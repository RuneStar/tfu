/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.xelement.Ag97;
import com.jagex.game.runetek6.xelement.Bm108;
import tfu.Gg3;

public class Aq107
extends Bm108 {
    @Override
    public void d(Gg3 gg3) {
        Gg3.aq(gg3, (float)((Double)this.r).doubleValue());
    }

    public static Aq107 g(Gg3 gg3, int n) {
        float f = Gg3.bl(gg3);
        return new Aq107(f);
    }

    Aq107(double d) {
        super(Ag97.d, d);
    }
}

