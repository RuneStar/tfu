// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.vartype;

import tfu.Gg3;
import com.jagex.game.runetek6.config.vartype.constants.VarLifetime;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import com.jagex.game.runetek6.config.vartype.constants.ScriptVarType;
import com.jagex.game.runetek6.config.vartype.constants.VarTransmitLevel;
import tfu.Gp293;

public abstract class VarType implements Gp293
{
    public VarTransmitLevel clientTransmitLevel;
    public ScriptVarType dataType;
    public String debugName;
    public int debugNameHash32;
    public final VarDomainType domain;
    public final int id;
    public VarLifetime lifeTime;
    
    public VarType(final VarDomainType domain, final int id) {
        this.lifeTime = VarLifetime.TEMPORARY;
        this.clientTransmitLevel = VarTransmitLevel.NEVER;
        this.domain = domain;
        this.id = id;
    }
    
    public void decode(final Gg3 gg3) {
        Gg3.ar(gg3);
    }
    
    public abstract void decode(final Gg3 p0, final int p1);
    
    @Override
    public boolean isValidDefinition() {
        return this.domain != null && this.dataType != null;
    }
    
    public Object getDefaultValue() {
        return this.domain.getDefaultValue(this.dataType);
    }
}
