package tfu;

class Ei604 extends Dm448 {
   String d;
   long g;
   int q;
   // $FF: synthetic field
   final Dg449 j;

   void g(Gg3 var1) {
      if (Gg3.ar(var1) != 255) {
         --var1.v;
         this.g = Gg3.bq(var1);
      }

      this.d = Gg3.bj(var1);
      this.q = Gg3.au(var1);
      if (Ef450.g) {
         System.out.println("memberhash:" + this.g + " membername:" + this.d);
      }

   }

   Ei604(Dg449 var1, long var2, String var4, int var5) {
      this.j = var1;
      this.g = -1L;
      this.d = null;
      this.q = 0;
      this.g = var2;
      this.d = var4;
      this.q = var5;
   }

   void d(Ef450 var1) {
      var1.q(this.g, this.d, this.q);
   }

   Ei604(Dg449 var1) {
      this.j = var1;
      this.g = -1L;
      this.d = null;
      this.q = 0;
   }
}
