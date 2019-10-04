package com.jagex.game.runetek6.event;

import tfu.Lm295;
import tfu.Lv148;

public enum ScriptEventHandler$Zones {
   TriggerScriptEvent;

   private Lm295 zone;

   public void stop() {
      if (this.zone != null) {
         this.zone.d();
      }

   }

   public void start() {
      if (this.zone == null) {
         this.zone = Lv148.q(this.name());
      }

      if (this.zone != null) {
         this.zone.g();
      }

   }
}
