package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.maths.ScaleRotTrans;
import tfu.Bb4;

public class BroadcastStateAndEventsTypes$AppearedPayload extends BroadcastStateAndEventsTypes$MessagePayload {
   public ScaleRotTrans transform;

   public BroadcastStateAndEventsTypes$AppearedPayload(Bb4 var1, String var2, int var3, ScaleRotTrans var4) {
      super(var1, var2, var3);
      this.transform = var4;
   }
}
