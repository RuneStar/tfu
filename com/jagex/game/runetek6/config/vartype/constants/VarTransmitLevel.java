// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.vartype.constants;

import com.jagex.core.constants.J204;

public enum VarTransmitLevel implements J204
{
    NEVER("NEVER", 0, 0), 
    ON_SET_ALWAYS("ON_SET_ALWAYS", 2, 2), 
    ON_SET_DIFFERENT("ON_SET_DIFFERENT", 1, 1);
    
    private final int serialID;
    
    @Override
    public int getId() {
        return this.serialID;
    }
    
    private VarTransmitLevel(final String name, final int ordinal, final int serialID) {
        this.serialID = serialID;
    }
}
