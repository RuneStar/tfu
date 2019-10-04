package tfu;

public class Ic327 {
   private static final int d = 256;
   private static final int g = 8;
   private static final int q = 1020;
   private int b;
   private int[] e;
   private int[] h;
   private int j;
   private int l;
   private int s;

   private static final void j(Ic327 var0) {
      var0.b += ++var0.l;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = var0.h[var1];
         if ((var1 & 2) == 0) {
            if ((var1 & 1) == 0) {
               var0.s ^= var0.s << 13;
            } else {
               var0.s ^= var0.s >>> 6;
            }
         } else if ((var1 & 1) == 0) {
            var0.s ^= var0.s << 2;
         } else {
            var0.s ^= var0.s >>> 16;
         }

         var0.s += var0.h[var1 + 128 & 255];
         int var3;
         var0.h[var1] = var3 = var0.h[(var2 & 1020) >> 2] + var0.s + var0.b;
         var0.e[var1] = var0.b = var0.h[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   public Ic327(int[] var1) {
      this.h = new int[256];
      this.e = new int[256];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.e[var2] = var1[var2];
      }

      e(this);
   }

   public static int d(Ic327 var0) {
      return g(var0);
   }

   public static int q(Ic327 var0) {
      if (var0.j == 0) {
         j(var0);
         var0.j = 256;
      }

      return var0.e[var0.j - 1];
   }

   private Ic327() {
   }

   private static final void e(Ic327 var0) {
      int var9 = -1640531527;
      int var8 = -1640531527;
      int var7 = -1640531527;
      int var6 = -1640531527;
      int var5 = -1640531527;
      int var4 = -1640531527;
      int var3 = -1640531527;
      int var2 = -1640531527;

      int var1;
      for(var1 = 0; var1 < 4; ++var1) {
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += var0.e[var1];
         var3 += var0.e[var1 + 1];
         var4 += var0.e[var1 + 2];
         var5 += var0.e[var1 + 3];
         var6 += var0.e[var1 + 4];
         var7 += var0.e[var1 + 5];
         var8 += var0.e[var1 + 6];
         var9 += var0.e[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         var0.h[var1] = var2;
         var0.h[var1 + 1] = var3;
         var0.h[var1 + 2] = var4;
         var0.h[var1 + 3] = var5;
         var0.h[var1 + 4] = var6;
         var0.h[var1 + 5] = var7;
         var0.h[var1 + 6] = var8;
         var0.h[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += var0.h[var1];
         var3 += var0.h[var1 + 1];
         var4 += var0.h[var1 + 2];
         var5 += var0.h[var1 + 3];
         var6 += var0.h[var1 + 4];
         var7 += var0.h[var1 + 5];
         var8 += var0.h[var1 + 6];
         var9 += var0.h[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         var0.h[var1] = var2;
         var0.h[var1 + 1] = var3;
         var0.h[var1 + 2] = var4;
         var0.h[var1 + 3] = var5;
         var0.h[var1 + 4] = var6;
         var0.h[var1 + 5] = var7;
         var0.h[var1 + 6] = var8;
         var0.h[var1 + 7] = var9;
      }

      j(var0);
      var0.j = 256;
   }

   private static final int g(Ic327 var0) {
      if (var0.j == 0) {
         j(var0);
         var0.j = 256;
      }

      return var0.e[--var0.j];
   }
}
