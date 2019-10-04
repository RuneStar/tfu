package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.util.SortedMap;
import java.util.TreeMap;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass("BroadcasterComponent")
public class BroadcasterComponent extends BroadcasterOrReceiverComponent {
   public static final int componentTypeId = StringTools.l(BroadcasterComponent.class.getName());
   private final IGameStateBroadcaster implementation;
   int last_AllowBroadcastsTo_ModCount;
   float last_MinimumBroadcastRadius;
   private float minimumBroadcastRadius;
   final SortedMap persistedState = new TreeMap();

   public void BroadcastableState(BroadcastStateAndEventsTypes$StateDefinition var1, BroadcastStateAndEventsTypes$StatePayload var2) {
      this.markAsUsed();
      this.persistedState.put(var1, var2);
      if (super.currentHub != null) {
         super.currentHub.queueMessageForCurrentReceivers(this, var1, var2);
      }

   }

   public BroadcasterComponent(IGameStateBroadcaster var1) {
      this.implementation = var1;
      if (this.implementation.causesAppearedOrGone()) {
         this.markAsUsed();
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void BroadcastableState(BroadcastStateAndEventsTypes$StateDefinition var1, byte[] var2) {
      this.BroadcastableState(var1, new BroadcastStateAndEventsTypes$StatePayload(var2, this.getEntity().bg));
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void BroadcastableEvent(BroadcastStateAndEventsTypes$EventDefinition var1, byte[] var2) {
      this.BroadcastableEvent(var1, new BroadcastStateAndEventsTypes$EventPayload(var2, this.getEntity().bg));
   }

   boolean causesAppearedOrGone() {
      return this.implementation.causesAppearedOrGone();
   }

   BroadcasterVisibility allowBroadcastsTo(GameEntity var1) {
      return this.implementation.allowBroadcastsTo(var1);
   }

   float getMinimumBroadcastRadius() {
      return this.minimumBroadcastRadius;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   void setMinimumBroadcastRadius(float var1) {
      this.minimumBroadcastRadius = var1;
   }

   Class getOppositeComponentClass() {
      return ReceiverComponent.class;
   }

   float getMinDistanceForPair(ReceiverComponent var1) {
      return var1.getMinDistanceForPair(this);
   }

   void resetVisibilityNow(ReceiverComponent var1) throws ReceiverDetachedException {
      super.currentHub.resetVisibilityNow(var1, this);
   }

   public void BroadcastableEvent(BroadcastStateAndEventsTypes$EventDefinition var1, BroadcastStateAndEventsTypes$EventPayload var2) {
      this.markAsUsed();
      if (super.currentHub != null) {
         super.currentHub.queueMessageForCurrentReceivers(this, var1, var2);
      }

   }

   void recalculateVisibilityNextService(ReceiverComponent var1) {
      super.currentHub.recalculateVisibilityNextService(var1, this);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int getComponentTypeID() {
      return componentTypeId;
   }
}
