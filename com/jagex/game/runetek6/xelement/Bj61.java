// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import java.util.HashMap;
import tfu.Gg3;
import java.util.Map;
import tfu.Ia63;
import tfu.Hp62;

public class Bj61 implements Hp62
{
    public static final Ia63 d;
    private Map g;
    
    public static Bj61 q(final Gg3 gg3) throws Au64 {
        final Bj61 bj61 = new Bj61();
        int ar;
        while ((ar = Gg3.ar(gg3)) != 0) {
            final Bx65 g = Bx65.g(ar);
            final int bd = Gg3.bd(gg3);
            final int n = gg3.v + bd;
            switch (F66.g[g.ordinal()]) {
                case 1: {
                    while (gg3.v < n) {
                        d(bj61, Gg3.bd(gg3), Gg3.bd(gg3));
                    }
                    break;
                }
                default: {
                    gg3.v += bd;
                    break;
                }
            }
            if (gg3.v != n) {
                throw new Au64("Chunk length mismatch when deserialising " + g + ": expected " + bd + " bytes, read " + (gg3.v - (n - bd)) + " bytes");
            }
        }
        return bj61;
    }
    
    public static void g(final Bj61 bj61, final Map map) {
        map.putAll(bj61.g);
    }
    
    public static void d(final Bj61 bj61, final Integer n, final Object o) {
        bj61.g.put(n, o);
    }
    
    public Bj61() {
        this.g = new HashMap();
    }
    
    @Override
    public void onAllRefsReleased() {
    }
    
    static {
        d = new K67();
    }
}
