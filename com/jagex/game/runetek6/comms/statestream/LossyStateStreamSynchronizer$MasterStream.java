// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

import java.util.TreeMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class LossyStateStreamSynchronizer$MasterStream
{
    public final byte filterGroup;
    public StateWrapper lastAcknowledgedState;
    public boolean resetPending;
    public final boolean sendKeyframes;
    public final Map statesAwaitingAcknowledgement;
    public final Map statesToSync;
    public final Map statesToSyncByTimestamp;
    public final LossyStateStream stream;
    final /* synthetic */ LossyStateStreamSynchronizer this$0;
    
    public void markAllStatesForSync() {
        if (this.stream.stateBelowLowest != null) {
            this.addStateToSync(this.stream.stateBelowLowest);
        }
        final Iterator<StateWrapper> iterator = this.stream.timestampsToStates.values().iterator();
        while (iterator.hasNext()) {
            this.addStateToSync(iterator.next());
        }
    }
    
    public void stateAcknowledged(final int i) {
        final StateWrapper lastAcknowledgedState = this.statesAwaitingAcknowledgement.get(i);
        if (lastAcknowledgedState != null) {
            this.lastAcknowledgedState = lastAcknowledgedState;
        }
    }
    
    public void reset() {
        this.statesToSync.clear();
        this.statesToSyncByTimestamp.clear();
        this.resetPending = true;
    }
    
    public boolean addStateToSync(final StateWrapper stateWrapper) {
        if (this.filterGroup == -1 || stateWrapper.filterGroup == this.filterGroup) {
            if (this.statesToSyncByTimestamp.containsKey(stateWrapper.timestamp)) {
                final StateWrapper stateWrapper2 = this.statesToSyncByTimestamp.get(stateWrapper.timestamp);
                if (LossyStateStream.STATE_ID_WIDTH.diffIDs(stateWrapper.uniqueID, stateWrapper2.uniqueID) <= 0) {
                    return false;
                }
                this.statesToSync.remove(stateWrapper2.uniqueID);
            }
            this.statesToSync.put(stateWrapper.uniqueID, new LossyStateStreamSynchronizer$StateWrapperWithTime(stateWrapper, System.currentTimeMillis()));
            this.statesToSyncByTimestamp.put(stateWrapper.timestamp, stateWrapper);
            final Iterator<LossyStateStreamSynchronizerListener> iterator = this.this$0.listeners.iterator();
            while (iterator.hasNext()) {
                iterator.next().newStateAddedToMaster(this.this$0, this.stream, stateWrapper);
            }
            return true;
        }
        return false;
    }
    
    public LossyStateStreamSynchronizer$MasterStream(final LossyStateStreamSynchronizer this$0, final LossyStateStream stream, final byte filterGroup, final boolean sendKeyframes) {
        this.this$0 = this$0;
        this.statesToSync = new HashMap();
        this.statesToSyncByTimestamp = new HashMap();
        this.lastAcknowledgedState = null;
        this.statesAwaitingAcknowledgement = new TreeMap();
        this.resetPending = false;
        this.stream = stream;
        this.filterGroup = filterGroup;
        this.sendKeyframes = sendKeyframes;
    }
}
