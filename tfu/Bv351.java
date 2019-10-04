package tfu;

import java.util.concurrent.ConcurrentLinkedQueue;

public final class Bv351 {
   boolean d;
   private final Ao128 g = new Ao128("Instantiated here");
   volatile boolean j;
   ConcurrentLinkedQueue q = new ConcurrentLinkedQueue();

   public Bn279 g() {
      if (this.j) {
         throw new IllegalStateException();
      } else {
         Bn279 var1;
         do {
            var1 = (Bn279)this.q.poll();
            if (var1 == null) {
               return null;
            }
         } while(var1.b.get() != By651.FINISHED);

         return var1;
      }
   }

   public static void d(Bv351 var0) {
      var0.j = true;

      while(true) {
         Bn279 var1 = (Bn279)var0.q.poll();
         if (var1 == null) {
            return;
         }

         Bn279.j(var1);
      }
   }

   protected void finalize() {
      if (this.d && !this.j) {
         System.err.println("----------------------------------------------------------------------------");
         System.err.println("Warning: TaskFinishNotifyQueue garbage-collected without cancelAllUnpolled()");
         this.g.printStackTrace();
         System.err.println("----------------------------------------------------------------------------");
         d(this);
      }

   }
}
