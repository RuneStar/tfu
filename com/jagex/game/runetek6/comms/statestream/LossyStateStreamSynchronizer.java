package com.jagex.game.runetek6.comms.statestream;

import com.jagex.game.runetek6.comms.statestream.packetchannel.PacketChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
   private static final Logger logger = LoggerFactory.getLogger(LossyStateStreamSynchronizer.class);
   private final ByteBuffer buf = ByteBuffer.allocate(65536);
   private PacketChannel channel;
   private final List erroredStreams = new LinkedList();
   private long lastKeyframeSentTime = -1L;
   private long lastPacketReceivedTime = -1L;
   public int[] lastPackets = new int[10];
   private final List listeners = new LinkedList();
   private final Map masterStreams = new HashMap();
   private int nextPacketID = 0;
   private final List packetsToAcknowledge = new LinkedList();
   private final ByteBuffer pktbuf = ByteBuffer.allocate(512);
   int ptr;
   private Map sentPackets = new HashMap();
   private final Map slaveStreams = new HashMap();
   private final Map splitPackets = new HashMap();

   private boolean processIncomingDeltaSectionG(LossyStateStreamSynchronizer$SlaveStream var1, SyncPacket$DeltaSection var2, boolean var3) {
      State var4 = null;
      if (var2.sourceStateID != 0) {
         StateWrapper var5 = (StateWrapper)var1.acknowledgedStates.get(var2.sourceStateID);
         if (var5 == null) {
            return false;
         }

         var4 = var5.state;
      }

      State var10 = var1.stream.factory.applyDeltaPacket(var4, ByteBuffer.wrap(var2.deltaPacket));
      StateWrapper var6 = new StateWrapper(var10, var2.targetStateID, var2.timestamp, var2.filterGroup);
      if (!var3) {
         long var7 = System.currentTimeMillis() - var2.addedTime;
         if (var7 > 1000L) {
            logger.info("Received highly delayed state: {}ms", var7);
         }
      }

      boolean var11 = false;
      if (var2.timestamp == -1) {
         var1.stream.stateBelowLowest = var6;
      } else {
         var11 = var1.stream.putState(var6);
      }

      if (var11) {
         Iterator var8 = this.listeners.iterator();

         while(var8.hasNext()) {
            LossyStateStreamSynchronizerListener var9 = (LossyStateStreamSynchronizerListener)var8.next();
            var9.newStateReceived(this, var1.stream, var6, var2.addedTime);
         }
      }

      if (var3) {
         var1.acknowledgedStates.put(var6.uniqueID, var6);
      }

      return true;
   }

   public void setChannel(PacketChannel var1) {
      this.channel = var1;
   }

   public boolean streamAdded(LossyStateStream var1) {
      return this.masterStreams.containsKey(var1.id) || this.slaveStreams.containsKey(var1.id);
   }

   private void addOutgoingDeltas(SyncPacket var1, int var2, LossyStateStreamSynchronizer$MasterStream var3) {
      LossyStateStreamSynchronizer$StateWrapperWithTime var6;
      int var8;
      byte[] var9;
      for(Iterator var4 = var3.statesToSync.entrySet().iterator(); var4.hasNext(); var1.addDeltaSection(var6.state.getClass(), var2, var8, var6.state.uniqueID, var6.state.timestamp, var6.state.filterGroup, var9, var6.addedTime)) {
         Entry var5 = (Entry)var4.next();
         var6 = (LossyStateStreamSynchronizer$StateWrapperWithTime)var5.getValue();
         State var7 = null;
         var8 = 0;
         if (var3.lastAcknowledgedState != null) {
            var7 = var3.lastAcknowledgedState.state;
            var8 = var3.lastAcknowledgedState.uniqueID;
         }

         this.buf.clear();
         var3.stream.factory.generateDeltaPacket(var7, var6.state.state, this.buf);
         this.buf.flip();
         var9 = new byte[this.buf.remaining()];
         this.buf.get(var9);
         long var10 = System.currentTimeMillis() - var6.addedTime;
         if (var10 > 1000L) {
            logger.info("Transmitting state after delay of {}ms", var10);
         }
      }

      var3.statesToSync.clear();
      var3.statesToSyncByTimestamp.clear();
   }

   public void addMasterStream(LossyStateStream var1, byte var2, boolean var3) {
      boolean var4 = this.masterStreams.containsKey(var1.id) || this.slaveStreams.containsKey(var1.id);
      if (var4) {
         throw new IllegalArgumentException("This stream ID (" + var1.id + ") is already allocated on this synchronizer");
      } else {
         LossyStateStreamSynchronizer$MasterStream var5 = new LossyStateStreamSynchronizer$MasterStream(this, var1, var2, var3);
         var5.markAllStatesForSync();
         var5.resetPending = true;
         this.masterStreams.put(var1.id, var5);
         var1.synchronizers.add(this);
         Iterator var6 = this.listeners.iterator();

         while(var6.hasNext()) {
            LossyStateStreamSynchronizerListener var7 = (LossyStateStreamSynchronizerListener)var6.next();
            var7.streamAdded(this, var1, true);
         }

      }
   }

   public void removeStream(int var1) {
      if (this.masterStreams.containsKey(var1)) {
         LossyStateStream var2 = ((LossyStateStreamSynchronizer$MasterStream)this.masterStreams.get(var1)).stream;
         var2.synchronizers.remove(this);
         Iterator var3 = this.listeners.iterator();

         while(var3.hasNext()) {
            LossyStateStreamSynchronizerListener var4 = (LossyStateStreamSynchronizerListener)var3.next();
            var4.streamRemoved(this, var2);
         }
      }

      this.masterStreams.remove(var1);
      this.slaveStreams.remove(var1);
   }

   void stateAdded(LossyStateStream var1, StateWrapper var2) {
      LossyStateStreamSynchronizer$MasterStream var3 = (LossyStateStreamSynchronizer$MasterStream)this.masterStreams.get(var1.id);
      if (var3 != null) {
         var3.addStateToSync(var2);
      }
   }

   public void removeAllStreams() {
      Iterator var1 = this.masterStreams.entrySet().iterator();

      while(var1.hasNext()) {
         Entry var2 = (Entry)var1.next();
         ((LossyStateStreamSynchronizer$MasterStream)var2.getValue()).stream.synchronizers.remove(this);
      }

      this.masterStreams.clear();
      this.slaveStreams.clear();
   }

   private int getNextPacketID() {
      int var1 = this.nextPacketID;
      this.nextPacketID = PACKET_ID_WIDTH.sumIDs(this.nextPacketID, 1);
      return var1;
   }

   public LossyStateStream getStream(int var1) {
      if (this.masterStreams.containsKey(var1)) {
         return ((LossyStateStreamSynchronizer$MasterStream)this.masterStreams.get(var1)).stream;
      } else {
         return this.slaveStreams.containsKey(var1) ? ((LossyStateStreamSynchronizer$SlaveStream)this.slaveStreams.get(var1)).stream : null;
      }
   }

   public void processIncomingPackets() throws IOException {
      // $FF: Couldn't be decompiled
   }

   private boolean processIncomingDeltaSection(int var1, SyncPacket$DeltaSection var2, boolean var3) {
      LossyStateStreamSynchronizer$SlaveStream var4 = (LossyStateStreamSynchronizer$SlaveStream)this.slaveStreams.get(var1);
      return var4 == null ? false : this.processIncomingDeltaSectionG(var4, var2, var3);
   }

   private void processIncomingPacketAcknowledgeSection(SyncPacket$PacketAcknowledgeSection var1) {
      LossyStateStreamSynchronizer$SentPacket var2 = (LossyStateStreamSynchronizer$SentPacket)this.sentPackets.get(var1.packetID);
      if (var2 != null) {
         Map var3 = (Map)var2.packet.sections.get(SyncPacket$SectionType.DELTA);
         LossyStateStreamSynchronizer$MasterStream var7;
         if (var3 != null) {
            Iterator var4 = var3.keySet().iterator();

            label44:
            while(true) {
               List var6;
               do {
                  if (!var4.hasNext()) {
                     break label44;
                  }

                  Integer var5 = (Integer)var4.next();
                  var6 = (List)var3.get(var5);
                  var7 = (LossyStateStreamSynchronizer$MasterStream)this.masterStreams.get(var5);
               } while(var7 == null);

               Iterator var8 = var6.iterator();

               while(var8.hasNext()) {
                  SyncPacket$Section var9 = (SyncPacket$Section)var8.next();
                  SyncPacket$DeltaSection var10 = (SyncPacket$DeltaSection)var9;
                  var7.stateAcknowledged(var10.targetStateID);
               }

               var7.statesAwaitingAcknowledgement.clear();
            }
         }

         Map var11 = (Map)var2.packet.sections.get(SyncPacket$SectionType.RESET);
         if (var11 != null) {
            Iterator var12 = var11.keySet().iterator();

            while(var12.hasNext()) {
               Integer var13 = (Integer)var12.next();
               var7 = (LossyStateStreamSynchronizer$MasterStream)this.masterStreams.get(var13);
               if (var7 != null) {
                  var7.resetPending = false;
               }
            }
         }

         this.sentPackets.remove(var1.packetID);
      }
   }

   private void processIncomingErrorSection(int var1, SyncPacket$ErrorSection var2) {
      LossyStateStreamSynchronizer$MasterStream var3 = (LossyStateStreamSynchronizer$MasterStream)this.masterStreams.get(var1);
      if (var3 != null) {
         var3.lastAcknowledgedState = null;
      }

   }

   public void addSlaveStream(LossyStateStream var1) {
      boolean var2 = this.masterStreams.containsKey(var1.id) || this.slaveStreams.containsKey(var1.id);
      if (var2) {
         throw new IllegalArgumentException("This stream ID (" + var1.id + ") is already allocated on this synchronizer");
      } else if (var1 instanceof SourceLossyStateStream) {
         throw new IllegalArgumentException("Can't add a SourceLossyStateStream as a slave stream");
      } else {
         LossyStateStreamSynchronizer$SlaveStream var3 = new LossyStateStreamSynchronizer$SlaveStream(var1);
         this.slaveStreams.put(var1.id, var3);
         var1.reset();
         Iterator var4 = this.listeners.iterator();

         while(var4.hasNext()) {
            LossyStateStreamSynchronizerListener var5 = (LossyStateStreamSynchronizerListener)var4.next();
            var5.streamAdded(this, var1, false);
         }

      }
   }

   public void addMasterStream(LossyStateStream var1) {
      this.addMasterStream(var1, (byte)-1, true);
   }

   public void sendOutgoingPackets() throws IOException {
      if (this.channel != null) {
         if (this.lastPacketReceivedTime < 0L) {
            this.lastPacketReceivedTime = System.currentTimeMillis();
         }

         if (this.lastKeyframeSentTime < 0L) {
            this.lastKeyframeSentTime = System.currentTimeMillis();
         }

         Lb33.g(Lb33.SyncOutgoing);

         try {
            SyncPacket var1 = new SyncPacket();
            this.cleanupSentPacketCache();
            long var2 = System.currentTimeMillis();
            var1.keyframe = var2 - this.lastKeyframeSentTime > 200L;
            if (var1.keyframe) {
               this.lastKeyframeSentTime = var2;
            }

            Iterator var4 = this.masterStreams.entrySet().iterator();

            while(var4.hasNext()) {
               Entry var5 = (Entry)var4.next();
               int var6 = (Integer)var5.getKey();
               LossyStateStreamSynchronizer$MasterStream var7 = (LossyStateStreamSynchronizer$MasterStream)var5.getValue();
               if (var1.keyframe) {
                  if (var7.resetPending) {
                     var1.addResetSection(var6);
                  } else if (var7.sendKeyframes) {
                     this.addOutgoingKeyframeDelta(var1, var6, var7);
                  }
               } else if (!var7.resetPending) {
                  this.addOutgoingDeltas(var1, var6, var7);
               }
            }

            var4 = this.packetsToAcknowledge.iterator();

            int var12;
            while(var4.hasNext()) {
               var12 = (Integer)var4.next();
               var1.addPacketAcknowledgeSection(var12);
            }

            this.packetsToAcknowledge.clear();
            var4 = this.erroredStreams.iterator();

            while(var4.hasNext()) {
               var12 = (Integer)var4.next();
               var1.addErrorSection(var12);
            }

            this.erroredStreams.clear();
            if (var1.sections.isEmpty()) {
               if (System.currentTimeMillis() - this.lastPacketReceivedTime < 1000L) {
                  Lb33.d(Lb33.SyncOutgoing);
                  return;
               }

               var1.keyframe = true;
            }

            this.buf.clear();
            if (var1.generatePacket(this.buf)) {
               this.sendPacket(var1, false);
            } else {
               List var11 = var1.sizedSubpacketSplit(this.buf.capacity());
               Iterator var13 = var11.iterator();

               while(var13.hasNext()) {
                  SyncPacket var14 = (SyncPacket)var13.next();
                  this.sendPacket(var14, true);
               }
            }

            Lb33.d(Lb33.SyncOutgoing);
         } finally {
            Lb33.d(Lb33.SyncOutgoing);
         }
      }
   }

   private void cleanupSentPacketCache() {
      long var1 = System.currentTimeMillis();
      LinkedList var3 = new LinkedList();
      Iterator var4 = this.sentPackets.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var5 = (Entry)var4.next();
         if (var1 - ((LossyStateStreamSynchronizer$SentPacket)var5.getValue()).sentTime > 10000L) {
            var3.add(var5.getKey());
         }
      }

      var4 = var3.iterator();

      while(var4.hasNext()) {
         Integer var6 = (Integer)var4.next();
         this.sentPackets.remove(var6);
      }

   }

   public void addListener(LossyStateStreamSynchronizerListener var1) {
      if (!this.listeners.contains(var1)) {
         this.listeners.add(var1);
      }

   }

   private void sendPacket(SyncPacket var1, boolean var2) throws IOException {
      if (var2) {
         this.buf.clear();
         var1.generatePacket(this.buf);
      }

      int var3 = 512 - (PACKET_ID_WIDTH.bytes + 3);
      int var4 = var3 - 4;
      int var5 = 0;
      int var6 = this.getNextPacketID();
      this.lastPackets[this.ptr] = this.buf.position();
      this.ptr = (this.ptr + 1) % this.lastPackets.length;
      int var7 = this.buf.position();
      if (var7 > var3) {
         var3 -= 4;
         int var8 = var7 / var4;
         int var9 = var7 % var4;
         if (var9 > 0) {
            ++var8;
         }

         for(int var10 = 0; var10 < var8; ++var10) {
            this.pktbuf.clear();
            this.pktbuf.put((byte)(var1.keyframe ? 1 : 0));
            PACKET_ID_WIDTH.putID(var6, this.pktbuf);
            this.pktbuf.putShort((short)var8);
            this.pktbuf.putShort((short)var10);
            int var11 = var4;
            if (var10 == var8 - 1 && var9 > 0) {
               var11 = var9;
            }

            this.pktbuf.putShort((short)var11);
            int var12 = var10 * var4;
            this.buf.position(var12);
            this.buf.limit(var12 + var11);
            this.pktbuf.put(this.buf);
            this.pktbuf.flip();
            this.channel.write(this.pktbuf);
            ++var5;
         }
      } else {
         this.pktbuf.clear();
         this.pktbuf.put((byte)(var1.keyframe ? 1 : 0));
         PACKET_ID_WIDTH.putID(var6, this.pktbuf);
         this.pktbuf.putShort((short)0);
         this.buf.flip();
         this.pktbuf.put(this.buf);
         this.pktbuf.flip();
         this.channel.write(this.pktbuf);
         ++var5;
      }

      if (var1.keyframe) {
         this.sentPackets.put(var6, new LossyStateStreamSynchronizer$SentPacket(var1, System.currentTimeMillis()));
      }

      LossyStateStreamProfiler.sendingSyncPacket(var1, var5);
   }

   private void processIncomingResetSection(int var1, SyncPacket$ResetSection var2) {
      LossyStateStreamSynchronizer$SlaveStream var3 = (LossyStateStreamSynchronizer$SlaveStream)this.slaveStreams.get(var1);
      if (var3 != null) {
         var3.stream.reset();
      }

   }

   void streamReset(LossyStateStream var1) {
      LossyStateStreamSynchronizer$MasterStream var2 = (LossyStateStreamSynchronizer$MasterStream)this.masterStreams.get(var1.id);
      if (var2 != null) {
         var2.reset();
      }
   }

   public void removeStream(LossyStateStream var1) {
      this.removeStream(var1.id);
   }

   public void removeAllListeners() {
      this.listeners.clear();
   }

   private void addOutgoingKeyframeDelta(SyncPacket var1, int var2, LossyStateStreamSynchronizer$MasterStream var3) {
      State var4 = null;
      int var5 = 0;
      if (var3.lastAcknowledgedState != null) {
         var4 = var3.lastAcknowledgedState.state;
         var5 = var3.lastAcknowledgedState.uniqueID;
      }

      StateWrapper var6 = var3.stream.getKeyframeState(var3.filterGroup);
      if (var6 != null) {
         if (var3.lastAcknowledgedState == null || var6.uniqueID != var3.lastAcknowledgedState.uniqueID) {
            this.buf.clear();
            var3.stream.factory.generateDeltaPacket(var4, var6.state, this.buf);
            this.buf.flip();
            byte[] var7 = new byte[this.buf.remaining()];
            this.buf.get(var7);
            var1.addDeltaSection(var6.state.getClass(), var2, var5, var6.uniqueID, var6.timestamp, var6.filterGroup, var7, -1L);
            var3.statesAwaitingAcknowledgement.put(var6.uniqueID, var6);
         }
      }
   }

   private void maintainStateCaches() {
      Iterator var1 = this.slaveStreams.values().iterator();

      while(var1.hasNext()) {
         LossyStateStreamSynchronizer$SlaveStream var2 = (LossyStateStreamSynchronizer$SlaveStream)var1.next();
         var2.cleanupAcknowledgedStateCache();
      }

      long var6 = System.currentTimeMillis();
      LinkedList var3 = new LinkedList();
      Iterator var4 = this.splitPackets.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var5 = (Entry)var4.next();
         if (var6 - ((LossyStateStreamSynchronizer$SplitPacket)var5.getValue()).receiveTime > 10000L) {
            var3.add(var5.getKey());
         }
      }

      var4 = var3.iterator();

      while(var4.hasNext()) {
         Integer var7 = (Integer)var4.next();
         this.splitPackets.remove(var7);
      }

   }

   // $FF: synthetic method
   static List access$000(LossyStateStreamSynchronizer var0) {
      return var0.listeners;
   }

   static {
      PACKET_ID_WIDTH = CircularIDWidth.TWO_BYTES;
   }
}
