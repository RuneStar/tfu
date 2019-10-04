package com.jagex.game.runetek6.comms.statestream;

import java.util.Iterator;

public class SourceLossyStateStream extends LossyStateStream {
   private int nextStateID = 1;

   public void reset() {
      super.reset();
      this.nextStateID = 1;
      Iterator var1 = super.synchronizers.iterator();

      while(var1.hasNext()) {
         LossyStateStreamSynchronizer var2 = (LossyStateStreamSynchronizer)var1.next();
         var2.streamReset(this);
      }

   }

   public void putState(State var1, int var2, byte var3) {
      LossyStateStreamProfiler.newStateAdded(this, var1, var2);
      this.putState(new StateWrapper(var1, this.getNextID(), var2, var3));
   }

   public void putState(State var1, int var2) {
      this.putState(var1, var2, (byte)-1);
   }

   private int getNextID() {
      this.nextStateID = LossyStateStream.STATE_ID_WIDTH.sumIDs(this.nextStateID, 1);
      if (this.nextStateID == 0) {
         this.nextStateID = LossyStateStream.STATE_ID_WIDTH.sumIDs(this.nextStateID, 1);
      }

      return this.nextStateID;
   }

   public SourceLossyStateStream(StateFactory var1, int var2, String var3) {
      super(var1, var2, var3);
   }
}
