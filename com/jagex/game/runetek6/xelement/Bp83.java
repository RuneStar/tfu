/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.xelement.Au64;
import com.jagex.game.runetek6.xelement.Bh77;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.game.runetek6.xelement.XElementLibrary;
import tfu.Gg3;
import tfu.Hi86;
import tfu.Hp62;
import tfu.Ia63;
import tfu.Id102;

final class Bp83
implements Ia63 {
    @Override
    public boolean resourceNeedsRefCounting() {
        return false;
    }

    Bp83() {
    }

    public Bh77 g(byte[] arrby, Integer n, Hi86 hi86) throws Id102 {
        try {
            return Bh77.w(new Gg3(arrby), XElement.ai);
        }
        catch (Au64 au64) {
            throw new Id102(au64);
        }
    }
}

