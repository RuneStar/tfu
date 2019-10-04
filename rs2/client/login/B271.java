// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.login;

import java.net.DatagramSocket;
import com.jagex.game.runetek6.config.objtype.ObjType;
import tfu.Fg140;
import rs2.client.L410;
import tfu.Hb335;
import rs2.client.sound.SoundManager;
import tfu.Ji520;
import rs2.client.friends.ClientFriendListComponent;
import rs2.client.chat.G232;
import tfu.Lz409;
import rs2.shared.movement.Af182;
import rs2.client.inventory.G451;
import tfu.Ea395;
import com.jagex.core.constants.D123;
import java.net.URL;
import java.applet.Applet;
import tfu.Mu209;
import tfu.Lq191;
import com.jagex.game.runetek6.gameentity.GameEntity;
import rs2.client.lua.ClientScriptAPI;
import tfu.Gc330;
import com.jagex.core.constants.E294;
import tfu.Gs329;
import tfu.Ic327;
import tfu.Fr156;
import rs2.client.W159;
import com.jagex.game.runetek6.client.GameShell3;
import rs2.client.R146;
import tfu.Gg3;
import tfu.Ex582;
import tfu.El328;
import tfu.Hx339;
import java.io.IOException;
import com.jagex.game.runetek6.comms.statestream.packetchannel.UDPPacketChannelClient;
import java.net.InetSocketAddress;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;
import org.slf4j.LoggerFactory;
import tfu.Lx337;
import tfu.Lf336;
import com.jagex.game.runetek6.comms.statestream.packetchannel.PacketChannel;
import com.jagex.jnibindings.runetek6.LuaNativeEvents;
import rs2.client.client;
import tfu.Mf509;
import com.jagex.game.runetek6.event.EventHandler;
import rs2.client.N272;
import org.slf4j.Logger;

public class B271 extends Y276
{
    private static final Logger logger;
    final boolean b;
    S605 d;
    final long e;
    final String h;
    final String j;
    int l;
    L606 q;
    final long s;
    int w;
    
    public B271(final N272 n272, final long e, final long s, final boolean b, final EventHandler eventHandler) {
        super(n272, 5.0f, eventHandler);
        this.j = null;
        this.e = e;
        this.h = null;
        this.s = s;
        this.b = b;
        if (this.e == 0L || this.s == 0L) {
            l(this, E275.LOGIN_FAIL, Mf509.INVALID_USERNAME_OR_PASSWORD);
            return;
        }
        this.q = L606.CONNECT_UDP;
    }
    
    public void g() {
        Y276.n(this);
        this.q = L606.CONNECT_UDP;
    }
    
    public void j() {
        N272.s(super.v);
        client.de.close();
        client.de = null;
        LuaNativeEvents.detachAllEventHandlers(client.cj.getLuaStateNativeRef());
        client.dq.setChannel(null);
        client.dq.removeAllStreams();
        Y276.n(this);
        this.d = new S605(System.currentTimeMillis() + 1000L, L606.CONNECT_UDP);
        this.q = L606.DELAY;
        B271.logger.error("Switching world");
    }
    
    private static void l(final B271 b271, final E275 e275, final Mf509 mf509) {
        B271.logger.info("Login failed: result={} serverResponse={}", e275, mf509);
        b271.q = null;
        N272.s(b271.v);
        b271.i(e275, mf509);
    }
    
    private static void e(final B271 b271, final E275 e275) {
        N272.s(b271.v);
        J570.q();
        if (b271.z < 4) {
            Lx337.q(Lf336.q);
            b271.x = 0.0f;
            b271.p = 40.0f;
            ++b271.z;
            b271.q = L606.CONNECT_UDP;
        }
        else {
            w(b271, e275);
        }
    }
    
    public void q() {
        N272.s(super.v);
        client.de.close();
        client.de = null;
        client.dq.setChannel(null);
        client.dq.removeAllStreams();
        Y276.n(this);
        this.d = new S605(System.currentTimeMillis() + 1000L, L606.CONNECT_UDP);
        this.q = L606.DELAY;
    }
    
    public B271(final N272 n272, final String j, final String h, final EventHandler eventHandler) {
        super(n272, 5.0f, eventHandler);
        this.j = j;
        this.e = 0L;
        this.h = h;
        this.s = 0L;
        this.b = false;
        if (this.j.equals("") || this.h.equals("")) {
            l(this, E275.LOGIN_FAIL, Mf509.INVALID_USERNAME_OR_PASSWORD);
            return;
        }
        this.q = L606.CONNECT_UDP;
    }
    
    static {
        logger = LoggerFactory.getLogger(B271.class);
    }
    
