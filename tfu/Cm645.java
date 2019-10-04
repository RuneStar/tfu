package tfu;

public class Cm645 extends Cs635 {
   private static final int d = 128;
   private static final boolean g = true;

   private static int h(Cm645 var0, int[] var1, int var2, int var3, int var4, float var5) {
      while(true) {
         if (var0.m > 0) {
            int var6 = var2 + var0.m;
            if (var6 > var4) {
               var6 = var4;
            }

            var0.m += var2;
            if (var0.e == 256 && (var0.j & 255) == 0) {
               if (Cd585.s) {
                  var2 = o(0.0F, Ci646.l((Ci646)var0.bm), var1, var0.j, var2, var0.l, var0.r, var0.y, var0.p, 0, var6, var3, var0);
               } else {
                  var2 = i(Ci646.l((Ci646)var0.bm), var1, var0.j, var2, var0.b, var0.v, 0, var6, var3, var0);
               }
            } else if (Cd585.s) {
               var2 = ag(0.0F, 0, Ci646.l((Ci646)var0.bm), var1, var0.j, var2, var0.l, var0.r, var0.y, var0.p, 0, var6, var3, var0, var0.e, var5);
            } else {
               var2 = c(0.0F, 0, Ci646.l((Ci646)var0.bm), var1, var0.j, var2, var0.b, var0.v, 0, var6, var3, var0, var0.e, var5);
            }

            var0.m -= var2;
            if (var0.m != 0) {
               return var2;
            }

            if (!bg(var0)) {
               continue;
            }

            return var4;
         }

         if (var0.e == 256 && (var0.j & 255) == 0) {
            if (Cd585.s) {
               return v(0.0F, Ci646.l((Ci646)var0.bm), var1, var0.j, var2, var0.l, var0.r, 0, var4, var3, var0);
            }

            return r(Ci646.l((Ci646)var0.bm), var1, var0.j, var2, var0.b, 0, var4, var3, var0);
         }

         if (Cd585.s) {
            return m(0.0F, 0, Ci646.l((Ci646)var0.bm), var1, var0.j, var2, var0.l, var0.r, 0, var4, var3, var0, var0.e, var5);
         }

         return t(0.0F, 0, Ci646.l((Ci646)var0.bm), var1, var0.j, var2, var0.b, 0, var4, var3, var0, var0.e, var5);
      }
   }

   protected Cm645(Ci646 var1, int var2, int var3, int var4) {
      super.bm = var1;
      super.u = var1.d;
      super.z = var1.q;
      super.t = var1.j;
      super.e = var2;
      super.h = var3;
      super.s = var4;
      super.j = 0;
      bd(this);
   }

