package tfu;

import java.applet.Applet;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;

public class Ku323 extends RuntimeException {
   private static final boolean d = true;
   public static int e;
   private static final boolean g = true;
   public static int h;
   public static String j;
   public static long q;
   public static Applet s;
   private String b;
   private Throwable l;

   private Ku323(Throwable var1, String var2) {
      this.b = var2;
      this.l = var1;
      this.initCause(var1);
   }

   public static String d(Throwable var0) throws IOException {
      String var1;
      if (var0 instanceof Ku323) {
         Ku323 var2 = (Ku323)var0;
         var1 = var2.b + " | ";
         var0 = var2.l;
      } else {
         var1 = "";
      }

      StringWriter var12 = new StringWriter();
      PrintWriter var3 = new PrintWriter(var12);
      var0.printStackTrace(var3);
      var3.close();
      String var4 = var12.toString();
      BufferedReader var5 = new BufferedReader(new StringReader(var4));
      String var6 = var5.readLine();

      while(true) {
         String var7 = var5.readLine();
         if (var7 == null) {
            var1 = var1 + "| " + var6;
            return var1;
         }

         int var8 = var7.indexOf(40);
         int var9 = var7.indexOf(41, var8 + 1);
         String var10;
         if (var8 != -1) {
            var10 = var7.substring(0, var8);
         } else {
            var10 = var7;
         }

         var10 = var10.trim();
         var10 = var10.substring(var10.lastIndexOf(32) + 1);
         var10 = var10.substring(var10.lastIndexOf(9) + 1);
         var1 = var1 + var10;
         if (var8 != -1 && var9 != -1) {
            int var11 = var7.indexOf(".java:", var8);
            if (var11 >= 0) {
               var1 = var1 + var7.substring(var11 + 5, var9);
            }
         }

         var1 = var1 + ' ';
      }
   }

   private static final void q(String var0) {
      System.out.println("Error: " + j(var0, "%0a", "\n"));
   }

   private static final String j(String var0, String var1, String var2) {
      for(int var3 = var0.indexOf(var1); var3 != -1; var3 = var0.indexOf(var1, var3 + var2.length())) {
         var0 = var0.substring(0, var3) + var2 + var0.substring(var3 + var1.length());
      }

      return var0;
   }

   public static void g(String var0, Throwable var1) {
      try {
         String var2 = "";
         if (var1 != null) {
            var2 = d(var1);
         }

         if (var0 != null) {
            if (var1 != null) {
               var2 = var2 + " | ";
            }

            var2 = var2 + var0;
         }

         q(var2);
         var2 = Mi507.d(var2);
         if (s == null) {
            return;
         }

         String var3 = "Unknown";
         String var4 = "1.1";

         try {
            var3 = System.getProperty("java.vendor");
            var4 = System.getProperty("java.version");
         } catch (Exception var7) {
         }

         URL var5 = new URL(s.getCodeBase(), "clienterror.ws?c=" + e + "&cs=" + h + "&u=" + (j != null ? Mi507.d(j) : "" + q) + "&v1=" + Mi507.d(var3) + "&v2=" + Mi507.d(var4) + "&e=" + var2);
         DataInputStream var6 = new DataInputStream(var5.openStream());
         var6.read();
         var6.close();
      } catch (Exception var8) {
         var8.printStackTrace();
      }

   }
}
