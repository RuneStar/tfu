package com.jagex.core.constants;

import java.util.Locale;
import tfu.Bs1;

@Q269(8)
@Bs1
public enum Language implements J204 {
   DE("de", "German", D123.LIVE, 1, "DE"),
   NL("nl", "Dutch", D123.WTWIP, 4, "NL"),
   EN("en", "English", D123.LIVE, 0, "GB"),
   ES("es", "Spanish", D123.LIVE, 5, "ES"),
   PT("pt", "Portuguese", D123.LIVE, 3, "BR"),
   FR("fr", "French", D123.LIVE, 2, "FR"),
   ES_MX("es-mx", "Spanish (Latin American)", D123.WTWIP, 6, "MX");

   public static final int b = 7;
   private static final Language[] p;
   private final String l;
   private final D123 r;
   public final int v;
   private final String w;
   private final Locale y;

   private Language(String var3, String var4, D123 var5, int var6, String var7) {
      this.l = var3;
      this.w = var4;
      this.r = var5;
      this.v = var6;
      if (var7 != null) {
         this.y = new Locale(var3.substring(0, 2), var7);
      } else {
         this.y = new Locale(var3.substring(0, 2));
      }

   }

   public static Language q(String var0) {
      String var1 = var0.toLowerCase(Locale.ENGLISH);
      Language[] var2 = p;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Language var5 = var2[var4];
         if (var5 != null && d(var5).equals(var1)) {
            return var5;
         }
      }

      return null;
   }

   public static String d(Language var0) {
      return var0.l;
   }

   public int getId() {
      return this.v;
   }

   public static Language j(int var0) {
      return var0 >= 0 && var0 < p.length ? p[var0] : null;
   }

   public String toString() {
      return d(this).toLowerCase(Locale.ENGLISH);
   }

   static {
      Language[] var0 = values();
      p = new Language[var0.length];
      Language[] var1 = var0;
      int var2 = var0.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Language var4 = var1[var3];
         if (p[var4.v] != null) {
            throw new IllegalStateException("Clashing IDs for " + p[var4.v] + " and " + var4);
         }

         p[var4.v] = var4;
      }

   }
}
