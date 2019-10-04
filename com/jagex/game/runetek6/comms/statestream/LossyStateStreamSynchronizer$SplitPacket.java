/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import java.nio.Buffer;
import java.nio.ByteBuffer;

class LossyStateStreamSynchronizer$SplitPacket {
    public final byte[][] payload;
    public final long receiveTime;

    public LossyStateStreamSynchronizer$SplitPacket(int n) {
        this.payload = new byte[n][];
        this.receiveTime = System.currentTimeMillis();
    }

    public boolean isComplete() {
        for (int i = 0; i < this.payload.length; ++i) {
            if (this.payload[i] != null) continue;
            return false;
        }
        return true;
    }

    public void reassemble(ByteBuffer byteBuffer) {
        byteBuffer.clear();
        for (int i = 0; i < this.payload.length; ++i) {
            byteBuffer.put(this.payload[i]);
        }
        byteBuffer.flip();
    }
}

