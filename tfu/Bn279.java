// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

public final class Bn279
{
    static final boolean g = false;
    AtomicReference b;
    Ao128 d;
    Future e;
    private Object h;
    public final Object j;
    Br121 q;
    private ExecutionException s;
    
    @Override
    protected void finalize() {
        if (this.q != null && this.q.q() && this.b.get() != By651.CANCELLED) {
            System.err.println("--------------------------------------------------------------------------");
            System.err.println("Error: TaskFuture garbage-collected without get() and without cancellation");
            System.err.println("Task: " + this.q);
            System.err.println("To see where the task was started, enable TaskFuture.debugWhereStarted");
            System.err.println("--------------------------------------------------------------------------");
            j(this);
        }
    }
    
    Bn279(final Br121 q, final Object j) {
        this.b = new AtomicReference((V)By651.UNSTARTED);
        this.q = q;
        this.j = j;
    }
    
    public Object d() throws ExecutionException {
        if (this.e != null) {
            this.q();
            this.q = null;
        }
        if (this.b.get() == By651.CANCELLED) {
            throw new IllegalStateException("Task has been cancelled!");
        }
        if (this.s != null) {
            throw this.s;
        }
        return this.h;
    }
    
    private void q() {
        try {
            this.h = this.e.get();
            this.e = null;
        }
        catch (InterruptedException cause) {
            throw new IllegalStateException(cause);
        }
        catch (ExecutionException s) {
            this.s = s;
            this.e = null;
        }
    }
    
    public static void j(final Bn279 bn279) {
        if (bn279.b.getAndSet(By651.CANCELLED) == By651.FINISHED) {
            if (bn279.e == null) {
                return;
            }
            bn279.q();
            try {
                bn279.q.h(bn279.h);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        bn279.q = null;
    }
    
    public static boolean g(final Bn279 bn279) {
        return bn279.e == null || bn279.e.isDone();
    }
}
