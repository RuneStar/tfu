// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import tfu.Hi86;
import tfu.Hg85;
import tfu.Hk84;
import tfu.Gg3;

public class Ao74 extends Am76
{
    public String d;
    
    public static Ao74 w(final Gg3 gg3, final D80 d80) throws Au64 {
        final Ao74 ao74 = new Ao74(d80);
        int ar;
        while ((ar = Gg3.ar(gg3)) != 0) {
            final H89 g = H89.g(ar);
            final int i = (g.e != -1) ? g.e : Gg3.bd(gg3);
            final int n = gg3.v + i;
            switch (Bd88.g[g.ordinal()]) {
                case 1: {
                    ao74.d = gg3.bh();
                    break;
                }
                case 2: {
                    Am76.eo(ao74, gg3);
                    break;
                }
                default: {
                    gg3.v += i;
                    break;
                }
            }
            if (gg3.v != n) {
                throw new Au64("Chunk length mismatch when deserialising " + g + ": expected " + i + " bytes, read " + (gg3.v - (n - i)) + " bytes");
            }
        }
        return ao74;
    }
    
    @Override
    public void r(final Gg3 gg3, final Hk84 hk84, final Hg85 hg85, final Hi86 hi86) {
        if (this.d != null) {
            Gg3.k(gg3, H89.SYSTEM_NAME.j);
            Gg3.a(gg3, Gg3.av(this.d));
            gg3.ap(this.d);
        }
        Gg3.k(gg3, H89.SUPER_TYPE_PROPERTIES.j);
        final int v = gg3.v + 4;
        gg3.v = v;
        final int n = v;
        super.r(gg3, hk84, hg85, hi86);
        Gg3.am(gg3, gg3.v - n);
        Gg3.k(gg3, 0);
    }
    
    public Ao74(final D80 d80) {
        super(d80);
    }
}
