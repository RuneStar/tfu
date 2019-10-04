// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.broadcast;

class BroadcastStateAndEventsHub$RecalculateVisibilityRequest
{
    final BroadcasterComponent broadcaster;
    final ReceiverComponent receiver;
    
    BroadcastStateAndEventsHub$RecalculateVisibilityRequest(final ReceiverComponent receiver, final BroadcasterComponent broadcaster) {
        this.receiver = receiver;
        this.broadcaster = broadcaster;
    }
}
