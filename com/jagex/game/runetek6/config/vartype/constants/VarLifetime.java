// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.vartype.constants;

import com.jagex.core.constants.J204;

public enum VarLifetime implements J204
{
    PERMANENT("PERMANENT", 1, 1), 
    TEMPORARY("TEMPORARY", 0, 0);
    
    private final int serialID;
    
    private VarLifetime(final String name, final int ordinal, final int serialID) {
        this.serialID = serialID;
    }
    
    @Override
    public int getId() {
        return this.serialID;
    }
}
