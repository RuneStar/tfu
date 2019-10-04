package com.jagex.game.runetek6.comms.statestream;

class LossyStateStreamProfiler$ThreadProc implements Runnable {
   public void run() {
      LossyStateStreamProfiler.t = null;
   }

   private static void sleep() {
      int var0 = 500;

      while(var0 > 0) {
         long var1 = System.nanoTime();

         try {
            Thread.sleep((long)var0);
            break;
         } catch (InterruptedException var4) {
            var0 = (int)((long)var0 - (System.nanoTime() - var1) / 1000000L);
         }
      }

   }

   private static void report() {
      Object var0 = LossyStateStreamProfiler.syncObject;
      synchronized(var0) {
         LossyStateStreamProfiler.currentStats.period = 500;
         LossyStateStreamProfiler.statsToSend = LossyStateStreamProfiler.currentStats;
         LossyStateStreamProfiler.newStats = true;
         LossyStateStreamProfiler.currentStats = new LossyStateStreamStatistics();
      }
   }
}
