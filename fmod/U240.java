/*
 * Decompiled with CFR 0.146.
 */
package fmod;

import fmod.fmod;

public class U240 {
    public long g = 0L;

    public static int g(U240 u240) {
        return fmod.getChannelsPlaying();
    }

    public U240(long l) {
        this.g = l;
    }
}

