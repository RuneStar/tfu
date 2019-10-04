package com.jagex.game.runetek6.xelement;

public enum H89 {
   SUPER_TYPE_PROPERTIES(255, -1),
   SYSTEM_NAME(1, -1),
   UNKNOWN(Integer.MAX_VALUE, -1);

   public final int e;
   public final int j;

   public static H89 g(int var0) {
      H89[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         H89 var4 = var1[var3];
         if (var4.j == var0) {
            return var4;
         }
      }

      return UNKNOWN;
   }

   private H89(int var3, int var4) {
      this.j = var3;
      this.e = var4;
   }
}
