// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.lua;

import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import java.util.LinkedList;
import org.slf4j.LoggerFactory;
import java.util.Iterator;
import tfu.Gs329;
import rs2.shared.lua.G284;
import tfu.El328;
import tfu.Eu326;
import tfu.Lb33;
import rs2.client.N272;
import rs2.client.client;
import tfu.Az399;
import tfu.Gg3;
import tfu.Ah536;
import org.slf4j.Logger;
import java.util.List;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("ScriptMessaging")
public final class ClientScriptMessaging
{
    private static boolean d;
    public static List j;
    private static final Logger logger;
    private static Ah536 q;
    
    public static Az399 q(final Gg3 gg3) {
        return ClientScriptMessaging.q.q(gg3, client.cj);
    }
    
    public static void d(final N272 n272) {
        Lb33.g(Lb33.SendScriptMessages);
        try {
            while (!ClientScriptMessaging.j.isEmpty()) {
                final El328 d = El328.d(Eu326.SCRIPT_MESSAGE, n272.s);
                Gg3.i(d.q, 0);
                final int v = d.q.v;
                final Gs329 q = d.q;
                q.v += 2;
                final Iterator iterator = ClientScriptMessaging.j.iterator();
                int n273 = 0;
                while (iterator.hasNext()) {
                    final Az399 az399 = iterator.next();
                    final int d2 = Ah536.d(ClientScriptMessaging.q, az399);
                    G284.g(client.ls, d2);
                    if (6 + d2 > 1350) {
                        ClientScriptMessaging.logger.error("Dropping script message of type " + az399.e + ":" + az399.h + " and size " + d2 + " as it too long for buffer!");
                        iterator.remove();
                    }
                    else {
                        if (2 + d.q.v + d2 > 1350) {
                            break;
                        }
                        ClientScriptMessaging.q.g(az399, d.q, ClientScriptMessaging.d);
                        iterator.remove();
                        ++n273;
                    }
                }
                final int v2 = d.q.v;
                d.q.v = v;
                Gg3.i(d.q, n273);
                d.q.v = v2;
                Gg3.as(d.q, d.q.v - v);
                N272.e(n272, d);
            }
        }
        finally {
            Lb33.d(Lb33.SendScriptMessages);
        }
    }
    
    static {
        logger = LoggerFactory.getLogger(ClientScriptMessaging.class);
        ClientScriptMessaging.j = new LinkedList();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void Send(final Object o, @ScriptID final Integer n, final String s, final String s2, final byte[] array) {
        ClientScriptMessaging.j.add(new Az399(client.cj, o, n, s2, s, array));
    }
    
    public static void g(final List list, final boolean d) {
        ClientScriptMessaging.q = new Ah536(list);
        ClientScriptMessaging.d = d;
    }
}
