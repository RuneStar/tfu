/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

public enum Ax92 {
    ELEMENTS(1, -1),
    LIGHTS(2, -1),
    PARTICLE_SYSTEMS(3, -1);
    
    public final int e;
    public final int j;

    private Ax92(int n2, int n3) {
        this.j = n2;
        this.e = n3;
    }

    public static Ax92 g(int n) {
        for (Ax92 ax92 : Ax92.values()) {
            if (ax92.j != n) continue;
            return ax92;
        }
        return null;
    }
}

