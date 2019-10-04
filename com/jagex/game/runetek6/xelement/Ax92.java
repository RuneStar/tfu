package com.jagex.game.runetek6.xelement;

public enum Ax92 {
   LIGHTS(2, -1),
   ELEMENTS(1, -1),
   PARTICLE_SYSTEMS(3, -1);

   public final int e;
   public final int j;

   private Ax92(int var3, int var4) {
      this.j = var3;
      this.e = var4;
   }

   public static Ax92 g(int var0) {
      Ax92[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Ax92 var4 = var1[var3];
         if (var4.j == var0) {
            return var4;
         }
      }

      return null;
   }
}
