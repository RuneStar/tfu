package com.jagex.game.runetek6.xelement;

import tfu.Gg3;
import tfu.Hi86;
import tfu.Ia63;
import tfu.Id102;

final class Bp83 implements Ia63 {
   public boolean resourceNeedsRefCounting() {
      return false;
   }

   public Bh77 g(byte[] var1, Integer var2, Hi86 var3) throws Id102 {
      try {
         return Bh77.w(new Gg3(var1), XElement.ai);
      } catch (Au64 var5) {
         throw new Id102(var5);
      }
   }
}
