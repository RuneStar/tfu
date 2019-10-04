// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.broadcast;

public enum BroadcasterVisibility
{
    SERVER_AND_CLIENT("SERVER_AND_CLIENT", 2), 
    SERVER_ONLY("SERVER_ONLY", 1), 
    UNKNOWN("UNKNOWN", 0);
    
    private BroadcasterVisibility(final String name, final int ordinal) {
    }
    
    public BroadcasterVisibility and(final BroadcasterVisibility broadcasterVisibility) {
        return (broadcasterVisibility.ordinal() < this.ordinal()) ? broadcasterVisibility : this;
    }
}
