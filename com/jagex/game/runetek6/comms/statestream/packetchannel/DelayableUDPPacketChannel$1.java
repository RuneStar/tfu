package com.jagex.game.runetek6.comms.statestream.packetchannel;

import java.io.IOException;

class DelayableUDPPacketChannel$1 implements Runnable {
   // $FF: synthetic field
   final DelayableUDPPacketChannel this$0;

   DelayableUDPPacketChannel$1(DelayableUDPPacketChannel var1) {
      this.this$0 = var1;
   }

   public void run() {
      while(this.this$0.delayThread == Thread.currentThread()) {
         DelayableUDPPacketChannel var1 = this.this$0;
         synchronized(var1) {
            try {
               this.this$0.process();
            } catch (IOException var5) {
               DelayableUDPPacketChannel.access$000().error("", var5);
            }

            try {
               Thread.sleep((long)this.this$0.msDelay);
            } catch (InterruptedException var4) {
            }
         }
      }

   }
}
