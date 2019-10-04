package com.jagex.game.runetek6.xelement;

import tfu.Gg3;
import tfu.Hi86;
import tfu.Ia63;
import tfu.Id102;

class Ab205 implements Ia63 {
   // $FF: synthetic field
   final XElementLibrary g;

   public XElement g(byte[] var1, Integer var2, Hi86 var3) throws Id102 {
      try {
         return XElement.by(new Gg3(var1), this.g);
      } catch (Au64 var5) {
         throw new Id102(var5);
      }
   }

   public boolean resourceNeedsRefCounting() {
      return false;
   }

   Ab205(XElementLibrary var1) {
      this.g = var1;
   }
}
