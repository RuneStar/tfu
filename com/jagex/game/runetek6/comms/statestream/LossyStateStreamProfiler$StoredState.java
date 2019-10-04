// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

public class LossyStateStreamProfiler$StoredState
{
    public final Object state;
    public final String streamName;
    public final long timeAdded;
    public final int timestamp;
    
    public LossyStateStreamProfiler$StoredState(final String streamName, final Object state, final int timestamp) {
        this.streamName = streamName;
        this.state = state;
        this.timestamp = timestamp;
        this.timeAdded = System.currentTimeMillis();
    }
}
