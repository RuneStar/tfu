// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.js5.js5;

public class M688 extends Cx556
{
    static final int t = 4;
    static final int u = 1;
    static final int z = 2;
    int[] a;
    private R694 aa;
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
    private int d;
    int[] e;
    private U691[][] f;
    private Ha262 g;
    private int[] h;
    int[] i;
    private int j;
    private int[] k;
    private int[] l;
    int[] m;
    private int[] n;
    private int[] o;
    private int[] p;
    private int q;
    private int[] r;
    private int[] s;
    private int[] v;
    private int[] x;
    private int[] y;
    
    private static void ap(final M688 m688, final boolean b) {
        if (b) {
            al(m688, -1);
        }
        else {
            av(m688, -1);
        }
        af(m688, -1);
        for (int i = 0; i < 16; ++i) {
            m688.r[i] = m688.l[i];
        }
        for (int j = 0; j < 16; ++j) {
            m688.v[j] = (m688.l[j] & 0xFFFFFF80);
        }
    }
    
    public M688(final M688 m688) {
        this.d = 256;
        this.q = 256;
        this.j = 1000000;
        this.e = new int[16];
        this.h = new int[16];
        this.s = new int[16];
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
        this.aa = null;
        this.g = m688.g;
        s(this, -1, 256);
        ap(this, true);
    }
    
    public static synchronized boolean r(final M688 m688, final P689 p5, final js5 js5, final Ca649 ca649, final int n) {
        p5.d();
        boolean b = true;
        int[] array = null;
        if (n > 0) {
            array = new int[] { n };
        }
        for (Ld263 ld263 = (Ld263)Ha262.e(p5.d); ld263 != null; ld263 = (Ld263)Ha262.h(p5.d)) {
            final int n2 = (int)ld263.bq;
            Y692 g = (Y692)Ha262.d(m688.g, n2);
            if (g == null) {
                g = Y692.g(js5, n2);
                if (g == null) {
                    b = false;
                    continue;
                }
                Ha262.q(m688.g, g, n2);
            }
            if (!Y692.d(g, ca649, (byte[])ld263.g, array)) {
                b = false;
            }
        }
        if (b) {
            P689.q(p5);
        }
        return b;
    }
    
    private static int at(final M688 m688, final U691 u691) {
        final int n = m688.s[u691.g];
        if (n < 8192) {
            return n * u691.l + 32 >> 6;
        }
        return 16384 - ((16384 - n) * (128 - u691.l) + 32 >> 6);
    }
    
    public static synchronized void t(final M688 m688, final P689 p5, final boolean b, final boolean b2, final long n) {
        z(m688, p5, b, b2);
        ab(m688, n * m688.ag.q);
    }
    
    public static synchronized void m(final M688 m688) {
        n(m688, true);
    }
    
    public static synchronized void n(final M688 m688, final boolean b) {
        Z693.d(m688.ag);
        m688.ah = null;
        ap(m688, b);
    }
    
    private static void i(final M688 m688, final int n, final int n2) {
        m688.l[n] = n2;
        m688.v[n] = (n2 & 0xFFFFFF80);
        o(m688, n, n2);
    }
    
    private void a(final int g, final int n, final int s) {
        c(this, g, n, 64);
        if ((this.m[g] & 0x2) != 0x0) {
            for (U691 u691 = (U691)Gx298.a(this.az.j); u691 != null; u691 = (U691)Gx298.ag(this.az.j)) {
                if (u691.g == g && u691.u < 0) {
                    this.f[g][u691.h] = null;
                    this.f[g][n] = u691;
                    final int n2 = u691.w + (u691.r * u691.v >> 12);
                    final U691 u692 = u691;
                    u692.w += n - u691.h << 8;
                    u691.r = n2 - u691.w;
                    u691.v = 4096;
                    u691.h = n;
                    return;
                }
            }
        }
        final Y692 d = (Y692)Ha262.d(this.g, this.r[g]);
        if (d == null) {
            return;
        }
        final Cw634 q = d.d[n];
        if (q == null) {
            return;
        }
        final U691 u693 = new U691();
        u693.g = g;
        u693.d = d;
        u693.q = q;
        u693.j = d.h[n];
        u693.e = d.s[n];
        u693.h = n;
        u693.s = s;
        u693.b = s * s * d.g * d.j[n] + 1024 >> 11;
        u693.l = (d.e[n] & 0xFF);
        u693.w = (n << 8) - (d.q[n] & 0x7FFF);
        u693.y = 0;
        u693.p = 0;
        u693.x = 0;
        u693.u = -1;
        u693.z = 0;
        if (this.i[g] == 0) {
            u693.n = q.d(as(this, u693), ac(this, u693), at(this, u693));
        }
        else {
            u693.n = q.d(as(this, u693), 0, at(this, u693));
            f(this, u693, d.q[n] < 0);
        }
        if (d.q[n] < 0) {
            Cs635.bq(u693.n, -1);
        }
        if (u693.e >= 0) {
            final U691 u694 = this.c[g][u693.e];
            if (u694 != null && u694.u < 0) {
                this.f[g][u694.h] = null;
                u694.u = 0;
            }
            this.c[g][u693.e] = u693;
        }
        Gx298.t(this.az.j, u693);
        this.f[g][n] = u693;
    }
    
