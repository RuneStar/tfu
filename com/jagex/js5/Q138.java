// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.js5;

import tfu.Gz143;
import tfu.Iw364;
import tfu.Ln265;
import tfu.Ha262;
import tfu.Gx298;
import tfu.Hl134;
import java.util.zip.CRC32;

public class Q138 extends S136
{
    private static CRC32 ag;
    private static final int ai = 1;
    private static final int al = 2;
    private static final int aq = 0;
    private static final int c = 250;
    private static final int f = 1000;
    private static final byte r = 0;
    private static final byte v = 1;
    private static final byte y = -1;
    private long a;
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
    private int n;
    private boolean o;
    private byte[] p;
    private L145 q;
    private int s;
    private boolean t;
    public int u;
    private H362 w;
    public int x;
    private Ha262 z;
    
    @Override
    public int s() {
        return this.u;
    }
    
    public H362 d() {
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
        final byte[] g = this.h.g();
        Label_0337: {
            if (this.h instanceof D363) {
                try {
                    if (g == null) {
                        throw new RuntimeException("Index not found in disk cache");
                    }
                    this.w = new H362(g, this.s, this.b);
                    if (this.w.j != this.l) {
                        throw new RuntimeException("Index version wrong - index.indexversion:" + this.w.j + " expected:" + this.l);
                    }
                    break Label_0337;
                }
                catch (RuntimeException ex) {
                    this.w = null;
                    if (W144.q(this.d)) {
                        this.h = null;
                    }
                    else {
                        this.h = this.d.g(255, this.g, (byte)0, true);
                    }
                    return null;
                }
            }
            try {
                if (g == null) {
                    throw new RuntimeException("Failed to download index from server!");
                }
                this.w = new H362(g, this.s, this.b);
            }
            catch (RuntimeException ex2) {
                W144.h(this.d);
                this.w = null;
                if (W144.q(this.d)) {
                    this.h = null;
                }
                else {
                    this.h = this.d.g(255, this.g, (byte)0, true);
                }
                return null;
            }
            if (this.e != null) {
                this.q.j(this.g, g, this.e);
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
    protected synchronized byte[] q(final int n) {
        final E361 j = this.j(n, 0);
        if (j == null) {
            return null;
        }
        final byte[] g = j.g();
        Ln265.ef(j);
        return g;
    }
    
    private synchronized E361 j(final int i, final int n) {
        E361 e361 = (E361)Ha262.d(this.z, i);
        if (e361 != null && n == 0 && !e361.s && e361.l) {
            Ln265.ef(e361);
            e361 = null;
        }
        if (e361 == null) {
            if (n == 0) {
                if (this.j != null && this.p[i] != -1) {
                    e361 = this.q.q(i, this.j);
                }
                else {
                    if (W144.q(this.d)) {
                        return null;
                    }
                    e361 = this.d.g(this.g, i, (byte)2, true);
                }
            }
            else if (n == 1) {
                if (this.j == null) {
                    throw new RuntimeException("fetchgroup_inner - VERIFY requested but no datafs available!");
                }
                e361 = this.q.e(i, this.j);
            }
            else {
                if (n != 2) {
                    throw new RuntimeException("Invalid fetchgroup mode!");
                }
                if (this.j == null) {
                    throw new RuntimeException("fetchgroup_inner - PREFETCH requested but no datafs available!");
                }
                if (this.p[i] != -1) {
                    throw new RuntimeException("fetchgroup_inner - PREFETCH requested, but cache isn't known invalid!");
                }
                if (W144.d(this.d)) {
                    return null;
                }
                e361 = this.d.g(this.g, i, (byte)2, false);
            }
            Ha262.q(this.z, e361, i);
        }
        if (e361.l) {
            return null;
        }
        final byte[] g = e361.g();
        if (e361 instanceof D363) {
            try {
                if (g == null || g.length <= 2) {
                    throw new RuntimeException("Data not in cache - data:" + g);
                }
                Q138.ag.reset();
                Q138.ag.update(g, 0, g.length - 2);
                if ((int)Q138.ag.getValue() != this.w.w[i]) {
                    throw new RuntimeException("Disk fetch CRC incorrect");
                }
                if (this.w.r != null && this.w.r[i] != null) {
                    final byte[] array = this.w.r[i];
                    final byte[] e362 = Iw364.e(g, 0, g.length - 2);
                    for (int j = 0; j < 64; ++j) {
                        if (e362[j] != array[j]) {
                            throw new RuntimeException("Disk fetch Whirlpool incorrect");
                        }
                    }
                }
                final int k = ((g[g.length - 2] & 0xFF) << 8) + (g[g.length - 1] & 0xFF);
                if (k != (this.w.v[i] & 0xFFFF)) {
                    throw new RuntimeException("Version incorrect - wanted:" + this.w.v[i] + " got:" + k);
                }
                if (this.p[i] != 1) {
                    if (this.p[i] == 0) {
                        ++this.x;
                    }
                    ++this.u;
                    this.p[i] = 1;
                }
                if (!e361.s) {
                    Ln265.ef(e361);
                }
                return e361;
            }
            catch (Exception ex) {
                this.p[i] = -1;
                Ln265.ef(e361);
                if (e361.s && !W144.q(this.d)) {
                    Ha262.q(this.z, this.d.g(this.g, i, (byte)2, true), i);
                }
                return null;
            }
        }
        try {
            if (g == null || g.length <= 2) {
                throw new RuntimeException("Data from server too small - data:" + g);
            }
            Q138.ag.reset();
            Q138.ag.update(g, 0, g.length - 2);
            if ((int)Q138.ag.getValue() != this.w.w[i]) {
                throw new RuntimeException("Net fetch CRC incorrect");
            }
            if (this.w.r != null && this.w.r[i] != null) {
                final byte[] array2 = this.w.r[i];
                final byte[] e363 = Iw364.e(g, 0, g.length - 2);
                for (int l = 0; l < 64; ++l) {
                    if (e363[l] != array2[l]) {
                        throw new RuntimeException("Whirlpool for group " + i + " incorrect - got:" + js5.av(e363) + " expected:" + js5.av(array2));
                    }
                }
            }
            this.d.u = 0;
            this.d.z = 0;
        }
        catch (RuntimeException ex2) {
            W144.h(this.d);
            Ln265.ef(e361);
            if (e361.s && !W144.q(this.d)) {
                Ha262.q(this.z, this.d.g(this.g, i, (byte)2, true), i);
            }
            return null;
        }
        g[g.length - 2] = (byte)(this.w.v[i] >>> 8);
        g[g.length - 1] = (byte)this.w.v[i];
        if (this.j != null) {
            this.q.j(i, g, this.j);
            if (this.p[i] != 1) {
                ++this.u;
                this.p[i] = 1;
            }
        }
        if (!e361.s) {
            Ln265.ef(e361);
        }
        return e361;
    }
    
    @Override
    protected synchronized int w(final int n) {
        final E361 e361 = (E361)Ha262.d(this.z, n);
        if (e361 != null) {
            return e361.d();
        }
        return 0;
    }
    
    public synchronized void h() {
        if (this.k != null) {
            if (this.d() == null) {
                return;
            }
            if (this.m) {
                boolean b = true;
                for (Ln265 ln265 = Gx298.i(this.k); ln265 != null; ln265 = Gx298.c(this.k)) {
                    final int n = (int)ln265.bq;
                    if (this.p[n] == 0) {
                        this.j(n, 1);
                    }
                    if (this.p[n] != 0) {
                        Ln265.ef(ln265);
                    }
                    else {
                        b = false;
                    }
                }
                while (this.n < this.w.y.length) {
                    if (this.w.y[this.n] == 0) {
                        ++this.n;
                    }
                    else {
                        if (this.q.d >= 250) {
                            b = false;
                            break;
                        }
                        if (this.p[this.n] == 0) {
                            this.j(this.n, 1);
                        }
                        if (this.p[this.n] == 0) {
                            final Ln265 ln266 = new Ln265();
                            ln266.bq = this.n;
                            Gx298.t(this.k, ln266);
                            b = false;
                        }
                        ++this.n;
                    }
                }
                if (b) {
                    this.m = false;
                    this.n = 0;
                }
            }
            else if (this.t) {
                boolean b2 = true;
                for (Ln265 ln267 = Gx298.i(this.k); ln267 != null; ln267 = Gx298.c(this.k)) {
                    final int n2 = (int)ln267.bq;
                    if (this.p[n2] != 1) {
                        this.j(n2, 2);
                    }
                    if (this.p[n2] == 1) {
                        Ln265.ef(ln267);
                    }
                    else {
                        b2 = false;
                    }
                }
                while (this.n < this.w.y.length) {
                    if (this.w.y[this.n] == 0) {
                        ++this.n;
                    }
                    else {
                        if (W144.d(this.d)) {
                            b2 = false;
                            break;
                        }
                        if (this.p[this.n] != 1) {
                            this.j(this.n, 2);
                        }
                        if (this.p[this.n] != 1) {
                            final Ln265 ln268 = new Ln265();
                            ln268.bq = this.n;
                            Gx298.t(this.k, ln268);
                            b2 = false;
                        }
                        ++this.n;
                    }
                }
                if (b2) {
                    this.t = false;
                    this.n = 0;
                }
            }
            else {
                this.k = null;
            }
        }
        if (this.o && Gz143.g() >= this.a) {
            for (E361 e361 = (E361)Ha262.e(this.z); e361 != null; e361 = (E361)Ha262.h(this.z)) {
                if (!e361.l) {
                    if (e361.b) {
                        if (!e361.s) {
                            throw new RuntimeException("Unexpected non-urgent orphan! archiveid:" + this.g + " group:" + e361.p);
                        }
                        Ln265.ef(e361);
                    }
                    else {
                        e361.b = true;
                    }
                }
            }
            this.a = Gz143.g() + 1000L;
        }
    }
    
    Q138(final int g, final Hl134 j, final Hl134 e, final W144 d, final L145 q, final int s, final byte[] b, final int l, final boolean o) {
        this.x = 0;
        this.u = 0;
        this.z = new Ha262(16);
        this.n = 0;
        this.i = new Gx298();
        this.a = 0L;
        this.g = g;
        this.j = j;
        if (this.j == null) {
            this.m = false;
        }
        else {
            this.m = true;
            this.k = new Gx298();
        }
        this.e = e;
        this.d = d;
        this.q = q;
        this.s = s;
        this.b = b;
        this.l = l;
        this.o = o;
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
    
    public static synchronized void e(final Q138 q138) {
        if (q138.k == null) {
            return;
        }
        if (q138.d() == null) {
            return;
        }
        for (Ln265 ln265 = Gx298.i(q138.i); ln265 != null; ln265 = Gx298.c(q138.i)) {
            final int n = (int)ln265.bq;
            if (n < 0 || n >= q138.w.l || q138.w.y[n] == 0) {
                Ln265.ef(ln265);
            }
            else {
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
        }
    }
    
    static {
        Q138.ag = new CRC32();
    }
    
    @Override
    public int g() {
        if (this.d() != null) {
            return 100;
        }
        if (this.h == null) {
            return 0;
        }
        return this.h.d();
    }
    
    @Override
    public synchronized int b() {
        if (this.w == null) {
            return 0;
        }
        if (!this.m) {
            return this.w.e;
        }
        final Ln265 i = Gx298.i(this.k);
        if (i == null) {
            return 0;
        }
        return (int)i.bq;
    }
}
