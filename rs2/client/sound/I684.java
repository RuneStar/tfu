package rs2.client.sound;

import fmod.X243;

final class I684 implements Z674 {
   public void d(byte[] var1, Object var2) {
   }

   public void q() {
      Y603.d = null;
      Y603.j = null;
      if (Y603.q != null) {
         X243.f(Y603.q);
         Y603.q = null;
      }

   }

   public void g(String var1, Object var2) {
      --Y603.h;
      if (Y603.h <= 0 && Y603.d != null) {
         X243 var3 = SoundManager.c.r(Y603.d, 0);
         if (X243.h(var3)) {
            X243.i(var3, Y603.e);
            if (Y603.j != null) {
               C595[] var4 = SoundManager.f(Y603.j);
               if (var4 != null) {
                  C595[] var5 = var4;
                  int var6 = var4.length;

                  for(int var7 = 0; var7 < var6; ++var7) {
                     C595 var8 = var5[var7];
                     var3.ag(var8.g, (float)var8.d);
                  }
               }
            }

            var3.a();
            if (Y603.q != null) {
               X243.f(Y603.q);
            }

            Y603.j = null;
            Y603.q = var3;
            Y603.g = Y603.d;
            Y603.d = null;
         }
      }

   }
}
