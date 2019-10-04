/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamProfiler$StoredState;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamProfiler$ThreadProc;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamStatistics;
import com.jagex.game.runetek6.comms.statestream.SyncPacket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LossyStateStreamProfiler {
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
        if (t == null) {
            t = new Thread(new LossyStateStreamProfiler$ThreadProc());
            t.start();
        }
    }

    public static void registerNewStream(int n, String string) {
        streamNames.put(n, string);
    }

    public static void streamFinalised(int n) {
        streamNames.remove(n);
    }

    static {
        enabled = false;
        t = null;
        syncObject = new Object();
        currentStats = new LossyStateStreamStatistics();
        statsToSend = null;
        newStats = false;
        streamNames = new HashMap();
        stateHistory = new LossyStateStreamProfiler$StoredState[10];
        stateHistoryPointer = 0;
    }

    public static void receivedSyncPacket(SyncPacket syncPacket) {
        if (!enabled) {
            return;
        }
        if (syncPacket.keyframe) {
            return;
        }
        LossyStateStreamProfiler.initialise();
        Object object = syncObject;
        synchronized (object) {
            ++LossyStateStreamProfiler.currentStats.receivedPacketCount;
            for (Map.Entry entry : syncPacket.sections.entrySet()) {
                int n = 0;
                for (Map.Entry entry2 : ((Map)entry.getValue()).entrySet()) {
                    int n2 = (Integer)entry2.getKey();
                    int n3 = ((List)entry2.getValue()).size();
                    n += n3;
                    LossyStateStreamProfiler.increaseCount(LossyStateStreamProfiler.currentStats.streamReceivedSectionCounts, n2, n3);
                    String string = (String)streamNames.get(n2);
                    if (string == null) continue;
                    LossyStateStreamProfiler.currentStats.streamNames.put(n2, string);
                }
                LossyStateStreamProfiler.increaseCount(LossyStateStreamProfiler.currentStats.receivedSectionCounts, entry.getKey(), n);
            }
        }
    }

    public static void newStateAdded(LossyStateStream lossyStateStream, Object object, int n) {
        if (!enabled) {
            return;
        }
        String string = (String)streamNames.get(lossyStateStream.id);
        if (string == null) {
            string = "[" + lossyStateStream.id + "]";
        }
        LossyStateStreamProfiler.stateHistory[LossyStateStreamProfiler.stateHistoryPointer] = new LossyStateStreamProfiler$StoredState(string, object, n);
        stateHistoryPointer = (stateHistoryPointer + 1) % stateHistory.length;
    }

    static void increaseCount(Map map, Object object, int n) {
        Integer n2 = (Integer)map.get(object);
        if (n2 == null) {
            map.put(object, n);
        } else {
            map.put(object, n2 + n);
        }
    }

    public static void sendingSyncPacket(SyncPacket syncPacket, int n) {
        if (!enabled) {
            return;
        }
        if (syncPacket.keyframe) {
            return;
        }
        LossyStateStreamProfiler.initialise();
        Object object = syncObject;
        synchronized (object) {
            ++LossyStateStreamProfiler.currentStats.rawSentPacketCount;
            LossyStateStreamProfiler.currentStats.sentPacketCount += n;
            for (Map.Entry entry : syncPacket.sections.entrySet()) {
                int n2 = 0;
                for (Map.Entry entry2 : ((Map)entry.getValue()).entrySet()) {
                    int n3 = (Integer)entry2.getKey();
                    int n4 = ((List)entry2.getValue()).size();
                    n2 += n4;
                    LossyStateStreamProfiler.increaseCount(LossyStateStreamProfiler.currentStats.streamSentSectionCounts, n3, n4);
                    String string = (String)streamNames.get(n3);
                    if (string == null) continue;
                    LossyStateStreamProfiler.currentStats.streamNames.put(n3, string);
                }
                LossyStateStreamProfiler.increaseCount(LossyStateStreamProfiler.currentStats.sentSectionCounts, entry.getKey(), n2);
            }
        }
    }
}

