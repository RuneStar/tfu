package com.jagex.game.runetek6.comms.broadcast;

class BroadcastStateAndEventsHub$PendingMessage {
   final BroadcastStateAndEventsTypes$MessageDefinition messageID;
   final BroadcastStateAndEventsTypes$MessagePayload messagePayload;

   BroadcastStateAndEventsHub$PendingMessage(BroadcastStateAndEventsTypes$MessageDefinition var1, BroadcastStateAndEventsTypes$MessagePayload var2) {
      this.messageID = var1;
      this.messagePayload = var2;
   }
}
