/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import fmod.E245;
import fmod.X243;
import rs2.client.sound.C595;
import rs2.client.sound.SoundManager;
import rs2.client.sound.Y603;
import rs2.client.sound.Z674;

final class I684
implements Z674 {
    I684() {
    }

    @Override
    public void d(byte[] arrby, Object object) {
    }

    @Override
    public void q() {
        Y603.d = null;
        Y603.j = null;
        if (Y603.q != null) {
            X243.f(Y603.q);
            Y603.q = null;
        }
    }

    @Override
    public void g(String string, Object object) {
        X243 x243;
        if (--Y603.h <= 0 && Y603.d != null && X243.h(x243 = SoundManager.c.r(Y603.d, 0))) {
            C595[] arrc595;
            X243.i(x243, Y603.e);
            if (Y603.j != null && (arrc595 = SoundManager.f(Y603.j)) != null) {
                for (C595 c595 : arrc595) {
                    x243.ag(c595.g, c595.d);
                }
            }
            x243.a();
            if (Y603.q != null) {
                X243.f(Y603.q);
            }
            Y603.j = null;
            Y603.q = x243;
            Y603.g = Y603.d;
            Y603.d = null;
        }
    }
}

