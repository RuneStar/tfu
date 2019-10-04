// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

import java.util.HashMap;
import tfu.Gg3;
import java.util.Map;
import java.util.Comparator;

public class LossyStateStreamStatistics
{
    public static final Comparator descendingValueSort;
    public int period;
    public int rawSentPacketCount;
    public int receivedPacketCount;
    public final Map receivedSectionCounts;
    public int sentPacketCount;
    public final Map sentSectionCounts;
    public final Map streamNames;
    public final Map streamReceivedSectionCounts;
    public final Map streamSentSectionCounts;
    
    static {
        descendingValueSort = new LossyStateStreamStatistics$1();
    }
    
    public static LossyStateStreamStatistics deserialise(final Gg3 gg3) {
        final LossyStateStreamStatistics lossyStateStreamStatistics = new LossyStateStreamStatistics();
        lossyStateStreamStatistics.period = Gg3.bd(gg3);
        lossyStateStreamStatistics.rawSentPacketCount = Gg3.bd(gg3);
        lossyStateStreamStatistics.sentPacketCount = Gg3.bd(gg3);
        lossyStateStreamStatistics.receivedPacketCount = Gg3.bd(gg3);
        for (int ar = Gg3.ar(gg3), i = 0; i < ar; ++i) {
            lossyStateStreamStatistics.sentSectionCounts.put(SyncPacket$SectionType.getByID(Gg3.ax(gg3)), Gg3.bd(gg3));
        }
        for (int ar2 = Gg3.ar(gg3), j = 0; j < ar2; ++j) {
            lossyStateStreamStatistics.receivedSectionCounts.put(SyncPacket$SectionType.getByID(Gg3.ax(gg3)), Gg3.bd(gg3));
        }
        for (int bd = Gg3.bd(gg3), k = 0; k < bd; ++k) {
            lossyStateStreamStatistics.streamSentSectionCounts.put(Gg3.bd(gg3), Gg3.bd(gg3));
        }
        for (int bd2 = Gg3.bd(gg3), l = 0; l < bd2; ++l) {
            lossyStateStreamStatistics.streamReceivedSectionCounts.put(Gg3.bd(gg3), Gg3.bd(gg3));
        }
        for (int bd3 = Gg3.bd(gg3), n = 0; n < bd3; ++n) {
            lossyStateStreamStatistics.streamNames.put(Gg3.bd(gg3), Gg3.bk(gg3));
        }
        return lossyStateStreamStatistics;
    }
    
    public LossyStateStreamStatistics() {
        this.rawSentPacketCount = 0;
        this.sentPacketCount = 0;
        this.receivedPacketCount = 0;
        this.sentSectionCounts = new HashMap();
        this.receivedSectionCounts = new HashMap();
        this.streamSentSectionCounts = new HashMap();
        this.streamReceivedSectionCounts = new HashMap();
        this.streamNames = new HashMap();
    }
}
