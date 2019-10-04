/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.event;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.event.ScriptEventHandler$Zones;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.jnibindings.runetek6.LuaFunctionRef;
import com.jagex.jnibindings.runetek6.Scripting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ao128;
import tfu.Jy122;

public class ScriptEventHandler
extends EventHandler {
    private static final Logger logger = LoggerFactory.getLogger(ScriptEventHandler.class);
    private final Object[] arguments;
    private final LuaFunctionRef function;
    private final ScriptManager scriptManager;

    public ScriptEventHandler(ScriptManager scriptManager, LuaFunctionRef luaFunctionRef, Object[] arrobject) {
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        if (luaFunctionRef == null) {
            throw new IllegalArgumentException("Null Lua function reference.");
        }
        this.scriptManager = scriptManager;
        this.function = luaFunctionRef;
        this.arguments = arrobject;
        ++ScriptManager.totalHandlersCreated;
    }

    public void finalize() {
        ++ScriptManager.totalHandlersDestroyed;
    }

    public static ScriptEventHandler createScriptEventHandler(ScriptManager scriptManager, LuaFunctionRef luaFunctionRef, Object[] arrobject) {
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        if (luaFunctionRef == null) {
            throw new IllegalArgumentException("Null Lua function reference.");
        }
        if (!Scripting.checkLuaFunction(scriptManager.getScriptManagerNativeRef(), scriptManager.getLuaStateNativeRef(), LuaFunctionRef.g(luaFunctionRef))) {
            throw new RuntimeException(String.format("Lua function ref '%d' is undefined", LuaFunctionRef.g(luaFunctionRef)));
        }
        ScriptEventHandler scriptEventHandler = new ScriptEventHandler(scriptManager, luaFunctionRef, arrobject);
        return scriptEventHandler;
    }

    @Override
    public void trigger(Object object, Object object2) {
        if (this.scriptManager.getThread() != Thread.currentThread()) {
            String string = "ScriptEventHandler.trigger() called from " + Thread.currentThread() + " - main thread is " + this.scriptManager.getThread();
            logger.error(string, new Ao128());
            throw new IllegalStateException(string);
        }
        if (this.function == null) {
            throw new RuntimeException("Cannot trigger event handler with no attached Lua function");
        }
        String string = "";
        ScriptEventHandler$Zones.TriggerScriptEvent.start();
        try {
            try {
                if (Jy122.g(ScriptManager.calltrace)) {
                    Jy122.h(ScriptManager.calltrace, "J>L: calling handler " + this.function);
                }
                Object[] arrobject = null;
                if (object2 != null) {
                    Class<?> class_ = object2.getClass();
                    if (!class_.isArray()) {
                        arrobject = new Object[]{object2};
                    } else {
                        if (class_.getComponentType().isPrimitive()) {
                            throw new RuntimeException("Cannot pass primitive arrays as payload.");
                        }
                        arrobject = (Object[])object2;
                    }
                }
                Scripting.callLuaFunction(this.scriptManager.getScriptManagerNativeRef(), this.scriptManager.getLuaStateNativeRef(), LuaFunctionRef.g(this.function), LuaFunctionRef.j(this.function), this.arguments, object, object != null ? Scripting.getClassName(object) : "", arrobject, 0);
                ++ScriptManager.totalHandlersTriggered;
            }
            catch (Throwable throwable) {
                logger.error("", throwable);
                string = ": **EXCEPTION:** " + throwable;
                try {
                    if (Jy122.g(ScriptManager.calltrace)) {
                        Jy122.l(ScriptManager.calltrace, "END" + string);
                    }
                }
                catch (Exception exception) {
                    logger.error("{}", exception);
                }
                ScriptEventHandler$Zones.TriggerScriptEvent.stop();
            }
            try {
                if (Jy122.g(ScriptManager.calltrace)) {
                    Jy122.l(ScriptManager.calltrace, "END" + string);
                }
            }
            catch (Exception exception) {
                logger.error("{}", exception);
            }
            ScriptEventHandler$Zones.TriggerScriptEvent.stop();
        }
        catch (Throwable throwable) {
            try {
                if (Jy122.g(ScriptManager.calltrace)) {
                    Jy122.l(ScriptManager.calltrace, "END" + string);
                }
            }
            catch (Exception exception) {
                logger.error("{}", exception);
            }
            ScriptEventHandler$Zones.TriggerScriptEvent.stop();
            throw throwable;
        }
    }
}

