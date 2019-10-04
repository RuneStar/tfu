// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.vartype;

import com.jagex.core.constants.J204;

public enum VarTypeEncodingKey implements J204
{
    DEBUGNAME("DEBUGNAME", 0, 1), 
    DOMAIN("DOMAIN", 1, 2), 
    LIFETIME("LIFETIME", 3, 4), 
    TRANSMITLEVEL("TRANSMITLEVEL", 4, 5), 
    TYPE("TYPE", 2, 3), 
    VARNAME_HASH32("VARNAME_HASH32", 5, 6);
    
    private final int serialID;
    
    private VarTypeEncodingKey(final String name, final int ordinal, final int serialID) {
        this.serialID = serialID;
    }
    
    @Override
    public int getId() {
        return this.serialID;
    }
}
