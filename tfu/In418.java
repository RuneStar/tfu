package tfu;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class In418 {
   static final boolean d = false;
   private static final Logger logger = LoggerFactory.getLogger(In418.class);
   private volatile ConcurrentLinkedQueue b = null;
   private final ReferenceQueue e = new ReferenceQueue();
   private AtomicInteger h = new AtomicInteger();
   private final Fo439 j = new Fo439();
   private final ConcurrentHashMap q = new ConcurrentHashMap();
   private volatile Thread s = null;

   void g() {
      Lb33.g(Lb33.ReleaseResources);

      try {
         if (this.s == null) {
            this.s = Thread.currentThread();
            this.b = new ConcurrentLinkedQueue();
         }

         if (Thread.currentThread() != this.s) {
            throw new IllegalStateException("Called from thread " + Thread.currentThread() + " instead of " + this.s);
         } else {
            while(true) {
               Hp62 var1 = (Hp62)this.b.poll();
               if (var1 == null) {
                  Lb33.d(Lb33.ReleaseResources);
                  return;
               }

               try {
                  var1.onAllRefsReleased();
               } catch (Exception var6) {
                  logger.error("", var6);
               }
            }
         }
      } finally {
         Lb33.d(Lb33.ReleaseResources);
      }
   }

   private static void d(In418 var0, Ii435 var1, Ao128 var2, String var3) {
      ++var1.j;
   }

   private static void q(In418 var0, Il434 var1, Ao128 var2) {
      ++var1.q;
      var0.h.incrementAndGet();
   }

   Hp62 j(Hm417 var1, Ao128 var2) throws ExecutionException {
      while(true) {
         b(this);
         Object var3 = this.q.get(var1);
         Ii435 var4;
         if (var3 == null) {
            var4 = new Ii435();
            d(this, var4, var2, "Initial");
            var3 = this.q.putIfAbsent(var1, var4);
            if (var3 == null) {
               return null;
            }
         }

         if (var3 instanceof Ii435) {
            var4 = (Ii435)var3;
            synchronized(var4) {
               if (var4.d == null) {
                  if (var4.q != null) {
                     throw new ExecutionException("Another thread failed to load this resource", var4.q);
                  }

                  d(this, var4, var2, "Extra");

                  do {
                     try {
                        var4.wait();
                     } catch (InterruptedException var9) {
                        logger.error("", var9);
                     }

                     if (var4.d != null) {
                        return var4.d;
                     }
                  } while(var4.q == null);

                  throw new ExecutionException("Another thread failed to load this resource", var4.q);
               }
            }
         } else {
            Il434 var12 = (Il434)var3;
            Hp62 var5 = (Hp62)var12.get();
            if (var5 == null) {
               this.l(var12);
            } else {
               if (var12.d.resourceNeedsRefCounting()) {
                  synchronized(var12) {
                     if (var12.j) {
                        this.q.remove(var1, var3);
                        continue;
                     }

                     q(this, var12, var2);
                  }
               }

               return var5;
            }
         }
      }
   }

   private static void w(In418 var0, ArrayList var1, String var2) {
      logger.error(var2);
      logger.error("Please enable ResourceCache.debugRefCounting to see history of request locations.");
   }

   void h(Hm417 var1, Throwable var2) {
      b(this);
      Object var3 = this.q.get(var1);
      if (var3 instanceof Ii435) {
         Ii435 var4 = (Ii435)var3;
         if (var4.g == Thread.currentThread()) {
            boolean var5 = this.q.remove(var1, var4);
            if (!var5) {
               throw new IllegalStateException("No other thread should have replaced an UnfinishedCacheEntry!");
            } else {
               if (var2 == null) {
                  var2 = new NullPointerException();
               }

               synchronized(var4) {
                  var4.q = (Throwable)var2;
                  var4.notifyAll();
               }
            }
         }
      }
   }

   void s(Hp62 var1) {
      Fo439 var3 = this.j;
      Il434 var2;
      synchronized(var3) {
         var2 = (Il434)Fo439.d(this.j, var1);
         if (var2 == null) {
            logger.error("Cannot release reference for resource " + var1 + " - it may have been GC'd already (check for 'Did you forget' errors) or it may not be refcounted at all", new Throwable());
            return;
         }

         synchronized(var2) {
            if (var2.q > 0) {
               --var2.q;
               this.h.decrementAndGet();
            } else {
               w(this, var2.e, "Error: refcounted resource was released too many times!");
            }

            if (var2.q == 0) {
               var2.j = true;
               Fo439.q(this.j, var1);
               this.q.remove(var2.g, var2);
               r(this, var2.e, "Resource fully released");
            }
         }
      }

      if (var2.q == 0) {
         if (this.b != null) {
            this.b.add(var1);
         } else {
            try {
               var1.onAllRefsReleased();
            } catch (Exception var7) {
               logger.error("", var7);
            }
         }
      }

   }

   void e(Hm417 var1, Hp62 var2, Hz419 var3) {
      b(this);
      Object var4 = this.q.get(var1);
      Ii435 var5 = (Ii435)var4;
      if (var5.g != Thread.currentThread()) {
         throw new IllegalStateException("Wrong thread!");
      } else if (var2 == null) {
         throw new NullPointerException();
      } else {
         synchronized(var5) {
            Il434 var7 = new Il434(var2, this.e, var1, var3);
            if (var3.resourceNeedsRefCounting()) {
               var7.q = var5.j;
               var5.j = 0;
               this.h.addAndGet(var7.q);
               Fo439 var8 = this.j;
               synchronized(var8) {
                  this.j.g(var2, var7);
               }
            } else {
               var7.softRef = new SoftReference(var2);
            }

            Object var13 = this.q.put(var1, var7);
            if (var13 != var5) {
               throw new IllegalStateException("No other thread should have replaced an UnfinishedCacheEntry!");
            } else {
               var5.d = var2;
               var5.notifyAll();
            }
         }
      }
   }

   private static void b(In418 var0) {
      while(true) {
         Il434 var1 = (Il434)var0.e.poll();
         if (var1 == null) {
            return;
         }

         var0.l(var1);
      }
   }

   private void l(Il434 var1) {
      if (var1.q > 0) {
         w(this, var1.e, "Error: refcounted resource of type " + var1.g.d + " was garbage-collected while refCount=" + var1.q + "! Did you forget to call releaseReference()?");
         this.h.addAndGet(-var1.q);
      }

      this.q.remove(var1.g, var1);
   }

   private static void r(In418 var0, ArrayList var1, String var2) {
      logger.trace(var2);
      logger.trace("Please enable ResourceCache.debugRefCounting to see history of request locations.");
   }
}
