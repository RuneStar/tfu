// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.LinkedList;
import org.slf4j.LoggerFactory;
import rs2.client.chat.G232;
import rs2.client.N272;
import com.jagex.game.runetek6.scenegraph.Scene;
import rs2.client.lua.ClientScriptAPI;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import java.util.Map;
import com.jagex.game.runetek6.gameentity.components.MappedEventComponent;
import com.jagex.game.runetek6.event.PhysicsEventMode;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import rs2.client.client;
import java.util.List;
import rs2.client.worldelement.player;
import org.slf4j.Logger;
import java.util.ArrayList;
import com.jagex.maths.Quaternion;

public class Gc330
{
    public static Quaternion b;
    private static final boolean d = true;
    public static int e;
    public static int h;
    public static ArrayList j;
    private static int l;
    private static final Logger logger;
    private static int q;
    private static final player[] r;
    public static int s;
    private static final Gg3[] v;
    private static final List w;
    
    public static void s(final Gg3 gg3, final int n) {
        final boolean b = j() == null;
        Gc330.logger.trace("Received player info 2 packet! Size: {}", n);
        final int br = Gg3.br(gg3);
        if (br > 0) {
            Gc330.logger.trace("Getting data about {} rule B infringers...", br);
            for (int i = 0; i < br; ++i) {
                final int au = Gg3.au(gg3);
                final int n2 = au & 0x7FF;
                final boolean b2 = (au & 0x8000) != 0x0;
                final Bb4 e = Bb4.e(gg3, Ed472.PLAYER);
                player e2 = Gc330.r[n2];
                if (e2 == null) {
                    Gc330.logger.debug("Received new player: {} {}", n2, (n2 == Gc330.q) ? " [self]" : "");
                    e2 = new player(e);
                    Gc330.r[n2] = e2;
                    Gc330.w.add(e2);
                    client.mm.add(e2);
                    ++Gc330.l;
                    GameEntity.ep(e2, new MappedEventComponent(null, PhysicsEventMode.COLLISION));
                    e2.be(n2, n2 == Gc330.q || b2);
                    if (n2 == Gc330.q) {
                        ClientScriptAPI.setNativeSelfGameEntity(client.cj.getScriptManagerNativeRef(), client.cj.getLuaStateNativeRef(), e2);
                        GameEntity.ep(e2, client.ku);
                    }
                }
                e2.m = n2;
                if (b2) {
                    Gc330.j.add(e2);
                }
                if ((au & 0x4000) != 0x0) {
                    e2.cq(gg3);
                }
            }
            int n3 = 0;
            int j;
            for (j = Gg3.by(gg3); j >= 0; j = Gg3.by(gg3)) {
                n3 += j;
                Gg3.ar(gg3);
                Gg3.ar(gg3);
                Gg3.ar(gg3);
            }
            Gc330.logger.trace("Received 'no change' update for {} players!", n3 + -j);
        }
        final int ar = Gg3.ar(gg3);
        Gc330.logger.trace("Received {} dropped players!", ar);
        for (int k = 0; k < ar; ++k) {
            final int br2 = Gg3.br(gg3);
            At476.j(Gc330.r[br2]);
            Gc330.j.remove(Gc330.r[br2]);
            player.cw(Gc330.r[br2]);
            player.co(Gc330.r[br2]);
            Scene.w(client.mm, Gc330.r[br2]);
            Gc330.w.remove(Gc330.r[br2]);
            Gc330.logger.info("Dropping player {}", br2);
            if (br2 == Gc330.q) {
                ClientScriptAPI.setNativeSelfGameEntity(client.cj.getScriptManagerNativeRef(), client.cj.getLuaStateNativeRef(), null);
            }
            Gc330.r[br2] = null;
            --Gc330.l;
        }
        final int ar2 = Gg3.ar(gg3);
        Gc330.logger.trace("Receiving physics/extend updates for " + ar2 + " players!");
        for (int l = 0; l < ar2; ++l) {
            final int au2 = Gg3.au(gg3);
            final int m = au2 & 0x3;
            final int n4 = au2 >> 2 & 0x7FF;
            if (m == 0) {
                final player player = Gc330.r[n4];
                if (player == null) {
                    Gc330.logger.warn("Eeek! Player was null for extend data: {}", n4);
                    client.ap();
                    return;
                }
                Gc330.logger.trace("Receiving extend data only for slot: {}", n4);
                b(gg3, n4, player);
            }
            else {
                Gc330.logger.debug("Inv t: {}", m);
            }
        }
        if (gg3.v != n) {
            Gc330.logger.warn("RPD: {} - {}", gg3.v, n);
            client.ap();
            return;
        }
        if (b && j() != null) {
            N272.e(client.fx, El328.d(Eu326.PLAYER_LOGIN, client.fx.s));
            client.cj.event.triggerEvent("__onLoggedIn", j());
            client.ba();
        }
    }
    
