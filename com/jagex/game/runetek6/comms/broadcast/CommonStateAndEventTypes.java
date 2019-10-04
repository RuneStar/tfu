/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StateDefinition;

public class CommonStateAndEventTypes {
    public static BroadcastStateAndEventsTypes$StateDefinition entityConfigDef = null;
    public static BroadcastStateAndEventsTypes$EventDefinition propertyEventDef = null;

    public static void Init(boolean bl) {
        entityConfigDef = BroadcastStateAndEventsTypes.DeclareStateDefinition("entityconfig", null, 100);
        if (bl) {
            entityConfigDef.setAutoForwarding(true);
        }
        propertyEventDef = BroadcastStateAndEventsTypes.DeclareEventDefinition("property", null);
        if (bl) {
            propertyEventDef.setAutoForwarding(true);
        }
    }
}

