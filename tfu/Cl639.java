/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.Arrays;
import java.util.Random;
import tfu.Cf644;
import tfu.Ch643;
import tfu.Gg3;

public class Cl639 {
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
    boolean g = true;
    private Ch643 h;
    private Ch643 j;
    private Ch643 l;
    private int p = 100;
    private Ch643 q;
    private int[] r;
    private Ch643 s;
    int t = 0;
    private Ch643 u;
    private int[] v;
    private int[] w = new int[]{0, 0, 0, 0, 0};
    private Cf644 x;
    private int y = 0;
    int z = 500;

    public static final int[] g(Cl639 cl639, int n, int n2) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        Arrays.fill(m, 0, n, 0);
        if (n2 < 10) {
            return m;
        }
        double d = (double)n / ((double)n2 + 0.0);
        Ch643.q(cl639.d);
        Ch643.q(cl639.q);
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        if (cl639.j != null && cl639.j.g) {
            Ch643.q(cl639.j);
            Ch643.q(cl639.e);
            n9 = (int)((double)(cl639.j.h - cl639.j.e) * 32.768 / d);
            n10 = (int)((double)cl639.j.e * 32.768 / d);
        }
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        if (cl639.h != null && cl639.h.g) {
            Ch643.q(cl639.h);
            Ch643.q(cl639.s);
            n12 = (int)((double)(cl639.h.h - cl639.h.e) * 32.768 / d);
            n13 = (int)((double)cl639.h.e * 32.768 / d);
        }
        for (n4 = 0; n4 < 5; ++n4) {
            if (cl639.w[n4] == 0) continue;
            Cl639.o[n4] = 0;
            Cl639.a[n4] = (int)((double)cl639.v[n4] * d);
            Cl639.f[n4] = (cl639.w[n4] << 14) / 100;
            Cl639.c[n4] = (int)((double)(cl639.d.h - cl639.d.e) * 32.768 * Math.pow(1.0057929410678534, cl639.r[n4]) / d);
            Cl639.ag[n4] = (int)((double)cl639.d.e * 32.768 / d);
        }
        for (n4 = 0; n4 < n; ++n4) {
            n8 = Ch643.j(cl639.d, n);
            n6 = Ch643.j(cl639.q, n);
            if (cl639.j != null && cl639.j.g) {
                n5 = Ch643.j(cl639.j, n);
                n3 = Ch643.j(cl639.e, n);
                n8 += Cl639.d(cl639, n11, n3, cl639.j.s) >> 1;
                n11 += (n5 * n9 >> 16) + n10;
            }
            if (cl639.h != null && cl639.h.g) {
                n5 = Ch643.j(cl639.h, n);
                n3 = Ch643.j(cl639.s, n);
                n6 = n6 * ((Cl639.d(cl639, n14, n3, cl639.h.s) >> 1) + 32768) >> 15;
                n14 += (n5 * n12 >> 16) + n13;
            }
            for (n5 = 0; n5 < 5; ++n5) {
                if (cl639.w[n5] == 0 || (n3 = n4 + a[n5]) >= n) continue;
                int[] arrn = m;
                int n15 = n3;
                arrn[n15] = arrn[n15] + Cl639.d(cl639, o[n5], n6 * f[n5] >> 15, cl639.d.s);
                int[] arrn2 = o;
                int n16 = n5;
                arrn2[n16] = arrn2[n16] + ((n8 * c[n5] >> 16) + ag[n5]);
            }
        }
        if (cl639.b != null && cl639.b.g) {
            Ch643.q(cl639.b);
            Ch643.q(cl639.l);
            n4 = 0;
            n8 = 0;
            n6 = 1;
            for (n5 = 0; n5 < n; ++n5) {
                n3 = Ch643.j(cl639.b, n);
                n7 = Ch643.j(cl639.l, n);
                n8 = n6 != 0 ? cl639.b.e + ((cl639.b.h - cl639.b.e) * n3 >> 8) : cl639.b.e + ((cl639.b.h - cl639.b.e) * n7 >> 8);
                if ((n4 += 256) >= n8) {
                    n4 = 0;
                    int n17 = n6 = n6 == 0 ? 1 : 0;
                }
                if (n6 == 0) continue;
                Cl639.m[n5] = 0;
            }
        }
        if (cl639.y > 0 && cl639.p > 0) {
            for (n8 = n4 = (int)((double)cl639.y * d); n8 < n; ++n8) {
                int[] arrn = m;
                int n18 = n8;
                arrn[n18] = arrn[n18] + m[n8 - n4] * cl639.p / 100;
            }
        }
        if (cl639.x.g && (cl639.x.d[0] > 0 || cl639.x.d[1] > 0)) {
            Ch643.q(cl639.u);
            n4 = Ch643.j(cl639.u, n + 1);
            n8 = Cf644.j(cl639.x, 0, (float)n4 / 65536.0f);
            n6 = Cf644.j(cl639.x, 1, (float)n4 / 65536.0f);
            if (n >= n8 + n6) {
                int n19;
                int n20;
                n5 = 0;
                n3 = n6;
                if (n3 > n - n8) {
                    n3 = n - n8;
                }
                while (n5 < n3) {
                    n7 = (int)((long)m[n5 + n8] * (long)Cf644.w >> 16);
                    for (n19 = 0; n19 < n8; ++n19) {
                        n7 += (int)((long)m[n5 + n8 - 1 - n19] * (long)Cf644.b[0][n19] >> 16);
                    }
                    for (n19 = 0; n19 < n5; ++n19) {
                        n7 -= (int)((long)m[n5 - 1 - n19] * (long)Cf644.b[1][n19] >> 16);
                    }
                    Cl639.m[n5] = n7;
                    n4 = Ch643.j(cl639.u, n + 1);
                    ++n5;
                }
                n7 = 128;
                n3 = 128;
                do {
                    if (n3 > n - n8) {
                        n3 = n - n8;
                    }
                    while (n5 < n3) {
                        n19 = (int)((long)m[n5 + n8] * (long)Cf644.w >> 16);
                        for (n20 = 0; n20 < n8; ++n20) {
                            n19 += (int)((long)m[n5 + n8 - 1 - n20] * (long)Cf644.b[0][n20] >> 16);
                        }
                        for (n20 = 0; n20 < n6; ++n20) {
                            n19 -= (int)((long)m[n5 - 1 - n20] * (long)Cf644.b[1][n20] >> 16);
                        }
                        Cl639.m[n5] = n19;
                        n4 = Ch643.j(cl639.u, n + 1);
                        ++n5;
                    }
                    if (n5 >= n - n8) break;
                    n8 = Cf644.j(cl639.x, 0, (float)n4 / 65536.0f);
                    n6 = Cf644.j(cl639.x, 1, (float)n4 / 65536.0f);
                    n3 += 128;
                } while (true);
                while (n5 < n) {
                    n19 = 0;
                    for (n20 = n5 + n8 - n; n20 < n8; ++n20) {
                        n19 += (int)((long)m[n5 + n8 - 1 - n20] * (long)Cf644.b[0][n20] >> 16);
                    }
                    for (n20 = 0; n20 < n6; ++n20) {
                        n19 -= (int)((long)m[n5 - 1 - n20] * (long)Cf644.b[1][n20] >> 16);
                    }
                    Cl639.m[n5] = n19;
                    n4 = Ch643.j(cl639.u, n + 1);
                    ++n5;
                }
            }
        }
        for (n4 = 0; n4 < n; ++n4) {
            if (m[n4] < -32768) {
                Cl639.m[n4] = -32768;
            }
            if (m[n4] <= 32767) continue;
            Cl639.m[n4] = 32767;
        }
        return m;
    }

    public Cl639() {
        this.r = new int[]{0, 0, 0, 0, 0};
        this.v = new int[]{0, 0, 0, 0, 0};
    }

    private static final int d(Cl639 cl639, int n, int n2, int n3) {
        if (n3 == 1) {
            if ((n & 0x7FFF) < 16384) {
                return n2;
            }
            return -n2;
        }
        if (n3 == 2) {
            return k[n & 0x7FFF] * n2 >> 14;
        }
        if (n3 == 3) {
            return ((n & 0x7FFF) * n2 >> 14) - n2;
        }
        if (n3 == 4) {
            return Cl639.n[n / 2607 & 0x7FFF] * n2;
        }
        return 0;
    }

    public final void q(Gg3 gg3) {
        int n;
        this.d = new Ch643();
        Ch643.g(this.d, gg3);
        this.q = new Ch643();
        Ch643.g(this.q, gg3);
        int n2 = Gg3.ar(gg3);
        if (n2 != 0) {
            --gg3.v;
            this.j = new Ch643();
            Ch643.g(this.j, gg3);
            this.e = new Ch643();
            Ch643.g(this.e, gg3);
        }
        if ((n2 = Gg3.ar(gg3)) != 0) {
            --gg3.v;
            this.h = new Ch643();
            Ch643.g(this.h, gg3);
            this.s = new Ch643();
            Ch643.g(this.s, gg3);
        }
        if ((n2 = Gg3.ar(gg3)) != 0) {
            --gg3.v;
            this.b = new Ch643();
            Ch643.g(this.b, gg3);
            this.l = new Ch643();
            Ch643.g(this.l, gg3);
        }
        for (int i = 0; i < 10 && (n = Gg3.br(gg3)) != 0; ++i) {
            this.w[i] = n;
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
        int n;
        Cl639.n = new int[32768];
        Random random = new Random(0L);
        for (n = 0; n < 32768; ++n) {
            Cl639.n[n] = (random.nextInt() & 2) - 1;
        }
        k = new int[32768];
        for (n = 0; n < 32768; ++n) {
            Cl639.k[n] = (int)(Math.sin((double)n / 5215.1903) * 16384.0);
        }
        m = new int[220500];
        o = new int[5];
        a = new int[5];
        f = new int[5];
        c = new int[5];
        ag = new int[5];
    }
}

