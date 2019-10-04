/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer;
import com.jagex.game.runetek6.comms.statestream.StateWrapper;

public interface LossyStateStreamSynchronizerListener {
    public void streamRemoved(LossyStateStreamSynchronizer var1, LossyStateStream var2);

    public void streamAdded(LossyStateStreamSynchronizer var1, LossyStateStream var2, boolean var3);

    public void newStateReceived(LossyStateStreamSynchronizer var1, LossyStateStream var2, StateWrapper var3, long var4);

    public void newStateAddedToMaster(LossyStateStreamSynchronizer var1, LossyStateStream var2, StateWrapper var3);
}

