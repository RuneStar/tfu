/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.G300;
import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;
import tfu.Gg3;

public final class O166
implements G300 {
    private static int d;
    private static O166[] g;
    private static int q;
    public float e;
    public float h;
    public float j;
    public float s;

    public O166(Gg3 gg3) {
        this.j = Gg3.bl(gg3);
        this.e = Gg3.bl(gg3);
        this.h = Gg3.bl(gg3);
        this.s = Gg3.bl(gg3);
    }

    public static O166 d() {
        O166[] arro166 = g;
        synchronized (arro166) {
            if (q == 0) {
                return new O166();
            }
            O166.v(g[--q]);
            return g[q];
        }
    }

    public static O166 q(float f, float f2, float f3, float f4) {
        O166[] arro166 = g;
        synchronized (arro166) {
            if (q == 0) {
                return new O166(f, f2, f3, f4);
            }
            O166.b(g[--q], f, f2, f3, f4);
            return g[q];
        }
    }

    public static O166 j(Quaternion quaternion) {
        O166[] arro166 = g;
        synchronized (arro166) {
            if (q == 0) {
                return new O166(quaternion);
            }
            O166.h(g[--q], quaternion);
            return g[q];
        }
    }

    public static void e(O166 o166) {
        O166[] arro166 = g;
        synchronized (arro166) {
            if (q < d - 1) {
                O166.g[O166.q++] = o166;
            }
        }
    }

    public O166 c() {
        return new O166(this);
    }

    public static final O166 k(O166 o166, Quaternion quaternion) {
        O166.b(o166, quaternion.w * o166.j + quaternion.x * o166.s + quaternion.y * o166.h - quaternion.z * o166.e, quaternion.w * o166.e - quaternion.x * o166.h + quaternion.y * o166.s + quaternion.z * o166.j, quaternion.w * o166.h + quaternion.x * o166.e - quaternion.y * o166.j + quaternion.z * o166.s, quaternion.w * o166.s - quaternion.x * o166.j - quaternion.y * o166.e - quaternion.z * o166.h);
        return o166;
    }

    public O166(O166 o166) {
        O166.s(this, o166);
    }

    public O166(Quaternion quaternion) {
        O166.h(this, quaternion);
    }

    public static O166 s(O166 o166, O166 o1662) {
        o166.j = o1662.j;
        o166.e = o1662.e;
        o166.h = o1662.h;
        o166.s = o1662.s;
        return o166;
    }

    public static O166 l(O166 o166, Vector3 vector3, float f) {
        O166.w(o166, vector3.x, vector3.y, vector3.z, f);
        return o166;
    }

    public static O166 w(O166 o166, float f, float f2, float f3, float f4) {
        float f5 = (float)Math.sin(f4 * 0.5f);
        float f6 = (float)Math.cos(f4 * 0.5f);
        o166.j = f * f5;
        o166.e = f2 * f5;
        o166.h = f3 * f5;
        o166.s = f6;
        return o166;
    }

    public static O166 r(O166 o166, float f, float f2, float f3) {
        O166.l(o166, Vector3.g(0.0f, 1.0f, 0.0f), f);
        O166 o1662 = O166.d();
        O166.l(o1662, Vector3.g(1.0f, 0.0f, 0.0f), f2);
        O166.i(o166, o1662);
        O166.l(o1662, Vector3.g(0.0f, 0.0f, 1.0f), f3);
        O166.i(o166, o1662);
        O166.e(o1662);
        return o166;
    }

    public static final O166 v(O166 o166) {
        o166.h = 0.0f;
        o166.e = 0.0f;
        o166.j = 0.0f;
        o166.s = 1.0f;
        return o166;
    }

    public static final O166 y(O166 o166) {
        o166.j = -o166.j;
        o166.e = -o166.e;
        o166.h = -o166.h;
        o166.s = -o166.s;
        return o166;
    }

    public O166() {
        O166.v(this);
    }

    public static final O166 x(O166 o166) {
        float f = 1.0f / O166.n(o166);
        o166.j *= f;
        o166.e *= f;
        o166.h *= f;
        o166.s *= f;
        return o166;
    }

    public static final O166 i(O166 o166, O166 o1662) {
        O166.b(o166, o1662.s * o166.j + o1662.j * o166.s + o1662.e * o166.h - o1662.h * o166.e, o1662.s * o166.e - o1662.j * o166.h + o1662.e * o166.s + o1662.h * o166.j, o1662.s * o166.h + o1662.j * o166.e - o1662.e * o166.j + o1662.h * o166.s, o1662.s * o166.s - o1662.j * o166.j - o1662.e * o166.e - o1662.h * o166.h);
        return o166;
    }

    public static final O166 u(O166 o166, Quaternion quaternion) {
        o166.j += quaternion.x;
        o166.e += quaternion.y;
        o166.h += quaternion.z;
        o166.s += quaternion.w;
        return o166;
    }

    public static final float t(O166 o166, Quaternion quaternion) {
        return o166.j * quaternion.x + o166.e * quaternion.y + o166.h * quaternion.z + o166.s * quaternion.w;
    }

    public static final float m(O166 o166, O166 o1662) {
        return o166.j * o1662.j + o166.e * o1662.e + o166.h * o1662.h + o166.s * o1662.s;
    }

    public static final float n(O166 o166) {
        return (float)Math.sqrt(O166.m(o166, o166));
    }

    public static final O166 o(O166 o166, Quaternion quaternion) {
        O166.b(o166, o166.s * quaternion.x + o166.j * quaternion.w + o166.e * quaternion.z - o166.h * quaternion.y, o166.s * quaternion.y - o166.j * quaternion.z + o166.e * quaternion.w + o166.h * quaternion.x, o166.s * quaternion.z + o166.j * quaternion.y - o166.e * quaternion.x + o166.h * quaternion.w, o166.s * quaternion.w - o166.j * quaternion.x - o166.e * quaternion.y - o166.h * quaternion.z);
        return o166;
    }

    public static final O166 a(O166 o166, float f) {
        o166.j *= f;
        o166.e *= f;
        o166.h *= f;
        o166.s *= f;
        return o166;
    }

    public static final O166 z(O166 o166, Quaternion quaternion, float f) {
        o166.j += quaternion.x * f;
        o166.e += quaternion.y * f;
        o166.h += quaternion.z * f;
        o166.s += quaternion.w * f;
        return o166;
    }

    public String toString() {
        return this.j + "," + this.e + "," + this.h + "," + this.s;
    }

    public static O166 b(O166 o166, float f, float f2, float f3, float f4) {
        o166.j = f;
        o166.e = f2;
        o166.h = f3;
        o166.s = f4;
        return o166;
    }

    public Quaternion ag() {
        return new Quaternion(this.j, this.e, this.h, this.s);
    }

    static {
        g = new O166[0];
    }

    public static O166 h(O166 o166, Quaternion quaternion) {
        o166.j = quaternion.x;
        o166.e = quaternion.y;
        o166.h = quaternion.z;
        o166.s = quaternion.w;
        return o166;
    }

    public static void g(int n) {
        d = n;
        g = new O166[n];
        q = 0;
    }

    public O166(float f, float f2, float f3, float f4) {
        O166.b(this, f, f2, f3, f4);
    }

    public static final O166 p(O166 o166) {
        o166.j = -o166.j;
        o166.e = -o166.e;
        o166.h = -o166.h;
        return o166;
    }

    public O166(float f, float f2, float f3) {
        O166.r(this, f, f2, f3);
    }

    public static final O166 f(O166 o166, Quaternion quaternion, float f) {
        if (O166.t(o166, quaternion) < 0.0f) {
            O166.y(o166);
        }
        O166.a(o166, 1.0f - f);
        Quaternion quaternion2 = quaternion.y(f);
        O166.u(o166, quaternion2);
        O166.x(o166);
        return o166;
    }
}

