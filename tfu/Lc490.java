/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.maths.Vector3;
import tfu.Lp301;

public class Lc490 {
    public static int g(Vector3 vector3, Vector3 vector32) {
        double d = vector32.x - vector3.x;
        double d2 = vector32.y - vector3.y;
        double d3 = vector32.z - vector3.z;
        return (int)Math.sqrt(d * d + d2 * d2 + d3 * d3);
    }

    public static int j(Lp301 lp301, Lp301 lp3012) {
        Vector3[] arrvector3 = Lc490.d(lp301, lp3012);
        if (arrvector3 == null) {
            return -1;
        }
        return Lc490.g(arrvector3[0], arrvector3[1]);
    }

    public static Vector3[] d(Lp301 lp301, Lp301 lp3012) {
        return Lc490.q(lp301.j(), lp301.e(), lp3012);
    }

    public static Vector3[] q(Vector3 vector3, Vector3 vector32, Lp301 lp301) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        Vector3 vector33 = lp301.j();
        Vector3 vector34 = lp301.e();
        boolean bl = false;
        if (vector33.x > vector32.x) {
            f2 = vector32.x;
            f = vector33.x;
        } else if (vector34.x < vector3.x) {
            f2 = vector3.x;
            f = vector34.x;
        } else {
            f2 = vector3.x >= vector33.x && vector3.x <= vector34.x ? (f = vector3.x) : (vector32.x >= vector33.x && vector32.x <= vector34.x ? (f = vector32.x) : (vector33.x >= vector3.x && vector33.x <= vector32.x ? (f = vector33.x) : (f = vector34.x)));
            bl = true;
        }
        boolean bl2 = false;
        if (vector33.y > vector32.y) {
            f6 = vector32.y;
            f4 = vector33.y;
        } else if (vector34.y < vector3.y) {
            f6 = vector3.y;
            f4 = vector34.y;
        } else {
            f6 = vector3.y >= vector33.y && vector3.y <= vector34.y ? (f4 = vector3.y) : (vector32.y >= vector33.y && vector32.y <= vector34.y ? (f4 = vector32.y) : (vector33.y >= vector3.y && vector33.y <= vector32.y ? (f4 = vector33.y) : (f4 = vector34.y)));
            bl2 = true;
        }
        boolean bl3 = false;
        if (vector33.z > vector32.z) {
            f3 = vector32.z;
            f5 = vector33.z;
        } else if (vector34.z < vector3.z) {
            f3 = vector3.z;
            f5 = vector34.z;
        } else {
            f3 = vector3.z >= vector33.z && vector3.z <= vector34.z ? (f5 = vector3.z) : (vector32.z >= vector33.z && vector32.z <= vector34.z ? (f5 = vector32.z) : (vector33.z >= vector3.z && vector33.z <= vector32.z ? (f5 = vector33.z) : (f5 = vector34.z)));
            bl3 = true;
        }
        if (bl && bl2 && bl3) {
            return null;
        }
        return new Vector3[]{Vector3.g(f2, f6, f3), Vector3.g(f, f4, f5)};
    }
}

