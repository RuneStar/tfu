package tfu;

import com.jagex.js5.js5;

public class Gv486 implements Ip424 {
   private final js5 g;

   public Gv486(js5 var1) {
      this.g = var1;
      if (!js5.i(this.g)) {
         throw new IllegalArgumentException();
      }
   }

   public static int g(Gv486 var0, String var1) {
      return var0.g.getgroupid(var1);
   }
}
