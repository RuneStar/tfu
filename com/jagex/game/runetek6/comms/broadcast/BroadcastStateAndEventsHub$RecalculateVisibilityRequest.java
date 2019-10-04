package com.jagex.game.runetek6.comms.broadcast;

class BroadcastStateAndEventsHub$RecalculateVisibilityRequest {
   final BroadcasterComponent broadcaster;
   final ReceiverComponent receiver;

   BroadcastStateAndEventsHub$RecalculateVisibilityRequest(ReceiverComponent var1, BroadcasterComponent var2) {
      this.receiver = var1;
      this.broadcaster = var2;
   }
}
