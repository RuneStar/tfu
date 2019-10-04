package com.jagex.game.runetek6.comms.statestream;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class LossyStateStreamSynchronizer$MasterStream {
   public final byte filterGroup;
   public StateWrapper lastAcknowledgedState;
   public boolean resetPending;
   public final boolean sendKeyframes;
   public final Map statesAwaitingAcknowledgement;
   public final Map statesToSync;
   public final Map statesToSyncByTimestamp;
   public final LossyStateStream stream;
   // $FF: synthetic field
   final LossyStateStreamSynchronizer this$0;

   public void markAllStatesForSync() {
      if (this.stream.stateBelowLowest != null) {
         this.addStateToSync(this.stream.stateBelowLowest);
      }

      Iterator var1 = this.stream.timestampsToStates.values().iterator();

      while(var1.hasNext()) {
         StateWrapper var2 = (StateWrapper)var1.next();
         this.addStateToSync(var2);
      }

   }

   public void stateAcknowledged(int var1) {
      StateWrapper var2 = (StateWrapper)this.statesAwaitingAcknowledgement.get(var1);
      if (var2 != null) {
         this.lastAcknowledgedState = var2;
      }

   }

   public void reset() {
      this.statesToSync.clear();
      this.statesToSyncByTimestamp.clear();
      this.resetPending = true;
   }

   public boolean addStateToSync(StateWrapper var1) {
      if (this.filterGroup != -1 && var1.filterGroup != this.filterGroup) {
         return false;
      } else {
         if (this.statesToSyncByTimestamp.containsKey(var1.timestamp)) {
            StateWrapper var2 = (StateWrapper)this.statesToSyncByTimestamp.get(var1.timestamp);
            if (LossyStateStream.STATE_ID_WIDTH.diffIDs(var1.uniqueID, var2.uniqueID) <= 0) {
               return false;
            }

            this.statesToSync.remove(var2.uniqueID);
         }

         this.statesToSync.put(var1.uniqueID, new LossyStateStreamSynchronizer$StateWrapperWithTime(var1, System.currentTimeMillis()));
         this.statesToSyncByTimestamp.put(var1.timestamp, var1);
         Iterator var4 = LossyStateStreamSynchronizer.access$000(this.this$0).iterator();

         while(var4.hasNext()) {
            LossyStateStreamSynchronizerListener var3 = (LossyStateStreamSynchronizerListener)var4.next();
            var3.newStateAddedToMaster(this.this$0, this.stream, var1);
         }

         return true;
      }
   }

   public LossyStateStreamSynchronizer$MasterStream(LossyStateStreamSynchronizer var1, LossyStateStream var2, byte var3, boolean var4) {
      this.this$0 = var1;
      this.statesToSync = new HashMap();
      this.statesToSyncByTimestamp = new HashMap();
      this.lastAcknowledgedState = null;
      this.statesAwaitingAcknowledgement = new TreeMap();
      this.resetPending = false;
      this.stream = var2;
      this.filterGroup = var3;
      this.sendKeyframes = var4;
   }
}
