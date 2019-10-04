package tfu;

class Ep612 extends Dm448 {
   byte d;
   byte e;
   boolean g;
   byte j;
   byte q;
   // $FF: synthetic field
   final Dg449 h;

   Ep612(Dg449 var1, Ef450 var2) {
      this.h = var1;
      this.g = var2.r;
      this.d = var2.v;
      this.q = var2.y;
      this.j = var2.p;
      this.e = var2.x;
   }

   Ep612(Dg449 var1) {
      this.h = var1;
   }

   void d(Ef450 var1) {
      var1.r = this.g;
      var1.v = this.d;
      var1.y = this.q;
      var1.p = this.j;
      var1.x = this.e;
   }

   void g(Gg3 var1) {
      this.g = Gg3.ar(var1) == 1;
      this.d = Gg3.ax(var1);
      this.q = Gg3.ax(var1);
      this.j = Gg3.ax(var1);
      this.e = Gg3.ax(var1);
   }
}
