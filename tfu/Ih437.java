/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import tfu.Gg3;
import tfu.Hi86;
import tfu.Hp62;
import tfu.Ia63;
import tfu.Id102;
import tfu.Iz11;

final class Ih437
implements Ia63 {
    Ih437() {
    }

    public Iz11 g(byte[] arrby, Integer n, Hi86 hi86) {
        boolean bl = false;
        boolean bl2 = false;
        return Iz11.g(new Gg3(arrby), hi86, false, bl, bl2);
    }

    @Override
    public boolean resourceNeedsRefCounting() {
        return false;
    }
}

