package tfu;

import com.jagex.js5.js5;

public class M688 extends Cx556 {
   static final int t = 4;
   static final int u = 1;
   static final int z = 2;
   int[] a = new int[16];
   private R694 aa = null;
   private long af;
   private Z693 ag = new Z693();
   private P689 ah;
   private int ai;
   private int al;
   private boolean ao;
   private int ap;
   private boolean aq;
   private long av;
   private T690 az = new T690(this);
   private int[] b = new int[16];
   private U691[][] c = new U691[16][128];
   private int d = 256;
   int[] e = new int[16];
   private U691[][] f = new U691[16][128];
   private Ha262 g;
   private int[] h = new int[16];
   int[] i = new int[16];
   private int j = 1000000;
   private int[] k = new int[16];
   private int[] l = new int[16];
   int[] m = new int[16];
   private int[] n = new int[16];
   private int[] o = new int[16];
   private int[] p = new int[16];
   private int q = 256;
   private int[] r = new int[16];
   private int[] s = new int[16];
   private int[] v = new int[16];
   private int[] x = new int[16];
   private int[] y = new int[16];

   private static void ap(M688 var0, boolean var1) {
      if (var1) {
         al(var0, -1);
      } else {
         av(var0, -1);
      }

      af(var0, -1);

      int var2;
      for(var2 = 0; var2 < 16; ++var2) {
         var0.r[var2] = var0.l[var2];
      }

      for(var2 = 0; var2 < 16; ++var2) {
         var0.v[var2] = var0.l[var2] & -128;
      }

   }

   public M688(M688 var1) {
      this.g = var1.g;
      s(this, -1, 256);
      ap(this, true);
   }

   public static synchronized boolean r(M688 var0, P689 var1, js5 var2, Ca649 var3, int var4) {
      var1.d();
      boolean var5 = true;
      int[] var6 = null;
      if (var4 > 0) {
         var6 = new int[]{var4};
      }

      for(Ld263 var7 = (Ld263)Ha262.e(var1.d); var7 != null; var7 = (Ld263)Ha262.h(var1.d)) {
         int var8 = (int)var7.bq;
         Y692 var9 = (Y692)Ha262.d(var0.g, (long)var8);
         if (var9 == null) {
            var9 = Y692.g(var2, var8);
            if (var9 == null) {
               var5 = false;
               continue;
            }

            Ha262.q(var0.g, var9, (long)var8);
         }

         if (!Y692.d(var9, var3, (byte[])var7.g, var6)) {
            var5 = false;
         }
      }

      if (var5) {
         P689.q(var1);
      }

      return var5;
   }

   private static int at(M688 var0, U691 var1) {
      int var2 = var0.s[var1.g];
      return var2 < 8192 ? var2 * var1.l + 32 >> 6 : 16384 - ((16384 - var2) * (128 - var1.l) + 32 >> 6);
   }

   public static synchronized void t(M688 var0, P689 var1, boolean var2, boolean var3, long var4) {
      z(var0, var1, var2, var3);
      ab(var0, var4 * (long)var0.ag.q);
   }

   public static synchronized void m(M688 var0) {
      n(var0, true);
   }

   public static synchronized void n(M688 var0, boolean var1) {
      Z693.d(var0.ag);
      var0.ah = null;
      ap(var0, var1);
   }

   private static void i(M688 var0, int var1, int var2) {
      var0.l[var1] = var2;
      var0.v[var1] = var2 & -128;
      o(var0, var1, var2);
   }

