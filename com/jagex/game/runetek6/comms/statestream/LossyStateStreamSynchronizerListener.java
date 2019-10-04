package com.jagex.game.runetek6.comms.statestream;

public interface LossyStateStreamSynchronizerListener {
   void streamRemoved(LossyStateStreamSynchronizer var1, LossyStateStream var2);

   void streamAdded(LossyStateStreamSynchronizer var1, LossyStateStream var2, boolean var3);

   void newStateReceived(LossyStateStreamSynchronizer var1, LossyStateStream var2, StateWrapper var3, long var4);

   void newStateAddedToMaster(LossyStateStreamSynchronizer var1, LossyStateStream var2, StateWrapper var3);
}
