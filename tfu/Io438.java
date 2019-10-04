package tfu;

import java.io.File;
import java.util.HashMap;

class Io438 {
   private static HashMap d = new HashMap();
   private static final int g = 60000;

   public static synchronized boolean g(File var0) {
      File var1;
      do {
         var1 = var0;
         var0 = var0.getParentFile();
         if (var0 == null) {
            return false;
         }
      } while(!var0.getName().equals("store"));

      Long var2 = (Long)d.get(var1);
      long var3 = System.currentTimeMillis();
      if (var2 != null && var2 + 60000L >= var3) {
         return false;
      } else {
         d.put(var1, var3);
         return true;
      }
   }
}
