package tfu;

public enum Gd27 {
   STELLARDAWN("stellardawn", "Stellar Dawn", 1, Ly234.STELLAR_DAWN),
   SCRATCH("scratch", "Scratch", 4, Ly234.SCRATCH),
   RUNESCAPE("runescape", "RuneScape", 0, Ly234.RUNESCAPE),
   TRANSFORMERS("transformers", "Transformers", 3, Ly234.TRANSFORMERS),
   ALTERNATEREALITY("alternatereality", "AlternateReality", 2, Ly234.RUNESCAPE);

   public final int b;
   public final String h;
   public final Ly234 l;
   public final String s;

   public static Gd27 g(int var0) {
      Gd27[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Gd27 var4 = var1[var3];
         if (var4.b == var0) {
            return var4;
         }
      }

      return null;
   }

   private Gd27(String var3, String var4, int var5, Ly234 var6) {
      this.h = var3;
      this.s = var4;
      this.b = var5;
      this.l = var6;
   }
}
