// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.core.stringtools.general.StringTools;
import tfu.Bb4;

public class BroadcastStateAndEventsTypes$DataMessagePayload extends BroadcastStateAndEventsTypes$MessagePayload
{
    public byte[] wire_data;
    
    public BroadcastStateAndEventsTypes$DataMessagePayload() {
    }
    
    public BroadcastStateAndEventsTypes$DataMessagePayload(final byte[] wire_data, final Bb4 bb4) {
        super(bb4);
        this.wire_data = wire_data;
    }
    
    public BroadcastStateAndEventsTypes$DataMessagePayload(final byte[] wire_data, final Bb4 bb4, final String s, final int n) {
        super(bb4, s, n);
        this.wire_data = wire_data;
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[brd=" + super.broadcasterID + "/wra=" + super.wranglerID + "/area=" + super.areaID + "/data=" + StringTools.x(this.wire_data) + "]@" + Integer.toHexString(this.hashCode());
    }
}
