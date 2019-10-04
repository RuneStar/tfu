/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.vartype.constants;

import com.jagex.core.constants.J204;

public enum VarTransmitLevel implements J204
{
    NEVER(0),
    ON_SET_DIFFERENT(1),
    ON_SET_ALWAYS(2);
    
    private final int serialID;

    @Override
    public int getId() {
        return this.serialID;
    }

    private VarTransmitLevel(int n2) {
        this.serialID = n2;
    }
}

