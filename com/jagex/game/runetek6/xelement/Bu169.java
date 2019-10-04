/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.xelement.Ag97;
import com.jagex.game.runetek6.xelement.Bm108;
import tfu.Gg3;

public class Bu169
extends Bm108 {
    public static Bu169 g(Gg3 gg3, int n) {
        String string = gg3.bp();
        return new Bu169(string);
    }

    @Override
    public void d(Gg3 gg3) {
        Gg3.ao(gg3, (CharSequence)this.r);
    }

    Bu169(String string) {
        super(Ag97.g, string);
    }
}

