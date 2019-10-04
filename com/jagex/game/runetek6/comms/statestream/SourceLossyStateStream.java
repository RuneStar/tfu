// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

import java.util.Iterator;

public class SourceLossyStateStream extends LossyStateStream
{
    private int nextStateID;
    
    public void reset() {
        super.reset();
        this.nextStateID = 1;
        final Iterator<LossyStateStreamSynchronizer> iterator = super.synchronizers.iterator();
        while (iterator.hasNext()) {
            iterator.next().streamReset(this);
        }
    }
    
    public void putState(final State state, final int n, final byte b) {
        LossyStateStreamProfiler.newStateAdded(this, state, n);
        this.putState(new StateWrapper(state, this.getNextID(), n, b));
    }
    
    public void putState(final State state, final int n) {
        this.putState(state, n, (byte)(-1));
    }
    
    private int getNextID() {
        this.nextStateID = LossyStateStream.STATE_ID_WIDTH.sumIDs(this.nextStateID, 1);
        if (this.nextStateID == 0) {
            this.nextStateID = LossyStateStream.STATE_ID_WIDTH.sumIDs(this.nextStateID, 1);
        }
        return this.nextStateID;
    }
    
    public SourceLossyStateStream(final StateFactory stateFactory, final int n, final String s) {
        super(stateFactory, n, s);
        this.nextStateID = 1;
    }
}
