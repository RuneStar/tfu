// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

import java.util.Map;
import java.util.Comparator;

final class LossyStateStreamStatistics$1 implements Comparator
{
    public int compare(final Map.Entry entry, final Map.Entry entry2) {
        final int compareTo = entry2.getValue().compareTo(entry.getValue());
        return (compareTo == 0) ? 1 : compareTo;
    }
}
