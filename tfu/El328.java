package tfu;

public class El328 extends Ln265 {
   private static El328[] e = new El328[300];
   private static int h = 0;
   public int d;
   public Eu326 g;
   public int j;
   public Gs329 q;

   private static El328 g() {
      return h == 0 ? new El328() : e[--h];
   }

   public static El328 d(Eu326 var0, Ic327 var1) {
      El328 var2 = g();
      var2.g = var0;
      var2.d = var0.ax;
      if (var2.d == -1) {
         var2.q = new Gs329(260);
      } else if (var2.d == -2) {
         var2.q = new Gs329(10000);
      } else if (var2.d <= 18) {
         var2.q = new Gs329(20);
      } else if (var2.d <= 98) {
         var2.q = new Gs329(100);
      } else {
         var2.q = new Gs329(260);
      }

      Gs329.g(var2.q, var1);
      Gs329.d(var2.q, var2.g.ordinal());
      var2.j = 0;
      return var2;
   }

   public static El328 q() {
      El328 var0 = g();
      var0.g = null;
      var0.d = 0;
      var0.q = new Gs329(5000);
      return var0;
   }

   public static void j(El328 var0) {
      if (h < e.length) {
         e[h++] = var0;
      }
   }

   private El328() {
   }
}
