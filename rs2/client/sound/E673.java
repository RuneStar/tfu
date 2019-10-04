/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import java.util.ArrayList;
import java.util.LinkedList;
import rs2.client.sound.K589;
import rs2.client.sound.X675;
import rs2.client.sound.Z674;
import tfu.Gg3;

final class E673
implements Z674 {
    @Override
    public void g(String string, Object object) {
    }

    @Override
    public void d(byte[] arrby, Object object) {
        int n;
        K589.q.clear();
        K589.j.clear();
        Gg3 gg3 = new Gg3(arrby);
        int n2 = Gg3.au(gg3);
        for (n = 0; n < n2; ++n) {
            K589.j.add(Gg3.bk(gg3));
        }
        n = Gg3.au(gg3);
        for (int i = 0; i < n; ++i) {
            X675 x675 = new X675();
            x675.p(gg3);
            K589.q.add(x675);
        }
        K589.w = System.currentTimeMillis() + 33L;
        K589.d = true;
        if (K589.e != null) {
            K589.h(K589.e, K589.h);
            K589.h = null;
            K589.e = null;
        }
        K589.l = System.currentTimeMillis();
    }

    E673() {
    }

    @Override
    public void q() {
    }
}

