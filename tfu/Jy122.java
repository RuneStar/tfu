package tfu;

import org.slf4j.Logger;

public class Jy122 {
   public static final int d = 1;
   public static final int g = 0;
   public static final int j = 3;
   public static final int q = 2;
   protected final int b;
   protected String e = "# ";
   protected int h = 0;
   protected final StringBuilder l = new StringBuilder();
   protected final Logger logger;

   public Jy122(Logger var1, int var2) {
      this.logger = var1;
      this.b = var2;
   }

   public static boolean g(Jy122 var0) {
      return var0.logger.isTraceEnabled();
   }

   public static void d(Jy122 var0, String var1) {
      var0.e = var1;
   }

   public static void h(Jy122 var0, String var1) {
      q(var0);
      r(var0);
      var0.l.append(var1);
      e(var0);
   }

   public static void j(Jy122 var0) {
      if (var0.h > 0) {
         --var0.h;
      }

   }

   protected static void e(Jy122 var0) {
      if (var0.b == 3) {
         var0.logger.warn(var0.l.toString());
      } else if (var0.b == 2) {
         var0.logger.info(var0.l.toString());
      } else if (var0.b == 1) {
         var0.logger.debug(var0.l.toString());
      } else {
         var0.logger.trace(var0.l.toString());
      }

      var0.l.setLength(0);
   }

   public static void b(Jy122 var0, String var1) {
      h(var0, var1);
      j(var0);
   }

   public static void l(Jy122 var0, String var1) {
      w(var0);
      var0.l.append(var1);
      e(var0);
      j(var0);
   }

   protected static void r(Jy122 var0) {
      var0.l.append(var0.e);

      for(int var1 = 1; var1 < var0.h - 1; ++var1) {
         var0.l.append(" |   ");
      }

      if (var0.h > 1) {
         var0.l.append(" +---");
      }

   }

   protected static void w(Jy122 var0) {
      var0.l.append(var0.e);

      for(int var1 = 1; var1 < var0.h; ++var1) {
         var0.l.append(" |   ");
      }

   }

   public static void q(Jy122 var0) {
      ++var0.h;
   }

   public static void s(Jy122 var0, String var1) {
      w(var0);
      var0.l.append(var1);
      e(var0);
   }

   public Jy122(Logger var1) {
      this.logger = var1;
      this.b = 0;
   }
}
