/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$AppearedPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$EventPayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$GonePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$StatePayload;
import com.jagex.game.runetek6.comms.broadcast.BroadcasterVisibility;
import com.jagex.game.runetek6.gameentity.GameEntity;

public interface IGameStateReceiver {
    public boolean useBroadcasterMinimumBroadcastRadius();

    public BroadcasterVisibility allowBroadcastsFrom(GameEntity var1);

    public void ReceiveAppeared(BroadcastStateAndEventsTypes$AppearedPayload var1, boolean var2, boolean var3);

    public void ReceiveGone(BroadcastStateAndEventsTypes$GonePayload var1, boolean var2, boolean var3);

    public float getMinimumInterestRadius();

    public void ReceiveState(String var1, BroadcastStateAndEventsTypes$StatePayload var2, boolean var3, boolean var4);

    public void ReceiveEvent(String var1, BroadcastStateAndEventsTypes$EventPayload var2, boolean var3, boolean var4);
}

