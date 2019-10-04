/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.vartype.bit;

import com.jagex.core.constants.J204;

@Deprecated
@Deprecated
public enum VarBitTypeEncodingKey implements J204
{
    BASEVAR(1),
    BITS(2),
    WARNONDECREASE(3),
    MASTERQUEST(4),
    QUESTPOINTS(5),
    WEALTHEQUIVALENT(6),
    SETVARALLOWED(7),
    SENDTOGAMELOGWORLD(8),
    TRANSMITLEVEL(9),
    TRANSMITLEVELOTHER(10),
    DEBUGNAME(11),
    IGNOREOVERLAP(12),
    VARBITNAME_HASH32(13);
    
    private final int serialID;

    @Override
    public int getId() {
        return this.serialID;
    }

    private VarBitTypeEncodingKey(int n2) {
        this.serialID = n2;
    }
}

