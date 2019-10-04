package tfu;

public abstract class Lv148 {
   private static Lv148 g;

   public static void d(boolean var0) {
      if (g != null) {
         g.h(var0);
      }

   }

   public static Lm295 q(String var0) {
      return g != null ? g.s(var0) : null;
   }

   public abstract Lm295 s(String var1);

   protected abstract void h(boolean var1);

   public static La499 j(String var0) {
      return g != null ? g.b(var0) : null;
   }

   public abstract La499 b(String var1);

   protected abstract void e(boolean var1);

   public static void g(boolean var0) {
      if (g != null) {
         g.e(var0);
      }

   }
}
