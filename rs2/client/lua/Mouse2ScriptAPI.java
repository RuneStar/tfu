// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.lua;

import org.slf4j.LoggerFactory;
import rs2.client.client;
import com.jagex.core.stringtools.general.StringTools;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import org.slf4j.Logger;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("JavaMouse")
public class Mouse2ScriptAPI
{
    private static final Logger logger;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetDefaultCursor(final String s) {
    }
    
    private static int g(final String s) {
        final int l = StringTools.l(s);
        for (int i = 0; i < client.en.num; ++i) {
            if (client.en.list(i).hash32 == l) {
                return i;
            }
        }
        Mouse2ScriptAPI.logger.warn("Could not find a cursor called {}", s);
        return -1;
    }
    
    public static final native void initNativeMouse(final long p0);
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetCursor(final String s) {
        final int g = g(s);
        if (g != -1) {
            client.af(g);
        }
    }
    
    static {
        logger = LoggerFactory.getLogger(Mouse2ScriptAPI.class);
    }
}
