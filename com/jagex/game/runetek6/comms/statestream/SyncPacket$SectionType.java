package com.jagex.game.runetek6.comms.statestream;

public enum SyncPacket$SectionType {
   DELTA((byte)1),
   ERROR((byte)3),
   PACKET_ACKNOWLEDGE((byte)2),
   RESET((byte)4);

   public final byte id;

   private SyncPacket$SectionType(byte var3) {
      this.id = var3;
   }

   public static SyncPacket$SectionType getByID(byte var0) {
      SyncPacket$SectionType[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         SyncPacket$SectionType var4 = var1[var3];
         if (var4.id == var0) {
            return var4;
         }
      }

      return null;
   }
}
