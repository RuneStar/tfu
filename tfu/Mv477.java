package tfu;

public class Mv477 {
   private static int[] b;
   private static int d = 0;
   private static byte[][] e = new byte[250][];
   private static int g = 0;
   private static byte[][] h = new byte[50][];
   private static byte[][] j = new byte[1000][];
   private static byte[][][] l;
   private static int q = 0;
   private static int[] s;

   public static synchronized void q(byte[] var0) {
      if (var0.length == 100 && g < 1000) {
         j[g++] = var0;
      } else if (var0.length == 5000 && d < 250) {
         e[d++] = var0;
      } else if (var0.length == 30000 && q < 50) {
         h[q++] = var0;
      } else {
         if (l != null) {
            for(int var1 = 0; var1 < s.length; ++var1) {
               if (var0.length == s[var1] && b[var1] < l[var1].length) {
                  l[var1][b[var1]++] = var0;
                  return;
               }
            }
         }

      }
   }

   public static synchronized byte[] d(int var0) {
      byte[] var3;
      if (var0 == 100 && g > 0) {
         var3 = j[--g];
         j[g] = null;
         return var3;
      } else if (var0 == 5000 && d > 0) {
         var3 = e[--d];
         e[d] = null;
         return var3;
      } else if (var0 == 30000 && q > 0) {
         var3 = h[--q];
         h[q] = null;
         return var3;
      } else {
         if (l != null) {
            for(int var1 = 0; var1 < s.length; ++var1) {
               if (var0 == s[var1] && b[var1] > 0) {
                  byte[] var2 = l[var1][--b[var1]];
                  l[var1][b[var1]] = null;
                  return var2;
               }
            }
         }

         return new byte[var0];
      }
   }

   public static void g(int[] var0, int[] var1) {
      if (var0 != null && var1 != null) {
         s = var0;
         b = new int[var0.length];
         l = new byte[var0.length][][];

         for(int var2 = 0; var2 < s.length; ++var2) {
            l[var2] = new byte[var1[var2]][];
         }

      } else {
         s = null;
         b = null;
         l = (byte[][][])null;
      }
   }
}
