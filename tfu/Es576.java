package tfu;

class Es576 extends Dm448 {
   int d;
   int g;
   int j;
   int q;
   // $FF: synthetic field
   final Dg449 e;

   Es576(Dg449 var1) {
      this.e = var1;
   }

   Es576(Dg449 var1, int var2, int var3, int var4, int var5) {
      this.e = var1;
      this.g = var2;
      this.j = var3;
      this.d = var4;
      this.q = var5;
   }

   void g(Gg3 var1) {
      this.g = Gg3.bd(var1);
      this.j = Gg3.bd(var1);
      this.d = Gg3.ar(var1);
      this.q = Gg3.ar(var1);
   }

   void d(Ef450 var1) {
      var1.v(this.g, this.j, this.d, this.q);
   }
}
