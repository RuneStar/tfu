/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.game.runetek6.script.resource.proto.ProtocolBufferDefinition;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tfu.Av542;
import tfu.Az399;
import tfu.Gg3;
import tfu.Js343;

public final class Ah536 {
    private final Map d;
    private final HashMap g = new HashMap();

    public Ah536(List list) {
        this.d = new HashMap();
        for (ProtocolBufferDefinition protocolBufferDefinition : list) {
            for (Js343 js343 : protocolBufferDefinition.messageProtocolIds) {
                this.g.put(new Av542(this, protocolBufferDefinition.name, (String)js343.d), js343.q);
                this.d.put(js343.q, new Js343(protocolBufferDefinition.name, js343.d));
            }
        }
    }

    public static int d(Ah536 ah536, Az399 az399) {
        return 5 + Gg3.av(az399.h) + Gg3.av(az399.e) + 2 + az399.s.length;
    }

    public final Az399 q(Gg3 gg3, ScriptManager scriptManager) {
        int n;
        Az399 az399 = new Az399(scriptManager);
        int n2 = Gg3.ar(gg3);
        az399.q = null;
        az399.j = Gg3.bd(gg3);
        switch (Gg3.ar(gg3)) {
            case 0: {
                n = Gg3.bd(gg3);
                Js343 js343 = (Js343)this.d.get(n);
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
        n = Gg3.au(gg3);
        az399.s = new byte[n];
        Gg3.bx(gg3, az399.s, 0, n);
        return az399;
    }

    public final void g(Az399 az399, Gg3 gg3, boolean bl) {
        Gg3.k(gg3, 0);
        Gg3.a(gg3, az399.j);
        if (bl) {
            Integer n = (Integer)this.g.get(new Av542(this, az399.e, az399.h));
            if (n == null) {
                bl = false;
            } else {
                Gg3.k(gg3, 0);
                Gg3.a(gg3, n);
            }
        }
        if (!bl) {
            Gg3.k(gg3, 1);
            gg3.ap(az399.e);
            gg3.ap(az399.h);
        }
        Gg3.i(gg3, az399.s.length);
        Gg3.aa(gg3, az399.s, 0, az399.s.length);
    }
}

