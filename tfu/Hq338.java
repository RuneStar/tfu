package tfu;

import java.awt.Frame;

public final class Hq338 {
   public static boolean g = true;

   public static Hd425[] g(Hw321 var0) {
      int[] var1 = Hw321.g(var0);
      Hd425[] var2 = new Hd425[var1.length >> 2];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Hd425 var4 = new Hd425();
         var2[var3] = var4;
         var4.g = var1[var3 << 2];
         var4.d = var1[(var3 << 2) + 1];
         var4.q = var1[(var3 << 2) + 2];
         var4.j = var1[(var3 << 2) + 3];
      }

      return var2;
   }

   public static Frame d(Hw321 var0, int var1, int var2, int var3, int var4) {
      if (var3 == 0) {
         Hd425[] var5 = g(var0);
         if (var5 == null) {
            return null;
         }

         boolean var6 = false;

         for(int var7 = 0; var7 < var5.length; ++var7) {
            if (var5[var7].g == var1 && var5[var7].d == var2 && (var4 == 0 || var4 == var5[var7].j) && (!var6 || var5[var7].q > var3)) {
               var3 = var5[var7].q;
               var6 = true;
            }
         }

         if (!var6) {
            return null;
         }
      }

      Frame var8 = new Frame("Jagex Full Screen");
      var8.setResizable(false);
      var0.d(var8, var1, var2, var3, var4);
      return var8;
   }

   private Hq338() {
   }

   public static void q(Hw321 var0, Frame var1) {
      Hw321.q(var0);
      var1.setVisible(false);
      var1.dispose();
   }
}
