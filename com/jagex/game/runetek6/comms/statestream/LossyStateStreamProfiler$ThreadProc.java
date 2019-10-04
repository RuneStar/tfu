/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import com.jagex.game.runetek6.comms.statestream.LossyStateStreamProfiler;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamStatistics;

class LossyStateStreamProfiler$ThreadProc
implements Runnable {
    @Override
    public void run() {
        LossyStateStreamProfiler.t = null;
    }

    private static void sleep() {
        int n = 500;
        while (n > 0) {
            long l = System.nanoTime();
            try {
                Thread.sleep(n);
                break;
            }
            catch (InterruptedException interruptedException) {
                n = (int)((long)n - (System.nanoTime() - l) / 1000000L);
            }
        }
    }

    private static void report() {
        Object object = LossyStateStreamProfiler.syncObject;
        synchronized (object) {
            LossyStateStreamProfiler.currentStats.period = 500;
            LossyStateStreamProfiler.statsToSend = LossyStateStreamProfiler.currentStats;
            LossyStateStreamProfiler.newStats = true;
            LossyStateStreamProfiler.currentStats = new LossyStateStreamStatistics();
        }
    }

    LossyStateStreamProfiler$ThreadProc() {
    }
}

