// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public abstract class Cs635 extends Cx556
{
    protected static final boolean q = false;
    int b;
    int e;
    int h;
    int j;
    int l;
    int m;
    int p;
    int r;
    int s;
    boolean t;
    int u;
    int v;
    int x;
    int y;
    int z;
    
    public static final synchronized void bq(final Cs635 cs635, final int x) {
        cs635.x = x;
    }
    
    private static final int ay(final int n, final int n2) {
        return (n2 < 0) ? n : ((int)(n * Math.sqrt((16384 - n2) * 1.220703125E-4) + 0.5));
    }
    
    @Override
    protected final Cx556 d() {
        return null;
    }
    
    protected static final void bd(final Cs635 cs635) {
        cs635.b = cs635.h;
        cs635.l = ay(cs635.h, cs635.s);
        cs635.r = ad(cs635.h, cs635.s);
    }
    
    @Override
    protected final int cd() {
        final int n = this.b * 3 >> 6;
        int n2 = (n ^ n >> 31) + (n >>> 31);
        if (this.x == 0) {
            n2 -= n2 * this.j / (((Cw634)super.bm).g() << 8);
        }
        else if (this.x >= 0) {
            n2 -= n2 * this.u / ((Cw634)super.bm).g();
        }
        return (n2 > 255) ? 255 : n2;
    }
    
    public static final synchronized void by(final Cs635 cs635, final int n, final int n2) {
        br(cs635, n, n2, bj(cs635));
    }
    
    public static final synchronized void bo(final Cs635 cs635, final int n) {
        bl(cs635, n, bj(cs635));
    }
    
    private static final int ad(final int n, final int n2) {
        return (n2 < 0) ? (-n) : ((int)(n * Math.sqrt(n2 * 1.220703125E-4) + 0.5));
    }
    
    public static final synchronized int bw(final Cs635 cs635) {
        return (cs635.h == Integer.MIN_VALUE) ? 0 : cs635.h;
    }
    
    public static final synchronized int bj(final Cs635 cs635) {
        return (cs635.s < 0) ? -1 : cs635.s;
    }
    
    @Override
    protected final int q() {
        if (this.h == 0 && this.m == 0) {
            return 0;
        }
        return 1;
    }
    
    public static final synchronized boolean bp(final Cs635 cs635) {
        return cs635.j < 0 || cs635.j >= ((Cw634)cs635.bm).g() << 8;
    }
    
    protected static final void bx(final Cs635 cs635) {
        if (cs635.m != 0) {
            if (cs635.h == Integer.MIN_VALUE) {
                cs635.h = 0;
            }
            cs635.m = 0;
            bd(cs635);
        }
    }
    
    public static final synchronized void bh(final Cs635 cs635, final boolean b) {
        cs635.e = (cs635.e ^ cs635.e >> 31) + (cs635.e >>> 31);
        if (b) {
            cs635.e = -cs635.e;
        }
    }
    
    public static final synchronized void br(final Cs635 cs635, int m, final int h, final int s) {
        if (m == 0) {
            bl(cs635, h, s);
            return;
        }
        final int ay = ay(h, s);
        final int ad = ad(h, s);
        if (cs635.l == ay && cs635.r == ad) {
            cs635.m = 0;
            return;
        }
        int n = h - cs635.b;
        if (cs635.b - h > n) {
            n = cs635.b - h;
        }
        if (ay - cs635.l > n) {
            n = ay - cs635.l;
        }
        if (cs635.l - ay > n) {
            n = cs635.l - ay;
        }
        if (ad - cs635.r > n) {
            n = ad - cs635.r;
        }
        if (cs635.r - ad > n) {
            n = cs635.r - ad;
        }
        if (m > n) {
            m = n;
        }
        cs635.m = m;
        cs635.h = h;
        cs635.s = s;
        cs635.v = (h - cs635.b) / m;
        cs635.y = (ay - cs635.l) / m;
        cs635.p = (ad - cs635.r) / m;
    }
    
    public static final synchronized void bl(final Cs635 cs635, final int h, final int s) {
        cs635.h = h;
        cs635.s = s;
        cs635.m = 0;
        bd(cs635);
    }
    
    public static final synchronized void bf(final Cs635 cs635, final int e) {
        if (cs635.e < 0) {
            cs635.e = -e;
        }
        else {
            cs635.e = e;
        }
    }
    
    public static final synchronized int bn(final Cs635 cs635) {
        return (cs635.e < 0) ? (-cs635.e) : cs635.e;
    }
    
    public static final synchronized void bv(final Cs635 cs635, int m) {
        if (m == 0) {
            bo(cs635, 0);
            Ln265.ef(cs635);
            return;
        }
        if (cs635.l == 0 && cs635.r == 0) {
            cs635.m = 0;
            cs635.h = 0;
            cs635.b = 0;
            Ln265.ef(cs635);
            return;
        }
        int n = -cs635.b;
        if (cs635.b > n) {
            n = cs635.b;
        }
        if (-cs635.l > n) {
            n = -cs635.l;
        }
        if (cs635.l > n) {
            n = cs635.l;
        }
        if (-cs635.r > n) {
            n = -cs635.r;
        }
        if (cs635.r > n) {
            n = cs635.r;
        }
        if (m > n) {
            m = n;
        }
        cs635.m = m;
        cs635.h = Integer.MIN_VALUE;
        cs635.v = -cs635.b / m;
        cs635.y = -cs635.l / m;
        cs635.p = -cs635.r / m;
    }
    
    @Override
    protected final Cx556 g() {
        return null;
    }
    
    @Override
    public abstract void j(final int[] p0, final int p1, final int p2);
    
    public static final synchronized boolean bm(final Cs635 cs635) {
        return cs635.m != 0;
    }
    
    @Override
    public final synchronized void e(int m) {
        if (this.m > 0) {
            if (m >= this.m) {
                if (this.h == Integer.MIN_VALUE) {
                    this.h = 0;
                    final int b = 0;
                    this.r = b;
                    this.l = b;
                    this.b = b;
                    Ln265.ef(this);
                    m = this.m;
                }
                this.m = 0;
                bd(this);
            }
            else {
                this.b += this.v * m;
                this.l += this.y * m;
                this.r += this.p * m;
                this.m -= m;
            }
        }
        final int n = this.u << 8;
        final int n2 = this.z << 8;
        final int j = ((Cw634)super.bm).g() << 8;
        final int n3 = n2 - n;
        if (n3 <= 0) {
            this.x = 0;
        }
        if (this.j < 0) {
            if (this.e <= 0) {
                bx(this);
                Ln265.ef(this);
                return;
            }
            this.j = 0;
        }
        if (this.j >= j) {
            if (this.e >= 0) {
                bx(this);
                Ln265.ef(this);
                return;
            }
            this.j = j - 1;
        }
        this.j += this.e * m;
        if (this.x >= 0) {
            Label_0768: {
                if (this.x > 0) {
                    if (this.t) {
                        if (this.e < 0) {
                            if (this.j >= n) {
                                return;
                            }
                            this.j = n + n - 1 - this.j;
                            this.e = -this.e;
                            if (--this.x == 0) {
                                break Label_0768;
                            }
                        }
                        while (this.j >= n2) {
                            this.j = n2 + n2 - 1 - this.j;
                            this.e = -this.e;
                            if (--this.x == 0) {
                                break Label_0768;
                            }
                            if (this.j >= n) {
                                return;
                            }
                            this.j = n + n - 1 - this.j;
                            this.e = -this.e;
                            if (--this.x == 0) {
                                break Label_0768;
                            }
                        }
                        return;
                    }
                    if (this.e < 0) {
                        if (this.j >= n) {
                            return;
                        }
                        final int n4 = (n2 - 1 - this.j) / n3;
                        if (n4 >= this.x) {
                            this.j += n3 * this.x;
                            this.x = 0;
                            break Label_0768;
                        }
                        this.j += n3 * n4;
                        this.x -= n4;
                    }
                    else {
                        if (this.j < n2) {
                            return;
                        }
                        final int n5 = (this.j - n) / n3;
                        if (n5 >= this.x) {
                            this.j -= n3 * this.x;
                            this.x = 0;
                            break Label_0768;
                        }
                        this.j -= n3 * n5;
                        this.x -= n5;
                    }
                    return;
                }
            }
            if (this.e < 0) {
                if (this.j < 0) {
                    this.j = -1;
                    bx(this);
                    Ln265.ef(this);
                }
            }
            else if (this.j >= j) {
                this.j = j;
                bx(this);
                Ln265.ef(this);
            }
            return;
        }
        if (this.t) {
            if (this.e < 0) {
                if (this.j >= n) {
                    return;
                }
                this.j = n + n - 1 - this.j;
                this.e = -this.e;
            }
            while (this.j >= n2) {
                this.j = n2 + n2 - 1 - this.j;
                this.e = -this.e;
                if (this.j >= n) {
                    return;
                }
                this.j = n + n - 1 - this.j;
                this.e = -this.e;
            }
            return;
        }
        if (this.e < 0) {
            if (this.j >= n) {
                return;
            }
            this.j = n2 - 1 - (n2 - 1 - this.j) % n3;
        }
        else {
            if (this.j < n2) {
                return;
            }
            this.j = n + (this.j - n) % n3;
        }
    }
    
    protected static final boolean bg(final Cs635 cs635) {
        int h = cs635.h;
        int ad;
        int ay;
        if (h == Integer.MIN_VALUE) {
            ay = (h = (ad = 0));
        }
        else {
            ay = ay(h, cs635.s);
            ad = ad(h, cs635.s);
        }
        if (cs635.b != h || cs635.l != ay || cs635.r != ad) {
            if (cs635.b < h) {
                cs635.v = 1;
                cs635.m = h - cs635.b;
            }
            else if (cs635.b > h) {
                cs635.v = -1;
                cs635.m = cs635.b - h;
            }
            else {
                cs635.v = 0;
            }
            if (cs635.l < ay) {
                cs635.y = 1;
                if (cs635.m == 0 || cs635.m > ay - cs635.l) {
                    cs635.m = ay - cs635.l;
                }
            }
            else if (cs635.l > ay) {
                cs635.y = -1;
                if (cs635.m == 0 || cs635.m > cs635.l - ay) {
                    cs635.m = cs635.l - ay;
                }
            }
            else {
                cs635.y = 0;
            }
            if (cs635.r < ad) {
                cs635.p = 1;
                if (cs635.m == 0 || cs635.m > ad - cs635.r) {
                    cs635.m = ad - cs635.r;
                }
            }
            else if (cs635.r > ad) {
                cs635.p = -1;
                if (cs635.m == 0 || cs635.m > cs635.r - ad) {
                    cs635.m = cs635.r - ad;
                }
            }
            else {
                cs635.p = 0;
            }
            return false;
        }
        if (cs635.h == Integer.MIN_VALUE) {
            cs635.h = 0;
            final int b = 0;
            cs635.r = b;
            cs635.l = b;
            cs635.b = b;
            Ln265.ef(cs635);
            return true;
        }
        bd(cs635);
        return false;
    }
    
    public static final synchronized void bk(final Cs635 cs635, int j) {
        final int n = ((Cw634)cs635.bm).g() << 8;
        if (j < -1) {
            j = -1;
        }
        if (j > n) {
            j = n;
        }
        cs635.j = j;
    }
}
