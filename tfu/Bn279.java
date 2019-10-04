/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.PrintStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import tfu.Ao128;
import tfu.Br121;
import tfu.By651;

public final class Bn279 {
    static final boolean g = false;
    AtomicReference b = new AtomicReference<By651>(By651.UNSTARTED);
    Ao128 d;
    Future e;
    private Object h;
    public final Object j;
    Br121 q;
    private ExecutionException s;

    protected void finalize() {
        if (this.q != null && this.q.q() && this.b.get() != By651.CANCELLED) {
            System.err.println("--------------------------------------------------------------------------");
            System.err.println("Error: TaskFuture garbage-collected without get() and without cancellation");
            System.err.println("Task: " + this.q);
            System.err.println("To see where the task was started, enable TaskFuture.debugWhereStarted");
            System.err.println("--------------------------------------------------------------------------");
            Bn279.j(this);
        }
    }

    Bn279(Br121 br121, Object object) {
        this.q = br121;
        this.j = object;
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
        catch (InterruptedException interruptedException) {
            throw new IllegalStateException(interruptedException);
        }
        catch (ExecutionException executionException) {
            this.s = executionException;
            this.e = null;
        }
    }

    public static void j(Bn279 bn279) {
        By651 by651 = bn279.b.getAndSet(By651.CANCELLED);
        if (by651 == By651.FINISHED) {
            if (bn279.e == null) {
                return;
            }
            bn279.q();
            try {
                bn279.q.h(bn279.h);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        bn279.q = null;
    }

    public static boolean g(Bn279 bn279) {
        return bn279.e == null || bn279.e.isDone();
    }
}

