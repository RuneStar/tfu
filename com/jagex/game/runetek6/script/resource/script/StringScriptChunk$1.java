package com.jagex.game.runetek6.script.resource.script;

import tfu.Hi86;
import tfu.Ia63;
import tfu.Mj383;

final class StringScriptChunk$1 implements Ia63 {
   public boolean resourceNeedsRefCounting() {
      return false;
   }

   public ScriptChunk constructResource(byte[] var1, String var2, Hi86 var3) {
      String var4 = Mj383.q(var1);
      return new StringScriptChunk(var2, var4);
   }
}
