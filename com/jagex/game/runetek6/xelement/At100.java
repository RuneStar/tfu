/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.xelement.T101;
import tfu.Gg3;
import tfu.Hi86;
import tfu.Hp62;
import tfu.Ia63;
import tfu.Id102;

final class At100
implements Ia63 {
    public T101 g(byte[] arrby, Integer n, Hi86 hi86) throws Id102 {
        return T101.g(new Gg3(arrby));
    }

    @Override
    public boolean resourceNeedsRefCounting() {
        return false;
    }

    At100() {
    }
}

