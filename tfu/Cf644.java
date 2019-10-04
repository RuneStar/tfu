package tfu;

public class Cf644 {
   static int[][] b = new int[2][8];
   static float l;
   static final int q = 4;
   static final float r = 100.0F;
   static float[][] s = new float[2][8];
   static final float v = 8.0F;
   static int w;
   static final float y = 32.703197F;
   int[] d = new int[2];
   int[][][] e = new int[2][2][4];
   boolean g = true;
   int[] h = new int[2];
   int[][][] j = new int[2][2][4];

   private static float d(float var0) {
      float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
      return var1 * 3.1415927F / 11025.0F;
   }

   private static float g(Cf644 var0, int var1, int var2, float var3) {
      float var4 = (float)var0.e[var1][0][var2] + var3 * (float)(var0.e[var1][1][var2] - var0.e[var1][0][var2]);
      var4 *= 0.0015258789F;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
   }

   public static final void e(Cf644 var0, Gg3 var1, Ch643 var2) {
      int var3 = Gg3.ar(var1);
      var0.d[0] = var3 >> 4;
      var0.d[1] = var3 & 15;
      if (var3 != 0) {
         var0.h[0] = Gg3.au(var1);
         var0.h[1] = Gg3.au(var1);
         int var4 = Gg3.ar(var1);

         int var5;
         int var6;
         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < var0.d[var5]; ++var6) {
               var0.j[var5][0][var6] = Gg3.au(var1);
               var0.e[var5][0][var6] = Gg3.au(var1);
            }
         }

         for(var5 = 0; var5 < 2; ++var5) {
            for(var6 = 0; var6 < var0.d[var5]; ++var6) {
               if ((var4 & 1 << var5 * 4 << var6) != 0) {
                  var0.j[var5][1][var6] = Gg3.au(var1);
                  var0.e[var5][1][var6] = Gg3.au(var1);
               } else {
                  var0.j[var5][1][var6] = var0.j[var5][0][var6];
                  var0.e[var5][1][var6] = var0.e[var5][0][var6];
               }
            }
         }

         if (var4 != 0 || var0.h[1] != var0.h[0]) {
            Ch643.d(var2, var1);
         }
      } else {
         var0.h[0] = var0.h[1] = 0;
      }

   }

   public static int j(Cf644 var0, int var1, float var2) {
      float var3;
      if (var1 == 0) {
         var3 = (float)var0.h[0] + (float)(var0.h[1] - var0.h[0]) * var2;
         var3 *= 0.0030517578F;
         l = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
         w = (int)(l * 65536.0F);
      }

      if (var0.d[var1] == 0) {
         return 0;
      } else {
         var3 = g(var0, var1, 0, var2);
         s[var1][0] = -2.0F * var3 * (float)Math.cos((double)q(var0, var1, 0, var2));
         s[var1][1] = var3 * var3;

         float[] var10000;
         int var4;
         for(var4 = 1; var4 < var0.d[var1]; ++var4) {
            var3 = g(var0, var1, var4, var2);
            float var5 = -2.0F * var3 * (float)Math.cos((double)q(var0, var1, var4, var2));
            float var6 = var3 * var3;
            s[var1][var4 * 2 + 1] = s[var1][var4 * 2 - 1] * var6;
            s[var1][var4 * 2] = s[var1][var4 * 2 - 1] * var5 + s[var1][var4 * 2 - 2] * var6;

            for(int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
               var10000 = s[var1];
               var10000[var7] += s[var1][var7 - 1] * var5 + s[var1][var7 - 2] * var6;
            }

            var10000 = s[var1];
            var10000[1] += s[var1][0] * var5 + var6;
            var10000 = s[var1];
            var10000[0] += var5;
         }

         if (var1 == 0) {
            for(var4 = 0; var4 < var0.d[0] * 2; ++var4) {
               var10000 = s[0];
               var10000[var4] *= l;
            }
         }

         for(var4 = 0; var4 < var0.d[var1] * 2; ++var4) {
            b[var1][var4] = (int)(s[var1][var4] * 65536.0F);
         }

         return var0.d[var1] * 2;
      }
   }

   private static float q(Cf644 var0, int var1, int var2, float var3) {
      float var4 = (float)var0.j[var1][0][var2] + var3 * (float)(var0.j[var1][1][var2] - var0.j[var1][0][var2]);
      var4 *= 1.2207031E-4F;
      return d(var4);
   }
}
