package com.jagex.game.runetek6.config.vartype;

import com.jagex.game.runetek6.config.vartype.constants.ScriptVarType;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import com.jagex.game.runetek6.config.vartype.constants.VarLifetime;
import com.jagex.game.runetek6.config.vartype.constants.VarTransmitLevel;
import tfu.Gg3;
import tfu.Gp293;

public abstract class VarType implements Gp293 {
   public VarTransmitLevel clientTransmitLevel;
   public ScriptVarType dataType;
   public String debugName;
   public int debugNameHash32;
   public final VarDomainType domain;
   public final int id;
   public VarLifetime lifeTime;

   public VarType(VarDomainType var1, int var2) {
      this.lifeTime = VarLifetime.TEMPORARY;
      this.clientTransmitLevel = VarTransmitLevel.NEVER;
      this.domain = var1;
      this.id = var2;
   }

   public void decode(Gg3 var1) {
      int var2 = Gg3.ar(var1);
   }

   public abstract void decode(Gg3 var1, int var2);

   public boolean isValidDefinition() {
      return this.domain != null && this.dataType != null;
   }

   public Object getDefaultValue() {
      return this.domain.getDefaultValue(this.dataType);
   }
}
