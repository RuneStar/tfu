/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.math;

import com.jagex.math.D99;
import tfu.Be2;
import tfu.Bs1;
import tfu.Gg3;
import tfu.Kl267;
import tfu.Kn266;

@Deprecated
@Bs1
@Be2
@Bs1
@Be2
@Bs1
@Be2
public class Vector3
implements D99,
Kn266,
Kl267 {
    private static Vector3[] d;
    public static final Vector3 g;
    private static int j;
    private static int q;
    public float x;
    public float y;
    public float z;

    public Vector3(Gg3 gg3, int n) {
        float f = (float)Math.pow(10.0, n);
        this.x = (float)Gg3.by(gg3) / f;
        this.y = (float)Gg3.by(gg3) / f;
        this.z = (float)Gg3.by(gg3) / f;
    }

    public static Vector3 d(Vector3 vector3) {
        Vector3[] arrvector3 = d;
        synchronized (arrvector3) {
            if (j == 0) {
                return new Vector3(vector3);
            }
            Vector3.e(d[--j], vector3);
            return d[j];
        }
    }

    @Bs1
    @Be2
    public Vector3(float f, float f2, float f3) {
        this.x = f;
        this.y = f2;
        this.z = f3;
    }

    public Vector3(Vector3 vector3) {
        this.x = vector3.x;
        this.y = vector3.y;
        this.z = vector3.z;
    }

    public static void j(Vector3 vector3, float f, float f2, float f3) {
        vector3.x = f;
        vector3.y = f2;
        vector3.z = f3;
    }

    public static void e(Vector3 vector3, Vector3 vector32) {
        Vector3.j(vector3, vector32.x, vector32.y, vector32.z);
    }

    public Vector3() {
    }

    public static Vector3 h(Vector3 vector3) {
        return Vector3.d(vector3);
    }

    static {
        g = new Vector3(0.0f, 0.0f, 0.0f);
        d = new Vector3[0];
    }

    public static Vector3 g(float f, float f2, float f3) {
        Vector3[] arrvector3 = d;
        synchronized (arrvector3) {
            if (j == 0) {
                return new Vector3(f, f2, f3);
            }
            Vector3.j(d[--j], f, f2, f3);
            return d[j];
        }
    }

    public Vector3(Gg3 gg3) {
        this.x = Gg3.bl(gg3);
        this.y = Gg3.bl(gg3);
        this.z = Gg3.bl(gg3);
    }

    public String toString() {
        return String.format("{Vector 3: %f,%f,%f}", Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.z));
    }
}

