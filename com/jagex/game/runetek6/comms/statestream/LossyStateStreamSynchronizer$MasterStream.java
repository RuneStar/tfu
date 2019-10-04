/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import com.jagex.game.runetek6.comms.statestream.CircularIDWidth;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer$StateWrapperWithTime;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizerListener;
import com.jagex.game.runetek6.comms.statestream.StateWrapper;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class LossyStateStreamSynchronizer$MasterStream {
    public final byte filterGroup;
    public StateWrapper lastAcknowledgedState = null;
    public boolean resetPending = false;
    public final boolean sendKeyframes;
    public final Map statesAwaitingAcknowledgement;
    public final Map statesToSync = new HashMap();
    public final Map statesToSyncByTimestamp = new HashMap();
    public final LossyStateStream stream;
    final /* synthetic */ LossyStateStreamSynchronizer this$0;

    public void markAllStatesForSync() {
        if (this.stream.stateBelowLowest != null) {
            this.addStateToSync(this.stream.stateBelowLowest);
        }
        for (StateWrapper stateWrapper : this.stream.timestampsToStates.values()) {
            this.addStateToSync(stateWrapper);
        }
    }

    public void stateAcknowledged(int n) {
        StateWrapper stateWrapper = (StateWrapper)this.statesAwaitingAcknowledgement.get(n);
        if (stateWrapper != null) {
            this.lastAcknowledgedState = stateWrapper;
        }
    }

    public void reset() {
        this.statesToSync.clear();
        this.statesToSyncByTimestamp.clear();
        this.resetPending = true;
    }

    public boolean addStateToSync(StateWrapper stateWrapper) {
        if (this.filterGroup == -1 || stateWrapper.filterGroup == this.filterGroup) {
            if (this.statesToSyncByTimestamp.containsKey(stateWrapper.timestamp)) {
                StateWrapper stateWrapper2 = (StateWrapper)this.statesToSyncByTimestamp.get(stateWrapper.timestamp);
                if (LossyStateStream.STATE_ID_WIDTH.diffIDs(stateWrapper.uniqueID, stateWrapper2.uniqueID) <= 0) {
                    return false;
                }
                this.statesToSync.remove(stateWrapper2.uniqueID);
            }
            this.statesToSync.put(stateWrapper.uniqueID, new LossyStateStreamSynchronizer$StateWrapperWithTime(stateWrapper, System.currentTimeMillis()));
            this.statesToSyncByTimestamp.put(stateWrapper.timestamp, stateWrapper);
            for (LossyStateStreamSynchronizerListener lossyStateStreamSynchronizerListener : LossyStateStreamSynchronizer.access$000(this.this$0)) {
                lossyStateStreamSynchronizerListener.newStateAddedToMaster(this.this$0, this.stream, stateWrapper);
            }
            return true;
        }
        return false;
    }

    public LossyStateStreamSynchronizer$MasterStream(LossyStateStreamSynchronizer lossyStateStreamSynchronizer, LossyStateStream lossyStateStream, byte by, boolean bl) {
        this.this$0 = lossyStateStreamSynchronizer;
        this.statesAwaitingAcknowledgement = new TreeMap();
        this.stream = lossyStateStream;
        this.filterGroup = by;
        this.sendKeyframes = bl;
    }
}

