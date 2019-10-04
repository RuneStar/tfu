package tfu;

import java.util.Comparator;
import java.util.Random;

public class Bo314 {
   public static Ak315 g(Object[] var0) {
      return j((Random)null, var0, 0, var0.length);
   }

   private static int[] e(int var0) {
      int[] var1 = new int[var0];

      for(int var2 = 0; var2 < var0; var1[var2] = var2++) {
      }

      return var1;
   }

   public static Ak315 q(Random var0, short[] var1, int var2, int var3) {
      int[] var4 = e(var3);

      for(int var5 = 0; var5 < var3; ++var5) {
         int var6 = var5 + Jz233.r(var0, var3 - var5);
         short var7 = var1[var2 + var5];
         var1[var2 + var5] = var1[var2 + var6];
         var1[var2 + var6] = var7;
         int var8 = var4[var5];
         var4[var5] = var4[var6];
         var4[var6] = var8;
      }

      return new Ak315(var1.length, var2, var4);
   }

   public static Ak315 j(Random var0, Object[] var1, int var2, int var3) {
      int[] var4 = e(var3);

      for(int var5 = 0; var5 < var3; ++var5) {
         int var6 = var5 + Jz233.r(var0, var3 - var5);
         Object var7 = var1[var2 + var5];
         var1[var2 + var5] = var1[var2 + var6];
         var1[var2 + var6] = var7;
         int var8 = var4[var5];
         var4[var5] = var4[var6];
         var4[var6] = var8;
      }

      return new Ak315(var1.length, var2, var4);
   }

   private static void u(boolean[] var0, int var1, int[] var2, int var3, int var4, Aj540 var5, boolean var6) {
      if (var4 - var3 > 1) {
         int var7 = var3;
         int var8 = var4 - 1;
         int var9 = var3 + var8 >>> 1;
         if (var4 - var3 >= 5) {
            int var10 = var5.g(var0[var1 + var3], var0[var1 + var8]);
            if (var10 > 0 || var10 == 0 && var2[var3] > var2[var8]) {
               var7 = var8;
               var8 = var3;
            }

            var10 = var5.g(var0[var1 + var9], var0[var1 + var7]);
            if (var10 < 0 || var10 == 0 && var2[var9] < var2[var7]) {
               var9 = var7;
            } else {
               var10 = var5.g(var0[var1 + var9], var0[var1 + var8]);
               if (var10 > 0 || var10 == 0 && var2[var9] > var2[var8]) {
                  var9 = var8;
               }
            }
         }

         boolean var14 = var0[var1 + var9];
         int var11 = var2[var9];
         int var12 = var4 - 1;
         var0[var1 + var9] = var0[var1 + var12];
         var2[var9] = var2[var12];
         var9 = var12;
         var12 = var3;

         while(var12 < var9) {
            int var13 = var5.g(var0[var1 + var12], var14);
            if ((var13 > 0 || var13 == 0 && var2[var12] > var11) != var6) {
               var0[var1 + var9] = var0[var1 + var12];
               var2[var9] = var2[var12];
               --var9;
               var0[var1 + var12] = var0[var1 + var9];
               var2[var12] = var2[var9];
            } else {
               ++var12;
            }
         }

         var0[var1 + var9] = var14;
         var2[var9] = var11;
         u(var0, var1, var2, var3, var9, var5, var6);
         u(var0, var1, var2, var9 + 1, var4, var5, var6);
      }
   }

   private static void b(byte[] var0, int var1, int[] var2, int var3, int var4, Bq656 var5, boolean var6) {
      if (var4 - var3 > 1) {
         int var7 = var3;
         int var8 = var4 - 1;
         int var9 = var3 + var8 >>> 1;
         int var10;
         if (var4 - var3 >= 5) {
            var10 = var5.g(var0[var1 + var3] & 255, var0[var1 + var8] & 255);
            if (var10 > 0 || var10 == 0 && var2[var3] > var2[var8]) {
               var7 = var8;
               var8 = var3;
            }

            var10 = var5.g(var0[var1 + var9] & 255, var0[var1 + var7] & 255);
            if (var10 < 0 || var10 == 0 && var2[var9] < var2[var7]) {
               var9 = var7;
            } else {
               var10 = var5.g(var0[var1 + var9] & 255, var0[var1 + var8] & 255);
               if (var10 > 0 || var10 == 0 && var2[var9] > var2[var8]) {
                  var9 = var8;
               }
            }
         }

         var10 = var0[var1 + var9] & 255;
         int var11 = var2[var9];
         int var12 = var4 - 1;
         var0[var1 + var9] = var0[var1 + var12];
         var2[var9] = var2[var12];
         var9 = var12;
         var12 = var3;

         while(var12 < var9) {
            int var13 = var5.g(var0[var1 + var12] & 255, var10);
            if ((var13 > 0 || var13 == 0 && var2[var12] > var11) != var6) {
               var0[var1 + var9] = var0[var1 + var12];
               var2[var9] = var2[var12];
               --var9;
               var0[var1 + var12] = var0[var1 + var9];
               var2[var12] = var2[var9];
            } else {
               ++var12;
            }
         }

         var0[var1 + var9] = (byte)var10;
         var2[var9] = var11;
         b(var0, var1, var2, var3, var9, var5, var6);
         b(var0, var1, var2, var9 + 1, var4, var5, var6);
      }
   }

