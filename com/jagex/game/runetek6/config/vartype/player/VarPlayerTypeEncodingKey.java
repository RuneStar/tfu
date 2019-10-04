// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.vartype.player;

import com.jagex.core.constants.J204;

@Deprecated
@Deprecated
@Deprecated
@Deprecated
public enum VarPlayerTypeEncodingKey implements J204
{
    CLANDATA("CLANDATA", 7, 107), 
    @Deprecated
    CLIENTCODE("CLIENTCODE", 10, 110), 
    @Deprecated
    GENERALPURPOSE("GENERALPURPOSE", 9, 109), 
    HISCOREDATA("HISCOREDATA", 5, 105), 
    LEGACYID("LEGACYID", 13, 113), 
    @Deprecated
    MASTERQUEST("MASTERQUEST", 11, 111), 
    PLOGDATA("PLOGDATA", 6, 106), 
    PROTECTEDACCESSREQUIRED("PROTECTEDACCESSREQUIRED", 0, 100), 
    @Deprecated
    QUESTPOINTS("QUESTPOINTS", 12, 112), 
    SENDTOGAMELOGWORLD("SENDTOGAMELOGWORLD", 3, 103), 
    SETVARALLOWED("SETVARALLOWED", 1, 101), 
    TRANSMITLEVELOTHER("TRANSMITLEVELOTHER", 8, 108), 
    WARNONDECREASE("WARNONDECREASE", 4, 104), 
    WEALTHEQUIVALENT("WEALTHEQUIVALENT", 2, 102);
    
    private final int serialID;
    
    private VarPlayerTypeEncodingKey(final String name, final int ordinal, final int serialID) {
        this.serialID = serialID;
    }
    
    @Override
    public int getId() {
        return this.serialID;
    }
}
