package tfu;

import java.util.HashMap;

public class Jo533 {
   private static final HashMap g = new HashMap();

   private static Jl526 g(String var0) {
      Jl526 var1 = (Jl526)g.get(var0);
      if (var1 == null) {
         var1 = new Jl526();
         g.put(var0, var1);
      }

      return var1;
   }

   public static void d(Jy122 var0, String var1, String var2) {
      Jl526 var3 = g(var1);
      if (Jl526.g(var3, var2)) {
         Jy122.s(var0, var2);
      }

   }
}
