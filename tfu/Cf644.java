/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Ch643;
import tfu.Gg3;

public class Cf644 {
    static int[][] b;
    static float l;
    static final int q = 4;
    static final float r = 100.0f;
    static float[][] s;
    static final float v = 8.0f;
    static int w;
    static final float y = 32.703197f;
    int[] d = new int[2];
    int[][][] e;
    boolean g = true;
    int[] h;
    int[][][] j = new int[2][2][4];

    static {
        s = new float[2][8];
        b = new int[2][8];
    }

    private static float d(float f) {
        float f2 = 32.703197f * (float)Math.pow(2.0, f);
        return f2 * 3.1415927f / 11025.0f;
    }

    private static float g(Cf644 cf644, int n, int n2, float f) {
        float f2 = (float)cf644.e[n][0][n2] + f * (float)(cf644.e[n][1][n2] - cf644.e[n][0][n2]);
        return 1.0f - (float)Math.pow(10.0, -(f2 *= 0.0015258789f) / 20.0f);
    }

    public Cf644() {
        this.e = new int[2][2][4];
        this.h = new int[2];
    }

    public static final void e(Cf644 cf644, Gg3 gg3, Ch643 ch643) {
        int n = Gg3.ar(gg3);
        cf644.d[0] = n >> 4;
        cf644.d[1] = n & 0xF;
        if (n != 0) {
            int n2;
            int n3;
            cf644.h[0] = Gg3.au(gg3);
            cf644.h[1] = Gg3.au(gg3);
            int n4 = Gg3.ar(gg3);
            for (n3 = 0; n3 < 2; ++n3) {
                for (n2 = 0; n2 < cf644.d[n3]; ++n2) {
                    cf644.j[n3][0][n2] = Gg3.au(gg3);
                    cf644.e[n3][0][n2] = Gg3.au(gg3);
                }
            }
            for (n3 = 0; n3 < 2; ++n3) {
                for (n2 = 0; n2 < cf644.d[n3]; ++n2) {
                    if ((n4 & 1 << n3 * 4 << n2) != 0) {
                        cf644.j[n3][1][n2] = Gg3.au(gg3);
                        cf644.e[n3][1][n2] = Gg3.au(gg3);
                        continue;
                    }
                    cf644.j[n3][1][n2] = cf644.j[n3][0][n2];
                    cf644.e[n3][1][n2] = cf644.e[n3][0][n2];
                }
            }
            if (n4 != 0 || cf644.h[1] != cf644.h[0]) {
                Ch643.d(ch643, gg3);
            }
        } else {
            cf644.h[1] = 0;
            cf644.h[0] = 0;
        }
    }

    public static int j(Cf644 cf644, int n, float f) {
        float f2;
        int n2;
        if (n == 0) {
            f2 = (float)cf644.h[0] + (float)(cf644.h[1] - cf644.h[0]) * f;
            l = (float)Math.pow(0.1, (f2 *= 0.0030517578f) / 20.0f);
            w = (int)(l * 65536.0f);
        }
        if (cf644.d[n] == 0) {
            return 0;
        }
        f2 = Cf644.g(cf644, n, 0, f);
        Cf644.s[n][0] = -2.0f * f2 * (float)Math.cos(Cf644.q(cf644, n, 0, f));
        Cf644.s[n][1] = f2 * f2;
        for (n2 = 1; n2 < cf644.d[n]; ++n2) {
            f2 = Cf644.g(cf644, n, n2, f);
            float f3 = -2.0f * f2 * (float)Math.cos(Cf644.q(cf644, n, n2, f));
            float f4 = f2 * f2;
            Cf644.s[n][n2 * 2 + 1] = s[n][n2 * 2 - 1] * f4;
            Cf644.s[n][n2 * 2] = s[n][n2 * 2 - 1] * f3 + s[n][n2 * 2 - 2] * f4;
            for (int i = n2 * 2 - 1; i >= 2; --i) {
                float[] arrf = s[n];
                int n3 = i;
                arrf[n3] = arrf[n3] + (s[n][i - 1] * f3 + s[n][i - 2] * f4);
            }
            float[] arrf = s[n];
            arrf[1] = arrf[1] + (s[n][0] * f3 + f4);
            float[] arrf2 = s[n];
            arrf2[0] = arrf2[0] + f3;
        }
        if (n == 0) {
            n2 = 0;
            while (n2 < cf644.d[0] * 2) {
                float[] arrf = s[0];
                int n4 = n2++;
                arrf[n4] = arrf[n4] * l;
            }
        }
        for (n2 = 0; n2 < cf644.d[n] * 2; ++n2) {
            Cf644.b[n][n2] = (int)(s[n][n2] * 65536.0f);
        }
        return cf644.d[n] * 2;
    }

    private static float q(Cf644 cf644, int n, int n2, float f) {
        float f2 = (float)cf644.j[n][0][n2] + f * (float)(cf644.j[n][1][n2] - cf644.j[n][0][n2]);
        return Cf644.d(f2 *= 1.2207031E-4f);
    }
}

