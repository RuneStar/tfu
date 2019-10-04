/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

public enum Bv116 {
    ATTACHMENT_POINT(1, -1),
    POSITION(4, 12),
    ORIENTATION(5, 16),
    SCALE(6, 4),
    SUPER_TYPE_PROPERTIES(255, -1),
    UNKNOWN(Integer.MAX_VALUE, -1);
    
    public final int b;
    public final int s;

    public static Bv116 g(int n) {
        for (Bv116 bv116 : Bv116.values()) {
            if (bv116.s != n) continue;
            return bv116;
        }
        return UNKNOWN;
    }

    private Bv116(int n2, int n3) {
        this.s = n2;
        this.b = n3;
    }
}

