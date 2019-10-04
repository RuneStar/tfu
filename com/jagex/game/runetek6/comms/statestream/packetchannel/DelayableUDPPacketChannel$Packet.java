package com.jagex.game.runetek6.comms.statestream.packetchannel;

import java.nio.ByteBuffer;

class DelayableUDPPacketChannel$Packet {
   public final ByteBuffer buf;
   public final long firingTime;

   public DelayableUDPPacketChannel$Packet(ByteBuffer var1, long var2) {
      this.buf = ByteBuffer.allocate(var1.remaining());
      this.buf.put(var1);
      this.buf.rewind();
      this.firingTime = var2;
   }
}
