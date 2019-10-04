/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import tfu.Bf654;
import tfu.Bg653;
import tfu.Bn279;
import tfu.Br121;
import tfu.Bv351;
import tfu.Mw514;

public final class Bu350 {
    private final PriorityBlockingQueue d;
    private final String g;
    private int j;
    private final ThreadPoolExecutor q;

    public void d() {
        ArrayList arrayList = new ArrayList(this.d.size());
        this.d.drainTo(arrayList);
        for (Runnable runnable : arrayList) {
            Bg653 bg653 = (Bg653)runnable;
            if (!bg653.d.d()) {
                Bn279.j(bg653.g);
                continue;
            }
            Bg653.q(bg653);
            this.d.add(runnable);
        }
    }

    public Bn279 g(Br121 br121, Bv351 bv351, Object object) {
        if (!br121.d()) {
            throw new IllegalStateException();
        }
        if (bv351 != null) {
            bv351.d |= br121.q();
        }
        Bn279 bn279 = new Bn279(br121, object);
        Bf654 bf654 = new Bf654(this, bn279, br121, bv351);
        Bg653 bg653 = new Bg653(bf654, bn279, br121, this.j++);
        bn279.e = bg653;
        this.q.execute(bg653);
        return bn279;
    }

    public Bu350(int n, String string) {
        this.g = string;
        Mw514 mw514 = new Mw514(this.g);
        this.d = new PriorityBlockingQueue(11);
        this.q = new ThreadPoolExecutor(n, n, 0L, TimeUnit.MILLISECONDS, (BlockingQueue<Runnable>)this.d, mw514);
    }

    public Bu350(String string) {
        this(1, string);
    }

    public static Object[] q(Bu350 bu350, Object[] arrobject) {
        Object object;
        arrobject = arrobject == null ? bu350.d.toArray() : bu350.d.toArray(arrobject);
        for (int i = 0; i < arrobject.length && (object = arrobject[i]) != null; ++i) {
            Bg653 bg653 = (Bg653)object;
            if (!bg653.d.d()) {
                Bn279.j(bg653.g);
            }
            arrobject[i] = null;
        }
        return arrobject;
    }

    public String toString() {
        return this.getClass().getName() + " \"" + this.g + "\"";
    }
}

