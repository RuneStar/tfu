// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import java.util.Iterator;
import tfu.Hi86;
import tfu.Hg85;
import tfu.Hk84;
import tfu.Gg3;
import java.util.ArrayList;
import java.util.List;

public class N78 extends D80
{
    protected List af;
    protected List al;
    protected List av;
    
    public static int da(final N78 n78) {
        return (n78.af != null) ? n78.af.size() : 0;
    }
    
    public static XElement dx(final N78 n78, final int n79) {
        return n78.af.get(n79);
    }
    
    public void dr(final XElement xElement) throws Ae201 {
        if (this.af == null) {
            this.af = new ArrayList();
        }
        this.af.add(xElement);
    }
    
    protected static void eg(final N78 n78, final Gg3 gg3) throws Au64 {
        int ar;
        while ((ar = Gg3.ar(gg3)) != 0) {
            final Ax92 g = Ax92.g(ar);
            final int i = (g.e != -1) ? g.e : Gg3.bd(gg3);
            final int n79 = gg3.v + i;
            switch (I541.g[g.ordinal()]) {
                case 1: {
                    for (int au = Gg3.au(gg3), j = 0; j < au; ++j) {
                        n78.dr(XElement.by(gg3, n78));
                    }
                    break;
                }
                case 2: {
                    for (int au2 = Gg3.au(gg3), k = 0; k < au2; ++k) {
                        n78.dy(J113.w(gg3, n78));
                    }
                    break;
                }
                case 3: {
                    for (int au3 = Gg3.au(gg3), l = 0; l < au3; ++l) {
                        n78.ez(Ao74.w(gg3, n78));
                    }
                    break;
                }
                default: {
                    gg3.v += i;
                    break;
                }
            }
            if (gg3.v != n79) {
                throw new Au64("Chunk length mismatch when deserialising " + g + ": expected " + i + " bytes, read " + (gg3.v - (n79 - i)) + " bytes");
            }
        }
    }
    
    public static J113 dd(final N78 n78, final int n79) {
        return n78.al.get(n79);
    }
    
    public void dy(final J113 j113) {
        if (this.al == null) {
            this.al = new ArrayList();
        }
        this.al.add(j113);
    }
    
    public N78(final D80 d80) {
        super(d80);
    }
    
    public static Ao74 er(final N78 n78, final int n79) {
        return n78.av.get(n79);
    }
    
    public void ez(final Ao74 ao74) {
        if (this.av == null) {
            this.av = new ArrayList();
        }
        this.av.add(ao74);
    }
    
    public void r(final Gg3 gg3, final Hk84 hk84, final Hg85 hg85, final Hi86 hi86) {
        if (this.af != null && !this.af.isEmpty()) {
            Gg3.k(gg3, Ax92.ELEMENTS.j);
            final int v = gg3.v + 4;
            gg3.v = v;
            final int n = v;
            Gg3.i(gg3, this.af.size());
            final Iterator<XElement> iterator = (Iterator<XElement>)this.af.iterator();
            while (iterator.hasNext()) {
                iterator.next().r(gg3, hk84, hg85, hi86);
            }
            Gg3.am(gg3, gg3.v - n);
        }
        if (this.al != null && !this.al.isEmpty()) {
            Gg3.k(gg3, Ax92.LIGHTS.j);
            final int v2 = gg3.v + 4;
            gg3.v = v2;
            final int n2 = v2;
            Gg3.i(gg3, this.al.size());
            final Iterator<J113> iterator2 = (Iterator<J113>)this.al.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().r(gg3, hk84, hg85, hi86);
            }
            Gg3.am(gg3, gg3.v - n2);
        }
        if (this.av != null && !this.av.isEmpty()) {
            Gg3.k(gg3, Ax92.PARTICLE_SYSTEMS.j);
            final int v3 = gg3.v + 4;
            gg3.v = v3;
            final int n3 = v3;
            Gg3.i(gg3, this.av.size());
            final Iterator<Ao74> iterator3 = (Iterator<Ao74>)this.av.iterator();
            while (iterator3.hasNext()) {
                iterator3.next().r(gg3, hk84, hg85, hi86);
            }
            Gg3.am(gg3, gg3.v - n3);
        }
        Gg3.k(gg3, 0);
    }
    
    public static int dg(final N78 n78) {
        return (n78.av != null) ? n78.av.size() : 0;
    }
    
    public static int db(final N78 n78) {
        return (n78.al != null) ? n78.al.size() : 0;
    }
}
