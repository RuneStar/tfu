// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.xelement;

import org.slf4j.LoggerFactory;
import tfu.Id102;
import tfu.Gg3;
import java.util.LinkedList;
import org.slf4j.Logger;
import tfu.Ia63;
import tfu.Hp62;

public class T101 implements Hp62
{
    public static final Ia63 d;
    private static final Logger logger;
    private static int t;
    public final int b;
    public final float e;
    public final int h;
    public Av106 j;
    public final float l;
    public int p;
    public String q;
    public String r;
    public final int s;
    public Ar110 u;
    public String v;
    public String w;
    public int x;
    public String y;
    public final LinkedList z;
    
    public T101(final float e, final int s, final int b, final int h, final float l, final Av106 j) {
        this.p = 0;
        this.x = 0;
        this.z = new LinkedList();
        this.e = e;
        this.s = s;
        this.b = b;
        this.h = h;
        this.l = l;
        this.j = j;
    }
    
    @Override
    public void onAllRefsReleased() {
    }
    
    public static T101 g(final Gg3 gg3) throws Id102 {
        final int ar = Gg3.ar(gg3);
        if (ar > T101.t) {
            throw new Id102("Unsupported version " + ar);
        }
        final float bl = Gg3.bl(gg3);
        final int bd = Gg3.bd(gg3);
        final int bd2 = Gg3.bd(gg3);
        Av106 full = Av106.FULL;
        if (ar >= 7) {
            full = Av106.values()[Gg3.ar(gg3)];
        }
        Gg3.bl(gg3);
        final float bl2 = Gg3.bl(gg3);
        final int bd3 = Gg3.bd(gg3);
        final T101 t101 = new T101(bl, bd, bd2, 1, bl2, full);
        for (int i = 0; i < bd3; ++i) {
            final int bd4 = Gg3.bd(gg3);
            final int bd5 = Gg3.bd(gg3);
            final int bd6 = Gg3.bd(gg3);
            final int bd7 = Gg3.bd(gg3);
            final int bd8 = Gg3.bd(gg3);
            boolean b = false;
            if (ar >= 4) {
                b = (Gg3.ax(gg3) != 0);
            }
            t101.z.add(new As109(bd4, bd5, bd6, bd7, bd8, b));
        }
        if (ar >= 2) {
            t101.q = gg3.bh();
            if (ar < 7) {
                if (t101.q.equals("main")) {
                    t101.j = Av106.UIONLY;
                }
                else {
                    t101.j = Av106.FULL;
                }
            }
        }
        if (ar >= 3) {
            t101.p = Gg3.bd(gg3);
            t101.x = Gg3.bd(gg3);
        }
        if (ar >= 5 && Gg3.ar(gg3) == 1) {
            t101.u = Ar110.g(gg3);
        }
        if (ar >= 6) {
            if (Gg3.ar(gg3) == 1) {
                t101.w = gg3.bh();
            }
            if (Gg3.ar(gg3) == 1) {
                t101.r = gg3.bh();
            }
            if (Gg3.ar(gg3) == 1) {
                t101.v = gg3.bh();
            }
            if (Gg3.ar(gg3) == 1) {
                t101.y = gg3.bh();
            }
        }
        return t101;
    }
    
    static {
        logger = LoggerFactory.getLogger(T101.class);
        d = new At100();
        T101.t = 7;
    }
}
