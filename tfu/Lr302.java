// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.maths.Vector3;
import com.jagex.maths.Quaternion;

public class Lr302
{
    public static final int b = 8;
    public static final int d = 100000;
    public static final int e = 1;
    public static final int g = -1000;
    public static final int h = 2;
    public static final int j = 256;
    public static final int l = 16;
    public static int q;
    public static final int s = 4;
    public static final int w = 32;
    
    public static float g(final Quaternion quaternion) {
        final Vector3 al = Vector3.al(Vector3.g(0.0f, 0.0f, 1.0f), quaternion);
        double atan2 = Math.atan2(al.x, al.z);
        if (atan2 < 0.0) {
            atan2 = 3.141592653589793 + (3.141592653589793 + atan2);
        }
        return (float)atan2;
    }
    
    static {
        Lr302.q = 2;
    }
    
    public static Quaternion d(final float n) {
        if (n >= -100.0f && n <= 100.0f) {
            return Quaternion.e(0.0f, 1.0f, 0.0f, n);
        }
        return Quaternion.g;
    }
}
