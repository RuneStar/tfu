/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.xelement.Ar110;
import com.jagex.game.runetek6.xelement.As109;
import com.jagex.game.runetek6.xelement.At100;
import com.jagex.game.runetek6.xelement.Av106;
import java.util.LinkedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Gg3;
import tfu.Hp62;
import tfu.Ia63;
import tfu.Id102;

public class T101
implements Hp62 {
    public static final Ia63 d;
    private static final Logger logger;
    private static int t;
    public final int b;
    public final float e;
    public final int h;
    public Av106 j;
    public final float l;
    public int p = 0;
    public String q;
    public String r;
    public final int s;
    public Ar110 u;
    public String v;
    public String w;
    public int x = 0;
    public String y;
    public final LinkedList z = new LinkedList();

    public T101(float f, int n, int n2, int n3, float f2, Av106 av106) {
        this.e = f;
        this.s = n;
        this.b = n2;
        this.h = n3;
        this.l = f2;
        this.j = av106;
    }

    @Override
    public void onAllRefsReleased() {
    }

    public static T101 g(Gg3 gg3) throws Id102 {
        int n;
        int n2 = Gg3.ar(gg3);
        if (n2 > t) {
            throw new Id102("Unsupported version " + n2);
        }
        float f = Gg3.bl(gg3);
        int n3 = Gg3.bd(gg3);
        int n4 = Gg3.bd(gg3);
        Av106 av106 = Av106.FULL;
        if (n2 >= 7) {
            av106 = Av106.values()[Gg3.ar(gg3)];
        }
        Gg3.bl(gg3);
        float f2 = Gg3.bl(gg3);
        int n5 = Gg3.bd(gg3);
        T101 t101 = new T101(f, n3, n4, 1, f2, av106);
        for (n = 0; n < n5; ++n) {
            int n6 = Gg3.bd(gg3);
            int n7 = Gg3.bd(gg3);
            int n8 = Gg3.bd(gg3);
            int n9 = Gg3.bd(gg3);
            int n10 = Gg3.bd(gg3);
            boolean bl = false;
            if (n2 >= 4) {
                bl = Gg3.ax(gg3) != 0;
            }
            t101.z.add(new As109(n6, n7, n8, n9, n10, bl));
        }
        if (n2 >= 2) {
            t101.q = gg3.bh();
            if (n2 < 7) {
                t101.j = t101.q.equals("main") ? Av106.UIONLY : Av106.FULL;
            }
        }
        if (n2 >= 3) {
            t101.p = Gg3.bd(gg3);
            t101.x = Gg3.bd(gg3);
        }
        if (n2 >= 5) {
            int n11 = n = Gg3.ar(gg3) == 1 ? 1 : 0;
            if (n != 0) {
                t101.u = Ar110.g(gg3);
            }
        }
        if (n2 >= 6) {
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
        t = 7;
    }
}

