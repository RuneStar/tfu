package tfu;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public final class Gk481 {
   public static final String b = "dd-MMM-yyyy HH:mm";
   public static final long d = 1000L;
   public static final long e = 86400000L;
   public static final int g = 11745;
   public static final long h = 604800000L;
   public static final long j = 3600000L;
   public static final String l = "dd-MMM-yyyy HH:mm:ss";
   private static Map p;
   public static final long q = 60000L;
   public static final String r = "dd/MM/yy";
   public static final String s = "dd-MMM-yyyy";
   private static final Calendar u = Calendar.getInstance(g("Europe/London"));
   public static final String v = "dd/MM/yy HH:mm";
   public static final String w = "yyyy-MM-dd_HH-mm-ss";
   private static final HashMap x = new HashMap();
   public static final String y = "dd/MM/yy HH:mm:ss";
   private static Map z;

   public static int d(long var0) {
      return (int)(var0 / 86400000L) - 11745;
   }

   public static int q() {
      return d(System.currentTimeMillis());
   }

   private Gk481() {
   }

   public static TimeZone g(String var0) {
      HashMap var1 = x;
      synchronized(var1) {
         TimeZone var2 = (TimeZone)x.get(var0);
         if (var2 == null) {
            var2 = TimeZone.getTimeZone(var0);
            x.put(var0, var2);
         }

         return var2;
      }
   }
}
