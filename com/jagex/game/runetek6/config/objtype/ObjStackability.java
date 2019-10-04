/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.objtype;

import com.jagex.core.constants.J204;

public enum ObjStackability implements J204
{
    SOMETIMES(0),
    ALWAYS(1),
    NEVER(2);
    
    private final int id;

    private ObjStackability(int n2) {
        this.id = n2;
    }

    @Override
    public int getId() {
        return this.id;
    }
}

