/*
 * Decompiled with CFR 0.146.
 */
package fmod;

import fmod.V241;
import fmod.fmod;

public class H238 {
    public long g = 0L;

    public static boolean g(H238 h238) {
        return h238.g != 0L;
    }

    public H238(long l) {
        this.g = l;
    }

    public static int q(H238 h238, int n) {
        return fmod.Channel_getPosition(h238.g, n);
    }

    public V241 d() {
        return new V241(fmod.Channel_getCurrentSound(this.g));
    }

    public static int j(H238 h238, int n, int n2) {
        return fmod.Channel_setPosition(h238.g, n, n2);
    }
}

