package tfu;

public enum Hf380 {
   FRIENDSONLY(1),
   PUBLIC(0),
   OFF(2);

   public final int j;

   public static Hf380 g(int var0) {
      Hf380[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Hf380 var4 = var1[var3];
         if (var4.j == var0) {
            return var4;
         }
      }

      return null;
   }

   private Hf380(int var3) {
      this.j = var3;
   }
}
