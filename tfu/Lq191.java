/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public class Lq191 {
    public static final float d = 0.5f;
    public static final int e = 0;
    private static int g = 20;
    public static final int h = 2;
    public static final float j = 0.1f;
    public static final int q = 50;

    public static int g() {
        return g;
    }

    public static float d() {
        return 1.0f / (float)g;
    }

    public static int j() {
        int n = (int)(0.1f * (float)g);
        if (n < 1) {
            n = 1;
        }
        return n;
    }

    public static void q(int n) {
        int n2 = (int)(0.5f * (float)n);
        if (n2 > 50) {
            throw new IllegalArgumentException("Framerate cannot be higher than 100.0");
        }
        g = n;
    }
}

