/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import tfu.Bn279;
import tfu.Br121;
import tfu.Bu350;
import tfu.Bv351;
import tfu.By651;

class Bf654
implements Callable {
    final /* synthetic */ Br121 d;
    final /* synthetic */ Bn279 g;
    final /* synthetic */ Bu350 j;
    final /* synthetic */ Bv351 q;

    public Object call() throws Exception {
        if (Bf654.g(this, By651.UNSTARTED, null)) {
            return null;
        }
        if (!this.g.b.compareAndSet(By651.UNSTARTED, By651.RUNNING)) {
            Bf654.d(this, null);
            return null;
        }
        Object object = null;
        try {
            object = this.d.s();
            if (!this.g.b.compareAndSet(By651.RUNNING, By651.FINISHED)) {
                Bf654.d(this, object);
                return null;
            }
            if (this.q != null) {
                this.q.q.add(this.g);
                if (Bf654.g(this, By651.FINISHED, object)) {
                    return null;
                }
            }
        }
        catch (Throwable throwable) {
            if (!this.g.b.compareAndSet(By651.RUNNING, By651.FINISHED)) {
                Bf654.d(this, object);
                return null;
            }
            if (this.q != null) {
                this.q.q.add(this.g);
                if (Bf654.g(this, By651.FINISHED, object)) {
                    return null;
                }
            }
            throw throwable;
        }
        return object;
    }

    private static boolean g(Bf654 bf654, By651 by651, Object object) {
        if (bf654.q != null && bf654.q.j) {
            if (bf654.g.b.compareAndSet(by651, By651.CANCELLED)) {
                Bf654.d(bf654, object);
            }
            return true;
        }
        return false;
    }

    private static void d(Bf654 bf654, Object object) {
        try {
            bf654.d.h(object);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    Bf654(Bu350 bu350, Bn279 bn279, Br121 br121, Bv351 bv351) {
        this.g = bn279;
        this.d = br121;
        this.q = bv351;
        this.j = bu350;
    }
}

