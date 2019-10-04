/*
 * Decompiled with CFR 0.146.
 */
package fmod;

import fmod.fmod;

public class L250 {
    private long g;

    public static int d(L250 l250) {
        return fmod.EventParameter_keyOff(l250.g);
    }

    public static boolean g(L250 l250) {
        return l250.g != 0L;
    }

    public static int q(L250 l250, float f) {
        return fmod.EventParameter_setValue(l250.g, f);
    }

    public L250(long l) {
        this.g = l;
    }
}

