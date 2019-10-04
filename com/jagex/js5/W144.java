// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.js5;

import java.io.IOException;
import tfu.Gz143;
import tfu.Kp349;
import tfu.Gg3;
import tfu.Hx339;
import tfu.Hn359;

public class W144
{
    protected static final boolean d = true;
    protected static final int e = 20;
    protected static final boolean g = false;
    protected static final int h = 512;
    protected static final int j = 50;
    protected static final int q = 3;
    protected Hn359 b;
    protected Hn359 l;
    protected B360 m;
    private Hx339 n;
    protected Gg3 p;
    protected Hn359 r;
    protected Gg3 t;
    public volatile int u;
    protected int v;
    protected Hn359 w;
    protected byte x;
    protected long y;
    public volatile int z;
    
    public static void h(final W144 w144) {
        try {
            w144.n.h();
        }
        catch (Exception ex) {}
        w144.n = null;
        ++w144.u;
        w144.z = -1;
        w144.x = (byte)(Math.random() * 255.0 + 1.0);
    }
    
    public synchronized B360 g(final int n, final int n2, final byte q, final boolean s) {
        final long p4 = ((long)n << 32) + n2;
        final B360 b360 = new B360();
        b360.p = p4;
        b360.q = q;
        b360.s = s;
        if (s) {
            if (e(this) >= 50) {
                throw new RuntimeException("Urgent list exceeded max limit of 50");
            }
            Hn359.q(this.b, b360);
        }
        else {
            if (j(this) >= 20) {
                throw new RuntimeException("Prefetch list exceeded max limit of 20");
            }
            Hn359.q(this.w, b360);
        }
        return b360;
    }
    
    public synchronized boolean s() {
        if (this.n != null) {
            final long g = Gz143.g();
            int n = (int)(g - this.y);
            this.y = g;
            if (n > 200) {
                n = 200;
            }
            this.v += n;
            if (this.v > 30000) {
                try {
                    this.n.h();
                }
                catch (Exception ex2) {}
                this.n = null;
            }
        }
        if (this.n == null) {
            return e(this) == 0 && j(this) == 0;
        }
        try {
            for (B360 b360 = (B360)Hn359.h(this.b); b360 != null; b360 = (B360)Hn359.b(this.b)) {
                this.p.v = 0;
                Gg3.k(this.p, 1);
                Gg3.c(this.p, b360.p);
                this.n.e(this.p.r, 0, this.p.r.length);
                Hn359.q(this.l, b360);
            }
            for (B360 b361 = (B360)Hn359.h(this.w); b361 != null; b361 = (B360)Hn359.b(this.w)) {
                this.p.v = 0;
                Gg3.k(this.p, 0);
                Gg3.c(this.p, b361.p);
                this.n.e(this.p.r, 0, this.p.r.length);
                Hn359.q(this.r, b361);
            }
            for (int i = 0; i < 100; ++i) {
                final int q = this.n.q();
                if (q < 0) {
                    throw new IOException();
                }
                if (q == 0) {
                    break;
                }
                this.v = 0;
                int n2 = 0;
                if (this.m == null) {
                    n2 = 10;
                }
                else if (this.m.d == 0) {
                    n2 = 1;
                }
                if (n2 > 0) {
                    int n3 = n2 - this.t.v;
                    if (n3 > q) {
                        n3 = q;
                    }
                    this.n.j(this.t.r, this.t.v, n3);
                    if (this.x != 0) {
                        for (int j = 0; j < n3; ++j) {
                            final byte[] r = this.t.r;
                            final int n4 = this.t.v + j;
                            r[n4] ^= this.x;
                        }
                    }
                    final Gg3 t = this.t;
                    t.v += n3;
                    if (this.t.v >= n2) {
                        if (this.m == null) {
                            this.t.v = 0;
                            final int ar = Gg3.ar(this.t);
                            final int bd = Gg3.bd(this.t);
                            final int ar2 = Gg3.ar(this.t);
                            final int bd2 = Gg3.bd(this.t);
                            final int k = ar2 & 0x7F;
                            final boolean b362 = (ar2 & 0x80) != 0x0;
                            final long n5 = ((long)ar << 32) + bd;
                            B360 m;
                            if (b362) {
                                for (m = (B360)Hn359.h(this.r); m != null; m = (B360)Hn359.b(this.r)) {
                                    if (m.p == n5) {
                                        break;
                                    }
                                }
                            }
                            else {
                                for (m = (B360)Hn359.h(this.l); m != null; m = (B360)Hn359.b(this.l)) {
                                    if (m.p == n5) {
                                        break;
                                    }
                                }
                            }
                            if (m == null) {
                                System.out.println("Could not find matching request - archiveid:" + ar + " groupid:" + bd + " ctype:" + k + " clen:" + bd2 + " xorcode:" + this.x);
                                throw new IOException();
                            }
                            final int n6 = (k == 0) ? 5 : 9;
                            this.m = m;
                            Gg3.k(this.m.g = new Gg3(bd2 + n6 + this.m.q), k);
                            Gg3.a(this.m.g, bd2);
                            this.m.d = 10;
                            this.t.v = 0;
                        }
                        else {
                            if (this.m.d != 0) {
                                System.out.println("Error processing incoming header!");
                                throw new IOException();
                            }
                            if (this.t.r[0] == -1) {
                                this.m.d = 1;
                                this.t.v = 0;
                            }
                            else {
                                this.m = null;
                            }
                        }
                    }
                }
                else {
                    final int n7 = this.m.g.r.length - this.m.q;
                    int n8 = 512 - this.m.d;
                    if (n8 > n7 - this.m.g.v) {
                        n8 = n7 - this.m.g.v;
                    }
                    if (n8 > q) {
                        n8 = q;
                    }
                    this.n.j(this.m.g.r, this.m.g.v, n8);
                    if (this.x != 0) {
                        for (int l = 0; l < n8; ++l) {
                            final byte[] r2 = this.m.g.r;
                            final int n9 = this.m.g.v + l;
                            r2[n9] ^= this.x;
                        }
                    }
                    final Gg3 g2 = this.m.g;
                    g2.v += n8;
                    final B360 m2 = this.m;
                    m2.d += n8;
                    if (this.m.g.v == n7) {
                        Kp349.t(this.m);
                        this.m.l = false;
                        this.m = null;
                    }
                    else if (this.m.d == 512) {
                        this.m.d = 0;
                    }
                }
            }
            return true;
        }
        catch (IOException ex) {
            ex.printStackTrace();
            try {
                this.n.h();
            }
            catch (Exception ex3) {}
            this.n = null;
            ++this.u;
            this.z = -2;
            return e(this) == 0 && j(this) == 0;
        }
    }
    
