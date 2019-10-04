/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import com.jagex.game.runetek6.comms.statestream.LossyStateStreamStatistics$1;
import com.jagex.game.runetek6.comms.statestream.SyncPacket$SectionType;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import tfu.Gg3;

public class LossyStateStreamStatistics {
    public static final Comparator descendingValueSort = new LossyStateStreamStatistics$1();
    public int period;
    public int rawSentPacketCount = 0;
    public int receivedPacketCount = 0;
    public final Map receivedSectionCounts;
    public int sentPacketCount = 0;
    public final Map sentSectionCounts = new HashMap();
    public final Map streamNames;
    public final Map streamReceivedSectionCounts;
    public final Map streamSentSectionCounts;

    public static LossyStateStreamStatistics deserialise(Gg3 gg3) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        LossyStateStreamStatistics lossyStateStreamStatistics = new LossyStateStreamStatistics();
        lossyStateStreamStatistics.period = Gg3.bd(gg3);
        lossyStateStreamStatistics.rawSentPacketCount = Gg3.bd(gg3);
        lossyStateStreamStatistics.sentPacketCount = Gg3.bd(gg3);
        lossyStateStreamStatistics.receivedPacketCount = Gg3.bd(gg3);
        int n7 = Gg3.ar(gg3);
        for (n3 = 0; n3 < n7; ++n3) {
            n2 = Gg3.ax(gg3);
            n6 = Gg3.bd(gg3);
            lossyStateStreamStatistics.sentSectionCounts.put(SyncPacket$SectionType.getByID((byte)n2), n6);
        }
        n3 = Gg3.ar(gg3);
        for (n2 = 0; n2 < n3; ++n2) {
            n6 = Gg3.ax(gg3);
            n = Gg3.bd(gg3);
            lossyStateStreamStatistics.receivedSectionCounts.put(SyncPacket$SectionType.getByID((byte)n6), n);
        }
        n2 = Gg3.bd(gg3);
        for (n6 = 0; n6 < n2; ++n6) {
            n = Gg3.bd(gg3);
            n4 = Gg3.bd(gg3);
            lossyStateStreamStatistics.streamSentSectionCounts.put(n, n4);
        }
        n6 = Gg3.bd(gg3);
        for (n = 0; n < n6; ++n) {
            n4 = Gg3.bd(gg3);
            n5 = Gg3.bd(gg3);
            lossyStateStreamStatistics.streamReceivedSectionCounts.put(n4, n5);
        }
        n = Gg3.bd(gg3);
        for (n4 = 0; n4 < n; ++n4) {
            n5 = Gg3.bd(gg3);
            String string = Gg3.bk(gg3);
            lossyStateStreamStatistics.streamNames.put(n5, string);
        }
        return lossyStateStreamStatistics;
    }

    public LossyStateStreamStatistics() {
        this.receivedSectionCounts = new HashMap();
        this.streamSentSectionCounts = new HashMap();
        this.streamReceivedSectionCounts = new HashMap();
        this.streamNames = new HashMap();
    }
}

