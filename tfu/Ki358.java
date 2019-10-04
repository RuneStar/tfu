package tfu;

import java.util.HashSet;

public final class Ki358 {
   private static HashSet g = new HashSet();

   public static Object g(Object var0) {
      if (var0 == null) {
         return null;
      } else if (var0 instanceof Kl267) {
         Kl267 var1 = (Kl267)var0;
         return var1.q();
      } else if (g.contains(var0.getClass())) {
         return var0;
      } else {
         throw new IllegalArgumentException("Unsupported type: " + var0.getClass());
      }
   }

   static {
      g.add(Byte.class);
      g.add(Short.class);
      g.add(Character.class);
      g.add(Integer.class);
      g.add(Long.class);
      g.add(Float.class);
      g.add(Double.class);
      g.add(Boolean.class);
      g.add(String.class);
   }
}
