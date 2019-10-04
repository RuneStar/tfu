// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.slf4j.Logger;

class In418
{
    static final boolean d = false;
    private static final Logger logger;
    private volatile ConcurrentLinkedQueue b;
    private final ReferenceQueue e;
    private AtomicInteger h;
    private final Fo439 j;
    private final ConcurrentHashMap q;
    private volatile Thread s;
    
    void g() {
        Lb33.g(Lb33.ReleaseResources);
        try {
            if (this.s == null) {
                this.s = Thread.currentThread();
                this.b = new ConcurrentLinkedQueue();
            }
            if (Thread.currentThread() != this.s) {
                throw new IllegalStateException("Called from thread " + Thread.currentThread() + " instead of " + this.s);
            }
            while (true) {
                final Hp62 hp62 = this.b.poll();
                if (hp62 == null) {
                    break;
                }
                try {
                    hp62.onAllRefsReleased();
                }
                catch (Exception ex) {
                    In418.logger.error("", ex);
                }
            }
        }
        finally {
            Lb33.d(Lb33.ReleaseResources);
        }
    }
    
    private static void d(final In418 in418, final Ii435 ii435, final Ao128 ao128, final String s) {
        ++ii435.j;
    }
    
    private static void q(final In418 in418, final Il434 il434, final Ao128 ao128) {
        ++il434.q;
        in418.h.incrementAndGet();
    }
    
    Hp62 j(final Hm417 key, final Ao128 ao128) throws ExecutionException {
        Hp62 hp62;
        while (true) {
            b(this);
            Object value = this.q.get(key);
            if (value == null) {
                final Ii435 value2 = new Ii435();
                d(this, value2, ao128, "Initial");
                value = this.q.putIfAbsent(key, value2);
                if (value == null) {
                    return null;
                }
            }
            if (value instanceof Ii435) {
                final Ii435 ii435 = (Ii435)value;
                synchronized (ii435) {
                    if (ii435.d != null) {
                        continue;
                    }
                    if (ii435.q != null) {
                        throw new ExecutionException("Another thread failed to load this resource", ii435.q);
                    }
                    d(this, ii435, ao128, "Extra");
                    while (true) {
                        try {
                            ii435.wait();
                        }
                        catch (InterruptedException ex) {
                            In418.logger.error("", ex);
                        }
                        if (ii435.d != null) {
                            return ii435.d;
                        }
                        if (ii435.q != null) {
                            throw new ExecutionException("Another thread failed to load this resource", ii435.q);
                        }
                    }
                }
            }
            final Il434 il434 = (Il434)value;
            hp62 = il434.get();
            if (hp62 == null) {
                this.l(il434);
            }
            else {
                if (il434.d.resourceNeedsRefCounting()) {
                    synchronized (il434) {
                        if (il434.j) {
                            this.q.remove(key, value);
                            continue;
                        }
                        q(this, il434, ao128);
                    }
                    break;
                }
                break;
            }
        }
        return hp62;
    }
    
    private static void w(final In418 in418, final ArrayList list, final String s) {
        In418.logger.error(s);
        In418.logger.error("Please enable ResourceCache.debugRefCounting to see history of request locations.");
    }
    
    void h(final Hm417 hm417, Throwable q) {
        b(this);
        final Ii435 value = this.q.get(hm417);
        if (!(value instanceof Ii435)) {
            return;
        }
        final Ii435 value2 = value;
        if (value2.g != Thread.currentThread()) {
            return;
        }
        if (!this.q.remove(hm417, value2)) {
            throw new IllegalStateException("No other thread should have replaced an UnfinishedCacheEntry!");
        }
        if (q == null) {
            q = new NullPointerException();
        }
        synchronized (value2) {
            value2.q = q;
            value2.notifyAll();
        }
    }
    
    void s(final Hp62 hp62) {
        final Il434 value;
        synchronized (this.j) {
            value = (Il434)Fo439.d(this.j, hp62);
            if (value == null) {
                In418.logger.error("Cannot release reference for resource " + hp62 + " - it may have been GC'd already (check for 'Did you forget' errors) or it may not be refcounted at all", new Throwable());
                return;
            }
            synchronized (value) {
                if (value.q > 0) {
                    --value.q;
                    this.h.decrementAndGet();
                }
                else {
                    w(this, value.e, "Error: refcounted resource was released too many times!");
                }
                if (value.q == 0) {
                    value.j = true;
                    Fo439.q(this.j, hp62);
                    this.q.remove(value.g, value);
                    r(this, value.e, "Resource fully released");
                }
            }
        }
        if (value.q == 0) {
            if (this.b != null) {
                this.b.add(hp62);
            }
            else {
                try {
                    hp62.onAllRefsReleased();
                }
                catch (Exception ex) {
                    In418.logger.error("", ex);
                }
            }
        }
    }
    
    void e(final Hm417 hm417, final Hp62 hp62, final Hz419 hz419) {
        b(this);
        final Ii435 ii435 = this.q.get(hm417);
        if (ii435.g != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread!");
        }
        if (hp62 == null) {
            throw new NullPointerException();
        }
        synchronized (ii435) {
            final Il434 value = new Il434(hp62, this.e, hm417, hz419);
            if (hz419.resourceNeedsRefCounting()) {
                value.q = ii435.j;
                ii435.j = 0;
                this.h.addAndGet(value.q);
                synchronized (this.j) {
                    this.j.g(hp62, value);
                }
            }
            else {
                value.softRef = new SoftReference((T)hp62);
            }
            if (this.q.put(hm417, value) != ii435) {
                throw new IllegalStateException("No other thread should have replaced an UnfinishedCacheEntry!");
            }
            ii435.d = hp62;
            ii435.notifyAll();
        }
    }
    
    private static void b(final In418 in418) {
        while (true) {
            final Il434 il434 = (Il434)in418.e.poll();
            if (il434 == null) {
                break;
            }
            in418.l(il434);
        }
    }
    
    private void l(final Il434 value) {
        if (value.q > 0) {
            w(this, value.e, "Error: refcounted resource of type " + value.g.d + " was garbage-collected while refCount=" + value.q + "! Did you forget to call releaseReference()?");
            this.h.addAndGet(-value.q);
        }
        this.q.remove(value.g, value);
    }
    
    static {
        logger = LoggerFactory.getLogger(In418.class);
    }
    
    private static void r(final In418 in418, final ArrayList list, final String s) {
        In418.logger.trace(s);
        In418.logger.trace("Please enable ResourceCache.debugRefCounting to see history of request locations.");
    }
    
    In418() {
        this.q = new ConcurrentHashMap();
        this.j = new Fo439();
        this.e = new ReferenceQueue();
        this.h = new AtomicInteger();
        this.s = null;
        this.b = null;
    }
}
