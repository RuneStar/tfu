/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import com.jagex.game.runetek6.comms.statestream.CircularIDWidth;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamProfiler;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer$1;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer$MasterStream;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer$SentPacket;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer$SlaveStream;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer$SplitPacket;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer$StateWrapperWithTime;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizerListener;
import com.jagex.game.runetek6.comms.statestream.SourceLossyStateStream;
import com.jagex.game.runetek6.comms.statestream.State;
import com.jagex.game.runetek6.comms.statestream.StateFactory;
import com.jagex.game.runetek6.comms.statestream.StateWrapper;
import com.jagex.game.runetek6.comms.statestream.SyncPacket;
import com.jagex.game.runetek6.comms.statestream.SyncPacket$DeltaSection;
import com.jagex.game.runetek6.comms.statestream.SyncPacket$ErrorSection;
import com.jagex.game.runetek6.comms.statestream.SyncPacket$PacketAcknowledgeSection;
import com.jagex.game.runetek6.comms.statestream.SyncPacket$ResetSection;
import com.jagex.game.runetek6.comms.statestream.SyncPacket$Section;
import com.jagex.game.runetek6.comms.statestream.SyncPacket$SectionType;
import com.jagex.game.runetek6.comms.statestream.packetchannel.PacketChannel;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Lb33;

public class LossyStateStreamSynchronizer {
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
    private long lastKeyframeSentTime = -1L;
    private long lastPacketReceivedTime = -1L;
    public int[] lastPackets;
    private final List listeners;
    private final Map masterStreams;
    private int nextPacketID = 0;
    private final List packetsToAcknowledge;
    private final ByteBuffer pktbuf;
    int ptr;
    private Map sentPackets;
    private final Map slaveStreams;
    private final Map splitPackets = new HashMap();

    private boolean processIncomingDeltaSectionG(LossyStateStreamSynchronizer$SlaveStream lossyStateStreamSynchronizer$SlaveStream, SyncPacket$DeltaSection syncPacket$DeltaSection, boolean bl) {
        long l;
        Object object;
        State state = null;
        if (syncPacket$DeltaSection.sourceStateID != 0) {
            object = (StateWrapper)lossyStateStreamSynchronizer$SlaveStream.acknowledgedStates.get(syncPacket$DeltaSection.sourceStateID);
            if (object == null) {
                return false;
            }
            state = ((StateWrapper)object).state;
        }
        object = lossyStateStreamSynchronizer$SlaveStream.stream.factory.applyDeltaPacket(state, ByteBuffer.wrap(syncPacket$DeltaSection.deltaPacket));
        StateWrapper stateWrapper = new StateWrapper((State)object, syncPacket$DeltaSection.targetStateID, syncPacket$DeltaSection.timestamp, syncPacket$DeltaSection.filterGroup);
        if (!bl && (l = System.currentTimeMillis() - syncPacket$DeltaSection.addedTime) > 1000L) {
            logger.info("Received highly delayed state: {}ms", l);
        }
        boolean bl2 = false;
        if (syncPacket$DeltaSection.timestamp == -1) {
            lossyStateStreamSynchronizer$SlaveStream.stream.stateBelowLowest = stateWrapper;
        } else {
            bl2 = lossyStateStreamSynchronizer$SlaveStream.stream.putState(stateWrapper);
        }
        if (bl2) {
            for (LossyStateStreamSynchronizerListener lossyStateStreamSynchronizerListener : this.listeners) {
                lossyStateStreamSynchronizerListener.newStateReceived(this, lossyStateStreamSynchronizer$SlaveStream.stream, stateWrapper, syncPacket$DeltaSection.addedTime);
            }
        }
        if (bl) {
            lossyStateStreamSynchronizer$SlaveStream.acknowledgedStates.put(stateWrapper.uniqueID, stateWrapper);
        }
        return true;
    }

    public void setChannel(PacketChannel packetChannel) {
        this.channel = packetChannel;
    }

