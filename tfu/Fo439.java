// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public final class Fo439
{
    private Fd458[] d;
    private int g;
    private ReferenceQueue q;
    
    public void g(final Object o, final Object d) {
        if (o == null) {
            throw new NullPointerException();
        }
        e(this);
        final int identityHashCode = System.identityHashCode(o);
        final int n = identityHashCode & this.d.length - 1;
        Fd458 q = this.d[n];
        if (q == null) {
            this.d[n] = new Fd458(o, this.q, identityHashCode, d);
            ++this.g;
            if (this.g >= this.d.length) {
                j(this);
            }
        }
        else {
            while (q.get() != o) {
                if (q.q == null) {
                    q.q = new Fd458(o, this.q, identityHashCode, d);
                    ++this.g;
                    if (this.g >= this.d.length) {
                        j(this);
                    }
                    return;
                }
                else {
                    q = q.q;
                }
            }
            q.d = d;
        }
    }
    
    public static Object d(final Fo439 fo439, final Object o) {
        if (o == null) {
            return null;
        }
        e(fo439);
        for (Fd458 q = fo439.d[System.identityHashCode(o) & fo439.d.length - 1]; q != null; q = q.q) {
            if (q.get() == o) {
                return q.d;
            }
        }
        return null;
    }
    
    public Fo439() {
        this.q = new ReferenceQueue();
        this.d = new Fd458[16];
    }
    
    private static void j(final Fo439 fo439) {
        final Fd458[] d = fo439.d;
        fo439.d = new Fd458[d.length * 2];
        for (Fd458 fd458 : d) {
            while (fd458 != null) {
                final Fd458 q = fd458.q;
                final int n = fd458.g & fo439.d.length - 1;
                fd458.q = fo439.d[n];
                fo439.d[n] = fd458;
                fd458 = q;
            }
        }
    }
    
    private static void e(final Fo439 fo439) {
        while (true) {
            final Fd458 fd458 = (Fd458)fo439.q.poll();
            if (fd458 == null) {
                break;
            }
            final int n = fd458.g & fo439.d.length - 1;
            Fd458 q = fo439.d[n];
            if (q == fd458) {
                fo439.d[n] = fd458.q;
                --fo439.g;
            }
            else {
                while (q != null && q.q != fd458) {
                    q = q.q;
                }
                if (q == null) {
                    continue;
                }
                q.q = fd458.q;
                --fo439.g;
            }
        }
    }
    
    public static void q(final Fo439 fo439, final Object o) {
        if (o == null) {
            return;
        }
        e(fo439);
        final int n = System.identityHashCode(o) & fo439.d.length - 1;
        Reference<Object> reference = (Reference<Object>)fo439.d[n];
        if (reference == null) {
            return;
        }
        if (reference.get() == o) {
            fo439.d[n] = ((Fd458)reference).q;
            --fo439.g;
        }
        else {
            while (true) {
                final Fd458 q = ((Fd458)reference).q;
                if (q == null) {
                    break;
                }
                if (q.get() == o) {
                    ((Fd458)reference).q = q.q;
                    --fo439.g;
                    break;
                }
                reference = (Reference<Object>)q;
            }
        }
    }
}
