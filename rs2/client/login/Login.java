// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.login;

import tfu.Gg3;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import rs2.client.client;
import com.jagex.game.runetek6.event.EventHandler;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("LoginManager")
public final class Login
{
    private static G270 d;
    private static final Logger logger;
    private static B271 q;
    
    static {
        logger = LoggerFactory.getLogger(Login.class);
    }
    
    public static void e() {
        Login.d = null;
        Login.q = null;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void requestLoginWithUsername(final String s, final String s2, final EventHandler eventHandler) {
        if (!s()) {
            Login.logger.warn("Rejected duplicate login");
            return;
        }
        if (s.length() > 320) {
            return;
        }
        if (s2 == null || s2.length() < 1) {
            return;
        }
        Login.q = new B271(client.fx, s, s2, eventHandler);
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
    public static void requestLoginFromSocialNetwork(final int n, final EventHandler eventHandler) {
        if (!s()) {
            return;
        }
        Login.d = new G270(client.fx, n, eventHandler);
        client.z(6);
    }
    
    public static void d() {
        Login.logger.warn("Starting switch world login");
        Login.q.q();
    }
    
    public static void q() {
        Login.logger.warn("Starting reconnection login");
        Login.q.g();
    }
    
    public static W274 j(final float n) {
        if (Login.d != null) {
            Login.d.d(n);
            final W274 h = Login.d.h();
            if (h != null) {
                if (h.g != E275.SUCCESS) {
                    return h;
                }
                Login.logger.debug("Attempting SN login for accountId '{}' with SN-SSO key '{}'", Login.d.e, Login.d.h);
                Login.q = new B271(client.fx, Login.d.e, Login.d.h, false, Login.d.m);
                Login.d = null;
            }
        }
        if (Login.q != null) {
            Login.q.d(n);
            return Login.q.h();
        }
        return null;
    }
    
    public static void g() {
        Login.logger.warn("Starting switch player login");
        Login.q.j();
    }
    
    public static boolean h() {
        return Login.d != null || Login.q != null;
    }
    
    private static boolean s() {
        return client.ac == 3 && !h();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void requestLoginSSO(final EventHandler eventHandler) {
        if (!s()) {
            Login.logger.warn("Rejected duplicate login");
            return;
        }
        if (client.ah == null) {
            Login.logger.warn("No SSO Key");
            return;
        }
        final Gg3 g = client.ah.g();
        final long bq = Gg3.bq(g);
        final long bq2 = Gg3.bq(g);
        Login.logger.debug("Attempting SSO login for accountId: '{}' key: '{}'.", bq, bq2);
        Login.q = new B271(client.fx, bq, bq2, client.ah.d, eventHandler);
        client.z(6);
    }
    
    @ScriptEntryPoint
    @Deprecated
    @Be2
    @Bs1
    public static void requestLoginGame(final String s, final String s2) {
        requestLoginWithUsername(s, s2, null);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void logout() {
        client.ap();
    }
}
