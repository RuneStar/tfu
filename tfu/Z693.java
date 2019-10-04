package tfu;

public class Z693 {
   private static final boolean g = true;
   public static final int p = 1;
   public static final int u = 3;
   private static final byte[] v = new byte[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
   public static final int w = 500000;
   public static final int x = 2;
   public static final int y = 0;
   private int[] b;
   public Gg3 d = new Gg3((byte[])null);
   private int[] e;
   private int[] h;
   private int[] j;
   public int l;
   public int q;
   private long r;
   public int[] s;

   public static void x(Z693 var0, long var1) {
      var0.r = var1;
      int var3 = var0.h.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         var0.s[var4] = 0;
         var0.b[var4] = 0;
         var0.d.v = var0.j[var4];
         b(var0, var4);
         var0.h[var4] = var0.d.v;
      }

   }

   public static boolean q(Z693 var0) {
      return var0.d.r != null;
   }

   public static int j(Z693 var0) {
      return var0.h.length;
   }

   private int w(int var1) {
      byte var2 = this.d.r[this.d.v];
      int var5;
      if (var2 < 0) {
         var5 = var2 & 255;
         this.b[var1] = var5;
         ++this.d.v;
      } else {
         var5 = this.b[var1];
         if (var5 == 0) {
            throw new RuntimeException();
         }
      }

      if (var5 != 240 && var5 != 247) {
         return r(this, var1, var5);
      } else {
         int var3 = Gg3.bn(this.d);
         if (var5 == 247 && var3 > 0) {
            int var4 = this.d.r[this.d.v] & 255;
            if (var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.d.v;
               this.b[var1] = var4;
               return r(this, var1, var4);
            }
         }

         Gg3 var10000 = this.d;
         var10000.v += var3;
         return 0;
      }
   }

   public Z693() {
   }

   public static void e(Z693 var0, int var1) {
      var0.d.v = var0.h[var1];
   }

   public static void h(Z693 var0, int var1) {
      var0.h[var1] = var0.d.v;
   }

   public static void b(Z693 var0, int var1) {
      int var2 = Gg3.bn(var0.d);
      int[] var10000 = var0.s;
      var10000[var1] += var2;
   }

   public void g(byte[] var1) {
      this.d.r = var1;
      this.d.v = 0;
      if (Gg3.bd(this.d) != 1297377380) {
         throw new RuntimeException();
      } else if (Gg3.bd(this.d) != 6) {
         throw new RuntimeException();
      } else {
         int var3 = Gg3.au(this.d);
         if (var3 >= 2) {
            throw new RuntimeException();
         } else {
            int var2 = Gg3.au(this.d);
            if (var2 == 0 || var3 == 0 && var2 > 1) {
               throw new RuntimeException();
            } else {
               this.q = Gg3.au(this.d);
               this.l = 500000;
               if (this.q >= 32768) {
                  throw new RuntimeException();
               } else {
                  this.j = new int[var2];
                  this.e = new int[var2];

                  Gg3 var10000;
                  int var5;
                  for(var3 = 0; var3 < var2; var10000.v += var5) {
                     if (this.d.v + 8 > this.d.r.length) {
                        throw new RuntimeException();
                     }

                     int var4 = Gg3.bd(this.d);
                     var5 = Gg3.bd(this.d);
                     if (this.d.v + var5 > this.d.r.length) {
                        throw new RuntimeException();
                     }

                     if (var4 == 1297379947) {
                        this.j[var3] = this.d.v;
                        this.e[var3] = this.d.v + var5;
                        ++var3;
                     }

                     var10000 = this.d;
                  }

                  this.r = 0L;
                  this.h = new int[var2];

                  for(var3 = 0; var3 < var2; ++var3) {
                     this.h[var3] = this.j[var3];
                  }

                  this.s = new int[var2];
                  this.b = new int[var2];
               }
            }
         }
      }
   }

   public static void s(Z693 var0) {
      var0.d.v = -1;
   }

   private static int r(Z693 var0, int var1, int var2) {
      int var4;
      if (var2 == 255) {
         int var7 = Gg3.ar(var0.d);
         var4 = Gg3.bn(var0.d);
         Gg3 var10000;
         if (var7 == 47) {
            var10000 = var0.d;
            var10000.v += var4;
            return 1;
         } else if (var7 == 81) {
            int var5 = Gg3.ay(var0.d);
            var4 -= 3;
            int var6 = var0.s[var1];
            var0.r += (long)var6 * (long)(var0.l - var5);
            var0.l = var5;
            var10000 = var0.d;
            var10000.v += var4;
            return 2;
         } else {
            var10000 = var0.d;
            var10000.v += var4;
            return 3;
         }
      } else {
         byte var3 = v[var2 - 128];
         var4 = var2;
         if (var3 >= 1) {
            var4 = var2 | Gg3.ar(var0.d) << 8;
         }

         if (var3 >= 2) {
            var4 |= Gg3.ar(var0.d) << 16;
         }

         return var4;
      }
   }

   public static long v(Z693 var0, int var1) {
      return var0.r + (long)var1 * (long)var0.l;
   }

   public static int y(Z693 var0) {
      int var1 = var0.h.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if (var0.h[var4] >= 0 && var0.s[var4] < var3) {
            var2 = var4;
            var3 = var0.s[var4];
         }
      }

      return var2;
   }

   public static boolean p(Z693 var0) {
      int var1 = var0.h.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if (var0.h[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   public Z693(byte[] var1) {
      this.g(var1);
   }

   public int l(int var1) {
      int var2 = this.w(var1);
      if (this.d.v > this.e[var1]) {
         throw new RuntimeException();
      } else {
         return var2;
      }
   }

   public static void d(Z693 var0) {
      var0.d.r = null;
      var0.j = null;
      var0.e = null;
      var0.h = null;
      var0.s = null;
      var0.b = null;
   }
}