   private static int ag(float var0, int var1, float[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, Cm645 var13, int var14, float var15) {
      var6 *= 128;
      var8 *= 128;
      var7 *= 128;
      var9 *= 128;
      var13.b -= var13.v * var5;
      if (var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      int var10001;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         var0 = var2[var1];
         var0 = var0 * 256.0F + (var2[var1 + 1] - var0) * (float)(var4 & 255);
         var10001 = var5++;
         var3[var10001] += (int)(var0 * (float)var6) >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += (int)(var0 * (float)var7) >> 6;
         var7 += var9;
      }

      if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14 - 1) / var14) > var11) {
         var10 = var11;
      }

      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var0 = var2[var4 >> 8];
         var0 = var0 * 256.0F + (var15 - var0) * (float)(var4 & 255);
         var10001 = var5++;
         var3[var10001] += (int)(var0 * (float)var6) >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += (int)(var0 * (float)var7) >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.b += var13.v * var5;
      var13.l = var6 / 128;
      var13.r = var7 / 128;
      var13.j = var4;
      return var5;
   }

   private static int s(Cm645 var0, int[] var1, int var2, int var3, int var4, float var5) {
      while(true) {
         if (var0.m > 0) {
            int var6 = var2 + var0.m;
            if (var6 > var4) {
               var6 = var4;
            }

            var0.m += var2;
            if (var0.e == -256 && (var0.j & 255) == 0) {
               if (Cd585.s) {
                  var2 = f(0.0F, Ci646.l((Ci646)var0.bm), var1, var0.j, var2, var0.l, var0.r, var0.y, var0.p, 0, var6, var3, var0);
               } else {
                  var2 = a(Ci646.l((Ci646)var0.bm), var1, var0.j, var2, var0.b, var0.v, 0, var6, var3, var0);
               }
            } else if (Cd585.s) {
               var2 = ai(0.0F, 0, Ci646.l((Ci646)var0.bm), var1, var0.j, var2, var0.l, var0.r, var0.y, var0.p, 0, var6, var3, var0, var0.e, var5);
            } else {
               var2 = aq(0.0F, 0, Ci646.l((Ci646)var0.bm), var1, var0.j, var2, var0.b, var0.v, 0, var6, var3, var0, var0.e, var5);
            }

            var0.m -= var2;
            if (var0.m != 0) {
               return var2;
            }

            if (!bg(var0)) {
               continue;
            }

            return var4;
         }

         if (var0.e == -256 && (var0.j & 255) == 0) {
            if (Cd585.s) {
               return z(0.0F, Ci646.l((Ci646)var0.bm), var1, var0.j, var2, var0.l, var0.r, 0, var4, var3, var0);
            }

            return u(Ci646.l((Ci646)var0.bm), var1, var0.j, var2, var0.b, 0, var4, var3, var0);
         }

         if (Cd585.s) {
            return k(0.0F, 0, Ci646.l((Ci646)var0.bm), var1, var0.j, var2, var0.l, var0.r, 0, var4, var3, var0, var0.e, var5);
         }

         return n(0.0F, 0, Ci646.l((Ci646)var0.bm), var1, var0.j, var2, var0.b, 0, var4, var3, var0, var0.e, var5);
      }
   }

   private static int r(float[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, Cm645 var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      var4 *= 128;
      if ((var5 = var3 + var7 - var2) > var6) {
         var5 = var6;
      }

      int var10001;
      for(var5 -= 3; var3 < var5; var1[var10001] = (int)((float)var1[var10001] + var0[var2++] * (float)var4)) {
         var10001 = var3++;
         var1[var10001] = (int)((float)var1[var10001] + var0[var2++] * (float)var4);
         var10001 = var3++;
         var1[var10001] = (int)((float)var1[var10001] + var0[var2++] * (float)var4);
         var10001 = var3++;
         var1[var10001] = (int)((float)var1[var10001] + var0[var2++] * (float)var4);
         var10001 = var3++;
      }

      for(var5 += 3; var3 < var5; var1[var10001] = (int)((float)var1[var10001] + var0[var2++] * (float)var4)) {
         var10001 = var3++;
      }

      var8.j = var2 << 8;
      return var3;
   }

   private static int v(float var0, float[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, Cm645 var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var5 *= 128;
      var6 *= 128;
      if ((var7 = var4 + var9 - var3) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var10001;
      for(var7 -= 6; var4 < var7; var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var6)) {
         var0 = var1[var3++];
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var5);
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var6);
         var0 = var1[var3++];
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var5);
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var6);
         var0 = var1[var3++];
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var5);
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var6);
         var0 = var1[var3++];
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var5);
         var10001 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var6)) {
         var0 = var1[var3++];
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var5);
         var10001 = var4++;
      }

      var10.j = var3 << 8;
      return var4 >> 1;
   }

   private static int u(float[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, Cm645 var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      var4 *= 128;
      if ((var5 = var3 + var2 - (var7 - 1)) > var6) {
         var5 = var6;
      }

      int var10001;
      for(var5 -= 3; var3 < var5; var1[var10001] = (int)((float)var1[var10001] + var0[var2--] * (float)var4)) {
         var10001 = var3++;
         var1[var10001] = (int)((float)var1[var10001] + var0[var2--] * (float)var4);
         var10001 = var3++;
         var1[var10001] = (int)((float)var1[var10001] + var0[var2--] * (float)var4);
         var10001 = var3++;
         var1[var10001] = (int)((float)var1[var10001] + var0[var2--] * (float)var4);
         var10001 = var3++;
      }

      for(var5 += 3; var3 < var5; var1[var10001] = (int)((float)var1[var10001] + var0[var2--] * (float)var4)) {
         var10001 = var3++;
      }

      var8.j = var2 << 8;
      return var3;
   }

   private static int t(float var0, int var1, float[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, Cm645 var10, int var11, float var12) {
      var6 *= 128;
      if (var11 == 0 || (var7 = var5 + (var9 - var4 + var11 - 257) / var11) > var8) {
         var7 = var8;
      }

      int var10001;
      while(var5 < var7) {
         var1 = var4 >> 8;
         var0 = var2[var1];
         var10001 = var5++;
         var3[var10001] += (int)((var0 * 256.0F + (var2[var1 + 1] - var0) * (float)(var4 & 255)) * (float)var6) >> 6;
         var4 += var11;
      }

      if (var11 == 0 || (var7 = var5 + (var9 - var4 + var11 - 1) / var11) > var8) {
         var7 = var8;
      }

      while(var5 < var7) {
         var0 = var2[var4 >> 8];
         var10001 = var5++;
         var3[var10001] += (int)((var0 * 256.0F + (var12 - var0) * (float)(var4 & 255)) * (float)var6) >> 6;
         var4 += var11;
      }

      var10.j = var4;
      return var5;
   }

   private static int n(float var0, int var1, float[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, Cm645 var10, int var11, float var12) {
      var6 *= 128;
      if (var11 == 0 || (var7 = var5 + (var9 + 256 - var4 + var11) / var11) > var8) {
         var7 = var8;
      }

      int var10001;
      while(var5 < var7) {
         var1 = var4 >> 8;
         var0 = var2[var1 - 1];
         var10001 = var5++;
         var3[var10001] += (int)((var0 * 256.0F + (var2[var1] - var0) * (float)(var4 & 255)) * (float)var6) >> 6;
         var4 += var11;
      }

      if (var11 == 0 || (var7 = var5 + (var9 - var4 + var11) / var11) > var8) {
         var7 = var8;
      }

      for(var0 = var12; var5 < var7; var4 += var11) {
         var10001 = var5++;
         var3[var10001] += (int)((var0 * 256.0F + (var2[var4 >> 8] - var0) * (float)(var4 & 255)) * (float)var6) >> 6;
      }

      var10.j = var4;
      return var5;
   }

   private static int i(float[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, Cm645 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      var4 *= 128;
      var5 *= 128;
      if ((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.l += var9.y * (var6 - var3);
      var9.r += var9.p * (var6 - var3);

      int var10001;
      for(var6 -= 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] = (int)((float)var1[var10001] + var0[var2++] * (float)var4);
         var4 += var5;
         var10001 = var3++;
         var1[var10001] = (int)((float)var1[var10001] + var0[var2++] * (float)var4);
         var4 += var5;
         var10001 = var3++;
         var1[var10001] = (int)((float)var1[var10001] + var0[var2++] * (float)var4);
         var4 += var5;
         var10001 = var3++;
         var1[var10001] = (int)((float)var1[var10001] + var0[var2++] * (float)var4);
      }

      for(var6 += 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] = (int)((float)var1[var10001] + var0[var2++] * (float)var4);
      }

      var9.b = var4 / 128 >> 2;
      var9.j = var2 << 8;
      return var3;
   }

   private static int o(float var0, float[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, Cm645 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      var5 *= 128;
      var7 *= 128;
      var6 *= 128;
      var8 *= 128;
      if ((var9 = var4 + var11 - var3) > var10) {
         var9 = var10;
      }

      var12.b += var12.v * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      int var10001;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var0 = var1[var3++];
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var5);
         var5 += var7;
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var6);
         var6 += var8;
         var0 = var1[var3++];
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var5);
         var5 += var7;
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var6);
         var6 += var8;
         var0 = var1[var3++];
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var5);
         var5 += var7;
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var6);
         var6 += var8;
         var0 = var1[var3++];
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var5);
         var5 += var7;
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var6);
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var0 = var1[var3++];
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var5);
         var5 += var7;
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var6);
      }

      var12.l = var5 / 128 >> 2;
      var12.r = var6 / 128 >> 2;
      var12.j = var3 << 8;
      return var4 >> 1;
   }

   private static int a(float[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, Cm645 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      var4 *= 128;
      var5 *= 128;
      if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.l += var9.y * (var6 - var3);
      var9.r += var9.p * (var6 - var3);

      int var10001;
      for(var6 -= 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] = (int)((float)var1[var10001] + var0[var2--] * (float)var4);
         var4 += var5;
         var10001 = var3++;
         var1[var10001] = (int)((float)var1[var10001] + var0[var2--] * (float)var4);
         var4 += var5;
         var10001 = var3++;
         var1[var10001] = (int)((float)var1[var10001] + var0[var2--] * (float)var4);
         var4 += var5;
         var10001 = var3++;
         var1[var10001] = (int)((float)var1[var10001] + var0[var2--] * (float)var4);
      }

      for(var6 += 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] = (int)((float)var1[var10001] + var0[var2--] * (float)var4);
      }

      var9.b = var4 / 128 >> 2;
      var9.j = var2 << 8;
      return var3;
   }

   private static int f(float var0, float[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, Cm645 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      var5 *= 128;
      var7 *= 128;
      var6 *= 128;
      var8 *= 128;
      if ((var9 = var4 + var3 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.b += var12.v * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      int var10001;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var0 = var1[var3--];
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var5);
         var5 += var7;
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var6);
         var6 += var8;
         var0 = var1[var3--];
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var5);
         var5 += var7;
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var6);
         var6 += var8;
         var0 = var1[var3--];
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var5);
         var5 += var7;
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var6);
         var6 += var8;
         var0 = var1[var3--];
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var5);
         var5 += var7;
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var6);
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var0 = var1[var3--];
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var5);
         var5 += var7;
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var6);
      }

      var12.l = var5 / 128 >> 2;
      var12.r = var6 / 128 >> 2;
      var12.j = var3 << 8;
      return var4 >> 1;
   }

   private static int m(float var0, int var1, float[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, Cm645 var11, int var12, float var13) {
      var6 *= 128;
      var7 *= 128;
      if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      int var10001;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         var0 = var2[var1];
         var0 = var0 * 256.0F + (var2[var1 + 1] - var0) * (float)(var4 & 255);
         var10001 = var5++;
         var3[var10001] += (int)(var0 * (float)var6) >> 6;
         var10001 = var5++;
         var3[var10001] += (int)(var0 * (float)var7) >> 6;
      }

      if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var0 = var2[var4 >> 8];
         var0 = var0 * 256.0F + (var13 - var0) * (float)(var4 & 255);
         var10001 = var5++;
         var3[var10001] += (int)(var0 * (float)var6) >> 6;
         var10001 = var5++;
         var3[var10001] += (int)(var0 * (float)var7) >> 6;
      }

      var11.j = var4;
      return var5 >> 1;
   }

   private static int aq(float var0, int var1, float[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, Cm645 var11, int var12, float var13) {
      var6 *= 128;
      var7 *= 128;
      var11.l -= var11.y * var5;
      var11.r -= var11.p * var5;
      if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      int var10001;
      while(var5 < var8) {
         var1 = var4 >> 8;
         var0 = var2[var1 - 1];
         var10001 = var5++;
         var3[var10001] += (int)((var0 * 256.0F + (var2[var1] - var0) * (float)(var4 & 255)) * (float)var6) >> 6;
         var6 += var7;
         var4 += var12;
      }

      if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      for(var0 = var13; var5 < var8; var4 += var12) {
         var10001 = var5++;
         var3[var10001] += (int)((var0 * 256.0F + (var2[var4 >> 8] - var0) * (float)(var4 & 255)) * (float)var6) >> 6;
         var6 += var7;
      }

      var11.l += var11.y * var5;
      var11.r += var11.p * var5;
      var11.b = var6 / 128;
      var11.j = var4;
      return var5;
   }

   private static int ai(float var0, int var1, float[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, Cm645 var13, int var14, float var15) {
      var6 *= 128;
      var8 *= 128;
      var7 *= 128;
      var9 *= 128;
      var13.b -= var13.v * var5;
      if (var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      int var10001;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         var0 = var2[var1 - 1];
         var0 = var0 * 256.0F + (var2[var1] - var0) * (float)(var4 & 255);
         var10001 = var5++;
         var3[var10001] += (int)(var0 * (float)var6) >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += (int)(var0 * (float)var7) >> 6;
         var7 += var9;
      }

      if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var0 = var15 * 256.0F + (var2[var4 >> 8] - var15) * (float)(var4 & 255);
         var10001 = var5++;
         var3[var10001] += (int)(var0 * (float)var6) >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += (int)(var0 * (float)var7) >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.b += var13.v * var5;
      var13.l = var6 / 128;
      var13.r = var7 / 128;
      var13.j = var4;
      return var5;
   }

   protected Cm645(Ci646 var1, int var2, int var3) {
      super.bm = var1;
      super.u = var1.d;
      super.z = var1.q;
      super.t = var1.j;
      super.e = var2;
      super.h = var3;
      super.s = 8192;
      super.j = 0;
      bd(this);
   }

   private static int k(float var0, int var1, float[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, Cm645 var11, int var12, float var13) {
      var6 *= 128;
      var7 *= 128;
      if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      int var10001;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         var0 = var2[var1 - 1];
         var0 = var0 * 256.0F + (var2[var1] - var0) * (float)(var4 & 255);
         var10001 = var5++;
         var3[var10001] += (int)(var0 * (float)var6) >> 6;
         var10001 = var5++;
         var3[var10001] += (int)(var0 * (float)var7) >> 6;
      }

      if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var0 = var13 * 256.0F + (var2[var4 >> 8] - var13) * (float)(var4 & 255);
         var10001 = var5++;
         var3[var10001] += (int)(var0 * (float)var6) >> 6;
         var10001 = var5++;
         var3[var10001] += (int)(var0 * (float)var7) >> 6;
      }

      var11.j = var4;
      return var5 >> 1;
   }

   public synchronized void j(int[] var1, int var2, int var3) throws IllegalStateException {
      if (super.h == 0 && super.m == 0) {
         this.e(var3);
      } else {
         int var4 = super.u << 8;
         int var5 = super.z << 8;
         int var6 = ((Ci646)super.bm).g() << 8;
         int var7 = var5 - var4;
         if (var7 <= 0) {
            super.x = 0;
         }

         int var8 = var2;
         var3 += var2;
         if (super.j < 0) {
            if (super.e <= 0) {
               bx(this);
               ef(this);
               return;
            }

            super.j = 0;
         }

         if (super.j >= var6) {
            if (super.e >= 0) {
               bx(this);
               ef(this);
               return;
            }

            super.j = var6 - 1;
         }

         if (super.x < 0) {
            if (super.t) {
               if (super.e < 0) {
                  var8 = s(this, var1, var2, var4, var3, Ci646.l((Ci646)super.bm)[super.u]);
                  if (super.j >= var4) {
                     return;
                  }

                  super.j = var4 + var4 - 1 - super.j;
                  super.e = -super.e;
               }

               while(true) {
                  var8 = h(this, var1, var8, var5, var3, Ci646.l((Ci646)super.bm)[super.z - 1]);
                  if (super.j < var5) {
                     return;
                  }

                  super.j = var5 + var5 - 1 - super.j;
                  super.e = -super.e;
                  var8 = s(this, var1, var8, var4, var3, Ci646.l((Ci646)super.bm)[super.u]);
                  if (super.j >= var4) {
                     return;
                  }

                  super.j = var4 + var4 - 1 - super.j;
                  super.e = -super.e;
               }
            } else if (super.e < 0) {
               while(true) {
                  var8 = s(this, var1, var8, var4, var3, Ci646.l((Ci646)super.bm)[super.z - 1]);
                  if (super.j >= var4) {
                     return;
                  }

                  super.j = var5 - 1 - (var5 - 1 - super.j) % var7;
               }
            } else {
               while(true) {
                  var8 = h(this, var1, var8, var5, var3, Ci646.l((Ci646)super.bm)[super.u]);
                  if (super.j < var5) {
                     return;
                  }

                  super.j = var4 + (super.j - var4) % var7;
               }
            }
         } else {
            int var9;
            if (super.x > 0) {
               if (super.t) {
                  label145: {
                     if (super.e < 0) {
                        var8 = s(this, var1, var2, var4, var3, Ci646.l((Ci646)super.bm)[super.u]);
                        if (super.j >= var4) {
                           return;
                        }

                        super.j = var4 + var4 - 1 - super.j;
                        super.e = -super.e;
                        if (--super.x == 0) {
                           break label145;
                        }
                     }

                     do {
                        var8 = h(this, var1, var8, var5, var3, Ci646.l((Ci646)super.bm)[super.z - 1]);
                        if (super.j < var5) {
                           return;
                        }

                        super.j = var5 + var5 - 1 - super.j;
                        super.e = -super.e;
                        if (--super.x == 0) {
                           break;
                        }

                        var8 = s(this, var1, var8, var4, var3, Ci646.l((Ci646)super.bm)[super.u]);
                        if (super.j >= var4) {
                           return;
                        }

                        super.j = var4 + var4 - 1 - super.j;
                        super.e = -super.e;
                     } while(--super.x != 0);
                  }
               } else if (super.e < 0) {
                  while(true) {
                     var8 = s(this, var1, var8, var4, var3, Ci646.l((Ci646)super.bm)[super.z - 1]);
                     if (super.j >= var4) {
                        return;
                     }

                     var9 = (var5 - 1 - super.j) / var7;
                     if (var9 >= super.x) {
                        super.j += var7 * super.x;
                        super.x = 0;
                        break;
                     }

                     super.j += var7 * var9;
                     super.x -= var9;
                  }
               } else {
                  while(true) {
                     var8 = h(this, var1, var8, var5, var3, Ci646.l((Ci646)super.bm)[super.u]);
                     if (super.j < var5) {
                        return;
                     }

                     var9 = (super.j - var4) / var7;
                     if (var9 >= super.x) {
                        super.j -= var7 * super.x;
                        super.x = 0;
                        break;
                     }

                     super.j -= var7 * var9;
                     super.x -= var9;
                  }
               }
            }

            if (super.e < 0) {
               s(this, var1, var8, 0, var3, 0.0F);
               if (super.j < 0) {
                  super.j = -1;
                  bx(this);
                  ef(this);
               }
            } else {
               h(this, var1, var8, var6, var3, 0.0F);
               if (super.j >= var6) {
                  super.j = var6;
                  bx(this);
                  ef(this);
               }
            }

            if (Ci646.w((Ci646)super.bm)) {
               var9 = super.j >> 8;
               if ((super.j & 255) != 0) {
                  ++var9;
               }

               if (var9 >= Ci646.l((Ci646)super.bm).length) {
                  var9 = Ci646.l((Ci646)super.bm).length - 1;
               }

               if (var9 > Ci646.r((Ci646)super.bm)) {
                  System.out.println("WaveStreamFP - attempted to play sound beyond streaming decode progress. Position accessed: " + var9 + ", streaming progress: " + Ci646.r((Ci646)super.bm));
               }
            }

         }
      }
   }

   private static int c(float var0, int var1, float[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, Cm645 var11, int var12, float var13) {
      var6 *= 128;
      var7 *= 128;
      var11.l -= var11.y * var5;
      var11.r -= var11.p * var5;
      if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      int var10001;
      while(var5 < var8) {
         var1 = var4 >> 8;
         var0 = var2[var1];
         var10001 = var5++;
         var3[var10001] += (int)((var0 * 256.0F + (var2[var1 + 1] - var0) * (float)(var4 & 255)) * (float)var6) >> 6;
         var6 += var7;
         var4 += var12;
      }

      if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      while(var5 < var8) {
         var0 = var2[var4 >> 8];
         var10001 = var5++;
         var3[var10001] += (int)((var0 * 256.0F + (var13 - var0) * (float)(var4 & 255)) * (float)var6) >> 6;
         var6 += var7;
         var4 += var12;
      }

      var11.l += var11.y * var5;
      var11.r += var11.p * var5;
      var11.b = var6 / 128;
      var11.j = var4;
      return var5;
   }

   private static int z(float var0, float[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, Cm645 var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var5 *= 128;
      var6 *= 128;
      if ((var7 = var4 + var3 - (var9 - 1)) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var10001;
      for(var7 -= 6; var4 < var7; var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var6)) {
         var0 = var1[var3--];
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var5);
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var6);
         var0 = var1[var3--];
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var5);
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var6);
         var0 = var1[var3--];
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var5);
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var6);
         var0 = var1[var3--];
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var5);
         var10001 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var6)) {
         var0 = var1[var3--];
         var10001 = var4++;
         var2[var10001] = (int)((float)var2[var10001] + var0 * (float)var5);
         var10001 = var4++;
      }

      var10.j = var3 << 8;
      return var4 >> 1;
   }
}
