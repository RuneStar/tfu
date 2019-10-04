/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.login;

import com.jagex.core.constants.D123;
import com.jagex.core.constants.E294;
import com.jagex.game.runetek6.client.GameShell3;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer;
import com.jagex.game.runetek6.comms.statestream.packetchannel.PacketChannel;
import com.jagex.game.runetek6.comms.statestream.packetchannel.UDPPacketChannelClient;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.script.LuaEventHandler;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.jnibindings.runetek6.LuaNativeEvents;
import com.jagex.js5.js5;
import com.jagex.maths.Vector3;
import java.applet.AppletContext;
import java.io.IOException;
import java.math.BigInteger;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectableChannel;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.Ah608;
import rs2.client.L410;
import rs2.client.N272;
import rs2.client.R146;
import rs2.client.W159;
import rs2.client.chat.G232;
import rs2.client.client;
import rs2.client.friends.ClientFriendListComponent;
import rs2.client.inventory.G451;
import rs2.client.login.E275;
import rs2.client.login.H577;
import rs2.client.login.J570;
import rs2.client.login.L606;
import rs2.client.login.S605;
import rs2.client.login.V607;
import rs2.client.login.W274;
import rs2.client.login.Y276;
import rs2.client.lua.ClientScriptAPI;
import rs2.client.sound.SoundManager;
import rs2.shared.movement.Af182;
import tfu.Ea395;
import tfu.Ef450;
import tfu.El328;
import tfu.Ex582;
import tfu.Fg140;
import tfu.Fr156;
import tfu.Fw152;
import tfu.Gc330;
import tfu.Gg3;
import tfu.Gs329;
import tfu.Hb335;
import tfu.Hx339;
import tfu.Ic327;
import tfu.Ji520;
import tfu.Lf336;
import tfu.Lq191;
import tfu.Lx337;
import tfu.Lz409;
import tfu.Mf509;
import tfu.Mu209;

