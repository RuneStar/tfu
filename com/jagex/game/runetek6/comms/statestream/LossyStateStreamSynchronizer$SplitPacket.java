// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

import java.nio.ByteBuffer;

class LossyStateStreamSynchronizer$SplitPacket
{
    public final byte[][] payload;
    public final long receiveTime;
    
    public LossyStateStreamSynchronizer$SplitPacket(final int n) {
        this.payload = new byte[n][];
        this.receiveTime = System.currentTimeMillis();
    }
    
    public boolean isComplete() {
        for (int i = 0; i < this.payload.length; ++i) {
            if (this.payload[i] == null) {
                return false;
            }
        }
        return true;
    }
    
    public void reassemble(final ByteBuffer byteBuffer) {
        byteBuffer.clear();
        for (int i = 0; i < this.payload.length; ++i) {
            byteBuffer.put(this.payload[i]);
        }
        byteBuffer.flip();
    }
}
