// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.concurrent.ConcurrentLinkedQueue;

public final class Bv351
{
    boolean d;
    private final Ao128 g;
    volatile boolean j;
    ConcurrentLinkedQueue q;
    
    public Bn279 g() {
        if (this.j) {
            throw new IllegalStateException();
        }
        Bn279 bn279;
        do {
            bn279 = this.q.poll();
            if (bn279 == null) {
                return null;
            }
        } while (bn279.b.get() != By651.FINISHED);
        return bn279;
    }
    
    public static void d(final Bv351 bv351) {
        bv351.j = true;
        while (true) {
            final Bn279 bn279 = bv351.q.poll();
            if (bn279 == null) {
                break;
            }
            Bn279.j(bn279);
        }
    }
    
    @Override
    protected void finalize() {
        if (this.d && !this.j) {
            System.err.println("----------------------------------------------------------------------------");
            System.err.println("Warning: TaskFinishNotifyQueue garbage-collected without cancelAllUnpolled()");
            this.g.printStackTrace();
            System.err.println("----------------------------------------------------------------------------");
            d(this);
        }
    }
    
    public Bv351() {
        this.g = new Ao128("Instantiated here");
        this.q = new ConcurrentLinkedQueue();
    }
}
