// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.lang.ref.ReferenceQueue;

public final class Fl59
{
    private Fh453[] d;
    private int g;
    private ReferenceQueue j;
    private ReferenceQueue q;
    
    public static Object d(final Fl59 fl59, final Object o) {
        if (o == null) {
            return null;
        }
        j(fl59);
        for (Fh453 q = fl59.d[System.identityHashCode(o) & fl59.d.length - 1]; q != null; q = q.q) {
            if (q.get() == o) {
                return q.d.get();
            }
        }
        return null;
    }
    
    private static void q(final Fl59 fl59) {
        final Fh453[] d = fl59.d;
        fl59.d = new Fh453[d.length * 2];
        for (Fh453 fh453 : d) {
            while (fh453 != null) {
                final Fh453 q = fh453.q;
                final int n = fh453.g & fl59.d.length - 1;
                fh453.q = fl59.d[n];
                fl59.d[n] = fh453;
                fh453 = q;
            }
        }
    }
    
    private static void j(final Fl59 fl59) {
        while (true) {
            final Fh453 fh453 = (Fh453)fl59.q.poll();
            if (fh453 == null) {
                break;
            }
            final int n = fh453.g & fl59.d.length - 1;
            Fh453 q = fl59.d[n];
            if (q == fh453) {
                fl59.d[n] = fh453.q;
                --fl59.g;
            }
            else {
                while (q != null && q.q != fh453) {
                    q = q.q;
                }
                if (q == null) {
                    continue;
                }
                q.q = fh453.q;
                --fl59.g;
            }
        }
        while (true) {
            final Fa452 fa452 = (Fa452)fl59.j.poll();
            if (fa452 == null) {
                break;
            }
            final Fh453 g = fa452.g;
            if (g.d != fa452) {
                continue;
            }
            final int n2 = g.g & fl59.d.length - 1;
            Fh453 q2 = fl59.d[n2];
            if (q2 == g) {
                fl59.d[n2] = g.q;
                --fl59.g;
            }
            else {
                while (q2 != null && q2.q != g) {
                    q2 = q2.q;
                }
                if (q2 == null) {
                    continue;
                }
                q2.q = g.q;
                --fl59.g;
            }
        }
    }
    
    public Fl59() {
        this.q = new ReferenceQueue();
        this.j = new ReferenceQueue();
        this.d = new Fh453[16];
    }
    
    public void g(final Object o, final Object o2) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (o2 == null) {
            throw new NullPointerException();
        }
        j(this);
        final int identityHashCode = System.identityHashCode(o);
        final int n = identityHashCode & this.d.length - 1;
        Fh453 q = this.d[n];
        if (q == null) {
            this.d[n] = new Fh453(o, this.q, identityHashCode, o2, this.j);
            ++this.g;
            if (this.g >= this.d.length) {
                q(this);
            }
        }
        else {
            while (q.get() != o) {
                if (q.q == null) {
                    q.q = new Fh453(o, this.q, identityHashCode, o2, this.j);
                    ++this.g;
                    if (this.g >= this.d.length) {
                        q(this);
                    }
                    return;
                }
                else {
                    q = q.q;
                }
            }
            q.g(o2, this.j);
        }
    }
}
