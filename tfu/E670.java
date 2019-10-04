// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class E670 implements Future
{
    private volatile boolean d;
    private final S671 g;
    private volatile boolean j;
    private volatile boolean q;
    
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
            synchronized (this) {
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
    
    public S671 d(final long duration, final TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (!this.q) {
            synchronized (this) {
                while (!this.q) {
                    this.wait(timeUnit.toMillis(duration));
                }
            }
        }
        if (this.j) {
            throw new InterruptedException();
        }
        return this.q ? this.g : null;
    }
    
    static void q(final E670 e670) {
        synchronized (e670) {
            if (e670.j) {
                return;
            }
            e670.d = true;
        }
        e670.g.g();
        synchronized (e670) {
            e670.q = true;
            e670.notifyAll();
        }
    }
    
    public E670(final S671 g) {
        this.d = false;
        this.q = false;
        this.j = false;
        this.g = g;
    }
    
    @Override
    public boolean cancel(final boolean b) {
        synchronized (this) {
            if (this.q) {
                return false;
            }
            if (b && this.d) {
                return false;
            }
            final boolean b2 = true;
            this.j = b2;
            this.q = b2;
            this.notifyAll();
        }
        return true;
    }
}
