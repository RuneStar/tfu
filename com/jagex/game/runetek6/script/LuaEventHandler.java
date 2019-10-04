/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.script;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.Event;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.event.ScriptEventHandler;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.jnibindings.runetek6.LuaFunctionRef;
import com.jagex.jnibindings.runetek6.StateEventManager;
import java.util.HashMap;
import java.util.Map;
import tfu.Be2;
import tfu.Bs1;
import tfu.Jy122;

public class LuaEventHandler {
    private Map events = new HashMap();

    public EventHandler addEventHandler(String string, EventHandler eventHandler) {
        return this.addEventHandler(StringTools.l(string), eventHandler);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public EventHandler addEventHandler(ScriptManager scriptManager, @ScriptID Integer n, LuaFunctionRef luaFunctionRef) {
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        ScriptEventHandler scriptEventHandler = new ScriptEventHandler(scriptManager, luaFunctionRef, null);
        this.addEventHandler(n, (EventHandler)scriptEventHandler);
        return scriptEventHandler;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public EventHandler addEventHandlerArgs(ScriptManager scriptManager, @ScriptID Integer n, LuaFunctionRef luaFunctionRef, Object ... arrobject) {
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        ScriptEventHandler scriptEventHandler = new ScriptEventHandler(scriptManager, luaFunctionRef, arrobject);
        this.addEventHandler(n, (EventHandler)scriptEventHandler);
        return scriptEventHandler;
    }

    public void triggerEvent(Object object, String string, Object object2) {
        Jy122.h(ScriptManager.calltrace, "SCRIPTING EVENT: " + object + "." + string + "(" + object2 + ")");
        this.triggerEvent(object, StringTools.l(string), object2);
        Jy122.h(ScriptManager.calltrace, "END");
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public EventHandler addEventHandler(@ScriptID Integer n, EventHandler eventHandler) {
        Event event = (Event)this.events.get(n);
        if (event == null) {
            event = new Event();
            this.events.put(n, event);
        }
        event.add(eventHandler);
        ++ScriptManager.totalHandlersActive;
        return eventHandler;
    }

    public boolean hasEvent(String string) {
        return this.hasEvent(StringTools.l(string));
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void removeEventHandler(@ScriptID Integer n, EventHandler eventHandler) {
        Event event = (Event)this.events.get(n);
        if (event != null) {
            --ScriptManager.totalHandlersActive;
            event.remove(eventHandler);
        }
    }

    public void removeEventHandler(String string, EventHandler eventHandler) {
        this.removeEventHandler(StringTools.l(string), eventHandler);
    }

    public void triggerEvent(String string, Object object) {
        Jy122.h(ScriptManager.calltrace, "SCRIPTING EVENT: " + string + "(" + object + ")");
        this.triggerEvent(StringTools.l(string), object);
        StateEventManager.sendEvent(string);
        Jy122.l(ScriptManager.calltrace, "END");
    }

    public boolean hasEvent(int n) {
        return this.events.containsKey(n);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void triggerEvent(Object object, @ScriptID Integer n, Object object2) {
        Event event = (Event)this.events.get(n);
        if (event != null) {
            event.trigger(object, object2);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void triggerEvent(@ScriptID Integer n, Object object) {
        Event event = (Event)this.events.get(n);
        if (event != null) {
            event.trigger(null, object);
        }
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void removeAllEventHandlers(@ScriptID Integer n) {
        Event event = (Event)this.events.get(n);
        if (event != null) {
            ScriptManager.totalHandlersActive -= event.size();
        }
        this.events.remove(n);
    }
}

