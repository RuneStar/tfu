// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.jnibindings.runetek6.StateEventManager;
import rs2.client.N272;
import rs2.client.client;

public class Gf474 extends J153
{
    public static void w() {
        if (d()) {
            r();
        }
    }
    
    private static void r() {
        int q = 2;
        final Q475 q2 = new Q475();
        while ((q = J153.q(q, q2)) != 0) {
            final El328 d = El328.d(Eu326.STATEEVENT_EVENTSBUFFER, client.fx.s);
            Gg3.an(d.q, q2.d);
            N272.e(client.fx, d);
        }
        StateEventManager.resetOutEventsBuffer();
    }
    
    public static void v(final Gs329 gs329) {
        J153.j(gs329);
    }
}
