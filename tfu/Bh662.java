package tfu;

import com.jagex.js5.js5;

public class Bh662 implements Jj524 {
   private final String d;
   private final js5 g;

   public Jb525 d() {
      return Jb525.JS5_FILE;
   }

   public Bh662(js5 var1, String var2) {
      this.g = var1;
      this.d = var2;
   }

   public int g() {
      return js5.aq(this.g, this.d) ? 100 : 0;
   }
}
