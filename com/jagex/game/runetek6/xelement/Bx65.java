// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

enum Bx65
{
    UNKNOWN("UNKNOWN", 1, -1), 
    ANIMATIONS("ANIMATIONS", 0, 1);
    
    public final int q;
    
    public static Bx65 g(final int n) {
        for (final Bx65 bx65 : values()) {
            if (bx65.q == n) {
                return bx65;
            }
        }
        return Bx65.UNKNOWN;
    }
    
    private Bx65(final String name, final int ordinal, final int q) {
        this.q = q;
    }
}
