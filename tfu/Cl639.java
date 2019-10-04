// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.Random;
import java.util.Arrays;

public class Cl639
{
    private static int[] a;
    private static int[] ag;
    private static int[] c;
    private static int[] f;
    private static final double i = 1.0057929410678534;
    private static int[] k;
    private static int[] m;
    private static int[] n;
    private static int[] o;
    private Ch643 b;
    private Ch643 d;
    private Ch643 e;
    boolean g;
    private Ch643 h;
    private Ch643 j;
    private Ch643 l;
    private int p;
    private Ch643 q;
    private int[] r;
    private Ch643 s;
    int t;
    private Ch643 u;
    private int[] v;
    private int[] w;
    private Cf644 x;
    private int y;
    int z;
    
    public static final int[] g(final Cl639 cl639, final int toIndex, final int n) {
        Arrays.fill(Cl639.m, 0, toIndex, 0);
        if (n < 10) {
            return Cl639.m;
        }
        final double n2 = toIndex / (n + 0.0);
        Ch643.q(cl639.d);
        Ch643.q(cl639.q);
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        if (cl639.j != null && cl639.j.g) {
            Ch643.q(cl639.j);
            Ch643.q(cl639.e);
            n3 = (int)((cl639.j.h - cl639.j.e) * 32.768 / n2);
            n4 = (int)(cl639.j.e * 32.768 / n2);
        }
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        if (cl639.h != null && cl639.h.g) {
            Ch643.q(cl639.h);
            Ch643.q(cl639.s);
            n6 = (int)((cl639.h.h - cl639.h.e) * 32.768 / n2);
            n7 = (int)(cl639.h.e * 32.768 / n2);
        }
        for (int i = 0; i < 5; ++i) {
            if (cl639.w[i] != 0) {
                Cl639.o[i] = 0;
                Cl639.a[i] = (int)(cl639.v[i] * n2);
                Cl639.f[i] = (cl639.w[i] << 14) / 100;
                Cl639.c[i] = (int)((cl639.d.h - cl639.d.e) * 32.768 * Math.pow(1.0057929410678534, cl639.r[i]) / n2);
                Cl639.ag[i] = (int)(cl639.d.e * 32.768 / n2);
            }
        }
        for (int j = 0; j < toIndex; ++j) {
            int k = Ch643.j(cl639.d, toIndex);
            int l = Ch643.j(cl639.q, toIndex);
            if (cl639.j != null && cl639.j.g) {
                final int m = Ch643.j(cl639.j, toIndex);
                k += d(cl639, n5, Ch643.j(cl639.e, toIndex), cl639.j.s) >> 1;
                n5 += (m * n3 >> 16) + n4;
            }
            if (cl639.h != null && cl639.h.g) {
                final int j2 = Ch643.j(cl639.h, toIndex);
                l = l * ((d(cl639, n8, Ch643.j(cl639.s, toIndex), cl639.h.s) >> 1) + 32768) >> 15;
                n8 += (j2 * n6 >> 16) + n7;
            }
            for (int n9 = 0; n9 < 5; ++n9) {
                if (cl639.w[n9] != 0) {
                    final int n10 = j + Cl639.a[n9];
                    if (n10 < toIndex) {
                        final int[] m2 = Cl639.m;
                        final int n11 = n10;
                        m2[n11] += d(cl639, Cl639.o[n9], l * Cl639.f[n9] >> 15, cl639.d.s);
                        final int[] o = Cl639.o;
                        final int n12 = n9;
                        o[n12] += (k * Cl639.c[n9] >> 16) + Cl639.ag[n9];
                    }
                }
            }
        }
        if (cl639.b != null && cl639.b.g) {
            Ch643.q(cl639.b);
            Ch643.q(cl639.l);
            int n13 = 0;
            boolean b = true;
            for (int n14 = 0; n14 < toIndex; ++n14) {
                final int j3 = Ch643.j(cl639.b, toIndex);
                final int j4 = Ch643.j(cl639.l, toIndex);
                int n15;
                if (b) {
                    n15 = cl639.b.e + ((cl639.b.h - cl639.b.e) * j3 >> 8);
                }
                else {
                    n15 = cl639.b.e + ((cl639.b.h - cl639.b.e) * j4 >> 8);
                }
                n13 += 256;
                if (n13 >= n15) {
                    n13 = 0;
                    b = !b;
                }
                if (b) {
                    Cl639.m[n14] = 0;
                }
            }
        }
        if (cl639.y > 0 && cl639.p > 0) {
            int n17;
            for (int n16 = n17 = (int)(cl639.y * n2); n17 < toIndex; ++n17) {
                final int[] m3 = Cl639.m;
                final int n18 = n17;
                m3[n18] += Cl639.m[n17 - n16] * cl639.p / 100;
            }
        }
        if (cl639.x.g && (cl639.x.d[0] > 0 || cl639.x.d[1] > 0)) {
            Ch643.q(cl639.u);
            int n19 = Ch643.j(cl639.u, toIndex + 1);
            int n20 = Cf644.j(cl639.x, 0, n19 / 65536.0f);
            int n21 = Cf644.j(cl639.x, 1, n19 / 65536.0f);
            if (toIndex >= n20 + n21) {
                int n22 = 0;
                int n23 = n21;
                if (n23 > toIndex - n20) {
                    n23 = toIndex - n20;
                }
                while (n22 < n23) {
                    int n24 = (int)(Cl639.m[n22 + n20] * (long)Cf644.w >> 16);
                    for (int n25 = 0; n25 < n20; ++n25) {
                        n24 += (int)(Cl639.m[n22 + n20 - 1 - n25] * (long)Cf644.b[0][n25] >> 16);
                    }
                    for (int n26 = 0; n26 < n22; ++n26) {
                        n24 -= (int)(Cl639.m[n22 - 1 - n26] * (long)Cf644.b[1][n26] >> 16);
                    }
                    Cl639.m[n22] = n24;
                    n19 = Ch643.j(cl639.u, toIndex + 1);
                    ++n22;
                }
                int n27 = 128;
                while (true) {
                    if (n27 > toIndex - n20) {
                        n27 = toIndex - n20;
                    }
                    while (n22 < n27) {
                        int n28 = (int)(Cl639.m[n22 + n20] * (long)Cf644.w >> 16);
                        for (int n29 = 0; n29 < n20; ++n29) {
                            n28 += (int)(Cl639.m[n22 + n20 - 1 - n29] * (long)Cf644.b[0][n29] >> 16);
                        }
                        for (int n30 = 0; n30 < n21; ++n30) {
                            n28 -= (int)(Cl639.m[n22 - 1 - n30] * (long)Cf644.b[1][n30] >> 16);
                        }
                        Cl639.m[n22] = n28;
                        n19 = Ch643.j(cl639.u, toIndex + 1);
                        ++n22;
                    }
                    if (n22 >= toIndex - n20) {
                        break;
                    }
                    n20 = Cf644.j(cl639.x, 0, n19 / 65536.0f);
                    n21 = Cf644.j(cl639.x, 1, n19 / 65536.0f);
                    n27 += 128;
                }
                while (n22 < toIndex) {
                    int n31 = 0;
                    for (int n32 = n22 + n20 - toIndex; n32 < n20; ++n32) {
                        n31 += (int)(Cl639.m[n22 + n20 - 1 - n32] * (long)Cf644.b[0][n32] >> 16);
                    }
                    for (int n33 = 0; n33 < n21; ++n33) {
                        n31 -= (int)(Cl639.m[n22 - 1 - n33] * (long)Cf644.b[1][n33] >> 16);
                    }
                    Cl639.m[n22] = n31;
                    Ch643.j(cl639.u, toIndex + 1);
                    ++n22;
                }
            }
        }
        for (int n34 = 0; n34 < toIndex; ++n34) {
            if (Cl639.m[n34] < -32768) {
                Cl639.m[n34] = -32768;
            }
            if (Cl639.m[n34] > 32767) {
                Cl639.m[n34] = 32767;
            }
        }
        return Cl639.m;
    }
    
