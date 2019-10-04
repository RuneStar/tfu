// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.event;

import com.jagex.game.runetek6.script.ScriptEntryPoint;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptID;

public interface EventForwarder
{
    @Be2
    @Bs1
    void triggerEvent(@ScriptID final Integer p0, final Object p1);
    
    @Be2
    @Bs1
    void removeAllEventHandlers(@ScriptID final Integer p0);
    
    @Be2
    @Bs1
    void removeEventHandler(final String p0, final EventHandler p1);
    
    @Be2
    @Bs1
    void addEventHandlerByID(@ScriptID final Integer p0, final EventHandler p1);
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    void addEventHandler(final String p0, final EventHandler p1);
}
