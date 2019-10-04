// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Cz584
{
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
        final int d = Jz233.d(n, n2);
        n /= d;
        n2 /= d;
        this.e = n;
        this.h = n2;
        this.s = new int[n][14];
        for (int i = 0; i < n; ++i) {
            final int[] array = this.s[i];
            final double n3 = 6.0 + i / (double)n;
            int j = (int)Math.floor(n3 - 7.0 + 1.0);
            if (j < 0) {
                j = 0;
            }
            int n4 = (int)Math.ceil(n3 + 7.0);
            if (n4 > 14) {
                n4 = 14;
            }
            final double n5 = n2 / (double)n;
            while (j < n4) {
                final double a = (j - n3) * 3.141592653589793;
                double n6 = n5;
                if (a < -1.0E-4 || a > 1.0E-4) {
                    n6 *= Math.sin(a) / a;
                }
                array[j] = (int)Math.floor(n6 * (0.54 + 0.46 * Math.cos((j - n3) * 0.2243994752564138)) * 65536.0 + 0.5);
                ++j;
            }
        }
    }
}
