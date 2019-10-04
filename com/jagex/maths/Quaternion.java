/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.maths;

import com.jagex.maths.B164;
import com.jagex.maths.I48;
import com.jagex.maths.M47;
import com.jagex.maths.O166;
import com.jagex.maths.Vector3;
import tfu.Be2;
import tfu.Bs1;
import tfu.Gg3;

@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public final class Quaternion
implements B164 {
    public static final Quaternion g = new Quaternion(0.0f, 0.0f, 0.0f, 1.0f);
    public final float w;
    public final float x;
    public final float y;
    public final float z;

    public boolean equals(Object object) {
        if (object instanceof O166) {
            return Quaternion.z(this, (O166)object);
        }
        return Quaternion.u(this, (Quaternion)object);
    }

    public static Quaternion d(Gg3 gg3) {
        return new Quaternion(gg3);
    }

    public static Quaternion e(float f, float f2, float f3, float f4) {
        float f5 = (float)Math.sin(f4 * 0.5f);
        float f6 = (float)Math.cos(f4 * 0.5f);
        return new Quaternion(f * f5, f2 * f5, f3 * f5, f6);
    }

    public static boolean z(Quaternion quaternion, O166 o166) {
        return o166 != null && Float.floatToIntBits(quaternion.x) == Float.floatToIntBits(o166.j) && Float.floatToIntBits(quaternion.y) == Float.floatToIntBits(o166.e) && Float.floatToIntBits(quaternion.z) == Float.floatToIntBits(o166.h) && Float.floatToIntBits(quaternion.w) == Float.floatToIntBits(o166.s);
    }

    public static void q(Quaternion quaternion, Gg3 gg3) {
        Gg3.aq(gg3, quaternion.x);
        Gg3.aq(gg3, quaternion.y);
        Gg3.aq(gg3, quaternion.z);
        Gg3.aq(gg3, quaternion.w);
    }

    public static Quaternion j(Vector3 vector3, float f) {
        return Quaternion.e(vector3.x, vector3.y, vector3.z, f);
    }

    public static Quaternion g(float f, float f2, float f3, float f4) {
        return new Quaternion(f, f2, f3, f4);
    }

    public static Quaternion h(float f, float f2, float f3) {
        O166 o166 = new O166();
        O166.l(o166, Vector3.g(0.0f, 1.0f, 0.0f), f);
        O166 o1662 = O166.d();
        O166.l(o1662, Vector3.g(1.0f, 0.0f, 0.0f), f2);
        O166.i(o166, o1662);
        O166.l(o1662, Vector3.g(0.0f, 0.0f, 1.0f), f3);
        O166.i(o166, o1662);
        O166.e(o1662);
        return o166.ag();
    }

    public final Quaternion b() {
        float f = 1.0f / Quaternion.w(this);
        return new Quaternion(this.x * f, this.y * f, this.z * f, this.w * f);
    }

    public final Quaternion s() {
        return new Quaternion(-this.x, -this.y, -this.z, this.w);
    }

    public static final float w(Quaternion quaternion) {
        return (float)Math.sqrt(Quaternion.l(quaternion, quaternion));
    }

    public final Quaternion r(Quaternion quaternion) {
        return new Quaternion(quaternion.w * this.x + quaternion.x * this.w + quaternion.y * this.z - quaternion.z * this.y, quaternion.w * this.y - quaternion.x * this.z + quaternion.y * this.w + quaternion.z * this.x, quaternion.w * this.z + quaternion.x * this.y - quaternion.y * this.x + quaternion.z * this.w, quaternion.w * this.w - quaternion.x * this.x - quaternion.y * this.y - quaternion.z * this.z);
    }

    public final Quaternion p(Quaternion quaternion, float f) {
        O166 o166 = new O166(this);
        if (O166.t(o166, quaternion) < 0.0f) {
            O166.y(o166);
        }
        O166.a(o166, 1.0f - f);
        O166.z(o166, quaternion, f);
        O166.x(o166);
        return o166.ag();
    }

    public Vector3 x() {
        float f = this.w;
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < -1.0f) {
            f = -1.0f;
        }
        float f2 = (float)(Math.acos(f) * 2.0);
        if (f2 == 0.0f) {
            return Vector3.g;
        }
        I48 i48 = new I48(this.x, this.y, this.z);
        if (this.x != 0.0f || this.y != 0.0f || this.z != 0.0f) {
            I48.m(i48);
            I48.aq(i48, f2);
        }
        return i48.ao();
    }

    public int hashCode() {
        return Float.floatToIntBits(this.x) + Float.floatToIntBits(this.y) + Float.floatToIntBits(this.z) + Float.floatToIntBits(this.w);
    }

    public M47 m() {
        float f = this.w * this.w;
        float f2 = this.w * this.x;
        float f3 = this.w * this.y;
        float f4 = this.w * this.z;
        float f5 = this.x * this.x;
        float f6 = this.x * this.y;
        float f7 = this.x * this.z;
        float f8 = this.y * this.y;
        float f9 = this.y * this.z;
        float f10 = this.z * this.z;
        M47 m47 = new M47(f5 + f - f10 - f8, f6 + f4 + f6 + f4, f7 - f3 - f3 + f7, f6 - f4 - f4 + f6, f8 + f - f5 - f10, f9 + f2 + f9 + f2, f7 + f3 + f7 + f3, f9 - f2 - f2 + f9, f10 + f - f8 - f5);
        return m47;
    }

    public static boolean u(Quaternion quaternion, Quaternion quaternion2) {
        return quaternion2 != null && Float.floatToIntBits(quaternion.x) == Float.floatToIntBits(quaternion2.x) && Float.floatToIntBits(quaternion.y) == Float.floatToIntBits(quaternion2.y) && Float.floatToIntBits(quaternion.z) == Float.floatToIntBits(quaternion2.z) && Float.floatToIntBits(quaternion.w) == Float.floatToIntBits(quaternion2.w);
    }

    public Quaternion(Gg3 gg3) {
        this.x = Gg3.bl(gg3);
        this.y = Gg3.bl(gg3);
        this.z = Gg3.bl(gg3);
        this.w = Gg3.bl(gg3);
    }

    public String toString() {
        return String.format("{ Quaternion: %.3f,%.3f,%.3f,%.3f }", Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.z), Float.valueOf(this.w));
    }

    public final Quaternion y(float f) {
        return new Quaternion(this.x * f, this.y * f, this.z * f, this.w * f);
    }

    @Bs1
    @Be2
    public Quaternion(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.w = f4;
    }

    public static final float l(Quaternion quaternion, Quaternion quaternion2) {
        return quaternion.x * quaternion2.x + quaternion.y * quaternion2.y + quaternion.z * quaternion2.z + quaternion.w * quaternion2.w;
    }

    public final Quaternion v(Quaternion quaternion) {
        return new Quaternion(this.w * quaternion.x + this.x * quaternion.w + this.y * quaternion.z - this.z * quaternion.y, this.w * quaternion.y - this.x * quaternion.z + this.y * quaternion.w + this.z * quaternion.x, this.w * quaternion.z + this.x * quaternion.y - this.y * quaternion.x + this.z * quaternion.w, this.w * quaternion.w - this.x * quaternion.x - this.y * quaternion.y - this.z * quaternion.z);
    }

    public static boolean t(Quaternion quaternion, Quaternion quaternion2, float f) {
        if (quaternion2.x - quaternion.x > f || quaternion2.x - quaternion.x < -f) {
            return false;
        }
        if (quaternion2.y - quaternion.y > f || quaternion2.y - quaternion.y < -f) {
            return false;
        }
        if (quaternion2.z - quaternion.z > f || quaternion2.z - quaternion.z < -f) {
            return false;
        }
        return !(quaternion2.w - quaternion.w > f) && !(quaternion2.w - quaternion.w < -f);
    }
}

