// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

public interface LossyStateStreamSynchronizerListener
{
    void streamRemoved(final LossyStateStreamSynchronizer p0, final LossyStateStream p1);
    
    void streamAdded(final LossyStateStreamSynchronizer p0, final LossyStateStream p1, final boolean p2);
    
    void newStateReceived(final LossyStateStreamSynchronizer p0, final LossyStateStream p1, final StateWrapper p2, final long p3);
    
    void newStateAddedToMaster(final LossyStateStreamSynchronizer p0, final LossyStateStream p1, final StateWrapper p2);
}
