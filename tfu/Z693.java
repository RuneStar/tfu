/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Gg3;

public class Z693 {
    private static final boolean g = true;
    public static final int p = 1;
    public static final int u = 3;
    private static final byte[] v = new byte[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static final int w = 500000;
    public static final int x = 2;
    public static final int y = 0;
    private int[] b;
    public Gg3 d = new Gg3(null);
    private int[] e;
    private int[] h;
    private int[] j;
    public int l;
    public int q;
    private long r;
    public int[] s;

    public static void x(Z693 z693, long l) {
        z693.r = l;
        int n = z693.h.length;
        for (int i = 0; i < n; ++i) {
            z693.s[i] = 0;
            z693.b[i] = 0;
            z693.d.v = z693.j[i];
            Z693.b(z693, i);
            z693.h[i] = z693.d.v;
        }
    }

    public static boolean q(Z693 z693) {
        return z693.d.r != null;
    }

    public static int j(Z693 z693) {
        return z693.h.length;
    }

    private int w(int n) {
        int n2 = this.d.r[this.d.v];
        if (n2 < 0) {
            this.b[n] = n2 &= 0xFF;
            ++this.d.v;
        } else {
            n2 = this.b[n];
            if (n2 == 0) {
                throw new RuntimeException();
            }
        }
        if (n2 == 240 || n2 == 247) {
            int n3;
            int n4 = Gg3.bn(this.d);
            if (n2 == 247 && n4 > 0 && ((n3 = this.d.r[this.d.v] & 0xFF) >= 241 && n3 <= 243 || n3 == 246 || n3 == 248 || n3 >= 250 && n3 <= 252 || n3 == 254)) {
                ++this.d.v;
                this.b[n] = n3;
                return Z693.r(this, n, n3);
            }
            this.d.v += n4;
            return 0;
        }
        return Z693.r(this, n, n2);
    }

    public Z693() {
    }

    public static void e(Z693 z693, int n) {
        z693.d.v = z693.h[n];
    }

    public static void h(Z693 z693, int n) {
        z693.h[n] = z693.d.v;
    }

    public static void b(Z693 z693, int n) {
        int n2 = Gg3.bn(z693.d);
        int[] arrn = z693.s;
        int n3 = n;
        arrn[n3] = arrn[n3] + n2;
    }

    public void g(byte[] arrby) {
        this.d.r = arrby;
        this.d.v = 0;
        if (Gg3.bd(this.d) != 1297377380) {
            throw new RuntimeException();
        }
        if (Gg3.bd(this.d) != 6) {
            throw new RuntimeException();
        }
        int n = Gg3.au(this.d);
        if (n >= 2) {
            throw new RuntimeException();
        }
        int n2 = Gg3.au(this.d);
        if (n2 == 0 || n == 0 && n2 > 1) {
            throw new RuntimeException();
        }
        this.q = Gg3.au(this.d);
        this.l = 500000;
        if (this.q >= 32768) {
            throw new RuntimeException();
        }
        this.j = new int[n2];
        this.e = new int[n2];
        n = 0;
        while (n < n2) {
            if (this.d.v + 8 > this.d.r.length) {
                throw new RuntimeException();
            }
            int n3 = Gg3.bd(this.d);
            int n4 = Gg3.bd(this.d);
            if (this.d.v + n4 > this.d.r.length) {
                throw new RuntimeException();
            }
            if (n3 == 1297379947) {
                this.j[n] = this.d.v;
                this.e[n] = this.d.v + n4;
                ++n;
            }
            this.d.v += n4;
        }
        this.r = 0L;
        this.h = new int[n2];
        for (n = 0; n < n2; ++n) {
            this.h[n] = this.j[n];
        }
        this.s = new int[n2];
        this.b = new int[n2];
    }

    public static void s(Z693 z693) {
        z693.d.v = -1;
    }

    private static int r(Z693 z693, int n, int n2) {
        if (n2 == 255) {
            int n3 = Gg3.ar(z693.d);
            int n4 = Gg3.bn(z693.d);
            if (n3 == 47) {
                z693.d.v += n4;
                return 1;
            }
            if (n3 == 81) {
                int n5 = Gg3.ay(z693.d);
                int n6 = z693.s[n];
                z693.r += (long)n6 * (long)(z693.l - n5);
                z693.l = n5;
                z693.d.v += (n4 -= 3);
                return 2;
            }
            z693.d.v += n4;
            return 3;
        }
        byte by = v[n2 - 128];
        int n7 = n2;
        if (by >= 1) {
            n7 |= Gg3.ar(z693.d) << 8;
        }
        if (by >= 2) {
            n7 |= Gg3.ar(z693.d) << 16;
        }
        return n7;
    }

    public static long v(Z693 z693, int n) {
        return z693.r + (long)n * (long)z693.l;
    }

    public static int y(Z693 z693) {
        int n = z693.h.length;
        int n2 = -1;
        int n3 = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            if (z693.h[i] < 0 || z693.s[i] >= n3) continue;
            n2 = i;
            n3 = z693.s[i];
        }
        return n2;
    }

    public static boolean p(Z693 z693) {
        int n = z693.h.length;
        for (int i = 0; i < n; ++i) {
            if (z693.h[i] < 0) continue;
            return false;
        }
        return true;
    }

    public Z693(byte[] arrby) {
        this.g(arrby);
    }

    public int l(int n) {
        int n2 = this.w(n);
        if (this.d.v > this.e[n]) {
            throw new RuntimeException();
        }
        return n2;
    }

    public static void d(Z693 z693) {
        z693.d.r = null;
        z693.j = null;
        z693.e = null;
        z693.h = null;
        z693.s = null;
        z693.b = null;
    }
}

