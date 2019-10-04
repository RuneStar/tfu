package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.core.stringtools.general.StringTools;
import tfu.Bb4;

public class BroadcastStateAndEventsTypes$DataMessagePayload extends BroadcastStateAndEventsTypes$MessagePayload {
   public byte[] wire_data;

   public BroadcastStateAndEventsTypes$DataMessagePayload() {
   }

   public BroadcastStateAndEventsTypes$DataMessagePayload(byte[] var1, Bb4 var2) {
      super(var2);
      this.wire_data = var1;
   }

   public BroadcastStateAndEventsTypes$DataMessagePayload(byte[] var1, Bb4 var2, String var3, int var4) {
      super(var2, var3, var4);
      this.wire_data = var1;
   }

   public String toString() {
      return this.getClass().getSimpleName() + "[brd=" + super.broadcasterID + "/wra=" + super.wranglerID + "/area=" + super.areaID + "/data=" + StringTools.x(this.wire_data) + "]@" + Integer.toHexString(this.hashCode());
   }
}
