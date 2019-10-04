/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.lua;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.config.cursortype.CursorType;
import com.jagex.game.runetek6.config.cursortype.CursorTypeList;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.client;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass(value="JavaMouse")
public class Mouse2ScriptAPI {
    private static final Logger logger = LoggerFactory.getLogger(Mouse2ScriptAPI.class);

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetDefaultCursor(String string) {
    }

    private static int g(String string) {
        int n = StringTools.l(string);
        for (int i = 0; i < client.en.num; ++i) {
            CursorType cursorType = client.en.list(i);
            if (cursorType.hash32 != n) continue;
            return i;
        }
        logger.warn("Could not find a cursor called {}", (Object)string);
        return -1;
    }

    public static final native void initNativeMouse(long var0);

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetCursor(String string) {
        int n = Mouse2ScriptAPI.g(string);
        if (n != -1) {
            client.af(n);
        }
    }
}

