/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.maths.H303;
import com.jagex.maths.Matrix4;
import com.jagex.maths.U316;
import tfu.A672;
import tfu.Fb341;
import tfu.Fy467;
import tfu.H149;

public class C340 {
    public static int b;
    static U316 d;
    static float e;
    static A672 g;
    static float h;
    static float j;
    public static int l;
    static U316 q;
    public static int r;
    static float s;
    static float[] v;
    public static int w;
    static float[] y;

    public static void d(H303 h303, Matrix4 matrix4) {
        j = h = (float)H149.p / 2.0f;
        e = s = (float)H149.x / 2.0f;
        s = -s;
        U316.e(d, h303);
        U316.q(q, d);
        U316.j(q, matrix4);
    }

    public static final void q() {
        b = 0;
        w = 0;
        r = H149.p;
        l = H149.x;
    }

    public static final void j(int n, int n2, int n3, int n4) {
        w = n >= 0 ? n : 0;
        r = n3 <= H149.p ? n3 : H149.p;
        b = n2 >= 0 ? n2 : 0;
        l = n4 <= H149.x ? n4 : H149.x;
    }

    public static final void e(float f, float f2, float f3, float f4, int n) {
        C340.b(f, f2, f3, f4, n, Fb341.BLEND_NORMAL);
    }

    public static final void h(float f, float f2, float f3, int n) {
        C340.l(f, f2, f3, n, Fb341.BLEND_NORMAL);
    }

    public static final void s(float f, float f2, float f3, int n) {
        C340.w(f, f2, f3, n, Fb341.BLEND_NORMAL);
    }

    public static void y(int n, int n2, int n3, int n4) {
    }

    public static final void g() {
        int[] arrn = new int[]{-1};
        g = new A672(1, 1, arrn, 0, 1);
    }

    public static final void w(float f, float f2, float f3, int n, Fb341 fb341) {
        C340.r(f, f2, f, f2 + f3, n, fb341);
    }

    public static final void r(float f, float f2, float f3, float f4, int n, Fb341 fb341) {
        C340.v(f, f2, f3, f4, n, 1, fb341);
    }

    public static final void v(float f, float f2, float f3, float f4, int n, int n2, Fb341 fb341) {
        float f5 = (f3 += 1.0f) - (f += 1.0f);
        float f6 = (f4 += 1.0f) - (f2 += 1.0f);
        float f7 = 1.0f / (float)Math.sqrt(f5 * f5 + f6 * f6);
        float f8 = -f6;
        float f9 = f5;
        A672.g(g, (f -= (f5 *= f7)) - (f8 *= 0.5f * (float)n2), (f2 -= (f6 *= f7)) - (f9 *= 0.5f * (float)n2), f3 - f8, f4 - f9, f + f8, f2 + f9, Fy467.PREBLEND_MODULATE, n, fb341);
    }

    public static final void l(float f, float f2, float f3, int n, Fb341 fb341) {
        C340.r(f, f2, f + f3, f2, n, fb341);
    }

    static {
        d = new U316();
        q = new U316();
        b = 0;
        l = 0;
        w = 0;
        r = 0;
        v = new float[4];
        y = new float[4];
    }

    public static final void b(float f, float f2, float f3, float f4, int n, Fb341 fb341) {
        A672.h(g, f, f2, f3, f4, Fy467.PREBLEND_MODULATE, n, fb341);
    }
}

