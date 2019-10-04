// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.objtype;

import com.jagex.core.constants.J204;

public enum ObjStackability implements J204
{
    ALWAYS("ALWAYS", 1, 1), 
    NEVER("NEVER", 2, 2), 
    SOMETIMES("SOMETIMES", 0, 0);
    
    private final int id;
    
    private ObjStackability(final String name, final int ordinal, final int id) {
        this.id = id;
    }
    
    @Override
    public int getId() {
        return this.id;
    }
}
