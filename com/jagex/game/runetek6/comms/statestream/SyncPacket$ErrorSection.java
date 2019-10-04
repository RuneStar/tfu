package com.jagex.game.runetek6.comms.statestream;

import java.nio.ByteBuffer;

class SyncPacket$ErrorSection extends SyncPacket$Section {
   public String toString() {
      return "ErrorSection";
   }

   public SyncPacket$SectionType getType() {
      return SyncPacket$SectionType.ERROR;
   }

   public int getBodySize() {
      return 0;
   }

   public void writeBody(ByteBuffer var1) {
   }

   public String toStringForDebug() {
      return "ErrorSection";
   }

   public int compareTo(SyncPacket$ErrorSection var1) {
      return 0;
   }

   SyncPacket$ErrorSection() {
   }

   SyncPacket$ErrorSection(ByteBuffer var1) {
   }
}
