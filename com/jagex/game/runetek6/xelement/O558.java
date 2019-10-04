package com.jagex.game.runetek6.xelement;

public enum O558 {
   HEIGHT_MAP(2, -1),
   MISC_PROPERTIES(1, 16),
   UNKNOWN(Integer.MAX_VALUE, -1),
   XML(254, -1);

   public final int e;
   public final int h;

   private O558(int var3, int var4) {
      this.e = var3;
      this.h = var4;
   }

   public static O558 g(int var0) {
      O558[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         O558 var4 = var1[var3];
         if (var4.e == var0) {
            return var4;
         }
      }

      return UNKNOWN;
   }
}
