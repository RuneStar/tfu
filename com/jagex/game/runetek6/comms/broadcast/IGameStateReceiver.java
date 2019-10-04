package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.gameentity.GameEntity;

public interface IGameStateReceiver {
   boolean useBroadcasterMinimumBroadcastRadius();

   BroadcasterVisibility allowBroadcastsFrom(GameEntity var1);

   void ReceiveAppeared(BroadcastStateAndEventsTypes$AppearedPayload var1, boolean var2, boolean var3);

   void ReceiveGone(BroadcastStateAndEventsTypes$GonePayload var1, boolean var2, boolean var3);

   float getMinimumInterestRadius();

   void ReceiveState(String var1, BroadcastStateAndEventsTypes$StatePayload var2, boolean var3, boolean var4);

   void ReceiveEvent(String var1, BroadcastStateAndEventsTypes$EventPayload var2, boolean var3, boolean var4);
}
