/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.event.EventHandler;

public class BroadcastStateAndEventsTypes$MessageDefinition {
    protected boolean autoForward;
    public final String messageName;
    protected final EventHandler validator;

    public boolean getAutoForwarding() {
        return this.autoForward;
    }

    public int hashCode() {
        return this.messageName.hashCode();
    }

    public boolean equals(Object object) {
        return this.messageName.equals(((BroadcastStateAndEventsTypes$MessageDefinition)object).messageName);
    }

    public void setAutoForwarding(boolean bl) {
        this.autoForward = bl;
    }

    public String toString() {
        return "(" + this.messageName + ")";
    }

    public BroadcastStateAndEventsTypes$MessageDefinition(String string, boolean bl, EventHandler eventHandler) {
        this.messageName = string;
        this.validator = eventHandler;
        this.autoForward = bl;
    }
}

