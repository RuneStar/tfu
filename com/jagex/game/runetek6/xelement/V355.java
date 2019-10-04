// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import tfu.Gg3;

public class V355 extends Bm108
{
    public static V355 g(final Gg3 gg3, final int n) {
        return new V355(Gg3.ar(gg3) != 0);
    }
    
    V355(final boolean b) {
        super(Ag97.q, b);
    }
    
    @Override
    public void d(final Gg3 gg3) {
        Gg3.k(gg3, ((boolean)super.r) ? 1 : 0);
    }
}