    public static void g() {
        Gc330.l = 0;
        Gc330.w.clear();
        Gc330.j.clear();
        for (int i = 0; i < 2048; ++i) {
            if (Gc330.r[i] != null) {
                if (client.mm != null) {
                    Scene.w(client.mm, Gc330.r[i]);
                }
                player.cw(Gc330.r[i]);
                Gc330.r[i].ba = null;
                Gc330.r[i] = null;
            }
            Gc330.v[i] = null;
        }
    }
    
    public static int d() {
        return Gc330.q;
    }
    
    public static player j() {
        if (Gc330.q != -1) {
            return Gc330.r[Gc330.q];
        }
        return null;
    }
    
    public static void q(final int q) {
        Gc330.q = q;
    }
    
    public static Iterable h() {
        return Gc330.w;
    }
    
    private static void b(final Gg3 gg3, final int i, final player player) {
        int ar = Gg3.ar(gg3);
        if (ar == 0) {
            return;
        }
        if ((ar & 0x80) != 0x0) {
            ar += Gg3.ar(gg3) << 8;
        }
        if ((ar & 0x8000) != 0x0) {
            ar += Gg3.ar(gg3) << 16;
        }
        if ((ar & 0x1) != 0x0) {
            final int ar2 = Gg3.ar(gg3);
            Gc330.logger.trace("Got information for player: {}, len: {}", i, ar2);
            final byte[] array = new byte[ar2];
            final Gg3 gg4 = new Gg3(array);
            Gg3.bx(gg3, array, 0, ar2);
            player.bn(Gc330.v[i] = gg4);
        }
        if ((ar & 0x10) != 0x0) {
            for (int ar3 = Gg3.ar(gg3), j = 0; j < ar3; ++j) {
                final String bh = gg3.bh();
                try {
                    client.cj.runScriptEvent(bh, player, null);
                }
                catch (Exception ex) {
                    Gc330.logger.error("Script execution failed: " + bh, ex);
                }
            }
        }
        if ((ar & 0x20) != 0x0) {
            for (int ar4 = Gg3.ar(gg3), k = 0; k < ar4; ++k) {
                final String bh2 = gg3.bh();
                try {
                    Gc330.logger.debug("Running client routine: {}", bh2);
                    client.cj.runScriptEvent(bh2, player, null);
                }
                catch (Exception ex2) {
                    Gc330.logger.error("Script execution failed: " + bh2, ex2);
                }
            }
        }
        if ((ar & 0x2000) != 0x0) {
            final String bk = Gg3.bk(gg3);
            if (bk.charAt(0) == '~') {
                G232.q(2, 0, player.bi(true), player.bt(player, false), player.aq, bk.substring(1));
            }
            else if (player == j()) {
                G232.q(2, 0, player.bi(true), player.bt(player, false), player.aq, bk);
            }
        }
        if ((ar & 0x1000) != 0x0) {
            final int au = Gg3.au(gg3);
            player.bk = Gg3.ar(gg3);
            player.bh = Gg3.ar(gg3);
            player.bp = ((au & 0x8000) != 0x0);
            player.bj = (au & 0x7FFF);
            player.bw = client.bj + player.bj + player.bk;
        }
        if ((ar & 0x800) != 0x0) {
            player.ay = (Gg3.ar(gg3) == 1);
        }
        if ((ar & 0x400000) != 0x0) {
            player.by.b();
            for (int n = gg3.r[gg3.v++] & 0xFF, l = 0; l < n; ++l) {
                final Kr260 decodeVarValue = client.fd.decodeVarValue(gg3);
                final Object h = player.by.h(decodeVarValue.g);
                player.by.s(decodeVarValue.g, decodeVarValue.d);
                if (player != j()) {
                    player.cv(player, decodeVarValue.g, decodeVarValue.d);
                }
                if (!Kh56.g(decodeVarValue.d, h)) {
                    final Integer ex3 = GameEntity.ex(player, client.fd.list(decodeVarValue.g).debugNameHash32);
                    if (ex3 != null) {
                        player.triggerEvent(ex3, decodeVarValue.d);
                    }
                }
            }
        }
        if ((ar & 0x200000) != 0x0) {
            for (int n2 = gg3.r[gg3.v++] & 0xFF, n3 = 0; n3 < n2; ++n3) {
                final Kr260 decodeVarValue2 = client.fd.decodeVarValue(gg3);
                final Object h2 = player.by.h(decodeVarValue2.g);
                player.by.s(decodeVarValue2.g, decodeVarValue2.d);
                if (player != j()) {
                    player.cv(player, decodeVarValue2.g, decodeVarValue2.d);
                }
                if (!Kh56.g(decodeVarValue2.d, h2)) {
                    final Integer ex4 = GameEntity.ex(player, client.fd.list(decodeVarValue2.g).debugNameHash32);
                    if (ex4 != null) {
                        player.triggerEvent(ex4, decodeVarValue2.d);
                    }
                }
            }
        }
    }
    
    static {
        logger = LoggerFactory.getLogger(Gc330.class);
        Gc330.q = -1;
        Gc330.j = new ArrayList();
        Gc330.b = Quaternion.g;
        Gc330.l = 0;
        w = new LinkedList();
        r = new player[2048];
        v = new Gg3[2048];
    }
    
    public static player e(final int n) {
        return Gc330.r[n];
    }
}