   private static void l(short[] var0, int var1, int[] var2, int var3, int var4, Bq656 var5, boolean var6) {
      if (var4 - var3 > 1) {
         int var7 = var3;
         int var8 = var4 - 1;
         int var9 = var3 + var8 >>> 1;
         if (var4 - var3 >= 5) {
            int var10 = var5.g(var0[var1 + var3], var0[var1 + var8]);
            if (var10 > 0 || var10 == 0 && var2[var3] > var2[var8]) {
               var7 = var8;
               var8 = var3;
            }

            var10 = var5.g(var0[var1 + var9], var0[var1 + var7]);
            if (var10 < 0 || var10 == 0 && var2[var9] < var2[var7]) {
               var9 = var7;
            } else {
               var10 = var5.g(var0[var1 + var9], var0[var1 + var8]);
               if (var10 > 0 || var10 == 0 && var2[var9] > var2[var8]) {
                  var9 = var8;
               }
            }
         }

         short var14 = var0[var1 + var9];
         int var11 = var2[var9];
         int var12 = var4 - 1;
         var0[var1 + var9] = var0[var1 + var12];
         var2[var9] = var2[var12];
         var9 = var12;
         var12 = var3;

         while(var12 < var9) {
            int var13 = var5.g(var0[var1 + var12], var14);
            if ((var13 > 0 || var13 == 0 && var2[var12] > var11) != var6) {
               var0[var1 + var9] = var0[var1 + var12];
               var2[var9] = var2[var12];
               --var9;
               var0[var1 + var12] = var0[var1 + var9];
               var2[var12] = var2[var9];
            } else {
               ++var12;
            }
         }

         var0[var1 + var9] = var14;
         var2[var9] = var11;
         l(var0, var1, var2, var3, var9, var5, var6);
         l(var0, var1, var2, var9 + 1, var4, var5, var6);
      }
   }

   private static void w(short[] var0, int var1, int[] var2, int var3, int var4, Bq656 var5, boolean var6) {
      if (var4 - var3 > 1) {
         int var7 = var3;
         int var8 = var4 - 1;
         int var9 = var3 + var8 >>> 1;
         int var10;
         if (var4 - var3 >= 5) {
            var10 = var5.g(var0[var1 + var3] & '\uffff', var0[var1 + var8] & '\uffff');
            if (var10 > 0 || var10 == 0 && var2[var3] > var2[var8]) {
               var7 = var8;
               var8 = var3;
            }

            var10 = var5.g(var0[var1 + var9] & '\uffff', var0[var1 + var7] & '\uffff');
            if (var10 < 0 || var10 == 0 && var2[var9] < var2[var7]) {
               var9 = var7;
            } else {
               var10 = var5.g(var0[var1 + var9] & '\uffff', var0[var1 + var8] & '\uffff');
               if (var10 > 0 || var10 == 0 && var2[var9] > var2[var8]) {
                  var9 = var8;
               }
            }
         }

         var10 = var0[var1 + var9] & '\uffff';
         int var11 = var2[var9];
         int var12 = var4 - 1;
         var0[var1 + var9] = var0[var1 + var12];
         var2[var9] = var2[var12];
         var9 = var12;
         var12 = var3;

         while(var12 < var9) {
            int var13 = var5.g(var0[var1 + var12] & '\uffff', var10);
            if ((var13 > 0 || var13 == 0 && var2[var12] > var11) != var6) {
               var0[var1 + var9] = var0[var1 + var12];
               var2[var9] = var2[var12];
               --var9;
               var0[var1 + var12] = var0[var1 + var9];
               var2[var12] = var2[var9];
            } else {
               ++var12;
            }
         }

         var0[var1 + var9] = (short)var10;
         var2[var9] = var11;
         w(var0, var1, var2, var3, var9, var5, var6);
         w(var0, var1, var2, var9 + 1, var4, var5, var6);
      }
   }

