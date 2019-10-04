// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.event.EventHandler;

public class BroadcastStateAndEventsTypes$StateDefinition extends BroadcastStateAndEventsTypes$MessageDefinition implements Comparable
{
    public int ordering;
    
    @Override
    public boolean equals(final Object o) {
        return super.messageName.equals(((BroadcastStateAndEventsTypes$StateDefinition)o).messageName) && this.ordering == ((BroadcastStateAndEventsTypes$StateDefinition)o).ordering;
    }
    
    public BroadcastStateAndEventsTypes$StateDefinition(final String s, final boolean b, final EventHandler eventHandler, final int ordering) {
        super(s, b, eventHandler);
        this.ordering = ordering;
    }
    
    public int compareTo(final BroadcastStateAndEventsTypes$StateDefinition broadcastStateAndEventsTypes$StateDefinition) {
        int compareTo = this.ordering - broadcastStateAndEventsTypes$StateDefinition.ordering;
        if (compareTo == 0) {
            compareTo = super.messageName.compareTo(broadcastStateAndEventsTypes$StateDefinition.messageName);
        }
        return compareTo;
    }
    
    @Override
    public String toString() {
        return "(" + super.messageName + "/order=" + this.ordering + ")";
    }
}
