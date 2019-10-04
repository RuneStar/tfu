package tfu;

import java.util.Arrays;
import java.util.Random;

public class Cl639 {
   private static int[] a;
   private static int[] ag;
   private static int[] c;
   private static int[] f;
   private static final double i = 1.0057929410678534D;
   private static int[] k;
   private static int[] m;
   private static int[] n = new int['耀'];
   private static int[] o;
   private Ch643 b;
   private Ch643 d;
   private Ch643 e;
   boolean g = true;
   private Ch643 h;
   private Ch643 j;
   private Ch643 l;
   private int p = 100;
   private Ch643 q;
   private int[] r = new int[]{0, 0, 0, 0, 0};
   private Ch643 s;
   int t = 0;
   private Ch643 u;
   private int[] v = new int[]{0, 0, 0, 0, 0};
   private int[] w = new int[]{0, 0, 0, 0, 0};
   private Cf644 x;
   private int y = 0;
   int z = 500;

   public static final int[] g(Cl639 var0, int var1, int var2) {
      Arrays.fill(m, 0, var1, 0);
      if (var2 < 10) {
         return m;
      } else {
         double var3 = (double)var1 / ((double)var2 + 0.0D);
         Ch643.q(var0.d);
         Ch643.q(var0.q);
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         if (var0.j != null && var0.j.g) {
            Ch643.q(var0.j);
            Ch643.q(var0.e);
            var5 = (int)((double)(var0.j.h - var0.j.e) * 32.768D / var3);
            var6 = (int)((double)var0.j.e * 32.768D / var3);
         }

         int var8 = 0;
         int var9 = 0;
         int var10 = 0;
         if (var0.h != null && var0.h.g) {
            Ch643.q(var0.h);
            Ch643.q(var0.s);
            var8 = (int)((double)(var0.h.h - var0.h.e) * 32.768D / var3);
            var9 = (int)((double)var0.h.e * 32.768D / var3);
         }

         int var11;
         for(var11 = 0; var11 < 5; ++var11) {
            if (var0.w[var11] != 0) {
               o[var11] = 0;
               a[var11] = (int)((double)var0.v[var11] * var3);
               f[var11] = (var0.w[var11] << 14) / 100;
               c[var11] = (int)((double)(var0.d.h - var0.d.e) * 32.768D * Math.pow(1.0057929410678534D, (double)var0.r[var11]) / var3);
               ag[var11] = (int)((double)var0.d.e * 32.768D / var3);
            }
         }

         int var12;
         int var13;
         int var14;
         int var15;
         int[] var10000;
         for(var11 = 0; var11 < var1; ++var11) {
            var12 = Ch643.j(var0.d, var1);
            var13 = Ch643.j(var0.q, var1);
            if (var0.j != null && var0.j.g) {
               var14 = Ch643.j(var0.j, var1);
               var15 = Ch643.j(var0.e, var1);
               var12 += d(var0, var7, var15, var0.j.s) >> 1;
               var7 += (var14 * var5 >> 16) + var6;
            }

            if (var0.h != null && var0.h.g) {
               var14 = Ch643.j(var0.h, var1);
               var15 = Ch643.j(var0.s, var1);
               var13 = var13 * ((d(var0, var10, var15, var0.h.s) >> 1) + '耀') >> 15;
               var10 += (var14 * var8 >> 16) + var9;
            }

            for(var14 = 0; var14 < 5; ++var14) {
               if (var0.w[var14] != 0) {
                  var15 = var11 + a[var14];
                  if (var15 < var1) {
                     var10000 = m;
                     var10000[var15] += d(var0, o[var14], var13 * f[var14] >> 15, var0.d.s);
                     var10000 = o;
                     var10000[var14] += (var12 * c[var14] >> 16) + ag[var14];
                  }
               }
            }
         }

         int var16;
         if (var0.b != null && var0.b.g) {
            Ch643.q(var0.b);
            Ch643.q(var0.l);
            var11 = 0;
            boolean var19 = false;
            boolean var20 = true;

            for(var14 = 0; var14 < var1; ++var14) {
               var15 = Ch643.j(var0.b, var1);
               var16 = Ch643.j(var0.l, var1);
               if (var20) {
                  var12 = var0.b.e + ((var0.b.h - var0.b.e) * var15 >> 8);
               } else {
                  var12 = var0.b.e + ((var0.b.h - var0.b.e) * var16 >> 8);
               }

               var11 += 256;
               if (var11 >= var12) {
                  var11 = 0;
                  var20 = !var20;
               }

               if (var20) {
                  m[var14] = 0;
               }
            }
         }

         if (var0.y > 0 && var0.p > 0) {
            var11 = (int)((double)var0.y * var3);

            for(var12 = var11; var12 < var1; ++var12) {
               var10000 = m;
               var10000[var12] += m[var12 - var11] * var0.p / 100;
            }
         }

         if (var0.x.g && (var0.x.d[0] > 0 || var0.x.d[1] > 0)) {
            Ch643.q(var0.u);
            var11 = Ch643.j(var0.u, var1 + 1);
            var12 = Cf644.j(var0.x, 0, (float)var11 / 65536.0F);
            var13 = Cf644.j(var0.x, 1, (float)var11 / 65536.0F);
            if (var1 >= var12 + var13) {
               var14 = 0;
               var15 = var13;
               if (var13 > var1 - var12) {
                  var15 = var1 - var12;
               }

               int var17;
               while(var14 < var15) {
                  var16 = (int)((long)m[var14 + var12] * (long)Cf644.w >> 16);

                  for(var17 = 0; var17 < var12; ++var17) {
                     var16 += (int)((long)m[var14 + var12 - 1 - var17] * (long)Cf644.b[0][var17] >> 16);
                  }

                  for(var17 = 0; var17 < var14; ++var17) {
                     var16 -= (int)((long)m[var14 - 1 - var17] * (long)Cf644.b[1][var17] >> 16);
                  }

                  m[var14] = var16;
                  var11 = Ch643.j(var0.u, var1 + 1);
                  ++var14;
               }

               boolean var21 = true;
               var15 = 128;

               while(true) {
                  if (var15 > var1 - var12) {
                     var15 = var1 - var12;
                  }

                  int var18;
                  while(var14 < var15) {
                     var17 = (int)((long)m[var14 + var12] * (long)Cf644.w >> 16);

                     for(var18 = 0; var18 < var12; ++var18) {
                        var17 += (int)((long)m[var14 + var12 - 1 - var18] * (long)Cf644.b[0][var18] >> 16);
                     }

                     for(var18 = 0; var18 < var13; ++var18) {
                        var17 -= (int)((long)m[var14 - 1 - var18] * (long)Cf644.b[1][var18] >> 16);
                     }

                     m[var14] = var17;
                     var11 = Ch643.j(var0.u, var1 + 1);
                     ++var14;
                  }

                  if (var14 >= var1 - var12) {
                     while(var14 < var1) {
                        var17 = 0;

                        for(var18 = var14 + var12 - var1; var18 < var12; ++var18) {
                           var17 += (int)((long)m[var14 + var12 - 1 - var18] * (long)Cf644.b[0][var18] >> 16);
                        }

                        for(var18 = 0; var18 < var13; ++var18) {
                           var17 -= (int)((long)m[var14 - 1 - var18] * (long)Cf644.b[1][var18] >> 16);
                        }

                        m[var14] = var17;
                        Ch643.j(var0.u, var1 + 1);
                        ++var14;
                     }
                     break;
                  }

                  var12 = Cf644.j(var0.x, 0, (float)var11 / 65536.0F);
                  var13 = Cf644.j(var0.x, 1, (float)var11 / 65536.0F);
                  var15 += 128;
               }
            }
         }

         for(var11 = 0; var11 < var1; ++var11) {
            if (m[var11] < -32768) {
               m[var11] = -32768;
            }

            if (m[var11] > 32767) {
               m[var11] = 32767;
            }
         }

         return m;
      }
   }

