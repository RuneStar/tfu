// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

public enum H89
{
    SUPER_TYPE_PROPERTIES("SUPER_TYPE_PROPERTIES", 1, 255, -1), 
    SYSTEM_NAME("SYSTEM_NAME", 0, 1, -1), 
    UNKNOWN("UNKNOWN", 2, Integer.MAX_VALUE, -1);
    
    public final int e;
    public final int j;
    
    public static H89 g(final int n) {
        for (final H89 h89 : values()) {
            if (h89.j == n) {
                return h89;
            }
        }
        return H89.UNKNOWN;
    }
    
    private H89(final String name, final int ordinal, final int j, final int e) {
        this.j = j;
        this.e = e;
    }
}
