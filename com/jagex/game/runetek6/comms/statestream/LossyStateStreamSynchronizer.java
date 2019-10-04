// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

import org.slf4j.LoggerFactory;
import java.util.LinkedList;
import java.util.HashMap;
import java.io.IOException;
import tfu.Lb33;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import com.jagex.game.runetek6.comms.statestream.packetchannel.PacketChannel;
import java.nio.ByteBuffer;
import org.slf4j.Logger;

public class LossyStateStreamSynchronizer
{
    private static final long ERROR_TIMEOUT = 20000L;
    private static final long KEYFRAME_INTERVAL = 200L;
    private static final int MIN_SLAVE_STATE_HOLDING = 5;
    static final CircularIDWidth PACKET_ID_WIDTH;
    private static final long SEND_PING_TIMEOUT = 1000L;
    private static final long SENT_PACKET_TIMEOUT = 10000L;
    private static final int TARGET_PACKET_SIZE = 512;
    private static final Logger logger;
    private final ByteBuffer buf;
    private PacketChannel channel;
    private final List erroredStreams;
    private long lastKeyframeSentTime;
    private long lastPacketReceivedTime;
    public int[] lastPackets;
    private final List listeners;
    private final Map masterStreams;
    private int nextPacketID;
    private final List packetsToAcknowledge;
    private final ByteBuffer pktbuf;
    int ptr;
    private Map sentPackets;
    private final Map slaveStreams;
    private final Map splitPackets;
    
    private boolean processIncomingDeltaSectionG(final LossyStateStreamSynchronizer$SlaveStream lossyStateStreamSynchronizer$SlaveStream, final SyncPacket$DeltaSection syncPacket$DeltaSection, final boolean b) {
        State state = null;
        if (syncPacket$DeltaSection.sourceStateID != 0) {
            final StateWrapper stateWrapper = lossyStateStreamSynchronizer$SlaveStream.acknowledgedStates.get(syncPacket$DeltaSection.sourceStateID);
            if (stateWrapper == null) {
                return false;
            }
            state = stateWrapper.state;
        }
        final StateWrapper stateBelowLowest = new StateWrapper(lossyStateStreamSynchronizer$SlaveStream.stream.factory.applyDeltaPacket(state, ByteBuffer.wrap(syncPacket$DeltaSection.deltaPacket)), syncPacket$DeltaSection.targetStateID, syncPacket$DeltaSection.timestamp, syncPacket$DeltaSection.filterGroup);
        if (!b) {
            final long l = System.currentTimeMillis() - syncPacket$DeltaSection.addedTime;
            if (l > 1000L) {
                LossyStateStreamSynchronizer.logger.info("Received highly delayed state: {}ms", l);
            }
        }
        boolean putState = false;
        if (syncPacket$DeltaSection.timestamp == -1) {
            lossyStateStreamSynchronizer$SlaveStream.stream.stateBelowLowest = stateBelowLowest;
        }
        else {
            putState = lossyStateStreamSynchronizer$SlaveStream.stream.putState(stateBelowLowest);
        }
        if (putState) {
            final Iterator<LossyStateStreamSynchronizerListener> iterator = this.listeners.iterator();
            while (iterator.hasNext()) {
                iterator.next().newStateReceived(this, lossyStateStreamSynchronizer$SlaveStream.stream, stateBelowLowest, syncPacket$DeltaSection.addedTime);
            }
        }
        if (b) {
            lossyStateStreamSynchronizer$SlaveStream.acknowledgedStates.put(stateBelowLowest.uniqueID, stateBelowLowest);
        }
        return true;
    }
    
    public void setChannel(final PacketChannel channel) {
        this.channel = channel;
    }
    
    public boolean streamAdded(final LossyStateStream lossyStateStream) {
        return this.masterStreams.containsKey(lossyStateStream.id) || this.slaveStreams.containsKey(lossyStateStream.id);
    }
    
