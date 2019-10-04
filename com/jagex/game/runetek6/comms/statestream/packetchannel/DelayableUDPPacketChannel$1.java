/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream.packetchannel;

import com.jagex.game.runetek6.comms.statestream.packetchannel.DelayableUDPPacketChannel;
import java.io.IOException;

class DelayableUDPPacketChannel$1
implements Runnable {
    final /* synthetic */ DelayableUDPPacketChannel this$0;

    DelayableUDPPacketChannel$1(DelayableUDPPacketChannel delayableUDPPacketChannel) {
        this.this$0 = delayableUDPPacketChannel;
    }

    @Override
    public void run() {
        while (this.this$0.delayThread == Thread.currentThread()) {
            DelayableUDPPacketChannel delayableUDPPacketChannel = this.this$0;
            synchronized (delayableUDPPacketChannel) {
                try {
                    this.this$0.process();
                }
                catch (IOException iOException) {
                    DelayableUDPPacketChannel.access$000().error("", iOException);
                }
                try {
                    Thread.sleep(this.this$0.msDelay);
                }
                catch (InterruptedException interruptedException) {
                    // empty catch block
                }
            }
        }
        return;
    }
}

