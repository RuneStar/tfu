// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.event;

import org.slf4j.LoggerFactory;
import tfu.Jy122;
import tfu.Ao128;
import com.jagex.jnibindings.runetek6.Scripting;
import com.jagex.jnibindings.runetek6.LuaRef;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.jnibindings.runetek6.LuaFunctionRef;
import org.slf4j.Logger;

public class ScriptEventHandler extends EventHandler
{
    private static final Logger logger;
    private final Object[] arguments;
    private final LuaFunctionRef function;
    private final ScriptManager scriptManager;
    
    public ScriptEventHandler(final ScriptManager scriptManager, final LuaFunctionRef function, final Object[] arguments) {
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        if (function == null) {
            throw new IllegalArgumentException("Null Lua function reference.");
        }
        this.scriptManager = scriptManager;
        this.function = function;
        this.arguments = arguments;
        ++ScriptManager.totalHandlersCreated;
    }
    
    public void finalize() {
        ++ScriptManager.totalHandlersDestroyed;
    }
    
    public static ScriptEventHandler createScriptEventHandler(final ScriptManager scriptManager, final LuaFunctionRef luaFunctionRef, final Object[] array) {
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        if (luaFunctionRef == null) {
            throw new IllegalArgumentException("Null Lua function reference.");
        }
        if (!Scripting.checkLuaFunction(scriptManager.getScriptManagerNativeRef(), scriptManager.getLuaStateNativeRef(), LuaRef.g(luaFunctionRef))) {
            throw new RuntimeException(String.format("Lua function ref '%d' is undefined", LuaRef.g(luaFunctionRef)));
        }
        return new ScriptEventHandler(scriptManager, luaFunctionRef, array);
    }
    
    @Override
    public void trigger(final Object o, final Object o2) {
        if (this.scriptManager.getThread() != Thread.currentThread()) {
            final String string = "ScriptEventHandler.trigger() called from " + Thread.currentThread() + " - main thread is " + this.scriptManager.getThread();
            ScriptEventHandler.logger.error(string, new Ao128());
            throw new IllegalStateException(string);
        }
        if (this.function == null) {
            throw new RuntimeException("Cannot trigger event handler with no attached Lua function");
        }
        String string2 = "";
        ScriptEventHandler$Zones.TriggerScriptEvent.start();
        try {
            if (Jy122.g(ScriptManager.calltrace)) {
                Jy122.h(ScriptManager.calltrace, "J>L: calling handler " + this.function);
            }
            Object[] array = null;
            if (o2 != null) {
                final Class<?> class1 = o2.getClass();
                if (!class1.isArray()) {
                    array = new Object[] { o2 };
                }
                else {
                    if (class1.getComponentType().isPrimitive()) {
                        throw new RuntimeException("Cannot pass primitive arrays as payload.");
                    }
                    array = (Object[])o2;
                }
            }
            Scripting.callLuaFunction(this.scriptManager.getScriptManagerNativeRef(), this.scriptManager.getLuaStateNativeRef(), LuaRef.g(this.function), LuaFunctionRef.j(this.function), this.arguments, o, (o != null) ? Scripting.getClassName(o) : "", array, 0);
            ++ScriptManager.totalHandlersTriggered;
        }
        catch (Throwable obj) {
            ScriptEventHandler.logger.error("", obj);
            string2 = ": **EXCEPTION:** " + obj;
        }
        finally {
            try {
                if (Jy122.g(ScriptManager.calltrace)) {
                    Jy122.l(ScriptManager.calltrace, "END" + string2);
                }
            }
            catch (Exception ex) {
                ScriptEventHandler.logger.error("{}", ex);
            }
            ScriptEventHandler$Zones.TriggerScriptEvent.stop();
        }
    }
    
    static {
        logger = LoggerFactory.getLogger(ScriptEventHandler.class);
    }
}
