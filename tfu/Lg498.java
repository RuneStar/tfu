// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import java.util.Comparator;

final class Lg498 implements Comparator
{
    public static int g(final Lg498 lg498, final Integer n, final Integer n2) {
        return LossyStateStream.TIMESTAMP_WIDTH.diffIDs(n, n2);
    }
}
