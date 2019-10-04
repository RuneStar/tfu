package rs2.client.sound;

import fmod.E245;
import fmod.Q244;
import fmod.X243;

class L681 {
   public float d;
   public X243 g;
   private String j;
   public H591 q;
   // $FF: synthetic field
   final H591 e;

   public static void g(L681 var0, Q244 var1) {
      if (X243.y(var0.g)) {
         X243.c(var0.g);
         H591.p(var0.e).remove(var0.g);
      }

      var0.g = E245.v(SoundManager.c, var0.j);
      if (X243.h(var0.g)) {
         X243.u(var0.g, var1);
         X243.i(var0.g, var0.d * var0.e.g);
         var0.g.a();
         H591.p(var0.e).add(var0.g);
      }

   }

   public L681(H591 var1, String var2, float var3, H591 var4) {
      this.e = var1;
      this.j = var2;
      this.q = var4;
      this.g = E245.v(SoundManager.c, var2);
      this.d = var3;
   }
}
