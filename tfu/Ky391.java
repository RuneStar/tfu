package tfu;

public class Ky391 {
   public Ky391 b;
   public Ky391 s;

   public static void g(Ky391 var0) {
      if (var0.b != null) {
         var0.b.s = var0.s;
         var0.s.b = var0.b;
         var0.s = null;
         var0.b = null;
      }
   }
}
