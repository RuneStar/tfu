/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.game.runetek6.comms.statestream.CircularIDWidth;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import java.util.Comparator;

final class Lh494
implements Comparator {
    Lh494() {
    }

    public static int g(Lh494 lh494, Integer n, Integer n2) {
        return LossyStateStream.TIMESTAMP_WIDTH.diffIDs(n, n2);
    }
}

