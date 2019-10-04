/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import java.util.Comparator;
import java.util.Map;

final class LossyStateStreamStatistics$1
implements Comparator {
    public int compare(Map.Entry entry, Map.Entry entry2) {
        int n = ((Integer)entry2.getValue()).compareTo((Integer)entry.getValue());
        return n == 0 ? 1 : n;
    }

    LossyStateStreamStatistics$1() {
    }
}

