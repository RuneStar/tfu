/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.xelement.Ae201;
import com.jagex.game.runetek6.xelement.Am76;
import com.jagex.game.runetek6.xelement.Ao74;
import com.jagex.game.runetek6.xelement.Au64;
import com.jagex.game.runetek6.xelement.Ax92;
import com.jagex.game.runetek6.xelement.D80;
import com.jagex.game.runetek6.xelement.J113;
import com.jagex.game.runetek6.xelement.XElement;
import java.util.ArrayList;
import java.util.List;
import tfu.Gg3;
import tfu.Hg85;
import tfu.Hi86;
import tfu.Hk84;

public class N78
extends D80 {
    protected List af;
    protected List al;
    protected List av;

    public static int da(N78 n78) {
        return n78.af != null ? n78.af.size() : 0;
    }

    public static XElement dx(N78 n78, int n) {
        return (XElement)n78.af.get(n);
    }

    public void dr(XElement xElement) throws Ae201 {
        if (this.af == null) {
            this.af = new ArrayList();
        }
        this.af.add(xElement);
    }

    protected static void eg(N78 n78, Gg3 gg3) throws Au64 {
        int n;
        while ((n = Gg3.ar(gg3)) != 0) {
            Ax92 ax92 = Ax92.g(n);
            int n2 = ax92.e != -1 ? ax92.e : Gg3.bd(gg3);
            int n3 = gg3.v + n2;
            switch (ax92) {
                case ELEMENTS: {
                    int n4;
                    int n5 = Gg3.au(gg3);
                    for (n4 = 0; n4 < n5; ++n4) {
                        n78.dr(XElement.by(gg3, n78));
                    }
                    break;
                }
                case LIGHTS: {
                    int n4;
                    int n5 = Gg3.au(gg3);
                    for (n4 = 0; n4 < n5; ++n4) {
                        n78.dy(J113.w(gg3, n78));
                    }
                    break;
                }
                case PARTICLE_SYSTEMS: {
                    int n4;
                    int n5 = Gg3.au(gg3);
                    for (n4 = 0; n4 < n5; ++n4) {
                        n78.ez(Ao74.w(gg3, n78));
                    }
                    break;
                }
                default: {
                    gg3.v += n2;
                }
            }
            if (gg3.v == n3) continue;
            throw new Au64("Chunk length mismatch when deserialising " + (Object)((Object)ax92) + ": expected " + n2 + " bytes, read " + (gg3.v - (n3 - n2)) + " bytes");
        }
    }

    public static J113 dd(N78 n78, int n) {
        return (J113)n78.al.get(n);
    }

    public void dy(J113 j113) {
        if (this.al == null) {
            this.al = new ArrayList();
        }
        this.al.add(j113);
    }

    public N78(D80 d80) {
        super(d80);
    }

    public static Ao74 er(N78 n78, int n) {
        return (Ao74)n78.av.get(n);
    }

    public void ez(Ao74 ao74) {
        if (this.av == null) {
            this.av = new ArrayList();
        }
        this.av.add(ao74);
    }

    public void r(Gg3 gg3, Hk84 hk84, Hg85 hg85, Hi86 hi86) {
        int n;
        if (this.af != null && !this.af.isEmpty()) {
            Gg3.k(gg3, Ax92.ELEMENTS.j);
            n = gg3.v += 4;
            Gg3.i(gg3, this.af.size());
            for (Am76 am76 : this.af) {
                ((XElement)am76).r(gg3, hk84, hg85, hi86);
            }
            Gg3.am(gg3, gg3.v - n);
        }
        if (this.al != null && !this.al.isEmpty()) {
            Gg3.k(gg3, Ax92.LIGHTS.j);
            n = gg3.v += 4;
            Gg3.i(gg3, this.al.size());
            for (Am76 am76 : this.al) {
                ((J113)am76).r(gg3, hk84, hg85, hi86);
            }
            Gg3.am(gg3, gg3.v - n);
        }
        if (this.av != null && !this.av.isEmpty()) {
            Gg3.k(gg3, Ax92.PARTICLE_SYSTEMS.j);
            n = gg3.v += 4;
            Gg3.i(gg3, this.av.size());
            for (Am76 am76 : this.av) {
                ((Ao74)am76).r(gg3, hk84, hg85, hi86);
            }
            Gg3.am(gg3, gg3.v - n);
        }
        Gg3.k(gg3, 0);
    }

    public static int dg(N78 n78) {
        return n78.av != null ? n78.av.size() : 0;
    }

    public static int db(N78 n78) {
        return n78.al != null ? n78.al.size() : 0;
    }
}

