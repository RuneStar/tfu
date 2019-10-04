/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.En568;
import tfu.Ew569;
import tfu.Fv466;
import tfu.Ha262;
import tfu.Hn359;
import tfu.Kp349;
import tfu.Ln265;

public final class Eq28 {
    private static final boolean g = false;
    private int d;
    private Hn359 e = new Hn359();
    private Ha262 j;
    private int q;

    public Eq28(int n, int n2) {
        int n3;
        this.d = n;
        this.q = n;
        for (n3 = 1; n3 + n3 < n && n3 < n2; n3 += n3) {
        }
        this.j = new Ha262(n3);
    }

    public Object g(long l) {
        Fv466 fv466 = (Fv466)Ha262.d(this.j, l);
        if (fv466 == null) {
            return null;
        }
        Object object = fv466.g();
        if (object == null) {
            Fv466.ef(fv466);
            Fv466.t(fv466);
            this.q += fv466.d;
            return null;
        }
        if (fv466.d()) {
            En568 en568 = new En568(object, fv466.d);
            Ha262.q(this.j, en568, fv466.bq);
            Hn359.q(this.e, en568);
            en568.p = 0L;
            Fv466.ef(fv466);
            Fv466.t(fv466);
        } else {
            Hn359.q(this.e, fv466);
            fv466.p = 0L;
        }
        return object;
    }

    public static void s(Eq28 eq28) {
        Hn359.d(eq28.e);
        Ha262.j(eq28.j);
        eq28.q = eq28.d;
    }

    private static void q(Eq28 eq28, Fv466 fv466) {
        if (fv466 != null) {
            Fv466.ef(fv466);
            Fv466.t(fv466);
            eq28.q += fv466.d;
        }
    }

    public static void j(Eq28 eq28, Object object, long l) {
        eq28.e(object, l, 1);
    }

    public static void d(Eq28 eq28, long l) {
        Fv466 fv466 = (Fv466)Ha262.d(eq28.j, l);
        Eq28.q(eq28, fv466);
    }

    public void h(int n) {
        Fv466 fv466 = (Fv466)Hn359.h(this.e);
        while (fv466 != null) {
            if (fv466.d()) {
                if (fv466.g() == null) {
                    Fv466.ef(fv466);
                    Fv466.t(fv466);
                    this.q += fv466.d;
                }
            } else if (++fv466.p > (long)n) {
                Ew569 ew569 = new Ew569(fv466.g(), fv466.d);
                Ha262.q(this.j, ew569, fv466.bq);
                Hn359.j(ew569, fv466);
                Fv466.ef(fv466);
                Fv466.t(fv466);
            }
            fv466 = (Fv466)Hn359.b(this.e);
        }
    }

    public static void b(Eq28 eq28) {
        Fv466 fv466 = (Fv466)Hn359.h(eq28.e);
        while (fv466 != null) {
            if (fv466.d()) {
                Fv466.ef(fv466);
                Fv466.t(fv466);
                eq28.q += fv466.d;
            }
            fv466 = (Fv466)Hn359.b(eq28.e);
        }
    }

    public Eq28(int n) {
        this(n, n);
    }

    public void e(Object object, long l, int n) {
        Fv466 fv466;
        if (n > this.d) {
            throw new IllegalStateException();
        }
        Eq28.d(this, l);
        this.q -= n;
        while (this.q < 0) {
            fv466 = (Fv466)Hn359.e(this.e);
            Eq28.q(this, fv466);
        }
        fv466 = new En568(object, n);
        Ha262.q(this.j, fv466, l);
        Hn359.q(this.e, fv466);
        fv466.p = 0L;
    }
}

