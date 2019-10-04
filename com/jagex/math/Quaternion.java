/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.math;

import com.jagex.math.D99;
import com.jagex.math.Vector3;
import tfu.Be2;
import tfu.Bs1;
import tfu.Gg3;

@Deprecated
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public final class Quaternion
implements D99 {
    private static int d;
    private static Quaternion[] g;
    public static final Quaternion j;
    private static int q;
    public float w;
    public float x;
    public float y;
    public float z;

    public static Quaternion g() {
        Quaternion[] arrquaternion = g;
        synchronized (arrquaternion) {
            if (q == 0) {
                return new Quaternion();
            }
            Quaternion.b(g[--q]);
            return g[q];
        }
    }

    public static void d(Quaternion quaternion) {
        Quaternion[] arrquaternion = g;
        synchronized (arrquaternion) {
            if (q < d - 1) {
                Quaternion.g[Quaternion.q++] = quaternion;
            }
        }
    }

    public Quaternion(Quaternion quaternion) {
        Quaternion.q(this, quaternion);
    }

    public static void s(Quaternion quaternion, float f, float f2, float f3) {
        Quaternion.e(quaternion, Vector3.g(0.0f, 1.0f, 0.0f), f);
        Quaternion quaternion2 = Quaternion.g();
        Quaternion.e(quaternion2, Vector3.g(1.0f, 0.0f, 0.0f), f2);
        Quaternion.l(quaternion, quaternion2);
        Quaternion.e(quaternion2, Vector3.g(0.0f, 0.0f, 1.0f), f3);
        Quaternion.l(quaternion, quaternion2);
        Quaternion.d(quaternion2);
    }

    public Quaternion(Gg3 gg3) {
        this.x = Gg3.bl(gg3);
        this.y = Gg3.bl(gg3);
        this.z = Gg3.bl(gg3);
        this.w = Gg3.bl(gg3);
    }

    public static void q(Quaternion quaternion, Quaternion quaternion2) {
        quaternion.x = quaternion2.x;
        quaternion.y = quaternion2.y;
        quaternion.z = quaternion2.z;
        quaternion.w = quaternion2.w;
    }

    public static void j(Quaternion quaternion, float f, float f2, float f3, float f4) {
        quaternion.x = f;
        quaternion.y = f2;
        quaternion.z = f3;
        quaternion.w = f4;
    }

    public static void h(Quaternion quaternion, float f, float f2, float f3, float f4) {
        float f5 = (float)Math.sin(f4 * 0.5f);
        float f6 = (float)Math.cos(f4 * 0.5f);
        quaternion.x = f * f5;
        quaternion.y = f2 * f5;
        quaternion.z = f3 * f5;
        quaternion.w = f6;
    }

    public static final void b(Quaternion quaternion) {
        quaternion.z = 0.0f;
        quaternion.y = 0.0f;
        quaternion.x = 0.0f;
        quaternion.w = 1.0f;
    }

    public static final void l(Quaternion quaternion, Quaternion quaternion2) {
        Quaternion.j(quaternion, quaternion2.w * quaternion.x + quaternion2.x * quaternion.w + quaternion2.y * quaternion.z - quaternion2.z * quaternion.y, quaternion2.w * quaternion.y - quaternion2.x * quaternion.z + quaternion2.y * quaternion.w + quaternion2.z * quaternion.x, quaternion2.w * quaternion.z + quaternion2.x * quaternion.y - quaternion2.y * quaternion.x + quaternion2.z * quaternion.w, quaternion2.w * quaternion.w - quaternion2.x * quaternion.x - quaternion2.y * quaternion.y - quaternion2.z * quaternion.z);
    }

    public String toString() {
        return this.x + "," + this.y + "," + this.z + "," + this.w;
    }

    static {
        g = new Quaternion[0];
        j = new Quaternion();
    }

    public Quaternion(float f, float f2, float f3) {
        Quaternion.s(this, f, f2, f3);
    }

    @Bs1
    @Be2
    public Quaternion(float f, float f2, float f3, float f4) {
        Quaternion.j(this, f, f2, f3, f4);
    }

    public static void e(Quaternion quaternion, Vector3 vector3, float f) {
        Quaternion.h(quaternion, vector3.x, vector3.y, vector3.z, f);
    }

    public Quaternion() {
        Quaternion.b(this);
    }
}

