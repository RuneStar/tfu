// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.maths.Vector3;

public class Lc490
{
    public static int g(final Vector3 vector3, final Vector3 vector4) {
        final double n = vector4.x - vector3.x;
        final double n2 = vector4.y - vector3.y;
        final double n3 = vector4.z - vector3.z;
        return (int)Math.sqrt(n * n + n2 * n2 + n3 * n3);
    }
    
    public static int j(final Lp301 lp301, final Lp301 lp302) {
        final Vector3[] d = d(lp301, lp302);
        if (d == null) {
            return -1;
        }
        return g(d[0], d[1]);
    }
    
    public static Vector3[] d(final Lp301 lp301, final Lp301 lp302) {
        return q(lp301.j(), lp301.e(), lp302);
    }
    
    public static Vector3[] q(final Vector3 vector3, final Vector3 vector4, final Lp301 lp301) {
        final Vector3 j = lp301.j();
        final Vector3 e = lp301.e();
        boolean b = false;
        float n;
        float n2;
        if (j.x > vector4.x) {
            n = vector4.x;
            n2 = j.x;
        }
        else if (e.x < vector3.x) {
            n = vector3.x;
            n2 = e.x;
        }
        else {
            if (vector3.x >= j.x && vector3.x <= e.x) {
                n2 = (n = vector3.x);
            }
            else if (vector4.x >= j.x && vector4.x <= e.x) {
                n2 = (n = vector4.x);
            }
            else if (j.x >= vector3.x && j.x <= vector4.x) {
                n2 = (n = j.x);
            }
            else {
                n2 = (n = e.x);
            }
            b = true;
        }
        boolean b2 = false;
        float n3;
        float n4;
        if (j.y > vector4.y) {
            n3 = vector4.y;
            n4 = j.y;
        }
        else if (e.y < vector3.y) {
            n3 = vector3.y;
            n4 = e.y;
        }
        else {
            if (vector3.y >= j.y && vector3.y <= e.y) {
                n4 = (n3 = vector3.y);
            }
            else if (vector4.y >= j.y && vector4.y <= e.y) {
                n4 = (n3 = vector4.y);
            }
            else if (j.y >= vector3.y && j.y <= vector4.y) {
                n4 = (n3 = j.y);
            }
            else {
                n4 = (n3 = e.y);
            }
            b2 = true;
        }
        boolean b3 = false;
        float n5;
        float n6;
        if (j.z > vector4.z) {
            n5 = vector4.z;
            n6 = j.z;
        }
        else if (e.z < vector3.z) {
            n5 = vector3.z;
            n6 = e.z;
        }
        else {
            if (vector3.z >= j.z && vector3.z <= e.z) {
                n6 = (n5 = vector3.z);
            }
            else if (vector4.z >= j.z && vector4.z <= e.z) {
                n6 = (n5 = vector4.z);
            }
            else if (j.z >= vector3.z && j.z <= vector4.z) {
                n6 = (n5 = j.z);
            }
            else {
                n6 = (n5 = e.z);
            }
            b3 = true;
        }
        if (b && b2 && b3) {
            return null;
        }
        return new Vector3[] { Vector3.g(n, n3, n5), Vector3.g(n2, n4, n6) };
    }
}
