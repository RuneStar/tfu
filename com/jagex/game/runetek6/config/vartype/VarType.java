/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.vartype;

import com.jagex.game.runetek6.config.vartype.constants.ScriptVarType;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import com.jagex.game.runetek6.config.vartype.constants.VarLifetime;
import com.jagex.game.runetek6.config.vartype.constants.VarTransmitLevel;
import tfu.Gg3;
import tfu.Gp293;

public abstract class VarType
implements Gp293 {
    public VarTransmitLevel clientTransmitLevel;
    public ScriptVarType dataType;
    public String debugName;
    public int debugNameHash32;
    public final VarDomainType domain;
    public final int id;
    public VarLifetime lifeTime = VarLifetime.TEMPORARY;

    public VarType(VarDomainType varDomainType, int n) {
        this.clientTransmitLevel = VarTransmitLevel.NEVER;
        this.domain = varDomainType;
        this.id = n;
    }

    public void decode(Gg3 gg3) {
        int n = Gg3.ar(gg3);
    }

    public abstract void decode(Gg3 var1, int var2);

    @Override
    public boolean isValidDefinition() {
        return this.domain != null && this.dataType != null;
    }

    public Object getDefaultValue() {
        return this.domain.getDefaultValue(this.dataType);
    }
}

