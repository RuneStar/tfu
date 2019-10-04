/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import fmod.E245;
import fmod.Q244;
import fmod.X243;
import rs2.client.sound.H591;
import rs2.client.sound.SoundManager;

class L681 {
    public float d;
    public X243 g;
    private String j;
    public H591 q;
    final /* synthetic */ H591 e;

    public static void g(L681 l681, Q244 q244) {
        if (X243.y(l681.g)) {
            X243.c(l681.g);
            H591.p(l681.e).remove(l681.g);
        }
        l681.g = E245.v(SoundManager.c, l681.j);
        if (X243.h(l681.g)) {
            X243.u(l681.g, q244);
            X243.i(l681.g, l681.d * l681.e.g);
            l681.g.a();
            H591.p(l681.e).add(l681.g);
        }
    }

    public L681(H591 h591, String string, float f, H591 h5912) {
        this.e = h591;
        this.j = string;
        this.q = h5912;
        this.g = E245.v(SoundManager.c, string);
        this.d = f;
    }
}

