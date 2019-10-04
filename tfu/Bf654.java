package tfu;

import java.util.concurrent.Callable;

class Bf654 implements Callable {
   // $FF: synthetic field
   final Br121 d;
   // $FF: synthetic field
   final Bn279 g;
   // $FF: synthetic field
   final Bu350 j;
   // $FF: synthetic field
   final Bv351 q;

   public Object call() throws Exception {
      if (g(this, By651.UNSTARTED, (Object)null)) {
         return null;
      } else if (!this.g.b.compareAndSet(By651.UNSTARTED, By651.RUNNING)) {
         d(this, (Object)null);
         return null;
      } else {
         Object var1 = null;

         try {
            var1 = this.d.s();
            if (!this.g.b.compareAndSet(By651.RUNNING, By651.FINISHED)) {
               d(this, var1);
               return null;
            } else {
               if (this.q != null) {
                  this.q.q.add(this.g);
                  if (g(this, By651.FINISHED, var1)) {
                     return null;
                  }
               }

               return var1;
            }
         } finally {
            if (!this.g.b.compareAndSet(By651.RUNNING, By651.FINISHED)) {
               d(this, var1);
               return null;
            } else {
               if (this.q != null) {
                  this.q.q.add(this.g);
                  if (g(this, By651.FINISHED, var1)) {
                     return null;
                  }
               }

            }
         }
      }
   }

   private static boolean g(Bf654 var0, By651 var1, Object var2) {
      if (var0.q != null && var0.q.j) {
         if (var0.g.b.compareAndSet(var1, By651.CANCELLED)) {
            d(var0, var2);
         }

         return true;
      } else {
         return false;
      }
   }

   private static void d(Bf654 var0, Object var1) {
      try {
         var0.d.h(var1);
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }

   Bf654(Bu350 var1, Bn279 var2, Br121 var3, Bv351 var4) {
      this.g = var2;
      this.d = var3;
      this.q = var4;
      this.j = var1;
   }
}
