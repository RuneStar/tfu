/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import java.util.Hashtable;
import rs2.client.sound.Ag588;
import rs2.client.sound.Z674;
import tfu.Gg3;

final class V696
implements Z674 {
    @Override
    public void d(byte[] arrby, Object object) {
        Gg3 gg3 = new Gg3(arrby);
        int n = Gg3.au(gg3);
        Ag588.e.clear();
        for (int i = 0; i < n; ++i) {
            Ag588 ag588 = new Ag588();
            int n2 = Gg3.au(gg3);
            ag588.d = Gg3.bk(gg3);
            ag588.q = Gg3.bk(gg3);
            ag588.j = Gg3.bk(gg3);
            int n3 = Gg3.au(gg3);
            for (int j = 0; j < n3; ++j) {
                String string = Gg3.bk(gg3);
                String string2 = Gg3.bk(gg3);
                ag588.g.put(string, string2);
                if (j != 22) continue;
                int n4 = 0;
                ++n4;
            }
            Ag588.e.put(n2, ag588);
        }
    }

    @Override
    public void g(String string, Object object) {
    }

    @Override
    public void q() {
        Ag588.e.clear();
    }

    V696() {
    }
}

