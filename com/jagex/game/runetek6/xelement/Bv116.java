// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

public enum Bv116
{
    POSITION("POSITION", 1, 4, 12), 
    SUPER_TYPE_PROPERTIES("SUPER_TYPE_PROPERTIES", 4, 255, -1), 
    ATTACHMENT_POINT("ATTACHMENT_POINT", 0, 1, -1), 
    UNKNOWN("UNKNOWN", 5, Integer.MAX_VALUE, -1), 
    SCALE("SCALE", 3, 6, 4), 
    ORIENTATION("ORIENTATION", 2, 5, 16);
    
    public final int b;
    public final int s;
    
    public static Bv116 g(final int n) {
        for (final Bv116 bv116 : values()) {
            if (bv116.s == n) {
                return bv116;
            }
        }
        return Bv116.UNKNOWN;
    }
    
    private Bv116(final String name, final int ordinal, final int s, final int b) {
        this.s = s;
        this.b = b;
    }
}
