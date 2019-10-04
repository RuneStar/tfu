package com.jagex.core.stringtools.general;

import tfu.Bs1;

@Bs1
public final class StringTools {
   public static String x(byte[] var0) {
      if (var0 == null) {
         return "";
      } else {
         String var1 = "";
         byte[] var2 = var0;
         int var3 = var0.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            byte var5 = var2[var4];
            if (var5 < 128 && var5 >= 32) {
               var1 = var1 + Character.toChars(var5)[0];
            } else {
               var1 = var1 + ".";
            }
         }

         return var1;
      }
   }

   public static boolean d(CharSequence var0) {
      return q(var0, 10, true);
   }

   public static boolean q(CharSequence var0, int var1, boolean var2) {
      if (var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if (var7 == 0) {
               if (var8 == '-') {
                  var3 = true;
                  continue;
               }

               if (var8 == '+' && var2) {
                  continue;
               }
            }

            int var10;
            if (var8 >= '0' && var8 <= '9') {
               var10 = var8 - 48;
            } else if (var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - 55;
            } else {
               if (var8 < 'a' || var8 > 'z') {
                  return false;
               }

               var10 = var8 - 87;
            }

            if (var10 >= var1) {
               return false;
            }

            if (var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if (var9 / var1 != var5) {
               return false;
            }

            var5 = var9;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("Invalid radix:" + var1);
      }
   }

   public static int j(CharSequence var0) {
      return h(var0, 10, true);
   }

   /** @deprecated */
   public static int b(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + J173.g(var0.charAt(var3));
      }

      return var2;
   }

   public static boolean w(char var0) {
      return var0 >= '0' && var0 <= '9';
   }

   public static boolean r(char var0) {
      return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }

   public static String v(String var0, char var1, String var2) {
      int var3 = var0.length();
      int var4 = var2.length();
      int var5 = var3;
      int var6 = var4 - 1;
      if (var6 != 0) {
         int var7 = 0;

         while(true) {
            var7 = var0.indexOf(var1, var7);
            if (var7 < 0) {
               break;
            }

            ++var7;
            var5 += var6;
         }
      }

      StringBuilder var10 = new StringBuilder(var5);
      int var8 = 0;

      while(true) {
         int var9 = var0.indexOf(var1, var8);
         if (var9 < 0) {
            var10.append(var0.substring(var8));
            return var10.toString();
         }

         var10.append(var0.substring(var8, var9));
         var10.append(var2);
         var8 = var9 + 1;
      }
   }

   public static String[] p(String var0, char var1) {
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < var0.length(); ++var3) {
         if (var0.charAt(var3) == var1) {
            ++var2;

            while(var3 < var0.length() && var0.charAt(var3) == var1) {
               ++var3;
            }
         }
      }

      String[] var4 = new String[var2 + 1];
      int var5 = 0;
      int var6 = 0;

      for(var3 = 0; var3 < var2; ++var3) {
         int var7;
         for(var7 = var6; var0.charAt(var7) != var1; ++var7) {
         }

         var4[var5++] = var0.substring(var6, var7);

         for(var6 = var7 + 1; var0.charAt(var6) == var1; ++var6) {
         }
      }

      var4[var2] = var0.substring(var6);
      return var4;
   }

   public static int l(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   private static boolean u(String var0, String var1, int var2, int var3) {
      int var4 = var0.length();

      int var5;
      for(var5 = var1.length(); var2 < var4 && var3 < var5; ++var3) {
         char var6 = var0.charAt(var2);
         char var7 = var1.charAt(var3);
         if (var6 == '*') {
            if (var2 == var4 - 1) {
               return true;
            }

            for(int var8 = var3; var8 < var5; ++var8) {
               if (u(var0, var1, var2 + 1, var8)) {
                  return true;
               }
            }

            return false;
         }

         if (var6 != '?' && var6 != var7) {
            return false;
         }

         ++var2;
      }

      return var2 == var4 && var3 == var5;
   }

   public static int e(CharSequence var0, int var1) {
      return h(var0, var1, true);
   }

   public static int g(CharSequence var0, char var1) {
      int var2 = 0;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         if (var0.charAt(var4) == var1) {
            ++var2;
         }
      }

      return var2;
   }

   private StringTools() {
   }

   public static String[] y(String var0, char var1) {
      int var2 = g(var0, var1);
      String[] var3 = new String[var2 + 1];
      int var4 = 0;
      int var5 = 0;

      for(int var6 = 0; var6 < var2; ++var6) {
         int var7;
         for(var7 = var5; var0.charAt(var7) != var1; ++var7) {
         }

         var3[var4++] = var0.substring(var5, var7);
         var5 = var7 + 1;
      }

      var3[var2] = var0.substring(var5);
      return var3;
   }

   public static int h(CharSequence var0, int var1, boolean var2) {
      if (var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if (var7 == 0) {
               if (var8 == '-') {
                  var3 = true;
                  continue;
               }

               if (var8 == '+' && var2) {
                  continue;
               }
            }

            int var10;
            if (var8 >= '0' && var8 <= '9') {
               var10 = var8 - 48;
            } else if (var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - 55;
            } else {
               if (var8 < 'a' || var8 > 'z') {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if (var10 >= var1) {
               throw new NumberFormatException();
            }

            if (var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if (var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if (!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("Invalid radix:" + var1);
      }
   }

   public static String s(int var0, int var1, boolean var2) {
      if (var1 >= 2 && var1 <= 36) {
         if (var2 && var0 >= 0) {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = '+';

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var0 * var1;
               if (var8 >= 10) {
                  var5[var6] = (char)(87 + var8);
               } else {
                  var5[var6] = (char)(48 + var8);
               }
            }

            return new String(var5);
         } else {
            return Integer.toString(var0, var1);
         }
      } else {
         throw new IllegalArgumentException("Invalid radix:" + var1);
      }
   }
}
