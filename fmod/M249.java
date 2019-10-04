/*
 * Decompiled with CFR 0.146.
 */
package fmod;

import fmod.B561;
import fmod.fmod;

public class M249 {
    private long g;

    public M249(long l) {
        this.g = l;
    }

    public B561 g() {
        B561 b561 = new B561();
        fmod.EventCategory_getInfo(this.g, b561);
        return b561;
    }

    public String toString() {
        return this.g().g;
    }

    public static int d(M249 m249, float f) {
        return fmod.EventCategory_setVolume(m249.g, f);
    }
}

