package tfu;

public final class Le231 {
   private static final String g = "#";

   public static final boolean g(String var0, String var1, String var2, String var3) {
      if (var0 != null && var2 != null) {
         return !var0.startsWith("#") && !var2.startsWith("#") ? var1.equals(var3) : var0.equals(var2);
      } else {
         return false;
      }
   }
}
