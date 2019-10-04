// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import tfu.Gz143;
import tfu.Ln265;
import tfu.Ha262;
import tfu.Hn359;
import tfu.Kp349;

public class L410 extends Kp349
{
    private static Hn359 b;
    public static final int e = 1;
    public static final int h = 2;
    private static Ha262 l;
    private static final long r = Long.MIN_VALUE;
    private static Hn359 s;
    private static final long v = 500L;
    private static final long w = Long.MAX_VALUE;
    int d;
    int g;
    String j;
    int q;
    
    public static void j(final int n, final int g) {
        final L410 g2 = g(1, n);
        h(g2);
        g2.g = g;
    }
    
    private L410(final int n, final long n2) {
        super.bq = ((long)n << 56 | n2);
    }
    
    public static L410 q() {
        final L410 l410 = (L410)Hn359.h(L410.s);
        if (l410 != null) {
            Ln265.ef(l410);
            Kp349.t(l410);
            return l410;
        }
        while (true) {
            final L410 l411 = (L410)Hn359.h(L410.b);
            if (l411 == null) {
                return null;
            }
            if (l(l411) > Gz143.g()) {
                return null;
            }
            Ln265.ef(l411);
            Kp349.t(l411);
            if ((l411.p & Long.MIN_VALUE) != 0x0L) {
                return l411;
            }
        }
    }
    
    public static void e(final int n, final String j) {
        final L410 g = g(2, n);
        h(g);
        g.j = j;
    }
    
    private static void h(final L410 l410) {
        l410.p |= Long.MIN_VALUE;
        if (l(l410) == 0L) {
            Hn359.q(L410.s, l410);
        }
    }
    
    public static int s(final L410 l410) {
        return (int)(l410.bq >>> 56 & 0xFFL);
    }
    
    public static long b(final L410 l410) {
        return l410.bq & 0xFFFFFFFFFFFFFFL;
    }
    
    private static long l(final L410 l410) {
        return l410.p & Long.MAX_VALUE;
    }
    
    static {
        L410.s = new Hn359();
        L410.b = new Hn359();
        L410.l = new Ha262(16);
    }
    
    private static L410 g(final int n, final long n2) {
        L410 l410 = (L410)Ha262.d(L410.l, (long)n << 56 | n2);
        if (l410 == null) {
            l410 = new L410(n, n2);
            Ha262.q(L410.l, l410, l410.bq);
        }
        return l410;
    }
    
    public static void d() {
        Ha262.j(L410.l);
        Hn359.d(L410.b);
        Hn359.d(L410.s);
    }
}