   private void a(int var1, int var2, int var3) {
      c(this, var1, var2, 64);
      if ((this.m[var1] & 2) != 0) {
         for(U691 var4 = (U691)Gx298.a(this.az.j); var4 != null; var4 = (U691)Gx298.ag(this.az.j)) {
            if (var4.g == var1 && var4.u < 0) {
               this.f[var1][var4.h] = null;
               this.f[var1][var2] = var4;
               int var5 = var4.w + (var4.r * var4.v >> 12);
               var4.w += var2 - var4.h << 8;
               var4.r = var5 - var4.w;
               var4.v = 4096;
               var4.h = var2;
               return;
            }
         }
      }

      Y692 var8 = (Y692)Ha262.d(this.g, (long)this.r[var1]);
      if (var8 != null) {
         Cw634 var9 = var8.d[var2];
         if (var9 != null) {
            U691 var6 = new U691();
            var6.g = var1;
            var6.d = var8;
            var6.q = var9;
            var6.j = var8.h[var2];
            var6.e = var8.s[var2];
            var6.h = var2;
            var6.s = var3;
            var6.b = var3 * var3 * var8.g * var8.j[var2] + 1024 >> 11;
            var6.l = var8.e[var2] & 255;
            var6.w = (var2 << 8) - (var8.q[var2] & 32767);
            var6.y = 0;
            var6.p = 0;
            var6.x = 0;
            var6.u = -1;
            var6.z = 0;
            if (this.i[var1] == 0) {
               var6.n = var9.d(as(this, var6), ac(this, var6), at(this, var6));
            } else {
               var6.n = var9.d(as(this, var6), 0, at(this, var6));
               f(this, var6, var8.q[var2] < 0);
            }

            if (var8.q[var2] < 0) {
               Cs635.bq(var6.n, -1);
            }

            if (var6.e >= 0) {
               U691 var7 = this.c[var1][var6.e];
               if (var7 != null && var7.u < 0) {
                  this.f[var1][var7.h] = null;
                  var7.u = 0;
               }

               this.c[var1][var6.e] = var6;
            }

            Gx298.t(this.az.j, var6);
            this.f[var1][var2] = var6;
         }
      }
   }

   static void f(M688 var0, U691 var1, boolean var2) {
      int var3 = var1.q.g();
      int var4;
      if (var2 && var1.q.j) {
         int var5 = var3 + var3 - var1.q.d;
         var4 = (int)((long)var0.i[var1.g] * (long)var5 >> 6);
         var3 <<= 8;
         if (var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            Cs635.bh(var1.n, true);
         }
      } else {
         var4 = (int)((long)var0.i[var1.g] * (long)var3 >> 6);
      }

      Cs635.bk(var1.n, var4);
   }

   private static void c(M688 var0, int var1, int var2, int var3) {
      U691 var4 = var0.f[var1][var2];
      if (var4 != null) {
         var0.f[var1][var2] = null;
         if ((var0.m[var1] & 2) != 0) {
            for(U691 var5 = (U691)Gx298.i(var0.az.j); var5 != null; var5 = (U691)Gx298.c(var0.az.j)) {
               if (var5.g == var4.g && var5.u < 0 && var5 != var4) {
                  var4.u = 0;
                  break;
               }
            }
         } else {
            var4.u = 0;
         }

      }
   }

   private static void ag(M688 var0, int var1, int var2, int var3) {
   }

   private static void ai(M688 var0, int var1, int var2) {
      var0.y[var1] = var2;
   }

   private static void al(M688 var0, int var1) {
      for(U691 var2 = (U691)Gx298.i(var0.az.j); var2 != null; var2 = (U691)Gx298.c(var0.az.j)) {
         if (var1 < 0 || var2.g == var1) {
            if (var2.n != null) {
               Cs635.bv(var2.n, Cd585.h / 100);
               if (Cs635.bm(var2.n)) {
                  var0.az.e.h(var2.n);
               }

               U691.g(var2);
            }

            if (var2.u < 0) {
               var0.f[var2.g][var2.h] = null;
            }

            U691.ef(var2);
         }
      }

   }

   protected synchronized int q() {
      return 0;
   }

   private static void ao(M688 var0, int var1) {
      if ((var0.m[var1] & 2) != 0) {
         for(U691 var2 = (U691)Gx298.i(var0.az.j); var2 != null; var2 = (U691)Gx298.c(var0.az.j)) {
            if (var2.g == var1 && var0.f[var1][var2.h] == null && var2.u < 0) {
               var2.u = 0;
            }
         }
      }

   }

   private static void af(M688 var0, int var1) {
      if (var1 >= 0) {
         var0.h[var1] = 12800;
         var0.s[var1] = 8192;
         var0.b[var1] = 16383;
         var0.y[var1] = 8192;
         var0.p[var1] = 0;
         var0.x[var1] = 8192;
         ao(var0, var1);
         aa(var0, var1);
         var0.m[var1] = 0;
         var0.n[var1] = 32767;
         var0.k[var1] = 256;
         var0.i[var1] = 0;
         am(var0, var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            af(var0, var1);
         }

      }
   }

