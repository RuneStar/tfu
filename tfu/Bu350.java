// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Callable;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.PriorityBlockingQueue;

public final class Bu350
{
    private final PriorityBlockingQueue d;
    private final String g;
    private int j;
    private final ThreadPoolExecutor q;
    
    public void d() {
        final ArrayList<Runnable> c = new ArrayList<Runnable>(this.d.size());
        this.d.drainTo(c);
        for (final Runnable e : c) {
            final Bg653 bg653 = (Bg653)e;
            if (!bg653.d.d()) {
                Bn279.j(bg653.g);
            }
            else {
                Bg653.q(bg653);
                this.d.add(e);
            }
        }
    }
    
    public Bn279 g(final Br121 br121, final Bv351 bv351, final Object o) {
        if (!br121.d()) {
            throw new IllegalStateException();
        }
        if (bv351 != null) {
            bv351.d |= br121.q();
        }
        final Bn279 bn279 = new Bn279(br121, o);
        final Bg653 bg653 = new Bg653(new Bf654(this, bn279, br121, bv351), bn279, br121, this.j++);
        bn279.e = bg653;
        this.q.execute(bg653);
        return bn279;
    }
    
    public Bu350(final int n, final String g) {
        this.g = g;
        final Mw514 threadFactory = new Mw514(this.g);
        this.d = new PriorityBlockingQueue(11);
        this.q = new ThreadPoolExecutor(n, n, 0L, TimeUnit.MILLISECONDS, this.d, threadFactory);
    }
    
    public Bu350(final String s) {
        this(1, s);
    }
    
    public static Object[] q(final Bu350 bu350, Object[] a) {
        if (a == null) {
            a = bu350.d.toArray();
        }
        else {
            a = bu350.d.toArray(a);
        }
        for (int i = 0; i < a.length; ++i) {
            final Object o = a[i];
            if (o == null) {
                break;
            }
            final Bg653 bg653 = (Bg653)o;
            if (!bg653.d.d()) {
                Bn279.j(bg653.g);
            }
            a[i] = null;
        }
        return a;
    }
    
    @Override
    public String toString() {
        return this.getClass().getName() + " \"" + this.g + "\"";
    }
}
