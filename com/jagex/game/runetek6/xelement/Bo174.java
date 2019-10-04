/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

public enum Bo174 {
    RADIUS(1, 4),
    COLOUR(2, 12),
    SUPER_TYPE_PROPERTIES(255, -1),
    UNKNOWN(Integer.MAX_VALUE, -1);
    
    public final int e;
    public final int h;

    private Bo174(int n2, int n3) {
        this.e = n2;
        this.h = n3;
    }

    public static Bo174 g(int n) {
        for (Bo174 bo174 : Bo174.values()) {
            if (bo174.e != n) continue;
            return bo174;
        }
        return UNKNOWN;
    }
}

