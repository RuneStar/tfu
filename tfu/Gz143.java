package tfu;

public final class Gz143 {
   private static long d;
   private static final boolean g = true;
   private static long q;

   private Gz143() {
   }

   public static final synchronized long g() {
      long var0 = System.currentTimeMillis();
      if (var0 < d) {
         System.out.println("WARNING: safetime: time jumped back by " + (d - var0) + " ms");
         q += d - var0;
      }

      d = var0;
      return var0 + q;
   }
}
