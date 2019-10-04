/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.xelement.Aa111;
import com.jagex.game.runetek6.xelement.Ac112;
import java.util.ArrayList;
import tfu.Gg3;
import tfu.Hp62;
import tfu.Ia63;
import tfu.Id102;

public final class Ar110
implements Hp62 {
    public static final Ia63 g = new Ac112();
    private static final int q = 1;
    public final ArrayList d = new ArrayList();

    public static Ar110 g(Gg3 gg3) throws Id102 {
        int n = Gg3.ar(gg3);
        if (n > 1) {
            throw new Id102("Unsupported version " + n);
        }
        int n2 = Gg3.bd(gg3);
        Ar110 ar110 = new Ar110();
        for (int i = 0; i < n2; ++i) {
            Aa111 aa111 = new Aa111();
            aa111.g = Gg3.ar(gg3);
            aa111.d = Gg3.bl(gg3);
            aa111.q = Gg3.bl(gg3);
            aa111.j = Gg3.bl(gg3);
            aa111.e = Gg3.bl(gg3);
            aa111.h = Gg3.bl(gg3);
            aa111.s = Gg3.bd(gg3);
            aa111.b = Gg3.bl(gg3);
            aa111.l = Gg3.bl(gg3);
            aa111.w = Gg3.bl(gg3);
            aa111.r = Gg3.bl(gg3);
            aa111.v = Gg3.ar(gg3) == 1;
            aa111.y = Gg3.ar(gg3) == 1;
            aa111.p = Gg3.ar(gg3) == 1;
            ar110.d.add(aa111);
        }
        return ar110;
    }

    @Override
    public void onAllRefsReleased() {
    }
}

