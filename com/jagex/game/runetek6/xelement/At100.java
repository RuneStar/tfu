package com.jagex.game.runetek6.xelement;

import tfu.Gg3;
import tfu.Hi86;
import tfu.Ia63;
import tfu.Id102;

final class At100 implements Ia63 {
   public T101 g(byte[] var1, Integer var2, Hi86 var3) throws Id102 {
      return T101.g(new Gg3(var1));
   }

   public boolean resourceNeedsRefCounting() {
      return false;
   }
}
