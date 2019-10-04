/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.B164;
import com.jagex.maths.I48;
import com.jagex.maths.M47;
import com.jagex.maths.O166;
import com.jagex.maths.Quaternion;
import tfu.Be2;
import tfu.Bs1;
import tfu.Gg3;
import tfu.Kl267;
import tfu.Lp301;

@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public final class Vector3
implements B164,
Lp301,
Kl267 {
    public static final Vector3 d;
    public static final Vector3 e;
    public static final Vector3 g;
    public static final Vector3 j;
    public static final Vector3 q;
    public final float x;
    public final float y;
    public final float z;

    public static Vector3 d(Gg3 gg3) {
        return new Vector3(gg3);
    }

    @Bs1
    @Be2
    public Vector3(float f, float f2, float f3) {
        this.x = f;
        this.y = f2;
        this.z = f3;
    }

    public Vector3(Gg3 gg3) {
        this.x = Gg3.bl(gg3);
        this.y = Gg3.bl(gg3);
        this.z = Gg3.bl(gg3);
    }

    public static Vector3 g(float f, float f2, float f3) {
        return new Vector3(f, f2, f3);
    }

    public static int r(Vector3 vector3) {
        return 12;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.x) + Float.floatToIntBits(this.y) + Float.floatToIntBits(this.z);
    }

    public static void w(Vector3 vector3, Gg3 gg3) {
        Gg3.aq(gg3, vector3.x);
        Gg3.aq(gg3, vector3.y);
        Gg3.aq(gg3, vector3.z);
    }

    public static boolean v(Vector3 vector3, Vector3 vector32) {
        return vector32 != null && Float.floatToIntBits(vector3.x) == Float.floatToIntBits(vector32.x) && Float.floatToIntBits(vector3.y) == Float.floatToIntBits(vector32.y) && Float.floatToIntBits(vector3.z) == Float.floatToIntBits(vector32.z);
    }

    public static final Vector3 k(Vector3 vector3, Vector3 vector32) {
        return Vector3.g(vector3.x - vector32.x, vector3.y - vector32.y, vector3.z - vector32.z);
    }

    public static boolean p(Vector3 vector3, Vector3 vector32, float f) {
        return Math.abs(vector32.x - vector3.x) <= f && Math.abs(vector32.y - vector3.y) <= f && Math.abs(vector32.z - vector3.z) <= f;
    }

    public static final Vector3 u(Vector3 vector3) {
        float f = 1.0f / Vector3.f(vector3);
        return Vector3.g(vector3.x * f, vector3.y * f, vector3.z * f);
    }

    public static final Vector3 z(Vector3 vector3, Vector3 vector32) {
        return Vector3.g(vector3.x + vector32.x, vector3.y + vector32.y, vector3.z + vector32.z);
    }

    public static final Vector3 m(Vector3 vector3, float f, float f2, float f3) {
        return Vector3.g(vector3.x + f, vector3.y + f2, vector3.z + f3);
    }

    public static final Vector3 n(Vector3 vector3, Vector3 vector32, float f) {
        return Vector3.g(vector3.x + vector32.x * f, vector3.y + vector32.y * f, vector3.z + vector32.z * f);
    }

    public Vector3 ao() {
        return new Vector3(-this.x, this.y, -this.z);
    }

    public static final Vector3 i(Vector3 vector3, float f, float f2, float f3) {
        return Vector3.g(vector3.x - f, vector3.y - f2, vector3.z - f3);
    }

    public static final float o(Vector3 vector3, Vector3 vector32) {
        return vector3.x * vector32.x + vector3.y * vector32.y + vector3.z * vector32.z;
    }

    public static Vector3 ap(Vector3 vector3) {
        return vector3;
    }

    public Vector3 an(float f) {
        return new Vector3(this.x, f, this.z);
    }

    public static final float c(Vector3 vector3) {
        return vector3.x * vector3.x + vector3.y * vector3.y + vector3.z * vector3.z;
    }

    public static float ag(Vector3 vector3, Vector3 vector32) {
        float f = vector32.x - vector3.x;
        float f2 = vector32.y - vector3.y;
        float f3 = vector32.z - vector3.z;
        return (float)Math.sqrt(f * f + f2 * f2 + f3 * f3);
    }

    public static final Vector3 ai(Vector3 vector3, float f) {
        return Vector3.g(vector3.x * f, vector3.y * f, vector3.z * f);
    }

    public static final Vector3 al(Vector3 vector3, Quaternion quaternion) {
        Quaternion quaternion2 = Quaternion.g(vector3.x, vector3.y, vector3.z, 0.0f);
        Quaternion quaternion3 = quaternion.s();
        O166 o166 = O166.j(quaternion3);
        O166.k(o166, quaternion2);
        O166.k(o166, quaternion);
        return Vector3.g(o166.j, o166.e, o166.h);
    }

    public static final Vector3 af(Vector3 vector3, M47 m47) {
        return Vector3.g(m47.f00 * vector3.x + m47.f10 * vector3.y + m47.f20 * vector3.z, m47.f01 * vector3.x + m47.f11 * vector3.y + m47.f21 * vector3.z, m47.f02 * vector3.x + m47.f12 * vector3.y + m47.f22 * vector3.z);
    }

    public static final Vector3 av(Vector3 vector3, Vector3 vector32, float f) {
        return Vector3.g(vector3.x + (vector32.x - vector3.x) * f, vector3.y + (vector32.y - vector3.y) * f, vector3.z + (vector32.z - vector3.z) * f);
    }

    public String toString() {
        return String.format("{ Vector3: %.3f,%.3f,%.3f }", Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.z));
    }

    @Override
    public Vector3 e() {
        return this;
    }

    @Override
    public Vector3 j() {
        return this;
    }

    public boolean equals(Object object) {
        if (object instanceof I48) {
            return Vector3.y(this, (I48)object);
        }
        return Vector3.v(this, (Vector3)object);
    }

    public Vector3(Gg3 gg3, int n) {
        float f = (float)Math.pow(10.0, n);
        this.x = (float)Gg3.by(gg3) / f;
        this.y = (float)Gg3.by(gg3) / f;
        this.z = (float)Gg3.by(gg3) / f;
    }

    public static final Vector3 t(Vector3 vector3, I48 i48) {
        return Vector3.g(vector3.x + i48.j, vector3.y + i48.e, vector3.z + i48.h);
    }

    public static float aq(Vector3 vector3, Vector3 vector32) {
        float f = vector32.x - vector3.x;
        float f2 = vector32.y - vector3.y;
        float f3 = vector32.z - vector3.z;
        return f * f + f2 * f2 + f3 * f3;
    }

    public static final Vector3 a(Vector3 vector3, Vector3 vector32) {
        return Vector3.g(vector3.y * vector32.z - vector3.z * vector32.y, vector3.z * vector32.x - vector3.x * vector32.z, vector3.x * vector32.y - vector3.y * vector32.x);
    }

    public Vector3 aa(float f) {
        return new Vector3(f, this.y, this.z);
    }

    public static boolean y(Vector3 vector3, I48 i48) {
        return i48 != null && Float.floatToIntBits(vector3.x) == Float.floatToIntBits(i48.j) && Float.floatToIntBits(vector3.y) == Float.floatToIntBits(i48.e) && Float.floatToIntBits(vector3.z) == Float.floatToIntBits(i48.h);
    }

    public static final Vector3 x(Vector3 vector3) {
        return Vector3.g(-vector3.x, -vector3.y, -vector3.z);
    }

    static {
        g = new Vector3(0.0f, 0.0f, 0.0f);
        d = new Vector3(1.0f, 0.0f, 0.0f);
        q = new Vector3(0.0f, 1.0f, 0.0f);
        j = new Vector3(0.0f, 0.0f, 1.0f);
        e = new Vector3(Float.NaN, Float.NaN, Float.NaN);
    }

    public static final float f(Vector3 vector3) {
        return (float)Math.sqrt(Vector3.c(vector3));
    }
}

