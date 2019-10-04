package com.jagex.game.runetek6.xelement;

public enum Bv116 {
   POSITION(4, 12),
   SUPER_TYPE_PROPERTIES(255, -1),
   ATTACHMENT_POINT(1, -1),
   UNKNOWN(Integer.MAX_VALUE, -1),
   SCALE(6, 4),
   ORIENTATION(5, 16);

   public final int b;
   public final int s;

   public static Bv116 g(int var0) {
      Bv116[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Bv116 var4 = var1[var3];
         if (var4.s == var0) {
            return var4;
         }
      }

      return UNKNOWN;
   }

   private Bv116(int var3, int var4) {
      this.s = var3;
      this.b = var4;
   }
}
