package com.jagex.core.constants;

import java.util.EnumSet;

@Deprecated
public enum D123 implements J204 {
   INTBETA("INTBETA", 6, new G320[]{G320.HAS_EXTERNAL_ACCESS}),
   WTWIP("WTWIP", 3, new G320[]{G320.OFFICE}),
   WTQA("WTQA", 2, new G320[]{G320.OFFICE, G320.QA}),
   LOCAL("LOCAL", 4),
   WTQA2("WTQA2", 9, new G320[]{G320.OFFICE, G320.QA}),
   WTITU("WTITU", 8, new G320[]{G320.OFFICE, G320.HAS_EXTERNAL_ACCESS}),
   LIVE("LIVE", 0, new G320[]{G320.HAS_EXTERNAL_ACCESS}),
   WTI("WTI", 5, new G320[]{G320.OFFICE, G320.HAS_EXTERNAL_ACCESS}),
   WTRC("WTRC", 1, new G320[]{G320.OFFICE, G320.HAS_EXTERNAL_ACCESS});

   private static final D123[] w = values();
   private final EnumSet p = EnumSet.noneOf(G320.class);
   private final int r;
   private String v;
   /** @deprecated */
   private String y = "";

   private D123(String var3, int var4) {
      this.v = var3;
      this.r = var4;
   }

   private D123(String var3, int var4, G320... var5) {
      this.v = var3;
      this.r = var4;
      G320[] var6 = var5;
      int var7 = var5.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         G320 var9 = var6[var8];
         this.p.add(var9);
      }

   }

   public static boolean d(D123 var0, G320 var1) {
      return var0.p.contains(var1);
   }

   public int getId() {
      return this.r;
   }

   public String toString() {
      return this.name().toLowerCase() + this.y;
   }
}
