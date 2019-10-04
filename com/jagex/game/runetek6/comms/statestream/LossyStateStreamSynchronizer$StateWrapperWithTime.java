/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import com.jagex.game.runetek6.comms.statestream.StateWrapper;

class LossyStateStreamSynchronizer$StateWrapperWithTime {
    public final long addedTime;
    public final StateWrapper state;

    public LossyStateStreamSynchronizer$StateWrapperWithTime(StateWrapper stateWrapper, long l) {
        this.state = stateWrapper;
        this.addedTime = l;
    }
}

