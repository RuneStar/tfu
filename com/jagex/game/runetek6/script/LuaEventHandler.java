// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.script;

import com.jagex.jnibindings.runetek6.StateEventManager;
import java.util.HashMap;
import com.jagex.game.runetek6.event.Event;
import tfu.Jy122;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.event.ScriptEventHandler;
import com.jagex.jnibindings.runetek6.LuaFunctionRef;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.EventHandler;
import java.util.Map;

public class LuaEventHandler
{
    private Map events;
    
    public EventHandler addEventHandler(final String s, final EventHandler eventHandler) {
        return this.addEventHandler(StringTools.l(s), eventHandler);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public EventHandler addEventHandler(final ScriptManager scriptManager, @ScriptID final Integer n, final LuaFunctionRef luaFunctionRef) {
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        final ScriptEventHandler scriptEventHandler = new ScriptEventHandler(scriptManager, luaFunctionRef, null);
        this.addEventHandler(n, scriptEventHandler);
        return scriptEventHandler;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public EventHandler addEventHandlerArgs(final ScriptManager scriptManager, @ScriptID final Integer n, final LuaFunctionRef luaFunctionRef, final Object... array) {
        if (scriptManager == null) {
            throw new IllegalArgumentException("Null ScriptManager instance.");
        }
        final ScriptEventHandler scriptEventHandler = new ScriptEventHandler(scriptManager, luaFunctionRef, array);
        this.addEventHandler(n, scriptEventHandler);
        return scriptEventHandler;
    }
    
    public void triggerEvent(final Object obj, final String str, final Object obj2) {
        Jy122.h(ScriptManager.calltrace, "SCRIPTING EVENT: " + obj + "." + str + "(" + obj2 + ")");
        this.triggerEvent(obj, StringTools.l(str), obj2);
        Jy122.h(ScriptManager.calltrace, "END");
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public EventHandler addEventHandler(@ScriptID final Integer n, final EventHandler eventHandler) {
        Event event = this.events.get(n);
        if (event == null) {
            event = new Event();
            this.events.put(n, event);
        }
        event.add(eventHandler);
        ++ScriptManager.totalHandlersActive;
        return eventHandler;
    }
    
    public boolean hasEvent(final String s) {
        return this.hasEvent(StringTools.l(s));
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void removeEventHandler(@ScriptID final Integer n, final EventHandler o) {
        final Event event = this.events.get(n);
        if (event != null) {
            --ScriptManager.totalHandlersActive;
            event.remove(o);
        }
    }
    
    public LuaEventHandler() {
        this.events = new HashMap();
    }
    
    public void removeEventHandler(final String s, final EventHandler eventHandler) {
        this.removeEventHandler(StringTools.l(s), eventHandler);
    }
    
    public void triggerEvent(final String str, final Object obj) {
        Jy122.h(ScriptManager.calltrace, "SCRIPTING EVENT: " + str + "(" + obj + ")");
        this.triggerEvent(StringTools.l(str), obj);
        StateEventManager.sendEvent(str);
        Jy122.l(ScriptManager.calltrace, "END");
    }
    
    public boolean hasEvent(final int i) {
        return this.events.containsKey(i);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void triggerEvent(final Object o, @ScriptID final Integer n, final Object o2) {
        final Event event = this.events.get(n);
        if (event != null) {
            event.trigger(o, o2);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void triggerEvent(@ScriptID final Integer n, final Object o) {
        final Event event = this.events.get(n);
        if (event != null) {
            event.trigger(null, o);
        }
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void removeAllEventHandlers(@ScriptID final Integer n) {
        final Event event = this.events.get(n);
        if (event != null) {
            ScriptManager.totalHandlersActive -= event.size();
        }
        this.events.remove(n);
    }
}
