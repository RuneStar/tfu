package com.jagex.game.runetek6.xelement;

import com.jagex.maths.Vector3;
import tfu.Gg3;

public class S356 extends Bm108 {
   public static S356 g(Gg3 var0, int var1) {
      Vector3 var2 = new Vector3(var0);
      return new S356(var2);
   }

   public void d(Gg3 var1) {
      Vector3.w((Vector3)super.r, var1);
   }

   S356(Vector3 var1) {
      super(Ag97.j, var1);
   }
}
