/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.defaults;

public enum DefaultsGroup {
    MAP(1),
    GRAPHICS(3),
    AUDIO(4),
    MICROTRANSACTION(5),
    ERROR(10);
    
    public final int js5GroupId;

    private DefaultsGroup(int n2) {
        this.js5GroupId = n2;
    }
}

