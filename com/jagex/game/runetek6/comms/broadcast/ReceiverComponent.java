package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import tfu.Be2;
import tfu.Bs1;
import tfu.Lb33;

@ScriptEntryClass
public class ReceiverComponent extends BroadcasterOrReceiverComponent {
   public static final int componentTypeId = StringTools.l(ReceiverComponent.class.getName());
   private static final ReceiverDetachedException receiverDetachedException = new ReceiverDetachedException();
   private final IGameStateReceiver implementation;
   int last_AllowBroadcastsFrom_ModCount;
   float last_MinimumInterestRadius;
   boolean last_UseBroadcasterMinimumBroadcastRadius;

   void ReceiveState(String var1, BroadcastStateAndEventsTypes$StatePayload var2, boolean var3, boolean var4) throws ReceiverDetachedException {
      Lb33.g(Lb33.ReceiveState);

      try {
         BroadcastStateAndEventsHub var5 = super.currentHub;
         this.implementation.ReceiveState(var1, var2, var3, var4);
         if (super.currentHub != var5) {
            throw receiverDetachedException;
         } else {
            Lb33.d(Lb33.ReceiveState);
         }
      } finally {
         Lb33.d(Lb33.ReceiveState);
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int getComponentTypeID() {
      return componentTypeId;
   }

   void ReceiveEvent(String var1, BroadcastStateAndEventsTypes$EventPayload var2, boolean var3, boolean var4) throws ReceiverDetachedException {
      Lb33.g(Lb33.ReceiveEvent);

      try {
         BroadcastStateAndEventsHub var5 = super.currentHub;
         this.implementation.ReceiveEvent(var1, var2, var3, var4);
         if (super.currentHub != var5) {
            throw receiverDetachedException;
         } else {
            Lb33.d(Lb33.ReceiveEvent);
         }
      } finally {
         Lb33.d(Lb33.ReceiveEvent);
      }
   }

   public ReceiverComponent(IGameStateReceiver var1) {
      this.implementation = var1;
      this.markAsUsed();
   }

   float getMinimumInterestRadius() {
      return this.implementation.getMinimumInterestRadius();
   }

   boolean useBroadcasterMinimumBroadcastRadius() {
      return this.implementation.useBroadcasterMinimumBroadcastRadius();
   }

   BroadcasterVisibility allowBroadcastsFrom(GameEntity var1) {
      return this.implementation.allowBroadcastsFrom(var1);
   }

   float getMinDistanceForPair(BroadcasterComponent var1) {
      float var2 = this.implementation.getMinimumInterestRadius();
      if (this.implementation.useBroadcasterMinimumBroadcastRadius()) {
         float var3 = var1.getMinimumBroadcastRadius();
         if (var3 > var2) {
            var2 = var3;
         }
      }

      return var2;
   }

   Class getOppositeComponentClass() {
      return BroadcasterComponent.class;
   }

   void resetVisibilityNow(BroadcasterComponent var1) throws ReceiverDetachedException {
      super.currentHub.resetVisibilityNow(this, var1);
   }

   void recalculateVisibilityNextService(BroadcasterComponent var1) {
      super.currentHub.recalculateVisibilityNextService(this, var1);
   }

   void ReceiveAppeared(BroadcastStateAndEventsTypes$AppearedPayload var1, boolean var2, boolean var3) throws ReceiverDetachedException {
      Lb33.g(Lb33.ReceiveAppeared);

      try {
         BroadcastStateAndEventsHub var4 = super.currentHub;
         this.implementation.ReceiveAppeared(var1, var2, var3);
         if (super.currentHub != var4) {
            throw receiverDetachedException;
         } else {
            Lb33.d(Lb33.ReceiveAppeared);
         }
      } finally {
         Lb33.d(Lb33.ReceiveAppeared);
      }
   }

   void ReceiveGone(BroadcastStateAndEventsTypes$GonePayload var1, boolean var2, boolean var3) throws ReceiverDetachedException {
      Lb33.g(Lb33.ReceiveGone);

      try {
         BroadcastStateAndEventsHub var4 = super.currentHub;
         this.implementation.ReceiveGone(var1, var2, var3);
         if (super.currentHub != var4) {
            throw receiverDetachedException;
         } else {
            Lb33.d(Lb33.ReceiveGone);
         }
      } finally {
         Lb33.d(Lb33.ReceiveGone);
      }
   }
}
