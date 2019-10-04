// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

public enum Bo174
{
    COLOUR("COLOUR", 1, 2, 12), 
    RADIUS("RADIUS", 0, 1, 4), 
    UNKNOWN("UNKNOWN", 3, Integer.MAX_VALUE, -1), 
    SUPER_TYPE_PROPERTIES("SUPER_TYPE_PROPERTIES", 2, 255, -1);
    
    public final int e;
    public final int h;
    
    private Bo174(final String name, final int ordinal, final int e, final int h) {
        this.e = e;
        this.h = h;
    }
    
    public static Bo174 g(final int n) {
        for (final Bo174 bo174 : values()) {
            if (bo174.e == n) {
                return bo174;
            }
        }
        return Bo174.UNKNOWN;
    }
}
