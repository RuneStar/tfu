/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.jnibindings.runetek6.Pick;
import com.jagex.maths.Vector3;
import java.security.InvalidParameterException;
import java.util.List;
import tfu.Fn87;
import tfu.H149;
import tfu.Kc180;

public final class Fi371 {
    private static long d;
    private static long g;
    public static final int j = 100;
    private static long q;

    public static void d(int n, int n2, int n3, List list) {
        int n4;
        if (n3 > 100) {
            throw new InvalidParameterException("maximum number of requested picked results must be <= 100");
        }
        long l = 4L;
        q = Kc180.e();
        d = q + 16L;
        if (g == 0L) {
            g = Kc180.g(100L * d);
        }
        Object object = H149.v;
        synchronized (object) {
            n4 = Pick.pickXY(n, n2, g, n3, null);
        }
        long l2 = g;
        for (int i = 0; i < n4; ++i) {
            Fn87 fn87 = new Fn87();
            l2 += Fi371.g(l2, fn87);
            list.add(fn87);
        }
    }

    private static long g(long l, Fn87 fn87) {
        long l2 = Kc180.h(l);
        float f = Kc180.u(l += q);
        float f2 = Kc180.u(l += 4L);
        float f3 = Kc180.u(l += 4L);
        float f4 = Kc180.u(l += 4L);
        l += 4L;
        fn87.g = l2;
        fn87.d = new Vector3(f, f2, f3);
        fn87.q = f4;
        return d;
    }

    static {
        g = 0L;
        d = 0L;
        q = 0L;
    }
}