   private static void an(M688 var0, int var1, boolean var2) {
      int var3 = var1 & 240;
      int var4;
      int var5;
      int var6;
      if (var3 == 128) {
         var4 = var1 & 15;
         var5 = var1 >> 8 & 127;
         var6 = var1 >> 16 & 127;
         c(var0, var4, var5, var6);
      } else if (var3 == 144) {
         var4 = var1 & 15;
         var5 = var1 >> 8 & 127;
         var6 = var1 >> 16 & 127;
         if (var6 > 0) {
            if (var2) {
               var0.a(var4, var5, var6);
            }
         } else {
            c(var0, var4, var5, 64);
         }

      } else if (var3 == 160) {
         var4 = var1 & 15;
         var5 = var1 >> 8 & 127;
         var6 = var1 >> 16 & 127;
         ag(var0, var4, var5, var6);
      } else if (var3 == 176) {
         var4 = var1 & 15;
         var5 = var1 >> 8 & 127;
         var6 = var1 >> 16 & 127;
         if (var5 == 0) {
            var0.v[var4] = (var0.v[var4] & -2080769) + (var6 << 14);
         }

         if (var5 == 32) {
            var0.v[var4] = (var0.v[var4] & -16257) + (var6 << 7);
         }

         if (var5 == 1) {
            var0.p[var4] = (var0.p[var4] & -16257) + (var6 << 7);
         }

         if (var5 == 33) {
            var0.p[var4] = (var0.p[var4] & -128) + var6;
         }

         if (var5 == 5) {
            var0.x[var4] = (var0.x[var4] & -16257) + (var6 << 7);
         }

         if (var5 == 37) {
            var0.x[var4] = (var0.x[var4] & -128) + var6;
         }

         if (var5 == 7) {
            var0.h[var4] = (var0.h[var4] & -16257) + (var6 << 7);
         }

         if (var5 == 39) {
            var0.h[var4] = (var0.h[var4] & -128) + var6;
         }

         if (var5 == 10) {
            var0.s[var4] = (var0.s[var4] & -16257) + (var6 << 7);
         }

         if (var5 == 42) {
            var0.s[var4] = (var0.s[var4] & -128) + var6;
         }

         if (var5 == 11) {
            var0.b[var4] = (var0.b[var4] & -16257) + (var6 << 7);
         }

         if (var5 == 43) {
            var0.b[var4] = (var0.b[var4] & -128) + var6;
         }

         int[] var10000;
         if (var5 == 64) {
            if (var6 >= 64) {
               var10000 = var0.m;
               var10000[var4] |= 1;
            } else {
               var10000 = var0.m;
               var10000[var4] &= -2;
            }
         }

         if (var5 == 20 && var0.aa != null) {
            var0.aa.g(var4, var6);
         }

         if (var5 == 65) {
            if (var6 >= 64) {
               var10000 = var0.m;
               var10000[var4] |= 2;
            } else {
               ao(var0, var4);
               var10000 = var0.m;
               var10000[var4] &= -3;
            }
         }

         if (var5 == 99) {
            var0.n[var4] = (var0.n[var4] & 127) + (var6 << 7);
         }

         if (var5 == 98) {
            var0.n[var4] = (var0.n[var4] & 16256) + var6;
         }

         if (var5 == 101) {
            var0.n[var4] = 16384 + (var0.n[var4] & 127) + (var6 << 7);
         }

         if (var5 == 100) {
            var0.n[var4] = 16384 + (var0.n[var4] & 16256) + var6;
         }

         if (var5 == 120) {
            al(var0, var4);
         }

         if (var5 == 121) {
            af(var0, var4);
         }

         if (var5 == 123) {
            av(var0, var4);
         }

         int var7;
         if (var5 == 6) {
            var7 = var0.n[var4];
            if (var7 == 16384) {
               var0.k[var4] = (var0.k[var4] & -16257) + (var6 << 7);
            }
         }

         if (var5 == 38) {
            var7 = var0.n[var4];
            if (var7 == 16384) {
               var0.k[var4] = (var0.k[var4] & -128) + var6;
            }
         }

         if (var5 == 16) {
            var0.i[var4] = (var0.i[var4] & -16257) + (var6 << 7);
         }

         if (var5 == 48) {
            var0.i[var4] = (var0.i[var4] & -128) + var6;
         }

         if (var5 == 81) {
            if (var6 >= 64) {
               var10000 = var0.m;
               var10000[var4] |= 4;
            } else {
               aa(var0, var4);
               var10000 = var0.m;
               var10000[var4] &= -5;
            }
         }

         if (var5 == 17) {
            am(var0, var4, (var0.o[var4] & -16257) + (var6 << 7));
         }

         if (var5 == 49) {
            am(var0, var4, (var0.o[var4] & -128) + var6);
         }

      } else if (var3 == 192) {
         var4 = var1 & 15;
         var5 = var1 >> 8 & 127;
         o(var0, var4, var0.v[var4] + var5);
      } else if (var3 == 208) {
         var4 = var1 & 15;
         var5 = var1 >> 8 & 127;
         aq(var0, var4, var5);
      } else if (var3 == 224) {
         var4 = var1 & 15;
         var5 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         ai(var0, var4, var5);
      } else {
         var3 = var1 & 255;
         if (var3 == 255) {
            ap(var0, true);
         }
      }
   }

