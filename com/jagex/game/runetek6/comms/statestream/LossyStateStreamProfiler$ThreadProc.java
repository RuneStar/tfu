// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

class LossyStateStreamProfiler$ThreadProc implements Runnable
{
    @Override
    public void run() {
        LossyStateStreamProfiler.t = null;
    }
    
    private static void sleep() {
        int i = 500;
        while (i > 0) {
            final long nanoTime = System.nanoTime();
            try {
                Thread.sleep(i);
            }
            catch (InterruptedException ex) {
                i -= (int)((System.nanoTime() - nanoTime) / 1000000L);
                continue;
            }
            break;
        }
    }
    
    private static void report() {
        synchronized (LossyStateStreamProfiler.syncObject) {
            LossyStateStreamProfiler.currentStats.period = 500;
            LossyStateStreamProfiler.statsToSend = LossyStateStreamProfiler.currentStats;
            LossyStateStreamProfiler.newStats = true;
            LossyStateStreamProfiler.currentStats = new LossyStateStreamStatistics();
        }
    }
}