   private static final int d(Cl639 var0, int var1, int var2, int var3) {
      if (var3 == 1) {
         return (var1 & 32767) < 16384 ? var2 : -var2;
      } else if (var3 == 2) {
         return k[var1 & 32767] * var2 >> 14;
      } else if (var3 == 3) {
         return ((var1 & 32767) * var2 >> 14) - var2;
      } else {
         return var3 == 4 ? n[var1 / 2607 & 32767] * var2 : 0;
      }
   }

   public final void q(Gg3 var1) {
      this.d = new Ch643();
      Ch643.g(this.d, var1);
      this.q = new Ch643();
      Ch643.g(this.q, var1);
      int var2 = Gg3.ar(var1);
      if (var2 != 0) {
         --var1.v;
         this.j = new Ch643();
         Ch643.g(this.j, var1);
         this.e = new Ch643();
         Ch643.g(this.e, var1);
      }

      var2 = Gg3.ar(var1);
      if (var2 != 0) {
         --var1.v;
         this.h = new Ch643();
         Ch643.g(this.h, var1);
         this.s = new Ch643();
         Ch643.g(this.s, var1);
      }

      var2 = Gg3.ar(var1);
      if (var2 != 0) {
         --var1.v;
         this.b = new Ch643();
         Ch643.g(this.b, var1);
         this.l = new Ch643();
         Ch643.g(this.l, var1);
      }

      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = Gg3.br(var1);
         if (var4 == 0) {
            break;
         }

         this.w[var3] = var4;
         this.r[var3] = Gg3.by(var1);
         this.v[var3] = Gg3.br(var1);
      }

      this.y = Gg3.br(var1);
      this.p = Gg3.br(var1);
      this.z = Gg3.au(var1);
      this.t = Gg3.au(var1);
      this.x = new Cf644();
      this.u = new Ch643();
      Cf644.e(this.x, var1, this.u);
   }

   static {
      Random var0 = new Random(0L);

      int var1;
      for(var1 = 0; var1 < 32768; ++var1) {
         n[var1] = (var0.nextInt() & 2) - 1;
      }

      k = new int['耀'];

      for(var1 = 0; var1 < 32768; ++var1) {
         k[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      m = new int[220500];
      o = new int[5];
      a = new int[5];
      f = new int[5];
      c = new int[5];
      ag = new int[5];
   }
}
