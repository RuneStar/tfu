package tfu;

import java.util.Iterator;

public class Gr482 implements Iterator {
   private Ln265 d;
   private Gx298 g;
   private Ln265 q = null;

   public static Ln265 g(Gr482 var0) {
      Ln265 var1 = var0.d;
      if (var1 == var0.g.g) {
         var1 = null;
         var0.d = null;
      } else {
         var0.d = var1.bo;
      }

      var0.q = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.d != this.g.g;
   }

   public void remove() {
      if (this.q == null) {
         throw new IllegalStateException();
      } else {
         Ln265.ef(this.q);
         this.q = null;
      }
   }

   public Gr482(Gx298 var1) {
      this.g = var1;
      this.d = this.g.g.bo;
      this.q = null;
   }
}
