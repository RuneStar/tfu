package tfu;

public class Ag543 implements Comparable {
   public final int d;
   public final int g;
   public final int q;

   public Ag543(Ag543 var1) {
      this.g = var1.g;
      this.d = var1.d;
      this.q = var1.q;
   }

   public Ag543(int var1, int var2, int var3) {
      this.g = var1;
      this.d = var2;
      this.q = var3;
   }

   public boolean equals(Object var1) {
      if (!(var1 instanceof Ag543)) {
         return false;
      } else {
         return g(this, (Ag543)var1) == 0;
      }
   }

   public int hashCode() {
      return this.g + this.d + this.q;
   }

   public static int g(Ag543 var0, Ag543 var1) {
      float var2 = (float)(var0.g - var1.g);
      if (var2 != 0.0F) {
         return var2 > 0.0F ? 1 : -1;
      } else {
         var2 = (float)(var0.d - var1.d);
         if (var2 != 0.0F) {
            return var2 > 0.0F ? 1 : -1;
         } else {
            var2 = (float)(var0.q - var1.q);
            if (var2 != 0.0F) {
               return var2 > 0.0F ? 1 : -1;
            } else {
               return 0;
            }
         }
      }
   }
}
