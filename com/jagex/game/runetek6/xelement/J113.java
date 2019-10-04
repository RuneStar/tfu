package com.jagex.game.runetek6.xelement;

import com.jagex.maths.Vector3;
import com.jagex.maths.Y310;
import tfu.Gg3;
import tfu.Hg85;
import tfu.Hi86;
import tfu.Hk84;

public class J113 extends Am76 {
   public float d;
   public Vector3 q = new Vector3(1.0F, 1.0F, 1.0F);

   public static J113 w(Gg3 var0, D80 var1) throws Au64 {
      // $FF: Couldn't be decompiled
   }

   public void r(Gg3 var1, Hk84 var2, Hg85 var3, Hi86 var4) {
      Gg3.k(var1, Bo174.RADIUS.e);
      Gg3.aq(var1, this.d);
      if (!Y310.g(this.q.x) || !Y310.g(this.q.y) || !Y310.g(this.q.z)) {
         Gg3.k(var1, Bo174.COLOUR.e);
         Gg3.aq(var1, this.q.x);
         Gg3.aq(var1, this.q.y);
         Gg3.aq(var1, this.q.z);
      }

      Gg3.k(var1, Bo174.SUPER_TYPE_PROPERTIES.e);
      int var5 = var1.v += 4;
      super.r(var1, var2, var3, var4);
      Gg3.am(var1, var1.v - var5);
      Gg3.k(var1, 0);
   }

   public J113(D80 var1) {
      super(var1);
   }
}
