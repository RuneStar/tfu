/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Jz233;

public class Cz584 {
    private static final int d = 14;
    private static final boolean g = true;
    private static final int j = 6;
    private static final int q = 7;
    private int e;
    private int h;
    private int[][] s;

    public Cz584(int n, int n2) {
        if (n == n2) {
            return;
        }
        if (n2 > n) {
            throw new IllegalArgumentException("decimator is designed to reduce the sampling frequency - it will sound horrible trying to increase it - oldfreq=" + n + " newfreq=" + n2);
        }
        int n3 = Jz233.d(n, n2);
        this.e = n /= n3;
        this.h = n2 /= n3;
        this.s = new int[n][14];
        for (int i = 0; i < n; ++i) {
            int n4;
            int[] arrn = this.s[i];
            double d = 6.0 + (double)i / (double)n;
            int n5 = (int)Math.floor(d - 7.0 + 1.0);
            if (n5 < 0) {
                n5 = 0;
            }
            if ((n4 = (int)Math.ceil(d + 7.0)) > 14) {
                n4 = 14;
            }
            double d2 = (double)n2 / (double)n;
            while (n5 < n4) {
                double d3 = ((double)n5 - d) * 3.141592653589793;
                double d4 = d2;
                if (d3 < -1.0E-4 || d3 > 1.0E-4) {
                    d4 *= Math.sin(d3) / d3;
                }
                arrn[n5] = (int)Math.floor((d4 *= 0.54 + 0.46 * Math.cos(((double)n5 - d) * 0.2243994752564138)) * 65536.0 + 0.5);
                ++n5;
            }
        }
    }
}

