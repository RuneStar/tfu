/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.login;

import com.jagex.core.constants.Language;
import com.jagex.game.runetek6.event.EventHandler;
import java.io.IOException;
import java.math.BigInteger;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.N272;
import rs2.client.R146;
import rs2.client.client;
import rs2.client.login.E275;
import rs2.client.login.Q580;
import rs2.client.login.W274;
import rs2.client.login.Y276;
import tfu.Dp208;
import tfu.El328;
import tfu.Ex582;
import tfu.Gd27;
import tfu.Gg3;
import tfu.Gs329;
import tfu.Hx339;
import tfu.Lf336;
import tfu.Lx337;
import tfu.Mf509;

public class G270
extends Y276 {
    private static final Logger logger = LoggerFactory.getLogger(G270.class);
    Q580 d;
    public long e;
    public long h;
    int j;
    int q;

    @Override
    public void d(float f) {
        if (this.d == null) {
            return;
        }
        Object[] arrobject = new Object[]{this.d, Float.valueOf(this.x), Float.valueOf(this.p)};
        logger.info("Login step: {} - {} / {}", arrobject);
        this.x += f;
        if (this.x > this.p) {
            G270.q(this, E275.TIMEOUT);
        }
        while (this.d != null) {
            try {
                switch (this.d) {
                    case CONNECT: {
                        this.v.q = Hx339.g(Lf336.q.g(), 15000);
                        N272.q(this.v);
                        Object object = El328.q();
                        Gs329.k(((El328)object).q, Ex582.INIT_SOCIAL_NETWORK_CONNECTION.w);
                        Gs329.i(((El328)object).q, 0);
                        int n = object.q.v;
                        Gs329.a(((El328)object).q, 1);
                        Gs329.a(((El328)object).q, 1);
                        Gs329.k(((El328)object).q, client.ac == 14 ? 1 : 0);
                        Gg3 gg3 = this.o();
                        Gg3.k(gg3, this.q);
                        Gg3.i(gg3, (int)(Math.random() * 9.9999999E7));
                        Gg3.k(gg3, client.n.getId());
                        Gg3.a(gg3, client.f);
                        for (int i = 0; i < 6; ++i) {
                            Gg3.a(gg3, (int)(Math.random() * 9.9999999E7));
                        }
                        Gg3.ag(gg3, client.bi);
                        Gg3.k(gg3, client.m.b);
                        Gg3.k(gg3, (int)(Math.random() * 9.9999999E7));
                        gg3.bt(R146.g, R146.d);
                        Gs329.aa(((El328)object).q, gg3.r, 0, gg3.v);
                        Gs329.as(((El328)object).q, object.q.v - n);
                        N272.e(this.v, (El328)object);
                        this.v.j();
                        this.d = Q580.WAIT_FOR_CONNECTION_ACK;
                        break;
                    }
                    case WAIT_FOR_CONNECTION_ACK: {
                        if (!this.v.q.d(1)) {
                            return;
                        }
                        this.v.q.j(this.v.b.r, 0, 1);
                        int n = this.v.b.r[0] & 0xFF;
                        if (n != 0) {
                            G270.e(this, E275.CONNECT_FAIL);
                            return;
                        }
                        this.d = Q580.WAIT_FOR_SOCIAL_NETWORK_TOKEN_LENGTH;
                        break;
                    }
                    case WAIT_FOR_SOCIAL_NETWORK_TOKEN_LENGTH: {
                        if (!this.v.q.d(2)) {
                            return;
                        }
                        this.v.q.j(this.v.b.r, 0, 2);
                        this.v.b.v = 0;
                        this.v.b.v = Gs329.au(this.v.b);
                        this.d = Q580.WAIT_FOR_SOCIAL_NETWORK_TOKEN;
                        break;
                    }
                    case WAIT_FOR_SOCIAL_NETWORK_TOKEN: {
                        if (!this.v.q.d(this.v.b.v)) {
                            return;
                        }
                        this.v.q.j(this.v.b.r, 0, this.v.b.v);
                        Gs329.bb(this.v.b, this.u);
                        this.v.b.v = 0;
                        Object object = this.v.b.bh();
                        this.v.b.v = 0;
                        if (!((String)object).startsWith("https://local.")) {
                            String string = "opensn";
                            if (!client.k || !Dp208.s((String)object, 1, string)) {
                                try {
                                    Dp208.j((String)object, true, false, string, client.ao, client.aa);
                                }
                                catch (Exception exception) {
                                    G270.e(this, E275.LOGIN_FAIL);
                                    return;
                                }
                            }
                        }
                        this.d = Q580.WAIT_FOR_SSO_KEY_RESPONSE;
                        break;
                    }
                    case WAIT_FOR_SSO_KEY_RESPONSE: {
                        if (!this.v.q.d(1)) {
                            return;
                        }
                        this.v.q.j(this.v.b.r, 0, 1);
                        if ((this.v.b.r[0] & 0xFF) != 1) break;
                        this.d = Q580.WAIT_FOR_SSO_KEY;
                        break;
                    }
                    case WAIT_FOR_SSO_KEY: {
                        if (!this.v.q.d(16)) {
                            return;
                        }
                        this.v.q.j(this.v.b.r, 0, 16);
                        this.v.b.v = 16;
                        Gs329.bb(this.v.b, this.u);
                        this.v.b.v = 0;
                        this.e = Gs329.bq(this.v.b);
                        this.h = Gs329.bq(this.v.b);
                        G270.k(this, E275.SUCCESS);
                        this.d = null;
                    }
                }
                continue;
            }
            catch (IOException iOException) {
                logger.error("", iOException);
                G270.q(this, E275.IOERROR);
                continue;
            }
            break;
        }
        return;
    }

    public G270(N272 n272, int n, EventHandler eventHandler) {
        super(n272, 5.0f, eventHandler);
        this.q = n;
        this.d = Q580.CONNECT;
    }

    private static void e(G270 g270, E275 e275) {
        G270.j(g270, e275, null);
    }

    private static void q(G270 g270, E275 e275) {
        N272.s(g270.v);
        if (g270.z < 4) {
            Lx337.q(Lf336.q);
            g270.x = 0.0f;
            g270.p = g270.d != Q580.CONNECT && g270.d != Q580.WAIT_FOR_CONNECTION_ACK && g270.d != Q580.WAIT_FOR_SOCIAL_NETWORK_TOKEN_LENGTH && g270.d != Q580.WAIT_FOR_SOCIAL_NETWORK_TOKEN ? 120.0f : 40.0f;
            ++g270.z;
            g270.d = Q580.CONNECT;
        } else {
            G270.e(g270, e275);
        }
    }

    private static void j(G270 g270, E275 e275, Mf509 mf509) {
        g270.d = null;
        N272.s(g270.v);
        g270.i(e275, mf509);
    }
}

