// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Dn555 extends Cx556
{
    private static boolean d;
    private static final boolean g = true;
    private Gx298 e;
    private int h;
    private Gx298 j;
    private long q;
    private int s;
    
    public static final synchronized void s(final Dn555 dn555, final Cx556 cx556) {
        Ln265.ef(cx556);
    }
    
    public final synchronized void h(final Cx556 cx556) {
        if (!Dn555.d && Ln265.ek(cx556)) {
            Dn555.d = true;
            new Throwable("Warning: if you were calling playstream in an attempt to get the stream reprioritised, it doesn't work that way any more - you should set wantmix instead").printStackTrace();
        }
        Gx298.m(this.j, cx556);
    }
    
    private static void u(final Dn555 dn555, final Cp628 cp628) {
        Ln265.ef(cp628);
        cp628.g();
        cp628.g = null;
        final Ln265 bo = dn555.e.g.bo;
        if (bo == dn555.e.g) {
            dn555.s = -1;
        }
        else {
            dn555.s = ((Cp628)bo).d;
        }
    }
    
    private static void v(final Dn555 dn555, Ln265 bo, final Cp628 cp628) {
        while (bo != dn555.e.g && ((Cp628)bo).d <= cp628.d) {
            bo = bo.bo;
        }
        Gx298.n(cp628, bo);
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
    
    private static void z(final Dn555 dn555, final int[] array, final int n, final int n2) {
        for (Cx556 cx556 = (Cx556)Gx298.i(dn555.j); cx556 != null; cx556 = (Cx556)Gx298.c(dn555.j)) {
            Cx556.ck(cx556, array, n, n2);
        }
    }
    
    @Override
    public final synchronized void e(int n) {
        while (this.s >= 0) {
            if (this.h + n < this.s) {
                this.h += n;
                t(this, n);
                return;
            }
            final int n2 = this.s - this.h;
            t(this, n2);
            n -= n2;
            this.h += n2;
            r(this);
            final Cp628 cp628 = (Cp628)Gx298.i(this.e);
            synchronized (cp628) {
                final int d = cp628.d(this);
                if (d < 0) {
                    cp628.d = 0;
                    u(this, cp628);
                }
                else {
                    cp628.d = d;
                    v(this, cp628.bo, cp628);
                }
            }
            if (n == 0) {
                return;
            }
        }
        t(this, n);
    }
    
    private static void t(final Dn555 dn555, final int n) {
        for (Cx556 cx556 = (Cx556)Gx298.i(dn555.j); cx556 != null; cx556 = (Cx556)Gx298.c(dn555.j)) {
            cx556.e(n);
        }
    }
    
    private static void r(final Dn555 dn555) {
        if (dn555.h > 0) {
            for (Cp628 cp628 = (Cp628)Gx298.i(dn555.e); cp628 != null; cp628 = (Cp628)Gx298.c(dn555.e)) {
                final Cp628 cp629 = cp628;
                cp629.d -= dn555.h;
            }
            dn555.s -= dn555.h;
            dn555.h = 0;
        }
    }
    
    public Dn555() {
        this.j = new Gx298();
        this.e = new Gx298();
        this.h = 0;
        this.s = -1;
    }
    
    @Override
    public final synchronized void j(final int[] array, int n, int n2) {
        final long g = Gz143.g();
        if (g >= this.q + 1000L) {
            this.q = g;
            if (Gx298.aq(this.j) > 500) {
                System.out.println("MIXER: streams=" + Gx298.aq(this.j) + " - if this is growing uncontrollably, you are leaking streams!");
            }
        }
        while (this.s >= 0) {
            if (this.h + n2 < this.s) {
                this.h += n2;
                z(this, array, n, n2);
                return;
            }
            final int n3 = this.s - this.h;
            z(this, array, n, n3);
            n += n3;
            n2 -= n3;
            this.h += n3;
            r(this);
            final Cp628 cp628 = (Cp628)Gx298.i(this.e);
            synchronized (cp628) {
                final int d = cp628.d(this);
                if (d < 0) {
                    cp628.d = 0;
                    u(this, cp628);
                }
                else {
                    cp628.d = d;
                    v(this, cp628.bo, cp628);
                }
            }
            if (n2 == 0) {
                return;
            }
        }
        z(this, array, n, n2);
    }
}
