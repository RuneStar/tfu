// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.vartype.constants;

import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.core.constants.J204;

public enum VarDomainType implements J204
{
    CAMPAIGN_VAR("CAMPAIGN_VAR", 8, Js5ConfigGroup.VAR_CAMPAIGN, 10, true, false), 
    CLAN("CLAN", 6, Js5ConfigGroup.VAR_CLAN, 6, true, true), 
    CLAN_SETTING("CLAN_SETTING", 7, Js5ConfigGroup.VAR_CLAN_SETTING, 7, true, false), 
    CLIENT("CLIENT", 2, Js5ConfigGroup.VAR_CLIENT, 2, true, true), 
    NPC("NPC", 1, Js5ConfigGroup.VAR_NPC, 1, false, true), 
    OBJECT("OBJECT", 5, Js5ConfigGroup.VAR_OBJECT, 5, true, true), 
    PLAYER("PLAYER", 0, Js5ConfigGroup.VAR_PLAYER, 0, true, true), 
    REGION("REGION", 4, Js5ConfigGroup.VAR_REGION, 4, false, false), 
    WORLD("WORLD", 3, Js5ConfigGroup.VAR_WORLD, 3, false, false);
    
    private final Js5ConfigGroup js5GroupID;
    private final boolean permitClientTransmission;
    private final boolean permitPermanentLifetime;
    private final int serialID;
    
    public Js5ConfigGroup getJs5GroupID() {
        return this.js5GroupID;
    }
    
    @Override
    public int getId() {
        return this.serialID;
    }
    
    private VarDomainType(final String name, final int ordinal, final Js5ConfigGroup js5GroupID, final int serialID, final boolean permitPermanentLifetime, final boolean permitClientTransmission) {
        this.js5GroupID = js5GroupID;
        this.serialID = serialID;
        this.permitPermanentLifetime = permitPermanentLifetime;
        this.permitClientTransmission = permitClientTransmission;
    }
    
    public Object getDefaultValue(final ScriptVarType scriptVarType) {
        return scriptVarType.getDefaultValue();
    }
}
