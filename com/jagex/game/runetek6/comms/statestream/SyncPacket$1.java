package com.jagex.game.runetek6.comms.statestream;

// $FF: synthetic class
class SyncPacket$1 {
   // $FF: synthetic field
   static final int[] $SwitchMap$com$jagex$game$runetek6$comms$statestream$SyncPacket$SectionType = new int[SyncPacket$SectionType.values().length];

   static {
      try {
         $SwitchMap$com$jagex$game$runetek6$comms$statestream$SyncPacket$SectionType[SyncPacket$SectionType.PACKET_ACKNOWLEDGE.ordinal()] = 1;
      } catch (NoSuchFieldError var4) {
      }

      try {
         $SwitchMap$com$jagex$game$runetek6$comms$statestream$SyncPacket$SectionType[SyncPacket$SectionType.DELTA.ordinal()] = 2;
      } catch (NoSuchFieldError var3) {
      }

      try {
         $SwitchMap$com$jagex$game$runetek6$comms$statestream$SyncPacket$SectionType[SyncPacket$SectionType.ERROR.ordinal()] = 3;
      } catch (NoSuchFieldError var2) {
      }

      try {
         $SwitchMap$com$jagex$game$runetek6$comms$statestream$SyncPacket$SectionType[SyncPacket$SectionType.RESET.ordinal()] = 4;
      } catch (NoSuchFieldError var1) {
      }

   }
}
