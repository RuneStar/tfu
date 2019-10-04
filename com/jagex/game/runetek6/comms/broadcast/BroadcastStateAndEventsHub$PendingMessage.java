/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$MessageDefinition;
import com.jagex.game.runetek6.comms.broadcast.BroadcastStateAndEventsTypes$MessagePayload;

class BroadcastStateAndEventsHub$PendingMessage {
    final BroadcastStateAndEventsTypes$MessageDefinition messageID;
    final BroadcastStateAndEventsTypes$MessagePayload messagePayload;

    BroadcastStateAndEventsHub$PendingMessage(BroadcastStateAndEventsTypes$MessageDefinition broadcastStateAndEventsTypes$MessageDefinition, BroadcastStateAndEventsTypes$MessagePayload broadcastStateAndEventsTypes$MessagePayload) {
        this.messageID = broadcastStateAndEventsTypes$MessageDefinition;
        this.messagePayload = broadcastStateAndEventsTypes$MessagePayload;
    }
}

