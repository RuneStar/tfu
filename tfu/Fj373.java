package tfu;

import com.jagex.js5.js5;

public class Fj373 {
   public byte[] b;
   public int d;
   public int e;
   public int g;
   public int h;
   public int j;
   public byte[] l;
   public int q;
   public int[] s;

   public static Fj373 g(js5 var0, int var1, int var2) {
      byte[] var3 = var0.getfile(var1, var2);
      return var3 == null ? null : d(var3)[0];
   }

   public static int q(Fj373 var0) {
      return var0.g + var0.q + var0.j;
   }

   public static int j(Fj373 var0) {
      return var0.d + var0.e + var0.h;
   }

   public static int[] e(Fj373 var0) {
      int var1 = q(var0);
      int[] var2 = new int[var1 * j(var0)];
      int var3;
      int var4;
      int var5;
      int var6;
      if (var0.l != null) {
         for(var3 = 0; var3 < var0.d; ++var3) {
            var4 = var3 * var0.g;
            var5 = var0.q + (var3 + var0.e) * var1;

            for(var6 = 0; var6 < var0.g; ++var6) {
               var2[var5++] = var0.l[var4] << 24 | var0.s[var0.b[var4] & 255];
               ++var4;
            }
         }
      } else {
         for(var3 = 0; var3 < var0.d; ++var3) {
            var4 = var3 * var0.g;
            var5 = var0.q + (var3 + var0.e) * var1;

            for(var6 = 0; var6 < var0.g; ++var6) {
               int var7 = var0.s[var0.b[var4++] & 255];
               if (var7 != 0) {
                  var2[var5++] = -16777216 | var7;
               } else {
                  var2[var5++] = 0;
               }
            }
         }
      }

      return var2;
   }

   public static Fj373[] d(byte[] var0) {
      Gg3 var1 = new Gg3(var0);
      var1.v = var0.length - 2;
      int var2 = Gg3.au(var1);
      Fj373[] var3 = new Fj373[var2];

      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var3[var4] = new Fj373();
      }

      var1.v = var0.length - 7 - var2 * 8;
      var4 = Gg3.au(var1);
      int var5 = Gg3.au(var1);
      int var6 = (Gg3.ar(var1) & 255) + 1;

      int var7;
      for(var7 = 0; var7 < var2; ++var7) {
         var3[var7].q = Gg3.au(var1);
      }

      for(var7 = 0; var7 < var2; ++var7) {
         var3[var7].e = Gg3.au(var1);
      }

      for(var7 = 0; var7 < var2; ++var7) {
         var3[var7].g = Gg3.au(var1);
      }

      for(var7 = 0; var7 < var2; ++var7) {
         var3[var7].d = Gg3.au(var1);
      }

      for(var7 = 0; var7 < var2; ++var7) {
         Fj373 var8 = var3[var7];
         var8.j = var4 - var8.g - var8.q;
         var8.h = var5 - var8.d - var8.e;
      }

      var1.v = var0.length - 7 - var2 * 8 - (var6 - 1) * 3;
      int[] var17 = new int[var6];

      int var16;
      for(var16 = 1; var16 < var6; ++var16) {
         var17[var16] = Gg3.ay(var1);
         if (var17[var16] == 0) {
            var17[var16] = 1;
         }
      }

      for(var16 = 0; var16 < var2; ++var16) {
         var3[var16].s = var17;
      }

      var1.v = 0;

      for(var16 = 0; var16 < var2; ++var16) {
         Fj373 var9 = var3[var16];
         int var10 = var9.g * var9.d;
         var9.b = new byte[var10];
         int var11 = Gg3.ar(var1);
         int var13;
         if ((var11 & 2) == 0) {
            int var18;
            if ((var11 & 1) == 0) {
               for(var18 = 0; var18 < var10; ++var18) {
                  var9.b[var18] = Gg3.ax(var1);
               }
            } else {
               for(var18 = 0; var18 < var9.g; ++var18) {
                  for(var13 = 0; var13 < var9.d; ++var13) {
                     var9.b[var18 + var13 * var9.g] = Gg3.ax(var1);
                  }
               }
            }
         } else {
            boolean var12 = false;
            var9.l = new byte[var10];
            if ((var11 & 1) == 0) {
               for(var13 = 0; var13 < var10; ++var13) {
                  var9.b[var13] = Gg3.ax(var1);
               }

               for(var13 = 0; var13 < var10; ++var13) {
                  byte var14 = var9.l[var13] = Gg3.ax(var1);
                  var12 |= var14 != -1;
               }
            } else {
               int var19;
               for(var13 = 0; var13 < var9.g; ++var13) {
                  for(var19 = 0; var19 < var9.d; ++var19) {
                     var9.b[var13 + var19 * var9.g] = Gg3.ax(var1);
                  }
               }

               for(var13 = 0; var13 < var9.g; ++var13) {
                  for(var19 = 0; var19 < var9.d; ++var19) {
                     byte var15 = var9.l[var13 + var19 * var9.g] = Gg3.ax(var1);
                     var12 |= var15 != -1;
                  }
               }
            }

            if (!var12) {
               var9.l = null;
            }
         }
      }

      return var3;
   }
}
