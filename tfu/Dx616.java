package tfu;

public class Dx616 extends Eg572 {
   public int d;
   public int g;
   public long q;
   // $FF: synthetic field
   final Ee573 j;

   Dx616(Ee573 var1, int var2, int var3, long var4) {
      this.j = var1;
      this.g = -1;
      this.g = var2;
      this.d = var3;
      this.q = var4;
   }

   Dx616(Ee573 var1) {
      this.j = var1;
      this.g = -1;
   }

   void g(Gg3 var1) {
      this.g = Gg3.au(var1);
      this.d = Gg3.ar(var1);
      if (Gg3.ar(var1) != 255) {
         --var1.v;
         this.q = Gg3.bq(var1);
      }

   }

   void d(Dr574 var1) {
      Dr574.q(var1, this.g);
   }
}
