package com.jagex.game.runetek6.xelement;

import tfu.Gg3;
import tfu.Hg85;
import tfu.Hi86;
import tfu.Hk84;

public class Ao74 extends Am76 {
   public String d;

   public static Ao74 w(Gg3 var0, D80 var1) throws Au64 {
      // $FF: Couldn't be decompiled
   }

   public void r(Gg3 var1, Hk84 var2, Hg85 var3, Hi86 var4) {
      if (this.d != null) {
         Gg3.k(var1, H89.SYSTEM_NAME.j);
         Gg3.a(var1, Gg3.av(this.d));
         var1.ap(this.d);
      }

      Gg3.k(var1, H89.SUPER_TYPE_PROPERTIES.j);
      int var5 = var1.v += 4;
      super.r(var1, var2, var3, var4);
      Gg3.am(var1, var1.v - var5);
      Gg3.k(var1, 0);
   }

   public Ao74(D80 var1) {
      super(var1);
   }
}