    public boolean streamAdded(LossyStateStream lossyStateStream) {
        return this.masterStreams.containsKey(lossyStateStream.id) || this.slaveStreams.containsKey(lossyStateStream.id);
    }

    private void addOutgoingDeltas(SyncPacket syncPacket, int n, LossyStateStreamSynchronizer$MasterStream lossyStateStreamSynchronizer$MasterStream) {
        for (Map.Entry entry : lossyStateStreamSynchronizer$MasterStream.statesToSync.entrySet()) {
            LossyStateStreamSynchronizer$StateWrapperWithTime lossyStateStreamSynchronizer$StateWrapperWithTime = (LossyStateStreamSynchronizer$StateWrapperWithTime)entry.getValue();
            State state = null;
            int n2 = 0;
            if (lossyStateStreamSynchronizer$MasterStream.lastAcknowledgedState != null) {
                state = lossyStateStreamSynchronizer$MasterStream.lastAcknowledgedState.state;
                n2 = lossyStateStreamSynchronizer$MasterStream.lastAcknowledgedState.uniqueID;
            }
            this.buf.clear();
            lossyStateStreamSynchronizer$MasterStream.stream.factory.generateDeltaPacket(state, lossyStateStreamSynchronizer$StateWrapperWithTime.state.state, this.buf);
            this.buf.flip();
            byte[] arrby = new byte[this.buf.remaining()];
            this.buf.get(arrby);
            long l = System.currentTimeMillis() - lossyStateStreamSynchronizer$StateWrapperWithTime.addedTime;
            if (l > 1000L) {
                logger.info("Transmitting state after delay of {}ms", l);
            }
            syncPacket.addDeltaSection(lossyStateStreamSynchronizer$StateWrapperWithTime.state.getClass(), n, n2, lossyStateStreamSynchronizer$StateWrapperWithTime.state.uniqueID, lossyStateStreamSynchronizer$StateWrapperWithTime.state.timestamp, lossyStateStreamSynchronizer$StateWrapperWithTime.state.filterGroup, arrby, lossyStateStreamSynchronizer$StateWrapperWithTime.addedTime);
        }
        lossyStateStreamSynchronizer$MasterStream.statesToSync.clear();
        lossyStateStreamSynchronizer$MasterStream.statesToSyncByTimestamp.clear();
    }

    public void addMasterStream(LossyStateStream lossyStateStream, byte by, boolean bl) {
        boolean bl2;
        boolean bl3 = bl2 = this.masterStreams.containsKey(lossyStateStream.id) || this.slaveStreams.containsKey(lossyStateStream.id);
        if (bl2) {
            throw new IllegalArgumentException("This stream ID (" + lossyStateStream.id + ") is already allocated on this synchronizer");
        }
        LossyStateStreamSynchronizer$MasterStream lossyStateStreamSynchronizer$MasterStream = new LossyStateStreamSynchronizer$MasterStream(this, lossyStateStream, by, bl);
        lossyStateStreamSynchronizer$MasterStream.markAllStatesForSync();
        lossyStateStreamSynchronizer$MasterStream.resetPending = true;
        this.masterStreams.put(lossyStateStream.id, lossyStateStreamSynchronizer$MasterStream);
        lossyStateStream.synchronizers.add(this);
        for (LossyStateStreamSynchronizerListener lossyStateStreamSynchronizerListener : this.listeners) {
            lossyStateStreamSynchronizerListener.streamAdded(this, lossyStateStream, true);
        }
    }

    public void removeStream(int n) {
        if (this.masterStreams.containsKey(n)) {
            LossyStateStream lossyStateStream = ((LossyStateStreamSynchronizer$MasterStream)this.masterStreams.get((Object)Integer.valueOf((int)n))).stream;
            lossyStateStream.synchronizers.remove(this);
            for (LossyStateStreamSynchronizerListener lossyStateStreamSynchronizerListener : this.listeners) {
                lossyStateStreamSynchronizerListener.streamRemoved(this, lossyStateStream);
            }
        }
        this.masterStreams.remove(n);
        this.slaveStreams.remove(n);
    }

