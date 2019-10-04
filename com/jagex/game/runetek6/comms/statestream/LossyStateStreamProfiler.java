package com.jagex.game.runetek6.comms.statestream;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LossyStateStreamProfiler {
   public static final int PERIOD_MS = 500;
   public static final int STATE_HISTORY = 10;
   static LossyStateStreamStatistics currentStats = new LossyStateStreamStatistics();
   public static boolean enabled = false;
   static boolean newStats = false;
   public static final LossyStateStreamProfiler$StoredState[] stateHistory = new LossyStateStreamProfiler$StoredState[10];
   public static int stateHistoryPointer = 0;
   static LossyStateStreamStatistics statsToSend = null;
   static Map streamNames = new HashMap();
   static Object syncObject = new Object();
   static Thread t = null;

   static void initialise() {
      if (t == null) {
         t = new Thread(new LossyStateStreamProfiler$ThreadProc());
         t.start();
      }

   }

   public static void registerNewStream(int var0, String var1) {
      streamNames.put(var0, var1);
   }

   public static void streamFinalised(int var0) {
      streamNames.remove(var0);
   }

   public static void receivedSyncPacket(SyncPacket var0) {
      if (enabled) {
         if (!var0.keyframe) {
            initialise();
            Object var1 = syncObject;
            synchronized(var1) {
               ++currentStats.receivedPacketCount;
               Iterator var2 = var0.sections.entrySet().iterator();

               while(var2.hasNext()) {
                  Entry var3 = (Entry)var2.next();
                  int var4 = 0;
                  Iterator var5 = ((Map)var3.getValue()).entrySet().iterator();

                  while(var5.hasNext()) {
                     Entry var6 = (Entry)var5.next();
                     int var7 = (Integer)var6.getKey();
                     int var8 = ((List)var6.getValue()).size();
                     var4 += var8;
                     increaseCount(currentStats.streamReceivedSectionCounts, var7, var8);
                     String var9 = (String)streamNames.get(var7);
                     if (var9 != null) {
                        currentStats.streamNames.put(var7, var9);
                     }
                  }

                  increaseCount(currentStats.receivedSectionCounts, var3.getKey(), var4);
               }

            }
         }
      }
   }

   public static void newStateAdded(LossyStateStream var0, Object var1, int var2) {
      if (enabled) {
         String var3 = (String)streamNames.get(var0.id);
         if (var3 == null) {
            var3 = "[" + var0.id + "]";
         }

         stateHistory[stateHistoryPointer] = new LossyStateStreamProfiler$StoredState(var3, var1, var2);
         stateHistoryPointer = (stateHistoryPointer + 1) % stateHistory.length;
      }
   }

   static void increaseCount(Map var0, Object var1, int var2) {
      Integer var3 = (Integer)var0.get(var1);
      if (var3 == null) {
         var0.put(var1, var2);
      } else {
         var0.put(var1, var3 + var2);
      }

   }

   public static void sendingSyncPacket(SyncPacket var0, int var1) {
      if (enabled) {
         if (!var0.keyframe) {
            initialise();
            Object var2 = syncObject;
            synchronized(var2) {
               ++currentStats.rawSentPacketCount;
               LossyStateStreamStatistics var10000 = currentStats;
               var10000.sentPacketCount += var1;
               Iterator var3 = var0.sections.entrySet().iterator();

               while(var3.hasNext()) {
                  Entry var4 = (Entry)var3.next();
                  int var5 = 0;
                  Iterator var6 = ((Map)var4.getValue()).entrySet().iterator();

                  while(var6.hasNext()) {
                     Entry var7 = (Entry)var6.next();
                     int var8 = (Integer)var7.getKey();
                     int var9 = ((List)var7.getValue()).size();
                     var5 += var9;
                     increaseCount(currentStats.streamSentSectionCounts, var8, var9);
                     String var10 = (String)streamNames.get(var8);
                     if (var10 != null) {
                        currentStats.streamNames.put(var8, var10);
                     }
                  }

                  increaseCount(currentStats.sentSectionCounts, var4.getKey(), var5);
               }

            }
         }
      }
   }
}
