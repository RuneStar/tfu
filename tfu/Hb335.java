package tfu;

public class Hb335 {
   private Ky391 d;
   public Ky391 g = new Ky391();

   public static void g(Hb335 var0) {
      while(true) {
         Ky391 var1 = var0.g.s;
         if (var1 == var0.g) {
            var0.d = null;
            return;
         }

         Ky391.g(var1);
      }
   }

   public static void d(Hb335 var0, Ky391 var1) {
      if (var1.b != null) {
         Ky391.g(var1);
      }

      var1.b = var0.g.b;
      var1.s = var0.g;
      var1.b.s = var1;
      var1.s.b = var1;
   }

   public Hb335() {
      this.g.s = this.g;
      this.g.b = this.g;
   }
}
