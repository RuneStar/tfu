/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.concurrent.Future;
import tfu.Ai354;
import tfu.B665;
import tfu.Fk353;
import tfu.Hh420;
import tfu.Hi86;
import tfu.Hp62;
import tfu.Ir421;
import tfu.N105;
import tfu.S671;

final class K547
implements Ir421 {
    @Override
    public boolean resourceNeedsRefCounting() {
        return true;
    }

    public N105 g(Fk353[] arrfk353, Hi86 hi86) throws Hh420 {
        N105 n105 = Ai354.d(arrfk353, hi86);
        Future future = B665.g().d(n105);
        try {
            return (N105)future.get();
        }
        catch (Exception exception) {
            throw new Hh420(exception);
        }
    }

    K547() {
    }
}

