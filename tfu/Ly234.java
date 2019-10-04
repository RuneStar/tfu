package tfu;

import com.jagex.core.constants.J204;

public enum Ly234 implements J204 {
   LEGACY(-1, "legacy", "Legacy", true, new Ly234[]{RUNESCAPE, FUNORB, WAR_OF_LEGENDS, EIGHT_REALMS, STELLAR_DAWN}),
   FUNORB(1, "funorb", "Fun Orb"),
   EIGHT_REALMS(4, "8realms", "8 Realms"),
   RUNESCAPE(0, "runescape", "RuneScape"),
   TRANSFORMERS(5, "transformers", "Transformers Universe"),
   STELLAR_DAWN(3, "stellardawn", "Stellar Dawn"),
   WAR_OF_LEGENDS(2, "waroflegends", "War of Legends"),
   SCRATCH(6, "scratch", "Scratch");

   public final int l;
   public final String r;
   public final boolean v;
   public final String w;
   public final Ly234[] y;

   private Ly234(int var3, String var4, String var5) {
      this.l = var3;
      this.w = var4;
      this.r = var5;
      this.v = false;
      this.y = new Ly234[0];
   }

   public int getId() {
      return this.l;
   }

   public String toString() {
      return this.r;
   }

   private Ly234(int var3, String var4, String var5, boolean var6, Ly234[] var7) {
      this.l = var3;
      this.w = var4;
      this.r = var5;
      this.v = var6;
      this.y = var7;
   }
}
