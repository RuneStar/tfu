// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public final class Eq28
{
    private static final boolean g = false;
    private int d;
    private Hn359 e;
    private Ha262 j;
    private int q;
    
    public Eq28(final int n, final int n2) {
        this.e = new Hn359();
        this.d = n;
        this.q = n;
        int n3;
        for (n3 = 1; n3 + n3 < n && n3 < n2; n3 += n3) {}
        this.j = new Ha262(n3);
    }
    
    public Object g(final long n) {
        final Fv466 fv466 = (Fv466)Ha262.d(this.j, n);
        if (fv466 == null) {
            return null;
        }
        final Object g = fv466.g();
        if (g == null) {
            Ln265.ef(fv466);
            Kp349.t(fv466);
            this.q += fv466.d;
            return null;
        }
        if (fv466.d()) {
            final En568 en568 = new En568(g, fv466.d);
            Ha262.q(this.j, en568, fv466.bq);
            Hn359.q(this.e, en568);
            en568.p = 0L;
            Ln265.ef(fv466);
            Kp349.t(fv466);
        }
        else {
            Hn359.q(this.e, fv466);
            fv466.p = 0L;
        }
        return g;
    }
    
    public static void s(final Eq28 eq28) {
        Hn359.d(eq28.e);
        Ha262.j(eq28.j);
        eq28.q = eq28.d;
    }
    
    private static void q(final Eq28 eq28, final Fv466 fv466) {
        if (fv466 != null) {
            Ln265.ef(fv466);
            Kp349.t(fv466);
            eq28.q += fv466.d;
        }
    }
    
    public static void j(final Eq28 eq28, final Object o, final long n) {
        eq28.e(o, n, 1);
    }
    
    public static void d(final Eq28 eq28, final long n) {
        q(eq28, (Fv466)Ha262.d(eq28.j, n));
    }
    
    public void h(final int n) {
        for (Fv466 fv466 = (Fv466)Hn359.h(this.e); fv466 != null; fv466 = (Fv466)Hn359.b(this.e)) {
            if (fv466.d()) {
                if (fv466.g() == null) {
                    Ln265.ef(fv466);
                    Kp349.t(fv466);
                    this.q += fv466.d;
                }
            }
            else {
                final Fv466 fv467 = fv466;
                final long p = fv467.p + 1L;
                fv467.p = p;
                if (p > n) {
                    final Ew569 ew569 = new Ew569(fv466.g(), fv466.d);
                    Ha262.q(this.j, ew569, fv466.bq);
                    Hn359.j(ew569, fv466);
                    Ln265.ef(fv466);
                    Kp349.t(fv466);
                }
            }
        }
    }
    
    public static void b(final Eq28 eq28) {
        for (Fv466 fv466 = (Fv466)Hn359.h(eq28.e); fv466 != null; fv466 = (Fv466)Hn359.b(eq28.e)) {
            if (fv466.d()) {
                Ln265.ef(fv466);
                Kp349.t(fv466);
                eq28.q += fv466.d;
            }
        }
    }
    
    public Eq28(final int n) {
        this(n, n);
    }
    
    public void e(final Object o, final long n, final int n2) {
        if (n2 > this.d) {
            throw new IllegalStateException();
        }
        d(this, n);
        this.q -= n2;
        while (this.q < 0) {
            q(this, (Fv466)Hn359.e(this.e));
        }
        final En568 en568 = new En568(o, n2);
        Ha262.q(this.j, en568, n);
        Hn359.q(this.e, en568);
        en568.p = 0L;
    }
}
