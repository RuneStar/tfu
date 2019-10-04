package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass("Flag")
public class Flag {
   private boolean flag;

   public Flag(boolean var1) {
      this.flag = var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void Set() {
      this.flag = true;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void Clear() {
      this.flag = false;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean Get() {
      return this.flag;
   }
}
