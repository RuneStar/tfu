/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public class Gy491 {
    private static int d;
    public static int[] e;
    private static int g;
    public static int[] j;
    public static int[] q;

    private static void d() {
        if (q != null) {
            return;
        }
        q = new int[65536];
        double d = 0.7 + (Math.random() * 0.03 - 0.015);
        int n = 0;
        for (int i = 0; i < 512; ++i) {
            float f = ((float)(i >> 3) / 64.0f + 0.0078125f) * 360.0f;
            float f2 = (float)(i & 7) / 8.0f + 0.0625f;
            for (int j = 0; j < 128; ++j) {
                float f3 = (float)j / 128.0f;
                float f4 = 0.0f;
                float f5 = 0.0f;
                float f6 = 0.0f;
                float f7 = f / 60.0f;
                int n2 = (int)f7;
                int n3 = n2 % 6;
                float f8 = f7 - (float)n2;
                float f9 = f3 * (1.0f - f2);
                float f10 = f3 * (1.0f - f8 * f2);
                float f11 = f3 * (1.0f - (1.0f - f8) * f2);
                if (n3 == 0) {
                    f4 = f3;
                    f5 = f11;
                    f6 = f9;
                } else if (n3 == 1) {
                    f4 = f10;
                    f5 = f3;
                    f6 = f9;
                } else if (n3 == 2) {
                    f4 = f9;
                    f5 = f3;
                    f6 = f11;
                } else if (n3 == 3) {
                    f4 = f9;
                    f5 = f10;
                    f6 = f3;
                } else if (n3 == 4) {
                    f4 = f11;
                    f5 = f9;
                    f6 = f3;
                } else if (n3 == 5) {
                    f4 = f3;
                    f5 = f9;
                    f6 = f10;
                }
                f4 = (float)Math.pow(f4, d);
                f5 = (float)Math.pow(f5, d);
                f6 = (float)Math.pow(f6, d);
                int n4 = (int)(f4 * 256.0f);
                int n5 = (int)(f5 * 256.0f);
                int n6 = (int)(f6 * 256.0f);
                int n7 = -16777216 + (n4 << 16) + (n5 << 8) + n6;
                Gy491.q[n++] = n7;
            }
        }
    }

    public static void g(boolean bl, boolean bl2) {
        if (bl) {
            ++g;
            Gy491.d();
        }
        if (bl2) {
            ++d;
            Gy491.q();
        }
    }

    private static void q() {
        if (j != null) {
            return;
        }
        j = new int[65536];
        e = new int[65536];
        double d = 0.7 + (Math.random() * 0.03 - 0.015);
        for (int i = 0; i < 65536; ++i) {
            double d2;
            int n;
            double d3 = (double)(i >> 10 & 0x3F) / 64.0 + 0.0078125;
            double d4 = (double)(i >> 7 & 7) / 8.0 + 0.0625;
            double d5 = d2 = (double)(i & 0x7F) / 128.0;
            double d6 = d2;
            double d7 = d2;
            if (d4 != 0.0) {
                double d8 = d2 < 0.5 ? d2 * (1.0 + d4) : d2 + d4 - d2 * d4;
                double d9 = 2.0 * d2 - d8;
                double d10 = d3 + 0.3333333333333333;
                if (d10 > 1.0) {
                    d10 -= 1.0;
                }
                double d11 = d3;
                double d12 = d3 - 0.3333333333333333;
                if (d12 < 0.0) {
                    d12 += 1.0;
                }
                d5 = 6.0 * d10 < 1.0 ? d9 + (d8 - d9) * 6.0 * d10 : (2.0 * d10 < 1.0 ? d8 : (3.0 * d10 < 2.0 ? d9 + (d8 - d9) * (0.6666666666666666 - d10) * 6.0 : d9));
                d6 = 6.0 * d11 < 1.0 ? d9 + (d8 - d9) * 6.0 * d11 : (2.0 * d11 < 1.0 ? d8 : (3.0 * d11 < 2.0 ? d9 + (d8 - d9) * (0.6666666666666666 - d11) * 6.0 : d9));
                d7 = 6.0 * d12 < 1.0 ? d9 + (d8 - d9) * 6.0 * d12 : (2.0 * d12 < 1.0 ? d8 : (3.0 * d12 < 2.0 ? d9 + (d8 - d9) * (0.6666666666666666 - d12) * 6.0 : d9));
            }
            d5 = Math.pow(d5, d);
            d6 = Math.pow(d6, d);
            d7 = Math.pow(d7, d);
            int n2 = (int)(d5 * 256.0);
            int n3 = (int)(d6 * 256.0);
            int n4 = (int)(d7 * 256.0);
            int n5 = (n2 << 16) + (n3 << 8) + n4;
            Gy491.j[i] = n5 & 0xFFFFFF;
            Gy491.e[i] = n = (n4 << 16) + (n3 << 8) + n2;
        }
    }

    static {
        g = 0;
        d = 0;
    }
}

