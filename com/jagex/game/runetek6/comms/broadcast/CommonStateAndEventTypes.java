// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.event.EventHandler;

public class CommonStateAndEventTypes
{
    public static BroadcastStateAndEventsTypes$StateDefinition entityConfigDef;
    public static BroadcastStateAndEventsTypes$EventDefinition propertyEventDef;
    
    public static void Init(final boolean b) {
        CommonStateAndEventTypes.entityConfigDef = BroadcastStateAndEventsTypes.DeclareStateDefinition("entityconfig", null, 100);
        if (b) {
            CommonStateAndEventTypes.entityConfigDef.setAutoForwarding(true);
        }
        CommonStateAndEventTypes.propertyEventDef = BroadcastStateAndEventsTypes.DeclareEventDefinition("property", null);
        if (b) {
            CommonStateAndEventTypes.propertyEventDef.setAutoForwarding(true);
        }
    }
    
    static {
        CommonStateAndEventTypes.entityConfigDef = null;
        CommonStateAndEventTypes.propertyEventDef = null;
    }
}
