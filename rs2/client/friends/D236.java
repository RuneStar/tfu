package rs2.client.friends;

import rs2.client.client;
import tfu.Le231;
import tfu.Md230;

public final class D236 {
   private final E235[] d;
   public int g = 0;

   public static E235 d(D236 var0, int var1) {
      return var1 >= 0 && var1 < var0.g ? var0.d[var1] : null;
   }

   public static boolean q(D236 var0) {
      return var0.g >= var0.d.length;
   }

   public D236(int var1) {
      this.d = new E235[var1];
   }

   public void g(boolean var1, String var2, String var3, String var4, String var5, boolean var6) {
      if (!var1) {
         E235 var8 = new E235();
         var8.g = var2;
         if (var3 == "") {
            var8.d = var2;
         } else {
            var8.d = var3;
         }

         var8.q = var4;
         if (var5 == "") {
            var8.j = var4;
         } else {
            var8.j = var5;
         }

         var8.e = var6;
         this.d[this.g++] = var8;
      } else {
         for(int var7 = 0; var7 < this.g; ++var7) {
            if (this.d[var7].d.equals(var5)) {
               this.d[var7].g = var2;
               if (var3 == "") {
                  this.d[var7].d = var2;
               } else {
                  this.d[var7].d = var3;
               }

               this.d[var7].q = var4;
               if (var5 == "") {
                  this.d[var7].j = var4;
               } else {
                  this.d[var7].j = var5;
               }
               break;
            }
         }

      }
   }

   public static boolean h(D236 var0, String var1) {
      if (var1 == null) {
         return false;
      } else {
         String var2 = Md230.j(var1);
         if (var2 == null) {
            return false;
         } else {
            for(int var3 = 0; var3 < var0.g; ++var3) {
               E235 var4 = var0.d[var3];
               if (Le231.g(var1, var2, var4.g, Md230.j(var4.g))) {
                  if (var0.g < var0.d.length) {
                     System.arraycopy(var0.d, var3 + 1, var0.d, var3, var0.g - var3);
                  }

                  --var0.g;
                  var0.d[var0.g] = null;
                  return true;
               }
            }

            return false;
         }
      }
   }

   public static void s(D236 var0) {
      var0.g = 0;
   }

   public static E235 j(D236 var0, String var1, boolean var2) {
      String var3 = Md230.e(var1, client.m.l);

      for(int var4 = 0; var4 < var0.g; ++var4) {
         if (Le231.g(var1, var3, var0.d[var4].d, Md230.e(var0.d[var4].d, client.m.l))) {
            return var0.d[var4];
         }

         if (var2 && var0.d[var4].j != null && Le231.g(var1, var3, var0.d[var4].j, Md230.e(var0.d[var4].j, client.m.l))) {
            return var0.d[var4];
         }
      }

      return null;
   }

   public static int e(D236 var0, String var1) {
      if (var1 != null) {
         for(int var2 = 0; var2 < var0.g; ++var2) {
            if (var1.equalsIgnoreCase(var0.d[var2].d)) {
               return var2;
            }

            if (var1.equalsIgnoreCase(var0.d[var2].j)) {
               return var2;
            }
         }
      }

      return -1;
   }
}
