package com.jagex.game.runetek6.xelement;

import java.util.ArrayList;
import tfu.Gg3;
import tfu.Hp62;
import tfu.Ia63;
import tfu.Id102;

public final class Ar110 implements Hp62 {
   public static final Ia63 g = new Ac112();
   private static final int q = 1;
   public final ArrayList d = new ArrayList();

   public static Ar110 g(Gg3 var0) throws Id102 {
      int var1 = Gg3.ar(var0);
      if (var1 > 1) {
         throw new Id102("Unsupported version " + var1);
      } else {
         int var2 = Gg3.bd(var0);
         Ar110 var3 = new Ar110();

         for(int var4 = 0; var4 < var2; ++var4) {
            Aa111 var5 = new Aa111();
            var5.g = Gg3.ar(var0);
            var5.d = Gg3.bl(var0);
            var5.q = Gg3.bl(var0);
            var5.j = Gg3.bl(var0);
            var5.e = Gg3.bl(var0);
            var5.h = Gg3.bl(var0);
            var5.s = Gg3.bd(var0);
            var5.b = Gg3.bl(var0);
            var5.l = Gg3.bl(var0);
            var5.w = Gg3.bl(var0);
            var5.r = Gg3.bl(var0);
            var5.v = Gg3.ar(var0) == 1;
            var5.y = Gg3.ar(var0) == 1;
            var5.p = Gg3.ar(var0) == 1;
            var3.d.add(var5);
         }

         return var3;
      }
   }

   public void onAllRefsReleased() {
   }
}
