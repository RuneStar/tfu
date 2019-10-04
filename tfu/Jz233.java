package tfu;

import java.util.Random;

public class Jz233 {
   private static final Object d = new Object();
   private static Random g;
   private static final String[] q = new String[]{"", "0", "00", "000", "0000", "00000"};

   public static int j(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   public static boolean h(int var0) {
      return (var0 & -var0) == var0;
   }

   public static int s(int var0) {
      int var1 = 0;
      if (var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if (var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if (var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if (var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if (var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var1 + var0;
   }

   public static int b(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }

   public static int l(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }

   public static int w(int var0, int var1) {
      int var2 = var0 >> 31 & var1 - 1;
      return (var0 + (var0 >>> 31)) % var1 + var2;
   }

   public static int r(Random var0, int var1) {
      if (var0 == null) {
         var0 = g;
         if (var0 == null) {
            Object var2 = d;
            synchronized(var2) {
               if (g == null) {
                  g = new Random();
               }

               var0 = g;
            }
         }
      }

      if (var1 <= 0) {
         throw new IllegalArgumentException();
      } else if (h(var1)) {
         return (int)(((long)var0.nextInt() & 4294967295L) * (long)var1 >> 32);
      } else {
         int var5 = Integer.MIN_VALUE - (int)(4294967296L % (long)var1);

         int var3;
         do {
            var3 = var0.nextInt();
         } while(var3 >= var5);

         return w(var3, var1);
      }
   }

   public static int e(int var0) {
      int var1 = var0 >>> 1;
      var1 |= var1 >>> 1;
      var1 |= var1 >>> 2;
      var1 |= var1 >>> 4;
      var1 |= var1 >>> 8;
      var1 |= var1 >>> 16;
      return var0 & ~var1;
   }

   public static int g(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if ((var1 & 1) != 0) {
            var2 *= var0;
         }

         var0 *= var0;
      }

      if (var1 == 1) {
         return var2 * var0;
      } else {
         return var2;
      }
   }

   public static int d(int var0, int var1) {
      int var2;
      if (var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }
}
