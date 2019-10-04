package tfu;

import java.util.Iterator;

public class Hv415 implements Iterator {
   private Ln265 d;
   private Ha262 g;
   private Ln265 j = null;
   private int q;

   public static Ln265 j(Hv415 var0) {
      Ln265 var1;
      if (var0.d != var0.g.d[var0.q - 1]) {
         var1 = var0.d;
         var0.d = var1.bo;
         var0.j = var1;
         return var1;
      } else {
         do {
            if (var0.q >= var0.g.g) {
               return null;
            }

            var1 = var0.g.d[var0.q++].bo;
         } while(var1 == var0.g.d[var0.q - 1]);

         var0.d = var1.bo;
         var0.j = var1;
         return var1;
      }
   }

   public boolean hasNext() {
      if (this.d != this.g.d[this.q - 1]) {
         return true;
      } else {
         while(this.q < this.g.g) {
            if (this.g.d[this.q++].bo != this.g.d[this.q - 1]) {
               this.d = this.g.d[this.q - 1].bo;
               return true;
            }

            this.d = this.g.d[this.q - 1];
         }

         return false;
      }
   }

   public Hv415(Ha262 var1) {
      this.g = var1;
      g(this);
   }

   public static void g(Hv415 var0) {
      var0.d = var0.g.d[0].bo;
      var0.q = 1;
      var0.j = null;
   }

   public void remove() {
      if (this.j == null) {
         throw new IllegalStateException();
      } else {
         Ln265.ef(this.j);
         this.j = null;
      }
   }
}
