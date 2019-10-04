package tfu;

import rs2.client.client;

public class Bx652 implements Jj524 {
   private boolean d;
   private final String g;

   public int g() {
      if (this.d) {
         return 100;
      } else {
         int var1 = client.el.d(this.g);
         if (var1 >= 0 && var1 <= 100) {
            return var1;
         } else {
            this.d = true;
            return 100;
         }
      }
   }

   public static boolean w(Bx652 var0) {
      return var0.d;
   }

   public Jb525 d() {
      return Jb525.NATIVE_LIBRARY;
   }

   public Bx652(String var1) {
      this.g = var1;
   }
}
