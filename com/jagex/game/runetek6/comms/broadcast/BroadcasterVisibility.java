/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.broadcast;

public enum BroadcasterVisibility {
    UNKNOWN,
    SERVER_ONLY,
    SERVER_AND_CLIENT;
    

    public BroadcasterVisibility and(BroadcasterVisibility broadcasterVisibility) {
        return broadcasterVisibility.ordinal() < this.ordinal() ? broadcasterVisibility : this;
    }
}