    static void f(final M688 m688, final U691 u691, final boolean b) {
        final int g = u691.q.g();
        int n;
        if (b && u691.q.j) {
            n = (int)(m688.i[u691.g] * (long)(g + g - u691.q.d) >> 6);
            final int n2 = g << 8;
            if (n >= n2) {
                n = n2 + n2 - 1 - n;
                Cs635.bh(u691.n, true);
            }
        }
        else {
            n = (int)(m688.i[u691.g] * (long)g >> 6);
        }
        Cs635.bk(u691.n, n);
    }
    
    private static void c(final M688 m688, final int n, final int n2, final int n3) {
        final U691 u691 = m688.f[n][n2];
        if (u691 == null) {
            return;
        }
        m688.f[n][n2] = null;
        if ((m688.m[n] & 0x2) != 0x0) {
            for (U691 u692 = (U691)Gx298.i(m688.az.j); u692 != null; u692 = (U691)Gx298.c(m688.az.j)) {
                if (u692.g == u691.g && u692.u < 0 && u692 != u691) {
                    u691.u = 0;
                    break;
                }
            }
        }
        else {
            u691.u = 0;
        }
    }
    
    private static void ag(final M688 m688, final int n, final int n2, final int n3) {
    }
    
    private static void ai(final M688 m688, final int n, final int n2) {
        m688.y[n] = n2;
    }
    
