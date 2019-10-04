// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

class LossyStateStreamSynchronizer$StateWrapperWithTime
{
    public final long addedTime;
    public final StateWrapper state;
    
    public LossyStateStreamSynchronizer$StateWrapperWithTime(final StateWrapper state, final long addedTime) {
        this.state = state;
        this.addedTime = addedTime;
    }
}
