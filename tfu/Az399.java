/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.jnibindings.runetek6.LuaRef;
import com.jagex.jnibindings.runetek6.Scripting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Az399 {
    private static final Logger logger = LoggerFactory.getLogger(Az399.class);
    private final ScriptManager d;
    public String e;
    public String h;
    public int j;
    public Object q;
    public byte[] s;

    public static LuaRef g(Az399 az399, Object object) {
        try {
            return Scripting.deserialiseScriptMessage(az399.d.getScriptManagerNativeRef(), az399.d.getLuaStateNativeRef(), az399.e, az399.h, az399.s, object, object != null ? Scripting.getClassName(object) : "");
        }
        catch (Exception exception) {
            logger.error("", exception);
            return null;
        }
    }

    Az399(ScriptManager scriptManager) {
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        this.d = scriptManager;
    }

    public Az399(ScriptManager scriptManager, Object object, int n, String string, String string2, byte[] arrby) {
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        this.d = scriptManager;
        this.q = object;
        this.j = n;
        this.h = string2;
        this.e = string;
        this.s = arrby;
    }
}