    public Cl639() {
        this.g = true;
        this.w = new int[] { 0, 0, 0, 0, 0 };
        this.r = new int[] { 0, 0, 0, 0, 0 };
        this.v = new int[] { 0, 0, 0, 0, 0 };
        this.y = 0;
        this.p = 100;
        this.z = 500;
        this.t = 0;
    }
    
    private static final int d(final Cl639 cl639, final int n, final int n2, final int n3) {
        if (n3 == 1) {
            if ((n & 0x7FFF) < 16384) {
                return n2;
            }
            return -n2;
        }
        else {
            if (n3 == 2) {
                return Cl639.k[n & 0x7FFF] * n2 >> 14;
            }
            if (n3 == 3) {
                return ((n & 0x7FFF) * n2 >> 14) - n2;
            }
            if (n3 == 4) {
                return Cl639.n[n / 2607 & 0x7FFF] * n2;
            }
            return 0;
        }
    }
    
    public final void q(final Gg3 gg3) {
        Ch643.g(this.d = new Ch643(), gg3);
        Ch643.g(this.q = new Ch643(), gg3);
        if (Gg3.ar(gg3) != 0) {
            --gg3.v;
            Ch643.g(this.j = new Ch643(), gg3);
            Ch643.g(this.e = new Ch643(), gg3);
        }
        if (Gg3.ar(gg3) != 0) {
            --gg3.v;
            Ch643.g(this.h = new Ch643(), gg3);
            Ch643.g(this.s = new Ch643(), gg3);
        }
        if (Gg3.ar(gg3) != 0) {
            --gg3.v;
            Ch643.g(this.b = new Ch643(), gg3);
            Ch643.g(this.l = new Ch643(), gg3);
        }
        for (int i = 0; i < 10; ++i) {
            final int br = Gg3.br(gg3);
            if (br == 0) {
                break;
            }
            this.w[i] = br;
            this.r[i] = Gg3.by(gg3);
            this.v[i] = Gg3.br(gg3);
        }
        this.y = Gg3.br(gg3);
        this.p = Gg3.br(gg3);
        this.z = Gg3.au(gg3);
        this.t = Gg3.au(gg3);
        this.x = new Cf644();
        this.u = new Ch643();
        Cf644.e(this.x, gg3, this.u);
    }
    
    static {
        Cl639.n = new int[32768];
        final Random random = new Random(0L);
        for (int i = 0; i < 32768; ++i) {
            Cl639.n[i] = (random.nextInt() & 0x2) - 1;
        }
        Cl639.k = new int[32768];
        for (int j = 0; j < 32768; ++j) {
            Cl639.k[j] = (int)(Math.sin(j / 5215.1903) * 16384.0);
        }
        Cl639.m = new int[220500];
        Cl639.o = new int[5];
        Cl639.a = new int[5];
        Cl639.f = new int[5];
        Cl639.c = new int[5];
        Cl639.ag = new int[5];
    }
}
