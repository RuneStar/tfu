package com.jagex.game.runetek6.config.vartype.constants;

import com.jagex.core.constants.J204;

public enum VarTransmitLevel implements J204 {
   NEVER(0),
   ON_SET_ALWAYS(2),
   ON_SET_DIFFERENT(1);

   private final int serialID;

   public int getId() {
      return this.serialID;
   }

   private VarTransmitLevel(int var3) {
      this.serialID = var3;
   }
}
