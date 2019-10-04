// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.jnibindings.runetek6.Scripting;
import com.jagex.jnibindings.runetek6.LuaRef;
import org.slf4j.LoggerFactory;
import com.jagex.game.runetek6.script.ScriptManager;
import org.slf4j.Logger;

public class Az399
{
    private static final Logger logger;
    private final ScriptManager d;
    public String e;
    public String h;
    public int j;
    public Object q;
    public byte[] s;
    
    static {
        logger = LoggerFactory.getLogger(Az399.class);
    }
    
    public static LuaRef g(final Az399 az399, final Object o) {
        try {
            return Scripting.deserialiseScriptMessage(az399.d.getScriptManagerNativeRef(), az399.d.getLuaStateNativeRef(), az399.e, az399.h, az399.s, o, (o != null) ? Scripting.getClassName(o) : "");
        }
        catch (Exception ex) {
            Az399.logger.error("", ex);
            return null;
        }
    }
    
    Az399(final ScriptManager d) {
        if (d == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        this.d = d;
    }
    
    public Az399(final ScriptManager d, final Object q, final int j, final String e, final String h, final byte[] s) {
        if (d == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        this.d = d;
        this.q = q;
        this.j = j;
        this.h = h;
        this.e = e;
        this.s = s;
    }
}
