/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

public enum O558 {
    MISC_PROPERTIES(1, 16),
    HEIGHT_MAP(2, -1),
    XML(254, -1),
    UNKNOWN(Integer.MAX_VALUE, -1);
    
    public final int e;
    public final int h;

    private O558(int n2, int n3) {
        this.e = n2;
        this.h = n3;
    }

    public static O558 g(int n) {
        for (O558 o558 : O558.values()) {
            if (o558.e != n) continue;
            return o558;
        }
        return UNKNOWN;
    }
}

