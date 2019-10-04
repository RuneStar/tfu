/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import rs2.client.sound.H591;
import rs2.client.sound.O678;
import rs2.client.sound.Z674;

class S677
implements Z674 {
    final /* synthetic */ H591 g;

    S677(H591 h591) {
        this.g = h591;
    }

    @Override
    public void d(byte[] arrby, Object object) {
    }

    @Override
    public void q() {
    }

    @Override
    public void g(String string, Object object) {
        H591 h591 = (H591)object;
        this.g.y(h591.h);
        h591.q = O678.PLAYING;
        h591.e = true;
    }
}

