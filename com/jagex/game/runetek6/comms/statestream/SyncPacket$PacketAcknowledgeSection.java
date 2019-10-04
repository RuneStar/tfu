package com.jagex.game.runetek6.comms.statestream;

import java.nio.ByteBuffer;

class SyncPacket$PacketAcknowledgeSection extends SyncPacket$Section {
   public final int packetID;

   public String toStringForDebug() {
      return this.toString();
   }

   public void writeBody(ByteBuffer var1) {
      LossyStateStreamSynchronizer.PACKET_ID_WIDTH.putID(this.packetID, var1);
   }

   SyncPacket$PacketAcknowledgeSection(ByteBuffer var1) {
      this.packetID = LossyStateStreamSynchronizer.PACKET_ID_WIDTH.getID(var1);
   }

   public int getBodySize() {
      return LossyStateStreamSynchronizer.PACKET_ID_WIDTH.bytes;
   }

   public String toString() {
      return "PACKET_ACKNOWLEDGE: " + this.packetID;
   }

   public int compareTo(SyncPacket$PacketAcknowledgeSection var1) {
      return 0;
   }

   public SyncPacket$SectionType getType() {
      return SyncPacket$SectionType.PACKET_ACKNOWLEDGE;
   }

   SyncPacket$PacketAcknowledgeSection(int var1) {
      this.packetID = var1;
   }
}
