/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.PrintStream;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import tfu.Ao128;
import tfu.Bn279;
import tfu.By651;

public final class Bv351 {
    boolean d;
    private final Ao128 g = new Ao128("Instantiated here");
    volatile boolean j;
    ConcurrentLinkedQueue q = new ConcurrentLinkedQueue();

    public Bn279 g() {
        Bn279 bn279;
        if (this.j) {
            throw new IllegalStateException();
        }
        do {
            if ((bn279 = (Bn279)this.q.poll()) != null) continue;
            return null;
        } while (bn279.b.get() != By651.FINISHED);
        return bn279;
    }

    public static void d(Bv351 bv351) {
        Bn279 bn279;
        bv351.j = true;
        while ((bn279 = (Bn279)bv351.q.poll()) != null) {
            Bn279.j(bn279);
        }
    }

    protected void finalize() {
        if (this.d && !this.j) {
            System.err.println("----------------------------------------------------------------------------");
            System.err.println("Warning: TaskFinishNotifyQueue garbage-collected without cancelAllUnpolled()");
            this.g.printStackTrace();
            System.err.println("----------------------------------------------------------------------------");
            Bv351.d(this);
        }
    }
}