   private static void r(char[] var0, int var1, int[] var2, int var3, int var4, Ad562 var5, boolean var6) {
      if (var4 - var3 > 1) {
         int var7 = var3;
         int var8 = var4 - 1;
         int var9 = var3 + var8 >>> 1;
         if (var4 - var3 >= 5) {
            int var10 = var5.g(var0[var1 + var3], var0[var1 + var8]);
            if (var10 > 0 || var10 == 0 && var2[var3] > var2[var8]) {
               var7 = var8;
               var8 = var3;
            }

            var10 = var5.g(var0[var1 + var9], var0[var1 + var7]);
            if (var10 < 0 || var10 == 0 && var2[var9] < var2[var7]) {
               var9 = var7;
            } else {
               var10 = var5.g(var0[var1 + var9], var0[var1 + var8]);
               if (var10 > 0 || var10 == 0 && var2[var9] > var2[var8]) {
                  var9 = var8;
               }
            }
         }

         char var14 = var0[var1 + var9];
         int var11 = var2[var9];
         int var12 = var4 - 1;
         var0[var1 + var9] = var0[var1 + var12];
         var2[var9] = var2[var12];
         var9 = var12;
         var12 = var3;

         while(var12 < var9) {
            int var13 = var5.g(var0[var1 + var12], var14);
            if ((var13 > 0 || var13 == 0 && var2[var12] > var11) != var6) {
               var0[var1 + var9] = var0[var1 + var12];
               var2[var9] = var2[var12];
               --var9;
               var0[var1 + var12] = var0[var1 + var9];
               var2[var12] = var2[var9];
            } else {
               ++var12;
            }
         }

         var0[var1 + var9] = var14;
         var2[var9] = var11;
         r(var0, var1, var2, var3, var9, var5, var6);
         r(var0, var1, var2, var9 + 1, var4, var5, var6);
      }
   }

   private static void v(int[] var0, int var1, int[] var2, int var3, int var4, Bq656 var5, boolean var6) {
      if (var4 - var3 > 1) {
         int var7 = var3;
         int var8 = var4 - 1;
         int var9 = var3 + var8 >>> 1;
         int var10;
         if (var4 - var3 >= 5) {
            var10 = var5.g(var0[var1 + var3], var0[var1 + var8]);
            if (var10 > 0 || var10 == 0 && var2[var3] > var2[var8]) {
               var7 = var8;
               var8 = var3;
            }

            var10 = var5.g(var0[var1 + var9], var0[var1 + var7]);
            if (var10 < 0 || var10 == 0 && var2[var9] < var2[var7]) {
               var9 = var7;
            } else {
               var10 = var5.g(var0[var1 + var9], var0[var1 + var8]);
               if (var10 > 0 || var10 == 0 && var2[var9] > var2[var8]) {
                  var9 = var8;
               }
            }
         }

         var10 = var0[var1 + var9];
         int var11 = var2[var9];
         int var12 = var4 - 1;
         var0[var1 + var9] = var0[var1 + var12];
         var2[var9] = var2[var12];
         var9 = var12;
         var12 = var3;

         while(var12 < var9) {
            int var13 = var5.g(var0[var1 + var12], var10);
            if ((var13 > 0 || var13 == 0 && var2[var12] > var11) != var6) {
               var0[var1 + var9] = var0[var1 + var12];
               var2[var9] = var2[var12];
               --var9;
               var0[var1 + var12] = var0[var1 + var9];
               var2[var12] = var2[var9];
            } else {
               ++var12;
            }
         }

         var0[var1 + var9] = var10;
         var2[var9] = var11;
         v(var0, var1, var2, var3, var9, var5, var6);
         v(var0, var1, var2, var9 + 1, var4, var5, var6);
      }
   }

