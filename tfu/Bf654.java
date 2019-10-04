// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.concurrent.Callable;

class Bf654 implements Callable
{
    final /* synthetic */ Br121 d;
    final /* synthetic */ Bn279 g;
    final /* synthetic */ Bu350 j;
    final /* synthetic */ Bv351 q;
    
    @Override
    public Object call() throws Exception {
        if (g(this, By651.UNSTARTED, null)) {
            return null;
        }
        if (!this.g.b.compareAndSet(By651.UNSTARTED, By651.RUNNING)) {
            d(this, null);
            return null;
        }
        Object s = null;
        try {
            s = this.d.s();
            if (!this.g.b.compareAndSet(By651.RUNNING, By651.FINISHED)) {
                d(this, s);
                return null;
            }
            if (this.q != null) {
                this.q.q.add(this.g);
                if (g(this, By651.FINISHED, s)) {
                    return null;
                }
            }
        }
        finally {
            if (!this.g.b.compareAndSet(By651.RUNNING, By651.FINISHED)) {
                d(this, s);
                return null;
            }
            if (this.q != null) {
                this.q.q.add(this.g);
                if (g(this, By651.FINISHED, s)) {
                    return null;
                }
            }
        }
        return s;
    }
    
    private static boolean g(final Bf654 bf654, final By651 expectedValue, final Object o) {
        if (bf654.q != null && bf654.q.j) {
            if (bf654.g.b.compareAndSet(expectedValue, By651.CANCELLED)) {
                d(bf654, o);
            }
            return true;
        }
        return false;
    }
    
    private static void d(final Bf654 bf654, final Object o) {
        try {
            bf654.d.h(o);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    Bf654(final Bu350 j, final Bn279 g, final Br121 d, final Bv351 q) {
        this.g = g;
        this.d = d;
        this.q = q;
        this.j = j;
    }
}
