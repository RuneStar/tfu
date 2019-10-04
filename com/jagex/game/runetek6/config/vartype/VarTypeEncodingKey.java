/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.vartype;

import com.jagex.core.constants.J204;

public enum VarTypeEncodingKey implements J204
{
    DEBUGNAME(1),
    DOMAIN(2),
    TYPE(3),
    LIFETIME(4),
    TRANSMITLEVEL(5),
    VARNAME_HASH32(6);
    
    private final int serialID;

    private VarTypeEncodingKey(int n2) {
        this.serialID = n2;
    }

    @Override
    public int getId() {
        return this.serialID;
    }
}

