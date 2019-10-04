// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.maths.Matrix4;
import com.jagex.maths.H303;
import com.jagex.maths.U316;

public class C340
{
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
    
    public static void d(final H303 h303, final Matrix4 matrix4) {
        C340.j = (C340.h = H149.p / 2.0f);
        C340.e = (C340.s = H149.x / 2.0f);
        C340.s = -C340.s;
        U316.e(C340.d, h303);
        U316.q(C340.q, C340.d);
        U316.j(C340.q, matrix4);
    }
    
    public static final void q() {
        C340.w = (C340.b = 0);
        C340.r = H149.p;
        C340.l = H149.x;
    }
    
    public static final void j(final int n, final int n2, final int n3, final int n4) {
        C340.w = ((n >= 0) ? n : 0);
        C340.r = ((n3 <= H149.p) ? n3 : H149.p);
        C340.b = ((n2 >= 0) ? n2 : 0);
        C340.l = ((n4 <= H149.x) ? n4 : H149.x);
    }
    
    public static final void e(final float n, final float n2, final float n3, final float n4, final int n5) {
        b(n, n2, n3, n4, n5, Fb341.BLEND_NORMAL);
    }
    
    public static final void h(final float n, final float n2, final float n3, final int n4) {
        l(n, n2, n3, n4, Fb341.BLEND_NORMAL);
    }
    
    public static final void s(final float n, final float n2, final float n3, final int n4) {
        w(n, n2, n3, n4, Fb341.BLEND_NORMAL);
    }
    
    public static void y(final int n, final int n2, final int n3, final int n4) {
    }
    
    public static final void g() {
        C340.g = new A672(1, 1, new int[] { -1 }, 0, 1);
    }
    
    public static final void w(final float n, final float n2, final float n3, final int n4, final Fb341 fb341) {
        r(n, n2, n, n2 + n3, n4, fb341);
    }
    
    public static final void r(final float n, final float n2, final float n3, final float n4, final int n5, final Fb341 fb341) {
        v(n, n2, n3, n4, n5, 1, fb341);
    }
    
    public static final void v(float n, float n2, float n3, float n4, final int n5, final int n6, final Fb341 fb341) {
        ++n;
        ++n2;
        ++n3;
        ++n4;
        final float n7 = n3 - n;
        final float n8 = n4 - n2;
        final float n9 = 1.0f / (float)Math.sqrt(n7 * n7 + n8 * n8);
        final float n10 = n7 * n9;
        final float n11 = n8 * n9;
        n -= n10;
        n2 -= n11;
        final float n12 = -n11;
        final float n13 = n10;
        final float n14 = n12 * (0.5f * n6);
        final float n15 = n13 * (0.5f * n6);
        A672.g(C340.g, n - n14, n2 - n15, n3 - n14, n4 - n15, n + n14, n2 + n15, Fy467.PREBLEND_MODULATE, n5, fb341);
    }
    
    public static final void l(final float n, final float n2, final float n3, final int n4, final Fb341 fb341) {
        r(n, n2, n + n3, n2, n4, fb341);
    }
    
    static {
        C340.d = new U316();
        C340.q = new U316();
        C340.b = 0;
        C340.l = 0;
        C340.w = 0;
        C340.r = 0;
        C340.v = new float[4];
        C340.y = new float[4];
    }
    
    public static final void b(final float n, final float n2, final float n3, final float n4, final int n5, final Fb341 fb341) {
        A672.h(C340.g, n, n2, n3, n4, Fy467.PREBLEND_MODULATE, n5, fb341);
    }
}
