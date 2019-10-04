// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream.packetchannel;

import java.io.IOException;

class DelayableUDPPacketChannel$1 implements Runnable
{
    final /* synthetic */ DelayableUDPPacketChannel this$0;
    
    DelayableUDPPacketChannel$1(final DelayableUDPPacketChannel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void run() {
        while (this.this$0.delayThread == Thread.currentThread()) {
            synchronized (this.this$0) {
                try {
                    this.this$0.process();
                }
                catch (IOException ex) {
                    DelayableUDPPacketChannel.logger.error("", ex);
                }
                try {
                    Thread.sleep(this.this$0.msDelay);
                }
                catch (InterruptedException ex2) {}
            }
        }
    }
}
