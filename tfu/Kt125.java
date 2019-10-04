package tfu;

public class Kt125 {
   private static Ks126 g;

   public static boolean q() {
      return g != null;
   }

   public static void g(Ks126 var0) {
      if (g != null) {
         throw new IllegalStateException("Duplicate NativeLibraryRegistry initialisation!");
      } else {
         g = var0;
      }
   }

   public static Ks126 d() {
      if (g == null) {
         throw new IllegalStateException("NativeLibraryRegistry not initialised!");
      } else {
         return g;
      }
   }
}
