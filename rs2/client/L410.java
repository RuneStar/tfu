package rs2.client;

import tfu.Gz143;
import tfu.Ha262;
import tfu.Hn359;
import tfu.Kp349;

public class L410 extends Kp349 {
   private static Hn359 b = new Hn359();
   public static final int e = 1;
   public static final int h = 2;
   private static Ha262 l = new Ha262(16);
   private static final long r = Long.MIN_VALUE;
   private static Hn359 s = new Hn359();
   private static final long v = 500L;
   private static final long w = Long.MAX_VALUE;
   int d;
   int g;
   String j;
   int q;

   public static void j(int var0, int var1) {
      L410 var2 = g(1, (long)var0);
      h(var2);
      var2.g = var1;
   }

   private L410(int var1, long var2) {
      super.bq = (long)var1 << 56 | var2;
   }

   public static L410 q() {
      L410 var0 = (L410)Hn359.h(s);
      if (var0 != null) {
         ef(var0);
         t(var0);
         return var0;
      } else {
         do {
            var0 = (L410)Hn359.h(b);
            if (var0 == null) {
               return null;
            }

            if (l(var0) > Gz143.g()) {
               return null;
            }

            ef(var0);
            t(var0);
         } while((var0.p & Long.MIN_VALUE) == 0L);

         return var0;
      }
   }

   public static void e(int var0, String var1) {
      L410 var2 = g(2, (long)var0);
      h(var2);
      var2.j = var1;
   }

   private static void h(L410 var0) {
      var0.p |= Long.MIN_VALUE;
      if (l(var0) == 0L) {
         Hn359.q(s, var0);
      }

   }

   public static int s(L410 var0) {
      return (int)(var0.bq >>> 56 & 255L);
   }

   public static long b(L410 var0) {
      return var0.bq & 72057594037927935L;
   }

   private static long l(L410 var0) {
      return var0.p & Long.MAX_VALUE;
   }

   private static L410 g(int var0, long var1) {
      L410 var3 = (L410)Ha262.d(l, (long)var0 << 56 | var1);
      if (var3 == null) {
         var3 = new L410(var0, var1);
         Ha262.q(l, var3, var3.bq);
      }

      return var3;
   }

   public static void d() {
      Ha262.j(l);
      Hn359.d(b);
      Hn359.d(s);
   }
}
