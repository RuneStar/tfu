package com.jagex.game.runetek6.xelement;

enum Bx65 {
   UNKNOWN(-1),
   ANIMATIONS(1);

   public final int q;

   public static Bx65 g(int var0) {
      Bx65[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Bx65 var4 = var1[var3];
         if (var4.q == var0) {
            return var4;
         }
      }

      return UNKNOWN;
   }

   private Bx65(int var3) {
      this.q = var3;
   }
}
