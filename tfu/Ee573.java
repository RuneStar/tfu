package tfu;

public class Ee573 {
   private static final int b = 5;
   private static final int e = 2;
   private static final int h = 3;
   private static final int j = 1;
   private static final int s = 4;
   public long d = -1L;
   public long g;
   public Gx298 q = new Gx298();

   public void d(Dr574 var1) {
      if (var1.bq == this.g && var1.n == this.d) {
         for(Eg572 var2 = (Eg572)Gx298.i(this.q); var2 != null; var2 = (Eg572)Gx298.c(this.q)) {
            var2.d(var1);
         }

         ++var1.n;
      } else {
         throw new RuntimeException("ClanChannelDelta.applyToClanChannel(): Credentials do not match! cc.clanHash:" + var1.bq + " updateNum:" + var1.n + " delta.clanHash:" + this.g + " updateNum:" + this.d);
      }
   }

   public Ee573(Gg3 var1) {
      this.g(var1);
   }

   public Ee573(Dr574 var1) {
      this.g = var1.bq;
      this.d = var1.n;
   }

   public void g(Gg3 var1) {
      this.g = Gg3.bq(var1);
      this.d = Gg3.bq(var1);

      for(int var2 = Gg3.ar(var1); var2 != 0; var2 = Gg3.ar(var1)) {
         Object var3;
         if (var2 == 1) {
            var3 = new Ek609(this);
         } else if (var2 == 4) {
            var3 = new Dd615(this);
         } else if (var2 == 3) {
            var3 = new Dx616(this);
         } else if (var2 == 2) {
            var3 = new Dj617(this);
         } else {
            if (var2 != 5) {
               throw new RuntimeException("Unrecognised ClanChannelDelta type in decode()");
            }

            var3 = new Er571(this);
         }

         ((Eg572)var3).g(var1);
         Gx298.t(this.q, (Ln265)var3);
      }

   }
}
