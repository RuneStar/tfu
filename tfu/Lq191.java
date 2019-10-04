// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Lq191
{
    public static final float d = 0.5f;
    public static final int e = 0;
    private static int g;
    public static final int h = 2;
    public static final float j = 0.1f;
    public static final int q = 50;
    
    public static int g() {
        return Lq191.g;
    }
    
    public static float d() {
        return 1.0f / Lq191.g;
    }
    
    static {
        Lq191.g = 20;
    }
    
    public static int j() {
        int n = (int)(0.1f * Lq191.g);
        if (n < 1) {
            n = 1;
        }
        return n;
    }
    
    public static void q(final int g) {
        if ((int)(0.5f * g) > 50) {
            throw new IllegalArgumentException("Framerate cannot be higher than 100.0");
        }
        Lq191.g = g;
    }
}
