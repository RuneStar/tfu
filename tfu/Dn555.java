/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.PrintStream;
import tfu.Cp628;
import tfu.Cx556;
import tfu.Gx298;
import tfu.Gz143;
import tfu.Ln265;

public class Dn555
extends Cx556 {
    private static boolean d;
    private static final boolean g = true;
    private Gx298 e;
    private int h = 0;
    private Gx298 j = new Gx298();
    private long q;
    private int s = -1;

    public static final synchronized void s(Dn555 dn555, Cx556 cx556) {
        Cx556.ef(cx556);
    }

    public final synchronized void h(Cx556 cx556) {
        if (!d && Cx556.ek(cx556)) {
            d = true;
            new Throwable("Warning: if you were calling playstream in an attempt to get the stream reprioritised, it doesn't work that way any more - you should set wantmix instead").printStackTrace();
        }
        Gx298.m(this.j, cx556);
    }

    private static void u(Dn555 dn555, Cp628 cp628) {
        Cp628.ef(cp628);
        cp628.g();
        cp628.g = null;
        Ln265 ln265 = dn555.e.g.bo;
        dn555.s = ln265 == dn555.e.g ? -1 : ((Cp628)ln265).d;
    }

    private static void v(Dn555 dn555, Ln265 ln265, Cp628 cp628) {
        while (ln265 != dn555.e.g && ((Cp628)ln265).d <= cp628.d) {
            ln265 = ln265.bo;
        }
        Gx298.n(cp628, ln265);
        dn555.s = ((Cp628)dn555.e.g.bo).d;
    }

    @Override
    protected Cx556 g() {
        return (Cx556)Gx298.i(this.j);
    }

    @Override
    protected Cx556 d() {
        return (Cx556)Gx298.c(this.j);
    }

    @Override
    protected int q() {
        return 0;
    }

    private static void z(Dn555 dn555, int[] arrn, int n, int n2) {
        Cx556 cx556 = (Cx556)Gx298.i(dn555.j);
        while (cx556 != null) {
            Cx556.ck(cx556, arrn, n, n2);
            cx556 = (Cx556)Gx298.c(dn555.j);
        }
    }

    @Override
    public final synchronized void e(int n) {
        do {
            Cp628 cp628;
            if (this.s < 0) {
                Dn555.t(this, n);
                return;
            }
            if (this.h + n < this.s) {
                this.h += n;
                Dn555.t(this, n);
                return;
            }
            int n2 = this.s - this.h;
            Dn555.t(this, n2);
            n -= n2;
            this.h += n2;
            Dn555.r(this);
            Cp628 cp6282 = cp628 = (Cp628)Gx298.i(this.e);
            synchronized (cp6282) {
                int n3 = cp628.d(this);
                if (n3 < 0) {
                    cp628.d = 0;
                    Dn555.u(this, cp628);
                } else {
                    cp628.d = n3;
                    Dn555.v(this, cp628.bo, cp628);
                }
            }
        } while (n != 0);
    }

    private static void t(Dn555 dn555, int n) {
        Cx556 cx556 = (Cx556)Gx298.i(dn555.j);
        while (cx556 != null) {
            cx556.e(n);
            cx556 = (Cx556)Gx298.c(dn555.j);
        }
    }

    private static void r(Dn555 dn555) {
        if (dn555.h > 0) {
            Cp628 cp628 = (Cp628)Gx298.i(dn555.e);
            while (cp628 != null) {
                cp628.d -= dn555.h;
                cp628 = (Cp628)Gx298.c(dn555.e);
            }
            dn555.s -= dn555.h;
            dn555.h = 0;
        }
    }

    public Dn555() {
        this.e = new Gx298();
    }

    @Override
    public final synchronized void j(int[] arrn, int n, int n2) {
        long l = Gz143.g();
        if (l >= this.q + 1000L) {
            this.q = l;
            if (Gx298.aq(this.j) > 500) {
                System.out.println("MIXER: streams=" + Gx298.aq(this.j) + " - if this is growing uncontrollably, you are leaking streams!");
            }
        }
        do {
            Cp628 cp628;
            if (this.s < 0) {
                Dn555.z(this, arrn, n, n2);
                return;
            }
            if (this.h + n2 < this.s) {
                this.h += n2;
                Dn555.z(this, arrn, n, n2);
                return;
            }
            int n3 = this.s - this.h;
            Dn555.z(this, arrn, n, n3);
            n += n3;
            n2 -= n3;
            this.h += n3;
            Dn555.r(this);
            Cp628 cp6282 = cp628 = (Cp628)Gx298.i(this.e);
            synchronized (cp6282) {
                int n4 = cp628.d(this);
                if (n4 < 0) {
                    cp628.d = 0;
                    Dn555.u(this, cp628);
                } else {
                    cp628.d = n4;
                    Dn555.v(this, cp628.bo, cp628);
                }
            }
        } while (n2 != 0);
    }
}