    private static void al(final M688 m688, final int n) {
        for (U691 u691 = (U691)Gx298.i(m688.az.j); u691 != null; u691 = (U691)Gx298.c(m688.az.j)) {
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
                Ln265.ef(u691);
            }
        }
    }
    
    @Override
    protected synchronized int q() {
        return 0;
    }
    
    private static void ao(final M688 m688, final int n) {
        if ((m688.m[n] & 0x2) != 0x0) {
            for (U691 u691 = (U691)Gx298.i(m688.az.j); u691 != null; u691 = (U691)Gx298.c(m688.az.j)) {
                if (u691.g == n && m688.f[n][u691.h] == null && u691.u < 0) {
                    u691.u = 0;
                }
            }
        }
    }
    
    private static void af(final M688 m688, int i) {
        if (i < 0) {
            for (i = 0; i < 16; ++i) {
                af(m688, i);
            }
            return;
        }
        m688.h[i] = 12800;
        m688.s[i] = 8192;
        m688.b[i] = 16383;
        m688.y[i] = 8192;
        m688.p[i] = 0;
        m688.x[i] = 8192;
        ao(m688, i);
        aa(m688, i);
        m688.m[i] = 0;
        m688.n[i] = 32767;
        m688.k[i] = 256;
        m688.i[i] = 0;
        am(m688, i, 8192);
    }
    
    private static void an(final M688 m688, final int n, final boolean b) {
        final int n2 = n & 0xF0;
        if (n2 == 128) {
            c(m688, n & 0xF, n >> 8 & 0x7F, n >> 16 & 0x7F);
            return;
        }
        if (n2 == 144) {
            final int n3 = n & 0xF;
            final int n4 = n >> 8 & 0x7F;
            final int n5 = n >> 16 & 0x7F;
            if (n5 > 0) {
                if (b) {
                    m688.a(n3, n4, n5);
                }
            }
            else {
                c(m688, n3, n4, 64);
            }
            return;
        }
        if (n2 == 160) {
            ag(m688, n & 0xF, n >> 8 & 0x7F, n >> 16 & 0x7F);
            return;
        }
        if (n2 == 176) {
            final int n6 = n & 0xF;
            final int n7 = n >> 8 & 0x7F;
            final int n8 = n >> 16 & 0x7F;
            if (n7 == 0) {
                m688.v[n6] = (m688.v[n6] & 0xFFE03FFF) + (n8 << 14);
            }
            if (n7 == 32) {
                m688.v[n6] = (m688.v[n6] & 0xFFFFC07F) + (n8 << 7);
            }
            if (n7 == 1) {
                m688.p[n6] = (m688.p[n6] & 0xFFFFC07F) + (n8 << 7);
            }
            if (n7 == 33) {
                m688.p[n6] = (m688.p[n6] & 0xFFFFFF80) + n8;
            }
            if (n7 == 5) {
                m688.x[n6] = (m688.x[n6] & 0xFFFFC07F) + (n8 << 7);
            }
            if (n7 == 37) {
                m688.x[n6] = (m688.x[n6] & 0xFFFFFF80) + n8;
            }
            if (n7 == 7) {
                m688.h[n6] = (m688.h[n6] & 0xFFFFC07F) + (n8 << 7);
            }
            if (n7 == 39) {
                m688.h[n6] = (m688.h[n6] & 0xFFFFFF80) + n8;
            }
            if (n7 == 10) {
                m688.s[n6] = (m688.s[n6] & 0xFFFFC07F) + (n8 << 7);
            }
            if (n7 == 42) {
                m688.s[n6] = (m688.s[n6] & 0xFFFFFF80) + n8;
            }
            if (n7 == 11) {
                m688.b[n6] = (m688.b[n6] & 0xFFFFC07F) + (n8 << 7);
            }
            if (n7 == 43) {
                m688.b[n6] = (m688.b[n6] & 0xFFFFFF80) + n8;
            }
            if (n7 == 64) {
                if (n8 >= 64) {
                    final int[] i = m688.m;
                    final int n9 = n6;
                    i[n9] |= 0x1;
                }
                else {
                    final int[] j = m688.m;
                    final int n10 = n6;
                    j[n10] &= 0xFFFFFFFE;
                }
            }
            if (n7 == 20 && m688.aa != null) {
                m688.aa.g(n6, n8);
            }
            if (n7 == 65) {
                if (n8 >= 64) {
                    final int[] k = m688.m;
                    final int n11 = n6;
                    k[n11] |= 0x2;
                }
                else {
                    ao(m688, n6);
                    final int[] l = m688.m;
                    final int n12 = n6;
                    l[n12] &= 0xFFFFFFFD;
                }
            }
            if (n7 == 99) {
                m688.n[n6] = (m688.n[n6] & 0x7F) + (n8 << 7);
            }
            if (n7 == 98) {
                m688.n[n6] = (m688.n[n6] & 0x3F80) + n8;
            }
            if (n7 == 101) {
                m688.n[n6] = 16384 + (m688.n[n6] & 0x7F) + (n8 << 7);
            }
            if (n7 == 100) {
                m688.n[n6] = 16384 + (m688.n[n6] & 0x3F80) + n8;
            }
            if (n7 == 120) {
                al(m688, n6);
            }
            if (n7 == 121) {
                af(m688, n6);
            }
            if (n7 == 123) {
                av(m688, n6);
            }
            if (n7 == 6 && m688.n[n6] == 16384) {
                m688.k[n6] = (m688.k[n6] & 0xFFFFC07F) + (n8 << 7);
            }
            if (n7 == 38 && m688.n[n6] == 16384) {
                m688.k[n6] = (m688.k[n6] & 0xFFFFFF80) + n8;
            }
            if (n7 == 16) {
                m688.i[n6] = (m688.i[n6] & 0xFFFFC07F) + (n8 << 7);
            }
            if (n7 == 48) {
                m688.i[n6] = (m688.i[n6] & 0xFFFFFF80) + n8;
            }
            if (n7 == 81) {
                if (n8 >= 64) {
                    final int[] m689 = m688.m;
                    final int n13 = n6;
                    m689[n13] |= 0x4;
                }
                else {
                    aa(m688, n6);
                    final int[] m690 = m688.m;
                    final int n14 = n6;
                    m690[n14] &= 0xFFFFFFFB;
                }
            }
            if (n7 == 17) {
                am(m688, n6, (m688.o[n6] & 0xFFFFC07F) + (n8 << 7));
            }
            if (n7 == 49) {
                am(m688, n6, (m688.o[n6] & 0xFFFFFF80) + n8);
            }
            return;
        }
        if (n2 == 192) {
            final int n15 = n & 0xF;
            o(m688, n15, m688.v[n15] + (n >> 8 & 0x7F));
            return;
        }
        if (n2 == 208) {
            aq(m688, n & 0xF, n >> 8 & 0x7F);
            return;
        }
        if (n2 == 224) {
            ai(m688, n & 0xF, (n >> 9 & 0x3F80) + (n >> 8 & 0x7F));
            return;
        }
        if ((n & 0xFF) == 0xFF) {
            ap(m688, true);
        }
    }
    
    static void am(final M688 m688, final int n, final int n2) {
        m688.o[n] = n2;
        m688.a[n] = (int)(2097152.0 * Math.pow(2.0, n2 * 5.4931640625E-4) + 0.5);
    }
    
    static boolean au(final M688 m688, final U691 u691, final int[] array, final int n, final int n2) {
        u691.k = Cd585.h / 100;
        if (u691.u >= 0 && (u691.n == null || Cs635.bp(u691.n))) {
            U691.g(u691);
            Ln265.ef(u691);
            if (u691.e > 0 && m688.c[u691.g][u691.e] == u691) {
                m688.c[u691.g][u691.e] = null;
            }
            return true;
        }
        final int v = u691.v;
        if (v > 0) {
            int v2 = v - (int)(16.0 * Math.pow(2.0, m688.x[u691.g] * 4.921259842519685E-4) + 0.5);
            if (v2 < 0) {
                v2 = 0;
            }
            u691.v = v2;
        }
        Cs635.bf(u691.n, as(m688, u691));
        final V686 j = u691.j;
        boolean b = false;
        ++u691.t;
        u691.m += j.b;
        final double n3 = ((u691.h - 60 << 8) + (u691.r * u691.v >> 12)) * 5.086263020833333E-6;
        if (j.q > 0) {
            if (j.h > 0) {
                u691.y += (int)(128.0 * Math.pow(2.0, n3 * j.h) + 0.5);
            }
            else {
                u691.y += 128;
            }
            if (u691.y * j.q >= 819200) {
                b = true;
            }
        }
        if (j.g != null) {
            if (j.j > 0) {
                u691.p += (int)(128.0 * Math.pow(2.0, n3 * j.j) + 0.5);
            }
            else {
                u691.p += 128;
            }
            while (u691.x < j.g.length - 2 && u691.p > (j.g[u691.x + 2] & 0xFF) << 8) {
                u691.x += 2;
            }
            if (u691.x == j.g.length - 2 && j.g[u691.x + 1] == 0) {
                b = true;
            }
        }
        if (u691.u >= 0 && j.d != null && (m688.m[u691.g] & 0x1) == 0x0 && (u691.e < 0 || m688.c[u691.g][u691.e] != u691)) {
            if (j.e > 0) {
                u691.u += (int)(128.0 * Math.pow(2.0, n3 * j.e) + 0.5);
            }
            else {
                u691.u += 128;
            }
            while (u691.z < j.d.length - 2 && u691.u > (j.d[u691.z + 2] & 0xFF) << 8) {
                u691.z += 2;
            }
            if (u691.z == j.d.length - 2) {
                b = true;
            }
        }
        if (b) {
            Cs635.bv(u691.n, u691.k);
            if (array != null) {
                u691.n.j(array, n, n2);
            }
            else {
                u691.n.e(n2);
            }
            if (Cs635.bm(u691.n)) {
                m688.az.e.h(u691.n);
            }
            U691.g(u691);
            if (u691.u >= 0) {
                Ln265.ef(u691);
                if (u691.e > 0 && m688.c[u691.g][u691.e] == u691) {
                    m688.c[u691.g][u691.e] = null;
                }
            }
            return true;
        }
        Cs635.br(u691.n, u691.k, ac(m688, u691), at(m688, u691));
        return false;
    }
    
    private static int ac(final M688 m688, final U691 u691) {
        if (m688.e[u691.g] == 0) {
            return 0;
        }
        final V686 j = u691.j;
        final int n = m688.h[u691.g] * m688.b[u691.g] + 4096 >> 13;
        int n2 = (((u691.b * (n * n + 16384 >> 15) + 16384 >> 15) * m688.d + 128 >> 8) * m688.q >> 8) * m688.e[u691.g] + 128 >> 8;
        if (j.q > 0) {
            n2 = (int)(n2 * Math.pow(0.5, 1.953125E-5 * u691.y * j.q) + 0.5);
        }
        if (j.g != null) {
            final int p2 = u691.p;
            int n3 = j.g[u691.x + 1];
            if (u691.x < j.g.length - 2) {
                final int n4 = (j.g[u691.x] & 0xFF) << 8;
                n3 += (j.g[u691.x + 3] - n3) * (p2 - n4) / (((j.g[u691.x + 2] & 0xFF) << 8) - n4);
            }
            n2 = n2 * n3 + 32 >> 6;
        }
        if (u691.u > 0 && j.d != null) {
            final int u692 = u691.u;
            int n5 = j.d[u691.z + 1];
            if (u691.z < j.d.length - 2) {
                final int n6 = (j.d[u691.z] & 0xFF) << 8;
                n5 += (j.d[u691.z + 3] - n5) * (u692 - n6) / (((j.d[u691.z + 2] & 0xFF) << 8) - n6);
            }
            n2 = n2 * n5 + 32 >> 6;
        }
        return n2;
    }
    
    public static synchronized void z(final M688 m688, final P689 p4, final boolean aq, final boolean b) {
        n(m688, b);
        m688.ag.g(p4.q);
        m688.aq = aq;
        m688.af = 0L;
        for (int j = Z693.j(m688.ag), i = 0; i < j; ++i) {
            Z693.e(m688.ag, i);
            Z693.b(m688.ag, i);
            Z693.h(m688.ag, i);
        }
        m688.ai = Z693.y(m688.ag);
        m688.al = m688.ag.s[m688.ai];
        m688.av = Z693.v(m688.ag, m688.al);
    }
    
    public static synchronized void v(final M688 m688) {
        for (Y692 y692 = (Y692)Ha262.e(m688.g); y692 != null; y692 = (Y692)Ha262.h(m688.g)) {
            Y692.q(y692);
        }
    }
    
    @Override
    protected synchronized Cx556 d() {
        return null;
    }
    
    @Override
    public synchronized void j(final int[] array, int n, int n2) {
        if (Z693.q(this.ag)) {
            final int n3 = this.j * this.ag.q / Cd585.h;
            do {
                final long af = this.af + n3 * (long)n2;
                if (this.av - af >= 0L) {
                    this.af = af;
                    break;
                }
                final int n4 = (int)((this.av - this.af + n3 - 1L) / n3);
                this.af += n3 * (long)n4;
                this.az.j(array, n, n4);
                n += n4;
                n2 -= n4;
                ar(this);
            } while (Z693.q(this.ag));
        }
        this.az.j(array, n, n2);
    }
    
    @Override
    public synchronized void e(int n) {
        if (Z693.q(this.ag)) {
            final int n2 = this.j * this.ag.q / Cd585.h;
            do {
                final long af = this.af + n2 * (long)n;
                if (this.av - af >= 0L) {
                    this.af = af;
                    break;
                }
                final int n3 = (int)((this.av - this.af + n2 - 1L) / n2);
                this.af += n2 * (long)n3;
                this.az.e(n3);
                n -= n3;
                ar(this);
            } while (Z693.q(this.ag));
        }
        this.az.e(n);
    }
    
    private static void ab(final M688 m688, final long n) {
        while (m688.av < n) {
            if (aw(m688)) {
                return;
            }
        }
    }
    
    private static boolean aw(final M688 m688) {
        boolean b = false;
        int ai = m688.ai;
        int al = m688.al;
        long n = m688.av;
        while (!b && al == m688.al) {
            while (m688.ag.s[ai] == al) {
                Z693.e(m688.ag, ai);
                final int l = m688.ag.l(ai);
                if (l == 1) {
                    Z693.s(m688.ag);
                    Z693.h(m688.ag, ai);
                    if (!Z693.p(m688.ag)) {
                        break;
                    }
                    if (m688.aq && al != 0) {
                        Z693.x(m688.ag, n);
                        b = true;
                        m688.al = 0;
                        break;
                    }
                    ap(m688, true);
                    Z693.d(m688.ag);
                    return true;
                }
                else {
                    if ((l & 0x80) != 0x0) {
                        an(m688, l, false);
                    }
                    Z693.b(m688.ag, ai);
                    Z693.h(m688.ag, ai);
                }
            }
            m688.af = n;
            ai = Z693.y(m688.ag);
            al = m688.ag.s[ai];
            n = Z693.v(m688.ag, al);
        }
        m688.ai = ai;
        m688.al = al;
        m688.av = n;
        return b;
    }
    
    private static void ar(final M688 m688) {
        int ai = m688.ai;
        int i = m688.al;
        long av = m688.av;
        if (m688.ah != null && i == m688.ap) {
            z(m688, m688.ah, m688.aq, m688.ao);
            ar(m688);
            return;
        }
        while (i == m688.al) {
            while (m688.ag.s[ai] == i) {
                Z693.e(m688.ag, ai);
                final int l = m688.ag.l(ai);
                if (l == 1) {
                    Z693.s(m688.ag);
                    Z693.h(m688.ag, ai);
                    if (!Z693.p(m688.ag)) {
                        break;
                    }
                    if (m688.ah != null) {
                        u(m688, m688.ah, m688.aq);
                        ar(m688);
                        return;
                    }
                    if (m688.aq && i != 0) {
                        Z693.x(m688.ag, av);
                        m688.al = 0;
                        break;
                    }
                    ap(m688, true);
                    Z693.d(m688.ag);
                    return;
                }
                else {
                    if ((l & 0x80) != 0x0) {
                        an(m688, l, true);
                    }
                    Z693.b(m688.ag, ai);
                    Z693.h(m688.ag, ai);
                }
            }
            ai = Z693.y(m688.ag);
            i = m688.ag.s[ai];
            av = Z693.v(m688.ag, i);
        }
        m688.ai = ai;
        m688.al = i;
        m688.av = av;
        if (m688.ah != null && m688.ap < i) {
            m688.ai = -1;
            m688.al = m688.ap;
            m688.av = Z693.v(m688.ag, m688.al);
        }
    }
    
    static boolean ax(final M688 m688, final U691 u691) {
        if (u691.n == null) {
            if (u691.u >= 0) {
                Ln265.ef(u691);
                if (u691.e > 0 && m688.c[u691.g][u691.e] == u691) {
                    m688.c[u691.g][u691.e] = null;
                }
            }
            return true;
        }
        return false;
    }
    
    public M688() {
        this.d = 256;
        this.q = 256;
        this.j = 1000000;
        this.e = new int[16];
        this.h = new int[16];
        this.s = new int[16];
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
        this.aa = null;
        this.g = new Ha262(128);
        s(this, -1, 256);
        ap(this, true);
    }
    
    private static void aa(final M688 m688, final int n) {
        if ((m688.m[n] & 0x4) != 0x0) {
            for (U691 u691 = (U691)Gx298.i(m688.az.j); u691 != null; u691 = (U691)Gx298.c(m688.az.j)) {
                if (u691.g == n) {
                    u691.o = 0;
                }
            }
        }
    }
    
    private static int as(final M688 m688, final U691 u691) {
        int n = u691.w + (u691.r * u691.v >> 12) + ((m688.y[u691.g] - 8192) * m688.k[u691.g] >> 12);
        final V686 j = u691.j;
        if (j.b > 0 && (j.s > 0 || m688.p[u691.g] > 0)) {
            int n2 = j.s << 2;
            final int n3 = j.l << 1;
            if (u691.t < n3) {
                n2 = n2 * u691.t / n3;
            }
            n += (int)(Math.sin((u691.m & 0x1FF) * 0.01227184630308513) * (n2 + (m688.p[u691.g] >> 7)));
        }
        final int n4 = (int)(256 * u691.q.g * Math.pow(2.0, n * 3.255208333333333E-4) / Cd585.h + 0.5);
        return (n4 < 1) ? 1 : n4;
    }
    
    public static synchronized void u(final M688 m688, final P689 p3, final boolean b) {
        z(m688, p3, b, true);
    }
    
    private static void o(final M688 m688, final int n, final int n2) {
        if (n2 != m688.r[n]) {
            m688.r[n] = n2;
            for (int i = 0; i < 128; ++i) {
                m688.c[n][i] = null;
            }
        }
    }
    
    private static void aq(final M688 m688, final int n, final int n2) {
    }
    
    public static synchronized void s(final M688 m688, final int n, final int n2) {
        if (n < 0) {
            for (int i = 0; i < 16; ++i) {
                m688.e[i] = n2;
            }
        }
        else {
            m688.e[n] = n2;
        }
    }
    
    private static void av(final M688 m688, final int n) {
        for (U691 u691 = (U691)Gx298.i(m688.az.j); u691 != null; u691 = (U691)Gx298.c(m688.az.j)) {
            if ((n < 0 || u691.g == n) && u691.u < 0) {
                m688.f[u691.g][u691.h] = null;
                u691.u = 0;
            }
        }
    }
    
    public static synchronized void h(final M688 m688, final int d) {
        m688.d = d;
    }
    
    @Override
    protected synchronized Cx556 g() {
        return this.az;
    }
}
