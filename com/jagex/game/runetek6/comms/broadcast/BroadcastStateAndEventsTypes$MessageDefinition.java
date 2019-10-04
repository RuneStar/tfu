// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.event.EventHandler;

public class BroadcastStateAndEventsTypes$MessageDefinition
{
    protected boolean autoForward;
    public final String messageName;
    protected final EventHandler validator;
    
    public boolean getAutoForwarding() {
        return this.autoForward;
    }
    
    @Override
    public int hashCode() {
        return this.messageName.hashCode();
    }
    
    @Override
    public boolean equals(final Object o) {
        return this.messageName.equals(((BroadcastStateAndEventsTypes$MessageDefinition)o).messageName);
    }
    
    public void setAutoForwarding(final boolean autoForward) {
        this.autoForward = autoForward;
    }
    
    @Override
    public String toString() {
        return "(" + this.messageName + ")";
    }
    
    public BroadcastStateAndEventsTypes$MessageDefinition(final String messageName, final boolean autoForward, final EventHandler validator) {
        this.messageName = messageName;
        this.validator = validator;
        this.autoForward = autoForward;
    }
}
