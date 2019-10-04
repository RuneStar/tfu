package com.jagex.game.runetek6.gameentity;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.maths.Vector3;
import tfu.Be2;
import tfu.Bs1;
import tfu.Fn87;

@ScriptEntryClass("PickResult")
public class ScriptablePickResult extends Fn87 {
   @ScriptEntryPoint
   @Be2
   @Bs1
   public float getDistance() {
      return super.q;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getPickPoint() {
      return super.d;
   }

   public ScriptablePickResult(Fn87 var1) {
      super(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Object getPicked() {
      return super.g;
   }
}
