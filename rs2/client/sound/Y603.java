package rs2.client.sound;

import fmod.X243;

public class Y603 {
   static String d = null;
   static float e = 1.0F;
   static String g = null;
   static int h = 0;
   static String j = null;
   static X243 q = null;

   public static X243 g() {
      return q;
   }

   public static void q() {
      if (q != null) {
         X243.f(q);
         q = null;
      }

      d = null;
      g = null;
   }

   public static void d(String var0, String var1) {
      if (!var0.equalsIgnoreCase(g) && !var0.equalsIgnoreCase(d)) {
         if (var0.equals("")) {
            g = null;
            d = null;
            q();
         } else {
            d = var0;
            j = var1;
            if (SoundManager.al.containsValue(var0)) {
               d = var0;
               I684 var2 = new I684();
               String[] var3 = SoundManager.c.r(d, 4).aq();
               if (var3 != null) {
                  h = var3.length;
                  String[] var4 = var3;
                  int var5 = var3.length;

                  for(int var6 = 0; var6 < var5; ++var6) {
                     String var7 = var4[var6];
                     G593.g(var7, 100000L, true, var2, (Object)null);
                  }
               } else {
                  d = null;
               }
            } else if (q != null) {
               X243.f(q);
            }

         }
      }
   }
}