   private static void p(float[] var0, int var1, int[] var2, int var3, int var4, Au658 var5, boolean var6) {
      if (var4 - var3 > 1) {
         int var7 = var3;
         int var8 = var4 - 1;
         int var9 = var3 + var8 >>> 1;
         if (var4 - var3 >= 5) {
            int var10 = var5.g(var0[var1 + var3], var0[var1 + var8]);
            if (var10 > 0 || var10 == 0 && var2[var3] > var2[var8]) {
               var7 = var8;
               var8 = var3;
            }

            var10 = var5.g(var0[var1 + var9], var0[var1 + var7]);
            if (var10 < 0 || var10 == 0 && var2[var9] < var2[var7]) {
               var9 = var7;
            } else {
               var10 = var5.g(var0[var1 + var9], var0[var1 + var8]);
               if (var10 > 0 || var10 == 0 && var2[var9] > var2[var8]) {
                  var9 = var8;
               }
            }
         }

         float var14 = var0[var1 + var9];
         int var11 = var2[var9];
         int var12 = var4 - 1;
         var0[var1 + var9] = var0[var1 + var12];
         var2[var9] = var2[var12];
         var9 = var12;
         var12 = var3;

         while(var12 < var9) {
            int var13 = var5.g(var0[var1 + var12], var14);
            if ((var13 > 0 || var13 == 0 && var2[var12] > var11) != var6) {
               var0[var1 + var9] = var0[var1 + var12];
               var2[var9] = var2[var12];
               --var9;
               var0[var1 + var12] = var0[var1 + var9];
               var2[var12] = var2[var9];
            } else {
               ++var12;
            }
         }

         var0[var1 + var9] = var14;
         var2[var9] = var11;
         p(var0, var1, var2, var3, var9, var5, var6);
         p(var0, var1, var2, var9 + 1, var4, var5, var6);
      }
   }

   private static void x(double[] var0, int var1, int[] var2, int var3, int var4, Ar552 var5, boolean var6) {
      if (var4 - var3 > 1) {
         int var7 = var3;
         int var8 = var4 - 1;
         int var9 = var3 + var8 >>> 1;
         if (var4 - var3 >= 5) {
            int var10 = var5.g(var0[var1 + var3], var0[var1 + var8]);
            if (var10 > 0 || var10 == 0 && var2[var3] > var2[var8]) {
               var7 = var8;
               var8 = var3;
            }

            var10 = var5.g(var0[var1 + var9], var0[var1 + var7]);
            if (var10 < 0 || var10 == 0 && var2[var9] < var2[var7]) {
               var9 = var7;
            } else {
               var10 = var5.g(var0[var1 + var9], var0[var1 + var8]);
               if (var10 > 0 || var10 == 0 && var2[var9] > var2[var8]) {
                  var9 = var8;
               }
            }
         }

         double var15 = var0[var1 + var9];
         int var12 = var2[var9];
         int var13 = var4 - 1;
         var0[var1 + var9] = var0[var1 + var13];
         var2[var9] = var2[var13];
         var9 = var13;
         var13 = var3;

         while(var13 < var9) {
            int var14 = var5.g(var0[var1 + var13], var15);
            if ((var14 > 0 || var14 == 0 && var2[var13] > var12) != var6) {
               var0[var1 + var9] = var0[var1 + var13];
               var2[var9] = var2[var13];
               --var9;
               var0[var1 + var13] = var0[var1 + var9];
               var2[var13] = var2[var9];
            } else {
               ++var13;
            }
         }

         var0[var1 + var9] = var15;
         var2[var9] = var12;
         x(var0, var1, var2, var3, var9, var5, var6);
         x(var0, var1, var2, var9 + 1, var4, var5, var6);
      }
   }

   private static void y(long[] var0, int var1, int[] var2, int var3, int var4, Ax659 var5, boolean var6) {
      if (var4 - var3 > 1) {
         int var7 = var3;
         int var8 = var4 - 1;
         int var9 = var3 + var8 >>> 1;
         if (var4 - var3 >= 5) {
            int var10 = var5.g(var0[var1 + var3], var0[var1 + var8]);
            if (var10 > 0 || var10 == 0 && var2[var3] > var2[var8]) {
               var7 = var8;
               var8 = var3;
            }

            var10 = var5.g(var0[var1 + var9], var0[var1 + var7]);
            if (var10 < 0 || var10 == 0 && var2[var9] < var2[var7]) {
               var9 = var7;
            } else {
               var10 = var5.g(var0[var1 + var9], var0[var1 + var8]);
               if (var10 > 0 || var10 == 0 && var2[var9] > var2[var8]) {
                  var9 = var8;
               }
            }
         }

         long var15 = var0[var1 + var9];
         int var12 = var2[var9];
         int var13 = var4 - 1;
         var0[var1 + var9] = var0[var1 + var13];
         var2[var9] = var2[var13];
         var9 = var13;
         var13 = var3;

         while(var13 < var9) {
            int var14 = var5.g(var0[var1 + var13], var15);
            if ((var14 > 0 || var14 == 0 && var2[var13] > var12) != var6) {
               var0[var1 + var9] = var0[var1 + var13];
               var2[var9] = var2[var13];
               --var9;
               var0[var1 + var13] = var0[var1 + var9];
               var2[var13] = var2[var9];
            } else {
               ++var13;
            }
         }

         var0[var1 + var9] = var15;
         var2[var9] = var12;
         y(var0, var1, var2, var3, var9, var5, var6);
         y(var0, var1, var2, var9 + 1, var4, var5, var6);
      }
   }