    public void d(final float n) {
        if (this.q == null) {
            return;
        }
        B271.logger.error("Login step: {} - {} / {}", new Object[] { this.q, super.x, super.p });
        super.x += n;
        if (super.x > super.p) {
            e(this, E275.TIMEOUT);
        }
        if (!J570.d()) {
            w(this, E275.ERROR_OPENING_STATE_STREAM);
            return;
        }
        while (this.q != null) {
            try {
                switch (V607.d[this.q.ordinal()]) {
                    case 1: {
                        if (System.currentTimeMillis() > this.d.g) {
                            this.q = this.d.d;
                            this.d = null;
                            continue;
                        }
                    }
                    case 2: {
                        try {
                            final DatagramChannel open = DatagramChannel.open();
                            open.configureBlocking(false);
                            final DatagramSocket socket = open.socket();
                            socket.bind(null);
                            socket.setReceiveBufferSize(65536);
                            socket.setSendBufferSize(65536);
                            B271.logger.debug("UDP: Opened local datagram port {} - connecting to {}:{}", new Object[] { socket.getLocalPort(), InetAddress.getByName(Lf336.q.d).getHostAddress(), Lf336.q.q });
                            open.connect(new InetSocketAddress(InetAddress.getByName(Lf336.q.d), Lf336.q.q));
                            client.de = new UDPPacketChannelClient(open);
                        }
                        catch (IOException ex) {
                            ex.printStackTrace();
                            w(this, E275.ERROR_OPENING_STATE_STREAM);
                            return;
                        }
                        this.q = L606.CONNECT_TCP;
                        continue;
                    }
                    case 3: {
                        super.v.q = Hx339.g(Lf336.q.g(), 15000);
                        N272.q(super.v);
                        final El328 q = El328.q();
                        Gg3.k(q.q, Ex582.INIT_GAME_CONNECTION.w);
                        Gg3.k(q.q, (client.al == null) ? 1 : 0);
                        N272.e(super.v, q);
                        super.v.j();
                        this.q = L606.WAIT_FOR_CONNECTION_ACK;
                        continue;
                    }
                    case 4: {
                        if (!super.v.q.d(1)) {
                            return;
                        }
                        super.v.q.j(super.v.b.r, 0, 1);
                        if ((super.v.b.r[0] & 0xFF) != 0x0) {
                            w(this, E275.CONNECT_FAIL);
                            return;
                        }
                        this.q = L606.SEND_LOGIN_REQUEST;
                        continue;
                    }
                    case 5: {
                        super.v.b.v = 0;
                        N272.q(super.v);
                        final El328 q2 = El328.q();
                        final Gs329 q3 = q2.q;
                        Gg3.k(q3, Ex582.GAMELOGIN.w);
                        final Gs329 gs329 = q3;
                        gs329.v += 2;
                        final int v = q3.v;
                        Gg3.a(q3, 1);
                        Gg3.a(q3, 1);
                        Gg3.k(q3, (client.ac == 14) ? 1 : 0);
                        final Gg3 o = this.o();
                        if (this.h != null) {
                            Gg3.k(o, 0);
                            o.af(this.h);
                            Gg3.ag(o, Double.doubleToLongBits(9.223372036854776E18 * Math.random()));
                        }
                        else {
                            Gg3.k(o, 1);
                            Gg3.k(o, this.b ? 1 : 0);
                            Gg3.ag(o, this.s);
                            Gg3.ag(o, client.bi);
                        }
                        o.bt(R146.g, R146.d);
                        Gg3.aa(q3, o.r, 0, o.v);
                        final int v2 = q3.v;
                        if (this.j != null) {
                            q3.af(this.j);
                        }
                        else {
                            Gg3.ag(q3, this.e);
                        }
                        Gg3.k(q3, client.a().ordinal());
                        Gg3.i(q3, GameShell3.canvasWid);
                        Gg3.i(q3, GameShell3.canvasHei);
                        Gg3.k(q3, W159.g().q);
                        GameShell3.pushUID192(q3);
                        q3.af(client.o);
                        Gg3.a(q3, client.f);
                        final Gg3 gg3 = new Gg3(Fr156.q(client.aj));
                        Fr156.d(client.aj, gg3);
                        Gg3.aa(q3, gg3.r, 0, gg3.r.length);
                        Gg3.a(q3, client.fe);
                        Gg3.a(q3, client.ap.q);
                        Gg3.ag(q3, client.ap.g);
                        Gg3.k(q3, (client.ap.d != null) ? 1 : 0);
                        if (client.ap.d != null) {
                            q3.af(client.ap.d);
                        }
                        Gg3.k(q3, client.k ? 1 : 0);
                        Gg3.k(q3, client.an ? 1 : 0);
                        Gg3.a(q3, client.dr.d());
                        Gg3.a(q3, client.db.d());
                        Gg3.a(q3, client.dd.d());
                        Gg3.a(q3, client.dy.d());
                        Gg3.a(q3, client.dg.d());
                        Gg3.a(q3, client.er.d());
                        Gg3.a(q3, client.ez.d());
                        Gg3.a(q3, client.et.d());
                        Gg3.a(q3, client.eu.d());
                        Gg3.a(q3, client.ey.d());
                        Gg3.a(q3, client.ea.d());
                        Gg3.a(q3, client.eo.d());
                        Gg3.a(q3, client.em.d());
                        Gg3.a(q3, client.eh.d());
                        Gg3.a(q3, client.es.d());
                        Gg3.a(q3, client.ec.d());
                        Gg3.a(q3, client.ei.d());
                        Gg3.a(q3, client.ef.d());
                        Gg3.a(q3, client.ek.d());
                        Gg3.a(q3, client.eb.d());
                        Gg3.a(q3, client.ee.d());
                        Gg3.a(q3, client.ep.d());
                        Gg3.ba(q3, super.u, v2, q3.v);
                        Gg3.as(q3, q3.v - v);
                        N272.e(super.v, q2);
                        super.v.j();
                        super.v.s = new Ic327(super.u);
                        for (int i = 0; i < 4; ++i) {
                            final int[] u = super.u;
                            final int n2 = i;
                            u[n2] += 50;
                        }
                        super.v.l = new Ic327(super.u);
                        super.v.w = new Ic327(super.u);
                        Gs329.g(super.v.b, super.v.l);
                        this.q = L606.WAIT_FOR_LOGIN_RESPONSE;
                        continue;
                    }
                    case 6: {
                        if (!super.v.q.d(1)) {
                            return;
                        }
                        super.v.q.j(super.v.b.r, 0, 1);
                        final int j = super.v.b.r[0] & 0xFF;
                        final Mf509 mf509 = (Mf509)E294.g(Mf509.class, j);
                        if (mf509 == null) {
                            B271.logger.warn("Encountered unrecognised login response code {}", j);
                            l(this, E275.LOGIN_FAIL, mf509);
                            continue;
                        }
                        switch (V607.g[mf509.ordinal()]) {
                            case 1: {
                                this.q = L606.WAIT_FOR_LOGIN_OK_LENGTH;
                                continue;
                            }
                            case 2: {
                                J570.g(super.u);
                                super.u = null;
                                this.q = L606.WAIT_FOR_UDP_LOGIN_RECONNECT;
                                continue;
                            }
                            case 3: {
                                this.q = L606.WAIT_FOR_SCRIPT_DISALLOW_REASON;
                                continue;
                            }
                            case 4: {
                                this.q = L606.WAIT_FOR_HOP_BLOCK_DURATION;
                                continue;
                            }
                            case 5: {
                                this.q = L606.WAIT_FOR_QUEUE_POSITION;
                                continue;
                            }
                            case 6: {
                                l(this, E275.LOGIN_FAIL, mf509);
                                continue;
                            }
                            default: {
                                l(this, E275.LOGIN_FAIL, mf509);
                                continue;
                            }
                        }
                        break;
                    }
                    case 7: {
                        if (!super.v.q.d(1)) {
                            return;
                        }
                        super.v.q.j(super.v.b.r, 0, 1);
                        final int n3 = super.v.b.r[0] & 0xFF;
                        l(this, E275.LOGIN_FAIL, Mf509.HOP_BLOCKED);
                        continue;
                    }
                    case 8: {
                        if (!super.v.q.d(2)) {
                            return;
                        }
                        super.v.q.j(super.v.b.r, 0, 2);
                        super.t = ((super.v.b.r[0] & 0xFF) << 8) + (super.v.b.r[1] & 0xFF);
                        B271.logger.trace("Position {} in queue {}", super.t, this.j);
                        this.q = L606.WAIT_FOR_LOGIN_RESPONSE;
                        continue;
                    }
                    case 9: {
                        if (!super.v.q.d(1)) {
                            return;
                        }
                        super.v.q.j(super.v.b.r, 0, 1);
                        final int n4 = super.v.b.r[0] & 0xFF;
                        l(this, E275.LOGIN_FAIL, Mf509.DISALLOWED_BY_SCRIPT);
                        continue;
                    }
                    case 10: {
                        if (!super.v.q.d(1)) {
                            return;
                        }
                        super.v.q.j(super.v.b.r, 0, 1);
                        this.l = (super.v.b.r[0] & 0xFF);
                        this.q = L606.WAIT_FOR_LOGIN_DETAILS;
                        continue;
                    }
                    case 11: {
                        final Gs329 b = super.v.b;
                        if (!super.v.q.d(this.l)) {
                            return;
                        }
                        super.v.q.j(b.r, 0, this.l);
                        b.v = 0;
                        client.ik = Gg3.ar(b);
                        client.in = Gg3.ar(b);
                        client.ic = (Gg3.ar(b) == 1);
                        client.ig = (Gg3.ar(b) == 1);
                        client.io = (Gg3.ar(b) == 1);
                        Gc330.g();
                        Gc330.q(Gg3.au(b));
                        ClientScriptAPI.setNativeSelfGameEntity(client.cj.getScriptManagerNativeRef(), client.cj.getLuaStateNativeRef(), null);
                        client.ip = (Gg3.ar(b) == 1);
                        client.iy = Gg3.ad(b);
                        client.il = (Gg3.ar(b) == 1);
                        client.br = Gg3.bk(b);
                        client.fa.setAllowMembers(client.il);
                        Lq191.q(Gg3.ar(b));
                        client.dz = 1;
                        client.du = false;
                        client.cj.event.triggerEvent("__onLogin", null);
                        Label_2238: {
                            if (!client.ic || client.ig) {
                                if (!client.ip) {
                                    try {
                                        Mu209.g(client.bu, "unzap");
                                    }
                                    catch (Throwable t) {}
                                    break Label_2238;
                                }
                            }
                            try {
                                Mu209.g(client.bu, "zap");
                            }
                            catch (Throwable t2) {
                                if (client.i) {
                                    try {
                                        client.bu.getAppletContext().showDocument(new URL(client.bu.getCodeBase(), "blank.ws"), "tbi");
                                    }
                                    catch (Exception ex3) {}
                                }
                            }
                        }
                        if (client.t == D123.LIVE) {
                            try {
                                Mu209.g(client.bu, "loggedin");
                            }
                            catch (Throwable t3) {}
                        }
                        J570.g(super.u);
                        super.u = null;
                        this.q = L606.WAIT_FOR_PLAYER_PACKET_LENGTH1;
                        continue;
                    }
                    case 12: {
                        if (!super.v.q.d(3)) {
                            return;
                        }
                        super.v.q.j(super.v.b.r, 0, 3);
                        this.q = L606.WAIT_FOR_PLAYER_PACKET_LENGTH2;
                        continue;
                    }
                    case 13: {
                        final Gs329 b2 = super.v.b;
                        b2.v = 0;
                        if (Gs329.q(b2)) {
                            if (!super.v.q.d(1)) {
                                return;
                            }
                            super.v.q.j(b2.r, 3, 1);
                        }
                        super.v.r = Ea395.values()[Gs329.j(b2)];
                        super.v.v = Gg3.au(b2);
                        this.q = L606.WAIT_FOR_PLAYER_PACKET;
                        continue;
                    }
                    case 14: {
                        if (client.cr == null) {
                            super.v.b.v = 0;
                            super.v.r = null;
                            super.v.n = null;
                            super.v.k = null;
                            super.v.i = null;
                            super.v.v = 0;
                            super.v.p = 0.0f;
                            client.bv = 0;
                            Gc330.g();
                            G451.j();
                            client.z(11);
                            client.ag();
                            super.v.r = null;
                            this.i(E275.SUCCESS, Mf509.RECONNECT_OK);
                            B271.logger.info("Reconnected OK");
                            this.q = null;
                        }
                        B271.logger.trace("Waiting for UDP login to go through");
                    }
                    case 15: {
                        if (!super.v.q.d(super.v.v)) {
                            return;
                        }
                        super.v.q.j(super.v.b.r, 0, super.v.v);
                        super.v.b.v = 0;
                        this.w = super.v.v;
                        client.bj(Af182.g);
                        Lz409.x(Lz409.d);
                        client.dr.m = 1;
                        if (client.ac == 15) {
                            client.av();
                        }
                        super.v.b.v = 0;
                        super.v.n = null;
                        super.v.k = null;
                        super.v.i = null;
                        super.v.p = 0.0f;
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
                        client.hi = (ObjType.clientpalette = new short[256]);
                        client.fe = 0;
                        client.ag();
                        client.dr.m = 2;
                        this.q = L606.WAIT_FOR_UDP_LOGIN;
                    }
                    case 16: {
                        B271.logger.trace("Waiting for udp login!");
                        if (client.cr != null) {
                            return;
                        }
                        client.gd = -1.0f;
                        client.bp();
                        if (super.v.b.v != this.w) {
                            throw new RuntimeException(super.v.b.v + " " + this.w);
                        }
                        super.v.r = null;
                        Y276.k(this, E275.SUCCESS);
                        B271.logger.info("Logged in OK");
                        this.q = null;
                    }
                }
            }
            catch (IOException ex2) {
                B271.logger.error("", ex2);
                e(this, E275.IOERROR);
            }
        }
    }
    
    private static void w(final B271 b271, final E275 e275) {
        B271.logger.info("Login failed: result={}", e275);
        l(b271, e275, null);
    }
}
