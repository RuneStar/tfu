package rs2.client.login;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.client;
import tfu.Be2;
import tfu.Bs1;
import tfu.Gg3;

@ScriptEntryClass("LoginManager")
public final class Login {
   private static G270 d;
   private static final Logger logger = LoggerFactory.getLogger(Login.class);
   private static B271 q;

   public static void e() {
      d = null;
      q = null;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void requestLoginWithUsername(String var0, String var1, EventHandler var2) {
      if (!s()) {
         logger.warn("Rejected duplicate login");
      } else if (var0.length() <= 320) {
         if (var1 != null && var1.length() >= 1) {
            q = new B271(client.fx, var0, var1, var2);
            client.z(6);
         }
      }
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
   public static void requestLoginFromSocialNetwork(int var0, EventHandler var1) {
      if (s()) {
         d = new G270(client.fx, var0, var1);
         client.z(6);
      }
   }

   public static void d() {
      logger.warn("Starting switch world login");
      q.q();
   }

   public static void q() {
      logger.warn("Starting reconnection login");
      q.g();
   }

   public static W274 j(float var0) {
      if (d != null) {
         d.d(var0);
         W274 var1 = d.h();
         if (var1 != null) {
            if (var1.g != E275.SUCCESS) {
               return var1;
            }

            logger.debug("Attempting SN login for accountId '{}' with SN-SSO key '{}'", d.e, d.h);
            q = new B271(client.fx, d.e, d.h, false, d.m);
            d = null;
         }
      }

      if (q != null) {
         q.d(var0);
         return q.h();
      } else {
         return null;
      }
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
      } else {
         return !h();
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void requestLoginSSO(EventHandler var0) {
      if (!s()) {
         logger.warn("Rejected duplicate login");
      } else if (client.ah == null) {
         logger.warn("No SSO Key");
      } else {
         Gg3 var1 = client.ah.g();
         long var2 = Gg3.bq(var1);
         long var4 = Gg3.bq(var1);
         logger.debug("Attempting SSO login for accountId: '{}' key: '{}'.", var2, var4);
         q = new B271(client.fx, var2, var4, client.ah.d, var0);
         client.z(6);
      }
   }

   /** @deprecated */
   @ScriptEntryPoint
   @Deprecated
   @Be2
   @Bs1
   public static void requestLoginGame(String var0, String var1) {
      requestLoginWithUsername(var0, var1, (EventHandler)null);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void logout() {
      client.ap();
   }
}
