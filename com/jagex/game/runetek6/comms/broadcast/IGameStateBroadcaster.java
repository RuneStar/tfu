/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.comms.broadcast.BroadcasterVisibility;
import com.jagex.game.runetek6.gameentity.GameEntity;

public interface IGameStateBroadcaster {
    public boolean causesAppearedOrGone();

    public BroadcasterVisibility allowBroadcastsTo(GameEntity var1);
}

