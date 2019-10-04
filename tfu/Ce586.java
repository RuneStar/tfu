package tfu;

import java.util.Arrays;

public class Ce586 extends Cx556 {
   private static final int a = 1514;
   private static final int af = 441;
   private static final int ag = 1617;
   private static final int ah = 364;
   private static final int ai = 556;
   private static final int al = 579;
   private static final int ao = 248;
   private static final int ap = 225;
   private static final int aq = 1640;
   private static final int av = 464;
   private static final int az = 341;
   public static final float b = 1.0F;
   private static final int c = 1580;
   private static final int d = 8;
   public static final float e = 0.84F;
   private static final int f = 1557;
   private static final boolean g = true;
   public static final float h = 7000.0F;
   private static final int i = 1445;
   public static final float j = 0.045F;
   private static final int k = 1422;
   public static final float l = 1.0F;
   private static final int m = 1356;
   private static final int n = 1379;
   private static final int o = 1491;
   private static final int p = 1139;
   private static final int q = 4;
   private static final int r = 23;
   public static final float s = 1.0F;
   private static final int t = 1300;
   private static final int u = 1211;
   private static final float v = 0.5F;
   private static final int x = 1188;
   private static final int y = 1116;
   private static final int z = 1277;
   private float aa;
   private float ab;
   private float ac;
   private int[] ad;
   private Cu637[] aj;
   private Cu637[] ak;
   private float am;
   private float an;
   private float ar;
   private float as;
   private float at;
   private Cc648[] au;
   private float aw;
   private Cc648[] ax = new Cc648[8];
   private Cx556 ay;

   private static int m(int var0, int[] var1, int var2, int var3) {
      if (var3 > var1.length) {
         var3 = var1.length;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1[var2];
         if (var5 > 0) {
            var5 = -var5;
         }

         if (var5 < var0) {
            var0 = var5;
         }

         ++var2;
         if (var2 == var1.length) {
            var2 = 0;
         }
      }

      return var0;
   }

   private void h() {
      int var1;
      if (Cd585.s) {
         if (this.au == null) {
            for(var1 = 0; var1 < 8; ++var1) {
               Cc648.g(this.ax[var1]);
            }

            for(var1 = 0; var1 < 4; ++var1) {
               Cu637.g(this.aj[var1]);
            }

            this.au = new Cc648[8];
            this.au[0] = new Cc648(1139 * Cd585.h / '걄');
            this.au[1] = new Cc648(1211 * Cd585.h / '걄');
            this.au[2] = new Cc648(1300 * Cd585.h / '걄');
            this.au[3] = new Cc648(1379 * Cd585.h / '걄');
            this.au[4] = new Cc648(1445 * Cd585.h / '걄');
            this.au[5] = new Cc648(1514 * Cd585.h / '걄');
            this.au[6] = new Cc648(1580 * Cd585.h / '걄');
            this.au[7] = new Cc648(1640 * Cd585.h / '걄');
            this.ak = new Cu637[4];
            this.ak[0] = new Cu637(579 * Cd585.h / '걄');
            this.ak[1] = new Cu637(464 * Cd585.h / '걄');
            this.ak[2] = new Cu637(364 * Cd585.h / '걄');
            this.ak[3] = new Cu637(248 * Cd585.h / '걄');
            this.ad = new int[512];
         }
      } else if (this.au != null) {
         for(var1 = 0; var1 < 8; ++var1) {
            Cc648.g(this.ax[var1]);
         }

         for(var1 = 0; var1 < 4; ++var1) {
            Cu637.g(this.aj[var1]);
         }

         this.au = null;
         this.ak = null;
         this.ad = new int[256];
      }

   }

