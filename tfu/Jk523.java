package tfu;

public class Jk523 {
   public Object d;
   public Object g;

   public String toString() {
      return this.g + ", " + this.d;
   }

   public boolean equals(Object var1) {
      if (var1 != null && var1 instanceof Jk523) {
         Jk523 var2 = (Jk523)var1;
         if (this.g == null) {
            if (var2.g != null) {
               return false;
            }
         } else if (!this.g.equals(var2.g)) {
            return false;
         }

         if (this.d == null) {
            if (var2.d != null) {
               return false;
            }
         } else if (!this.d.equals(var2.d)) {
            return false;
         }

         return true;
      } else {
         return false;
      }
   }

   public int hashCode() {
      int var1 = 0;
      if (this.g != null) {
         var1 += this.g.hashCode();
      }

      if (this.d != null) {
         var1 += 31 * this.d.hashCode();
      }

      return var1;
   }

   public Jk523(Object var1, Object var2) {
      this.g = var1;
      this.d = var2;
   }
}
