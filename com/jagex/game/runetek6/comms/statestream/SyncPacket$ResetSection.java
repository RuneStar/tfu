package com.jagex.game.runetek6.comms.statestream;

import java.nio.ByteBuffer;

class SyncPacket$ResetSection extends SyncPacket$Section {
   SyncPacket$ResetSection(ByteBuffer var1) {
   }

   public int getBodySize() {
      return 0;
   }

   public SyncPacket$SectionType getType() {
      return SyncPacket$SectionType.RESET;
   }

   public void writeBody(ByteBuffer var1) {
   }

   public String toString() {
      return "ResetSection";
   }

   public int compareTo(SyncPacket$ResetSection var1) {
      return 0;
   }

   public String toStringForDebug() {
      return "ResetSection";
   }

   SyncPacket$ResetSection() {
   }
}
