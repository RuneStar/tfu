package tfu;

import java.applet.Applet;
import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import java.net.URL;

public class Dp208 {
   private static Applet d = null;
   public static final int e = 1;
   private static final boolean g = true;
   public static final int h = 2;
   public static final int j = 0;
   private static String q = null;
   public static final int s = 3;

   public static void g(Applet var0, String var1) {
      d = var0;
      q = var1;
   }

   public static void d(String var0, boolean var1, boolean var2) {
      e(var0, var1, "openjs", var2);
   }

   /** @deprecated */
   @Deprecated
   public static void q(String var0, boolean var1, boolean var2, boolean var3, boolean var4) {
      e(var0, var1, "openjs", var4);
   }

   /** @deprecated */
   @Deprecated
   public static void j(String var0, boolean var1, boolean var2, String var3, boolean var4, boolean var5) {
      e(var0, var1, var3, var4);
   }

   public static boolean h(String var0, int var1) {
      return s(var0, var1, "openjs");
   }

   public static boolean s(String var0, int var1, String var2) {
      if (var1 == 0) {
         try {
            if (!q.startsWith("win")) {
               throw new Exception();
            } else if (!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var10 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if (var10.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var5) {
            var5.printStackTrace();
            return false;
         }
      } else if (var1 == 1) {
         try {
            Object var3 = Mu209.d(d, var2, (new URL(d.getCodeBase(), var0)).toString());
            return var3 != null;
         } catch (Throwable var6) {
            var6.printStackTrace();
            return false;
         }
      } else if (var1 == 2) {
         try {
            d.getAppletContext().showDocument(new URL(d.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            var7.printStackTrace();
            return false;
         }
      } else if (var1 == 3) {
         try {
            Mu209.g(d, "loggedout");
         } catch (Throwable var9) {
         }

         try {
            d.getAppletContext().showDocument(new URL(d.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            var8.printStackTrace();
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   public static void e(String var0, boolean var1, String var2, boolean var3) {
      if (var1) {
         if (!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
            }
         }

         if (q.startsWith("win") && !var3) {
            h(var0, 0);
            return;
         }

         if (q.startsWith("mac")) {
            s(var0, 1, var2);
            return;
         }

         h(var0, 2);
      } else {
         h(var0, 3);
      }

   }
}
