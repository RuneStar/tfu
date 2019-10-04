package com.jagex.game.runetek6.xelement;

import tfu.Gg3;
import tfu.Hi86;
import tfu.Ia63;
import tfu.Id102;

final class K67 implements Ia63 {
   public Bj61 g(byte[] var1, Integer var2, Hi86 var3) throws Id102 {
      try {
         return Bj61.q(new Gg3(var1));
      } catch (Au64 var5) {
         throw new Id102("Exception whilst constructing an animation set", var5);
      }
   }

   public boolean resourceNeedsRefCounting() {
      return false;
   }
}
