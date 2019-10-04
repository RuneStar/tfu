package com.jagex.core.stringtools.general;

public class J173 {
   private static final char[] g = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};

   public static byte[] j(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if ((var4 <= 0 || var4 >= 128) && (var4 < 160 || var4 > 255)) {
            if (var4 == 8364) {
               var2[var3] = -128;
            } else if (var4 == 8218) {
               var2[var3] = -126;
            } else if (var4 == 402) {
               var2[var3] = -125;
            } else if (var4 == 8222) {
               var2[var3] = -124;
            } else if (var4 == 8230) {
               var2[var3] = -123;
            } else if (var4 == 8224) {
               var2[var3] = -122;
            } else if (var4 == 8225) {
               var2[var3] = -121;
            } else if (var4 == 710) {
               var2[var3] = -120;
            } else if (var4 == 8240) {
               var2[var3] = -119;
            } else if (var4 == 352) {
               var2[var3] = -118;
            } else if (var4 == 8249) {
               var2[var3] = -117;
            } else if (var4 == 338) {
               var2[var3] = -116;
            } else if (var4 == 381) {
               var2[var3] = -114;
            } else if (var4 == 8216) {
               var2[var3] = -111;
            } else if (var4 == 8217) {
               var2[var3] = -110;
            } else if (var4 == 8220) {
               var2[var3] = -109;
            } else if (var4 == 8221) {
               var2[var3] = -108;
            } else if (var4 == 8226) {
               var2[var3] = -107;
            } else if (var4 == 8211) {
               var2[var3] = -106;
            } else if (var4 == 8212) {
               var2[var3] = -105;
            } else if (var4 == 732) {
               var2[var3] = -104;
            } else if (var4 == 8482) {
               var2[var3] = -103;
            } else if (var4 == 353) {
               var2[var3] = -102;
            } else if (var4 == 8250) {
               var2[var3] = -101;
            } else if (var4 == 339) {
               var2[var3] = -100;
            } else if (var4 == 382) {
               var2[var3] = -98;
            } else if (var4 == 376) {
               var2[var3] = -97;
            } else {
               var2[var3] = 63;
            }
         } else {
            var2[var3] = (byte)var4;
         }
      }

      return var2;
   }

   public static byte g(char var0) {
      byte var1;
      if ((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if (var0 == 8364) {
            var1 = -128;
         } else if (var0 == 8218) {
            var1 = -126;
         } else if (var0 == 402) {
            var1 = -125;
         } else if (var0 == 8222) {
            var1 = -124;
         } else if (var0 == 8230) {
            var1 = -123;
         } else if (var0 == 8224) {
            var1 = -122;
         } else if (var0 == 8225) {
            var1 = -121;
         } else if (var0 == 710) {
            var1 = -120;
         } else if (var0 == 8240) {
            var1 = -119;
         } else if (var0 == 352) {
            var1 = -118;
         } else if (var0 == 8249) {
            var1 = -117;
         } else if (var0 == 338) {
            var1 = -116;
         } else if (var0 == 381) {
            var1 = -114;
         } else if (var0 == 8216) {
            var1 = -111;
         } else if (var0 == 8217) {
            var1 = -110;
         } else if (var0 == 8220) {
            var1 = -109;
         } else if (var0 == 8221) {
            var1 = -108;
         } else if (var0 == 8226) {
            var1 = -107;
         } else if (var0 == 8211) {
            var1 = -106;
         } else if (var0 == 8212) {
            var1 = -105;
         } else if (var0 == 732) {
            var1 = -104;
         } else if (var0 == 8482) {
            var1 = -103;
         } else if (var0 == 353) {
            var1 = -102;
         } else if (var0 == 8250) {
            var1 = -101;
         } else if (var0 == 339) {
            var1 = -100;
         } else if (var0 == 382) {
            var1 = -98;
         } else if (var0 == 376) {
            var1 = -97;
         } else {
            var1 = 63;
         }
      } else {
         var1 = (byte)var0;
      }

      return var1;
   }

   public static String s(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var1 + var5] & 255;
         if (var6 != 0) {
            if (var6 >= 128 && var6 < 160) {
               char var7 = g[var6 - 128];
               if (var7 == 0) {
                  var7 = '?';
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   public static boolean d(byte var0) {
      int var1 = var0 & 255;
      if (var1 == 0) {
         return false;
      } else {
         return var1 < 128 || var1 >= 160 || g[var1 - 128] != 0;
      }
   }

   public static char q(byte var0) {
      int var1 = var0 & 255;
      if (var1 == 0) {
         throw new IllegalArgumentException("Non cp1252 character 0x" + Integer.toString(var1, 16) + " provided");
      } else {
         if (var1 >= 128 && var1 < 160) {
            char var2 = g[var1 - 128];
            if (var2 == 0) {
               var2 = '?';
            }

            var1 = var2;
         }

         return (char)var1;
      }
   }

   public static int e(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var1 + var6);
         if ((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if (var7 == 8364) {
               var3[var4 + var6] = -128;
            } else if (var7 == 8218) {
               var3[var4 + var6] = -126;
            } else if (var7 == 402) {
               var3[var4 + var6] = -125;
            } else if (var7 == 8222) {
               var3[var4 + var6] = -124;
            } else if (var7 == 8230) {
               var3[var4 + var6] = -123;
            } else if (var7 == 8224) {
               var3[var4 + var6] = -122;
            } else if (var7 == 8225) {
               var3[var4 + var6] = -121;
            } else if (var7 == 710) {
               var3[var4 + var6] = -120;
            } else if (var7 == 8240) {
               var3[var4 + var6] = -119;
            } else if (var7 == 352) {
               var3[var4 + var6] = -118;
            } else if (var7 == 8249) {
               var3[var4 + var6] = -117;
            } else if (var7 == 338) {
               var3[var4 + var6] = -116;
            } else if (var7 == 381) {
               var3[var4 + var6] = -114;
            } else if (var7 == 8216) {
               var3[var4 + var6] = -111;
            } else if (var7 == 8217) {
               var3[var4 + var6] = -110;
            } else if (var7 == 8220) {
               var3[var4 + var6] = -109;
            } else if (var7 == 8221) {
               var3[var4 + var6] = -108;
            } else if (var7 == 8226) {
               var3[var4 + var6] = -107;
            } else if (var7 == 8211) {
               var3[var4 + var6] = -106;
            } else if (var7 == 8212) {
               var3[var4 + var6] = -105;
            } else if (var7 == 732) {
               var3[var4 + var6] = -104;
            } else if (var7 == 8482) {
               var3[var4 + var6] = -103;
            } else if (var7 == 353) {
               var3[var4 + var6] = -102;
            } else if (var7 == 8250) {
               var3[var4 + var6] = -101;
            } else if (var7 == 339) {
               var3[var4 + var6] = -100;
            } else if (var7 == 382) {
               var3[var4 + var6] = -98;
            } else if (var7 == 376) {
               var3[var4 + var6] = -97;
            } else {
               var3[var4 + var6] = 63;
            }
         } else {
            var3[var4 + var6] = (byte)var7;
         }
      }

      return var5;
   }

   public static String h(byte[] var0) {
      return s(var0, 0, var0.length);
   }

   private J173() {
   }
}
