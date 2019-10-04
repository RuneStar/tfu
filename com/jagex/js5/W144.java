/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.js5;

import com.jagex.js5.B360;
import com.jagex.js5.E361;
import java.io.IOException;
import java.io.PrintStream;
import tfu.Gg3;
import tfu.Gz143;
import tfu.Hn359;
import tfu.Hx339;
import tfu.Kp349;

public class W144 {
    protected static final boolean d = true;
    protected static final int e = 20;
    protected static final boolean g = false;
    protected static final int h = 512;
    protected static final int j = 50;
    protected static final int q = 3;
    protected Hn359 b = new Hn359();
    protected Hn359 l = new Hn359();
    protected B360 m;
    private Hx339 n;
    protected Gg3 p;
    protected Hn359 r;
    protected Gg3 t;
    public volatile int u = 0;
    protected int v;
    protected Hn359 w = new Hn359();
    protected byte x = 0;
    protected long y;
    public volatile int z = 0;

    public static void h(W144 w144) {
        try {
            w144.n.h();
        }
        catch (Exception exception) {
            // empty catch block
        }
        w144.n = null;
        ++w144.u;
        w144.z = -1;
        w144.x = (byte)(Math.random() * 255.0 + 1.0);
    }

    public synchronized B360 g(int n, int n2, byte by, boolean bl) {
        long l = ((long)n << 32) + (long)n2;
        B360 b360 = new B360();
        b360.p = l;
        b360.q = by;
        b360.s = bl;
        if (bl) {
            if (W144.e(this) >= 50) {
                throw new RuntimeException("Urgent list exceeded max limit of 50");
            }
            Hn359.q(this.b, b360);
        } else {
            if (W144.j(this) >= 20) {
                throw new RuntimeException("Prefetch list exceeded max limit of 20");
            }
            Hn359.q(this.w, b360);
        }
        return b360;
    }

    public synchronized boolean s() {
        int n;
        Object object2;
        if (this.n != null) {
            long l = Gz143.g();
            n = (int)(l - this.y);
            this.y = l;
            if (n > 200) {
                n = 200;
            }
            this.v += n;
            if (this.v > 30000) {
                try {
                    this.n.h();
                }
                catch (Exception object2) {
                    // empty catch block
                }
                this.n = null;
            }
        }
        if (this.n == null) {
            return W144.e(this) == 0 && W144.j(this) == 0;
        }
        try {
            B360 b360 = (B360)Hn359.h(this.b);
            while (b360 != null) {
                this.p.v = 0;
                Gg3.k(this.p, 1);
                Gg3.c(this.p, b360.p);
                this.n.e(this.p.r, 0, this.p.r.length);
                Hn359.q(this.l, b360);
                b360 = (B360)Hn359.b(this.b);
            }
            b360 = (B360)Hn359.h(this.w);
            while (b360 != null) {
                this.p.v = 0;
                Gg3.k(this.p, 0);
                Gg3.c(this.p, b360.p);
                this.n.e(this.p.r, 0, this.p.r.length);
                Hn359.q(this.r, b360);
                b360 = (B360)Hn359.b(this.w);
            }
            for (int i = 0; i < 100; ++i) {
                Object object3;
                Object object4;
                int n2 = this.n.q();
                if (n2 < 0) {
                    throw new IOException();
                }
                if (n2 == 0) break;
                this.v = 0;
                n = 0;
                if (this.m == null) {
                    n = 10;
                } else if (this.m.d == 0) {
                    n = 1;
                }
                if (n > 0) {
                    object2 = n - this.t.v;
                    if (object2 > n2) {
                        object2 = n2;
                    }
                    this.n.j(this.t.r, this.t.v, (int)object2);
                    if (this.x != 0) {
                        for (object3 = 0; object3 < object2; ++object3) {
                            byte[] arrby = this.t.r;
                            int n3 = this.t.v + object3;
                            arrby[n3] = (byte)(arrby[n3] ^ this.x);
                        }
                    }
                    this.t.v += object2;
                    if (this.t.v < n) continue;
                    if (this.m == null) {
                        this.t.v = 0;
                        object3 = Gg3.ar(this.t);
                        object4 = Gg3.bd(this.t);
                        int n4 = Gg3.ar(this.t);
                        int n5 = Gg3.bd(this.t);
                        int n6 = n4 & 0x7F;
                        boolean bl = (n4 & 0x80) != 0;
                        long l = ((long)object3 << 32) + (long)object4;
                        B360 b3602 = null;
                        if (bl) {
                            b3602 = (B360)Hn359.h(this.r);
                            while (b3602 != null && b3602.p != l) {
                                b3602 = (B360)Hn359.b(this.r);
                            }
                        } else {
                            b3602 = (B360)Hn359.h(this.l);
                            while (b3602 != null && b3602.p != l) {
                                b3602 = (B360)Hn359.b(this.l);
                            }
                        }
                        if (b3602 == null) {
                            System.out.println("Could not find matching request - archiveid:" + object3 + " groupid:" + object4 + " ctype:" + n6 + " clen:" + n5 + " xorcode:" + this.x);
                            throw new IOException();
                        }
                        int n7 = n6 == 0 ? 5 : 9;
                        this.m = b3602;
                        this.m.g = new Gg3(n5 + n7 + this.m.q);
                        Gg3.k(this.m.g, n6);
                        Gg3.a(this.m.g, n5);
                        this.m.d = 10;
                        this.t.v = 0;
                        continue;
                    }
                    if (this.m.d == 0) {
                        if (this.t.r[0] == -1) {
                            this.m.d = 1;
                            this.t.v = 0;
                            continue;
                        }
                        this.m = null;
                        continue;
                    }
                    System.out.println("Error processing incoming header!");
                    throw new IOException();
                }
                object3 = 512 - this.m.d;
                object2 = this.m.g.r.length - this.m.q;
                if (object3 > object2 - this.m.g.v) {
                    object3 = object2 - this.m.g.v;
                }
                if (object3 > n2) {
                    object3 = n2;
                }
                this.n.j(this.m.g.r, this.m.g.v, (int)object3);
                if (this.x != 0) {
                    for (object4 = 0; object4 < object3; ++object4) {
                        byte[] arrby = this.m.g.r;
                        int n8 = this.m.g.v + object4;
                        arrby[n8] = (byte)(arrby[n8] ^ this.x);
                    }
                }
                this.m.g.v += object3;
                this.m.d += object3;
                if (this.m.g.v == object2) {
                    B360.t(this.m);
                    this.m.l = false;
                    this.m = null;
                    continue;
                }
                if (this.m.d != 512) continue;
                this.m.d = 0;
            }
            return true;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            try {
                this.n.h();
            }
            catch (Exception exception) {
                // empty catch block
            }
            this.n = null;
            ++this.u;
            this.z = -2;
            return W144.e(this) == 0 && W144.j(this) == 0;
        }
    }

