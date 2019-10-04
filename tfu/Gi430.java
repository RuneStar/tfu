package tfu;

public class Gi430 {
   private static final void d(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
      }

   }

   public static final void g(long var0) {
      if (var0 > 0L) {
         if (var0 % 10L == 0L) {
            d(var0 - 1L);
            d(1L);
         } else {
            d(var0);
         }

      }
   }
}
