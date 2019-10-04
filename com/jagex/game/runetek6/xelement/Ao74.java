/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.xelement.Am76;
import com.jagex.game.runetek6.xelement.Au64;
import com.jagex.game.runetek6.xelement.D80;
import com.jagex.game.runetek6.xelement.H89;
import tfu.Gg3;
import tfu.Hg85;
import tfu.Hi86;
import tfu.Hk84;

public class Ao74
extends Am76 {
    public String d;

    public static Ao74 w(Gg3 gg3, D80 d80) throws Au64 {
        int n;
        Ao74 ao74 = new Ao74(d80);
        while ((n = Gg3.ar(gg3)) != 0) {
            H89 h89 = H89.g(n);
            int n2 = h89.e != -1 ? h89.e : Gg3.bd(gg3);
            int n3 = gg3.v + n2;
            switch (h89) {
                case SYSTEM_NAME: {
                    ao74.d = gg3.bh();
                    break;
                }
                case SUPER_TYPE_PROPERTIES: {
                    Am76.eo(ao74, gg3);
                    break;
                }
                default: {
                    gg3.v += n2;
                }
            }
            if (gg3.v == n3) continue;
            throw new Au64("Chunk length mismatch when deserialising " + (Object)((Object)h89) + ": expected " + n2 + " bytes, read " + (gg3.v - (n3 - n2)) + " bytes");
        }
        return ao74;
    }

    @Override
    public void r(Gg3 gg3, Hk84 hk84, Hg85 hg85, Hi86 hi86) {
        if (this.d != null) {
            Gg3.k(gg3, H89.SYSTEM_NAME.j);
            Gg3.a(gg3, Gg3.av(this.d));
            gg3.ap(this.d);
        }
        Gg3.k(gg3, H89.SUPER_TYPE_PROPERTIES.j);
        int n = gg3.v += 4;
        super.r(gg3, hk84, hg85, hi86);
        Gg3.am(gg3, gg3.v - n);
        Gg3.k(gg3, 0);
    }

    public Ao74(D80 d80) {
        super(d80);
    }
}

