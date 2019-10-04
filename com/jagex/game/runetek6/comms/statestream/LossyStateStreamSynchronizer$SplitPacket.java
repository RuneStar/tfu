package com.jagex.game.runetek6.comms.statestream;

import java.nio.ByteBuffer;

class LossyStateStreamSynchronizer$SplitPacket {
   public final byte[][] payload;
   public final long receiveTime;

   public LossyStateStreamSynchronizer$SplitPacket(int var1) {
      this.payload = new byte[var1][];
      this.receiveTime = System.currentTimeMillis();
   }

   public boolean isComplete() {
      for(int var1 = 0; var1 < this.payload.length; ++var1) {
         if (this.payload[var1] == null) {
            return false;
         }
      }

      return true;
   }

   public void reassemble(ByteBuffer var1) {
      var1.clear();

      for(int var2 = 0; var2 < this.payload.length; ++var2) {
         var1.put(this.payload[var2]);
      }

      var1.flip();
   }
}
