/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.sound.SoundManager;
import rs2.client.worldelement.Npc;
import rs2.client.worldelement.player;
import tfu.Ac557;
import tfu.Am548;
import tfu.An52;
import tfu.As554;
import tfu.Cv549;
import tfu.Dn555;
import tfu.Gx298;
import tfu.Ha262;
import tfu.Ln265;

public class At476 {
    private static final int d = 75;
    private static Ha262 e;
    private static Gx298 h;
    private static Gx298 j;
    private static final Logger logger;
    private static Gx298 q;
    private static Ha262 s;

    public static void e(player player2) {
        logger.trace("Attempting player sound update");
        As554 as554 = (As554)Ha262.d(e, player2.m);
        if (as554 == null) {
            At476.q(player2);
        } else {
            At476.j(player2);
            At476.q(player2);
        }
    }

    public static void g(boolean bl) {
        Ln265 ln265 = (Am548)Gx298.i(q);
        while (ln265 != null) {
            if (ln265.a != null) {
                Dn555.s(SoundManager.t, ln265.a);
                ln265.a = null;
            }
            Am548.ef(ln265);
            Gx298.t(h, ln265);
            ln265 = (Am548)Gx298.c(q);
        }
        if (bl) {
            ln265 = (Am548)Gx298.i(j);
            while (ln265 != null) {
                if (ln265.a != null) {
                    Dn555.s(SoundManager.t, ln265.a);
                    ln265.a = null;
                }
                Am548.ef(ln265);
                ln265 = (Am548)Gx298.c(j);
            }
            ln265 = (As554)Ha262.e(e);
            while (ln265 != null) {
                if (((As554)ln265).d != null && ln265.d.a != null) {
                    Dn555.s(SoundManager.t, ln265.d.a);
                    ln265.d.a = null;
                }
                if (((As554)ln265).q != null && ln265.q.a != null) {
                    Dn555.s(SoundManager.t, ln265.q.a);
                    ln265.q.a = null;
                }
                As554.ef(ln265);
                ln265 = (As554)Ha262.h(e);
            }
        }
    }

    public static void d() {
        Am548 am548 = (Am548)Gx298.i(q);
        while (am548 != null) {
            if (am548.e) {
                am548.g();
            }
            am548 = (Am548)Gx298.c(q);
        }
        am548 = (Am548)Gx298.i(j);
        while (am548 != null) {
            if (am548.e) {
                am548.g();
            }
            am548 = (Am548)Gx298.c(j);
        }
    }

    public static void q(player player2) {
        Ac557 ac557 = null;
        if (player2.ac != -1) {
            ac557 = new Ac557(player2);
            ac557.c = player2.ac;
            ac557.k = player2.ab;
            ac557.d = player2.aw << 2;
            ac557.q = player2.ax;
            ac557.n = 256;
            ac557.m = 256;
            ac557.g = player2.ar << 2;
        }
        Ac557 ac5572 = null;
        if (player2.at != -1) {
            ac5572 = new Ac557(player2);
            ac5572.c = player2.at;
            ac5572.k = player2.ab;
            ac5572.d = player2.aw << 2;
            ac5572.q = player2.ax;
            ac5572.n = 256;
            ac5572.m = 256;
            ac5572.g = player2.ar << 2;
        }
        Ha262.q(e, new As554(player2, ac557, ac5572), player2.m);
    }

    static int h(Npc npc) {
        int n = -1;
        return n;
    }

    static {
        logger = LoggerFactory.getLogger(At476.class);
        q = new Gx298();
        j = new Gx298();
        e = new Ha262(16);
        h = new Gx298();
        s = new Ha262(16);
    }

    public static void j(player player2) {
        logger.trace("Attempting player sound removal");
        As554 as554 = (As554)Ha262.d(e, player2.m);
        if (as554 != null) {
            if (as554.d != null && as554.d.a != null) {
                Dn555.s(SoundManager.t, as554.d.a);
                as554.d.a = null;
            }
            if (as554.q != null && as554.q.a != null) {
                Dn555.s(SoundManager.t, as554.q.a);
                as554.q.a = null;
            }
            As554.ef(as554);
        }
    }
}

