package tfu;

public class Cz584 {
   private static final int d = 14;
   private static final boolean g = true;
   private static final int j = 6;
   private static final int q = 7;
   private int e;
   private int h;
   private int[][] s;

   public Cz584(int var1, int var2) {
      if (var1 != var2) {
         if (var2 > var1) {
            throw new IllegalArgumentException("decimator is designed to reduce the sampling frequency - it will sound horrible trying to increase it - oldfreq=" + var1 + " newfreq=" + var2);
         } else {
            int var3 = Jz233.d(var1, var2);
            var1 /= var3;
            var2 /= var3;
            this.e = var1;
            this.h = var2;
            this.s = new int[var1][14];

            for(int var4 = 0; var4 < var1; ++var4) {
               int[] var5 = this.s[var4];
               double var6 = 6.0D + (double)var4 / (double)var1;
               int var8 = (int)Math.floor(var6 - 7.0D + 1.0D);
               if (var8 < 0) {
                  var8 = 0;
               }

               int var9 = (int)Math.ceil(var6 + 7.0D);
               if (var9 > 14) {
                  var9 = 14;
               }

               for(double var10 = (double)var2 / (double)var1; var8 < var9; ++var8) {
                  double var12 = ((double)var8 - var6) * 3.141592653589793D;
                  double var14 = var10;
                  if (var12 < -1.0E-4D || var12 > 1.0E-4D) {
                     var14 = var10 * (Math.sin(var12) / var12);
                  }

                  var14 *= 0.54D + 0.46D * Math.cos(((double)var8 - var6) * 0.2243994752564138D);
                  var5[var8] = (int)Math.floor(var14 * 65536.0D + 0.5D);
               }
            }

         }
      }
   }
}
