/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ao128;
import tfu.Fo439;
import tfu.Hm417;
import tfu.Hp62;
import tfu.Hz419;
import tfu.Ii435;
import tfu.Il434;
import tfu.Lb33;

class In418 {
    static final boolean d = false;
    private static final Logger logger = LoggerFactory.getLogger(In418.class);
    private volatile ConcurrentLinkedQueue b = null;
    private final ReferenceQueue e;
    private AtomicInteger h;
    private final Fo439 j;
    private final ConcurrentHashMap q = new ConcurrentHashMap();
    private volatile Thread s = null;

    void g() {
        Lb33.g(Lb33.ReleaseResources);
        try {
            Hp62 hp62;
            if (this.s == null) {
                this.s = Thread.currentThread();
                this.b = new ConcurrentLinkedQueue();
            }
            if (Thread.currentThread() != this.s) {
                throw new IllegalStateException("Called from thread " + Thread.currentThread() + " instead of " + this.s);
            }
            while ((hp62 = (Hp62)this.b.poll()) != null) {
                try {
                    hp62.onAllRefsReleased();
                }
                catch (Exception exception) {
                    logger.error("", exception);
                }
            }
            Lb33.d(Lb33.ReleaseResources);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.ReleaseResources);
            throw throwable;
        }
    }

    private static void d(In418 in418, Ii435 ii435, Ao128 ao128, String string) {
        ++ii435.j;
    }

    private static void q(In418 in418, Il434 il434, Ao128 ao128) {
        ++il434.q;
        in418.h.incrementAndGet();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    Hp62 j(Hm417 hm417, Ao128 ao128) throws ExecutionException {
        Object object;
        do {
            Object object2;
            In418.b(this);
            Object object3 = this.q.get(hm417);
            if (object3 == null) {
                object = new Ii435();
                In418.d(this, (Ii435)object, ao128, "Initial");
                object3 = this.q.putIfAbsent(hm417, object);
                if (object3 == null) {
                    return null;
                }
            }
            if (object3 instanceof Ii435) {
                object2 = object = (Ii435)object3;
                synchronized (object2) {
                    if (((Ii435)object).d != null) {
                        continue;
                    }
                    if (((Ii435)object).q != null) {
                        throw new ExecutionException("Another thread failed to load this resource", ((Ii435)object).q);
                    }
                    break;
                }
            }
            object = (Il434)object3;
            object2 = (Hp62)((Reference)object).get();
            if (object2 == null) {
                this.l((Il434)object);
                continue;
            }
            if (!((Il434)object).d.resourceNeedsRefCounting()) return object2;
            Object object4 = object;
            synchronized (object4) {
                if (!((Il434)object).j) {
                    In418.q(this, (Il434)object, ao128);
                    return object2;
                }
                this.q.remove(hm417, object3);
            }
        } while (true);
        {
            In418.d(this, (Ii435)object, ao128, "Extra");
            do {
                try {
                    object.wait();
                }
                catch (InterruptedException interruptedException) {
                    logger.error("", interruptedException);
                }
                if (((Ii435)object).d == null) continue;
                return ((Ii435)object).d;
            } while (((Ii435)object).q == null);
            throw new ExecutionException("Another thread failed to load this resource", ((Ii435)object).q);
        }
    }

    private static void w(In418 in418, ArrayList arrayList, String string) {
        logger.error(string);
        logger.error("Please enable ResourceCache.debugRefCounting to see history of request locations.");
    }

    void h(Hm417 hm417, Throwable throwable) {
        In418.b(this);
        Object v = this.q.get(hm417);
        if (!(v instanceof Ii435)) {
            return;
        }
        Ii435 ii435 = (Ii435)v;
        if (ii435.g != Thread.currentThread()) {
            return;
        }
        boolean bl = this.q.remove(hm417, ii435);
        if (!bl) {
            throw new IllegalStateException("No other thread should have replaced an UnfinishedCacheEntry!");
        }
        if (throwable == null) {
            throwable = new NullPointerException();
        }
        Ii435 ii4352 = ii435;
        synchronized (ii4352) {
            ii435.q = throwable;
            ii435.notifyAll();
        }
    }

    void s(Hp62 hp62) {
        Il434 il434;
        Fo439 fo439 = this.j;
        synchronized (fo439) {
            il434 = (Il434)Fo439.d(this.j, hp62);
            if (il434 == null) {
                logger.error("Cannot release reference for resource " + hp62 + " - it may have been GC'd already (check for 'Did you forget' errors) or it may not be refcounted at all", new Throwable());
                return;
            }
            Il434 il4342 = il434;
            synchronized (il4342) {
                if (il434.q > 0) {
                    --il434.q;
                    this.h.decrementAndGet();
                } else {
                    In418.w(this, il434.e, "Error: refcounted resource was released too many times!");
                }
                if (il434.q == 0) {
                    il434.j = true;
                    Fo439.q(this.j, hp62);
                    this.q.remove(il434.g, il434);
                    In418.r(this, il434.e, "Resource fully released");
                }
            }
        }
        if (il434.q == 0) {
            if (this.b != null) {
                this.b.add(hp62);
            } else {
                try {
                    hp62.onAllRefsReleased();
                }
                catch (Exception exception) {
                    logger.error("", exception);
                }
            }
        }
    }

    void e(Hm417 hm417, Hp62 hp62, Hz419 hz419) {
        In418.b(this);
        Object v = this.q.get(hm417);
        Ii435 ii435 = (Ii435)v;
        if (ii435.g != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread!");
        }
        if (hp62 == null) {
            throw new NullPointerException();
        }
        Ii435 ii4352 = ii435;
        synchronized (ii4352) {
            Object object;
            Il434 il434 = new Il434(hp62, this.e, hm417, hz419);
            if (hz419.resourceNeedsRefCounting()) {
                il434.q = ii435.j;
                ii435.j = 0;
                this.h.addAndGet(il434.q);
                object = this.j;
                synchronized (object) {
                    this.j.g(hp62, il434);
                }
            } else {
                il434.softRef = new SoftReference<Hp62>(hp62);
            }
            object = this.q.put(hm417, il434);
            if (object != ii435) {
                throw new IllegalStateException("No other thread should have replaced an UnfinishedCacheEntry!");
            }
            ii435.d = hp62;
            ii435.notifyAll();
        }
    }

    private static void b(In418 in418) {
        Il434 il434;
        while ((il434 = (Il434)in418.e.poll()) != null) {
            in418.l(il434);
        }
    }

    private void l(Il434 il434) {
        if (il434.q > 0) {
            In418.w(this, il434.e, "Error: refcounted resource of type " + il434.g.d + " was garbage-collected while refCount=" + il434.q + "! Did you forget to call releaseReference()?");
            this.h.addAndGet(-il434.q);
        }
        this.q.remove(il434.g, il434);
    }

    private static void r(In418 in418, ArrayList arrayList, String string) {
        logger.trace(string);
        logger.trace("Please enable ResourceCache.debugRefCounting to see history of request locations.");
    }

    In418() {
        this.j = new Fo439();
        this.e = new ReferenceQueue();
        this.h = new AtomicInteger();
    }
}

