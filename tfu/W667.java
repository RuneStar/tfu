/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.js5.js5;
import tfu.Ca649;
import tfu.Cd585;
import tfu.M688;
import tfu.P689;
import tfu.X687;

public class W667 {
    private static Ca649 a;
    private static final int b = 1;
    static js5 d;
    private static Cd585 e;
    static X687 f;
    static js5 g;
    private static final boolean h = false;
    private static M688 i;
    private static M688 j;
    private static X687 k;
    private static final int l = 2;
    private static long m;
    private static boolean n;
    private static P689 o;
    private static int p;
    static js5 q;
    private static int r;
    private static final int s = 0;
    private static int[] t;
    private static int u;
    private static js5 v;
    private static final int w = 3;
    private static int x;
    private static int y;
    private static int z;

    static void q() {
        r = 0;
        o = null;
        a = null;
        v = null;
        i = null;
    }

    public static boolean d() {
        block14 : {
            try {
                if (r != 2) break block14;
                if (o == null && (o = P689.g(v, y, p)) == null) {
                    return false;
                }
                if (a == null) {
                    a = new Ca649(q, d);
                }
                M688 m688 = j;
                if (i != null) {
                    m688 = i;
                }
                if (!M688.r(m688, o, g, a, 22050)) break block14;
                j = m688;
                M688.v(j);
                if (z > 0) {
                    r = 3;
                    M688.h(j, z > x ? x : z);
                    for (int i = 0; i < t.length; ++i) {
                        M688.s(j, i, t[i]);
                        W667.t[i] = 255;
                    }
                } else {
                    r = 0;
                    M688.h(j, x);
                    for (int i = 0; i < t.length; ++i) {
                        M688.s(j, i, t[i]);
                        W667.t[i] = 255;
                    }
                }
                if (i == null) {
                    if (m > 0L) {
                        M688.t(j, o, n, true, m);
                    } else {
                        M688.u(j, o, n);
                    }
                    if (k != null) {
                        k.g();
                    }
                }
                if (e != null) {
                    Cd585.g(e, j);
                }
                o = null;
                a = null;
                v = null;
                m = 0L;
                i = null;
                k = null;
                return true;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                M688.m(j);
                W667.q();
            }
        }
        return false;
    }

    static {
        r = 0;
        f = null;
    }

    public static void g(int n) {
        r = 1;
        v = null;
        y = -1;
        p = -1;
        i = null;
        x = 0;
        W667.n = false;
        u = n;
        k = null;
    }
}

