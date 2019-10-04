package tfu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Jl526 {
   private String d = new String();
   private final Logger logger = LoggerFactory.getLogger(Jl526.class);

   public static boolean g(Jl526 var0, String var1) {
      if (!var1.equals(var0.d)) {
         var0.d = var1;
         return true;
      } else {
         return false;
      }
   }
}
