/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.game.runetek6.comms.statestream.CircularIDWidth;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import java.util.Comparator;

final class Lg498
implements Comparator {
    Lg498() {
    }

    public static int g(Lg498 lg498, Integer n, Integer n2) {
        return LossyStateStream.TIMESTAMP_WIDTH.diffIDs(n, n2);
    }
}

