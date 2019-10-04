// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.gameentity.GameEntity;

public interface IGameStateReceiver
{
    boolean useBroadcasterMinimumBroadcastRadius();
    
    BroadcasterVisibility allowBroadcastsFrom(final GameEntity p0);
    
    void ReceiveAppeared(final BroadcastStateAndEventsTypes$AppearedPayload p0, final boolean p1, final boolean p2);
    
    void ReceiveGone(final BroadcastStateAndEventsTypes$GonePayload p0, final boolean p1, final boolean p2);
    
    float getMinimumInterestRadius();
    
    void ReceiveState(final String p0, final BroadcastStateAndEventsTypes$StatePayload p1, final boolean p2, final boolean p3);
    
    void ReceiveEvent(final String p0, final BroadcastStateAndEventsTypes$EventPayload p1, final boolean p2, final boolean p3);
}