    void stateAdded(LossyStateStream lossyStateStream, StateWrapper stateWrapper) {
        LossyStateStreamSynchronizer$MasterStream lossyStateStreamSynchronizer$MasterStream = (LossyStateStreamSynchronizer$MasterStream)this.masterStreams.get(lossyStateStream.id);
        if (lossyStateStreamSynchronizer$MasterStream == null) {
            return;
        }
        lossyStateStreamSynchronizer$MasterStream.addStateToSync(stateWrapper);
    }

    public void removeAllStreams() {
        for (Map.Entry entry : this.masterStreams.entrySet()) {
            ((LossyStateStreamSynchronizer$MasterStream)entry.getValue()).stream.synchronizers.remove(this);
        }
        this.masterStreams.clear();
        this.slaveStreams.clear();
    }

    private int getNextPacketID() {
        int n = this.nextPacketID;
        this.nextPacketID = PACKET_ID_WIDTH.sumIDs(this.nextPacketID, 1);
        return n;
    }

    public LossyStateStream getStream(int n) {
        if (this.masterStreams.containsKey(n)) {
            return ((LossyStateStreamSynchronizer$MasterStream)this.masterStreams.get((Object)Integer.valueOf((int)n))).stream;
        }
        if (this.slaveStreams.containsKey(n)) {
            return ((LossyStateStreamSynchronizer$SlaveStream)this.slaveStreams.get((Object)Integer.valueOf((int)n))).stream;
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
            do {
                byte[] arrby;
                this.buf.clear();
                int n = this.channel.read(this.buf);
                if (n <= 0) {
                    if (System.currentTimeMillis() - this.lastPacketReceivedTime <= 20000L) break;
                    throw new IOException("Timed out while waiting for packets");
                }
                this.lastPacketReceivedTime = System.currentTimeMillis();
                this.buf.limit(n);
                this.buf.rewind();
                boolean bl = this.buf.get() == 1;
                int n2 = PACKET_ID_WIDTH.getID(this.buf);
                int n3 = this.buf.getShort() & 0xFFFF;
                if (n3 != 0) {
                    int n4 = this.buf.getShort() & 0xFFFF;
                    int n5 = this.buf.getShort() & 0xFFFF;
                    Object object = (LossyStateStreamSynchronizer$SplitPacket)this.splitPackets.get(n2);
                    if (object == null) {
                        object = new LossyStateStreamSynchronizer$SplitPacket(n3);
                        this.splitPackets.put(n2, object);
                    }
                    if (((LossyStateStreamSynchronizer$SplitPacket)object).payload[n4] == null) {
                        arrby = new byte[n5];
                        this.buf.get(arrby);
                        object.payload[n4] = arrby;
                    }
                    if (!((LossyStateStreamSynchronizer$SplitPacket)object).isComplete()) continue;
                    ((LossyStateStreamSynchronizer$SplitPacket)object).reassemble(this.buf);
                    this.splitPackets.remove(n2);
                }
                SyncPacket syncPacket = SyncPacket.parsePacket(this.buf);
                LossyStateStreamProfiler.receivedSyncPacket(syncPacket);
                for (Object object : syncPacket.sections.keySet()) {
                    arrby = (byte[])syncPacket.sections.get(object);
                    Iterator iterator = arrby.keySet().iterator();
                    while (iterator.hasNext()) {
                        int n6 = (Integer)iterator.next();
                        List list = (List)arrby.get(n6);
                        boolean bl2 = false;
                        for (SyncPacket$Section syncPacket$Section : list) {
                            switch (LossyStateStreamSynchronizer$1.$SwitchMap$com$jagex$game$runetek6$comms$statestream$SyncPacket$SectionType[((Enum)object).ordinal()]) {
                                case 1: {
                                    if (this.processIncomingDeltaSection(n6, (SyncPacket$DeltaSection)syncPacket$Section, bl)) break;
                                    bl2 = true;
                                    break;
                                }
                                case 2: {
                                    this.processIncomingPacketAcknowledgeSection((SyncPacket$PacketAcknowledgeSection)syncPacket$Section);
                                    break;
                                }
                                case 3: {
                                    this.processIncomingErrorSection(n6, (SyncPacket$ErrorSection)syncPacket$Section);
                                    break;
                                }
                                case 4: {
                                    this.processIncomingResetSection(n6, (SyncPacket$ResetSection)syncPacket$Section);
                                }
                            }
                        }
                        if (!bl2) continue;
                        this.erroredStreams.add(n6);
                    }
                }
                if (!bl) continue;
                this.packetsToAcknowledge.add(n2);
            } while (true);
            Lb33.d(Lb33.SyncIncoming);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.SyncIncoming);
            throw throwable;
        }
    }

    private boolean processIncomingDeltaSection(int n, SyncPacket$DeltaSection syncPacket$DeltaSection, boolean bl) {
        LossyStateStreamSynchronizer$SlaveStream lossyStateStreamSynchronizer$SlaveStream = (LossyStateStreamSynchronizer$SlaveStream)this.slaveStreams.get(n);
        if (lossyStateStreamSynchronizer$SlaveStream == null) {
            return false;
        }
        return this.processIncomingDeltaSectionG(lossyStateStreamSynchronizer$SlaveStream, syncPacket$DeltaSection, bl);
    }

    public LossyStateStreamSynchronizer() {
        this.sentPackets = new HashMap();
        this.masterStreams = new HashMap();
        this.slaveStreams = new HashMap();
        this.buf = ByteBuffer.allocate(65536);
        this.pktbuf = ByteBuffer.allocate(512);
        this.listeners = new LinkedList();
        this.packetsToAcknowledge = new LinkedList();
        this.erroredStreams = new LinkedList();
        this.lastPackets = new int[10];
    }

    private void processIncomingPacketAcknowledgeSection(SyncPacket$PacketAcknowledgeSection syncPacket$PacketAcknowledgeSection) {
        Object object;
        LossyStateStreamSynchronizer$MasterStream lossyStateStreamSynchronizer$MasterStream;
        LossyStateStreamSynchronizer$SentPacket lossyStateStreamSynchronizer$SentPacket = (LossyStateStreamSynchronizer$SentPacket)this.sentPackets.get(syncPacket$PacketAcknowledgeSection.packetID);
        if (lossyStateStreamSynchronizer$SentPacket == null) {
            return;
        }
        Map map = (Map)lossyStateStreamSynchronizer$SentPacket.packet.sections.get((Object)SyncPacket$SectionType.DELTA);
        if (map != null) {
            object = map.keySet().iterator();
            while (object.hasNext()) {
                Integer n = (Integer)object.next();
                Object object2 = (List)map.get(n);
                lossyStateStreamSynchronizer$MasterStream = (LossyStateStreamSynchronizer$MasterStream)this.masterStreams.get(n);
                if (lossyStateStreamSynchronizer$MasterStream == null) continue;
                Iterator iterator = object2.iterator();
                while (iterator.hasNext()) {
                    SyncPacket$Section syncPacket$Section = (SyncPacket$Section)iterator.next();
                    SyncPacket$DeltaSection syncPacket$DeltaSection = (SyncPacket$DeltaSection)syncPacket$Section;
                    lossyStateStreamSynchronizer$MasterStream.stateAcknowledged(syncPacket$DeltaSection.targetStateID);
                }
                lossyStateStreamSynchronizer$MasterStream.statesAwaitingAcknowledgement.clear();
            }
        }
        if ((object = (Map)lossyStateStreamSynchronizer$SentPacket.packet.sections.get((Object)SyncPacket$SectionType.RESET)) != null) {
            for (Object object2 : object.keySet()) {
                lossyStateStreamSynchronizer$MasterStream = (LossyStateStreamSynchronizer$MasterStream)this.masterStreams.get(object2);
                if (lossyStateStreamSynchronizer$MasterStream == null) continue;
                lossyStateStreamSynchronizer$MasterStream.resetPending = false;
            }
        }
        this.sentPackets.remove(syncPacket$PacketAcknowledgeSection.packetID);
    }

    private void processIncomingErrorSection(int n, SyncPacket$ErrorSection syncPacket$ErrorSection) {
        LossyStateStreamSynchronizer$MasterStream lossyStateStreamSynchronizer$MasterStream = (LossyStateStreamSynchronizer$MasterStream)this.masterStreams.get(n);
        if (lossyStateStreamSynchronizer$MasterStream != null) {
            lossyStateStreamSynchronizer$MasterStream.lastAcknowledgedState = null;
        }
    }

    public void addSlaveStream(LossyStateStream lossyStateStream) {
        boolean bl;
        boolean bl2 = bl = this.masterStreams.containsKey(lossyStateStream.id) || this.slaveStreams.containsKey(lossyStateStream.id);
        if (bl) {
            throw new IllegalArgumentException("This stream ID (" + lossyStateStream.id + ") is already allocated on this synchronizer");
        }
        if (lossyStateStream instanceof SourceLossyStateStream) {
            throw new IllegalArgumentException("Can't add a SourceLossyStateStream as a slave stream");
        }
        LossyStateStreamSynchronizer$SlaveStream lossyStateStreamSynchronizer$SlaveStream = new LossyStateStreamSynchronizer$SlaveStream(lossyStateStream);
        this.slaveStreams.put(lossyStateStream.id, lossyStateStreamSynchronizer$SlaveStream);
        lossyStateStream.reset();
        for (LossyStateStreamSynchronizerListener lossyStateStreamSynchronizerListener : this.listeners) {
            lossyStateStreamSynchronizerListener.streamAdded(this, lossyStateStream, false);
        }
    }

    public void addMasterStream(LossyStateStream lossyStateStream) {
        this.addMasterStream(lossyStateStream, (byte)-1, true);
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
            SyncPacket syncPacket = new SyncPacket();
            this.cleanupSentPacketCache();
            long l = System.currentTimeMillis();
            boolean bl = syncPacket.keyframe = l - this.lastKeyframeSentTime > 200L;
            if (syncPacket.keyframe) {
                this.lastKeyframeSentTime = l;
            }
            for (Map.Entry object2 : this.masterStreams.entrySet()) {
                int syncPacket2 = (Integer)object2.getKey();
                LossyStateStreamSynchronizer$MasterStream lossyStateStreamSynchronizer$MasterStream = (LossyStateStreamSynchronizer$MasterStream)object2.getValue();
                if (syncPacket.keyframe) {
                    if (lossyStateStreamSynchronizer$MasterStream.resetPending) {
                        syncPacket.addResetSection(syncPacket2);
                        continue;
                    }
                    if (!lossyStateStreamSynchronizer$MasterStream.sendKeyframes) continue;
                    this.addOutgoingKeyframeDelta(syncPacket, syncPacket2, lossyStateStreamSynchronizer$MasterStream);
                    continue;
                }
                if (lossyStateStreamSynchronizer$MasterStream.resetPending) continue;
                this.addOutgoingDeltas(syncPacket, syncPacket2, lossyStateStreamSynchronizer$MasterStream);
            }
            Object object = this.packetsToAcknowledge.iterator();
            while (object.hasNext()) {
                int n = (Integer)((Object)object.next());
                syncPacket.addPacketAcknowledgeSection(n);
            }
            this.packetsToAcknowledge.clear();
            object = this.erroredStreams.iterator();
            while (object.hasNext()) {
                int n = (Integer)((Object)object.next());
                syncPacket.addErrorSection(n);
            }
            this.erroredStreams.clear();
            if (syncPacket.sections.isEmpty()) {
                if (System.currentTimeMillis() - this.lastPacketReceivedTime < 1000L) {
                    Lb33.d(Lb33.SyncOutgoing);
                    return;
                }
                syncPacket.keyframe = true;
            }
            this.buf.clear();
            if (syncPacket.generatePacket(this.buf)) {
                this.sendPacket(syncPacket, false);
            } else {
                object = syncPacket.sizedSubpacketSplit(this.buf.capacity());
                Iterator iterator = object.iterator();
                while (iterator.hasNext()) {
                    SyncPacket syncPacket2 = (SyncPacket)iterator.next();
                    this.sendPacket(syncPacket2, true);
                }
            }
            Lb33.d(Lb33.SyncOutgoing);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.SyncOutgoing);
            throw throwable;
        }
    }

    private void cleanupSentPacketCache() {
        long l = System.currentTimeMillis();
        LinkedList linkedList = new LinkedList();
        for (Map.Entry object : this.sentPackets.entrySet()) {
            if (l - ((LossyStateStreamSynchronizer$SentPacket)object.getValue()).sentTime <= 10000L) continue;
            linkedList.add(object.getKey());
        }
        for (Integer n : linkedList) {
            this.sentPackets.remove(n);
        }
    }

    public void addListener(LossyStateStreamSynchronizerListener lossyStateStreamSynchronizerListener) {
        if (!this.listeners.contains(lossyStateStreamSynchronizerListener)) {
            this.listeners.add(lossyStateStreamSynchronizerListener);
        }
    }

    private void sendPacket(SyncPacket syncPacket, boolean bl) throws IOException {
        if (bl) {
            this.buf.clear();
            syncPacket.generatePacket(this.buf);
        }
        int n = 512 - (LossyStateStreamSynchronizer.PACKET_ID_WIDTH.bytes + 3);
        int n2 = n - 4;
        int n3 = 0;
        int n4 = this.getNextPacketID();
        this.lastPackets[this.ptr] = this.buf.position();
        this.ptr = (this.ptr + 1) % this.lastPackets.length;
        int n5 = this.buf.position();
        if (n5 > n) {
            n -= 4;
            int n6 = n5 / n2;
            int n7 = n5 % n2;
            if (n7 > 0) {
                ++n6;
            }
            for (int i = 0; i < n6; ++i) {
                this.pktbuf.clear();
                this.pktbuf.put((byte)(syncPacket.keyframe ? 1 : 0));
                PACKET_ID_WIDTH.putID(n4, this.pktbuf);
                this.pktbuf.putShort((short)n6);
                this.pktbuf.putShort((short)i);
                int n8 = n2;
                if (i == n6 - 1 && n7 > 0) {
                    n8 = n7;
                }
                this.pktbuf.putShort((short)n8);
                int n9 = i * n2;
                this.buf.position(n9);
                this.buf.limit(n9 + n8);
                this.pktbuf.put(this.buf);
                this.pktbuf.flip();
                this.channel.write(this.pktbuf);
                ++n3;
            }
        } else {
            this.pktbuf.clear();
            this.pktbuf.put((byte)(syncPacket.keyframe ? 1 : 0));
            PACKET_ID_WIDTH.putID(n4, this.pktbuf);
            this.pktbuf.putShort((short)0);
            this.buf.flip();
            this.pktbuf.put(this.buf);
            this.pktbuf.flip();
            this.channel.write(this.pktbuf);
            ++n3;
        }
        if (syncPacket.keyframe) {
            this.sentPackets.put(n4, new LossyStateStreamSynchronizer$SentPacket(syncPacket, System.currentTimeMillis()));
        }
        LossyStateStreamProfiler.sendingSyncPacket(syncPacket, n3);
    }

    private void processIncomingResetSection(int n, SyncPacket$ResetSection syncPacket$ResetSection) {
        LossyStateStreamSynchronizer$SlaveStream lossyStateStreamSynchronizer$SlaveStream = (LossyStateStreamSynchronizer$SlaveStream)this.slaveStreams.get(n);
        if (lossyStateStreamSynchronizer$SlaveStream != null) {
            lossyStateStreamSynchronizer$SlaveStream.stream.reset();
        }
    }

    void streamReset(LossyStateStream lossyStateStream) {
        LossyStateStreamSynchronizer$MasterStream lossyStateStreamSynchronizer$MasterStream = (LossyStateStreamSynchronizer$MasterStream)this.masterStreams.get(lossyStateStream.id);
        if (lossyStateStreamSynchronizer$MasterStream == null) {
            return;
        }
        lossyStateStreamSynchronizer$MasterStream.reset();
    }

    public void removeStream(LossyStateStream lossyStateStream) {
        this.removeStream(lossyStateStream.id);
    }

    public void removeAllListeners() {
        this.listeners.clear();
    }

    private void addOutgoingKeyframeDelta(SyncPacket syncPacket, int n, LossyStateStreamSynchronizer$MasterStream lossyStateStreamSynchronizer$MasterStream) {
        StateWrapper stateWrapper;
        State state = null;
        int n2 = 0;
        if (lossyStateStreamSynchronizer$MasterStream.lastAcknowledgedState != null) {
            state = lossyStateStreamSynchronizer$MasterStream.lastAcknowledgedState.state;
            n2 = lossyStateStreamSynchronizer$MasterStream.lastAcknowledgedState.uniqueID;
        }
        if ((stateWrapper = lossyStateStreamSynchronizer$MasterStream.stream.getKeyframeState(lossyStateStreamSynchronizer$MasterStream.filterGroup)) == null) {
            return;
        }
        if (lossyStateStreamSynchronizer$MasterStream.lastAcknowledgedState != null && stateWrapper.uniqueID == lossyStateStreamSynchronizer$MasterStream.lastAcknowledgedState.uniqueID) {
            return;
        }
        this.buf.clear();
        lossyStateStreamSynchronizer$MasterStream.stream.factory.generateDeltaPacket(state, stateWrapper.state, this.buf);
        this.buf.flip();
        byte[] arrby = new byte[this.buf.remaining()];
        this.buf.get(arrby);
        syncPacket.addDeltaSection(stateWrapper.state.getClass(), n, n2, stateWrapper.uniqueID, stateWrapper.timestamp, stateWrapper.filterGroup, arrby, -1L);
        lossyStateStreamSynchronizer$MasterStream.statesAwaitingAcknowledgement.put(stateWrapper.uniqueID, stateWrapper);
    }

    private void maintainStateCaches() {
        for (LossyStateStreamSynchronizer$SlaveStream lossyStateStreamSynchronizer$SlaveStream : this.slaveStreams.values()) {
            lossyStateStreamSynchronizer$SlaveStream.cleanupAcknowledgedStateCache();
        }
        long l = System.currentTimeMillis();
        LinkedList linkedList = new LinkedList();
        for (Map.Entry object : this.splitPackets.entrySet()) {
            if (l - ((LossyStateStreamSynchronizer$SplitPacket)object.getValue()).receiveTime <= 10000L) continue;
            linkedList.add(object.getKey());
        }
        for (Integer n : linkedList) {
            this.splitPackets.remove(n);
        }
    }

    static /* synthetic */ List access$000(LossyStateStreamSynchronizer lossyStateStreamSynchronizer) {
        return lossyStateStreamSynchronizer.listeners;
    }

    static {
        logger = LoggerFactory.getLogger(LossyStateStreamSynchronizer.class);
        PACKET_ID_WIDTH = CircularIDWidth.TWO_BYTES;
    }
}

