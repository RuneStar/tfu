/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.xelement.Af81;
import com.jagex.game.runetek6.xelement.Au64;
import com.jagex.game.runetek6.xelement.Bn70;
import com.jagex.game.runetek6.xelement.Bp83;
import com.jagex.game.runetek6.xelement.D80;
import com.jagex.game.runetek6.xelement.N78;
import com.jagex.game.runetek6.xelement.Q79;
import com.jagex.game.runetek6.xelement.W14;
import tfu.Gg3;
import tfu.Hg85;
import tfu.Hi86;
import tfu.Hk84;
import tfu.Hp62;
import tfu.Ia63;

public class Bh77
extends N78
implements Hp62 {
    public static final Ia63 d = new Bp83();
    public String b;
    public Bn70 e;
    private Q79 h = new Q79();
    public W14 j;
    public String l;
    public byte[] q;
    public String r;
    private String s;
    public String w;

    @Override
    public int d(String string) {
        return Q79.d(this.h, string);
    }

    @Override
    public void j(String string) {
        Q79.g(this.h, string);
    }

    public static Bh77 w(Gg3 gg3, D80 d80) throws Au64 {
        int n;
        Bh77 bh77 = new Bh77(d80);
        while ((n = Gg3.ar(gg3)) != 0) {
            Af81 af81 = Af81.g(n);
            int n2 = af81.y != -1 ? af81.y : Gg3.bd(gg3);
            int n3 = gg3.v + n2;
            switch (af81) {
                case TERRAIN: {
                    bh77.j = W14.q(gg3);
                    break;
                }
                case NAVMESH_REF_CHUNK: {
                    Bh77.p(bh77, gg3.bh());
                    break;
                }
                case ENVSETTINGS_CHUNK: {
                    bh77.e = new Bn70();
                    bh77.e.d(gg3);
                    break;
                }
                case GROUND_COVER_CHUNK: {
                    bh77.b = gg3.bh();
                    break;
                }
                case IRRADIANCE_VOLUMES_CHUNK: {
                    bh77.l = gg3.bh();
                    break;
                }
                case UMBRA_SCENE_CHUNK: {
                    bh77.w = gg3.bh();
                    break;
                }
                case SOURCE_PATH: {
                    bh77.r = gg3.bh();
                    break;
                }
                case PROPERTY_NAME_TABLE: {
                    bh77.h = Q79.e(gg3);
                    break;
                }
                case SUPER_TYPE_PROPERTIES: {
                    N78.eg(bh77, gg3);
                    break;
                }
                default: {
                    gg3.v += n2;
                }
            }
            if (gg3.v == n3) continue;
            throw new Au64("Chunk length mismatch when deserialising " + (Object)((Object)af81) + ": expected " + n2 + " bytes, read " + (gg3.v - (n3 - n2)) + " bytes");
        }
        return bh77;
    }

    @Override
    public String q(int n) {
        return Q79.q(this.h, n);
    }

    @Override
    public void onAllRefsReleased() {
    }

    public Bh77(D80 d80) {
        super(d80);
    }

    public static void p(Bh77 bh77, String string) {
        bh77.s = string;
    }

    public static String v(Bh77 bh77) {
        return bh77.s;
    }

    @Override
    public void r(Gg3 gg3, Hk84 hk84, Hg85 hg85, Hi86 hi86) {
        int n;
        if (this.j != null) {
            Gg3.k(gg3, Af81.TERRAIN.v);
            n = gg3.v += 4;
            W14.j(this.j, gg3);
            Gg3.am(gg3, gg3.v - n);
        }
        if (Bh77.v(this) != null) {
            Gg3.k(gg3, Af81.NAVMESH_REF_CHUNK.v);
            Gg3.a(gg3, Gg3.av(Bh77.v(this)));
            gg3.ap(Bh77.v(this));
        }
        if (this.e != null) {
            Gg3.k(gg3, Af81.ENVSETTINGS_CHUNK.v);
            n = gg3.v += 4;
            Bn70.g(this.e, gg3);
            Gg3.am(gg3, gg3.v - n);
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
        n = gg3.v += 4;
        Q79.j(this.h, gg3);
        Gg3.am(gg3, gg3.v - n);
        Gg3.k(gg3, Af81.SUPER_TYPE_PROPERTIES.v);
        n = gg3.v += 4;
        super.r(gg3, hk84, hg85, hi86);
        Gg3.am(gg3, gg3.v - n);
        Gg3.k(gg3, 0);
    }
}

