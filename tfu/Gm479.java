package tfu;

public enum Gm479 {
   BUILDLIVE("BUILDLIVE", 3),
   INTBETA("INTBETA", 4),
   LIVE("LIVE", 0),
   WIP("WIP", 2),
   RC("RC", 1);

   public final String h;
   public final int s;

   public static Gm479 g(int var0) {
      Gm479[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Gm479 var4 = var1[var3];
         if (var4.s == var0) {
            return var4;
         }
      }

      return null;
   }

   private Gm479(String var3, int var4) {
      this.h = var3;
      this.s = var4;
   }
}
