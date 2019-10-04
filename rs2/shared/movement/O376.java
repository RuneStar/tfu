package rs2.shared.movement;

import java.util.Arrays;

public class O376 {
   public final Object[] d;
   public final String g;

   public boolean equals(Object var1) {
      if (!(var1 instanceof O376)) {
         return false;
      } else {
         O376 var2 = (O376)var1;
         if (!this.g.equals(var2.g)) {
            return false;
         } else {
            return Arrays.equals(this.d, var2.d);
         }
      }
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.g + "(");
      boolean var2 = true;
      Object[] var3 = this.d;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Object var6 = var3[var5];
         if (var2) {
            var2 = false;
         } else {
            var1.append(",");
         }

         var1.append(var6);
      }

      var1.append(")");
      return var1.toString();
   }

   public O376(String var1, Object[] var2) {
      this.g = var1;
      this.d = var2;
   }
}
