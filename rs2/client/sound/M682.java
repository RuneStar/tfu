/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import rs2.client.sound.K589;
import rs2.client.sound.N680;
import rs2.client.sound.X675;
import rs2.client.sound.Z674;

class M682
implements Z674 {
    final /* synthetic */ X675 g;

    @Override
    public void g(String string, Object object) {
        X675 x675 = (X675)object;
        X675.z(x675);
        if (K589.b != null) {
            X675.h(K589.b);
        }
        X675.h(this.g);
        long l = 0L;
        X675 x6752 = K589.s;
        if (x6752 == null) {
            X675.g(this.g);
        } else if (x6752 != null && X675.w(x6752)) {
            long l2;
            long l3 = l2 = K589.s == null ? 0L : X675.x(K589.s);
            long l4 = l3 / (long)x6752.r;
            l = ++l4 * (long)x6752.r - l3;
            long l5 = l2 + l;
            if (x6752 != x675) {
                if (K589.s != null && l5 > (long)X675.u(K589.s)) {
                    l5 %= (long)X675.u(K589.s);
                }
                X675.s(x675, new N680(0, l5));
                K589.b = x675;
            }
        }
    }

    @Override
    public void d(byte[] arrby, Object object) {
    }

    @Override
    public void q() {
    }

    M682(X675 x675) {
        this.g = x675;
    }
}

