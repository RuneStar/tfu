/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.comms.broadcast.BroadcasterComponent;
import com.jagex.game.runetek6.comms.broadcast.ReceiverComponent;

class BroadcastStateAndEventsHub$RecalculateVisibilityRequest {
    final BroadcasterComponent broadcaster;
    final ReceiverComponent receiver;

    BroadcastStateAndEventsHub$RecalculateVisibilityRequest(ReceiverComponent receiverComponent, BroadcasterComponent broadcasterComponent) {
        this.receiver = receiverComponent;
        this.broadcaster = broadcasterComponent;
    }
}

