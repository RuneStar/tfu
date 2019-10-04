package com.jagex.game.runetek6.comms.statestream;

public class LossyStateStreamProfiler$StoredState {
   public final Object state;
   public final String streamName;
   public final long timeAdded;
   public final int timestamp;

   public LossyStateStreamProfiler$StoredState(String var1, Object var2, int var3) {
      this.streamName = var1;
      this.state = var2;
      this.timestamp = var3;
      this.timeAdded = System.currentTimeMillis();
   }
}
