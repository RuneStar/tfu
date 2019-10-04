// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

import tfu.Gg3;

public final class O166 implements G300
{
    private static int d;
    private static O166[] g;
    private static int q;
    public float e;
    public float h;
    public float j;
    public float s;
    
    public O166(final Gg3 gg3) {
        this.j = Gg3.bl(gg3);
        this.e = Gg3.bl(gg3);
        this.h = Gg3.bl(gg3);
        this.s = Gg3.bl(gg3);
    }
    
    public static O166 d() {
        synchronized (O166.g) {
            if (O166.q == 0) {
                return new O166();
            }
            v(O166.g[--O166.q]);
            return O166.g[O166.q];
        }
    }
    
    public static O166 q(final float n, final float n2, final float n3, final float n4) {
        synchronized (O166.g) {
            if (O166.q == 0) {
                return new O166(n, n2, n3, n4);
            }
            b(O166.g[--O166.q], n, n2, n3, n4);
            return O166.g[O166.q];
        }
    }
    
    public static O166 j(final Quaternion quaternion) {
        synchronized (O166.g) {
            if (O166.q == 0) {
                return new O166(quaternion);
            }
            h(O166.g[--O166.q], quaternion);
            return O166.g[O166.q];
        }
    }
    
    public static void e(final O166 o166) {
        synchronized (O166.g) {
            if (O166.q < O166.d - 1) {
                O166.g[O166.q++] = o166;
            }
        }
    }
    
    public O166 c() {
        return new O166(this);
    }
    
    public static final O166 k(final O166 o166, final Quaternion quaternion) {
        b(o166, quaternion.w * o166.j + quaternion.x * o166.s + quaternion.y * o166.h - quaternion.z * o166.e, quaternion.w * o166.e - quaternion.x * o166.h + quaternion.y * o166.s + quaternion.z * o166.j, quaternion.w * o166.h + quaternion.x * o166.e - quaternion.y * o166.j + quaternion.z * o166.s, quaternion.w * o166.s - quaternion.x * o166.j - quaternion.y * o166.e - quaternion.z * o166.h);
        return o166;
    }
    
    public O166(final O166 o166) {
        s(this, o166);
    }
    
    public O166(final Quaternion quaternion) {
        h(this, quaternion);
    }
    
    public static O166 s(final O166 o166, final O166 o167) {
        o166.j = o167.j;
        o166.e = o167.e;
        o166.h = o167.h;
        o166.s = o167.s;
        return o166;
    }
    
    public static O166 l(final O166 o166, final Vector3 vector3, final float n) {
        w(o166, vector3.x, vector3.y, vector3.z, n);
        return o166;
    }
    
    public static O166 w(final O166 o166, final float n, final float n2, final float n3, final float n4) {
        final float n5 = (float)Math.sin(n4 * 0.5f);
        final float s = (float)Math.cos(n4 * 0.5f);
        o166.j = n * n5;
        o166.e = n2 * n5;
        o166.h = n3 * n5;
        o166.s = s;
        return o166;
    }
    
    public static O166 r(final O166 o166, final float n, final float n2, final float n3) {
        l(o166, Vector3.g(0.0f, 1.0f, 0.0f), n);
        final O166 d = d();
        l(d, Vector3.g(1.0f, 0.0f, 0.0f), n2);
        i(o166, d);
        l(d, Vector3.g(0.0f, 0.0f, 1.0f), n3);
        i(o166, d);
        e(d);
        return o166;
    }
    
    public static final O166 v(final O166 o166) {
        final float j = 0.0f;
        o166.h = j;
        o166.e = j;
        o166.j = j;
        o166.s = 1.0f;
        return o166;
    }
    
    public static final O166 y(final O166 o166) {
        o166.j = -o166.j;
        o166.e = -o166.e;
        o166.h = -o166.h;
        o166.s = -o166.s;
        return o166;
    }
    
    public O166() {
        v(this);
    }
    
