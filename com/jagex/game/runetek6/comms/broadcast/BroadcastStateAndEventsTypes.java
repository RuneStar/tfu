/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$MessageDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StateDefinition;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.util.HashMap;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass(value="Broadcast")
public class BroadcastStateAndEventsTypes {
    static HashMap known_message_declarations = new HashMap();

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static BroadcastStateAndEventsTypes$StateDefinition DeclareStateDefinition(String string, EventHandler eventHandler, int n) {
        BroadcastStateAndEventsTypes$MessageDefinition broadcastStateAndEventsTypes$MessageDefinition = (BroadcastStateAndEventsTypes$MessageDefinition)known_message_declarations.get(string);
        if (broadcastStateAndEventsTypes$MessageDefinition != null) {
            if (!(broadcastStateAndEventsTypes$MessageDefinition instanceof BroadcastStateAndEventsTypes$StateDefinition)) {
                throw new RuntimeException("Message type '" + string + "' was previously declared, but not as a State definition (is " + string.getClass() + ")");
            }
            if (((BroadcastStateAndEventsTypes$StateDefinition)broadcastStateAndEventsTypes$MessageDefinition).ordering != n) {
                throw new RuntimeException("State '" + string + "' was previously declared with a different priority (" + ((BroadcastStateAndEventsTypes$StateDefinition)broadcastStateAndEventsTypes$MessageDefinition).ordering + ")");
            }
            if (((BroadcastStateAndEventsTypes$StateDefinition)broadcastStateAndEventsTypes$MessageDefinition).validator != eventHandler) {
                throw new RuntimeException("State '" + string + "' was previously declared with a different validation callback");
            }
        } else {
            broadcastStateAndEventsTypes$MessageDefinition = new BroadcastStateAndEventsTypes$StateDefinition(string, false, eventHandler, n);
            known_message_declarations.put(string, broadcastStateAndEventsTypes$MessageDefinition);
        }
        return (BroadcastStateAndEventsTypes$StateDefinition)broadcastStateAndEventsTypes$MessageDefinition;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetAutoForwarding(BroadcastStateAndEventsTypes$MessageDefinition broadcastStateAndEventsTypes$MessageDefinition, boolean bl) {
        broadcastStateAndEventsTypes$MessageDefinition.setAutoForwarding(bl);
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static BroadcastStateAndEventsTypes$EventDefinition DeclareEventDefinition(String string, EventHandler eventHandler) {
        BroadcastStateAndEventsTypes$MessageDefinition broadcastStateAndEventsTypes$MessageDefinition = (BroadcastStateAndEventsTypes$MessageDefinition)known_message_declarations.get(string);
        if (broadcastStateAndEventsTypes$MessageDefinition != null) {
            if (!(broadcastStateAndEventsTypes$MessageDefinition instanceof BroadcastStateAndEventsTypes$EventDefinition)) {
                throw new RuntimeException("Message type '" + string + "' was previously declared, but not as an Event definition (is " + string.getClass() + ")");
            }
            if (((BroadcastStateAndEventsTypes$EventDefinition)broadcastStateAndEventsTypes$MessageDefinition).validator != eventHandler) {
                throw new RuntimeException("Event '" + string + "' was previously declared with a different validation callback");
            }
        } else {
            broadcastStateAndEventsTypes$MessageDefinition = new BroadcastStateAndEventsTypes$EventDefinition(string, false, eventHandler);
            known_message_declarations.put(string, broadcastStateAndEventsTypes$MessageDefinition);
        }
        return (BroadcastStateAndEventsTypes$EventDefinition)broadcastStateAndEventsTypes$MessageDefinition;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static BroadcastStateAndEventsTypes$StateDefinition GetStateDefinition(String string) {
        BroadcastStateAndEventsTypes$MessageDefinition broadcastStateAndEventsTypes$MessageDefinition = (BroadcastStateAndEventsTypes$MessageDefinition)known_message_declarations.get(string);
        if (broadcastStateAndEventsTypes$MessageDefinition instanceof BroadcastStateAndEventsTypes$StateDefinition) {
            return (BroadcastStateAndEventsTypes$StateDefinition)broadcastStateAndEventsTypes$MessageDefinition;
        }
        if (broadcastStateAndEventsTypes$MessageDefinition == null) {
            throw new RuntimeException("Message type '" + string + "' has not been declared.  It needs to be declared before use.");
        }
        throw new RuntimeException("Message type '" + string + "' has been declared, but not as a State definition (is " + string.getClass() + ")");
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public static BroadcastStateAndEventsTypes$EventDefinition GetEventDefinition(String string) {
        BroadcastStateAndEventsTypes$MessageDefinition broadcastStateAndEventsTypes$MessageDefinition = (BroadcastStateAndEventsTypes$MessageDefinition)known_message_declarations.get(string);
        if (broadcastStateAndEventsTypes$MessageDefinition instanceof BroadcastStateAndEventsTypes$EventDefinition) {
            return (BroadcastStateAndEventsTypes$EventDefinition)broadcastStateAndEventsTypes$MessageDefinition;
        }
        if (broadcastStateAndEventsTypes$MessageDefinition == null) {
            throw new RuntimeException("Message type '" + string + " has not been declared.  It needs to be declared before use.");
        }
        throw new RuntimeException("Message type '" + string + "' has been declared, but not as an Event definition (is " + string.getClass() + ")");
    }

    public static BroadcastStateAndEventsTypes$StateDefinition getStateDefinition(String string) {
        BroadcastStateAndEventsTypes$MessageDefinition broadcastStateAndEventsTypes$MessageDefinition = (BroadcastStateAndEventsTypes$MessageDefinition)known_message_declarations.get(string);
        if (broadcastStateAndEventsTypes$MessageDefinition instanceof BroadcastStateAndEventsTypes$StateDefinition) {
            return (BroadcastStateAndEventsTypes$StateDefinition)broadcastStateAndEventsTypes$MessageDefinition;
        }
        return null;
    }

    public static BroadcastStateAndEventsTypes$EventDefinition getEventDefinition(String string) {
        BroadcastStateAndEventsTypes$MessageDefinition broadcastStateAndEventsTypes$MessageDefinition = (BroadcastStateAndEventsTypes$MessageDefinition)known_message_declarations.get(string);
        if (broadcastStateAndEventsTypes$MessageDefinition instanceof BroadcastStateAndEventsTypes$EventDefinition) {
            return (BroadcastStateAndEventsTypes$EventDefinition)broadcastStateAndEventsTypes$MessageDefinition;
        }
        return null;
    }
}

