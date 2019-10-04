/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.xelement.Au64;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.game.runetek6.xelement.XElementLibrary;
import tfu.Gg3;
import tfu.Hi86;
import tfu.Hp62;
import tfu.Ia63;
import tfu.Id102;

class Ab205
implements Ia63 {
    final /* synthetic */ XElementLibrary g;

    public XElement g(byte[] arrby, Integer n, Hi86 hi86) throws Id102 {
        try {
            return XElement.by(new Gg3(arrby), this.g);
        }
        catch (Au64 au64) {
            throw new Id102(au64);
        }
    }

    @Override
    public boolean resourceNeedsRefCounting() {
        return false;
    }

    Ab205(XElementLibrary xElementLibrary) {
        this.g = xElementLibrary;
    }
}

