package com.jagex.game.runetek6.config.vartype;

import com.jagex.core.constants.J204;

public enum VarTypeEncodingKey implements J204 {
   DEBUGNAME(1),
   DOMAIN(2),
   LIFETIME(4),
   TRANSMITLEVEL(5),
   TYPE(3),
   VARNAME_HASH32(6);

   private final int serialID;

   private VarTypeEncodingKey(int var3) {
      this.serialID = var3;
   }

   public int getId() {
      return this.serialID;
   }
}
