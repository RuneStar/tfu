/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.xelement.Am76;
import com.jagex.game.runetek6.xelement.Au64;
import com.jagex.game.runetek6.xelement.Bo174;
import com.jagex.game.runetek6.xelement.D80;
import com.jagex.maths.Vector3;
import com.jagex.maths.Y310;
import tfu.Gg3;
import tfu.Hg85;
import tfu.Hi86;
import tfu.Hk84;

public class J113
extends Am76 {
    public float d;
    public Vector3 q = new Vector3(1.0f, 1.0f, 1.0f);

    public static J113 w(Gg3 gg3, D80 d80) throws Au64 {
        int n;
        J113 j113 = new J113(d80);
        while ((n = Gg3.ar(gg3)) != 0) {
            Bo174 bo174 = Bo174.g(n);
            int n2 = bo174.h != -1 ? bo174.h : Gg3.bd(gg3);
            int n3 = gg3.v + n2;
            switch (bo174) {
                case RADIUS: {
                    j113.d = Gg3.bl(gg3);
                    break;
                }
                case COLOUR: {
                    j113.q = new Vector3(Gg3.bl(gg3), Gg3.bl(gg3), Gg3.bl(gg3));
                    break;
                }
                case SUPER_TYPE_PROPERTIES: {
                    Am76.eo(j113, gg3);
                    break;
                }
                default: {
                    gg3.v += n2;
                }
            }
            if (gg3.v == n3) continue;
            throw new Au64("Chunk length mismatch when deserialising " + (Object)((Object)bo174) + ": expected " + n2 + " bytes, read " + (gg3.v - (n3 - n2)) + " bytes");
        }
        return j113;
    }

    @Override
    public void r(Gg3 gg3, Hk84 hk84, Hg85 hg85, Hi86 hi86) {
        Gg3.k(gg3, Bo174.RADIUS.e);
        Gg3.aq(gg3, this.d);
        if (!(Y310.g(this.q.x) && Y310.g(this.q.y) && Y310.g(this.q.z))) {
            Gg3.k(gg3, Bo174.COLOUR.e);
            Gg3.aq(gg3, this.q.x);
            Gg3.aq(gg3, this.q.y);
            Gg3.aq(gg3, this.q.z);
        }
        Gg3.k(gg3, Bo174.SUPER_TYPE_PROPERTIES.e);
        int n = gg3.v += 4;
        super.r(gg3, hk84, hg85, hi86);
        Gg3.am(gg3, gg3.v - n);
        Gg3.k(gg3, 0);
    }

    public J113(D80 d80) {
        super(d80);
    }
}

