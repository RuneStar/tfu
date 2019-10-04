/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.xelement.Au64;
import com.jagex.game.runetek6.xelement.Bj61;
import tfu.Gg3;
import tfu.Hi86;
import tfu.Hp62;
import tfu.Ia63;
import tfu.Id102;

final class K67
implements Ia63 {
    public Bj61 g(byte[] arrby, Integer n, Hi86 hi86) throws Id102 {
        try {
            return Bj61.q(new Gg3(arrby));
        }
        catch (Au64 au64) {
            throw new Id102("Exception whilst constructing an animation set", au64);
        }
    }

    K67() {
    }

    @Override
    public boolean resourceNeedsRefCounting() {
        return false;
    }
}

