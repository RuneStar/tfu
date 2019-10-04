// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

public enum Ax92
{
    LIGHTS("LIGHTS", 1, 2, -1), 
    ELEMENTS("ELEMENTS", 0, 1, -1), 
    PARTICLE_SYSTEMS("PARTICLE_SYSTEMS", 2, 3, -1);
    
    public final int e;
    public final int j;
    
    private Ax92(final String name, final int ordinal, final int j, final int e) {
        this.j = j;
        this.e = e;
    }
    
    public static Ax92 g(final int n) {
        for (final Ax92 ax92 : values()) {
            if (ax92.j == n) {
                return ax92;
            }
        }
        return null;
    }
}
