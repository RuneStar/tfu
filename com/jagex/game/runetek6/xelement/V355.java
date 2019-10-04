/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.xelement.Ag97;
import com.jagex.game.runetek6.xelement.Bm108;
import tfu.Gg3;

public class V355
extends Bm108 {
    public static V355 g(Gg3 gg3, int n) {
        int n2 = Gg3.ar(gg3);
        return new V355(n2 != 0);
    }

    V355(boolean bl) {
        super(Ag97.q, bl);
    }

    @Override
    public void d(Gg3 gg3) {
        Gg3.k(gg3, (Boolean)this.r != false ? 1 : 0);
    }
}

