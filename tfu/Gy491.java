package tfu;

public class Gy491 {
   private static int d = 0;
   public static int[] e;
   private static int g = 0;
   public static int[] j;
   public static int[] q;

   private static void d() {
      if (q == null) {
         q = new int[65536];
         double var0 = 0.7D + (Math.random() * 0.03D - 0.015D);
         int var2 = 0;

         for(int var3 = 0; var3 < 512; ++var3) {
            float var4 = ((float)(var3 >> 3) / 64.0F + 0.0078125F) * 360.0F;
            float var5 = (float)(var3 & 7) / 8.0F + 0.0625F;

            for(int var6 = 0; var6 < 128; ++var6) {
               float var7 = (float)var6 / 128.0F;
               float var8 = 0.0F;
               float var9 = 0.0F;
               float var10 = 0.0F;
               float var11 = var4 / 60.0F;
               int var12 = (int)var11;
               int var13 = var12 % 6;
               float var14 = var11 - (float)var12;
               float var15 = var7 * (1.0F - var5);
               float var16 = var7 * (1.0F - var14 * var5);
               float var17 = var7 * (1.0F - (1.0F - var14) * var5);
               if (var13 == 0) {
                  var8 = var7;
                  var9 = var17;
                  var10 = var15;
               } else if (var13 == 1) {
                  var8 = var16;
                  var9 = var7;
                  var10 = var15;
               } else if (var13 == 2) {
                  var8 = var15;
                  var9 = var7;
                  var10 = var17;
               } else if (var13 == 3) {
                  var8 = var15;
                  var9 = var16;
                  var10 = var7;
               } else if (var13 == 4) {
                  var8 = var17;
                  var9 = var15;
                  var10 = var7;
               } else if (var13 == 5) {
                  var8 = var7;
                  var9 = var15;
                  var10 = var16;
               }

               var8 = (float)Math.pow((double)var8, var0);
               var9 = (float)Math.pow((double)var9, var0);
               var10 = (float)Math.pow((double)var10, var0);
               int var18 = (int)(var8 * 256.0F);
               int var19 = (int)(var9 * 256.0F);
               int var20 = (int)(var10 * 256.0F);
               int var21 = -16777216 + (var18 << 16) + (var19 << 8) + var20;
               q[var2++] = var21;
            }
         }

      }
   }

   public static void g(boolean var0, boolean var1) {
      if (var0) {
         ++g;
         d();
      }

      if (var1) {
         ++d;
         q();
      }

   }

   private static void q() {
      if (j == null) {
         j = new int[65536];
         e = new int[65536];
         double var0 = 0.7D + (Math.random() * 0.03D - 0.015D);

         for(int var2 = 0; var2 < 65536; ++var2) {
            double var3 = (double)(var2 >> 10 & 63) / 64.0D + 0.0078125D;
            double var5 = (double)(var2 >> 7 & 7) / 8.0D + 0.0625D;
            double var7 = (double)(var2 & 127) / 128.0D;
            double var9 = var7;
            double var11 = var7;
            double var13 = var7;
            if (var5 != 0.0D) {
               double var15;
               if (var7 < 0.5D) {
                  var15 = var7 * (1.0D + var5);
               } else {
                  var15 = var7 + var5 - var7 * var5;
               }

               double var17 = 2.0D * var7 - var15;
               double var19 = var3 + 0.3333333333333333D;
               if (var19 > 1.0D) {
                  --var19;
               }

               double var23 = var3 - 0.3333333333333333D;
               if (var23 < 0.0D) {
                  ++var23;
               }

               if (6.0D * var19 < 1.0D) {
                  var9 = var17 + (var15 - var17) * 6.0D * var19;
               } else if (2.0D * var19 < 1.0D) {
                  var9 = var15;
               } else if (3.0D * var19 < 2.0D) {
                  var9 = var17 + (var15 - var17) * (0.6666666666666666D - var19) * 6.0D;
               } else {
                  var9 = var17;
               }

               if (6.0D * var3 < 1.0D) {
                  var11 = var17 + (var15 - var17) * 6.0D * var3;
               } else if (2.0D * var3 < 1.0D) {
                  var11 = var15;
               } else if (3.0D * var3 < 2.0D) {
                  var11 = var17 + (var15 - var17) * (0.6666666666666666D - var3) * 6.0D;
               } else {
                  var11 = var17;
               }

               if (6.0D * var23 < 1.0D) {
                  var13 = var17 + (var15 - var17) * 6.0D * var23;
               } else if (2.0D * var23 < 1.0D) {
                  var13 = var15;
               } else if (3.0D * var23 < 2.0D) {
                  var13 = var17 + (var15 - var17) * (0.6666666666666666D - var23) * 6.0D;
               } else {
                  var13 = var17;
               }
            }

            var9 = Math.pow(var9, var0);
            var11 = Math.pow(var11, var0);
            var13 = Math.pow(var13, var0);
            int var25 = (int)(var9 * 256.0D);
            int var16 = (int)(var11 * 256.0D);
            int var26 = (int)(var13 * 256.0D);
            int var18 = (var25 << 16) + (var16 << 8) + var26;
            j[var2] = var18 & 16777215;
            int var27 = (var26 << 16) + (var16 << 8) + var25;
            e[var2] = var27;
         }

      }
   }
}
