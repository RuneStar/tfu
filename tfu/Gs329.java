package tfu;

public class Gs329 extends Gg3 {
   private static final int[] d = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   private Ic327 g;
   private int j;
   private int q;

   public static void h(Gs329 var0) {
      var0.j = var0.v * 8;
   }

   public Gs329(byte[] var1) {
      super(var1);
   }

   public static void g(Gs329 var0, Ic327 var1) {
      var0.g = var1;
   }

   public static void d(Gs329 var0, int var1) {
      var0.r[var0.v++] = (byte)(var1 + Ic327.d(var0.g));
   }

   public static void e(Gs329 var0, byte[] var1, int var2, int var3) {
      for(int var4 = 0; var4 < var3; ++var4) {
         var1[var4 + var2] = (byte)(var0.r[var0.v++] - Ic327.d(var0.g));
      }

   }

   public static int j(Gs329 var0) {
      int var1 = var0.r[var0.v++] - Ic327.d(var0.g) & 255;
      return var1 < 128 ? var1 : (var1 - 128 << 8) + (var0.r[var0.v++] - Ic327.d(var0.g) & 255);
   }

   public Gs329(int var1) {
      super(var1);
   }

   public static void b(Gs329 var0) {
      var0.v = (var0.j + 7) / 8;
   }

   public int s(int var1) {
      if (var1 > 32) {
         throw new IllegalArgumentException();
      } else {
         int var2 = this.j >> 3;
         int var3 = 8 - (this.j & 7);
         int var4 = 0;

         for(this.j += var1; var1 > var3; var3 = 8) {
            var4 += (super.r[var2++] & d[var3]) << var1 - var3;
            var1 -= var3;
         }

         if (var1 == var3) {
            var4 += super.r[var2] & d[var3];
         } else {
            var4 += super.r[var2] >> var3 - var1 & d[var1];
         }

         return var4;
      }
   }

   public static boolean q(Gs329 var0) {
      int var1 = var0.r[var0.v] - Ic327.q(var0.g) & 255;
      return var1 >= 128;
   }
}
