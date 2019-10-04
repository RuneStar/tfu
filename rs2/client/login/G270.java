// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.login;

import tfu.Lx337;
import org.slf4j.LoggerFactory;
import tfu.Mf509;
import com.jagex.game.runetek6.event.EventHandler;
import java.io.IOException;
import tfu.Dp208;
import rs2.client.R146;
import rs2.client.client;
import tfu.Gg3;
import tfu.Ex582;
import tfu.El328;
import rs2.client.N272;
import tfu.Hx339;
import tfu.Lf336;
import org.slf4j.Logger;

public class G270 extends Y276
{
    private static final Logger logger;
    Q580 d;
    public long e;
    public long h;
    int j;
    int q;
    
    public void d(final float n) {
        if (this.d == null) {
            return;
        }
        G270.logger.info("Login step: {} - {} / {}", new Object[] { this.d, super.x, super.p });
        super.x += n;
        if (super.x > super.p) {
            q(this, E275.TIMEOUT);
        }
        while (this.d != null) {
            try {
                switch (D581.g[this.d.ordinal()]) {
                    case 1: {
                        super.v.q = Hx339.g(Lf336.q.g(), 15000);
                        N272.q(super.v);
                        final El328 q = El328.q();
                        Gg3.k(q.q, Ex582.INIT_SOCIAL_NETWORK_CONNECTION.w);
                        Gg3.i(q.q, 0);
                        final int v = q.q.v;
                        Gg3.a(q.q, 1);
                        Gg3.a(q.q, 1);
                        Gg3.k(q.q, (client.ac == 14) ? 1 : 0);
                        final Gg3 o = this.o();
                        Gg3.k(o, this.q);
                        Gg3.i(o, (int)(Math.random() * 9.9999999E7));
                        Gg3.k(o, client.n.getId());
                        Gg3.a(o, client.f);
                        for (int i = 0; i < 6; ++i) {
                            Gg3.a(o, (int)(Math.random() * 9.9999999E7));
                        }
                        Gg3.ag(o, client.bi);
                        Gg3.k(o, client.m.b);
                        Gg3.k(o, (int)(Math.random() * 9.9999999E7));
                        o.bt(R146.g, R146.d);
                        Gg3.aa(q.q, o.r, 0, o.v);
                        Gg3.as(q.q, q.q.v - v);
                        N272.e(super.v, q);
                        super.v.j();
                        this.d = Q580.WAIT_FOR_CONNECTION_ACK;
                        continue;
                    }
                    case 2: {
                        if (!super.v.q.d(1)) {
                            return;
                        }
                        super.v.q.j(super.v.b.r, 0, 1);
                        if ((super.v.b.r[0] & 0xFF) != 0x0) {
                            e(this, E275.CONNECT_FAIL);
                            return;
                        }
                        this.d = Q580.WAIT_FOR_SOCIAL_NETWORK_TOKEN_LENGTH;
                        continue;
                    }
                    case 3: {
                        if (!super.v.q.d(2)) {
                            return;
                        }
                        super.v.q.j(super.v.b.r, 0, 2);
                        super.v.b.v = 0;
                        super.v.b.v = Gg3.au(super.v.b);
                        this.d = Q580.WAIT_FOR_SOCIAL_NETWORK_TOKEN;
                        continue;
                    }
                    case 4: {
                        if (!super.v.q.d(super.v.b.v)) {
                            return;
                        }
                        super.v.q.j(super.v.b.r, 0, super.v.b.v);
                        Gg3.bb(super.v.b, super.u);
                        super.v.b.v = 0;
                        final String bh = super.v.b.bh();
                        super.v.b.v = 0;
                        Label_0726: {
                            if (!bh.startsWith("https://local.")) {
                                final String s = "opensn";
                                if (client.k) {
                                    if (Dp208.s(bh, 1, s)) {
                                        break Label_0726;
                                    }
                                }
                                try {
                                    Dp208.j(bh, true, false, s, client.ao, client.aa);
                                }
                                catch (Exception ex2) {
                                    e(this, E275.LOGIN_FAIL);
                                    return;
                                }
                            }
                        }
                        this.d = Q580.WAIT_FOR_SSO_KEY_RESPONSE;
                        continue;
                    }
                    case 5: {
                        if (!super.v.q.d(1)) {
                            return;
                        }
                        super.v.q.j(super.v.b.r, 0, 1);
                        if ((super.v.b.r[0] & 0xFF) == 0x1) {
                            this.d = Q580.WAIT_FOR_SSO_KEY;
                            continue;
                        }
                        continue;
                    }
                    case 6: {
                        if (!super.v.q.d(16)) {
                            return;
                        }
                        super.v.q.j(super.v.b.r, 0, 16);
                        super.v.b.v = 16;
                        Gg3.bb(super.v.b, super.u);
                        super.v.b.v = 0;
                        this.e = Gg3.bq(super.v.b);
                        this.h = Gg3.bq(super.v.b);
                        Y276.k(this, E275.SUCCESS);
                        this.d = null;
                        continue;
                    }
                }
            }
            catch (IOException ex) {
                G270.logger.error("", ex);
                q(this, E275.IOERROR);
            }
        }
    }
    
    public G270(final N272 n272, final int q, final EventHandler eventHandler) {
        super(n272, 5.0f, eventHandler);
        this.q = q;
        this.d = Q580.CONNECT;
    }
    
    private static void e(final G270 g270, final E275 e275) {
        j(g270, e275, null);
    }
    
    static {
        logger = LoggerFactory.getLogger(G270.class);
    }
    
    private static void q(final G270 g270, final E275 e275) {
        N272.s(g270.v);
        if (g270.z < 4) {
            Lx337.q(Lf336.q);
            g270.x = 0.0f;
            if (g270.d != Q580.CONNECT && g270.d != Q580.WAIT_FOR_CONNECTION_ACK && g270.d != Q580.WAIT_FOR_SOCIAL_NETWORK_TOKEN_LENGTH && g270.d != Q580.WAIT_FOR_SOCIAL_NETWORK_TOKEN) {
                g270.p = 120.0f;
            }
            else {
                g270.p = 40.0f;
            }
            ++g270.z;
            g270.d = Q580.CONNECT;
        }
        else {
            e(g270, e275);
        }
    }
    
    private static void j(final G270 g270, final E275 e275, final Mf509 mf509) {
        g270.d = null;
        N272.s(g270.v);
        g270.i(e275, mf509);
    }
}
