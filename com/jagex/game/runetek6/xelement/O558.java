// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

public enum O558
{
    HEIGHT_MAP("HEIGHT_MAP", 1, 2, -1), 
    MISC_PROPERTIES("MISC_PROPERTIES", 0, 1, 16), 
    UNKNOWN("UNKNOWN", 3, Integer.MAX_VALUE, -1), 
    XML("XML", 2, 254, -1);
    
    public final int e;
    public final int h;
    
    private O558(final String name, final int ordinal, final int e, final int h) {
        this.e = e;
        this.h = h;
    }
    
    public static O558 g(final int n) {
        for (final O558 o558 : values()) {
            if (o558.e == n) {
                return o558;
            }
        }
        return O558.UNKNOWN;
    }
}
