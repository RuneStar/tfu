// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import java.io.IOException;
import tfu.Ln265;
import tfu.El328;
import org.slf4j.LoggerFactory;
import tfu.Hx339;
import tfu.Ic327;
import tfu.Gx298;
import tfu.Ea395;
import tfu.Gg3;
import tfu.Gs329;
import org.slf4j.Logger;

public class N272
{
    public static final int g = 15000;
    private static final Logger logger;
    public Gs329 b;
    public int e;
    public Gg3 h;
    public Ea395 i;
    public Gx298 j;
    public Ea395 k;
    public Ic327 l;
    public int m;
    public Ea395 n;
    public boolean o;
    public float p;
    public Hx339 q;
    public Ea395 r;
    public Ic327 s;
    public int t;
    public int u;
    public int v;
    public Ic327 w;
    private long x;
    public boolean y;
    public int z;
    
    static {
        logger = LoggerFactory.getLogger(N272.class);
    }
    
    public N272() {
        this.j = new Gx298();
        this.e = 0;
        this.h = new Gg3(1350);
        this.b = new Gs329(15000);
        this.r = null;
        this.v = 0;
        this.y = true;
        this.p = 0.0f;
        this.x = 0L;
        this.o = false;
    }
    
    public static final void d(final N272 n272, final long x) {
        n272.x = x;
    }
    
    public static final void q(final N272 n272) {
        Gx298.z(n272.j);
        n272.e = 0;
    }
    
    public final void j() throws IOException {
        if (this.q != null && this.e > 0) {
            this.h.v = 0;
            while (true) {
                final El328 el328 = (El328)Gx298.i(this.j);
                if (el328 == null) {
                    break;
                }
                if (el328.j > this.h.r.length) {
                    N272.logger.error("Dropping client -> server message of type " + el328.g + " and size " + el328.j + " as it too long for buffer!");
                    Ln265.ef(el328);
                    Gg3.n(el328.q);
                    El328.j(el328);
                }
                else {
                    if (el328.j > this.h.r.length - this.h.v) {
                        break;
                    }
                    Gg3.aa(this.h, el328.q.r, 0, el328.j);
                    this.e -= el328.j;
                    Ln265.ef(el328);
                    Gg3.n(el328.q);
                    El328.j(el328);
                }
            }
            this.q.e(this.h.r, 0, this.h.v);
            this.u += this.h.v;
            this.x = 0L;
        }
    }
    
    public static final long g(final N272 n272) {
        if (n272.x == 0L) {
            n272.x = System.currentTimeMillis();
        }
        return n272.x;
    }
    
    public static void s(final N272 n272) {
        if (n272.q != null) {
            n272.q.h();
            n272.q = null;
            n272.p = 0.0f;
        }
    }
    
    public static void h(final N272 n272) {
        if (client.bj % 50 == 0) {
            n272.t = n272.u;
            n272.u = 0;
            n272.m = n272.z;
            n272.z = 0;
        }
    }
    
    public static final void e(final N272 n272, final El328 el328) {
        Gx298.t(n272.j, el328);
        el328.j = el328.q.v;
        el328.q.v = 0;
        n272.e += el328.j;
    }
}
