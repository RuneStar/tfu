/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.xelement.Au64;
import com.jagex.game.runetek6.xelement.Bx65;
import com.jagex.game.runetek6.xelement.K67;
import java.util.HashMap;
import java.util.Map;
import tfu.Gg3;
import tfu.Hp62;
import tfu.Ia63;

public class Bj61
implements Hp62 {
    public static final Ia63 d = new K67();
    private Map g = new HashMap();

    public static Bj61 q(Gg3 gg3) throws Au64 {
        int n;
        Bj61 bj61 = new Bj61();
        while ((n = Gg3.ar(gg3)) != 0) {
            Bx65 bx65 = Bx65.g(n);
            int n2 = Gg3.bd(gg3);
            int n3 = gg3.v + n2;
            switch (bx65) {
                case ANIMATIONS: {
                    while (gg3.v < n3) {
                        int n4 = Gg3.bd(gg3);
                        int n5 = Gg3.bd(gg3);
                        Bj61.d(bj61, n4, n5);
                    }
                    break;
                }
                default: {
                    gg3.v += n2;
                }
            }
            if (gg3.v == n3) continue;
            throw new Au64("Chunk length mismatch when deserialising " + (Object)((Object)bx65) + ": expected " + n2 + " bytes, read " + (gg3.v - (n3 - n2)) + " bytes");
        }
        return bj61;
    }

    public static void g(Bj61 bj61, Map map) {
        map.putAll(bj61.g);
    }

    public static void d(Bj61 bj61, Integer n, Object object) {
        bj61.g.put(n, object);
    }

    @Override
    public void onAllRefsReleased() {
    }
}

