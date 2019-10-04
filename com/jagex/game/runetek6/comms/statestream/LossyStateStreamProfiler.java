// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class LossyStateStreamProfiler
{
    public static final int PERIOD_MS = 500;
    public static final int STATE_HISTORY = 10;
    static LossyStateStreamStatistics currentStats;
    public static boolean enabled;
    static boolean newStats;
    public static final LossyStateStreamProfiler$StoredState[] stateHistory;
    public static int stateHistoryPointer;
    static LossyStateStreamStatistics statsToSend;
    static Map streamNames;
    static Object syncObject;
    static Thread t;
    
    static void initialise() {
        if (LossyStateStreamProfiler.t == null) {
            (LossyStateStreamProfiler.t = new Thread(new LossyStateStreamProfiler$ThreadProc())).start();
        }
    }
    
    public static void registerNewStream(final int i, final String s) {
        LossyStateStreamProfiler.streamNames.put(i, s);
    }
    
    public static void streamFinalised(final int i) {
        LossyStateStreamProfiler.streamNames.remove(i);
    }
    
    static {
        LossyStateStreamProfiler.enabled = false;
        LossyStateStreamProfiler.t = null;
        LossyStateStreamProfiler.syncObject = new Object();
        LossyStateStreamProfiler.currentStats = new LossyStateStreamStatistics();
        LossyStateStreamProfiler.statsToSend = null;
        LossyStateStreamProfiler.newStats = false;
        LossyStateStreamProfiler.streamNames = new HashMap();
        stateHistory = new LossyStateStreamProfiler$StoredState[10];
        LossyStateStreamProfiler.stateHistoryPointer = 0;
    }
    
    public static void receivedSyncPacket(final SyncPacket syncPacket) {
        if (!LossyStateStreamProfiler.enabled) {
            return;
        }
        if (syncPacket.keyframe) {
            return;
        }
        initialise();
        synchronized (LossyStateStreamProfiler.syncObject) {
            final LossyStateStreamStatistics currentStats = LossyStateStreamProfiler.currentStats;
            ++currentStats.receivedPacketCount;
            for (final Map.Entry<K, Map> entry : syncPacket.sections.entrySet()) {
                int n = 0;
                for (final Map.Entry<Integer, Map<Integer, Map<Integer, V>>> entry2 : entry.getValue().entrySet()) {
                    final int intValue = entry2.getKey();
                    final int size = ((List)entry2.getValue()).size();
                    n += size;
                    increaseCount(LossyStateStreamProfiler.currentStats.streamReceivedSectionCounts, intValue, size);
                    final String s = LossyStateStreamProfiler.streamNames.get(intValue);
                    if (s != null) {
                        LossyStateStreamProfiler.currentStats.streamNames.put(intValue, s);
                    }
                }
                increaseCount(LossyStateStreamProfiler.currentStats.receivedSectionCounts, entry.getKey(), n);
            }
        }
    }
    
    public static void newStateAdded(final LossyStateStream lossyStateStream, final Object o, final int n) {
        if (!LossyStateStreamProfiler.enabled) {
            return;
        }
        String string = LossyStateStreamProfiler.streamNames.get(lossyStateStream.id);
        if (string == null) {
            string = "[" + lossyStateStream.id + "]";
        }
        LossyStateStreamProfiler.stateHistory[LossyStateStreamProfiler.stateHistoryPointer] = new LossyStateStreamProfiler$StoredState(string, o, n);
        LossyStateStreamProfiler.stateHistoryPointer = (LossyStateStreamProfiler.stateHistoryPointer + 1) % LossyStateStreamProfiler.stateHistory.length;
    }
    
    static void increaseCount(final Map map, final Object o, final int i) {
        final Integer n = map.get(o);
        if (n == null) {
            map.put(o, i);
        }
        else {
            map.put(o, n + i);
        }
    }
    
    public static void sendingSyncPacket(final SyncPacket syncPacket, final int n) {
        if (!LossyStateStreamProfiler.enabled) {
            return;
        }
        if (syncPacket.keyframe) {
            return;
        }
        initialise();
        synchronized (LossyStateStreamProfiler.syncObject) {
            final LossyStateStreamStatistics currentStats = LossyStateStreamProfiler.currentStats;
            ++currentStats.rawSentPacketCount;
            final LossyStateStreamStatistics currentStats2 = LossyStateStreamProfiler.currentStats;
            currentStats2.sentPacketCount += n;
            for (final Map.Entry<K, Map> entry : syncPacket.sections.entrySet()) {
                int n2 = 0;
                for (final Map.Entry<Integer, Map<Integer, Map<Integer, V>>> entry2 : entry.getValue().entrySet()) {
                    final int intValue = entry2.getKey();
                    final int size = ((List)entry2.getValue()).size();
                    n2 += size;
                    increaseCount(LossyStateStreamProfiler.currentStats.streamSentSectionCounts, intValue, size);
                    final String s = LossyStateStreamProfiler.streamNames.get(intValue);
                    if (s != null) {
                        LossyStateStreamProfiler.currentStats.streamNames.put(intValue, s);
                    }
                }
                increaseCount(LossyStateStreamProfiler.currentStats.sentSectionCounts, entry.getKey(), n2);
            }
        }
    }
}
