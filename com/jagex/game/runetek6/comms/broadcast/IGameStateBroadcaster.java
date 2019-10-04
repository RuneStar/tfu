package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.gameentity.GameEntity;

public interface IGameStateBroadcaster {
   boolean causesAppearedOrGone();

   BroadcasterVisibility allowBroadcastsTo(GameEntity var1);
}
