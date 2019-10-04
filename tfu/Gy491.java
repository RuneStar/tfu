// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Gy491
{
    private static int d;
    public static int[] e;
    private static int g;
    public static int[] j;
    public static int[] q;
    
    private static void d() {
        if (Gy491.q == null) {
            Gy491.q = new int[65536];
            final double b = 0.7 + (Math.random() * 0.03 - 0.015);
            int n = 0;
            for (int i = 0; i < 512; ++i) {
                final float n2 = ((i >> 3) / 64.0f + 0.0078125f) * 360.0f;
                final float n3 = (i & 0x7) / 8.0f + 0.0625f;
                for (int j = 0; j < 128; ++j) {
                    final float n4 = j / 128.0f;
                    float n5 = 0.0f;
                    float n6 = 0.0f;
                    float n7 = 0.0f;
                    final float n8 = n2 / 60.0f;
                    final int n9 = (int)n8;
                    final int n10 = n9 % 6;
                    final float n11 = n8 - n9;
                    final float n12 = n4 * (1.0f - n3);
                    final float n13 = n4 * (1.0f - n11 * n3);
                    final float n14 = n4 * (1.0f - (1.0f - n11) * n3);
                    if (n10 == 0) {
                        n5 = n4;
                        n6 = n14;
                        n7 = n12;
                    }
                    else if (n10 == 1) {
                        n5 = n13;
                        n6 = n4;
                        n7 = n12;
                    }
                    else if (n10 == 2) {
                        n5 = n12;
                        n6 = n4;
                        n7 = n14;
                    }
                    else if (n10 == 3) {
                        n5 = n12;
                        n6 = n13;
                        n7 = n4;
                    }
                    else if (n10 == 4) {
                        n5 = n14;
                        n6 = n12;
                        n7 = n4;
                    }
                    else if (n10 == 5) {
                        n5 = n4;
                        n6 = n12;
                        n7 = n13;
                    }
                    Gy491.q[n++] = -16777216 + ((int)((float)Math.pow(n5, b) * 256.0f) << 16) + ((int)((float)Math.pow(n6, b) * 256.0f) << 8) + (int)((float)Math.pow(n7, b) * 256.0f);
                }
            }
        }
    }
    
    public static void g(final boolean b, final boolean b2) {
        if (b) {
            ++Gy491.g;
            d();
        }
        if (b2) {
            ++Gy491.d;
            q();
        }
    }
    
    private static void q() {
        if (Gy491.j != null) {
            return;
        }
        Gy491.j = new int[65536];
        Gy491.e = new int[65536];
        final double b = 0.7 + (Math.random() * 0.03 - 0.015);
        for (int i = 0; i < 65536; ++i) {
            final double n = (i >> 10 & 0x3F) / 64.0 + 0.0078125;
            final double n2 = (i >> 7 & 0x7) / 8.0 + 0.0625;
            double a3;
            double a2;
            double a;
            final double n3 = a = (a2 = (a3 = (i & 0x7F) / 128.0));
            if (n2 != 0.0) {
                double n4;
                if (n3 < 0.5) {
                    n4 = n3 * (1.0 + n2);
                }
                else {
                    n4 = n3 + n2 - n3 * n2;
                }
                final double n5 = 2.0 * n3 - n4;
                double n6 = n + 0.3333333333333333;
                if (n6 > 1.0) {
                    --n6;
                }
                final double n7 = n;
                double n8 = n - 0.3333333333333333;
                if (n8 < 0.0) {
                    ++n8;
                }
                if (6.0 * n6 < 1.0) {
                    a3 = n5 + (n4 - n5) * 6.0 * n6;
                }
                else if (2.0 * n6 < 1.0) {
                    a3 = n4;
                }
                else if (3.0 * n6 < 2.0) {
                    a3 = n5 + (n4 - n5) * (0.6666666666666666 - n6) * 6.0;
                }
                else {
                    a3 = n5;
                }
                if (6.0 * n7 < 1.0) {
                    a2 = n5 + (n4 - n5) * 6.0 * n7;
                }
                else if (2.0 * n7 < 1.0) {
                    a2 = n4;
                }
                else if (3.0 * n7 < 2.0) {
                    a2 = n5 + (n4 - n5) * (0.6666666666666666 - n7) * 6.0;
                }
                else {
                    a2 = n5;
                }
                if (6.0 * n8 < 1.0) {
                    a = n5 + (n4 - n5) * 6.0 * n8;
                }
                else if (2.0 * n8 < 1.0) {
                    a = n4;
                }
                else if (3.0 * n8 < 2.0) {
                    a = n5 + (n4 - n5) * (0.6666666666666666 - n8) * 6.0;
                }
                else {
                    a = n5;
                }
            }
            final double pow = Math.pow(a3, b);
            final double pow2 = Math.pow(a2, b);
            final double pow3 = Math.pow(a, b);
            final int n9 = (int)(pow * 256.0);
            final int n10 = (int)(pow2 * 256.0);
            final int n11 = (int)(pow3 * 256.0);
            Gy491.j[i] = ((n9 << 16) + (n10 << 8) + n11 & 0xFFFFFF);
            Gy491.e[i] = (n11 << 16) + (n10 << 8) + n9;
        }
    }
    
    static {
        Gy491.g = 0;
        Gy491.d = 0;
    }
}
