/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerTypeListClient;
import com.jagex.game.runetek6.event.PhysicsEventMode;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.components.MappedEventComponent;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.game.runetek6.script.LuaEventHandler;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import com.jagex.maths.Quaternion;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.N272;
import rs2.client.chat.G232;
import rs2.client.client;
import rs2.client.friends.ClientFriendListComponent;
import rs2.client.lua.ClientScriptAPI;
import rs2.client.worldelement.L51;
import rs2.client.worldelement.player;
import tfu.At476;
import tfu.Bb4;
import tfu.Ed472;
import tfu.El328;
import tfu.Eu326;
import tfu.Gg3;
import tfu.Ic327;
import tfu.Kh56;
import tfu.Kr260;
import tfu.Mn54;

public class Gc330 {
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

    public static void s(Gg3 gg3, int n) {
        int n2;
        int n3;
        int n4;
        int n5;
        boolean bl = Gc330.j() == null;
        logger.trace("Received player info 2 packet! Size: {}", n);
        int n6 = Gg3.br(gg3);
        if (n6 > 0) {
            logger.trace("Getting data about {} rule B infringers...", n6);
            for (n3 = 0; n3 < n6; ++n3) {
                n5 = Gg3.au(gg3);
                n2 = n5 & 0x7FF;
                n4 = (n5 & 0x8000) != 0 ? 1 : 0;
                Bb4 bb4 = Bb4.e(gg3, Ed472.PLAYER);
                player player2 = r[n2];
                if (player2 == null) {
                    logger.debug("Received new player: {} {}", n2, (Object)(n2 == q ? " [self]" : ""));
                    Gc330.r[n2] = player2 = new player(bb4);
                    w.add(player2);
                    client.mm.add(player2);
                    ++l;
                    player.ep(player2, new MappedEventComponent(null, PhysicsEventMode.COLLISION));
                    player2.be(n2, n2 == q || n4 != 0);
                    if (n2 == q) {
                        ClientScriptAPI.setNativeSelfGameEntity(client.cj.getScriptManagerNativeRef(), client.cj.getLuaStateNativeRef(), player2);
                        player.ep(player2, client.ku);
                    }
                }
                player2.m = n2;
                if (n4 != 0) {
                    j.add(player2);
                }
                if ((n5 & 0x4000) == 0) continue;
                player2.cq(gg3);
            }
            n3 = 0;
            n5 = Gg3.by(gg3);
            while (n5 >= 0) {
                n3 += n5;
                Gg3.ar(gg3);
                Gg3.ar(gg3);
                Gg3.ar(gg3);
                n5 = Gg3.by(gg3);
            }
            logger.trace("Received 'no change' update for {} players!", n3 += -n5);
        }
        n3 = Gg3.ar(gg3);
        logger.trace("Received {} dropped players!", n3);
        for (n5 = 0; n5 < n3; ++n5) {
            n2 = Gg3.br(gg3);
            At476.j(r[n2]);
            j.remove(r[n2]);
            player.cw(r[n2]);
            player.co(r[n2]);
            Scene.w(client.mm, r[n2]);
            w.remove(r[n2]);
            logger.info("Dropping player {}", n2);
            if (n2 == q) {
                ClientScriptAPI.setNativeSelfGameEntity(client.cj.getScriptManagerNativeRef(), client.cj.getLuaStateNativeRef(), null);
            }
            Gc330.r[n2] = null;
            --l;
        }
        n5 = Gg3.ar(gg3);
        logger.trace("Receiving physics/extend updates for " + n5 + " players!");
        for (n2 = 0; n2 < n5; ++n2) {
            n4 = Gg3.au(gg3);
            int n7 = n4 & 3;
            int n8 = n4 >> 2 & 0x7FF;
            if (n7 == 0) {
                player player3 = r[n8];
                if (player3 == null) {
                    logger.warn("Eeek! Player was null for extend data: {}", n8);
                    client.ap();
                    return;
                }
                logger.trace("Receiving extend data only for slot: {}", n8);
                Gc330.b(gg3, n8, player3);
                continue;
            }
            logger.debug("Inv t: {}", n7);
        }
        if (gg3.v != n) {
            logger.warn("RPD: {} - {}", gg3.v, (Object)n);
            client.ap();
            return;
        }
        if (bl && Gc330.j() != null) {
            El328 el328 = El328.d(Eu326.PLAYER_LOGIN, client.fx.s);
            N272.e(client.fx, el328);
            client.cj.event.triggerEvent("__onLoggedIn", (Object)Gc330.j());
            client.ba();
        }
    }

    public static void g() {
        l = 0;
        w.clear();
        j.clear();
        for (int i = 0; i < 2048; ++i) {
            if (r[i] != null) {
                if (client.mm != null) {
                    Scene.w(client.mm, r[i]);
                }
                player.cw(r[i]);
                Gc330.r[i].ba = null;
                Gc330.r[i] = null;
            }
            Gc330.v[i] = null;
        }
    }

