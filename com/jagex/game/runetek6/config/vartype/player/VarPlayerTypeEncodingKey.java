/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.vartype.player;

import com.jagex.core.constants.J204;

@Deprecated
@Deprecated
@Deprecated
@Deprecated
public enum VarPlayerTypeEncodingKey implements J204
{
    PROTECTEDACCESSREQUIRED(100),
    SETVARALLOWED(101),
    WEALTHEQUIVALENT(102),
    SENDTOGAMELOGWORLD(103),
    WARNONDECREASE(104),
    HISCOREDATA(105),
    PLOGDATA(106),
    CLANDATA(107),
    TRANSMITLEVELOTHER(108),
    GENERALPURPOSE(109),
    CLIENTCODE(110),
    MASTERQUEST(111),
    QUESTPOINTS(112),
    LEGACYID(113);
    
    private final int serialID;

    private VarPlayerTypeEncodingKey(int n2) {
        this.serialID = n2;
    }

    @Override
    public int getId() {
        return this.serialID;
    }
}