   private static void h(Object[] var0, int var1, int[] var2, int var3, int var4, Comparator var5, boolean var6) {
      if (var4 - var3 > 1) {
         int var7 = var3;
         int var8 = var4 - 1;
         int var9 = var3 + var8 >>> 1;
         if (var4 - var3 >= 5) {
            int var10 = var5.compare(var0[var1 + var3], var0[var1 + var8]);
            if (var10 > 0 || var10 == 0 && var2[var3] > var2[var8]) {
               var7 = var8;
               var8 = var3;
            }

            var10 = var5.compare(var0[var1 + var9], var0[var1 + var7]);
            if (var10 < 0 || var10 == 0 && var2[var9] < var2[var7]) {
               var9 = var7;
            } else {
               var10 = var5.compare(var0[var1 + var9], var0[var1 + var8]);
               if (var10 > 0 || var10 == 0 && var2[var9] > var2[var8]) {
                  var9 = var8;
               }
            }
         }

         Object var14 = var0[var1 + var9];
         int var11 = var2[var9];
         int var12 = var4 - 1;
         var0[var1 + var9] = var0[var1 + var12];
         var2[var9] = var2[var12];
         var9 = var12;
         var12 = var3;

         while(var12 < var9) {
            int var13 = var5.compare(var0[var1 + var12], var14);
            if ((var13 > 0 || var13 == 0 && var2[var12] > var11) != var6) {
               var0[var1 + var9] = var0[var1 + var12];
               var2[var9] = var2[var12];
               --var9;
               var0[var1 + var12] = var0[var1 + var9];
               var2[var12] = var2[var9];
            } else {
               ++var12;
            }
         }

         var0[var1 + var9] = var14;
         var2[var9] = var11;
         h(var0, var1, var2, var3, var9, var5, var6);
         h(var0, var1, var2, var9 + 1, var4, var5, var6);
      }
   }

   private static void s(byte[] var0, int var1, int[] var2, int var3, int var4, Bq656 var5, boolean var6) {
      if (var4 - var3 > 1) {
         int var7 = var3;
         int var8 = var4 - 1;
         int var9 = var3 + var8 >>> 1;
         if (var4 - var3 >= 5) {
            int var10 = var5.g(var0[var1 + var3], var0[var1 + var8]);
            if (var10 > 0 || var10 == 0 && var2[var3] > var2[var8]) {
               var7 = var8;
               var8 = var3;
            }

            var10 = var5.g(var0[var1 + var9], var0[var1 + var7]);
            if (var10 < 0 || var10 == 0 && var2[var9] < var2[var7]) {
               var9 = var7;
            } else {
               var10 = var5.g(var0[var1 + var9], var0[var1 + var8]);
               if (var10 > 0 || var10 == 0 && var2[var9] > var2[var8]) {
                  var9 = var8;
               }
            }
         }

         byte var14 = var0[var1 + var9];
         int var11 = var2[var9];
         int var12 = var4 - 1;
         var0[var1 + var9] = var0[var1 + var12];
         var2[var9] = var2[var12];
         var9 = var12;
         var12 = var3;

         while(var12 < var9) {
            int var13 = var5.g(var0[var1 + var12], var14);
            if ((var13 > 0 || var13 == 0 && var2[var12] > var11) != var6) {
               var0[var1 + var9] = var0[var1 + var12];
               var2[var9] = var2[var12];
               --var9;
               var0[var1 + var12] = var0[var1 + var9];
               var2[var12] = var2[var9];
            } else {
               ++var12;
            }
         }

         var0[var1 + var9] = var14;
         var2[var9] = var11;
         s(var0, var1, var2, var3, var9, var5, var6);
         s(var0, var1, var2, var9 + 1, var4, var5, var6);
      }
   }

   public static Ak315 d(Random var0, short[] var1) {
      return q(var0, var1, 0, var1.length);
   }
}
