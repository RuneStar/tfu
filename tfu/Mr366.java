package tfu;

public final class Mr366 {
   private int[] g;

   public static int g(Mr366 var0, int var1) {
      int var2 = (var0.g.length >> 1) - 1;
      int var3 = var1 & var2;

      while(true) {
         int var4 = var0.g[var3 + var3 + 1];
         if (var4 == -1) {
            return -1;
         }

         if (var0.g[var3 + var3] == var1) {
            return var4;
         }

         var3 = var3 + 1 & var2;
      }
   }

   public Mr366(int[] var1) {
      int var2;
      for(var2 = 1; var2 <= var1.length + (var1.length >> 1); var2 <<= 1) {
      }

      this.g = new int[var2 + var2];

      int var3;
      for(var3 = 0; var3 < var2 + var2; ++var3) {
         this.g[var3] = -1;
      }

      int var4;
      for(var3 = 0; var3 < var1.length; this.g[var4 + var4 + 1] = var3++) {
         for(var4 = var1[var3] & var2 - 1; this.g[var4 + var4 + 1] != -1; var4 = var4 + 1 & var2 - 1) {
         }

         this.g[var4 + var4] = var1[var3];
      }

   }
}
