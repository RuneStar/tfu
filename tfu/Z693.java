// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Z693
{
    private static final boolean g = true;
    public static final int p = 1;
    public static final int u = 3;
    private static final byte[] v;
    public static final int w = 500000;
    public static final int x = 2;
    public static final int y = 0;
    private int[] b;
    public Gg3 d;
    private int[] e;
    private int[] h;
    private int[] j;
    public int l;
    public int q;
    private long r;
    public int[] s;
    
    public static void x(final Z693 z693, final long r) {
        z693.r = r;
        for (int length = z693.h.length, i = 0; i < length; ++i) {
            z693.s[i] = 0;
            z693.b[i] = 0;
            z693.d.v = z693.j[i];
            b(z693, i);
            z693.h[i] = z693.d.v;
        }
    }
    
    public static boolean q(final Z693 z693) {
        return z693.d.r != null;
    }
    
    public static int j(final Z693 z693) {
        return z693.h.length;
    }
    
    private int w(final int n) {
        final byte b = this.d.r[this.d.v];
        int n2;
        if (b < 0) {
            n2 = (b & 0xFF);
            this.b[n] = n2;
            final Gg3 d = this.d;
            ++d.v;
        }
        else {
            n2 = this.b[n];
            if (n2 == 0) {
                throw new RuntimeException();
            }
        }
        if (n2 == 240 || n2 == 247) {
            final int bn = Gg3.bn(this.d);
            if (n2 == 247 && bn > 0) {
                final int n3 = this.d.r[this.d.v] & 0xFF;
                if ((n3 >= 241 && n3 <= 243) || n3 == 246 || n3 == 248 || (n3 >= 250 && n3 <= 252) || n3 == 254) {
                    final Gg3 d2 = this.d;
                    ++d2.v;
                    this.b[n] = n3;
                    return r(this, n, n3);
                }
            }
            final Gg3 d3 = this.d;
            d3.v += bn;
            return 0;
        }
        return r(this, n, n2);
    }
    
    public Z693() {
        this.d = new Gg3(null);
    }
    
    public static void e(final Z693 z693, final int n) {
        z693.d.v = z693.h[n];
    }
    
    public static void h(final Z693 z693, final int n) {
        z693.h[n] = z693.d.v;
    }
    
    public static void b(final Z693 z693, final int n) {
        final int bn = Gg3.bn(z693.d);
        final int[] s = z693.s;
        s[n] += bn;
    }
    
    public void g(final byte[] r) {
        this.d.r = r;
        this.d.v = 0;
        if (Gg3.bd(this.d) != 1297377380) {
            throw new RuntimeException();
        }
        if (Gg3.bd(this.d) != 6) {
            throw new RuntimeException();
        }
        final int au = Gg3.au(this.d);
        if (au >= 2) {
            throw new RuntimeException();
        }
        final int au2 = Gg3.au(this.d);
        if (au2 == 0 || (au == 0 && au2 > 1)) {
            throw new RuntimeException();
        }
        this.q = Gg3.au(this.d);
        this.l = 500000;
        if (this.q >= 32768) {
            throw new RuntimeException();
        }
        this.j = new int[au2];
        this.e = new int[au2];
        int i = 0;
        while (i < au2) {
            if (this.d.v + 8 > this.d.r.length) {
                throw new RuntimeException();
            }
            final int bd = Gg3.bd(this.d);
            final int bd2 = Gg3.bd(this.d);
            if (this.d.v + bd2 > this.d.r.length) {
                throw new RuntimeException();
            }
            if (bd == 1297379947) {
                this.j[i] = this.d.v;
                this.e[i] = this.d.v + bd2;
                ++i;
            }
            final Gg3 d = this.d;
            d.v += bd2;
        }
        this.r = 0L;
        this.h = new int[au2];
        for (int j = 0; j < au2; ++j) {
            this.h[j] = this.j[j];
        }
        this.s = new int[au2];
        this.b = new int[au2];
    }
    
    public static void s(final Z693 z693) {
        z693.d.v = -1;
    }
    
    private static int r(final Z693 z693, final int n, final int n2) {
        if (n2 != 255) {
            final byte b = Z693.v[n2 - 128];
            int n3 = n2;
            if (b >= 1) {
                n3 |= Gg3.ar(z693.d) << 8;
            }
            if (b >= 2) {
                n3 |= Gg3.ar(z693.d) << 16;
            }
            return n3;
        }
        final int ar = Gg3.ar(z693.d);
        int bn = Gg3.bn(z693.d);
        if (ar == 47) {
            final Gg3 d = z693.d;
            d.v += bn;
            return 1;
        }
        if (ar == 81) {
            final int ay = Gg3.ay(z693.d);
            bn -= 3;
            z693.r += z693.s[n] * (long)(z693.l - ay);
            z693.l = ay;
            final Gg3 d2 = z693.d;
            d2.v += bn;
            return 2;
        }
        final Gg3 d3 = z693.d;
        d3.v += bn;
        return 3;
    }
    
    public static long v(final Z693 z693, final int n) {
        return z693.r + n * (long)z693.l;
    }
    
    public static int y(final Z693 z693) {
        final int length = z693.h.length;
        int n = -1;
        int n2 = Integer.MAX_VALUE;
        for (int i = 0; i < length; ++i) {
            if (z693.h[i] >= 0) {
                if (z693.s[i] < n2) {
                    n = i;
                    n2 = z693.s[i];
                }
            }
        }
        return n;
    }
    
    public static boolean p(final Z693 z693) {
        for (int length = z693.h.length, i = 0; i < length; ++i) {
            if (z693.h[i] >= 0) {
                return false;
            }
        }
        return true;
    }
    
    public Z693(final byte[] array) {
        this.d = new Gg3(null);
        this.g(array);
    }
    
    static {
        v = new byte[] { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    }
    
    public int l(final int n) {
        final int w = this.w(n);
        if (this.d.v > this.e[n]) {
            throw new RuntimeException();
        }
        return w;
    }
    
    public static void d(final Z693 z693) {
        z693.d.r = null;
        z693.j = null;
        z693.e = null;
        z693.h = null;
        z693.s = null;
        z693.b = null;
    }
}
