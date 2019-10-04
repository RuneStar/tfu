/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.vartype.constants;

import com.jagex.core.constants.J204;

public enum VarLifetime implements J204
{
    TEMPORARY(0),
    PERMANENT(1);
    
    private final int serialID;

    private VarLifetime(int n2) {
        this.serialID = n2;
    }

    @Override
    public int getId() {
        return this.serialID;
    }
}

