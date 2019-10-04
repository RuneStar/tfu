// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.broadcast;

import tfu.Bb4;

public class BroadcastStateAndEventsTypes$MessagePayload
{
    public int areaID;
    public Bb4 broadcasterID;
    public String wranglerID;
    
    protected BroadcastStateAndEventsTypes$MessagePayload() {
    }
    
    public BroadcastStateAndEventsTypes$MessagePayload(final Bb4 broadcasterID, final String wranglerID, final int areaID) {
        this.broadcasterID = broadcasterID;
        this.wranglerID = wranglerID;
        this.areaID = areaID;
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[brd=" + this.broadcasterID + "/trk=" + this.wranglerID + "/area=" + this.areaID + "]@" + Integer.toHexString(this.hashCode());
    }
    
    public BroadcastStateAndEventsTypes$MessagePayload(final Bb4 broadcasterID) {
        this.broadcasterID = broadcasterID;
        this.wranglerID = null;
        this.areaID = -1;
    }
}