public class B271
extends Y276 {
    private static final Logger logger = LoggerFactory.getLogger(B271.class);
    final boolean b;
    S605 d;
    final long e;
    final String h;
    final String j;
    int l;
    L606 q;
    final long s;
    int w;

    public B271(N272 n272, long l, long l2, boolean bl, EventHandler eventHandler) {
        super(n272, 5.0f, eventHandler);
        this.j = null;
        this.e = l;
        this.h = null;
        this.s = l2;
        this.b = bl;
        if (this.e == 0L || this.s == 0L) {
            B271.l(this, E275.LOGIN_FAIL, Mf509.INVALID_USERNAME_OR_PASSWORD);
            return;
        }
        this.q = L606.CONNECT_UDP;
    }

    @Override
    public void g() {
        B271.n(this);
        this.q = L606.CONNECT_UDP;
    }

    public void j() {
        N272.s(this.v);
        client.de.close();
        client.de = null;
        LuaNativeEvents.detachAllEventHandlers(client.cj.getLuaStateNativeRef());
        client.dq.setChannel(null);
        client.dq.removeAllStreams();
        B271.n(this);
        this.d = new S605(System.currentTimeMillis() + 1000L, L606.CONNECT_UDP);
        this.q = L606.DELAY;
        logger.error("Switching world");
    }

    private static void l(B271 b271, E275 e275, Mf509 mf509) {
        logger.info("Login failed: result={} serverResponse={}", (Object)e275, (Object)mf509);
        b271.q = null;
        N272.s(b271.v);
        b271.i(e275, mf509);
    }

    private static void e(B271 b271, E275 e275) {
        N272.s(b271.v);
        J570.q();
        if (b271.z < 4) {
            Lx337.q(Lf336.q);
            b271.x = 0.0f;
            b271.p = 40.0f;
            ++b271.z;
            b271.q = L606.CONNECT_UDP;
        } else {
            B271.w(b271, e275);
        }
    }

    public void q() {
        N272.s(this.v);
        client.de.close();
        client.de = null;
        client.dq.setChannel(null);
        client.dq.removeAllStreams();
        B271.n(this);
        this.d = new S605(System.currentTimeMillis() + 1000L, L606.CONNECT_UDP);
        this.q = L606.DELAY;
    }

    public B271(N272 n272, String string, String string2, EventHandler eventHandler) {
        super(n272, 5.0f, eventHandler);
        this.j = string;
        this.e = 0L;
        this.h = string2;
        this.s = 0L;
        this.b = false;
        if (this.j.equals("") || this.h.equals("")) {
            B271.l(this, E275.LOGIN_FAIL, Mf509.INVALID_USERNAME_OR_PASSWORD);
            return;
        }
        this.q = L606.CONNECT_UDP;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public void d(float var1_1) {
        if (this.q == null) {
            return;
        }
        var2_2 = new Object[]{this.q, Float.valueOf(this.x), Float.valueOf(this.p)};
        B271.logger.error("Login step: {} - {} / {}", var2_2);
        this.x += var1_1;
        if (this.x > this.p) {
            B271.e(this, E275.TIMEOUT);
        }
        if (!J570.d()) {
            B271.w(this, E275.ERROR_OPENING_STATE_STREAM);
            return;
        }
        do {
            if (this.q == null) {
                return;
            }
            try {
                block6 : switch (V607.d[this.q.ordinal()]) {
                    case 1: {
                        if (System.currentTimeMillis() <= this.d.g) return;
                        this.q = this.d.d;
                        this.d = null;
                        break;
                    }
                    case 2: {
                        try {
                            var3_3 = DatagramChannel.open();
                            var3_3.configureBlocking(false);
                            var4_10 = var3_3.socket();
                            var4_10.bind(null);
                            var4_10.setReceiveBufferSize(65536);
                            var4_10.setSendBufferSize(65536);
                            var5_14 = new Object[]{var4_10.getLocalPort(), InetAddress.getByName(Lf336.q.d).getHostAddress(), Lf336.q.q};
                            B271.logger.debug("UDP: Opened local datagram port {} - connecting to {}:{}", var5_14);
                            var3_3.connect(new InetSocketAddress(InetAddress.getByName(Lf336.q.d), Lf336.q.q));
                            client.de = new UDPPacketChannelClient((DatagramChannel)var3_3);
                        }
                        catch (IOException var3_4) {
                            var3_4.printStackTrace();
                            B271.w(this, E275.ERROR_OPENING_STATE_STREAM);
                            return;
                        }
                        this.q = L606.CONNECT_TCP;
                        break;
                    }
                    case 3: {
                        this.v.q = Hx339.g(Lf336.q.g(), 15000);
                        N272.q(this.v);
                        var3_3 = El328.q();
                        Gs329.k(var3_3.q, Ex582.INIT_GAME_CONNECTION.w);
                        Gs329.k(var3_3.q, client.al != null ? 0 : 1);
                        N272.e(this.v, (El328)var3_3);
                        this.v.j();
                        this.q = L606.WAIT_FOR_CONNECTION_ACK;
                        break;
                    }
                    case 4: {
                        if (!this.v.q.d(1)) {
                            return;
                        }
                        this.v.q.j(this.v.b.r, 0, 1);
                        var3_5 = this.v.b.r[0] & 255;
                        if (var3_5 != 0) {
                            B271.w(this, E275.CONNECT_FAIL);
                            return;
                        }
                        this.q = L606.SEND_LOGIN_REQUEST;
                        break;
                    }
                    case 5: {
                        this.v.b.v = 0;
                        N272.q(this.v);
                        var3_3 = El328.q();
                        var4_10 = var3_3.q;
                        Gs329.k((Gg3)var4_10, Ex582.GAMELOGIN.w);
                        var4_10.v += 2;
                        var5_15 = var4_10.v;
                        Gs329.a((Gg3)var4_10, 1);
                        Gs329.a((Gg3)var4_10, 1);
                        Gs329.k((Gg3)var4_10, client.ac == 14 ? 1 : 0);
                        var6_17 = this.o();
                        if (this.h != null) {
                            Gg3.k(var6_17, 0);
                            var6_17.af(this.h);
                            Gg3.ag(var6_17, Double.doubleToLongBits(9.223372036854776E18 * Math.random()));
                        } else {
                            Gg3.k(var6_17, 1);
                            Gg3.k(var6_17, this.b != false ? 1 : 0);
                            Gg3.ag(var6_17, this.s);
                            Gg3.ag(var6_17, client.bi);
                        }
                        var6_17.bt(R146.g, R146.d);
                        Gs329.aa((Gg3)var4_10, var6_17.r, 0, var6_17.v);
                        var7_18 = var4_10.v;
                        if (this.j != null) {
                            var4_10.af(this.j);
                        } else {
                            Gs329.ag((Gg3)var4_10, this.e);
                        }
                        Gs329.k((Gg3)var4_10, client.a().ordinal());
                        Gs329.i((Gg3)var4_10, GameShell3.canvasWid);
                        Gs329.i((Gg3)var4_10, GameShell3.canvasHei);
                        Gs329.k((Gg3)var4_10, W159.g().q);
                        GameShell3.pushUID192((Gg3)var4_10);
                        var4_10.af(client.o);
                        Gs329.a((Gg3)var4_10, client.f);
                        var8_19 = new Gg3(Fr156.q(client.aj));
                        Fr156.d(client.aj, var8_19);
                        Gs329.aa((Gg3)var4_10, var8_19.r, 0, var8_19.r.length);
                        Gs329.a((Gg3)var4_10, client.fe);
                        Gs329.a((Gg3)var4_10, client.ap.q);
                        Gs329.ag((Gg3)var4_10, client.ap.g);
                        Gs329.k((Gg3)var4_10, client.ap.d == null ? 0 : 1);
                        if (client.ap.d != null) {
                            var4_10.af(client.ap.d);
                        }
                        Gs329.k((Gg3)var4_10, client.k != false ? 1 : 0);
                        Gs329.k((Gg3)var4_10, client.an != false ? 1 : 0);
                        Gs329.a((Gg3)var4_10, client.dr.d());
                        Gs329.a((Gg3)var4_10, client.db.d());
                        Gs329.a((Gg3)var4_10, client.dd.d());
                        Gs329.a((Gg3)var4_10, client.dy.d());
                        Gs329.a((Gg3)var4_10, client.dg.d());
                        Gs329.a((Gg3)var4_10, client.er.d());
                        Gs329.a((Gg3)var4_10, client.ez.d());
                        Gs329.a((Gg3)var4_10, client.et.d());
                        Gs329.a((Gg3)var4_10, client.eu.d());
                        Gs329.a((Gg3)var4_10, client.ey.d());
                        Gs329.a((Gg3)var4_10, client.ea.d());
                        Gs329.a((Gg3)var4_10, client.eo.d());
                        Gs329.a((Gg3)var4_10, client.em.d());
                        Gs329.a((Gg3)var4_10, client.eh.d());
                        Gs329.a((Gg3)var4_10, client.es.d());
                        Gs329.a((Gg3)var4_10, client.ec.d());
                        Gs329.a((Gg3)var4_10, client.ei.d());
                        Gs329.a((Gg3)var4_10, client.ef.d());
                        Gs329.a((Gg3)var4_10, client.ek.d());
                        Gs329.a((Gg3)var4_10, client.eb.d());
                        Gs329.a((Gg3)var4_10, client.ee.d());
                        Gs329.a((Gg3)var4_10, client.ep.d());
                        Gs329.ba((Gg3)var4_10, this.u, var7_18, var4_10.v);
                        Gs329.as((Gg3)var4_10, var4_10.v - var5_15);
                        N272.e(this.v, (El328)var3_3);
                        this.v.j();
                        this.v.s = new Ic327(this.u);
                        var9_20 = 0;
                        while (var9_20 < 4) {
                            v0 = this.u;
                            v1 = var9_20++;
                            v0[v1] = v0[v1] + 50;
                        }
                        this.v.l = new Ic327(this.u);
                        this.v.w = new Ic327(this.u);
                        Gs329.g(this.v.b, this.v.l);
                        this.q = L606.WAIT_FOR_LOGIN_RESPONSE;
                        break;
                    }
                    case 6: {
                        if (!this.v.q.d(1)) {
                            return;
                        }
                        this.v.q.j(this.v.b.r, 0, 1);
                        var3_6 = this.v.b.r[0] & 255;
                        var4_10 = (Mf509)E294.g(Mf509.class, var3_6);
                        if (var4_10 == null) {
                            B271.logger.warn("Encountered unrecognised login response code {}", var3_6);
                            B271.l(this, E275.LOGIN_FAIL, (Mf509)var4_10);
                            break;
                        }
                        switch (V607.g[var4_10.ordinal()]) {
                            case 1: {
                                this.q = L606.WAIT_FOR_LOGIN_OK_LENGTH;
                                break block6;
                            }
                            case 2: {
                                J570.g(this.u);
                                this.u = null;
                                this.q = L606.WAIT_FOR_UDP_LOGIN_RECONNECT;
                                break block6;
                            }
                            case 3: {
                                this.q = L606.WAIT_FOR_SCRIPT_DISALLOW_REASON;
                                break block6;
                            }
                            case 4: {
                                this.q = L606.WAIT_FOR_HOP_BLOCK_DURATION;
                                break block6;
                            }
                            case 5: {
                                this.q = L606.WAIT_FOR_QUEUE_POSITION;
                                break block6;
                            }
                            case 6: {
                                B271.l(this, E275.LOGIN_FAIL, (Mf509)var4_10);
                                break block6;
                            }
                        }
                        B271.l(this, E275.LOGIN_FAIL, (Mf509)var4_10);
                        break;
                    }
                    case 7: {
                        if (!this.v.q.d(1)) {
                            return;
                        }
                        this.v.q.j(this.v.b.r, 0, 1);
                        var3_7 = this.v.b.r[0] & 255;
                        B271.l(this, E275.LOGIN_FAIL, Mf509.HOP_BLOCKED);
                        break;
                    }
                    case 8: {
                        if (!this.v.q.d(2)) {
                            return;
                        }
                        this.v.q.j(this.v.b.r, 0, 2);
                        this.t = ((this.v.b.r[0] & 255) << 8) + (this.v.b.r[1] & 255);
                        B271.logger.trace("Position {} in queue {}", this.t, (Object)this.j);
                        this.q = L606.WAIT_FOR_LOGIN_RESPONSE;
                        break;
                    }
                    case 9: {
                        if (!this.v.q.d(1)) {
                            return;
                        }
                        this.v.q.j(this.v.b.r, 0, 1);
                        var3_8 = this.v.b.r[0] & 255;
                        B271.l(this, E275.LOGIN_FAIL, Mf509.DISALLOWED_BY_SCRIPT);
                        break;
                    }
                    case 10: {
                        if (!this.v.q.d(1)) {
                            return;
                        }
                        this.v.q.j(this.v.b.r, 0, 1);
                        this.l = this.v.b.r[0] & 255;
                        this.q = L606.WAIT_FOR_LOGIN_DETAILS;
                        break;
                    }
                    case 11: {
                        var3_3 = this.v.b;
                        if (!this.v.q.d(this.l)) {
                            return;
                        }
                        this.v.q.j(var3_3.r, 0, this.l);
                        var3_3.v = 0;
                        client.ik = Gs329.ar((Gg3)var3_3);
                        client.in = Gs329.ar((Gg3)var3_3);
                        client.ic = Gs329.ar((Gg3)var3_3) == 1;
                        client.ig = Gs329.ar((Gg3)var3_3) == 1;
                        client.io = Gs329.ar((Gg3)var3_3) == 1;
                        Gc330.g();
                        Gc330.q(Gs329.au((Gg3)var3_3));
                        ClientScriptAPI.setNativeSelfGameEntity(client.cj.getScriptManagerNativeRef(), client.cj.getLuaStateNativeRef(), null);
                        client.ip = Gs329.ar((Gg3)var3_3) == 1;
                        client.iy = Gs329.ad((Gg3)var3_3);
                        client.il = Gs329.ar((Gg3)var3_3) == 1;
                        client.br = Gs329.bk((Gg3)var3_3);
                        client.fa.setAllowMembers(client.il);
                        Lq191.q(Gs329.ar((Gg3)var3_3));
                        client.dz = 1;
                        client.du = false;
                        client.cj.event.triggerEvent("__onLogin", null);
                        if ((!client.ic || client.ig) && !client.ip) ** GOTO lbl251
                        try {
                            Mu209.g(client.bu, "zap");
                        }
                        catch (Throwable var4_11) {
                            if (!client.i) ** GOTO lbl257
                            try {
                                client.bu.getAppletContext().showDocument(new URL(client.bu.getCodeBase(), "blank.ws"), "tbi");
                                ** GOTO lbl257
                            }
                            catch (Exception var5_16) {}
                        }
                        ** GOTO lbl257
                        {
                        }
lbl251: // 1 sources:
                        try {
                            Mu209.g(client.bu, "unzap");
                        }
                        catch (Throwable var4_12) {
                            // empty catch block
                        }
lbl257: // 6 sources:
                        if (client.t == D123.LIVE) {
                            try {
                                Mu209.g(client.bu, "loggedin");
                            }
                            catch (Throwable var4_13) {
                                // empty catch block
                            }
                        }
                        J570.g(this.u);
                        this.u = null;
                        this.q = L606.WAIT_FOR_PLAYER_PACKET_LENGTH1;
                        break;
                    }
                    case 12: {
                        if (!this.v.q.d(3)) {
                            return;
                        }
                        this.v.q.j(this.v.b.r, 0, 3);
                        this.q = L606.WAIT_FOR_PLAYER_PACKET_LENGTH2;
                        break;
                    }
                    case 13: {
                        var3_3 = this.v.b;
                        var3_3.v = 0;
                        if (Gs329.q((Gs329)var3_3)) {
                            if (!this.v.q.d(1)) {
                                return;
                            }
                            this.v.q.j(var3_3.r, 3, 1);
                        }
                        this.v.r = Ea395.values()[Gs329.j((Gs329)var3_3)];
                        this.v.v = Gs329.au((Gg3)var3_3);
                        this.q = L606.WAIT_FOR_PLAYER_PACKET;
                        break;
                    }
                    case 14: {
                        if (client.cr == null) {
                            this.v.b.v = 0;
                            this.v.r = null;
                            this.v.n = null;
                            this.v.k = null;
                            this.v.i = null;
                            this.v.v = 0;
                            this.v.p = 0.0f;
                            client.bv = 0;
                            Gc330.g();
                            G451.j();
                            client.z(11);
                            client.ag();
                            this.v.r = null;
                            this.i(E275.SUCCESS, Mf509.RECONNECT_OK);
                            B271.logger.info("Reconnected OK");
                            this.q = null;
                        }
                        B271.logger.trace("Waiting for UDP login to go through");
                        return;
                    }
                    case 15: {
                        if (!this.v.q.d(this.v.v)) {
                            return;
                        }
                        this.v.q.j(this.v.b.r, 0, this.v.v);
                        this.v.b.v = 0;
                        this.w = this.v.v;
                        client.bj(Af182.g);
                        Lz409.x(Lz409.d);
                        client.dr.m = 1;
                        if (client.ac == 15) {
                            client.av();
                        }
                        this.v.b.v = 0;
                        this.v.n = null;
                        this.v.k = null;
                        this.v.i = null;
                        this.v.p = 0.0f;
                        client.bv = 0;
                        G232.h();
                        ClientFriendListComponent.d(client.ku);
                        client.ju = null;
                        client.km = 0;
                        client.kg = null;
                        client.kj = null;
                        client.kv = null;
                        GameShell3.focus = true;
                        client.bk = true;
                        Ji520.g();
                        SoundManager.y();
                        client.gw = (int)(Math.random() * 100.0) - 50;
                        client.gx = (int)(Math.random() * 110.0) - 55;
                        client.hn = (int)(Math.random() * 80.0) - 40;
                        client.hj = (int)(Math.random() * 120.0) - 60;
                        client.ho = (int)(Math.random() * 30.0) - 20;
                        client.ft.clear();
                        Hb335.g(client.jb);
                        client.jw.d();
                        L410.d();
                        Fg140.d(client.jr);
                        G451.j();
                        client.ae = true;
                        ObjType.clientpalette = new short[256];
                        client.hi = ObjType.clientpalette;
                        client.fe = 0;
                        client.ag();
                        client.dr.m = 2;
                        this.q = L606.WAIT_FOR_UDP_LOGIN;
                        return;
                    }
                    case 16: {
                        B271.logger.trace("Waiting for udp login!");
                        if (client.cr != null) return;
                        client.gd = -1.0f;
                        client.bp();
                        if (this.v.b.v != this.w) {
                            throw new RuntimeException(this.v.b.v + " " + this.w);
                        }
                        this.v.r = null;
                        B271.k(this, E275.SUCCESS);
                        B271.logger.info("Logged in OK");
                        this.q = null;
                        return;
                    }
                }
                continue;
            }
            catch (IOException var3_9) {
                B271.logger.error("", var3_9);
                B271.e(this, E275.IOERROR);
                continue;
            }
            break;
        } while (true);
    }

    private static void w(B271 b271, E275 e275) {
        logger.info("Login failed: result={}", (Object)e275);
        B271.l(b271, e275, null);
    }
}

