package tfu;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

public final class Bn279 {
   static final boolean g = false;
   AtomicReference b;
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
         j(this);
      }

   }

   Bn279(Br121 var1, Object var2) {
      this.b = new AtomicReference(By651.UNSTARTED);
      this.q = var1;
      this.j = var2;
   }

   public Object d() throws ExecutionException {
      if (this.e != null) {
         this.q();
         this.q = null;
      }

      if (this.b.get() == By651.CANCELLED) {
         throw new IllegalStateException("Task has been cancelled!");
      } else if (this.s != null) {
         throw this.s;
      } else {
         return this.h;
      }
   }

   private void q() {
      try {
         this.h = this.e.get();
         this.e = null;
      } catch (InterruptedException var2) {
         throw new IllegalStateException(var2);
      } catch (ExecutionException var3) {
         this.s = var3;
         this.e = null;
      }

   }

   public static void j(Bn279 var0) {
      By651 var1 = (By651)var0.b.getAndSet(By651.CANCELLED);
      if (var1 == By651.FINISHED) {
         if (var0.e == null) {
            return;
         }

         var0.q();

         try {
            var0.q.h(var0.h);
         } catch (Exception var3) {
            var3.printStackTrace();
         }
      }

      var0.q = null;
   }

   public static boolean g(Bn279 var0) {
      return var0.e == null || var0.e.isDone();
   }
}