    public static synchronized boolean q(final W144 w144) {
        return e(w144) >= 50;
    }
    
    public static synchronized int j(final W144 w144) {
        return Hn359.l(w144.w) + Hn359.l(w144.r);
    }
    
    public static synchronized int e(final W144 w144) {
        return Hn359.l(w144.b) + Hn359.l(w144.l);
    }
    
    public static void r(final W144 w144) {
        if (w144.n == null) {
            return;
        }
        try {
            w144.p.v = 0;
            Gg3.k(w144.p, 7);
            Gg3.c(w144.p, 0L);
            w144.n.e(w144.p.r, 0, w144.p.r.length);
        }
        catch (IOException ex) {
            ex.printStackTrace();
            try {
                w144.n.h();
            }
            catch (Exception ex2) {}
            w144.n = null;
            ++w144.u;
            w144.z = -2;
        }
    }
    
    public static void v(final W144 w144) {
        if (w144.n != null) {
            w144.n.h();
        }
    }
    
    public static void b(final W144 w144, final Object o, final boolean b) {
        if (w144.n != null) {
            try {
                w144.n.h();
            }
            catch (Exception ex2) {}
            w144.n = null;
        }
        w144.n = (Hx339)o;
        l(w144);
        w(w144, b);
        w144.t.v = 0;
        w144.m = null;
        while (true) {
            final B360 b2 = (B360)Hn359.e(w144.l);
            if (b2 == null) {
                break;
            }
            Hn359.q(w144.b, b2);
        }
        while (true) {
            final B360 b3 = (B360)Hn359.e(w144.r);
            if (b3 == null) {
                break;
            }
            Hn359.q(w144.w, b3);
        }
        if (w144.x != 0) {
            try {
                w144.p.v = 0;
                Gg3.k(w144.p, 4);
                Gg3.k(w144.p, w144.x);
                Gg3.a(w144.p, 0);
                w144.n.e(w144.p.r, 0, w144.p.r.length);
            }
            catch (IOException ex) {
                ex.printStackTrace();
                try {
                    w144.n.h();
                }
                catch (Exception ex3) {}
                w144.n = null;
                ++w144.u;
                w144.z = -2;
            }
        }
        w144.v = 0;
        w144.y = Gz143.g();
    }
    
    protected static void l(final W144 w144) {
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
        catch (IOException ex) {
            ex.printStackTrace();
            try {
                w144.n.h();
            }
            catch (Exception ex2) {}
            w144.n = null;
            ++w144.u;
            w144.z = -2;
        }
    }
    
    public static void w(final W144 w144, final boolean b) {
        if (w144.n == null) {
            return;
        }
        try {
            w144.p.v = 0;
            Gg3.k(w144.p, b ? 2 : 3);
            Gg3.c(w144.p, 0L);
            w144.n.e(w144.p.r, 0, w144.p.r.length);
        }
        catch (IOException ex) {
            ex.printStackTrace();
            try {
                w144.n.h();
            }
            catch (Exception ex2) {}
            w144.n = null;
            ++w144.u;
            w144.z = -2;
        }
    }
    
    public static void y(final W144 w144) {
        if (w144.n != null) {
            w144.n.s();
        }
    }
    
    public W144() {
        this.b = new Hn359();
        this.l = new Hn359();
        this.w = new Hn359();
        this.r = new Hn359();
        this.p = new Gg3(6);
        this.x = 0;
        this.u = 0;
        this.z = 0;
        this.t = new Gg3(10);
    }
    
    public static synchronized boolean d(final W144 w144) {
        return j(w144) >= 20;
    }
}