   public synchronized void j(int[] var1, int var2, int var3) {
      this.h();
      var3 += var2;

      while(var2 < var3) {
         int var4 = var3 - var2;
         if (var4 > 256) {
            var4 = 256;
         }

         if (this.ay != null) {
            this.ay.j(this.ad, 0, var4);
         }

         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < 8; ++var6) {
            var5 = m(var5, this.ax[var6].d, this.ax[var6].q, var4);
         }

         for(var6 = 0; var6 < 4; ++var6) {
            var5 = m(var5, this.aj[var6].g, this.aj[var6].d, var4);
         }

         if (Cd585.s) {
            for(var6 = 0; var6 < 8; ++var6) {
               var5 = m(var5, this.au[var6].d, this.au[var6].q, var4);
            }

            for(var6 = 0; var6 < 4; ++var6) {
               var5 = m(var5, this.ak[var6].g, this.ak[var6].d, var4);
            }

            var4 <<= 1;
            var2 <<= 1;
         }

         int var7;
         for(var6 = 0; var6 < var4; ++var6) {
            var7 = this.ad[var6];
            if (var7 > 0) {
               var7 = -var7;
            }

            if (var7 < var5) {
               var5 = var7;
            }
         }

         for(var6 = 0; var5 <= -4096; var5 >>= 1) {
            ++var6;
         }

         var7 = (int)(this.an * 4096.0F);
         int var8 = (int)(this.as * 4096.0F);
         int var9 = (int)(this.aw * 4096.0F);
         int var10 = (int)(this.aa * 65536.0F);
         int var11;
         int var12;
         int var13;
         int var14;
         int var15;
         int var16;
         int var10001;
         int var18;
         int var19;
         if (Cd585.s) {
            var11 = (int)(this.at * 4096.0F);
            var12 = (int)(this.ab * 4096.0F);
            var13 = 0;

            while(true) {
               if (var13 >= var4) {
                  var2 >>= 1;
                  break;
               }

               var14 = this.ad[var13++] >> var6;
               var15 = this.ad[var13++] >> var6;
               var16 = (var14 + var15) * var10 >> 17;
               int var24 = 0;

               int var20;
               int var21;
               for(var18 = 0; var18 < 8; ++var18) {
                  Cc648 var25 = this.ax[var18];
                  var20 = var25.d[var25.q] >> var6;
                  var21 = var25.g >> var6;
                  var21 += (var20 - var21) * var8 + 2048 >> 12;
                  var25.g = var21 << var6;
                  var25.d[var25.q] = var16 + (var21 * var7 + 2048 >> 12) << var6;
                  if (++var25.q >= var25.d.length) {
                     var25.q = 0;
                  }

                  var24 += var20;
               }

               for(var18 = 0; var18 < 4; ++var18) {
                  Cu637 var26 = this.aj[var18];
                  var20 = var26.g[var26.d] >> var6;
                  var24 = var20 - var24;
                  var26.g[var26.d] = var16 + (var20 * 2048 + 2048 >> 12) << var6;
                  if (++var26.d >= var26.g.length) {
                     var26.d = 0;
                  }
               }

               var18 = 0;

               for(var19 = 0; var19 < 8; ++var19) {
                  Cc648 var27 = this.au[var19];
                  var21 = var27.d[var27.q] >> var6;
                  int var22 = var27.g >> var6;
                  var22 += (var21 - var22) * var8 + 2048 >> 12;
                  var27.g = var22 << var6;
                  var27.d[var27.q] = var16 + (var22 * var7 + 2048 >> 12) << var6;
                  if (++var27.q >= var27.d.length) {
                     var27.q = 0;
                  }

                  var18 += var21;
               }

               for(var19 = 0; var19 < 4; ++var19) {
                  Cu637 var28 = this.ak[var19];
                  var21 = var28.g[var28.d] >> var6;
                  var18 = var21 - var18;
                  var28.g[var28.d] = var16 + (var21 * 2048 + 2048 >> 12) << var6;
                  if (++var28.d >= var28.g.length) {
                     var28.d = 0;
                  }
               }

               if (var6 > 12) {
                  var10001 = var2++;
                  var1[var10001] += var24 * var11 + var18 * var12 + var14 * var9 << var6 - 12;
                  var10001 = var2++;
                  var1[var10001] += var18 * var11 + var24 * var12 + var15 * var9 << var6 - 12;
               } else {
                  var10001 = var2++;
                  var1[var10001] += var24 * var11 + var18 * var12 + var14 * var9 >> 12 - var6;
                  var10001 = var2++;
                  var1[var10001] += var18 * var11 + var24 * var12 + var15 * var9 >> 12 - var6;
               }
            }
         } else {
            var11 = (int)(this.ac * 4096.0F);

            for(var12 = 0; var12 < var4; ++var12) {
               var13 = this.ad[var12] >> var6;
               var14 = var13 * var10 >> 16;
               var15 = 0;

               for(var16 = 0; var16 < 8; ++var16) {
                  Cc648 var17 = this.ax[var16];
                  var18 = var17.d[var17.q] >> var6;
                  var19 = var17.g >> var6;
                  var19 += (var18 - var19) * var8 + 2048 >> 12;
                  var17.g = var19 << var6;
                  var17.d[var17.q] = var14 + (var19 * var7 + 2048 >> 12) << var6;
                  if (++var17.q >= var17.d.length) {
                     var17.q = 0;
                  }

                  var15 += var18;
               }

               for(var16 = 0; var16 < 4; ++var16) {
                  Cu637 var23 = this.aj[var16];
                  var18 = var23.g[var23.d] >> var6;
                  var15 = var18 - var15;
                  var23.g[var23.d] = var14 + (var18 * 2048 + 2048 >> 12) << var6;
                  if (++var23.d >= var23.g.length) {
                     var23.d = 0;
                  }
               }

               if (var6 > 12) {
                  var10001 = var2++;
                  var1[var10001] += var15 * var11 + var13 * var9 << var6 - 12;
               } else {
                  var10001 = var2++;
                  var1[var10001] += var15 * var11 + var13 * var9 >> 12 - var6;
               }
            }
         }

         if (this.ay != null) {
            Arrays.fill(this.ad, 0, var4, 0);
         }
      }

   }

   public static synchronized void r(Ce586 var0, float var1) {
      var0.an = var1;
   }

   public static synchronized void v(Ce586 var0, float var1) {
      var0.am = var1;
      var0.as = 1.0F - (float)Math.pow(0.5D, 1000000.0D / (double)(var0.am * (float)Cd585.h));
   }

   public static synchronized void z(Ce586 var0, float var1) {
      var0.aw = var1;
   }

   public synchronized void t(float var1) {
      if (this.ar >= -1.0F && this.ar <= 1.0F) {
         this.ar = var1;
         this.at = (float)((double)this.ac * Math.sqrt((double)(1.0F + this.ar) * 0.5D));
         this.ab = (float)((double)this.ac * Math.sqrt((double)(1.0F - this.ar) * 0.5D));
      } else {
         throw new IllegalArgumentException("Width must be between -1 and 1");
      }
   }

   protected Cx556 g() {
      return this.ay;
   }

   public Ce586(Cx556 var1) {
      this.ax[0] = new Cc648(1116 * Cd585.h / '걄');
      this.ax[1] = new Cc648(1188 * Cd585.h / '걄');
      this.ax[2] = new Cc648(1277 * Cd585.h / '걄');
      this.ax[3] = new Cc648(1356 * Cd585.h / '걄');
      this.ax[4] = new Cc648(1422 * Cd585.h / '걄');
      this.ax[5] = new Cc648(1491 * Cd585.h / '걄');
      this.ax[6] = new Cc648(1557 * Cd585.h / '걄');
      this.ax[7] = new Cc648(1617 * Cd585.h / '걄');
      this.aj = new Cu637[4];
      this.aj[0] = new Cu637(556 * Cd585.h / '걄');
      this.aj[1] = new Cu637(441 * Cd585.h / '걄');
      this.aj[2] = new Cu637(341 * Cd585.h / '걄');
      this.aj[3] = new Cu637(225 * Cd585.h / '걄');
      if (!Cd585.s) {
         this.ad = new int[256];
      }

      this.h();
      s(this, 0.045F);
      u(this, 1.0F);
      r(this, 0.84F);
      z(this, 1.0F);
      v(this, 7000.0F);
      this.t(1.0F);
      this.ay = var1;
   }

   public static synchronized void u(Ce586 var0, float var1) {
      var0.ac = var1;
      var0.at = (float)((double)var0.ac * Math.sqrt((double)(1.0F + var0.ar) * 0.5D));
      var0.ab = (float)((double)var0.ac * Math.sqrt((double)(1.0F - var0.ar) * 0.5D));
   }

   public synchronized void e(int var1) {
      if (this.ay != null) {
         this.ay.e(var1);
      }

   }

   public static synchronized void s(Ce586 var0, float var1) {
      var0.aa = var1;
   }

   protected int q() {
      return 8;
   }

   protected Cx556 d() {
      return null;
   }
}
