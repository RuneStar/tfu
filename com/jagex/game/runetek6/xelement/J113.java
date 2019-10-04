// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import com.jagex.maths.Y310;
import tfu.Hi86;
import tfu.Hg85;
import tfu.Hk84;
import tfu.Gg3;
import com.jagex.maths.Vector3;

public class J113 extends Am76
{
    public float d;
    public Vector3 q;
    
    public static J113 w(final Gg3 gg3, final D80 d80) throws Au64 {
        final J113 j113 = new J113(d80);
        int ar;
        while ((ar = Gg3.ar(gg3)) != 0) {
            final Bo174 g = Bo174.g(ar);
            final int i = (g.h != -1) ? g.h : Gg3.bd(gg3);
            final int n = gg3.v + i;
            switch (Aj202.g[g.ordinal()]) {
                case 1: {
                    j113.d = Gg3.bl(gg3);
                    break;
                }
                case 2: {
                    j113.q = new Vector3(Gg3.bl(gg3), Gg3.bl(gg3), Gg3.bl(gg3));
                    break;
                }
                case 3: {
                    Am76.eo(j113, gg3);
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
        return j113;
    }
    
    @Override
    public void r(final Gg3 gg3, final Hk84 hk84, final Hg85 hg85, final Hi86 hi86) {
        Gg3.k(gg3, Bo174.RADIUS.e);
        Gg3.aq(gg3, this.d);
        if (!Y310.g(this.q.x) || !Y310.g(this.q.y) || !Y310.g(this.q.z)) {
            Gg3.k(gg3, Bo174.COLOUR.e);
            Gg3.aq(gg3, this.q.x);
            Gg3.aq(gg3, this.q.y);
            Gg3.aq(gg3, this.q.z);
        }
        Gg3.k(gg3, Bo174.SUPER_TYPE_PROPERTIES.e);
        final int v = gg3.v + 4;
        gg3.v = v;
        final int n = v;
        super.r(gg3, hk84, hg85, hi86);
        Gg3.am(gg3, gg3.v - n);
        Gg3.k(gg3, 0);
    }
    
    public J113(final D80 d80) {
        super(d80);
        this.q = new Vector3(1.0f, 1.0f, 1.0f);
    }
}
