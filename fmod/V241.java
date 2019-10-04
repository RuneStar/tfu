/*
 * Decompiled with CFR 0.146.
 */
package fmod;

import fmod.fmod;

public class V241 {
    long g = 0L;

    public V241(long l) {
        this.g = l;
    }

    public static int g(V241 v241, int n) {
        return fmod.Sound_getLength(v241.g, n);
    }
}

