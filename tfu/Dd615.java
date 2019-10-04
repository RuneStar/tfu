package tfu;

class Dd615 extends Eg572 {
   boolean d;
   String g;
   byte j;
   byte q;
   // $FF: synthetic field
   final Ee573 e;

   void g(Gg3 var1) {
      this.g = Gg3.bj(var1);
      if (this.g != null) {
         this.d = Gg3.ar(var1) == 1;
         this.q = Gg3.ax(var1);
         this.j = Gg3.ax(var1);
      }

   }

   Dd615(Ee573 var1, String var2, boolean var3, byte var4, byte var5) {
      this.e = var1;
      this.g = var2;
      this.d = var3;
      this.q = var4;
      this.j = var5;
   }

   void d(Dr574 var1) {
      var1.k = this.g;
      if (this.g != null) {
         var1.i = this.d;
         var1.o = this.q;
         var1.a = this.j;
      }

   }

   Dd615(Ee573 var1) {
      this.e = var1;
   }
}
