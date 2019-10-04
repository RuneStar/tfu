package com.jagex.game.runetek6.comms.broadcast;

public enum BroadcasterVisibility {
   SERVER_AND_CLIENT,
   SERVER_ONLY,
   UNKNOWN;

   public BroadcasterVisibility and(BroadcasterVisibility var1) {
      return var1.ordinal() < this.ordinal() ? var1 : this;
   }
}
