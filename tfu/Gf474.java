/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.jnibindings.runetek6.StateEventManager;
import rs2.client.N272;
import rs2.client.client;
import tfu.El328;
import tfu.Eu326;
import tfu.Gg3;
import tfu.Gs329;
import tfu.Ic327;
import tfu.J153;
import tfu.Q475;

public class Gf474
extends J153 {
    public static void w() {
        if (Gf474.d()) {
            Gf474.r();
        }
    }

    private static void r() {
        int n = 2;
        Q475 q475 = new Q475();
        while ((n = Gf474.q(n, q475)) != 0) {
            El328 el328 = El328.d(Eu326.STATEEVENT_EVENTSBUFFER, client.fx.s);
            Gs329.an(el328.q, q475.d);
            N272.e(client.fx, el328);
        }
        StateEventManager.resetOutEventsBuffer();
    }

    public static void v(Gs329 gs329) {
        Gf474.j(gs329);
    }
}

