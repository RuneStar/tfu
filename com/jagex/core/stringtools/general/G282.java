package com.jagex.core.stringtools.general;

public class G282 {
   private static char[] d;
   private static char[] g = new char[64];
   private static int[] q;

   private G282() {
   }

   public static int g(char var0) {
      return var0 >= 0 && var0 < q.length ? q[var0] : -1;
   }

   public static byte[] q(String var0) {
      int var1 = var0.length();
      if (var1 == 0) {
         return new byte[0];
      } else {
         int var2 = var1 + 3 & -4;
         int var3 = var2 / 4 * 3;
         if (var2 - 2 < var1 && g(var0.charAt(var2 - 2)) != -1) {
            if (var2 - 1 >= var1 || g(var0.charAt(var2 - 1)) == -1) {
               --var3;
            }
         } else {
            var3 -= 2;
         }

         byte[] var4 = new byte[var3];
         d(var0, var4, 0);
         return var4;
      }
   }

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         g[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         g[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         g[var0] = (char)(48 + var0 - 52);
      }

      g[62] = '+';
      g[63] = '/';
      d = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         d[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         d[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         d[var0] = (char)(48 + var0 - 52);
      }

      d[62] = '*';
      d[63] = '-';
      q = new int[128];

      for(var0 = 0; var0 < q.length; ++var0) {
         q[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         q[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         q[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         q[var0] = var0 - 48 + 52;
      }

      q[42] = q[43] = 62;
      q[45] = q[47] = 63;
   }

   public static int d(String var0, byte[] var1, int var2) {
      int var3 = var2;
      int var4 = var0.length();

      for(int var5 = 0; var5 < var4; var5 += 4) {
         int var6 = g(var0.charAt(var5));
         int var7 = var5 + 1 < var4 ? g(var0.charAt(var5 + 1)) : -1;
         int var8 = var5 + 2 < var4 ? g(var0.charAt(var5 + 2)) : -1;
         int var9 = var5 + 3 < var4 ? g(var0.charAt(var5 + 3)) : -1;
         var1[var2++] = (byte)(var6 << 2 | var7 >>> 4);
         if (var8 == -1) {
            break;
         }

         var1[var2++] = (byte)((var7 & 15) << 4 | var8 >>> 2);
         if (var9 == -1) {
            break;
         }

         var1[var2++] = (byte)((var8 & 3) << 6 | var9);
      }

      return var2 - var3;
   }
}
