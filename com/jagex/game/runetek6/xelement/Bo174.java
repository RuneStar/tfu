package com.jagex.game.runetek6.xelement;

public enum Bo174 {
   COLOUR(2, 12),
   RADIUS(1, 4),
   UNKNOWN(Integer.MAX_VALUE, -1),
   SUPER_TYPE_PROPERTIES(255, -1);

   public final int e;
   public final int h;

   private Bo174(int var3, int var4) {
      this.e = var3;
      this.h = var4;
   }

   public static Bo174 g(int var0) {
      Bo174[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Bo174 var4 = var1[var3];
         if (var4.e == var0) {
            return var4;
         }
      }

      return UNKNOWN;
   }
}
