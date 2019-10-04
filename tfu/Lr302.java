package tfu;

import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;

public class Lr302 {
   public static final int b = 8;
   public static final int d = 100000;
   public static final int e = 1;
   public static final int g = -1000;
   public static final int h = 2;
   public static final int j = 256;
   public static final int l = 16;
   public static int q = 2;
   public static final int s = 4;
   public static final int w = 32;

   public static float g(Quaternion var0) {
      Vector3 var1 = Vector3.g(0.0F, 0.0F, 1.0F);
      var1 = Vector3.al(var1, var0);
      double var2 = Math.atan2((double)var1.x, (double)var1.z);
      if (var2 < 0.0D) {
         var2 = 3.141592653589793D + 3.141592653589793D + var2;
      }

      return (float)var2;
   }

   public static Quaternion d(float var0) {
      return var0 >= -100.0F && var0 <= 100.0F ? Quaternion.e(0.0F, 1.0F, 0.0F, var0) : Quaternion.g;
   }
}
