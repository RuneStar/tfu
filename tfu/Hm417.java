package tfu;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Hm417 {
   final Class d;
   private final int g;
   private final Set q = new HashSet();

   public int hashCode() {
      return this.g;
   }

   Hm417(Class var1, Object[] var2) {
      this.d = var1;
      Collections.addAll(this.q, var2);
      int var3 = this.d.hashCode();
      Object[] var4 = var2;
      int var5 = var2.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Object var7 = var4[var6];
         var3 ^= var7.hashCode();
      }

      this.g = var3;
   }

   public boolean equals(Object var1) {
      Hm417 var2 = (Hm417)var1;
      return this.d.equals(var2.d) && this.q.equals(var2.q);
   }

   Hm417(Class var1, Object var2) {
      this.d = var1;
      this.q.add(var2);
      this.g = this.d.hashCode() ^ var2.hashCode();
   }
}
