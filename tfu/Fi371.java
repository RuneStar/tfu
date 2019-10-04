// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.maths.Vector3;
import com.jagex.jnibindings.runetek6.Pick;
import java.security.InvalidParameterException;
import java.util.List;

public final class Fi371
{
    private static long d;
    private static long g;
    public static final int j = 100;
    private static long q;
    
    public static void d(final int n, final int n2, final int n3, final List list) {
        if (n3 > 100) {
            throw new InvalidParameterException("maximum number of requested picked results must be <= 100");
        }
        Fi371.q = Kc180.e();
        Fi371.d = Fi371.q + 16L;
        if (Fi371.g == 0L) {
            Fi371.g = Kc180.g(100L * Fi371.d);
        }
        final int pickXY;
        synchronized (H149.v) {
            pickXY = Pick.pickXY(n, n2, Fi371.g, n3, null);
        }
        long g = Fi371.g;
        for (int i = 0; i < pickXY; ++i) {
            final Fn87 fn87 = new Fn87();
            g += g(g, fn87);
            list.add(fn87);
        }
    }
    
    private static long g(long n, final Fn87 fn87) {
        final long h = Kc180.h(n);
        n += Fi371.q;
        final float u = Kc180.u(n);
        n += 4L;
        final float u2 = Kc180.u(n);
        n += 4L;
        final float u3 = Kc180.u(n);
        n += 4L;
        final float u4 = Kc180.u(n);
        n += 4L;
        fn87.g = h;
        fn87.d = new Vector3(u, u2, u3);
        fn87.q = u4;
        return Fi371.d;
    }
    
    static {
        Fi371.g = 0L;
        Fi371.d = 0L;
        Fi371.q = 0L;
    }
}
