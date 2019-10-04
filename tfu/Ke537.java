package tfu;

import java.io.File;

public class Ke537 {
   public static final String d;
   public static final String e;
   public static final String g;
   public static final File h;
   public static final String j;
   public static final String q;

   static {
      String var0 = "Unknown";

      try {
         var0 = System.getProperty("java.vendor").toLowerCase();
      } catch (Exception var7) {
      }

      g = var0.toLowerCase();
      var0 = "Unknown";

      try {
         var0 = System.getProperty("java.version").toLowerCase();
      } catch (Exception var6) {
      }

      d = var0.toLowerCase();
      var0 = "Unknown";

      try {
         var0 = System.getProperty("os.name").toLowerCase();
      } catch (Exception var5) {
      }

      q = var0.toLowerCase();
      var0 = "Unknown";

      try {
         var0 = System.getProperty("os.arch").toLowerCase();
      } catch (Exception var4) {
      }

      j = var0.toLowerCase();
      var0 = "Unknown";

      try {
         var0 = System.getProperty("os.version").toLowerCase();
      } catch (Exception var3) {
      }

      e = var0.toLowerCase();
      var0 = "~/";

      try {
         var0 = System.getProperty("user.home").toLowerCase();
      } catch (Exception var2) {
      }

      h = new File(var0);
   }
}
