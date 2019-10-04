package com.jagex.game.runetek6.comms.statestream;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import tfu.Gg3;

public class LossyStateStreamStatistics {
   public static final Comparator descendingValueSort = new LossyStateStreamStatistics$1();
   public int period;
   public int rawSentPacketCount = 0;
   public int receivedPacketCount = 0;
   public final Map receivedSectionCounts = new HashMap();
   public int sentPacketCount = 0;
   public final Map sentSectionCounts = new HashMap();
   public final Map streamNames = new HashMap();
   public final Map streamReceivedSectionCounts = new HashMap();
   public final Map streamSentSectionCounts = new HashMap();

   public static LossyStateStreamStatistics deserialise(Gg3 var0) {
      LossyStateStreamStatistics var1 = new LossyStateStreamStatistics();
      var1.period = Gg3.bd(var0);
      var1.rawSentPacketCount = Gg3.bd(var0);
      var1.sentPacketCount = Gg3.bd(var0);
      var1.receivedPacketCount = Gg3.bd(var0);
      int var2 = Gg3.ar(var0);

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; ++var3) {
         byte var4 = Gg3.ax(var0);
         var5 = Gg3.bd(var0);
         var1.sentSectionCounts.put(SyncPacket$SectionType.getByID(var4), var5);
      }

      var3 = Gg3.ar(var0);

      int var6;
      int var10;
      for(var10 = 0; var10 < var3; ++var10) {
         byte var11 = Gg3.ax(var0);
         var6 = Gg3.bd(var0);
         var1.receivedSectionCounts.put(SyncPacket$SectionType.getByID(var11), var6);
      }

      var10 = Gg3.bd(var0);

      int var7;
      for(var5 = 0; var5 < var10; ++var5) {
         var6 = Gg3.bd(var0);
         var7 = Gg3.bd(var0);
         var1.streamSentSectionCounts.put(var6, var7);
      }

      var5 = Gg3.bd(var0);

      int var8;
      for(var6 = 0; var6 < var5; ++var6) {
         var7 = Gg3.bd(var0);
         var8 = Gg3.bd(var0);
         var1.streamReceivedSectionCounts.put(var7, var8);
      }

      var6 = Gg3.bd(var0);

      for(var7 = 0; var7 < var6; ++var7) {
         var8 = Gg3.bd(var0);
         String var9 = Gg3.bk(var0);
         var1.streamNames.put(var8, var9);
      }

      return var1;
   }
}
