// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.js5.js5;

public class W667
{
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
        W667.r = 0;
        W667.o = null;
        W667.a = null;
        W667.v = null;
        W667.i = null;
    }
    
    public static boolean d() {
        try {
            if (W667.r == 2) {
                if (W667.o == null) {
                    W667.o = P689.g(W667.v, W667.y, W667.p);
                    if (W667.o == null) {
                        return false;
                    }
                }
                if (W667.a == null) {
                    W667.a = new Ca649(W667.q, W667.d);
                }
                M688 j = W667.j;
                if (W667.i != null) {
                    j = W667.i;
                }
                if (M688.r(j, W667.o, W667.g, W667.a, 22050)) {
                    M688.v(W667.j = j);
                    if (W667.z > 0) {
                        W667.r = 3;
                        M688.h(W667.j, (W667.z > W667.x) ? W667.x : W667.z);
                        for (int i = 0; i < W667.t.length; ++i) {
                            M688.s(W667.j, i, W667.t[i]);
                            W667.t[i] = 255;
                        }
                    }
                    else {
                        W667.r = 0;
                        M688.h(W667.j, W667.x);
                        for (int k = 0; k < W667.t.length; ++k) {
                            M688.s(W667.j, k, W667.t[k]);
                            W667.t[k] = 255;
                        }
                    }
                    if (W667.i == null) {
                        if (W667.m > 0L) {
                            M688.t(W667.j, W667.o, W667.n, true, W667.m);
                        }
                        else {
                            M688.u(W667.j, W667.o, W667.n);
                        }
                        if (W667.k != null) {
                            W667.k.g();
                        }
                    }
                    if (W667.e != null) {
                        Cd585.g(W667.e, W667.j);
                    }
                    W667.o = null;
                    W667.a = null;
                    W667.v = null;
                    W667.m = 0L;
                    W667.i = null;
                    W667.k = null;
                    return true;
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            M688.m(W667.j);
            q();
        }
        return false;
    }
    
    static {
        W667.r = 0;
        W667.f = null;
    }
    
    public static void g(final int u) {
        W667.r = 1;
        W667.v = null;
        W667.y = -1;
        W667.p = -1;
        W667.i = null;
        W667.x = 0;
        W667.n = false;
        W667.u = u;
        W667.k = null;
    }
}
