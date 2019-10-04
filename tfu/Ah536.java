// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.game.runetek6.script.ScriptManager;
import java.util.Iterator;
import com.jagex.game.runetek6.script.resource.proto.ProtocolBufferDefinition;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public final class Ah536
{
    private final Map d;
    private final HashMap g;
    
    public Ah536(final List list) {
        this.g = new HashMap();
        this.d = new HashMap();
        for (final ProtocolBufferDefinition protocolBufferDefinition : list) {
            for (final Js343 js343 : protocolBufferDefinition.messageProtocolIds) {
                this.g.put(new Av542(this, protocolBufferDefinition.name, (String)js343.d), js343.q);
                this.d.put(js343.q, new Js343(protocolBufferDefinition.name, js343.d));
            }
        }
    }
    
    public static int d(final Ah536 ah536, final Az399 az399) {
        return 5 + Gg3.av(az399.h) + Gg3.av(az399.e) + 2 + az399.s.length;
    }
    
    public final Az399 q(final Gg3 gg3, final ScriptManager scriptManager) {
        final Az399 az399 = new Az399(scriptManager);
        Gg3.ar(gg3);
        az399.q = null;
        az399.j = Gg3.bd(gg3);
        switch (Gg3.ar(gg3)) {
            case 0: {
                final Js343 js343 = this.d.get(Gg3.bd(gg3));
                az399.e = (String)js343.d;
                az399.h = (String)js343.q;
                break;
            }
            case 1: {
                az399.e = gg3.bh();
                az399.h = gg3.bh();
                break;
            }
            default: {
                throw new IllegalStateException();
            }
        }
        final int au = Gg3.au(gg3);
        Gg3.bx(gg3, az399.s = new byte[au], 0, au);
        return az399;
    }
    
    public final void g(final Az399 az399, final Gg3 gg3, boolean b) {
        Gg3.k(gg3, 0);
        Gg3.a(gg3, az399.j);
        if (b) {
            final Integer n = this.g.get(new Av542(this, az399.e, az399.h));
            if (n == null) {
                b = false;
            }
            else {
                Gg3.k(gg3, 0);
                Gg3.a(gg3, n);
            }
        }
        if (!b) {
            Gg3.k(gg3, 1);
            gg3.ap(az399.e);
            gg3.ap(az399.h);
        }
        Gg3.i(gg3, az399.s.length);
        Gg3.aa(gg3, az399.s, 0, az399.s.length);
    }
}
