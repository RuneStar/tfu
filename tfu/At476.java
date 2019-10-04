// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import rs2.client.worldelement.Npc;
import rs2.client.sound.SoundManager;
import rs2.client.worldelement.player;
import org.slf4j.Logger;

public class At476
{
    private static final int d = 75;
    private static Ha262 e;
    private static Gx298 h;
    private static Gx298 j;
    private static final Logger logger;
    private static Gx298 q;
    private static Ha262 s;
    
    public static void e(final player player) {
        At476.logger.trace("Attempting player sound update");
        if (Ha262.d(At476.e, player.m) == null) {
            q(player);
        }
        else {
            j(player);
            q(player);
        }
    }
    
    public static void g(final boolean b) {
        for (Am548 am548 = (Am548)Gx298.i(At476.q); am548 != null; am548 = (Am548)Gx298.c(At476.q)) {
            if (am548.a != null) {
                Dn555.s(SoundManager.t, am548.a);
                am548.a = null;
            }
            Ln265.ef(am548);
            Gx298.t(At476.h, am548);
        }
        if (b) {
            for (Am548 am549 = (Am548)Gx298.i(At476.j); am549 != null; am549 = (Am548)Gx298.c(At476.j)) {
                if (am549.a != null) {
                    Dn555.s(SoundManager.t, am549.a);
                    am549.a = null;
                }
                Ln265.ef(am549);
            }
            for (As554 as554 = (As554)Ha262.e(At476.e); as554 != null; as554 = (As554)Ha262.h(At476.e)) {
                if (as554.d != null && as554.d.a != null) {
                    Dn555.s(SoundManager.t, as554.d.a);
                    as554.d.a = null;
                }
                if (as554.q != null && as554.q.a != null) {
                    Dn555.s(SoundManager.t, as554.q.a);
                    as554.q.a = null;
                }
                Ln265.ef(as554);
            }
        }
    }
    
    public static void d() {
        for (Am548 am548 = (Am548)Gx298.i(At476.q); am548 != null; am548 = (Am548)Gx298.c(At476.q)) {
            if (am548.e) {
                am548.g();
            }
        }
        for (Am548 am549 = (Am548)Gx298.i(At476.j); am549 != null; am549 = (Am548)Gx298.c(At476.j)) {
            if (am549.e) {
                am549.g();
            }
        }
    }
    
    public static void q(final player player) {
        Ac557 ac557 = null;
        if (player.ac != -1) {
            ac557 = new Ac557(player);
            ac557.c = player.ac;
            ac557.k = player.ab;
            ac557.d = player.aw << 2;
            ac557.q = player.ax;
            ac557.n = 256;
            ac557.m = 256;
            ac557.g = player.ar << 2;
        }
        Ac557 ac558 = null;
        if (player.at != -1) {
            ac558 = new Ac557(player);
            ac558.c = player.at;
            ac558.k = player.ab;
            ac558.d = player.aw << 2;
            ac558.q = player.ax;
            ac558.n = 256;
            ac558.m = 256;
            ac558.g = player.ar << 2;
        }
        Ha262.q(At476.e, new As554(player, ac557, ac558), player.m);
    }
    
    static int h(final Npc npc) {
        return -1;
    }
    
    static {
        logger = LoggerFactory.getLogger(At476.class);
        At476.q = new Gx298();
        At476.j = new Gx298();
        At476.e = new Ha262(16);
        At476.h = new Gx298();
        At476.s = new Ha262(16);
    }
    
    public static void j(final player player) {
        At476.logger.trace("Attempting player sound removal");
        final As554 as554 = (As554)Ha262.d(At476.e, player.m);
        if (as554 != null) {
            if (as554.d != null && as554.d.a != null) {
                Dn555.s(SoundManager.t, as554.d.a);
                as554.d.a = null;
            }
            if (as554.q != null && as554.q.a != null) {
                Dn555.s(SoundManager.t, as554.q.a);
                as554.q.a = null;
            }
            Ln265.ef(as554);
        }
    }
}
