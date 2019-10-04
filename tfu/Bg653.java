package tfu;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class Bg653 extends FutureTask implements Comparable {
   final Br121 d;
   final Bn279 g;
   int j;
   final int q;

   Bg653(Callable var1, Bn279 var2, Br121 var3, int var4) {
      super(var1);
      this.g = var2;
      this.d = var3;
      this.q = var4;
      q(this);
   }

   public static int x(Bg653 var0, Runnable var1) {
      Bg653 var2 = (Bg653)var1;
      if (var0.j > var2.j) {
         return -1;
      } else {
         return var0.j < var2.j ? 1 : var0.q - var2.q;
      }
   }

   static void q(Bg653 var0) {
      var0.j = var0.d.e();
   }
}