    public static synchronized boolean q(W144 w144) {
        return W144.e(w144) >= 50;
    }

    public static synchronized int j(W144 w144) {
        return Hn359.l(w144.w) + Hn359.l(w144.r);
    }

    public static synchronized int e(W144 w144) {
        return Hn359.l(w144.b) + Hn359.l(w144.l);
    }

    public static void r(W144 w144) {
        if (w144.n == null) {
            return;
        }
        try {
            w144.p.v = 0;
            Gg3.k(w144.p, 7);
            Gg3.c(w144.p, 0L);
            w144.n.e(w144.p.r, 0, w144.p.r.length);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            try {
                w144.n.h();
            }
            catch (Exception exception) {
                // empty catch block
            }
            w144.n = null;
            ++w144.u;
            w144.z = -2;
        }
    }

    public static void v(W144 w144) {
        if (w144.n != null) {
            w144.n.h();
        }
    }

    public static void b(W144 w144, Object object, boolean bl) {
        B360 b360;
        if (w144.n != null) {
            try {
                w144.n.h();
            }
            catch (Exception exception) {
                // empty catch block
            }
            w144.n = null;
        }
        w144.n = (Hx339)object;
        W144.l(w144);
        W144.w(w144, bl);
        w144.t.v = 0;
        w144.m = null;
        while ((b360 = (B360)Hn359.e(w144.l)) != null) {
            Hn359.q(w144.b, b360);
        }
        while ((b360 = (B360)Hn359.e(w144.r)) != null) {
            Hn359.q(w144.w, b360);
        }
        if (w144.x != 0) {
            try {
                w144.p.v = 0;
                Gg3.k(w144.p, 4);
                Gg3.k(w144.p, w144.x);
                Gg3.a(w144.p, 0);
                w144.n.e(w144.p.r, 0, w144.p.r.length);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                try {
                    w144.n.h();
                }
                catch (Exception exception) {
                    // empty catch block
                }
                w144.n = null;
                ++w144.u;
                w144.z = -2;
            }
        }
        w144.v = 0;
        w144.y = Gz143.g();
    }

    protected static void l(W144 w144) {
        if (w144.n == null) {
            return;
        }
        try {
            w144.p.v = 0;
            Gg3.k(w144.p, 6);
            Gg3.o(w144.p, 3);
            Gg3.i(w144.p, 0);
            w144.n.e(w144.p.r, 0, w144.p.r.length);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            try {
                w144.n.h();
            }
            catch (Exception exception) {
                // empty catch block
            }
            w144.n = null;
            ++w144.u;
            w144.z = -2;
        }
    }

    public static void w(W144 w144, boolean bl) {
        if (w144.n == null) {
            return;
        }
        try {
            w144.p.v = 0;
            Gg3.k(w144.p, bl ? 2 : 3);
            Gg3.c(w144.p, 0L);
            w144.n.e(w144.p.r, 0, w144.p.r.length);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            try {
                w144.n.h();
            }
            catch (Exception exception) {
                // empty catch block
            }
            w144.n = null;
            ++w144.u;
            w144.z = -2;
        }
    }

    public static void y(W144 w144) {
        if (w144.n != null) {
            w144.n.s();
        }
    }

    public W144() {
        this.r = new Hn359();
        this.p = new Gg3(6);
        this.t = new Gg3(10);
    }

    public static synchronized boolean d(W144 w144) {
        return W144.j(w144) >= 20;
    }
}

