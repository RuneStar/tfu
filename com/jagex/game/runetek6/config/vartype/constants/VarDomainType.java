/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.vartype.constants;

import com.jagex.core.constants.J204;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.game.runetek6.config.vartype.constants.ScriptVarType;

public enum VarDomainType implements J204
{
    PLAYER(Js5ConfigGroup.VAR_PLAYER, 0, true, true),
    NPC(Js5ConfigGroup.VAR_NPC, 1, false, true),
    CLIENT(Js5ConfigGroup.VAR_CLIENT, 2, true, true),
    WORLD(Js5ConfigGroup.VAR_WORLD, 3, false, false),
    REGION(Js5ConfigGroup.VAR_REGION, 4, false, false),
    OBJECT(Js5ConfigGroup.VAR_OBJECT, 5, true, true),
    CLAN(Js5ConfigGroup.VAR_CLAN, 6, true, true),
    CLAN_SETTING(Js5ConfigGroup.VAR_CLAN_SETTING, 7, true, false),
    CAMPAIGN_VAR(Js5ConfigGroup.VAR_CAMPAIGN, 10, true, false);
    
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

    private VarDomainType(Js5ConfigGroup js5ConfigGroup, int n2, boolean bl, boolean bl2) {
        this.js5GroupID = js5ConfigGroup;
        this.serialID = n2;
        this.permitPermanentLifetime = bl;
        this.permitClientTransmission = bl2;
    }

    public Object getDefaultValue(ScriptVarType scriptVarType) {
        return scriptVarType.getDefaultValue();
    }
}

