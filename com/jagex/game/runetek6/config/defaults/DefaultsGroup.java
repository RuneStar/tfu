// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.defaults;

public enum DefaultsGroup
{
    AUDIO("AUDIO", 2, 4), 
    ERROR("ERROR", 4, 10), 
    GRAPHICS("GRAPHICS", 1, 3), 
    MAP("MAP", 0, 1), 
    MICROTRANSACTION("MICROTRANSACTION", 3, 5);
    
    public final int js5GroupId;
    
    private DefaultsGroup(final String name, final int ordinal, final int js5GroupId) {
        this.js5GroupId = js5GroupId;
    }
}
