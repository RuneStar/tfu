/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Dc622;
import tfu.De623;
import tfu.Gi430;

public abstract class Ds621 {
    private static final boolean s = true;

    public static Ds621 r() {
        try {
            return new Dc622();
        }
        catch (Throwable throwable) {
            return new De623();
        }
    }

    public static final int v(Ds621 ds621, long l) {
        long l2 = ds621.g();
        if (l2 > 0L) {
            Gi430.g(l2);
        }
        return ds621.d(l);
    }

    public abstract long g();

    public abstract int d(long var1);
}