   static void am(M688 var0, int var1, int var2) {
      var0.o[var1] = var2;
      var0.a[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   static boolean au(M688 var0, U691 var1, int[] var2, int var3, int var4) {
      var1.k = Cd585.h / 100;
      if (var1.u < 0 || var1.n != null && !Cs635.bp(var1.n)) {
         int var5 = var1.v;
         if (var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)var0.x[var1.g] * 4.921259842519685E-4D) + 0.5D);
            if (var5 < 0) {
               var5 = 0;
            }

            var1.v = var5;
         }

         Cs635.bf(var1.n, as(var0, var1));
         V686 var6 = var1.j;
         boolean var7 = false;
         ++var1.t;
         var1.m += var6.b;
         double var8 = (double)((var1.h - 60 << 8) + (var1.r * var1.v >> 12)) * 5.086263020833333E-6D;
         if (var6.q > 0) {
            if (var6.h > 0) {
               var1.y += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.h) + 0.5D);
            } else {
               var1.y += 128;
            }

            if (var1.y * var6.q >= 819200) {
               var7 = true;
            }
         }

         if (var6.g != null) {
            if (var6.j > 0) {
               var1.p += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.j) + 0.5D);
            } else {
               var1.p += 128;
            }

            while(var1.x < var6.g.length - 2 && var1.p > (var6.g[var1.x + 2] & 255) << 8) {
               var1.x += 2;
            }

            if (var1.x == var6.g.length - 2 && var6.g[var1.x + 1] == 0) {
               var7 = true;
            }
         }

         if (var1.u >= 0 && var6.d != null && (var0.m[var1.g] & 1) == 0 && (var1.e < 0 || var0.c[var1.g][var1.e] != var1)) {
            if (var6.e > 0) {
               var1.u += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.e) + 0.5D);
            } else {
               var1.u += 128;
            }

            while(var1.z < var6.d.length - 2 && var1.u > (var6.d[var1.z + 2] & 255) << 8) {
               var1.z += 2;
            }

            if (var1.z == var6.d.length - 2) {
               var7 = true;
            }
         }

         if (var7) {
            Cs635.bv(var1.n, var1.k);
            if (var2 != null) {
               var1.n.j(var2, var3, var4);
            } else {
               var1.n.e(var4);
            }

            if (Cs635.bm(var1.n)) {
               var0.az.e.h(var1.n);
            }

            U691.g(var1);
            if (var1.u >= 0) {
               U691.ef(var1);
               if (var1.e > 0 && var0.c[var1.g][var1.e] == var1) {
                  var0.c[var1.g][var1.e] = null;
               }
            }

            return true;
         } else {
            Cs635.br(var1.n, var1.k, ac(var0, var1), at(var0, var1));
            return false;
         }
      } else {
         U691.g(var1);
         U691.ef(var1);
         if (var1.e > 0 && var0.c[var1.g][var1.e] == var1) {
            var0.c[var1.g][var1.e] = null;
         }

         return true;
      }
   }

   private static int ac(M688 var0, U691 var1) {
      if (var0.e[var1.g] == 0) {
         return 0;
      } else {
         V686 var2 = var1.j;
         int var3 = var0.h[var1.g] * var0.b[var1.g] + 4096 >> 13;
         var3 = var3 * var3 + 16384 >> 15;
         var3 = var1.b * var3 + 16384 >> 15;
         var3 = var3 * var0.d + 128 >> 8;
         var3 = var3 * var0.q >> 8;
         var3 = var3 * var0.e[var1.g] + 128 >> 8;
         if (var2.q > 0) {
            var3 = (int)((double)var3 * Math.pow(0.5D, 1.953125E-5D * (double)var1.y * (double)var2.q) + 0.5D);
         }

         int var4;
         int var5;
         int var6;
         int var7;
         if (var2.g != null) {
            var4 = var1.p;
            var5 = var2.g[var1.x + 1];
            if (var1.x < var2.g.length - 2) {
               var6 = (var2.g[var1.x] & 255) << 8;
               var7 = (var2.g[var1.x + 2] & 255) << 8;
               var5 += (var2.g[var1.x + 3] - var5) * (var4 - var6) / (var7 - var6);
            }

            var3 = var3 * var5 + 32 >> 6;
         }

         if (var1.u > 0 && var2.d != null) {
            var4 = var1.u;
            var5 = var2.d[var1.z + 1];
            if (var1.z < var2.d.length - 2) {
               var6 = (var2.d[var1.z] & 255) << 8;
               var7 = (var2.d[var1.z + 2] & 255) << 8;
               var5 += (var2.d[var1.z + 3] - var5) * (var4 - var6) / (var7 - var6);
            }

            var3 = var3 * var5 + 32 >> 6;
         }

         return var3;
      }
   }

   public static synchronized void z(M688 var0, P689 var1, boolean var2, boolean var3) {
      n(var0, var3);
      var0.ag.g(var1.q);
      var0.aq = var2;
      var0.af = 0L;
      int var4 = Z693.j(var0.ag);

      for(int var5 = 0; var5 < var4; ++var5) {
         Z693.e(var0.ag, var5);
         Z693.b(var0.ag, var5);
         Z693.h(var0.ag, var5);
      }

      var0.ai = Z693.y(var0.ag);
      var0.al = var0.ag.s[var0.ai];
      var0.av = Z693.v(var0.ag, var0.al);
   }

   public static synchronized void v(M688 var0) {
      for(Y692 var1 = (Y692)Ha262.e(var0.g); var1 != null; var1 = (Y692)Ha262.h(var0.g)) {
         Y692.q(var1);
      }

   }

   protected synchronized Cx556 d() {
      return null;
   }

   public synchronized void j(int[] var1, int var2, int var3) {
      if (Z693.q(this.ag)) {
         int var4 = this.j * this.ag.q / Cd585.h;

         do {
            long var5 = this.af + (long)var4 * (long)var3;
            if (this.av - var5 >= 0L) {
               this.af = var5;
               break;
            }

            int var7 = (int)((this.av - this.af + (long)var4 - 1L) / (long)var4);
            this.af += (long)var4 * (long)var7;
            this.az.j(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            ar(this);
         } while(Z693.q(this.ag));
      }

      this.az.j(var1, var2, var3);
   }

   public synchronized void e(int var1) {
      if (Z693.q(this.ag)) {
         int var2 = this.j * this.ag.q / Cd585.h;

         do {
            long var3 = this.af + (long)var2 * (long)var1;
            if (this.av - var3 >= 0L) {
               this.af = var3;
               break;
            }

            int var5 = (int)((this.av - this.af + (long)var2 - 1L) / (long)var2);
            this.af += (long)var2 * (long)var5;
            this.az.e(var5);
            var1 -= var5;
            ar(this);
         } while(Z693.q(this.ag));
      }

      this.az.e(var1);
   }

   private static void ab(M688 var0, long var1) {
      while(true) {
         if (var0.av < var1) {
            boolean var3 = aw(var0);
            if (!var3) {
               continue;
            }

            return;
         }

         return;
      }
   }

   private static boolean aw(M688 var0) {
      boolean var1 = false;
      int var2 = var0.ai;
      int var3 = var0.al;
      long var4 = var0.av;

      label39:
      while(true) {
         if (!var1 && var3 == var0.al) {
            while(true) {
               if (var0.ag.s[var2] == var3) {
                  Z693.e(var0.ag, var2);
                  int var6 = var0.ag.l(var2);
                  if (var6 != 1) {
                     if ((var6 & 128) != 0) {
                        an(var0, var6, false);
                     }

                     Z693.b(var0.ag, var2);
                     Z693.h(var0.ag, var2);
                     continue;
                  }

                  Z693.s(var0.ag);
                  Z693.h(var0.ag, var2);
                  if (Z693.p(var0.ag)) {
                     if (!var0.aq || var3 == 0) {
                        ap(var0, true);
                        Z693.d(var0.ag);
                        return true;
                     }

                     Z693.x(var0.ag, var4);
                     var1 = true;
                     var0.al = 0;
                  }
               }

               var0.af = var4;
               var2 = Z693.y(var0.ag);
               var3 = var0.ag.s[var2];
               var4 = Z693.v(var0.ag, var3);
               continue label39;
            }
         }

         var0.ai = var2;
         var0.al = var3;
         var0.av = var4;
         return var1;
      }
   }

   private static void ar(M688 var0) {
      int var1 = var0.ai;
      int var2 = var0.al;
      long var3 = var0.av;
      if (var0.ah != null && var2 == var0.ap) {
         z(var0, var0.ah, var0.aq, var0.ao);
         ar(var0);
      } else {
         while(var2 == var0.al) {
            while(var0.ag.s[var1] == var2) {
               Z693.e(var0.ag, var1);
               int var5 = var0.ag.l(var1);
               if (var5 == 1) {
                  Z693.s(var0.ag);
                  Z693.h(var0.ag, var1);
                  if (Z693.p(var0.ag)) {
                     if (var0.ah != null) {
                        u(var0, var0.ah, var0.aq);
                        ar(var0);
                        return;
                     }

                     if (!var0.aq || var2 == 0) {
                        ap(var0, true);
                        Z693.d(var0.ag);
                        return;
                     }

                     Z693.x(var0.ag, var3);
                     var0.al = 0;
                  }
                  break;
               }

               if ((var5 & 128) != 0) {
                  an(var0, var5, true);
               }

               Z693.b(var0.ag, var1);
               Z693.h(var0.ag, var1);
            }

            var1 = Z693.y(var0.ag);
            var2 = var0.ag.s[var1];
            var3 = Z693.v(var0.ag, var2);
         }

         var0.ai = var1;
         var0.al = var2;
         var0.av = var3;
         if (var0.ah != null && var0.ap < var2) {
            var0.ai = -1;
            var0.al = var0.ap;
            var0.av = Z693.v(var0.ag, var0.al);
         }

      }
   }

   static boolean ax(M688 var0, U691 var1) {
      if (var1.n == null) {
         if (var1.u >= 0) {
            U691.ef(var1);
            if (var1.e > 0 && var0.c[var1.g][var1.e] == var1) {
               var0.c[var1.g][var1.e] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public M688() {
      this.g = new Ha262(128);
      s(this, -1, 256);
      ap(this, true);
   }

   private static void aa(M688 var0, int var1) {
      if ((var0.m[var1] & 4) != 0) {
         for(U691 var2 = (U691)Gx298.i(var0.az.j); var2 != null; var2 = (U691)Gx298.c(var0.az.j)) {
            if (var2.g == var1) {
               var2.o = 0;
            }
         }
      }

   }

   private static int as(M688 var0, U691 var1) {
      int var2 = var1.w + (var1.r * var1.v >> 12);
      var2 += (var0.y[var1.g] - 8192) * var0.k[var1.g] >> 12;
      V686 var3 = var1.j;
      int var4;
      if (var3.b > 0 && (var3.s > 0 || var0.p[var1.g] > 0)) {
         var4 = var3.s << 2;
         int var5 = var3.l << 1;
         if (var1.t < var5) {
            var4 = var4 * var1.t / var5;
         }

         var4 += var0.p[var1.g] >> 7;
         double var6 = Math.sin((double)(var1.m & 511) * 0.01227184630308513D);
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(256 * var1.q.g) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)Cd585.h + 0.5D);
      return var4 < 1 ? 1 : var4;
   }

   public static synchronized void u(M688 var0, P689 var1, boolean var2) {
      z(var0, var1, var2, true);
   }

   private static void o(M688 var0, int var1, int var2) {
      if (var2 != var0.r[var1]) {
         var0.r[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            var0.c[var1][var3] = null;
         }
      }

   }

   private static void aq(M688 var0, int var1, int var2) {
   }

   public static synchronized void s(M688 var0, int var1, int var2) {
      if (var1 < 0) {
         for(int var3 = 0; var3 < 16; ++var3) {
            var0.e[var3] = var2;
         }
      } else {
         var0.e[var1] = var2;
      }

   }

   private static void av(M688 var0, int var1) {
      for(U691 var2 = (U691)Gx298.i(var0.az.j); var2 != null; var2 = (U691)Gx298.c(var0.az.j)) {
         if ((var1 < 0 || var2.g == var1) && var2.u < 0) {
            var0.f[var2.g][var2.h] = null;
            var2.u = 0;
         }
      }

   }

   public static synchronized void h(M688 var0, int var1) {
      var0.d = var1;
   }

   protected synchronized Cx556 g() {
      return this.az;
   }
}
