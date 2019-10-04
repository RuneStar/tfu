package tfu;

import com.jagex.core.stringtools.general.StringTools;

public class Md230 {
   /** @deprecated */
   public static final int d = 12;
   private static Ly234 e = null;
   public static final int g = 1;
   private static final char[] j = new char[]{'[', ']', '#'};
   public static final char[] q = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};

   public static final int g(Ly234 var0) {
      // $FF: Couldn't be decompiled
   }

   public static final boolean d(char var0) {
      if (Character.isISOControl(var0)) {
         return false;
      } else if (StringTools.r(var0)) {
         return true;
      } else {
         char[] var1 = q;
         int var2 = var1.length;

         int var3;
         char var4;
         for(var3 = 0; var3 < var2; ++var3) {
            var4 = var1[var3];
            if (var0 == var4) {
               return true;
            }
         }

         var1 = j;
         var2 = var1.length;

         for(var3 = 0; var3 < var2; ++var3) {
            var4 = var1[var3];
            if (var0 == var4) {
               return true;
            }
         }

         return false;
      }
   }

   /** @deprecated */
   public static String j(CharSequence var0) {
      return e(var0, (Ly234)null);
   }

   public static String e(CharSequence var0, Ly234 var1) {
      if (var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && q(var0.charAt(var2)); ++var2) {
         }

         while(var3 > var2 && q(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if (var4 >= 1 && var4 <= g(var1)) {
            StringBuilder var5 = new StringBuilder(var4);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               if (d(var7)) {
                  char var8 = h(var7);
                  if (var8 != 0) {
                     var5.append(var8);
                  }
               }
            }

            if (var5.length() == 0) {
               return null;
            } else {
               return var5.toString();
            }
         } else {
            return null;
         }
      }
   }

   public static char h(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }

   public static final boolean q(char var0) {
      return var0 == 160 || var0 == ' ' || var0 == '_' || var0 == '-';
   }
}
