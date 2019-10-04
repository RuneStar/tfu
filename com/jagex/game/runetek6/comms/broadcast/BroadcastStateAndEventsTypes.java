// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.broadcast;

import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.event.EventHandler;
import java.util.HashMap;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("Broadcast")
public class BroadcastStateAndEventsTypes
{
    static HashMap known_message_declarations;
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static BroadcastStateAndEventsTypes$StateDefinition DeclareStateDefinition(final String key, final EventHandler eventHandler, final int n) {
        BroadcastStateAndEventsTypes$MessageDefinition value = BroadcastStateAndEventsTypes.known_message_declarations.get(key);
        if (value != null) {
            if (!(value instanceof BroadcastStateAndEventsTypes$StateDefinition)) {
                throw new RuntimeException("Message type '" + key + "' was previously declared, but not as a State definition (is " + key.getClass() + ")");
            }
            if (((BroadcastStateAndEventsTypes$StateDefinition)value).ordering != n) {
                throw new RuntimeException("State '" + key + "' was previously declared with a different priority (" + ((BroadcastStateAndEventsTypes$StateDefinition)value).ordering + ")");
            }
            if (((BroadcastStateAndEventsTypes$StateDefinition)value).validator != eventHandler) {
                throw new RuntimeException("State '" + key + "' was previously declared with a different validation callback");
            }
        }
        else {
            value = new BroadcastStateAndEventsTypes$StateDefinition(key, false, eventHandler, n);
            BroadcastStateAndEventsTypes.known_message_declarations.put(key, value);
        }
        return (BroadcastStateAndEventsTypes$StateDefinition)value;
    }
    
    static {
        BroadcastStateAndEventsTypes.known_message_declarations = new HashMap();
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static void SetAutoForwarding(final BroadcastStateAndEventsTypes$MessageDefinition broadcastStateAndEventsTypes$MessageDefinition, final boolean autoForwarding) {
        broadcastStateAndEventsTypes$MessageDefinition.setAutoForwarding(autoForwarding);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static BroadcastStateAndEventsTypes$EventDefinition DeclareEventDefinition(final String s, final EventHandler eventHandler) {
        BroadcastStateAndEventsTypes$MessageDefinition value = BroadcastStateAndEventsTypes.known_message_declarations.get(s);
        if (value != null) {
            if (!(value instanceof BroadcastStateAndEventsTypes$EventDefinition)) {
                throw new RuntimeException("Message type '" + s + "' was previously declared, but not as an Event definition (is " + s.getClass() + ")");
            }
            if (((BroadcastStateAndEventsTypes$EventDefinition)value).validator != eventHandler) {
                throw new RuntimeException("Event '" + s + "' was previously declared with a different validation callback");
            }
        }
        else {
            value = new BroadcastStateAndEventsTypes$EventDefinition(s, false, eventHandler);
            BroadcastStateAndEventsTypes.known_message_declarations.put(s, value);
        }
        return (BroadcastStateAndEventsTypes$EventDefinition)value;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static BroadcastStateAndEventsTypes$StateDefinition GetStateDefinition(final String str) {
        final BroadcastStateAndEventsTypes$MessageDefinition broadcastStateAndEventsTypes$MessageDefinition = BroadcastStateAndEventsTypes.known_message_declarations.get(str);
        if (broadcastStateAndEventsTypes$MessageDefinition instanceof BroadcastStateAndEventsTypes$StateDefinition) {
            return (BroadcastStateAndEventsTypes$StateDefinition)broadcastStateAndEventsTypes$MessageDefinition;
        }
        if (broadcastStateAndEventsTypes$MessageDefinition == null) {
            throw new RuntimeException("Message type '" + str + "' has not been declared.  It needs to be declared before use.");
        }
        throw new RuntimeException("Message type '" + str + "' has been declared, but not as a State definition (is " + str.getClass() + ")");
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public static BroadcastStateAndEventsTypes$EventDefinition GetEventDefinition(final String str) {
        final BroadcastStateAndEventsTypes$MessageDefinition broadcastStateAndEventsTypes$MessageDefinition = BroadcastStateAndEventsTypes.known_message_declarations.get(str);
        if (broadcastStateAndEventsTypes$MessageDefinition instanceof BroadcastStateAndEventsTypes$EventDefinition) {
            return (BroadcastStateAndEventsTypes$EventDefinition)broadcastStateAndEventsTypes$MessageDefinition;
        }
        if (broadcastStateAndEventsTypes$MessageDefinition == null) {
            throw new RuntimeException("Message type '" + str + " has not been declared.  It needs to be declared before use.");
        }
        throw new RuntimeException("Message type '" + str + "' has been declared, but not as an Event definition (is " + str.getClass() + ")");
    }
    
    public static BroadcastStateAndEventsTypes$StateDefinition getStateDefinition(final String key) {
        final BroadcastStateAndEventsTypes$MessageDefinition broadcastStateAndEventsTypes$MessageDefinition = BroadcastStateAndEventsTypes.known_message_declarations.get(key);
        if (broadcastStateAndEventsTypes$MessageDefinition instanceof BroadcastStateAndEventsTypes$StateDefinition) {
            return (BroadcastStateAndEventsTypes$StateDefinition)broadcastStateAndEventsTypes$MessageDefinition;
        }
        return null;
    }
    
    public static BroadcastStateAndEventsTypes$EventDefinition getEventDefinition(final String key) {
        final BroadcastStateAndEventsTypes$MessageDefinition broadcastStateAndEventsTypes$MessageDefinition = BroadcastStateAndEventsTypes.known_message_declarations.get(key);
        if (broadcastStateAndEventsTypes$MessageDefinition instanceof BroadcastStateAndEventsTypes$EventDefinition) {
            return (BroadcastStateAndEventsTypes$EventDefinition)broadcastStateAndEventsTypes$MessageDefinition;
        }
        return null;
    }
}
