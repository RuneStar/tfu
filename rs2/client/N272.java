/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.client;
import tfu.Ea395;
import tfu.El328;
import tfu.Eu326;
import tfu.Gg3;
import tfu.Gs329;
import tfu.Gx298;
import tfu.Hx339;
import tfu.Ic327;

public class N272 {
    public static final int g = 15000;
    private static final Logger logger = LoggerFactory.getLogger(N272.class);
    public Gs329 b;
    public int e = 0;
    public Gg3 h;
    public Ea395 i;
    public Gx298 j = new Gx298();
    public Ea395 k;
    public Ic327 l;
    public int m;
    public Ea395 n;
    public boolean o = false;
    public float p = 0.0f;
    public Hx339 q;
    public Ea395 r = null;
    public Ic327 s;
    public int t;
    public int u;
    public int v = 0;
    public Ic327 w;
    private long x = 0L;
    public boolean y = true;
    public int z;

    public N272() {
        this.h = new Gg3(1350);
        this.b = new Gs329(15000);
    }

    public static final void d(N272 n272, long l) {
        n272.x = l;
    }

    public static final void q(N272 n272) {
        Gx298.z(n272.j);
        n272.e = 0;
    }

    public final void j() throws IOException {
        if (this.q != null && this.e > 0) {
            El328 el328;
            this.h.v = 0;
            while ((el328 = (El328)Gx298.i(this.j)) != null) {
                if (el328.j > this.h.r.length) {
                    logger.error("Dropping client -> server message of type " + (Object)((Object)el328.g) + " and size " + el328.j + " as it too long for buffer!");
                    El328.ef(el328);
                    Gs329.n(el328.q);
                    El328.j(el328);
                    continue;
                }
                if (el328.j > this.h.r.length - this.h.v) break;
                Gg3.aa(this.h, el328.q.r, 0, el328.j);
                this.e -= el328.j;
                El328.ef(el328);
                Gs329.n(el328.q);
                El328.j(el328);
            }
            this.q.e(this.h.r, 0, this.h.v);
            this.u += this.h.v;
            this.x = 0L;
        }
    }

    public static final long g(N272 n272) {
        if (n272.x == 0L) {
            n272.x = System.currentTimeMillis();
        }
        return n272.x;
    }

    public static void s(N272 n272) {
        if (n272.q != null) {
            n272.q.h();
            n272.q = null;
            n272.p = 0.0f;
        }
    }

    public static void h(N272 n272) {
        if (client.bj % 50 == 0) {
            n272.t = n272.u;
            n272.u = 0;
            n272.m = n272.z;
            n272.z = 0;
        }
    }

    public static final void e(N272 n272, El328 el328) {
        Gx298.t(n272.j, el328);
        el328.j = el328.q.v;
        el328.q.v = 0;
        n272.e += el328.j;
    }
}

