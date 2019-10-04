package com.jagex.game.runetek6.config.vartype.constants;

import com.jagex.core.constants.J204;
import com.jagex.game.runetek6.config.Js5ConfigGroup;

public enum VarDomainType implements J204 {
   CAMPAIGN_VAR(Js5ConfigGroup.VAR_CAMPAIGN, 10, true, false),
   CLAN(Js5ConfigGroup.VAR_CLAN, 6, true, true),
   CLAN_SETTING(Js5ConfigGroup.VAR_CLAN_SETTING, 7, true, false),
   CLIENT(Js5ConfigGroup.VAR_CLIENT, 2, true, true),
   NPC(Js5ConfigGroup.VAR_NPC, 1, false, true),
   OBJECT(Js5ConfigGroup.VAR_OBJECT, 5, true, true),
   PLAYER(Js5ConfigGroup.VAR_PLAYER, 0, true, true),
   REGION(Js5ConfigGroup.VAR_REGION, 4, false, false),
   WORLD(Js5ConfigGroup.VAR_WORLD, 3, false, false);

   private final Js5ConfigGroup js5GroupID;
   private final boolean permitClientTransmission;
   private final boolean permitPermanentLifetime;
   private final int serialID;

   public Js5ConfigGroup getJs5GroupID() {
      return this.js5GroupID;
   }

   public int getId() {
      return this.serialID;
   }

   private VarDomainType(Js5ConfigGroup var3, int var4, boolean var5, boolean var6) {
      this.js5GroupID = var3;
      this.serialID = var4;
      this.permitPermanentLifetime = var5;
      this.permitClientTransmission = var6;
   }

   public Object getDefaultValue(ScriptVarType var1) {
      return var1.getDefaultValue();
   }
}
