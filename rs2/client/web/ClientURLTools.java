/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.web;

import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.applet.AppletContext;
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
    public static void openURLModule(String string, String string2, @ScriptDefaults(defaultBoolean=true) boolean bl) {
        ClientURLTools.g(string, string2, bl);
    }

    private static void g(String string, String string2, boolean bl) {
        if (string2 == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("?dest=");
        stringBuilder.append(string2);
        if (string != null) {
            stringBuilder.append("&mod=");
            stringBuilder.append(string);
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("redirect.ws");
        stringBuilder2.append(stringBuilder);
        if (bl) {
            Dp208.d(client.bu.getCodeBase() + stringBuilder2.toString(), bl, client.ao);
        } else {
            client client2 = client.bu;
            try {
                Mu209.g(client2, "loggedout");
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            try {
                client2.getAppletContext().showDocument(new URL(client2.getCodeBase(), stringBuilder2.toString()), "_top");
            }
            catch (Exception exception) {
                logger.error("", exception);
            }
        }
    }

    @ScriptEntryPoint
    @Be2
    public static void openURL(String string, @ScriptDefaults(defaultBoolean=true) boolean bl) {
        ClientURLTools.g(null, string, bl);
    }
}

