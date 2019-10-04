// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import tfu.Id102;
import tfu.Gg3;
import java.util.ArrayList;
import tfu.Ia63;
import tfu.Hp62;

public final class Ar110 implements Hp62
{
    public static final Ia63 g;
    private static final int q = 1;
    public final ArrayList d;
    
    public Ar110() {
        this.d = new ArrayList();
    }
    
    public static Ar110 g(final Gg3 gg3) throws Id102 {
        final int ar = Gg3.ar(gg3);
        if (ar > 1) {
            throw new Id102("Unsupported version " + ar);
        }
        final int bd = Gg3.bd(gg3);
        final Ar110 ar2 = new Ar110();
        for (int i = 0; i < bd; ++i) {
            final Aa111 e = new Aa111();
            e.g = Gg3.ar(gg3);
            e.d = Gg3.bl(gg3);
            e.q = Gg3.bl(gg3);
            e.j = Gg3.bl(gg3);
            e.e = Gg3.bl(gg3);
            e.h = Gg3.bl(gg3);
            e.s = Gg3.bd(gg3);
            e.b = Gg3.bl(gg3);
            e.l = Gg3.bl(gg3);
            e.w = Gg3.bl(gg3);
            e.r = Gg3.bl(gg3);
            e.v = (Gg3.ar(gg3) == 1);
            e.y = (Gg3.ar(gg3) == 1);
            e.p = (Gg3.ar(gg3) == 1);
            ar2.d.add(e);
        }
        return ar2;
    }
    
    @Override
    public void onAllRefsReleased() {
    }
    
    static {
        g = new Ac112();
    }
}
