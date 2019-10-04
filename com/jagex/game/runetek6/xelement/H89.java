/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

public enum H89 {
    SYSTEM_NAME(1, -1),
    SUPER_TYPE_PROPERTIES(255, -1),
    UNKNOWN(Integer.MAX_VALUE, -1);
    
    public final int e;
    public final int j;

    public static H89 g(int n) {
        for (H89 h89 : H89.values()) {
            if (h89.j != n) continue;
            return h89;
        }
        return UNKNOWN;
    }

    private H89(int n2, int n3) {
        this.j = n2;
        this.e = n3;
    }
}

