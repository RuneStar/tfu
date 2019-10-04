package rs2.client.sound;

class M682 implements Z674 {
   // $FF: synthetic field
   final X675 g;

   public void g(String var1, Object var2) {
      X675 var3 = (X675)var2;
      X675.z(var3);
      if (K589.b != null) {
         X675.h(K589.b);
      }

      X675.h(this.g);
      long var4 = 0L;
      X675 var6 = K589.s;
      if (var6 == null) {
         X675.g(this.g);
      } else if (var6 != null && X675.w(var6)) {
         long var7 = K589.s == null ? 0L : X675.x(K589.s);
         long var11 = var7 / (long)var6.r;
         ++var11;
         var4 = var11 * (long)var6.r - var7;
         long var13 = var7 + var4;
         if (var6 != var3) {
            if (K589.s != null && var13 > (long)X675.u(K589.s)) {
               var13 %= (long)X675.u(K589.s);
            }

            X675.s(var3, new N680(0, var13));
            K589.b = var3;
         }
      }

   }

   public void d(byte[] var1, Object var2) {
   }

   public void q() {
   }

   M682(X675 var1) {
      this.g = var1;
   }
}
