/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

enum Bx65 {
    ANIMATIONS(1),
    UNKNOWN(-1);
    
    public final int q;

    public static Bx65 g(int n) {
        for (Bx65 bx65 : Bx65.values()) {
            if (bx65.q != n) continue;
            return bx65;
        }
        return UNKNOWN;
    }

    private Bx65(int n2) {
        this.q = n2;
    }
}

