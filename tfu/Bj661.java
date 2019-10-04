package tfu;

import com.jagex.js5.js5;

public class Bj661 implements Jj524 {
   private final String d;
   private final js5 g;

   public Jb525 d() {
      return Jb525.JS5_GROUP;
   }

   public Bj661(js5 var1, String var2) {
      this.g = var1;
      this.d = var2;
   }

   public int g() {
      return js5.ai(this.g, this.d) ? 100 : js5.al(this.g, this.d);
   }
}
