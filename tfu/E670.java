/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import tfu.S671;

class E670
implements Future {
    private volatile boolean d = false;
    private final S671 g;
    private volatile boolean j = false;
    private volatile boolean q = false;

    @Override
    public boolean isDone() {
        return this.q;
    }

    @Override
    public boolean isCancelled() {
        return this.j;
    }

    public S671 g() throws InterruptedException, ExecutionException {
        if (!this.q) {
            E670 e670 = this;
            synchronized (e670) {
                while (!this.q) {
                    this.wait();
                }
            }
        }
        if (this.j) {
            throw new InterruptedException();
        }
        return this.g;
    }

    public S671 d(long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (!this.q) {
            E670 e670 = this;
            synchronized (e670) {
                while (!this.q) {
                    this.wait(timeUnit.toMillis(l));
                }
            }
        }
        if (this.j) {
            throw new InterruptedException();
        }
        return this.q ? this.g : null;
    }

    static void q(E670 e670) {
        E670 e6702 = e670;
        synchronized (e6702) {
            if (e670.j) {
                return;
            }
            e670.d = true;
        }
        e670.g.g();
        e6702 = e670;
        synchronized (e6702) {
            e670.q = true;
            e670.notifyAll();
        }
    }

    public E670(S671 s671) {
        this.g = s671;
    }

    @Override
    public boolean cancel(boolean bl) {
        E670 e670 = this;
        synchronized (e670) {
            if (this.q) {
                return false;
            }
            if (bl && this.d) {
                return false;
            }
            this.j = true;
            this.q = true;
            this.notifyAll();
        }
        return true;
    }
}

