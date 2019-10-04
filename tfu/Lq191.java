package tfu;

public class Lq191 {
   public static final float d = 0.5F;
   public static final int e = 0;
   private static int g = 20;
   public static final int h = 2;
   public static final float j = 0.1F;
   public static final int q = 50;

   public static int g() {
      return g;
   }

   public static float d() {
      return 1.0F / (float)g;
   }

   public static int j() {
      int var0 = (int)(0.1F * (float)g);
      if (var0 < 1) {
         var0 = 1;
      }

      return var0;
   }

   public static void q(int var0) {
      int var1 = (int)(0.5F * (float)var0);
      if (var1 > 50) {
         throw new IllegalArgumentException("Framerate cannot be higher than 100.0");
      } else {
         g = var0;
      }
   }
}
