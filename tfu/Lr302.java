/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;

public class Lr302 {
    public static final int b = 8;
    public static final int d = 100000;
    public static final int e = 1;
    public static final int g = -1000;
    public static final int h = 2;
    public static final int j = 256;
    public static final int l = 16;
    public static int q = 2;
    public static final int s = 4;
    public static final int w = 32;

    public static float g(Quaternion quaternion) {
        Vector3 vector3 = Vector3.g(0.0f, 0.0f, 1.0f);
        vector3 = Vector3.al(vector3, quaternion);
        double d = Math.atan2(vector3.x, vector3.z);
        if (d < 0.0) {
            d = 3.141592653589793 + (3.141592653589793 + d);
        }
        return (float)d;
    }

    public static Quaternion d(float f) {
        if (f >= -100.0f && f <= 100.0f) {
            return Quaternion.e(0.0f, 1.0f, 0.0f, f);
        }
        return Quaternion.g;
    }
}

