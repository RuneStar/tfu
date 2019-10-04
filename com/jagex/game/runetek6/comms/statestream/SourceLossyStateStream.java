/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import com.jagex.game.runetek6.comms.statestream.CircularIDWidth;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamProfiler;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer;
import com.jagex.game.runetek6.comms.statestream.State;
import com.jagex.game.runetek6.comms.statestream.StateFactory;
import com.jagex.game.runetek6.comms.statestream.StateWrapper;
import java.util.List;

public class SourceLossyStateStream
extends LossyStateStream {
    private int nextStateID = 1;

    @Override
    public void reset() {
        super.reset();
        this.nextStateID = 1;
        for (LossyStateStreamSynchronizer lossyStateStreamSynchronizer : this.synchronizers) {
            lossyStateStreamSynchronizer.streamReset(this);
        }
    }

    public void putState(State state, int n, byte by) {
        LossyStateStreamProfiler.newStateAdded(this, state, n);
        this.putState(new StateWrapper(state, this.getNextID(), n, by));
    }

    public void putState(State state, int n) {
        this.putState(state, n, (byte)-1);
    }

    private int getNextID() {
        this.nextStateID = LossyStateStream.STATE_ID_WIDTH.sumIDs(this.nextStateID, 1);
        if (this.nextStateID == 0) {
            this.nextStateID = LossyStateStream.STATE_ID_WIDTH.sumIDs(this.nextStateID, 1);
        }
        return this.nextStateID;
    }

    public SourceLossyStateStream(StateFactory stateFactory, int n, String string) {
        super(stateFactory, n, string);
    }
}

