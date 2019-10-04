package tfu;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class E670 implements Future {
   private volatile boolean d = false;
   private final S671 g;
   private volatile boolean j = false;
   private volatile boolean q = false;

   public boolean isDone() {
      return this.q;
   }

   public boolean isCancelled() {
      return this.j;
   }

   public S671 g() throws InterruptedException, ExecutionException {
      if (!this.q) {
         synchronized(this) {
            while(!this.q) {
               this.wait();
            }
         }
      }

      if (this.j) {
         throw new InterruptedException();
      } else {
         return this.g;
      }
   }

   public S671 d(long var1, TimeUnit var3) throws InterruptedException, ExecutionException, TimeoutException {
      if (!this.q) {
         synchronized(this) {
            while(!this.q) {
               this.wait(var3.toMillis(var1));
            }
         }
      }

      if (this.j) {
         throw new InterruptedException();
      } else {
         return this.q ? this.g : null;
      }
   }

   static void q(E670 var0) {
      synchronized(var0) {
         if (var0.j) {
            return;
         }

         var0.d = true;
      }

      var0.g.g();
      synchronized(var0) {
         var0.q = true;
         var0.notifyAll();
      }
   }

   public E670(S671 var1) {
      this.g = var1;
   }

   public boolean cancel(boolean var1) {
      synchronized(this) {
         if (this.q) {
            return false;
         } else if (var1 && this.d) {
            return false;
         } else {
            this.q = this.j = true;
            this.notifyAll();
            return true;
         }
      }
   }
}