    public static final O166 x(final O166 o166) {
        final float n = 1.0f / n(o166);
        o166.j *= n;
        o166.e *= n;
        o166.h *= n;
        o166.s *= n;
        return o166;
    }
    
    public static final O166 i(final O166 o166, final O166 o167) {
        b(o166, o167.s * o166.j + o167.j * o166.s + o167.e * o166.h - o167.h * o166.e, o167.s * o166.e - o167.j * o166.h + o167.e * o166.s + o167.h * o166.j, o167.s * o166.h + o167.j * o166.e - o167.e * o166.j + o167.h * o166.s, o167.s * o166.s - o167.j * o166.j - o167.e * o166.e - o167.h * o166.h);
        return o166;
    }
    
    public static final O166 u(final O166 o166, final Quaternion quaternion) {
        o166.j += quaternion.x;
        o166.e += quaternion.y;
        o166.h += quaternion.z;
        o166.s += quaternion.w;
        return o166;
    }
    
    public static final float t(final O166 o166, final Quaternion quaternion) {
        return o166.j * quaternion.x + o166.e * quaternion.y + o166.h * quaternion.z + o166.s * quaternion.w;
    }
    
    public static final float m(final O166 o166, final O166 o167) {
        return o166.j * o167.j + o166.e * o167.e + o166.h * o167.h + o166.s * o167.s;
    }
    
    public static final float n(final O166 o166) {
        return (float)Math.sqrt(m(o166, o166));
    }
    
    public static final O166 o(final O166 o166, final Quaternion quaternion) {
        b(o166, o166.s * quaternion.x + o166.j * quaternion.w + o166.e * quaternion.z - o166.h * quaternion.y, o166.s * quaternion.y - o166.j * quaternion.z + o166.e * quaternion.w + o166.h * quaternion.x, o166.s * quaternion.z + o166.j * quaternion.y - o166.e * quaternion.x + o166.h * quaternion.w, o166.s * quaternion.w - o166.j * quaternion.x - o166.e * quaternion.y - o166.h * quaternion.z);
        return o166;
    }
    
    public static final O166 a(final O166 o166, final float n) {
        o166.j *= n;
        o166.e *= n;
        o166.h *= n;
        o166.s *= n;
        return o166;
    }
    
    public static final O166 z(final O166 o166, final Quaternion quaternion, final float n) {
        o166.j += quaternion.x * n;
        o166.e += quaternion.y * n;
        o166.h += quaternion.z * n;
        o166.s += quaternion.w * n;
        return o166;
    }
    
    @Override
    public String toString() {
        return this.j + "," + this.e + "," + this.h + "," + this.s;
    }
    
    public static O166 b(final O166 o166, final float j, final float e, final float h, final float s) {
        o166.j = j;
        o166.e = e;
        o166.h = h;
        o166.s = s;
        return o166;
    }
    
    public Quaternion ag() {
        return new Quaternion(this.j, this.e, this.h, this.s);
    }
    
    static {
        O166.g = new O166[0];
    }
    
    public static O166 h(final O166 o166, final Quaternion quaternion) {
        o166.j = quaternion.x;
        o166.e = quaternion.y;
        o166.h = quaternion.z;
        o166.s = quaternion.w;
        return o166;
    }
    
    public static void g(final int d) {
        O166.d = d;
        O166.g = new O166[d];
        O166.q = 0;
    }
    
    public O166(final float n, final float n2, final float n3, final float n4) {
        b(this, n, n2, n3, n4);
    }
    
    public static final O166 p(final O166 o166) {
        o166.j = -o166.j;
        o166.e = -o166.e;
        o166.h = -o166.h;
        return o166;
    }
    
    public O166(final float n, final float n2, final float n3) {
        r(this, n, n2, n3);
    }
    
    public static final O166 f(final O166 o166, final Quaternion quaternion, final float n) {
        if (t(o166, quaternion) < 0.0f) {
            y(o166);
        }
        a(o166, 1.0f - n);
        u(o166, quaternion.y(n));
        x(o166);
        return o166;
    }
}
