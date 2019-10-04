package tfu;

import com.jagex.jnibindings.runetek6.StateEventManager;

public class J153 {
   protected static final int d = 4;
   protected static long e = 0L;
   protected static final int g = 2;
   protected static boolean h = true;
   protected static long j = 0L;
   protected static int q = 4096;

   protected static void j(Gg3 var0) {
      if (h) {
         int var1 = Gg3.aj(var0);
         var0.v -= 2;
         short var2 = Kc180.p(j);
         var2 = (short)(var2 + 2);
         byte[] var3 = new byte[var1];
         Gg3.bx(var0, var3, 0, var1);

         for(int var4 = 0; var4 < var1; ++var2) {
            Kc180.b(j + (long)var2, var3[var4]);
            ++var4;
         }

         Kc180.w(j, (short)(var2 - 2));
      }

   }

   public static void g() {
      if (h) {
         j = Kc180.g((long)q);
         e = Kc180.g((long)q);
         StateEventManager.initEventsBuffers(j, e, q);
      }

   }

   protected static boolean d() {
      return Kc180.p(e) > 0;
   }

   protected static int q(int var0, Q475 var1) {
      if (!h) {
         return 0;
      } else {
         short var2 = Kc180.p(e);
         if (var2 <= var0) {
            return 0;
         } else {
            short var3 = Kc180.p(e + (long)var0);
            int var4 = Kc180.x(e + (long)var0 + 2L);
            if (var4 != 0) {
               var1.g = Bb4.s(var4);
            } else {
               var1.g = null;
            }

            int var5 = var3 + 2;
            var1.d = new Gg3(var5);
            Gg3.i(var1.d, var3);
            byte[] var6 = new byte[var3];

            for(int var7 = 0; var7 < var3; ++var7) {
               var6[var7] = Kc180.y(e + (long)var0 + (long)var7);
            }

            Gg3.aa(var1.d, var6, 0, var3);
            return var0 + var3;
         }
      }
   }
}
