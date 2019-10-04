/*
 * Decompiled with CFR 0.146.
 */
package fmod;

import fmod.H238;
import fmod.fmod;

public class S237 {
    public long g;

    public S237(long l) {
        this.g = l;
    }

    public static boolean g(S237 s237) {
        return s237.g != 0L;
    }

    public H238 d(int n) {
        return new H238(fmod.ChannelGroup_getChannel(this.g, n));
    }

    public static int q(S237 s237) {
        return fmod.ChannelGroup_getNumChannels(s237.g);
    }
}

