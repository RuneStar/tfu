package tfu;

public class Jp534 {
   private byte[] d;
   public Jh522 g;

   public void g(Gg3 var1, int var2) {
      int var3 = var1.v + var2;
      int var4 = Gg3.ar(var1);
      int var5 = Gg3.ar(var1);
      int var6 = Gg3.bd(var1);
      int var7 = Gg3.bd(var1);
      int var8 = var3 - var1.v;
      if (var6 == 0) {
         this.d = new byte[var7];
      }

      Gg3.bx(var1, this.d, var6, var8);
      var6 += var8;
      if (var6 == var7) {
         if (this.g == null) {
            this.g = new Jh522(var4);
         }

         Jh522.d(this.g, var5, this.d);
         this.d = null;
      }

   }
}
