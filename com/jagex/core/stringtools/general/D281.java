package com.jagex.core.stringtools.general;

import com.jagex.core.constants.Language;

public class D281 {
   private static final String[] d = new String[]{" B", " KiB", " MiB", " GiB", " TiB", " PiB", " EiB"};
   public static final int e = 2;
   private static final String g = " ";
   public static final int j = 1;
   public static final int q = 0;

   private D281() {
   }

   public static String g(long var0, int var2, boolean var3, Language var4) {
      char var5 = ',';
      char var6 = '.';
      if (var4 == Language.EN) {
         var5 = '.';
         var6 = ',';
      }

      if (var4 == Language.FR) {
         var6 = 160;
      }

      boolean var7 = false;
      if (var0 < 0L) {
         var7 = true;
         var0 = -var0;
      }

      StringBuilder var8 = new StringBuilder(26);
      int var9;
      int var10;
      if (var2 > 0) {
         for(var9 = 0; var9 < var2; ++var9) {
            var10 = (int)var0;
            var0 /= 10L;
            var8.append((char)(48 + var10 - (int)var0 * 10));
         }

         var8.append(var5);
      }

      var9 = 0;

      while(true) {
         var10 = (int)var0;
         var0 /= 10L;
         var8.append((char)(48 + var10 - (int)var0 * 10));
         if (var0 == 0L) {
            if (var7) {
               var8.append('-');
            }

            return var8.reverse().toString();
         }

         if (var3) {
            ++var9;
            if (var9 % 3 == 0) {
               var8.append(var6);
            }
         }
      }
   }
}
