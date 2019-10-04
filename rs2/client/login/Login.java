/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.login;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.N272;
import rs2.client.client;
import rs2.client.login.B271;
import rs2.client.login.E275;
import rs2.client.login.G270;
import rs2.client.login.R273;
import rs2.client.login.W274;
import rs2.client.login.Y276;
import tfu.Be2;
import tfu.Bs1;
import tfu.Gg3;

@ScriptEntryClass(value="LoginManager")
public final class Login {
    private static G270 d;
    private static final Logger logger;
    private static B271 q;

    static {
        logger = LoggerFactory.getLogger(Login.class);
    }

    public static void e() {
        d = null;
        q = null;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void requestLoginWithUsername(String string, String string2, EventHandler eventHandler) {
        if (!Login.s()) {
            logger.warn("Rejected duplicate login");
            return;
        }
        if (string.length() > 320) {
            return;
        }
        if (string2 == null || string2.length() < 1) {
            return;
        }
        q = new B271(client.fx, string, string2, eventHandler);
        client.z(6);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static boolean checkSSOKeyAvailable() {
        return client.ah != null;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void requestLoginFromSocialNetwork(int n, EventHandler eventHandler) {
        if (!Login.s()) {
            return;
        }
        d = new G270(client.fx, n, eventHandler);
        client.z(6);
    }

    public static void d() {
        logger.warn("Starting switch world login");
        q.q();
    }

    public static void q() {
        logger.warn("Starting reconnection login");
        q.g();
    }

    public static W274 j(float f) {
        if (d != null) {
            d.d(f);
            W274 w274 = d.h();
            if (w274 != null) {
                if (w274.g != E275.SUCCESS) {
                    return w274;
                }
                logger.debug("Attempting SN login for accountId '{}' with SN-SSO key '{}'", Login.d.e, (Object)Login.d.h);
                q = new B271(client.fx, Login.d.e, Login.d.h, false, Login.d.m);
                d = null;
            }
        }
        if (q != null) {
            q.d(f);
            return q.h();
        }
        return null;
    }

    public static void g() {
        logger.warn("Starting switch player login");
        q.j();
    }

    public static boolean h() {
        return d != null || q != null;
    }

    private static boolean s() {
        if (client.ac != 3) {
            return false;
        }
        return !Login.h();
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void requestLoginSSO(EventHandler eventHandler) {
        if (!Login.s()) {
            logger.warn("Rejected duplicate login");
            return;
        }
        if (client.ah == null) {
            logger.warn("No SSO Key");
            return;
        }
        Gg3 gg3 = client.ah.g();
        long l = Gg3.bq(gg3);
        long l2 = Gg3.bq(gg3);
        logger.debug("Attempting SSO login for accountId: '{}' key: '{}'.", l, (Object)l2);
        q = new B271(client.fx, l, l2, client.ah.d, eventHandler);
        client.z(6);
    }

    @ScriptEntryPoint
    @Deprecated
    @Be2
    @Bs1
    public static void requestLoginGame(String string, String string2) {
        Login.requestLoginWithUsername(string, string2, null);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void logout() {
        client.ap();
    }
}

