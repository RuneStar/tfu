// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.broadcast;

class BroadcastStateAndEventsHub$PendingMessage
{
    final BroadcastStateAndEventsTypes$MessageDefinition messageID;
    final BroadcastStateAndEventsTypes$MessagePayload messagePayload;
    
    BroadcastStateAndEventsHub$PendingMessage(final BroadcastStateAndEventsTypes$MessageDefinition messageID, final BroadcastStateAndEventsTypes$MessagePayload messagePayload) {
        this.messageID = messageID;
        this.messagePayload = messagePayload;
    }
}
