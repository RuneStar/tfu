package com.jagex.game.runetek6.scripthelpers;

import com.jagex.game.runetek6.script.ScriptEntryPoint;
import tfu.Be2;
import tfu.Bn279;
import tfu.Bs1;

public class STaskFuture {
   public final Bn279 inner;

   public STaskFuture(Bn279 var1) {
      this.inner = var1;
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public void CancelIfNotUsedYet() {
      Bn279.j(this.inner);
   }
}
