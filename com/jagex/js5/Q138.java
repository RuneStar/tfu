/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.js5;

import com.jagex.js5.B360;
import com.jagex.js5.D363;
import com.jagex.js5.E361;
import com.jagex.js5.H362;
import com.jagex.js5.L145;
import com.jagex.js5.S136;
import com.jagex.js5.W144;
import com.jagex.js5.js5;
import java.util.zip.CRC32;
import tfu.Gx298;
import tfu.Gz143;
import tfu.Ha262;
import tfu.Hl134;
import tfu.Iw364;
import tfu.Kp349;
import tfu.Ln265;

public class Q138
extends S136 {
    private static CRC32 ag = new CRC32();
    private static final int ai = 1;
    private static final int al = 2;
    private static final int aq = 0;
    private static final int c = 250;
    private static final int f = 1000;
    private static final byte r = 0;
    private static final byte v = 1;
    private static final byte y = -1;
    private long a = 0L;
    private byte[] b;
    private W144 d;
    private Hl134 e;
    private int g;
    private E361 h;
    private Gx298 i;
    private Hl134 j;
    private Gx298 k;
    private int l;
    private boolean m;
    private int n = 0;
    private boolean o;
    private byte[] p;
    private L145 q;
    private int s;
    private boolean t;
    public int u = 0;
    private H362 w;
    public int x = 0;
    private Ha262 z = new Ha262(16);

    @Override
    public int s() {
        return this.u;
    }

    @Override
    public H362 d() {
        block14 : {
            if (this.w != null) {
                return this.w;
            }
            if (this.h == null) {
                if (W144.q(this.d)) {
                    return null;
                }
                this.h = this.d.g(255, this.g, (byte)0, true);
            }
            if (this.h.l) {
                return null;
            }
            byte[] arrby = this.h.g();
            if (this.h instanceof D363) {
                try {
                    if (arrby == null) {
                        throw new RuntimeException("Index not found in disk cache");
                    }
                    this.w = new H362(arrby, this.s, this.b);
                    if (this.w.j != this.l) {
                        throw new RuntimeException("Index version wrong - index.indexversion:" + this.w.j + " expected:" + this.l);
                    }
                    break block14;
                }
                catch (RuntimeException runtimeException) {
                    this.w = null;
                    this.h = W144.q(this.d) ? null : this.d.g(255, this.g, (byte)0, true);
                    return null;
                }
            }
            try {
                if (arrby == null) {
                    throw new RuntimeException("Failed to download index from server!");
                }
                this.w = new H362(arrby, this.s, this.b);
            }
            catch (RuntimeException runtimeException) {
                W144.h(this.d);
                this.w = null;
                this.h = W144.q(this.d) ? null : this.d.g(255, this.g, (byte)0, true);
                return null;
            }
            if (this.e != null) {
                this.q.j(this.g, arrby, this.e);
            }
        }
        this.h = null;
        if (this.j != null) {
            this.p = new byte[this.w.l];
            this.u = 0;
            this.x = 0;
        }
        return this.w;
    }

    @Override
    protected synchronized byte[] q(int n) {
        E361 e361 = this.j(n, 0);
        if (e361 == null) {
            return null;
        }
        byte[] arrby = e361.g();
        E361.ef(e361);
        return arrby;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private synchronized E361 j(int n, int n2) {
        E361 e361 = (E361)Ha262.d(this.z, n);
        if (e361 != null && n2 == 0 && !e361.s && e361.l) {
            E361.ef(e361);
            e361 = null;
        }
        if (e361 == null) {
            if (n2 == 0) {
                if (this.j != null && this.p[n] != -1) {
                    e361 = this.q.q(n, this.j);
                } else {
                    if (W144.q(this.d)) return null;
                    e361 = this.d.g(this.g, n, (byte)2, true);
                }
            } else if (n2 == 1) {
                if (this.j == null) {
                    throw new RuntimeException("fetchgroup_inner - VERIFY requested but no datafs available!");
                }
                e361 = this.q.e(n, this.j);
            } else {
                if (n2 != 2) throw new RuntimeException("Invalid fetchgroup mode!");
                if (this.j == null) {
                    throw new RuntimeException("fetchgroup_inner - PREFETCH requested but no datafs available!");
                }
                if (this.p[n] != -1) {
                    throw new RuntimeException("fetchgroup_inner - PREFETCH requested, but cache isn't known invalid!");
                }
                if (W144.d(this.d)) return null;
                e361 = this.d.g(this.g, n, (byte)2, false);
            }
            Ha262.q(this.z, e361, n);
        }
        if (e361.l) {
            return null;
        }
        byte[] arrby = e361.g();
        if (e361 instanceof D363) {
            try {
                int n3;
                if (arrby == null || arrby.length <= 2) {
                    throw new RuntimeException("Data not in cache - data:" + arrby);
                }
                ag.reset();
                ag.update(arrby, 0, arrby.length - 2);
                int n4 = (int)ag.getValue();
                if (n4 != this.w.w[n]) {
                    throw new RuntimeException("Disk fetch CRC incorrect");
                }
                if (this.w.r != null && this.w.r[n] != null) {
                    byte[] arrby2 = this.w.r[n];
                    byte[] arrby3 = Iw364.e(arrby, 0, arrby.length - 2);
                    for (int i = 0; i < 64; ++i) {
                        if (arrby3[i] == arrby2[i]) continue;
                        throw new RuntimeException("Disk fetch Whirlpool incorrect");
                    }
                }
                if ((n3 = ((arrby[arrby.length - 2] & 0xFF) << 8) + (arrby[arrby.length - 1] & 0xFF)) != (this.w.v[n] & 0xFFFF)) {
                    throw new RuntimeException("Version incorrect - wanted:" + this.w.v[n] + " got:" + n3);
                }
                if (this.p[n] != 1) {
                    if (this.p[n] == 0) {
                        ++this.x;
                    }
                    ++this.u;
                    this.p[n] = 1;
                }
                if (e361.s) return e361;
                E361.ef(e361);
                return e361;
            }
            catch (Exception exception) {
                this.p[n] = -1;
                E361.ef(e361);
                if (!e361.s || W144.q(this.d)) return null;
                e361 = this.d.g(this.g, n, (byte)2, true);
                Ha262.q(this.z, e361, n);
                return null;
            }
        }
        try {
            if (arrby == null || arrby.length <= 2) {
                throw new RuntimeException("Data from server too small - data:" + arrby);
            }
            ag.reset();
            ag.update(arrby, 0, arrby.length - 2);
            int n5 = (int)ag.getValue();
            if (n5 != this.w.w[n]) {
                throw new RuntimeException("Net fetch CRC incorrect");
            }
            if (this.w.r != null && this.w.r[n] != null) {
                byte[] arrby4 = this.w.r[n];
                byte[] arrby5 = Iw364.e(arrby, 0, arrby.length - 2);
                for (int i = 0; i < 64; ++i) {
                    if (arrby5[i] == arrby4[i]) continue;
                    throw new RuntimeException("Whirlpool for group " + n + " incorrect - got:" + js5.av(arrby5) + " expected:" + js5.av(arrby4));
                }
            }
            this.d.u = 0;
            this.d.z = 0;
        }
        catch (RuntimeException runtimeException) {
            W144.h(this.d);
            E361.ef(e361);
            if (!e361.s || W144.q(this.d)) return null;
            e361 = this.d.g(this.g, n, (byte)2, true);
            Ha262.q(this.z, e361, n);
            return null;
        }
        arrby[arrby.length - 2] = (byte)(this.w.v[n] >>> 8);
        arrby[arrby.length - 1] = (byte)this.w.v[n];
        if (this.j != null) {
            this.q.j(n, arrby, this.j);
            if (this.p[n] != 1) {
                ++this.u;
                this.p[n] = 1;
            }
        }
        if (e361.s) return e361;
        E361.ef(e361);
        return e361;
    }

    @Override
    protected synchronized int w(int n) {
        E361 e361 = (E361)Ha262.d(this.z, n);
        if (e361 != null) {
            return e361.d();
        }
        return 0;
    }

    public synchronized void h() {
        if (this.k != null) {
            Ln265 ln265;
            int n;
            boolean bl;
            if (this.d() == null) {
                return;
            }
            if (this.m) {
                bl = true;
                ln265 = Gx298.i(this.k);
                while (ln265 != null) {
                    n = (int)ln265.bq;
                    if (this.p[n] == 0) {
                        this.j(n, 1);
                    }
                    if (this.p[n] != 0) {
                        Ln265.ef(ln265);
                    } else {
                        bl = false;
                    }
                    ln265 = Gx298.c(this.k);
                }
                while (this.n < this.w.y.length) {
                    if (this.w.y[this.n] == 0) {
                        ++this.n;
                        continue;
                    }
                    if (this.q.d >= 250) {
                        bl = false;
                        break;
                    }
                    if (this.p[this.n] == 0) {
                        this.j(this.n, 1);
                    }
                    if (this.p[this.n] == 0) {
                        ln265 = new Ln265();
                        ln265.bq = this.n;
                        Gx298.t(this.k, ln265);
                        bl = false;
                    }
                    ++this.n;
                }
                if (bl) {
                    this.m = false;
                    this.n = 0;
                }
            } else if (this.t) {
                bl = true;
                ln265 = Gx298.i(this.k);
                while (ln265 != null) {
                    n = (int)ln265.bq;
                    if (this.p[n] != 1) {
                        this.j(n, 2);
                    }
                    if (this.p[n] == 1) {
                        Ln265.ef(ln265);
                    } else {
                        bl = false;
                    }
                    ln265 = Gx298.c(this.k);
                }
                while (this.n < this.w.y.length) {
                    if (this.w.y[this.n] == 0) {
                        ++this.n;
                        continue;
                    }
                    if (W144.d(this.d)) {
                        bl = false;
                        break;
                    }
                    if (this.p[this.n] != 1) {
                        this.j(this.n, 2);
                    }
                    if (this.p[this.n] != 1) {
                        ln265 = new Ln265();
                        ln265.bq = this.n;
                        Gx298.t(this.k, ln265);
                        bl = false;
                    }
                    ++this.n;
                }
                if (bl) {
                    this.t = false;
                    this.n = 0;
                }
            } else {
                this.k = null;
            }
        }
        if (this.o && Gz143.g() >= this.a) {
            E361 e361 = (E361)Ha262.e(this.z);
            while (e361 != null) {
                if (!e361.l) {
                    if (e361.b) {
                        if (!e361.s) {
                            throw new RuntimeException("Unexpected non-urgent orphan! archiveid:" + this.g + " group:" + e361.p);
                        }
                        E361.ef(e361);
                    } else {
                        e361.b = true;
                    }
                }
                e361 = (E361)Ha262.h(this.z);
            }
            this.a = Gz143.g() + 1000L;
        }
    }

    Q138(int n, Hl134 hl134, Hl134 hl1342, W144 w144, L145 l145, int n2, byte[] arrby, int n3, boolean bl) {
        this.i = new Gx298();
        this.g = n;
        this.j = hl134;
        if (this.j == null) {
            this.m = false;
        } else {
            this.m = true;
            this.k = new Gx298();
        }
        this.e = hl1342;
        this.d = w144;
        this.q = l145;
        this.s = n2;
        this.b = arrby;
        this.l = n3;
        this.o = bl;
        if (this.e != null) {
            this.h = this.q.q(this.g, this.e);
        }
    }

    public synchronized void l() {
        if (this.j == null) {
            return;
        }
        this.t = true;
        if (this.k == null) {
            this.k = new Gx298();
        }
    }

    public static synchronized void e(Q138 q138) {
        if (q138.k == null) {
            return;
        }
        if (q138.d() == null) {
            return;
        }
        Ln265 ln265 = Gx298.i(q138.i);
        while (ln265 != null) {
            int n = (int)ln265.bq;
            if (n < 0 || n >= q138.w.l || q138.w.y[n] == 0) {
                Ln265.ef(ln265);
            } else {
                if (q138.p[n] == 0) {
                    q138.j(n, 1);
                }
                if (q138.p[n] == -1) {
                    q138.j(n, 2);
                }
                if (q138.p[n] == 1) {
                    Ln265.ef(ln265);
                }
            }
            ln265 = Gx298.c(q138.i);
        }
    }

    @Override
    public int g() {
        if (this.d() == null) {
            if (this.h == null) {
                return 0;
            }
            return this.h.d();
        }
        return 100;
    }

    @Override
    public synchronized int b() {
        if (this.w == null) {
            return 0;
        }
        if (!this.m) {
            return this.w.e;
        }
        Ln265 ln265 = Gx298.i(this.k);
        if (ln265 == null) {
            return 0;
        }
        return (int)ln265.bq;
    }
}