    private void addOutgoingDeltas(final SyncPacket syncPacket, final int n, final LossyStateStreamSynchronizer$MasterStream lossyStateStreamSynchronizer$MasterStream) {
        final Iterator<Map.Entry<K, LossyStateStreamSynchronizer$StateWrapperWithTime>> iterator = lossyStateStreamSynchronizer$MasterStream.statesToSync.entrySet().iterator();
        while (iterator.hasNext()) {
            final LossyStateStreamSynchronizer$StateWrapperWithTime lossyStateStreamSynchronizer$StateWrapperWithTime = iterator.next().getValue();
            State state = null;
            int uniqueID = 0;
            if (lossyStateStreamSynchronizer$MasterStream.lastAcknowledgedState != null) {
                state = lossyStateStreamSynchronizer$MasterStream.lastAcknowledgedState.state;
                uniqueID = lossyStateStreamSynchronizer$MasterStream.lastAcknowledgedState.uniqueID;
            }
            this.buf.clear();
            lossyStateStreamSynchronizer$MasterStream.stream.factory.generateDeltaPacket(state, lossyStateStreamSynchronizer$StateWrapperWithTime.state.state, this.buf);
            this.buf.flip();
            final byte[] dst = new byte[this.buf.remaining()];
            this.buf.get(dst);
            final long l = System.currentTimeMillis() - lossyStateStreamSynchronizer$StateWrapperWithTime.addedTime;
            if (l > 1000L) {
                LossyStateStreamSynchronizer.logger.info("Transmitting state after delay of {}ms", l);
            }
            syncPacket.addDeltaSection(lossyStateStreamSynchronizer$StateWrapperWithTime.state.getClass(), n, uniqueID, lossyStateStreamSynchronizer$StateWrapperWithTime.state.uniqueID, lossyStateStreamSynchronizer$StateWrapperWithTime.state.timestamp, lossyStateStreamSynchronizer$StateWrapperWithTime.state.filterGroup, dst, lossyStateStreamSynchronizer$StateWrapperWithTime.addedTime);
        }
        lossyStateStreamSynchronizer$MasterStream.statesToSync.clear();
        lossyStateStreamSynchronizer$MasterStream.statesToSyncByTimestamp.clear();
    }
    
