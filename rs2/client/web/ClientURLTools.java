package rs2.client.web;

import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.client;
import tfu.Be2;
import tfu.Dp208;
import tfu.Mu209;

@ScriptEntryClass
public class ClientURLTools {
   private static final Logger logger = LoggerFactory.getLogger(ClientURLTools.class);

   @ScriptEntryPoint
   @Be2
   public static void openURLModule(String var0, String var1, @ScriptDefaults(defaultBoolean = true) boolean var2) {
      g(var0, var1, var2);
   }

   private static void g(String var0, String var1, boolean var2) {
      if (var1 != null) {
         StringBuilder var3 = new StringBuilder();
         var3.append("?dest=");
         var3.append(var1);
         if (var0 != null) {
            var3.append("&mod=");
            var3.append(var0);
         }

         StringBuilder var4 = new StringBuilder();
         var4.append("redirect.ws");
         var4.append(var3);
         if (var2) {
            Dp208.d(client.bu.getCodeBase() + var4.toString(), var2, client.ao);
         } else {
            client var5 = client.bu;

            try {
               Mu209.g(var5, "loggedout");
            } catch (Throwable var8) {
            }

            try {
               var5.getAppletContext().showDocument(new URL(var5.getCodeBase(), var4.toString()), "_top");
            } catch (Exception var7) {
               logger.error("", var7);
            }
         }

      }
   }

   @ScriptEntryPoint
   @Be2
   public static void openURL(String var0, @ScriptDefaults(defaultBoolean = true) boolean var1) {
      g((String)null, var0, var1);
   }
}
