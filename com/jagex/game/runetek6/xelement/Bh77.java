// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import tfu.Hi86;
import tfu.Hg85;
import tfu.Hk84;
import tfu.Gg3;
import tfu.Ia63;
import tfu.Hp62;

public class Bh77 extends N78 implements Hp62
{
    public static final Ia63 d;
    public String b;
    public Bn70 e;
    private Q79 h;
    public W14 j;
    public String l;
    public byte[] q;
    public String r;
    private String s;
    public String w;
    
    @Override
    public int d(final String s) {
        return Q79.d(this.h, s);
    }
    
    @Override
    public void j(final String s) {
        Q79.g(this.h, s);
    }
    
    public static Bh77 w(final Gg3 gg3, final D80 d80) throws Au64 {
        final Bh77 bh77 = new Bh77(d80);
        int ar;
        while ((ar = Gg3.ar(gg3)) != 0) {
            final Af81 g = Af81.g(ar);
            final int i = (g.y != -1) ? g.y : Gg3.bd(gg3);
            final int n = gg3.v + i;
            switch (P82.g[g.ordinal()]) {
                case 1: {
                    bh77.j = W14.q(gg3);
                    break;
                }
                case 2: {
                    p(bh77, gg3.bh());
                    break;
                }
                case 3: {
                    (bh77.e = new Bn70()).d(gg3);
                    break;
                }
                case 4: {
                    bh77.b = gg3.bh();
                    break;
                }
                case 5: {
                    bh77.l = gg3.bh();
                    break;
                }
                case 6: {
                    bh77.w = gg3.bh();
                    break;
                }
                case 7: {
                    bh77.r = gg3.bh();
                    break;
                }
                case 8: {
                    bh77.h = Q79.e(gg3);
                    break;
                }
                case 9: {
                    N78.eg(bh77, gg3);
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
        return bh77;
    }
    
    @Override
    public String q(final int n) {
        return Q79.q(this.h, n);
    }
    
    @Override
    public void onAllRefsReleased() {
    }
    
    public Bh77(final D80 d80) {
        super(d80);
        this.h = new Q79();
    }
    
    public static void p(final Bh77 bh77, final String s) {
        bh77.s = s;
    }
    
    public static String v(final Bh77 bh77) {
        return bh77.s;
    }
    
    static {
        d = new Bp83();
    }
    
    @Override
    public void r(final Gg3 gg3, final Hk84 hk84, final Hg85 hg85, final Hi86 hi86) {
        if (this.j != null) {
            Gg3.k(gg3, Af81.TERRAIN.v);
            final int v = gg3.v + 4;
            gg3.v = v;
            final int n = v;
            W14.j(this.j, gg3);
            Gg3.am(gg3, gg3.v - n);
        }
        if (v(this) != null) {
            Gg3.k(gg3, Af81.NAVMESH_REF_CHUNK.v);
            Gg3.a(gg3, Gg3.av(v(this)));
            gg3.ap(v(this));
        }
        if (this.e != null) {
            Gg3.k(gg3, Af81.ENVSETTINGS_CHUNK.v);
            final int v2 = gg3.v + 4;
            gg3.v = v2;
            final int n2 = v2;
            Bn70.g(this.e, gg3);
            Gg3.am(gg3, gg3.v - n2);
        }
        if (this.b != null) {
            Gg3.k(gg3, Af81.GROUND_COVER_CHUNK.v);
            Gg3.a(gg3, Gg3.av(this.b));
            gg3.ap(this.b);
        }
        if (this.r != null) {
            Gg3.k(gg3, Af81.SOURCE_PATH.v);
            Gg3.a(gg3, Gg3.av(this.r));
            gg3.ap(this.r);
        }
        if (this.l != null) {
            Gg3.k(gg3, Af81.IRRADIANCE_VOLUMES_CHUNK.v);
            Gg3.a(gg3, Gg3.av(this.l));
            gg3.ap(this.l);
        }
        if (this.w != null) {
            Gg3.k(gg3, Af81.UMBRA_SCENE_CHUNK.v);
            Gg3.a(gg3, Gg3.av(this.w));
            gg3.ap(this.w);
        }
        Gg3.k(gg3, Af81.PROPERTY_NAME_TABLE.v);
        final int v3 = gg3.v + 4;
        gg3.v = v3;
        final int n3 = v3;
        Q79.j(this.h, gg3);
        Gg3.am(gg3, gg3.v - n3);
        Gg3.k(gg3, Af81.SUPER_TYPE_PROPERTIES.v);
        final int v4 = gg3.v + 4;
        gg3.v = v4;
        final int n4 = v4;
        super.r(gg3, hk84, hg85, hi86);
        Gg3.am(gg3, gg3.v - n4);
        Gg3.k(gg3, 0);
    }
}
