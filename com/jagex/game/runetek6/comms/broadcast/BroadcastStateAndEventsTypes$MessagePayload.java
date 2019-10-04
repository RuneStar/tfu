package com.jagex.game.runetek6.comms.broadcast;

import tfu.Bb4;

public class BroadcastStateAndEventsTypes$MessagePayload {
   public int areaID;
   public Bb4 broadcasterID;
   public String wranglerID;

   protected BroadcastStateAndEventsTypes$MessagePayload() {
   }

   public BroadcastStateAndEventsTypes$MessagePayload(Bb4 var1, String var2, int var3) {
      this.broadcasterID = var1;
      this.wranglerID = var2;
      this.areaID = var3;
   }

   public String toString() {
      return this.getClass().getSimpleName() + "[brd=" + this.broadcasterID + "/trk=" + this.wranglerID + "/area=" + this.areaID + "]@" + Integer.toHexString(this.hashCode());
   }

   public BroadcastStateAndEventsTypes$MessagePayload(Bb4 var1) {
      this.broadcasterID = var1;
      this.wranglerID = null;
      this.areaID = -1;
   }
}
