/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$MessageDefinition;
import com.jagex.game.runetek6.event.EventHandler;

public class BroadcastStateAndEventsTypes$StateDefinition
extends BroadcastStateAndEventsTypes$MessageDefinition
implements Comparable {
    public int ordering;

    @Override
    public boolean equals(Object object) {
        return this.messageName.equals(((BroadcastStateAndEventsTypes$StateDefinition)object).messageName) && this.ordering == ((BroadcastStateAndEventsTypes$StateDefinition)object).ordering;
    }

    public BroadcastStateAndEventsTypes$StateDefinition(String string, boolean bl, EventHandler eventHandler, int n) {
        super(string, bl, eventHandler);
        this.ordering = n;
    }

    public int compareTo(BroadcastStateAndEventsTypes$StateDefinition broadcastStateAndEventsTypes$StateDefinition) {
        int n = this.ordering - broadcastStateAndEventsTypes$StateDefinition.ordering;
        if (n == 0) {
            n = this.messageName.compareTo(broadcastStateAndEventsTypes$StateDefinition.messageName);
        }
        return n;
    }

    @Override
    public String toString() {
        return "(" + this.messageName + "/order=" + this.ordering + ")";
    }
}

