package tfu;

class Er571 extends Eg572 {
   private static final int s = 1;
   byte d;
   String e;
   int g;
   boolean h;
   long j;
   int q;
   // $FF: synthetic field
   final Ee573 b;

   Er571(Ee573 var1, int var2, byte var3, int var4, long var5, String var7, boolean var8) {
      this.b = var1;
      this.g = -1;
      this.g = var2;
      this.d = var3;
      this.q = var4;
      this.j = var5;
      this.e = var7;
      this.h = var8;
   }

   void d(Dr574 var1) {
      Dt575 var2 = var1.z[this.g];
      var2.d = this.d;
      var2.q = this.q;
      var2.e = this.j;
      var2.j = this.e;
      var2.h = this.h;
   }

   void g(Gg3 var1) {
      Gg3.ar(var1);
      this.g = Gg3.au(var1);
      this.d = Gg3.ax(var1);
      this.q = Gg3.au(var1);
      this.j = Gg3.bq(var1);
      this.e = Gg3.bk(var1);
      this.h = Gg3.ar(var1) == 1;
   }

   Er571(Ee573 var1) {
      this.b = var1;
      this.g = -1;
   }
}
