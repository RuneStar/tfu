package tfu;

public class Js343 {
   public final Object d;
   public final Object q;

   public boolean equals(Object var1) {
      if (var1 != null && var1 instanceof Js343) {
         Js343 var2 = (Js343)var1;
         if (this.d == null) {
            if (var2.d != null) {
               return false;
            }
         } else if (!this.d.equals(var2.d)) {
            return false;
         }

         if (this.q == null) {
            if (var2.q != null) {
               return false;
            }
         } else if (!this.q.equals(var2.q)) {
            return false;
         }

         return true;
      } else {
         return false;
      }
   }

   public String toString() {
      return this.d + ", " + this.q;
   }

   public Js343(Object var1, Object var2) {
      this.d = var1;
      this.q = var2;
   }

   public int hashCode() {
      int var1 = 0;
      if (this.d != null) {
         var1 += this.d.hashCode();
      }

      if (this.q != null) {
         var1 += 31 * this.q.hashCode();
      }

      return var1;
   }
}
