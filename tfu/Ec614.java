package tfu;

class Ec614 extends Dm448 {
   String d;
   long g;
   // $FF: synthetic field
   final Dg449 q;

   void d(Ef450 var1) {
      var1.q(this.g, this.d, 0);
   }

   Ec614(Dg449 var1, long var2, String var4) {
      this.q = var1;
      this.g = -1L;
      this.d = null;
      this.g = var2;
      this.d = var4;
   }

   void g(Gg3 var1) {
      if (Gg3.ar(var1) != 255) {
         --var1.v;
         this.g = Gg3.bq(var1);
      }

      this.d = Gg3.bj(var1);
      if (Ef450.g) {
         System.out.println("memberhash:" + this.g + " membername:" + this.d);
      }

   }

   Ec614(Dg449 var1) {
      this.q = var1;
      this.g = -1L;
      this.d = null;
   }
}
