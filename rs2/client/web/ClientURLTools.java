// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.web;

import java.net.URL;
import java.applet.Applet;
import tfu.Mu209;
import tfu.Dp208;
import rs2.client.client;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptDefaults;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass
public class ClientURLTools
{
    private static final Logger logger;
    
    static {
        logger = LoggerFactory.getLogger(ClientURLTools.class);
    }
    
    @ScriptEntryPoint
    @Be2
    public static void openURLModule(final String s, final String s2, @ScriptDefaults(defaultBoolean = true) final boolean b) {
        g(s, s2, b);
    }
    
    private static void g(final String str, final String str2, final boolean b) {
        if (str2 == null) {
            return;
        }
        final StringBuilder s = new StringBuilder();
        s.append("?dest=");
        s.append(str2);
        if (str != null) {
            s.append("&mod=");
            s.append(str);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("redirect.ws");
        sb.append((CharSequence)s);
        if (b) {
            Dp208.d(client.bu.getCodeBase() + sb.toString(), b, client.ao);
        }
        else {
            final client bu = client.bu;
            try {
                Mu209.g(bu, "loggedout");
            }
            catch (Throwable t) {}
            try {
                bu.getAppletContext().showDocument(new URL(bu.getCodeBase(), sb.toString()), "_top");
            }
            catch (Exception ex) {
                ClientURLTools.logger.error("", ex);
            }
        }
    }
    
    @ScriptEntryPoint
    @Be2
    public static void openURL(final String s, @ScriptDefaults(defaultBoolean = true) final boolean b) {
        g(null, s, b);
    }
}
