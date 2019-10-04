/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.xelement.Ag97;
import com.jagex.game.runetek6.xelement.Bm108;
import com.jagex.maths.V198;
import tfu.Gg3;

public class Ah203
extends Bm108 {
    public static Ah203 g(Gg3 gg3, int n) {
        V198 v198 = new V198(gg3);
        return new Ah203(v198);
    }

    @Override
    public void d(Gg3 gg3) {
        V198.g((V198)this.r, gg3);
    }

    Ah203(V198 v198) {
        super(Ag97.e, v198);
    }
}