    public static int d() {
        return q;
    }

    public static player j() {
        if (q != -1) {
            return r[q];
        }
        return null;
    }

    public static void q(int n) {
        q = n;
    }

    public static Iterable h() {
        return w;
    }

    private static void b(Gg3 gg3, int n, player player2) {
        VarType varType;
        Integer n2;
        int n3;
        Object object;
        Object object2;
        int n4 = Gg3.ar(gg3);
        if (n4 == 0) {
            return;
        }
        if ((n4 & 0x80) != 0) {
            n4 += Gg3.ar(gg3) << 8;
        }
        if ((n4 & 0x8000) != 0) {
            n4 += Gg3.ar(gg3) << 16;
        }
        if ((n4 & 1) != 0) {
            n3 = Gg3.ar(gg3);
            logger.trace("Got information for player: {}, len: {}", n, (Object)n3);
            byte[] arrby = new byte[n3];
            object2 = new Gg3(arrby);
            Gg3.bx(gg3, arrby, 0, n3);
            Gc330.v[n] = object2;
            player2.bn((Gg3)object2);
        }
        if ((n4 & 0x10) != 0) {
            n3 = Gg3.ar(gg3);
            for (int i = 0; i < n3; ++i) {
                object2 = gg3.bh();
                try {
                    client.cj.runScriptEvent((String)object2, player2, null);
                    continue;
                }
                catch (Exception exception) {
                    logger.error("Script execution failed: " + (String)object2, exception);
                }
            }
        }
        if ((n4 & 0x20) != 0) {
            n3 = Gg3.ar(gg3);
            for (int i = 0; i < n3; ++i) {
                object2 = gg3.bh();
                try {
                    logger.debug("Running client routine: {}", object2);
                    client.cj.runScriptEvent((String)object2, player2, null);
                    continue;
                }
                catch (Exception exception) {
                    logger.error("Script execution failed: " + (String)object2, exception);
                }
            }
        }
        if ((n4 & 0x2000) != 0) {
            String string = Gg3.bk(gg3);
            if (string.charAt(0) == '~') {
                string = string.substring(1);
                G232.q(2, 0, player2.bi(true), player.bt(player2, false), player2.aq, string);
            } else if (player2 == Gc330.j()) {
                G232.q(2, 0, player2.bi(true), player.bt(player2, false), player2.aq, string);
            }
        }
        if ((n4 & 0x1000) != 0) {
            n3 = Gg3.au(gg3);
            player2.bk = Gg3.ar(gg3);
            player2.bh = Gg3.ar(gg3);
            player2.bp = (n3 & 0x8000) != 0;
            player2.bj = n3 & 0x7FFF;
            player2.bw = client.bj + player2.bj + player2.bk;
        }
        if ((n4 & 0x800) != 0) {
            boolean bl = player2.ay = Gg3.ar(gg3) == 1;
        }
        if ((n4 & 0x400000) != 0) {
            player2.by.b();
            n3 = gg3.r[gg3.v++] & 0xFF;
            for (int i = 0; i < n3; ++i) {
                object2 = client.fd.decodeVarValue(gg3);
                object = player2.by.h(((Kr260)object2).g);
                player2.by.s(((Kr260)object2).g, ((Kr260)object2).d);
                if (player2 != Gc330.j()) {
                    player.cv(player2, ((Kr260)object2).g, ((Kr260)object2).d);
                }
                if (Kh56.g(((Kr260)object2).d, object)) continue;
                varType = client.fd.list(((Kr260)object2).g);
                n2 = player.ex(player2, varType.debugNameHash32);
                if (n2 == null) continue;
                player2.triggerEvent(n2, ((Kr260)object2).d);
            }
        }
        if ((n4 & 0x200000) != 0) {
            n3 = gg3.r[gg3.v++] & 0xFF;
            for (int i = 0; i < n3; ++i) {
                object2 = client.fd.decodeVarValue(gg3);
                object = player2.by.h(((Kr260)object2).g);
                player2.by.s(((Kr260)object2).g, ((Kr260)object2).d);
                if (player2 != Gc330.j()) {
                    player.cv(player2, ((Kr260)object2).g, ((Kr260)object2).d);
                }
                if (Kh56.g(((Kr260)object2).d, object)) continue;
                varType = client.fd.list(((Kr260)object2).g);
                n2 = player.ex(player2, varType.debugNameHash32);
                if (n2 == null) continue;
                player2.triggerEvent(n2, ((Kr260)object2).d);
            }
        }
    }

    static {
        logger = LoggerFactory.getLogger(Gc330.class);
        q = -1;
        j = new ArrayList();
        b = Quaternion.g;
        l = 0;
        w = new LinkedList();
        r = new player[2048];
        v = new Gg3[2048];
    }

    public static player e(int n) {
        return r[n];
    }
}

