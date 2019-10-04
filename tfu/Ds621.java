package tfu;

public abstract class Ds621 {
   private static final boolean s = true;

   public static Ds621 r() {
      try {
         return new Dc622();
      } catch (Throwable var1) {
         return new De623();
      }
   }

   public static final int v(Ds621 var0, long var1) {
      long var3 = var0.g();
      if (var3 > 0L) {
         Gi430.g(var3);
      }

      return var0.d(var1);
   }

   public abstract long g();

   public abstract int d(long var1);
}
