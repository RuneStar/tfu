package tfu;

import com.jagex.core.stringtools.general.J173;

public class Mi507 {
   private Mi507() {
   }

   public static String d(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if ((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
            if (var4 == ' ') {
               var2.append('+');
            } else {
               byte var5 = J173.g(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if (var6 >= 10) {
                  var2.append((char)(55 + var6));
               } else {
                  var2.append((char)(48 + var6));
               }

               var6 = var5 & 15;
               if (var6 >= 10) {
                  var2.append((char)(55 + var6));
               } else {
                  var2.append((char)(48 + var6));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   public static String g(String var0) {
      StringBuilder var1 = new StringBuilder();
      int var2 = var0.length();

      for(int var3 = 0; var3 < var2; ++var3) {
         char var4 = var0.charAt(var3);
         if (var4 == '%' && var2 > var3 + 2) {
            var4 = var0.charAt(var3 + 1);
            boolean var5 = false;
            int var6;
            if (var4 >= '0' && var4 <= '9') {
               var6 = var4 - 48;
            } else if (var4 >= 'a' && var4 <= 'f') {
               var6 = 10 + var4 - 97;
            } else {
               if (var4 < 'A' || var4 > 'F') {
                  var1.append('%');
                  continue;
               }

               var6 = 10 + var4 - 65;
            }

            var6 *= 16;
            var4 = var0.charAt(var3 + 2);
            if (var4 >= '0' && var4 <= '9') {
               var6 += var4 - 48;
            } else if (var4 >= 'a' && var4 <= 'f') {
               var6 += 10 + var4 - 97;
            } else {
               if (var4 < 'A' || var4 > 'F') {
                  var1.append('%');
                  continue;
               }

               var6 += 10 + var4 - 65;
            }

            if (var6 != 0 && J173.d((byte)var6)) {
               var1.append(J173.q((byte)var6));
            }

            var3 += 2;
         } else if (var4 == '+') {
            var1.append(' ');
         } else {
            var1.append(var4);
         }
      }

      return var1.toString();
   }
}
