package com.jagex.game.runetek6.config.vartype.constants;

import com.jagex.core.constants.J204;

public enum VarLifetime implements J204 {
   PERMANENT(1),
   TEMPORARY(0);

   private final int serialID;

   private VarLifetime(int var3) {
      this.serialID = var3;
   }

   public int getId() {
      return this.serialID;
   }
}
