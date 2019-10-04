/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import tfu.Gz143;
import tfu.Ha262;
import tfu.Hn359;
import tfu.Kp349;
import tfu.Ln265;

public class L410
extends Kp349 {
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

    public static void j(int n, int n2) {
        L410 l410 = L410.g(1, n);
        L410.h(l410);
        l410.g = n2;
    }

    private L410(int n, long l) {
        this.bq = (long)n << 56 | l;
    }

    public static L410 q() {
        L410 l410 = (L410)Hn359.h(s);
        if (l410 != null) {
            L410.ef(l410);
            L410.t(l410);
            return l410;
        }
        do {
            if ((l410 = (L410)Hn359.h(b)) == null) {
                return null;
            }
            if (L410.l(l410) > Gz143.g()) {
                return null;
            }
            L410.ef(l410);
            L410.t(l410);
        } while ((l410.p & Long.MIN_VALUE) == 0L);
        return l410;
    }

    public static void e(int n, String string) {
        L410 l410 = L410.g(2, n);
        L410.h(l410);
        l410.j = string;
    }

    private static void h(L410 l410) {
        l410.p |= Long.MIN_VALUE;
        if (L410.l(l410) == 0L) {
            Hn359.q(s, l410);
        }
    }

    public static int s(L410 l410) {
        return (int)(l410.bq >>> 56 & 0xFFL);
    }

    public static long b(L410 l410) {
        return l410.bq & 0xFFFFFFFFFFFFFFL;
    }

    private static long l(L410 l410) {
        return l410.p & Long.MAX_VALUE;
    }

    static {
        s = new Hn359();
        b = new Hn359();
        l = new Ha262(16);
    }

    private static L410 g(int n, long l) {
        L410 l410 = (L410)Ha262.d(L410.l, (long)n << 56 | l);
        if (l410 == null) {
            l410 = new L410(n, l);
            Ha262.q(L410.l, l410, l410.bq);
        }
        return l410;
    }

    public static void d() {
        Ha262.j(l);
        Hn359.d(b);
        Hn359.d(s);
    }
}