    public void addMasterStream(final LossyStateStream lossyStateStream, final byte b, final boolean b2) {
        if (this.masterStreams.containsKey(lossyStateStream.id) || this.slaveStreams.containsKey(lossyStateStream.id)) {
            throw new IllegalArgumentException("This stream ID (" + lossyStateStream.id + ") is already allocated on this synchronizer");
        }
        final LossyStateStreamSynchronizer$MasterStream lossyStateStreamSynchronizer$MasterStream = new LossyStateStreamSynchronizer$MasterStream(this, lossyStateStream, b, b2);
        lossyStateStreamSynchronizer$MasterStream.markAllStatesForSync();
        lossyStateStreamSynchronizer$MasterStream.resetPending = true;
        this.masterStreams.put(lossyStateStream.id, lossyStateStreamSynchronizer$MasterStream);
        lossyStateStream.synchronizers.add(this);
        final Iterator<LossyStateStreamSynchronizerListener> iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().streamAdded(this, lossyStateStream, true);
        }
    }
    
    public void removeStream(final int n) {
        if (this.masterStreams.containsKey(n)) {
            final LossyStateStream stream = this.masterStreams.get(n).stream;
            stream.synchronizers.remove(this);
            final Iterator<LossyStateStreamSynchronizerListener> iterator = this.listeners.iterator();
            while (iterator.hasNext()) {
                iterator.next().streamRemoved(this, stream);
            }
        }
        this.masterStreams.remove(n);
        this.slaveStreams.remove(n);
    }
    
    void stateAdded(final LossyStateStream lossyStateStream, final StateWrapper stateWrapper) {
        final LossyStateStreamSynchronizer$MasterStream lossyStateStreamSynchronizer$MasterStream = this.masterStreams.get(lossyStateStream.id);
        if (lossyStateStreamSynchronizer$MasterStream == null) {
            return;
        }
        lossyStateStreamSynchronizer$MasterStream.addStateToSync(stateWrapper);
    }
    
    public void removeAllStreams() {
        final Iterator<Map.Entry<K, LossyStateStreamSynchronizer$MasterStream>> iterator = this.masterStreams.entrySet().iterator();
        while (iterator.hasNext()) {
            iterator.next().getValue().stream.synchronizers.remove(this);
        }
        this.masterStreams.clear();
        this.slaveStreams.clear();
    }
    
    private int getNextPacketID() {
        final int nextPacketID = this.nextPacketID;
        this.nextPacketID = LossyStateStreamSynchronizer.PACKET_ID_WIDTH.sumIDs(this.nextPacketID, 1);
        return nextPacketID;
    }
    
    public LossyStateStream getStream(final int n) {
        if (this.masterStreams.containsKey(n)) {
            return this.masterStreams.get(n).stream;
        }
        if (this.slaveStreams.containsKey(n)) {
            return this.slaveStreams.get(n).stream;
        }
        return null;
    }
    
    public void processIncomingPackets() throws IOException {
        if (this.channel == null) {
            return;
        }
        if (this.lastPacketReceivedTime < 0L) {
            this.lastPacketReceivedTime = System.currentTimeMillis();
        }
        Lb33.g(Lb33.SyncIncoming);
        try {
            this.maintainStateCaches();
            while (true) {
                this.buf.clear();
                final int read = this.channel.read(this.buf);
                if (read <= 0) {
                    break;
                }
                this.lastPacketReceivedTime = System.currentTimeMillis();
                this.buf.limit(read);
                this.buf.rewind();
                final boolean b = this.buf.get() == 1;
                final int id = LossyStateStreamSynchronizer.PACKET_ID_WIDTH.getID(this.buf);
                final int n = this.buf.getShort() & 0xFFFF;
                if (n != 0) {
                    final int n2 = this.buf.getShort() & 0xFFFF;
                    final int n3 = this.buf.getShort() & 0xFFFF;
                    LossyStateStreamSynchronizer$SplitPacket lossyStateStreamSynchronizer$SplitPacket = this.splitPackets.get(id);
                    if (lossyStateStreamSynchronizer$SplitPacket == null) {
                        lossyStateStreamSynchronizer$SplitPacket = new LossyStateStreamSynchronizer$SplitPacket(n);
                        this.splitPackets.put(id, lossyStateStreamSynchronizer$SplitPacket);
                    }
                    if (lossyStateStreamSynchronizer$SplitPacket.payload[n2] == null) {
                        final byte[] dst = new byte[n3];
                        this.buf.get(dst);
                        lossyStateStreamSynchronizer$SplitPacket.payload[n2] = dst;
                    }
                    if (!lossyStateStreamSynchronizer$SplitPacket.isComplete()) {
                        continue;
                    }
                    lossyStateStreamSynchronizer$SplitPacket.reassemble(this.buf);
                    this.splitPackets.remove(id);
                }
                final SyncPacket packet = SyncPacket.parsePacket(this.buf);
                LossyStateStreamProfiler.receivedSyncPacket(packet);
                for (final SyncPacket$SectionType syncPacket$SectionType : packet.sections.keySet()) {
                    final Map<Integer, Map<Integer, Map<Integer, Map>>> map = packet.sections.get(syncPacket$SectionType);
                    for (final int intValue : map.keySet()) {
                        final List list = (List)map.get(intValue);
                        boolean b2 = false;
                        for (final SyncPacket$Section syncPacket$Section : list) {
                            switch (LossyStateStreamSynchronizer$1.$SwitchMap$com$jagex$game$runetek6$comms$statestream$SyncPacket$SectionType[syncPacket$SectionType.ordinal()]) {
                                case 1: {
                                    if (!this.processIncomingDeltaSection(intValue, (SyncPacket$DeltaSection)syncPacket$Section, b)) {
                                        b2 = true;
                                        continue;
                                    }
                                    continue;
                                }
                                case 2: {
                                    this.processIncomingPacketAcknowledgeSection((SyncPacket$PacketAcknowledgeSection)syncPacket$Section);
                                    continue;
                                }
                                case 3: {
                                    this.processIncomingErrorSection(intValue, (SyncPacket$ErrorSection)syncPacket$Section);
                                    continue;
                                }
                                case 4: {
                                    this.processIncomingResetSection(intValue, (SyncPacket$ResetSection)syncPacket$Section);
                                    continue;
                                }
                            }
                        }
                        if (b2) {
                            this.erroredStreams.add(intValue);
                        }
                    }
                }
                if (!b) {
                    continue;
                }
                this.packetsToAcknowledge.add(id);
            }
            if (System.currentTimeMillis() - this.lastPacketReceivedTime > 20000L) {
                throw new IOException("Timed out while waiting for packets");
            }
        }
        finally {
            Lb33.d(Lb33.SyncIncoming);
        }
    }
    
    private boolean processIncomingDeltaSection(final int i, final SyncPacket$DeltaSection syncPacket$DeltaSection, final boolean b) {
        final LossyStateStreamSynchronizer$SlaveStream lossyStateStreamSynchronizer$SlaveStream = this.slaveStreams.get(i);
        return lossyStateStreamSynchronizer$SlaveStream != null && this.processIncomingDeltaSectionG(lossyStateStreamSynchronizer$SlaveStream, syncPacket$DeltaSection, b);
    }
    
    public LossyStateStreamSynchronizer() {
        this.nextPacketID = 0;
        this.splitPackets = new HashMap();
        this.sentPackets = new HashMap();
        this.masterStreams = new HashMap();
        this.slaveStreams = new HashMap();
        this.buf = ByteBuffer.allocate(65536);
        this.pktbuf = ByteBuffer.allocate(512);
        this.lastPacketReceivedTime = -1L;
        this.lastKeyframeSentTime = -1L;
        this.listeners = new LinkedList();
        this.packetsToAcknowledge = new LinkedList();
        this.erroredStreams = new LinkedList();
        this.lastPackets = new int[10];
    }
    
    private void processIncomingPacketAcknowledgeSection(final SyncPacket$PacketAcknowledgeSection syncPacket$PacketAcknowledgeSection) {
        final LossyStateStreamSynchronizer$SentPacket lossyStateStreamSynchronizer$SentPacket = this.sentPackets.get(syncPacket$PacketAcknowledgeSection.packetID);
        if (lossyStateStreamSynchronizer$SentPacket == null) {
            return;
        }
        final Map<Integer, Map<Integer, Map<Integer, Map>>> map = lossyStateStreamSynchronizer$SentPacket.packet.sections.get(SyncPacket$SectionType.DELTA);
        if (map != null) {
            for (final Integer n : map.keySet()) {
                final List<SyncPacket$Section> list = (List<SyncPacket$Section>)map.get(n);
                final LossyStateStreamSynchronizer$MasterStream lossyStateStreamSynchronizer$MasterStream = this.masterStreams.get(n);
                if (lossyStateStreamSynchronizer$MasterStream == null) {
                    continue;
                }
                final Iterator<SyncPacket$Section> iterator2 = list.iterator();
                while (iterator2.hasNext()) {
                    lossyStateStreamSynchronizer$MasterStream.stateAcknowledged(((SyncPacket$DeltaSection)iterator2.next()).targetStateID);
                }
                lossyStateStreamSynchronizer$MasterStream.statesAwaitingAcknowledgement.clear();
            }
        }
        final Map<Integer, Map<Integer, Map<Integer, Map>>> map2 = lossyStateStreamSynchronizer$SentPacket.packet.sections.get(SyncPacket$SectionType.RESET);
        if (map2 != null) {
            final Iterator<Integer> iterator3 = map2.keySet().iterator();
            while (iterator3.hasNext()) {
                final LossyStateStreamSynchronizer$MasterStream lossyStateStreamSynchronizer$MasterStream2 = this.masterStreams.get(iterator3.next());
                if (lossyStateStreamSynchronizer$MasterStream2 == null) {
                    continue;
                }
                lossyStateStreamSynchronizer$MasterStream2.resetPending = false;
            }
        }
        this.sentPackets.remove(syncPacket$PacketAcknowledgeSection.packetID);
    }
    
    private void processIncomingErrorSection(final int i, final SyncPacket$ErrorSection syncPacket$ErrorSection) {
        final LossyStateStreamSynchronizer$MasterStream lossyStateStreamSynchronizer$MasterStream = this.masterStreams.get(i);
        if (lossyStateStreamSynchronizer$MasterStream != null) {
            lossyStateStreamSynchronizer$MasterStream.lastAcknowledgedState = null;
        }
    }
    
    public void addSlaveStream(final LossyStateStream lossyStateStream) {
        if (this.masterStreams.containsKey(lossyStateStream.id) || this.slaveStreams.containsKey(lossyStateStream.id)) {
            throw new IllegalArgumentException("This stream ID (" + lossyStateStream.id + ") is already allocated on this synchronizer");
        }
        if (lossyStateStream instanceof SourceLossyStateStream) {
            throw new IllegalArgumentException("Can't add a SourceLossyStateStream as a slave stream");
        }
        this.slaveStreams.put(lossyStateStream.id, new LossyStateStreamSynchronizer$SlaveStream(lossyStateStream));
        lossyStateStream.reset();
        final Iterator<LossyStateStreamSynchronizerListener> iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().streamAdded(this, lossyStateStream, false);
        }
    }
    
    public void addMasterStream(final LossyStateStream lossyStateStream) {
        this.addMasterStream(lossyStateStream, (byte)(-1), true);
    }
    
    public void sendOutgoingPackets() throws IOException {
        if (this.channel == null) {
            return;
        }
        if (this.lastPacketReceivedTime < 0L) {
            this.lastPacketReceivedTime = System.currentTimeMillis();
        }
        if (this.lastKeyframeSentTime < 0L) {
            this.lastKeyframeSentTime = System.currentTimeMillis();
        }
        Lb33.g(Lb33.SyncOutgoing);
        try {
            final SyncPacket syncPacket = new SyncPacket();
            this.cleanupSentPacketCache();
            final long currentTimeMillis = System.currentTimeMillis();
            syncPacket.keyframe = (currentTimeMillis - this.lastKeyframeSentTime > 200L);
            if (syncPacket.keyframe) {
                this.lastKeyframeSentTime = currentTimeMillis;
            }
            for (final Map.Entry<Integer, V> entry : this.masterStreams.entrySet()) {
                final int intValue = entry.getKey();
                final LossyStateStreamSynchronizer$MasterStream lossyStateStreamSynchronizer$MasterStream = (LossyStateStreamSynchronizer$MasterStream)entry.getValue();
                if (syncPacket.keyframe) {
                    if (lossyStateStreamSynchronizer$MasterStream.resetPending) {
                        syncPacket.addResetSection(intValue);
                    }
                    else {
                        if (!lossyStateStreamSynchronizer$MasterStream.sendKeyframes) {
                            continue;
                        }
                        this.addOutgoingKeyframeDelta(syncPacket, intValue, lossyStateStreamSynchronizer$MasterStream);
                    }
                }
                else {
                    if (lossyStateStreamSynchronizer$MasterStream.resetPending) {
                        continue;
                    }
                    this.addOutgoingDeltas(syncPacket, intValue, lossyStateStreamSynchronizer$MasterStream);
                }
            }
            final Iterator<Integer> iterator2 = this.packetsToAcknowledge.iterator();
            while (iterator2.hasNext()) {
                syncPacket.addPacketAcknowledgeSection(iterator2.next());
            }
            this.packetsToAcknowledge.clear();
            final Iterator<Integer> iterator3 = this.erroredStreams.iterator();
            while (iterator3.hasNext()) {
                syncPacket.addErrorSection(iterator3.next());
            }
            this.erroredStreams.clear();
            if (syncPacket.sections.isEmpty()) {
                if (System.currentTimeMillis() - this.lastPacketReceivedTime < 1000L) {
                    return;
                }
                syncPacket.keyframe = true;
            }
            this.buf.clear();
            if (syncPacket.generatePacket(this.buf)) {
                this.sendPacket(syncPacket, false);
            }
            else {
                final Iterator iterator4 = syncPacket.sizedSubpacketSplit(this.buf.capacity()).iterator();
                while (iterator4.hasNext()) {
                    this.sendPacket(iterator4.next(), true);
                }
            }
        }
        finally {
            Lb33.d(Lb33.SyncOutgoing);
        }
    }
    
    private void cleanupSentPacketCache() {
        final long currentTimeMillis = System.currentTimeMillis();
        final LinkedList<Integer> list = (LinkedList<Integer>)new LinkedList<Object>();
        for (final Map.Entry<K, LossyStateStreamSynchronizer$SentPacket> entry : this.sentPackets.entrySet()) {
            if (currentTimeMillis - entry.getValue().sentTime > 10000L) {
                list.add(entry.getKey());
            }
        }
        final Iterator<Object> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            this.sentPackets.remove(iterator2.next());
        }
    }
    
    public void addListener(final LossyStateStreamSynchronizerListener lossyStateStreamSynchronizerListener) {
        if (!this.listeners.contains(lossyStateStreamSynchronizerListener)) {
            this.listeners.add(lossyStateStreamSynchronizerListener);
        }
    }
    
    private void sendPacket(final SyncPacket syncPacket, final boolean b) throws IOException {
        if (b) {
            this.buf.clear();
            syncPacket.generatePacket(this.buf);
        }
        int n = 512 - (LossyStateStreamSynchronizer.PACKET_ID_WIDTH.bytes + 3);
        final int n2 = n - 4;
        int n3 = 0;
        final int nextPacketID = this.getNextPacketID();
        this.lastPackets[this.ptr] = this.buf.position();
        this.ptr = (this.ptr + 1) % this.lastPackets.length;
        final int position = this.buf.position();
        if (position > n) {
            n -= 4;
            int n4 = position / n2;
            final int n5 = position % n2;
            if (n5 > 0) {
                ++n4;
            }
            for (int i = 0; i < n4; ++i) {
                this.pktbuf.clear();
                this.pktbuf.put((byte)(syncPacket.keyframe ? 1 : 0));
                LossyStateStreamSynchronizer.PACKET_ID_WIDTH.putID(nextPacketID, this.pktbuf);
                this.pktbuf.putShort((short)n4);
                this.pktbuf.putShort((short)i);
                int n6 = n2;
                if (i == n4 - 1 && n5 > 0) {
                    n6 = n5;
                }
                this.pktbuf.putShort((short)n6);
                final int n7 = i * n2;
                this.buf.position(n7);
                this.buf.limit(n7 + n6);
                this.pktbuf.put(this.buf);
                this.pktbuf.flip();
                this.channel.write(this.pktbuf);
                ++n3;
            }
        }
        else {
            this.pktbuf.clear();
            this.pktbuf.put((byte)(syncPacket.keyframe ? 1 : 0));
            LossyStateStreamSynchronizer.PACKET_ID_WIDTH.putID(nextPacketID, this.pktbuf);
            this.pktbuf.putShort((short)0);
            this.buf.flip();
            this.pktbuf.put(this.buf);
            this.pktbuf.flip();
            this.channel.write(this.pktbuf);
            ++n3;
        }
        if (syncPacket.keyframe) {
            this.sentPackets.put(nextPacketID, new LossyStateStreamSynchronizer$SentPacket(syncPacket, System.currentTimeMillis()));
        }
        LossyStateStreamProfiler.sendingSyncPacket(syncPacket, n3);
    }
    
    private void processIncomingResetSection(final int i, final SyncPacket$ResetSection syncPacket$ResetSection) {
        final LossyStateStreamSynchronizer$SlaveStream lossyStateStreamSynchronizer$SlaveStream = this.slaveStreams.get(i);
        if (lossyStateStreamSynchronizer$SlaveStream != null) {
            lossyStateStreamSynchronizer$SlaveStream.stream.reset();
        }
    }
    
    void streamReset(final LossyStateStream lossyStateStream) {
        final LossyStateStreamSynchronizer$MasterStream lossyStateStreamSynchronizer$MasterStream = this.masterStreams.get(lossyStateStream.id);
        if (lossyStateStreamSynchronizer$MasterStream == null) {
            return;
        }
        lossyStateStreamSynchronizer$MasterStream.reset();
    }
    
    public void removeStream(final LossyStateStream lossyStateStream) {
        this.removeStream(lossyStateStream.id);
    }
    
    public void removeAllListeners() {
        this.listeners.clear();
    }
    
    private void addOutgoingKeyframeDelta(final SyncPacket syncPacket, final int n, final LossyStateStreamSynchronizer$MasterStream lossyStateStreamSynchronizer$MasterStream) {
        State state = null;
        int uniqueID = 0;
        if (lossyStateStreamSynchronizer$MasterStream.lastAcknowledgedState != null) {
            state = lossyStateStreamSynchronizer$MasterStream.lastAcknowledgedState.state;
            uniqueID = lossyStateStreamSynchronizer$MasterStream.lastAcknowledgedState.uniqueID;
        }
        final StateWrapper keyframeState = lossyStateStreamSynchronizer$MasterStream.stream.getKeyframeState(lossyStateStreamSynchronizer$MasterStream.filterGroup);
        if (keyframeState == null) {
            return;
        }
        if (lossyStateStreamSynchronizer$MasterStream.lastAcknowledgedState != null && keyframeState.uniqueID == lossyStateStreamSynchronizer$MasterStream.lastAcknowledgedState.uniqueID) {
            return;
        }
        this.buf.clear();
        lossyStateStreamSynchronizer$MasterStream.stream.factory.generateDeltaPacket(state, keyframeState.state, this.buf);
        this.buf.flip();
        final byte[] dst = new byte[this.buf.remaining()];
        this.buf.get(dst);
        syncPacket.addDeltaSection(keyframeState.state.getClass(), n, uniqueID, keyframeState.uniqueID, keyframeState.timestamp, keyframeState.filterGroup, dst, -1L);
        lossyStateStreamSynchronizer$MasterStream.statesAwaitingAcknowledgement.put(keyframeState.uniqueID, keyframeState);
    }
    
    private void maintainStateCaches() {
        final Iterator<LossyStateStreamSynchronizer$SlaveStream> iterator = this.slaveStreams.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().cleanupAcknowledgedStateCache();
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final LinkedList<Integer> list = (LinkedList<Integer>)new LinkedList<Object>();
        for (final Map.Entry<K, LossyStateStreamSynchronizer$SplitPacket> entry : this.splitPackets.entrySet()) {
            if (currentTimeMillis - entry.getValue().receiveTime > 10000L) {
                list.add(entry.getKey());
            }
        }
        final Iterator<Object> iterator3 = list.iterator();
        while (iterator3.hasNext()) {
            this.splitPackets.remove(iterator3.next());
        }
    }
    
    static {
        logger = LoggerFactory.getLogger(LossyStateStreamSynchronizer.class);
        PACKET_ID_WIDTH = CircularIDWidth.TWO_BYTES;
    }
}
