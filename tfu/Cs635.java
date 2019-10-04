/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Cb633;
import tfu.Cw634;
import tfu.Cx556;

public abstract class Cs635
extends Cx556 {
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

    public static final synchronized void bq(Cs635 cs635, int n) {
        cs635.x = n;
    }

    private static final int ay(int n, int n2) {
        return n2 < 0 ? n : (int)((double)n * Math.sqrt((double)(16384 - n2) * 1.220703125E-4) + 0.5);
    }

    @Override
    protected final Cx556 d() {
        return null;
    }

    protected static final void bd(Cs635 cs635) {
        cs635.b = cs635.h;
        cs635.l = Cs635.ay(cs635.h, cs635.s);
        cs635.r = Cs635.ad(cs635.h, cs635.s);
    }

    @Override
    protected final int cd() {
        int n = this.b * 3 >> 6;
        n = (n ^ n >> 31) + (n >>> 31);
        if (this.x == 0) {
            n -= n * this.j / (((Cw634)this.bm).g() << 8);
        } else if (this.x >= 0) {
            n -= n * this.u / ((Cw634)this.bm).g();
        }
        return n > 255 ? 255 : n;
    }

    public static final synchronized void by(Cs635 cs635, int n, int n2) {
        Cs635.br(cs635, n, n2, Cs635.bj(cs635));
    }

    public static final synchronized void bo(Cs635 cs635, int n) {
        Cs635.bl(cs635, n, Cs635.bj(cs635));
    }

    private static final int ad(int n, int n2) {
        return n2 < 0 ? -n : (int)((double)n * Math.sqrt((double)n2 * 1.220703125E-4) + 0.5);
    }

    public static final synchronized int bw(Cs635 cs635) {
        return cs635.h == Integer.MIN_VALUE ? 0 : cs635.h;
    }

    public static final synchronized int bj(Cs635 cs635) {
        return cs635.s < 0 ? -1 : cs635.s;
    }

    @Override
    protected final int q() {
        return this.h != 0 || this.m != 0;
    }

    public static final synchronized boolean bp(Cs635 cs635) {
        return cs635.j < 0 || cs635.j >= ((Cw634)cs635.bm).g() << 8;
    }

    protected static final void bx(Cs635 cs635) {
        if (cs635.m != 0) {
            if (cs635.h == Integer.MIN_VALUE) {
                cs635.h = 0;
            }
            cs635.m = 0;
            Cs635.bd(cs635);
        }
    }

    public static final synchronized void bh(Cs635 cs635, boolean bl) {
        cs635.e = (cs635.e ^ cs635.e >> 31) + (cs635.e >>> 31);
        if (bl) {
            cs635.e = -cs635.e;
        }
    }

    public static final synchronized void br(Cs635 cs635, int n, int n2, int n3) {
        if (n == 0) {
            Cs635.bl(cs635, n2, n3);
            return;
        }
        int n4 = Cs635.ay(n2, n3);
        int n5 = Cs635.ad(n2, n3);
        if (cs635.l == n4 && cs635.r == n5) {
            cs635.m = 0;
            return;
        }
        int n6 = n2 - cs635.b;
        if (cs635.b - n2 > n6) {
            n6 = cs635.b - n2;
        }
        if (n4 - cs635.l > n6) {
            n6 = n4 - cs635.l;
        }
        if (cs635.l - n4 > n6) {
            n6 = cs635.l - n4;
        }
        if (n5 - cs635.r > n6) {
            n6 = n5 - cs635.r;
        }
        if (cs635.r - n5 > n6) {
            n6 = cs635.r - n5;
        }
        if (n > n6) {
            n = n6;
        }
        cs635.m = n;
        cs635.h = n2;
        cs635.s = n3;
        cs635.v = (n2 - cs635.b) / n;
        cs635.y = (n4 - cs635.l) / n;
        cs635.p = (n5 - cs635.r) / n;
    }

    public static final synchronized void bl(Cs635 cs635, int n, int n2) {
        cs635.h = n;
        cs635.s = n2;
        cs635.m = 0;
        Cs635.bd(cs635);
    }

    public static final synchronized void bf(Cs635 cs635, int n) {
        cs635.e = cs635.e < 0 ? -n : n;
    }

    public static final synchronized int bn(Cs635 cs635) {
        return cs635.e < 0 ? -cs635.e : cs635.e;
    }

    public static final synchronized void bv(Cs635 cs635, int n) {
        if (n == 0) {
            Cs635.bo(cs635, 0);
            Cs635.ef(cs635);
            return;
        }
        if (cs635.l == 0 && cs635.r == 0) {
            cs635.m = 0;
            cs635.h = 0;
            cs635.b = 0;
            Cs635.ef(cs635);
            return;
        }
        int n2 = -cs635.b;
        if (cs635.b > n2) {
            n2 = cs635.b;
        }
        if (-cs635.l > n2) {
            n2 = -cs635.l;
        }
        if (cs635.l > n2) {
            n2 = cs635.l;
        }
        if (-cs635.r > n2) {
            n2 = -cs635.r;
        }
        if (cs635.r > n2) {
            n2 = cs635.r;
        }
        if (n > n2) {
            n = n2;
        }
        cs635.m = n;
        cs635.h = Integer.MIN_VALUE;
        cs635.v = -cs635.b / n;
        cs635.y = -cs635.l / n;
        cs635.p = -cs635.r / n;
    }

    @Override
    protected final Cx556 g() {
        return null;
    }

    @Override
    public abstract void j(int[] var1, int var2, int var3);

    public static final synchronized boolean bm(Cs635 cs635) {
        return cs635.m != 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public final synchronized void e(int n) {
        int n2;
        block31 : {
            int n3;
            int n4;
            block33 : {
                block30 : {
                    int n5;
                    block32 : {
                        block28 : {
                            block29 : {
                                if (this.m > 0) {
                                    if (n >= this.m) {
                                        if (this.h == Integer.MIN_VALUE) {
                                            this.h = 0;
                                            this.r = 0;
                                            this.l = 0;
                                            this.b = 0;
                                            Cs635.ef(this);
                                            n = this.m;
                                        }
                                        this.m = 0;
                                        Cs635.bd(this);
                                    } else {
                                        this.b += this.v * n;
                                        this.l += this.y * n;
                                        this.r += this.p * n;
                                        this.m -= n;
                                    }
                                }
                                n3 = this.u << 8;
                                n4 = this.z << 8;
                                n2 = ((Cw634)this.bm).g() << 8;
                                n5 = n4 - n3;
                                if (n5 <= 0) {
                                    this.x = 0;
                                }
                                if (this.j < 0) {
                                    if (this.e <= 0) {
                                        Cs635.bx(this);
                                        Cs635.ef(this);
                                        return;
                                    }
                                    this.j = 0;
                                }
                                if (this.j >= n2) {
                                    if (this.e >= 0) {
                                        Cs635.bx(this);
                                        Cs635.ef(this);
                                        return;
                                    }
                                    this.j = n2 - 1;
                                }
                                this.j += this.e * n;
                                if (this.x >= 0) break block28;
                                if (!this.t) break block29;
                                if (this.e < 0) {
                                    if (this.j >= n3) {
                                        return;
                                    }
                                    this.j = n3 + n3 - 1 - this.j;
                                    this.e = -this.e;
                                }
                                break block30;
                            }
                            if (this.e < 0) {
                                if (this.j >= n3) {
                                    return;
                                }
                                this.j = n4 - 1 - (n4 - 1 - this.j) % n5;
                                return;
                            }
                            if (this.j < n4) {
                                return;
                            }
                            this.j = n3 + (this.j - n3) % n5;
                            return;
                        }
                        if (this.x <= 0) break block31;
                        if (!this.t) break block32;
                        if (this.e >= 0) break block33;
                        if (this.j >= n3) {
                            return;
                        }
                        this.j = n3 + n3 - 1 - this.j;
                        this.e = -this.e;
                        if (--this.x != 0) break block33;
                        break block31;
                    }
                    if (this.e < 0) {
                        if (this.j >= n3) {
                            return;
                        }
                        int n6 = (n4 - 1 - this.j) / n5;
                        if (n6 < this.x) {
                            this.j += n5 * n6;
                            this.x -= n6;
                            return;
                        }
                        this.j += n5 * this.x;
                        this.x = 0;
                    } else {
                        if (this.j < n4) {
                            return;
                        }
                        int n7 = (this.j - n3) / n5;
                        if (n7 < this.x) {
                            this.j -= n5 * n7;
                            this.x -= n7;
                            return;
                        }
                        this.j -= n5 * this.x;
                        this.x = 0;
                    }
                    break block31;
                }
                do {
                    if (this.j < n4) {
                        return;
                    }
                    this.j = n4 + n4 - 1 - this.j;
                    this.e = -this.e;
                    if (this.j >= n3) {
                        return;
                    }
                    this.j = n3 + n3 - 1 - this.j;
                    this.e = -this.e;
                } while (true);
            }
            do {
                if (this.j < n4) {
                    return;
                }
                this.j = n4 + n4 - 1 - this.j;
                this.e = -this.e;
                if (--this.x == 0) break;
                if (this.j >= n3) {
                    return;
                }
                this.j = n3 + n3 - 1 - this.j;
                this.e = -this.e;
            } while (--this.x != 0);
        }
        if (this.e < 0) {
            if (this.j >= 0) return;
            this.j = -1;
            Cs635.bx(this);
            Cs635.ef(this);
            return;
        }
        if (this.j < n2) return;
        this.j = n2;
        Cs635.bx(this);
        Cs635.ef(this);
    }

    protected static final boolean bg(Cs635 cs635) {
        int n;
        int n2;
        int n3 = cs635.h;
        if (n3 == Integer.MIN_VALUE) {
            n2 = 0;
            n = 0;
            n3 = 0;
        } else {
            n = Cs635.ay(n3, cs635.s);
            n2 = Cs635.ad(n3, cs635.s);
        }
        if (cs635.b != n3 || cs635.l != n || cs635.r != n2) {
            if (cs635.b < n3) {
                cs635.v = 1;
                cs635.m = n3 - cs635.b;
            } else if (cs635.b > n3) {
                cs635.v = -1;
                cs635.m = cs635.b - n3;
            } else {
                cs635.v = 0;
            }
            if (cs635.l < n) {
                cs635.y = 1;
                if (cs635.m == 0 || cs635.m > n - cs635.l) {
                    cs635.m = n - cs635.l;
                }
            } else if (cs635.l > n) {
                cs635.y = -1;
                if (cs635.m == 0 || cs635.m > cs635.l - n) {
                    cs635.m = cs635.l - n;
                }
            } else {
                cs635.y = 0;
            }
            if (cs635.r < n2) {
                cs635.p = 1;
                if (cs635.m == 0 || cs635.m > n2 - cs635.r) {
                    cs635.m = n2 - cs635.r;
                }
            } else if (cs635.r > n2) {
                cs635.p = -1;
                if (cs635.m == 0 || cs635.m > cs635.r - n2) {
                    cs635.m = cs635.r - n2;
                }
            } else {
                cs635.p = 0;
            }
            return false;
        }
        if (cs635.h == Integer.MIN_VALUE) {
            cs635.h = 0;
            cs635.r = 0;
            cs635.l = 0;
            cs635.b = 0;
            Cs635.ef(cs635);
            return true;
        }
        Cs635.bd(cs635);
        return false;
    }

    public static final synchronized void bk(Cs635 cs635, int n) {
        int n2 = ((Cw634)cs635.bm).g() << 8;
        if (n < -1) {
            n = -1;
        }
        if (n > n2) {
            n = n2;
        }
        cs635.j = n;
    }
}

