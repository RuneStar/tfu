package tfu;

import com.jagex.jnibindings.runetek6.Pick;
import com.jagex.maths.Vector3;
import java.security.InvalidParameterException;
import java.util.List;

public final class Fi371 {
   private static long d = 0L;
   private static long g = 0L;
   public static final int j = 100;
   private static long q = 0L;

   public static void d(int var0, int var1, int var2, List var3) {
      if (var2 > 100) {
         throw new InvalidParameterException("maximum number of requested picked results must be <= 100");
      } else {
         long var4 = 4L;
         q = (long)Kc180.e();
         d = q + 16L;
         if (g == 0L) {
            g = Kc180.g(100L * d);
         }

         Object var7 = H149.v;
         int var6;
         synchronized(var7) {
            var6 = Pick.pickXY(var0, var1, g, var2, (long[])null);
         }

         long var12 = g;

         for(int var9 = 0; var9 < var6; ++var9) {
            Fn87 var10 = new Fn87();
            var12 += g(var12, var10);
            var3.add(var10);
         }

      }
   }

   private static long g(long var0, Fn87 var2) {
      long var3 = Kc180.h(var0);
      var0 += q;
      float var6 = Kc180.u(var0);
      var0 += 4L;
      float var7 = Kc180.u(var0);
      var0 += 4L;
      float var8 = Kc180.u(var0);
      var0 += 4L;
      float var5 = Kc180.u(var0);
      var0 += 4L;
      var2.g = var3;
      var2.d = new Vector3(var6, var7, var8);
      var2.q = var5;
      return d;
   }
}
