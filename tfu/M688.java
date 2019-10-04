/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.js5.js5;
import tfu.Ca649;
import tfu.Cd585;
import tfu.Cs635;
import tfu.Cw634;
import tfu.Cx556;
import tfu.Dn555;
import tfu.Gx298;
import tfu.Ha262;
import tfu.Ld263;
import tfu.Ln265;
import tfu.P689;
import tfu.R694;
import tfu.T690;
import tfu.U691;
import tfu.V686;
import tfu.Y692;
import tfu.Z693;

public class M688
extends Cx556 {
    static final int t = 4;
    static final int u = 1;
    static final int z = 2;
    int[] a;
    private R694 aa = null;
    private long af;
    private Z693 ag;
    private P689 ah;
    private int ai;
    private int al;
    private boolean ao;
    private int ap;
    private boolean aq;
    private long av;
    private T690 az;
    private int[] b;
    private U691[][] c;
    private int d = 256;
    int[] e = new int[16];
    private U691[][] f;
    private Ha262 g;
    private int[] h = new int[16];
    int[] i;
    private int j = 1000000;
    private int[] k;
    private int[] l;
    int[] m;
    private int[] n;
    private int[] o;
    private int[] p;
    private int q = 256;
    private int[] r;
    private int[] s = new int[16];
    private int[] v;
    private int[] x;
    private int[] y;

    private static void ap(M688 m688, boolean bl) {
        int n;
        if (bl) {
            M688.al(m688, -1);
        } else {
            M688.av(m688, -1);
        }
        M688.af(m688, -1);
        for (n = 0; n < 16; ++n) {
            m688.r[n] = m688.l[n];
        }
        for (n = 0; n < 16; ++n) {
            m688.v[n] = m688.l[n] & 0xFFFFFF80;
        }
    }

    public M688(M688 m688) {
        this.b = new int[16];
        this.l = new int[16];
        this.r = new int[16];
        this.v = new int[16];
        this.y = new int[16];
        this.p = new int[16];
        this.x = new int[16];
        this.m = new int[16];
        this.n = new int[16];
        this.k = new int[16];
        this.i = new int[16];
        this.o = new int[16];
        this.a = new int[16];
        this.f = new U691[16][128];
        this.c = new U691[16][128];
        this.ag = new Z693();
        this.az = new T690(this);
        this.g = m688.g;
        M688.s(this, -1, 256);
        M688.ap(this, true);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static synchronized boolean r(M688 var0, P689 var1_1, js5 var2_2, Ca649 var3_3, int var4_4) {
        var1_1.d();
        var5_5 = true;
        var6_6 = null;
        if (var4_4 > 0) {
            var6_6 = new int[]{var4_4};
        }
        var7_7 = (Ld263)Ha262.e(var1_1.d);
        do {
            if (var7_7 == null) {
                if (var5_5 == false) return var5_5;
                P689.q(var1_1);
                return var5_5;
            }
            var8_8 = (int)var7_7.bq;
            var9_9 = (Y692)Ha262.d(var0.g, var8_8);
            if (var9_9 != null) ** GOTO lbl20
            var9_9 = Y692.g(var2_2, var8_8);
            if (var9_9 == null) {
                var5_5 = false;
            } else {
                Ha262.q(var0.g, var9_9, var8_8);
lbl20: // 2 sources:
                if (!Y692.d(var9_9, var3_3, (byte[])var7_7.g, var6_6)) {
                    var5_5 = false;
                }
            }
            var7_7 = (Ld263)Ha262.h(var1_1.d);
        } while (true);
    }

    private static int at(M688 m688, U691 u691) {
        int n = m688.s[u691.g];
        if (n < 8192) {
            return n * u691.l + 32 >> 6;
        }
        return 16384 - ((16384 - n) * (128 - u691.l) + 32 >> 6);
    }

    public static synchronized void t(M688 m688, P689 p689, boolean bl, boolean bl2, long l) {
        M688.z(m688, p689, bl, bl2);
        M688.ab(m688, l * (long)m688.ag.q);
    }

    public static synchronized void m(M688 m688) {
        M688.n(m688, true);
    }

    public static synchronized void n(M688 m688, boolean bl) {
        Z693.d(m688.ag);
        m688.ah = null;
        M688.ap(m688, bl);
    }

    private static void i(M688 m688, int n, int n2) {
        m688.l[n] = n2;
        m688.v[n] = n2 & 0xFFFFFF80;
        M688.o(m688, n, n2);
    }

    private void a(int n, int n2, int n3) {
        Ln265 ln265;
        M688.c(this, n, n2, 64);
        if ((this.m[n] & 2) != 0) {
            ln265 = (U691)Gx298.a(this.az.j);
            while (ln265 != null) {
                if (ln265.g == n && ln265.u < 0) {
                    this.f[n][ln265.h] = null;
                    this.f[n][n2] = ln265;
                    int n4 = ln265.w + (ln265.r * ln265.v >> 12);
                    ln265.w += n2 - ln265.h << 8;
                    ln265.r = n4 - ln265.w;
                    ln265.v = 4096;
                    ln265.h = n2;
                    return;
                }
                ln265 = (U691)Gx298.ag(this.az.j);
            }
        }
        if ((ln265 = (Y692)Ha262.d(this.g, this.r[n])) == null) {
            return;
        }
        Cw634 cw634 = ((Y692)ln265).d[n2];
        if (cw634 == null) {
            return;
        }
        U691 u691 = new U691();
        u691.g = n;
        u691.d = ln265;
        u691.q = cw634;
        u691.j = ((Y692)ln265).h[n2];
        u691.e = ((Y692)ln265).s[n2];
        u691.h = n2;
        u691.s = n3;
        u691.b = n3 * n3 * ((Y692)ln265).g * ((Y692)ln265).j[n2] + 1024 >> 11;
        u691.l = ((Y692)ln265).e[n2] & 0xFF;
        u691.w = (n2 << 8) - (((Y692)ln265).q[n2] & 0x7FFF);
        u691.y = 0;
        u691.p = 0;
        u691.x = 0;
        u691.u = -1;
        u691.z = 0;
        if (this.i[n] == 0) {
            u691.n = cw634.d(M688.as(this, u691), M688.ac(this, u691), M688.at(this, u691));
        } else {
            u691.n = cw634.d(M688.as(this, u691), 0, M688.at(this, u691));
            M688.f(this, u691, ((Y692)ln265).q[n2] < 0);
        }
        if (((Y692)ln265).q[n2] < 0) {
            Cs635.bq(u691.n, -1);
        }
        if (u691.e >= 0) {
            U691 u6912 = this.c[n][u691.e];
            if (u6912 != null && u6912.u < 0) {
                this.f[n][u6912.h] = null;
                u6912.u = 0;
            }
            this.c[n][u691.e] = u691;
        }
        Gx298.t(this.az.j, u691);
        this.f[n][n2] = u691;
    }

    static void f(M688 m688, U691 u691, boolean bl) {
        int n;
        int n2 = u691.q.g();
        if (bl && u691.q.j) {
            int n3 = n2 + n2 - u691.q.d;
            n = (int)((long)m688.i[u691.g] * (long)n3 >> 6);
            if (n >= (n2 <<= 8)) {
                n = n2 + n2 - 1 - n;
                Cs635.bh(u691.n, true);
            }
        } else {
            n = (int)((long)m688.i[u691.g] * (long)n2 >> 6);
        }
        Cs635.bk(u691.n, n);
    }

    private static void c(M688 m688, int n, int n2, int n3) {
        U691 u691 = m688.f[n][n2];
        if (u691 == null) {
            return;
        }
        m688.f[n][n2] = null;
        if ((m688.m[n] & 2) != 0) {
            U691 u6912 = (U691)Gx298.i(m688.az.j);
            while (u6912 != null) {
                if (u6912.g == u691.g && u6912.u < 0 && u6912 != u691) {
                    u691.u = 0;
                    break;
                }
                u6912 = (U691)Gx298.c(m688.az.j);
            }
        } else {
            u691.u = 0;
        }
    }

    private static void ag(M688 m688, int n, int n2, int n3) {
    }

    private static void ai(M688 m688, int n, int n2) {
        m688.y[n] = n2;
    }

    private static void al(M688 m688, int n) {
        U691 u691 = (U691)Gx298.i(m688.az.j);
        while (u691 != null) {
            if (n < 0 || u691.g == n) {
                if (u691.n != null) {
                    Cs635.bv(u691.n, Cd585.h / 100);
                    if (Cs635.bm(u691.n)) {
                        m688.az.e.h(u691.n);
                    }
                    U691.g(u691);
                }
                if (u691.u < 0) {
                    m688.f[u691.g][u691.h] = null;
                }
                U691.ef(u691);
            }
            u691 = (U691)Gx298.c(m688.az.j);
        }
    }

    @Override
    protected synchronized int q() {
        return 0;
    }

    private static void ao(M688 m688, int n) {
        if ((m688.m[n] & 2) != 0) {
            U691 u691 = (U691)Gx298.i(m688.az.j);
            while (u691 != null) {
                if (u691.g == n && m688.f[n][u691.h] == null && u691.u < 0) {
                    u691.u = 0;
                }
                u691 = (U691)Gx298.c(m688.az.j);
            }
        }
    }

    private static void af(M688 m688, int n) {
        if (n < 0) {
            for (n = 0; n < 16; ++n) {
                M688.af(m688, n);
            }
            return;
        }
        m688.h[n] = 12800;
        m688.s[n] = 8192;
        m688.b[n] = 16383;
        m688.y[n] = 8192;
        m688.p[n] = 0;
        m688.x[n] = 8192;
        M688.ao(m688, n);
        M688.aa(m688, n);
        m688.m[n] = 0;
        m688.n[n] = 32767;
        m688.k[n] = 256;
        m688.i[n] = 0;
        M688.am(m688, n, 8192);
    }

    private static void an(M688 m688, int n, boolean bl) {
        int n2 = n & 0xF0;
        if (n2 == 128) {
            int n3 = n & 0xF;
            int n4 = n >> 8 & 0x7F;
            int n5 = n >> 16 & 0x7F;
            M688.c(m688, n3, n4, n5);
            return;
        }
        if (n2 == 144) {
            int n6 = n & 0xF;
            int n7 = n >> 8 & 0x7F;
            int n8 = n >> 16 & 0x7F;
            if (n8 > 0) {
                if (bl) {
                    m688.a(n6, n7, n8);
                }
            } else {
                M688.c(m688, n6, n7, 64);
            }
            return;
        }
        if (n2 == 160) {
            int n9 = n & 0xF;
            int n10 = n >> 8 & 0x7F;
            int n11 = n >> 16 & 0x7F;
            M688.ag(m688, n9, n10, n11);
            return;
        }
        if (n2 == 176) {
            int n12;
            int n13 = n & 0xF;
            int n14 = n >> 8 & 0x7F;
            int n15 = n >> 16 & 0x7F;
            if (n14 == 0) {
                m688.v[n13] = (m688.v[n13] & 0xFFE03FFF) + (n15 << 14);
            }
            if (n14 == 32) {
                m688.v[n13] = (m688.v[n13] & 0xFFFFC07F) + (n15 << 7);
            }
            if (n14 == 1) {
                m688.p[n13] = (m688.p[n13] & 0xFFFFC07F) + (n15 << 7);
            }
            if (n14 == 33) {
                m688.p[n13] = (m688.p[n13] & 0xFFFFFF80) + n15;
            }
            if (n14 == 5) {
                m688.x[n13] = (m688.x[n13] & 0xFFFFC07F) + (n15 << 7);
            }
            if (n14 == 37) {
                m688.x[n13] = (m688.x[n13] & 0xFFFFFF80) + n15;
            }
            if (n14 == 7) {
                m688.h[n13] = (m688.h[n13] & 0xFFFFC07F) + (n15 << 7);
            }
            if (n14 == 39) {
                m688.h[n13] = (m688.h[n13] & 0xFFFFFF80) + n15;
            }
            if (n14 == 10) {
                m688.s[n13] = (m688.s[n13] & 0xFFFFC07F) + (n15 << 7);
            }
            if (n14 == 42) {
                m688.s[n13] = (m688.s[n13] & 0xFFFFFF80) + n15;
            }
            if (n14 == 11) {
                m688.b[n13] = (m688.b[n13] & 0xFFFFC07F) + (n15 << 7);
            }
            if (n14 == 43) {
                m688.b[n13] = (m688.b[n13] & 0xFFFFFF80) + n15;
            }
            if (n14 == 64) {
                if (n15 >= 64) {
                    int[] arrn = m688.m;
                    int n16 = n13;
                    arrn[n16] = arrn[n16] | 1;
                } else {
                    int[] arrn = m688.m;
                    int n17 = n13;
                    arrn[n17] = arrn[n17] & 0xFFFFFFFE;
                }
            }
            if (n14 == 20 && m688.aa != null) {
                m688.aa.g(n13, n15);
            }
            if (n14 == 65) {
                if (n15 >= 64) {
                    int[] arrn = m688.m;
                    int n18 = n13;
                    arrn[n18] = arrn[n18] | 2;
                } else {
                    M688.ao(m688, n13);
                    int[] arrn = m688.m;
                    int n19 = n13;
                    arrn[n19] = arrn[n19] & 0xFFFFFFFD;
                }
            }
            if (n14 == 99) {
                m688.n[n13] = (m688.n[n13] & 0x7F) + (n15 << 7);
            }
            if (n14 == 98) {
                m688.n[n13] = (m688.n[n13] & 0x3F80) + n15;
            }
            if (n14 == 101) {
                m688.n[n13] = 16384 + (m688.n[n13] & 0x7F) + (n15 << 7);
            }
            if (n14 == 100) {
                m688.n[n13] = 16384 + (m688.n[n13] & 0x3F80) + n15;
            }
            if (n14 == 120) {
                M688.al(m688, n13);
            }
            if (n14 == 121) {
                M688.af(m688, n13);
            }
            if (n14 == 123) {
                M688.av(m688, n13);
            }
            if (n14 == 6 && (n12 = m688.n[n13]) == 16384) {
                m688.k[n13] = (m688.k[n13] & 0xFFFFC07F) + (n15 << 7);
            }
            if (n14 == 38 && (n12 = m688.n[n13]) == 16384) {
                m688.k[n13] = (m688.k[n13] & 0xFFFFFF80) + n15;
            }
            if (n14 == 16) {
                m688.i[n13] = (m688.i[n13] & 0xFFFFC07F) + (n15 << 7);
            }
            if (n14 == 48) {
                m688.i[n13] = (m688.i[n13] & 0xFFFFFF80) + n15;
            }
            if (n14 == 81) {
                if (n15 >= 64) {
                    int[] arrn = m688.m;
                    int n20 = n13;
                    arrn[n20] = arrn[n20] | 4;
                } else {
                    M688.aa(m688, n13);
                    int[] arrn = m688.m;
                    int n21 = n13;
                    arrn[n21] = arrn[n21] & 0xFFFFFFFB;
                }
            }
            if (n14 == 17) {
                M688.am(m688, n13, (m688.o[n13] & 0xFFFFC07F) + (n15 << 7));
            }
            if (n14 == 49) {
                M688.am(m688, n13, (m688.o[n13] & 0xFFFFFF80) + n15);
            }
            return;
        }
        if (n2 == 192) {
            int n22 = n & 0xF;
            int n23 = n >> 8 & 0x7F;
            M688.o(m688, n22, m688.v[n22] + n23);
            return;
        }
        if (n2 == 208) {
            int n24 = n & 0xF;
            int n25 = n >> 8 & 0x7F;
            M688.aq(m688, n24, n25);
            return;
        }
        if (n2 == 224) {
            int n26 = n & 0xF;
            int n27 = (n >> 9 & 0x3F80) + (n >> 8 & 0x7F);
            M688.ai(m688, n26, n27);
            return;
        }
        n2 = n & 0xFF;
        if (n2 == 255) {
            M688.ap(m688, true);
            return;
        }
    }

    static void am(M688 m688, int n, int n2) {
        m688.o[n] = n2;
        m688.a[n] = (int)(2097152.0 * Math.pow(2.0, (double)n2 * 5.4931640625E-4) + 0.5);
    }

    static boolean au(M688 m688, U691 u691, int[] arrn, int n, int n2) {
        u691.k = Cd585.h / 100;
        if (u691.u >= 0 && (u691.n == null || Cs635.bp(u691.n))) {
            U691.g(u691);
            U691.ef(u691);
            if (u691.e > 0 && m688.c[u691.g][u691.e] == u691) {
                m688.c[u691.g][u691.e] = null;
            }
            return true;
        }
        int n3 = u691.v;
        if (n3 > 0) {
            if ((n3 -= (int)(16.0 * Math.pow(2.0, (double)m688.x[u691.g] * 4.921259842519685E-4) + 0.5)) < 0) {
                n3 = 0;
            }
            u691.v = n3;
        }
        Cs635.bf(u691.n, M688.as(m688, u691));
        V686 v686 = u691.j;
        boolean bl = false;
        ++u691.t;
        u691.m += v686.b;
        double d = (double)((u691.h - 60 << 8) + (u691.r * u691.v >> 12)) * 5.086263020833333E-6;
        if (v686.q > 0) {
            u691.y = v686.h > 0 ? (u691.y += (int)(128.0 * Math.pow(2.0, d * (double)v686.h) + 0.5)) : (u691.y += 128);
            if (u691.y * v686.q >= 819200) {
                bl = true;
            }
        }
        if (v686.g != null) {
            u691.p = v686.j > 0 ? (u691.p += (int)(128.0 * Math.pow(2.0, d * (double)v686.j) + 0.5)) : (u691.p += 128);
            while (u691.x < v686.g.length - 2 && u691.p > (v686.g[u691.x + 2] & 0xFF) << 8) {
                u691.x += 2;
            }
            if (u691.x == v686.g.length - 2 && v686.g[u691.x + 1] == 0) {
                bl = true;
            }
        }
        if (u691.u >= 0 && v686.d != null && (m688.m[u691.g] & 1) == 0 && (u691.e < 0 || m688.c[u691.g][u691.e] != u691)) {
            u691.u = v686.e > 0 ? (u691.u += (int)(128.0 * Math.pow(2.0, d * (double)v686.e) + 0.5)) : (u691.u += 128);
            while (u691.z < v686.d.length - 2 && u691.u > (v686.d[u691.z + 2] & 0xFF) << 8) {
                u691.z += 2;
            }
            if (u691.z == v686.d.length - 2) {
                bl = true;
            }
        }
        if (bl) {
            Cs635.bv(u691.n, u691.k);
            if (arrn != null) {
                u691.n.j(arrn, n, n2);
            } else {
                u691.n.e(n2);
            }
            if (Cs635.bm(u691.n)) {
                m688.az.e.h(u691.n);
            }
            U691.g(u691);
            if (u691.u >= 0) {
                U691.ef(u691);
                if (u691.e > 0 && m688.c[u691.g][u691.e] == u691) {
                    m688.c[u691.g][u691.e] = null;
                }
            }
            return true;
        }
        Cs635.br(u691.n, u691.k, M688.ac(m688, u691), M688.at(m688, u691));
        return false;
    }

    private static int ac(M688 m688, U691 u691) {
        int n;
        int n2;
        int n3;
        int n4;
        if (m688.e[u691.g] == 0) {
            return 0;
        }
        V686 v686 = u691.j;
        int n5 = m688.h[u691.g] * m688.b[u691.g] + 4096 >> 13;
        n5 = n5 * n5 + 16384 >> 15;
        n5 = u691.b * n5 + 16384 >> 15;
        n5 = n5 * m688.d + 128 >> 8;
        n5 = n5 * m688.q >> 8;
        n5 = n5 * m688.e[u691.g] + 128 >> 8;
        if (v686.q > 0) {
            n5 = (int)((double)n5 * Math.pow(0.5, 1.953125E-5 * (double)u691.y * (double)v686.q) + 0.5);
        }
        if (v686.g != null) {
            n2 = u691.p;
            n4 = v686.g[u691.x + 1];
            if (u691.x < v686.g.length - 2) {
                n = (v686.g[u691.x] & 0xFF) << 8;
                n3 = (v686.g[u691.x + 2] & 0xFF) << 8;
                n4 += (v686.g[u691.x + 3] - n4) * (n2 - n) / (n3 - n);
            }
            n5 = n5 * n4 + 32 >> 6;
        }
        if (u691.u > 0 && v686.d != null) {
            n2 = u691.u;
            n4 = v686.d[u691.z + 1];
            if (u691.z < v686.d.length - 2) {
                n = (v686.d[u691.z] & 0xFF) << 8;
                n3 = (v686.d[u691.z + 2] & 0xFF) << 8;
                n4 += (v686.d[u691.z + 3] - n4) * (n2 - n) / (n3 - n);
            }
            n5 = n5 * n4 + 32 >> 6;
        }
        return n5;
    }

    public static synchronized void z(M688 m688, P689 p689, boolean bl, boolean bl2) {
        M688.n(m688, bl2);
        m688.ag.g(p689.q);
        m688.aq = bl;
        m688.af = 0L;
        int n = Z693.j(m688.ag);
        for (int i = 0; i < n; ++i) {
            Z693.e(m688.ag, i);
            Z693.b(m688.ag, i);
            Z693.h(m688.ag, i);
        }
        m688.ai = Z693.y(m688.ag);
        m688.al = m688.ag.s[m688.ai];
        m688.av = Z693.v(m688.ag, m688.al);
    }

    public static synchronized void v(M688 m688) {
        Y692 y692 = (Y692)Ha262.e(m688.g);
        while (y692 != null) {
            Y692.q(y692);
            y692 = (Y692)Ha262.h(m688.g);
        }
    }

    @Override
    protected synchronized Cx556 d() {
        return null;
    }

    @Override
    public synchronized void j(int[] arrn, int n, int n2) {
        if (Z693.q(this.ag)) {
            int n3 = this.j * this.ag.q / Cd585.h;
            do {
                long l;
                if (this.av - (l = this.af + (long)n3 * (long)n2) >= 0L) {
                    this.af = l;
                    break;
                }
                int n4 = (int)((this.av - this.af + (long)n3 - 1L) / (long)n3);
                this.af += (long)n3 * (long)n4;
                this.az.j(arrn, n, n4);
                n += n4;
                n2 -= n4;
                M688.ar(this);
            } while (Z693.q(this.ag));
        }
        this.az.j(arrn, n, n2);
    }

    @Override
    public synchronized void e(int n) {
        if (Z693.q(this.ag)) {
            int n2 = this.j * this.ag.q / Cd585.h;
            do {
                long l;
                if (this.av - (l = this.af + (long)n2 * (long)n) >= 0L) {
                    this.af = l;
                    break;
                }
                int n3 = (int)((this.av - this.af + (long)n2 - 1L) / (long)n2);
                this.af += (long)n2 * (long)n3;
                this.az.e(n3);
                n -= n3;
                M688.ar(this);
            } while (Z693.q(this.ag));
        }
        this.az.e(n);
    }

    private static void ab(M688 m688, long l) {
        while (m688.av < l) {
            boolean bl = M688.aw(m688);
            if (!bl) continue;
            return;
        }
    }

    private static boolean aw(M688 m688) {
        boolean bl = false;
        int n = m688.ai;
        int n2 = m688.al;
        long l = m688.av;
        while (!bl && n2 == m688.al) {
            while (m688.ag.s[n] == n2) {
                Z693.e(m688.ag, n);
                int n3 = m688.ag.l(n);
                if (n3 == 1) {
                    Z693.s(m688.ag);
                    Z693.h(m688.ag, n);
                    if (!Z693.p(m688.ag)) break;
                    if (m688.aq && n2 != 0) {
                        Z693.x(m688.ag, l);
                        bl = true;
                        m688.al = 0;
                        break;
                    }
                    M688.ap(m688, true);
                    Z693.d(m688.ag);
                    return true;
                }
                if ((n3 & 0x80) != 0) {
                    M688.an(m688, n3, false);
                }
                Z693.b(m688.ag, n);
                Z693.h(m688.ag, n);
            }
            m688.af = l;
            n = Z693.y(m688.ag);
            n2 = m688.ag.s[n];
            l = Z693.v(m688.ag, n2);
        }
        m688.ai = n;
        m688.al = n2;
        m688.av = l;
        return bl;
    }

    private static void ar(M688 m688) {
        int n = m688.ai;
        int n2 = m688.al;
        long l = m688.av;
        if (m688.ah != null && n2 == m688.ap) {
            M688.z(m688, m688.ah, m688.aq, m688.ao);
            M688.ar(m688);
            return;
        }
        while (n2 == m688.al) {
            while (m688.ag.s[n] == n2) {
                Z693.e(m688.ag, n);
                int n3 = m688.ag.l(n);
                if (n3 == 1) {
                    Z693.s(m688.ag);
                    Z693.h(m688.ag, n);
                    if (!Z693.p(m688.ag)) break;
                    if (m688.ah != null) {
                        M688.u(m688, m688.ah, m688.aq);
                        M688.ar(m688);
                        return;
                    }
                    if (m688.aq && n2 != 0) {
                        Z693.x(m688.ag, l);
                        m688.al = 0;
                        break;
                    }
                    M688.ap(m688, true);
                    Z693.d(m688.ag);
                    return;
                }
                if ((n3 & 0x80) != 0) {
                    M688.an(m688, n3, true);
                }
                Z693.b(m688.ag, n);
                Z693.h(m688.ag, n);
            }
            n = Z693.y(m688.ag);
            n2 = m688.ag.s[n];
            l = Z693.v(m688.ag, n2);
        }
        m688.ai = n;
        m688.al = n2;
        m688.av = l;
        if (m688.ah != null && m688.ap < n2) {
            m688.ai = -1;
            m688.al = m688.ap;
            m688.av = Z693.v(m688.ag, m688.al);
        }
    }

    static boolean ax(M688 m688, U691 u691) {
        if (u691.n == null) {
            if (u691.u >= 0) {
                U691.ef(u691);
                if (u691.e > 0 && m688.c[u691.g][u691.e] == u691) {
                    m688.c[u691.g][u691.e] = null;
                }
            }
            return true;
        }
        return false;
    }

    public M688() {
        this.b = new int[16];
        this.l = new int[16];
        this.r = new int[16];
        this.v = new int[16];
        this.y = new int[16];
        this.p = new int[16];
        this.x = new int[16];
        this.m = new int[16];
        this.n = new int[16];
        this.k = new int[16];
        this.i = new int[16];
        this.o = new int[16];
        this.a = new int[16];
        this.f = new U691[16][128];
        this.c = new U691[16][128];
        this.ag = new Z693();
        this.az = new T690(this);
        this.g = new Ha262(128);
        M688.s(this, -1, 256);
        M688.ap(this, true);
    }

    private static void aa(M688 m688, int n) {
        if ((m688.m[n] & 4) != 0) {
            U691 u691 = (U691)Gx298.i(m688.az.j);
            while (u691 != null) {
                if (u691.g == n) {
                    u691.o = 0;
                }
                u691 = (U691)Gx298.c(m688.az.j);
            }
        }
    }

    private static int as(M688 m688, U691 u691) {
        int n;
        int n2 = u691.w + (u691.r * u691.v >> 12);
        n2 += (m688.y[u691.g] - 8192) * m688.k[u691.g] >> 12;
        V686 v686 = u691.j;
        if (v686.b > 0 && (v686.s > 0 || m688.p[u691.g] > 0)) {
            n = v686.s << 2;
            int n3 = v686.l << 1;
            if (u691.t < n3) {
                n = n * u691.t / n3;
            }
            double d = Math.sin((double)(u691.m & 0x1FF) * 0.01227184630308513);
            n2 += (int)(d * (double)(n += m688.p[u691.g] >> 7));
        }
        return (n = (int)((double)(256 * u691.q.g) * Math.pow(2.0, (double)n2 * 3.255208333333333E-4) / (double)Cd585.h + 0.5)) < 1 ? 1 : n;
    }

    public static synchronized void u(M688 m688, P689 p689, boolean bl) {
        M688.z(m688, p689, bl, true);
    }

    private static void o(M688 m688, int n, int n2) {
        if (n2 != m688.r[n]) {
            m688.r[n] = n2;
            for (int i = 0; i < 128; ++i) {
                m688.c[n][i] = null;
            }
        }
    }

    private static void aq(M688 m688, int n, int n2) {
    }

    public static synchronized void s(M688 m688, int n, int n2) {
        if (n < 0) {
            for (int i = 0; i < 16; ++i) {
                m688.e[i] = n2;
            }
        } else {
            m688.e[n] = n2;
        }
    }

    private static void av(M688 m688, int n) {
        U691 u691 = (U691)Gx298.i(m688.az.j);
        while (u691 != null) {
            if ((n < 0 || u691.g == n) && u691.u < 0) {
                m688.f[u691.g][u691.h] = null;
                u691.u = 0;
            }
            u691 = (U691)Gx298.c(m688.az.j);
        }
    }

    public static synchronized void h(M688 m688, int n) {
        m688.d = n;
    }

    @Override
    protected synchronized Cx556 g() {
        return this.az;
    }
}

