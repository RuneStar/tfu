package tfu;

import java.util.Iterator;

public class Hr428 implements Iterator {
   private Kp349 d;
   private Hn359 g;
   private Kp349 q = null;

   public boolean hasNext() {
      return this.d != this.g.g;
   }

   public static Kp349 g(Hr428 var0) {
      Kp349 var1 = var0.d;
      if (var1 == var0.g.g) {
         var1 = null;
         var0.d = null;
      } else {
         var0.d = var1.x;
      }

      var0.q = var1;
      return var1;
   }

   public void remove() {
      if (this.q == null) {
         throw new IllegalStateException();
      } else {
         Kp349.t(this.q);
         this.q = null;
      }
   }

   public Hr428(Hn359 var1) {
      this.g = var1;
      this.d = this.g.g.x;
      this.q = null;
   }
}
