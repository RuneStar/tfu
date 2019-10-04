package tfu;

final class Av542 extends Js343 {
   // $FF: synthetic field
   final Ah536 g;

   public int hashCode() {
      int var1 = 0;
      if (super.d != null) {
         var1 += ((String)super.d).toLowerCase().hashCode();
      }

      if (super.q != null) {
         var1 += 31 * ((String)super.q).toLowerCase().hashCode();
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if (var1 != null && var1 instanceof Js343) {
         Av542 var2 = (Av542)var1;
         if (super.d == null) {
            if (var2.d != null) {
               return false;
            }
         } else if (!((String)super.d).equalsIgnoreCase((String)var2.d)) {
            return false;
         }

         if (super.q == null) {
            if (var2.q != null) {
               return false;
            }
         } else if (!((String)super.q).equalsIgnoreCase((String)var2.q)) {
            return false;
         }

         return true;
      } else {
         return false;
      }
   }

   public Av542(Ah536 var1, String var2, String var3) {
      super(var2, var3);
      this.g = var1;
   }
}
