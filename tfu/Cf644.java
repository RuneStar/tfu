// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Cf644
{
    static int[][] b;
    static float l;
    static final int q = 4;
    static final float r = 100.0f;
    static float[][] s;
    static final float v = 8.0f;
    static int w;
    static final float y = 32.703197f;
    int[] d;
    int[][][] e;
    boolean g;
    int[] h;
    int[][][] j;
    
    static {
        Cf644.s = new float[2][8];
        Cf644.b = new int[2][8];
    }
    
    private static float d(final float n) {
        return 32.703197f * (float)Math.pow(2.0, n) * 3.1415927f / 11025.0f;
    }
    
    private static float g(final Cf644 cf644, final int n, final int n2, final float n3) {
        return 1.0f - (float)Math.pow(10.0, -((cf644.e[n][0][n2] + n3 * (cf644.e[n][1][n2] - cf644.e[n][0][n2])) * 0.0015258789f) / 20.0f);
    }
    
    public Cf644() {
        this.g = true;
        this.d = new int[2];
        this.j = new int[2][2][4];
        this.e = new int[2][2][4];
        this.h = new int[2];
    }
    
    public static final void e(final Cf644 cf644, final Gg3 gg3, final Ch643 ch643) {
        final int ar = Gg3.ar(gg3);
        cf644.d[0] = ar >> 4;
        cf644.d[1] = (ar & 0xF);
        if (ar != 0) {
            cf644.h[0] = Gg3.au(gg3);
            cf644.h[1] = Gg3.au(gg3);
            final int ar2 = Gg3.ar(gg3);
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < cf644.d[i]; ++j) {
                    cf644.j[i][0][j] = Gg3.au(gg3);
                    cf644.e[i][0][j] = Gg3.au(gg3);
                }
            }
            for (int k = 0; k < 2; ++k) {
                for (int l = 0; l < cf644.d[k]; ++l) {
                    if ((ar2 & 1 << k * 4 << l) != 0x0) {
                        cf644.j[k][1][l] = Gg3.au(gg3);
                        cf644.e[k][1][l] = Gg3.au(gg3);
                    }
                    else {
                        cf644.j[k][1][l] = cf644.j[k][0][l];
                        cf644.e[k][1][l] = cf644.e[k][0][l];
                    }
                }
            }
            if (ar2 != 0 || cf644.h[1] != cf644.h[0]) {
                Ch643.d(ch643, gg3);
            }
        }
        else {
            cf644.h[0] = (cf644.h[1] = 0);
        }
    }
    
    public static int j(final Cf644 cf644, final int n, final float n2) {
        if (n == 0) {
            Cf644.l = (float)Math.pow(0.1, (cf644.h[0] + (cf644.h[1] - cf644.h[0]) * n2) * 0.0030517578f / 20.0f);
            Cf644.w = (int)(Cf644.l * 65536.0f);
        }
        if (cf644.d[n] == 0) {
            return 0;
        }
        final float g = g(cf644, n, 0, n2);
        Cf644.s[n][0] = -2.0f * g * (float)Math.cos(q(cf644, n, 0, n2));
        Cf644.s[n][1] = g * g;
        for (int i = 1; i < cf644.d[n]; ++i) {
            final float g2 = g(cf644, n, i, n2);
            final float n3 = -2.0f * g2 * (float)Math.cos(q(cf644, n, i, n2));
            final float n4 = g2 * g2;
            Cf644.s[n][i * 2 + 1] = Cf644.s[n][i * 2 - 1] * n4;
            Cf644.s[n][i * 2] = Cf644.s[n][i * 2 - 1] * n3 + Cf644.s[n][i * 2 - 2] * n4;
            for (int j = i * 2 - 1; j >= 2; --j) {
                final float[] array = Cf644.s[n];
                final int n5 = j;
                array[n5] += Cf644.s[n][j - 1] * n3 + Cf644.s[n][j - 2] * n4;
            }
            final float[] array2 = Cf644.s[n];
            final int n6 = 1;
            array2[n6] += Cf644.s[n][0] * n3 + n4;
            final float[] array3 = Cf644.s[n];
            final int n7 = 0;
            array3[n7] += n3;
        }
        if (n == 0) {
            for (int k = 0; k < cf644.d[0] * 2; ++k) {
                final float[] array4 = Cf644.s[0];
                final int n8 = k;
                array4[n8] *= Cf644.l;
            }
        }
        for (int l = 0; l < cf644.d[n] * 2; ++l) {
            Cf644.b[n][l] = (int)(Cf644.s[n][l] * 65536.0f);
        }
        return cf644.d[n] * 2;
    }
    
    private static float q(final Cf644 cf644, final int n, final int n2, final float n3) {
        return d((cf644.j[n][0][n2] + n3 * (cf644.j[n][1][n2] - cf644.j[n][0][n2])) * 1.2207031E-4f);
    }
}
