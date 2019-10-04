// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import java.util.Comparator;

final class Lh494 implements Comparator
{
    public static int g(final Lh494 lh494, final Integer n, final Integer n2) {
        return LossyStateStream.TIMESTAMP_WIDTH.diffIDs(n, n2);
    }
}
