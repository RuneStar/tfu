package tfu;

public class Ek609 extends Eg572 {
   String d;
   long e;
   long g;
   byte j;
   int q;
   // $FF: synthetic field
   final Ee573 h;

   Ek609(Ee573 var1, long var2, String var4, int var5, byte var6, long var7) {
      this.h = var1;
      this.g = -1L;
      this.d = null;
      this.g = var2;
      this.d = var4;
      this.q = var5;
      this.j = var6;
      this.e = var7;
   }

   void g(Gg3 var1) {
      if (Gg3.ar(var1) != 255) {
         --var1.v;
         this.g = Gg3.bq(var1);
      }

      this.d = Gg3.bj(var1);
      this.q = Gg3.au(var1);
      this.j = Gg3.ax(var1);
      this.e = Gg3.bq(var1);
      if (Dr574.g) {
         System.out.println("memberhash:" + this.g + " membername:" + this.d);
      }

   }

   Ek609(Ee573 var1) {
      this.h = var1;
      this.g = -1L;
      this.d = null;
   }

   void d(Dr574 var1) {
      Dt575 var2 = new Dt575();
      var2.g = this.g;
      var2.j = this.d;
      var2.q = this.q;
      var2.d = this.j;
      var2.e = this.e;
      Dr574.d(var1, var2);
   }
}
