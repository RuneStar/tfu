/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.xelement.Ar110;
import tfu.Gg3;
import tfu.Hi86;
import tfu.Hp62;
import tfu.Ia63;
import tfu.Id102;

final class Ac112
implements Ia63 {
    public Ar110 g(byte[] arrby, Integer n, Hi86 hi86) throws Id102 {
        return Ar110.g(new Gg3(arrby));
    }

    Ac112() {
    }

    @Override
    public boolean resourceNeedsRefCounting() {
        return false;
    }
}

