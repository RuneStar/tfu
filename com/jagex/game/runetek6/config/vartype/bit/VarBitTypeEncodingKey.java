// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.vartype.bit;

import com.jagex.core.constants.J204;

@Deprecated
@Deprecated
public enum VarBitTypeEncodingKey implements J204
{
    BASEVAR("BASEVAR", 0, 1), 
    BITS("BITS", 1, 2), 
    DEBUGNAME("DEBUGNAME", 10, 11), 
    IGNOREOVERLAP("IGNOREOVERLAP", 11, 12), 
    @Deprecated
    MASTERQUEST("MASTERQUEST", 3, 4), 
    @Deprecated
    QUESTPOINTS("QUESTPOINTS", 4, 5), 
    SENDTOGAMELOGWORLD("SENDTOGAMELOGWORLD", 7, 8), 
    SETVARALLOWED("SETVARALLOWED", 6, 7), 
    TRANSMITLEVEL("TRANSMITLEVEL", 8, 9), 
    TRANSMITLEVELOTHER("TRANSMITLEVELOTHER", 9, 10), 
    VARBITNAME_HASH32("VARBITNAME_HASH32", 12, 13), 
    WARNONDECREASE("WARNONDECREASE", 2, 3), 
    WEALTHEQUIVALENT("WEALTHEQUIVALENT", 5, 6);
    
    private final int serialID;
    
    @Override
    public int getId() {
        return this.serialID;
    }
    
    private VarBitTypeEncodingKey(final String name, final int ordinal, final int serialID) {
        this.serialID = serialID;
    }
}
