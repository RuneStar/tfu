/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.lua;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import com.jagex.game.runetek6.script.ScriptManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.N272;
import rs2.client.client;
import rs2.shared.lua.G284;
import tfu.Ah536;
import tfu.Az399;
import tfu.Be2;
import tfu.Bs1;
import tfu.El328;
import tfu.Eu326;
import tfu.Gg3;
import tfu.Gs329;
import tfu.Ic327;
import tfu.Lb33;

@ScriptEntryClass(value="ScriptMessaging")
public final class ClientScriptMessaging {
    private static boolean d;
    public static List j;
    private static final Logger logger;
    private static Ah536 q;

    public static Az399 q(Gg3 gg3) {
        return q.q(gg3, client.cj);
    }

    public static void d(N272 n272) {
        Lb33.g(Lb33.SendScriptMessages);
        try {
            while (!j.isEmpty()) {
                El328 el328 = El328.d(Eu326.SCRIPT_MESSAGE, n272.s);
                Gs329.i(el328.q, 0);
                int n = el328.q.v;
                el328.q.v += 2;
                Iterator iterator = j.iterator();
                int n2 = 0;
                while (iterator.hasNext()) {
                    Az399 az399 = (Az399)iterator.next();
                    int n3 = Ah536.d(q, az399);
                    G284.g(client.ls, n3);
                    if (6 + n3 > 1350) {
                        logger.error("Dropping script message of type " + az399.e + ":" + az399.h + " and size " + n3 + " as it too long for buffer!");
                        iterator.remove();
                        continue;
                    }
                    if (2 + el328.q.v + n3 > 1350) break;
                    q.g(az399, el328.q, d);
                    iterator.remove();
                    ++n2;
                }
                int n4 = el328.q.v;
                el328.q.v = n;
                Gs329.i(el328.q, n2);
                el328.q.v = n4;
                Gs329.as(el328.q, el328.q.v - n);
                N272.e(n272, el328);
            }
            Lb33.d(Lb33.SendScriptMessages);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.SendScriptMessages);
            throw throwable;
        }
    }

    static {
        logger = LoggerFactory.getLogger(ClientScriptMessaging.class);
        j = new LinkedList();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void Send(Object object, @ScriptID Integer n, String string, String string2, byte[] arrby) {
        j.add(new Az399(client.cj, object, n, string2, string, arrby));
    }

    public static void g(List list, boolean bl) {
        q = new Ah536(list);
        d = bl;
    }
}

