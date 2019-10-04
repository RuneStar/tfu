package tfu;

import com.jagex.core.stringtools.general.J173;

public class Af155 {
   static Al154 d;
   private static final boolean g = false;

   public static void g(Al154 var0) {
      d = var0;
   }

   public static String q(Gg3 var0) {
      return j(var0, 32767);
   }

   public static int d(Gg3 var0, String var1) {
      int var2 = var0.v;
      byte[] var3 = J173.j(var1);
      var0.at(var3.length);
      var0.v += d.d(var3, 0, var3.length, var0.r, var0.v);
      return var0.v - var2;
   }

   public static String j(Gg3 var0, int var1) {
      try {
         int var2 = Gg3.br(var0);
         if (var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.v += Al154.q(d, var0.r, var0.v, var3, 0, var2);
         String var4 = J173.s(var3, 0, var2);
         return var4;
      } catch (Exception var5) {
         return "Cabbage";
      }
   }
}
