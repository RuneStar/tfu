package tfu;

import java.io.File;
import java.util.Collection;

public class Iu445 {
   public static String g(File var0) {
      if (!var0.isDirectory()) {
         String var1 = var0.getName();
         int var2 = var1.lastIndexOf(46);
         return var2 >= 0 ? var1.substring(var2 + 1) : "";
      } else {
         return null;
      }
   }

   public static void d(File var0, Collection var1, String... var2) {
      int var5;
      int var6;
      if (var0.isDirectory()) {
         File[] var3 = var0.listFiles();
         File[] var4 = var3;
         var5 = var3.length;

         for(var6 = 0; var6 < var5; ++var6) {
            File var7 = var4[var6];
            d(var7, var1, var2);
         }
      } else if (var0.isFile()) {
         String var8 = var0.getPath();
         String[] var9 = var2;
         var5 = var2.length;

         for(var6 = 0; var6 < var5; ++var6) {
            String var10 = var9[var6];
            if (var8.length() > var10.length() && var8.charAt(var8.length() - var10.length() - 1) == '.' && var8.endsWith(var10)) {
               var1.add(var0);
               break;
            }
         }
      }

   }
}
