/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream.packetchannel;

import java.nio.Buffer;
import java.nio.ByteBuffer;

class DelayableUDPPacketChannel$Packet {
    public final ByteBuffer buf;
    public final long firingTime;

    public DelayableUDPPacketChannel$Packet(ByteBuffer byteBuffer, long l) {
        this.buf = ByteBuffer.allocate(byteBuffer.remaining());
        this.buf.put(byteBuffer);
        this.buf.rewind();
        this.firingTime = l;
    }
}

