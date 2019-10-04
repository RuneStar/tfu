/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.G300;
import com.jagex.maths.O166;
import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;
import tfu.Gg3;
import tfu.Kl267;
import tfu.Lp301;

public final class I48
implements G300,
Lp301,
Kl267 {
    private static int d;
    private static I48[] g;
    private static int q;
    public float e;
    public float h;
    public float j;

    public static I48 d() {
        I48[] arri48 = g;
        synchronized (arri48) {
            if (q == 0) {
                return new I48();
            }
            I48.z(g[--q]);
            return g[q];
        }
    }

    public static I48 w(float f, float f2, float f3) {
        I48[] arri48 = g;
        synchronized (arri48) {
            if (q == 0) {
                return new I48(f, f2, f3);
            }
            I48.p(g[--q], f, f2, f3);
            return g[q];
        }
    }

    public static I48 u(I48 i48, I48 i482) {
        I48.p(i48, i482.j, i482.e, i482.h);
        return i48;
    }

    public static I48 v(I48 i48) {
        I48[] arri48 = g;
        synchronized (arri48) {
            if (q == 0) {
                return new I48(i48);
            }
            I48.u(g[--q], i48);
            return g[q];
        }
    }

    public static void y(I48 i48) {
        I48[] arri48 = g;
        synchronized (arri48) {
            if (q < d - 1) {
                I48.g[I48.q++] = i48;
            }
        }
    }

    public I48(float f, float f2, float f3) {
        this.j = f;
        this.e = f2;
        this.h = f3;
    }

    public I48(Vector3 vector3) {
        this.j = vector3.x;
        this.e = vector3.y;
        this.h = vector3.z;
    }

    public I48(Gg3 gg3, int n) {
        float f = (float)Math.pow(10.0, n);
        this.j = (float)Gg3.by(gg3) / f;
        this.e = (float)Gg3.by(gg3) / f;
        this.h = (float)Gg3.by(gg3) / f;
    }

    public static I48 p(I48 i48, float f, float f2, float f3) {
        i48.j = f;
        i48.e = f2;
        i48.h = f3;
        return i48;
    }

    public static I48 x(I48 i48, Vector3 vector3) {
        I48.p(i48, vector3.x, vector3.y, vector3.z);
        return i48;
    }

    public static final float ag(I48 i48) {
        return i48.j * i48.j + i48.e * i48.e + i48.h * i48.h;
    }

    public static final I48 z(I48 i48) {
        i48.h = 0.0f;
        i48.e = 0.0f;
        i48.j = 0.0f;
        return i48;
    }

    public static final I48 k(I48 i48, I48 i482) {
        i48.j += i482.j;
        i48.e += i482.e;
        i48.h += i482.h;
        return i48;
    }

    public static final I48 i(I48 i48, float f, float f2, float f3) {
        i48.j += f;
        i48.e += f2;
        i48.h += f3;
        return i48;
    }

    public String toString() {
        return String.format("{Vector 3: %f,%f,%f}", Float.valueOf(this.j), Float.valueOf(this.e), Float.valueOf(this.h));
    }

    public static final I48 a(I48 i48, I48 i482) {
        i48.j -= i482.j;
        i48.e -= i482.e;
        i48.h -= i482.h;
        return i48;
    }

    public static I48 r(Vector3 vector3) {
        I48[] arri48 = g;
        synchronized (arri48) {
            if (q == 0) {
                return new I48(vector3);
            }
            I48.x(g[--q], vector3);
            return g[q];
        }
    }

    public static void g(int n) {
        d = n;
        g = new I48[n];
        q = 0;
    }

    public static final I48 aq(I48 i48, float f) {
        i48.j *= f;
        i48.e *= f;
        i48.h *= f;
        return i48;
    }

    public static final I48 al(I48 i48, Quaternion quaternion) {
        Quaternion quaternion2 = Quaternion.g(i48.j, i48.e, i48.h, 0.0f);
        Quaternion quaternion3 = quaternion.s();
        O166 o166 = O166.j(quaternion3);
        O166.k(o166, quaternion2);
        O166.k(o166, quaternion);
        I48.p(i48, o166.j, o166.e, o166.h);
        O166.e(o166);
        return i48;
    }

    public static final I48 af(I48 i48, O166 o166) {
        O166 o1662 = O166.q(i48.j, i48.e, i48.h, 0.0f);
        O166 o1663 = O166.i(O166.p(o166.c()), o1662);
        O166.i(o1663, o166);
        I48.p(i48, o1663.j, o1663.e, o1663.h);
        O166.e(o1662);
        O166.e(o1663);
        return i48;
    }

    public static final I48 av(I48 i48, Vector3 vector3, float f) {
        I48.aq(i48, 1.0f - f);
        I48.n(i48, Vector3.ai(vector3, f));
        return i48;
    }

    public I48(Gg3 gg3) {
        this.j = Gg3.bl(gg3);
        this.e = Gg3.bl(gg3);
        this.h = Gg3.bl(gg3);
    }

    @Override
    public Vector3 j() {
        return this.ao();
    }

    public static I48 ap(I48 i48) {
        return I48.v(i48);
    }

    public Vector3 ao() {
        return new Vector3(this.j, this.e, this.h);
    }

    static {
        g = new I48[0];
    }

    public static final float c(I48 i48) {
        return (float)Math.sqrt(I48.ag(i48));
    }

    public static final I48 o(I48 i48, Vector3 vector3) {
        i48.j -= vector3.x;
        i48.e -= vector3.y;
        i48.h -= vector3.z;
        return i48;
    }

    public static final I48 m(I48 i48) {
        float f = 1.0f / I48.c(i48);
        i48.j *= f;
        i48.e *= f;
        i48.h *= f;
        return i48;
    }

    public static final I48 ai(I48 i48, float f) {
        i48.j /= f;
        i48.e /= f;
        i48.h /= f;
        return i48;
    }

    @Override
    public Vector3 e() {
        return this.ao();
    }

    public I48(I48 i48) {
        this.j = i48.j;
        this.e = i48.e;
        this.h = i48.h;
    }

    public static final I48 n(I48 i48, Vector3 vector3) {
        i48.j += vector3.x;
        i48.e += vector3.y;
        i48.h += vector3.z;
        return i48;
    }

    public I48() {
    }

    public static final I48 t(I48 i48) {
        i48.j = -i48.j;
        i48.e = -i48.e;
        i48.h = -i48.h;
        return i48;
    }

    public static final I48 f(I48 i48, Vector3 vector3, float f) {
        i48.j -= vector3.x * f;
        i48.e -= vector3.y * f;
        i48.h -= vector3.z * f;
        return i48;
    }
}

