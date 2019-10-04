// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream.packetchannel;

import java.nio.ByteBuffer;

class DelayableUDPPacketChannel$Packet
{
    public final ByteBuffer buf;
    public final long firingTime;
    
    public DelayableUDPPacketChannel$Packet(final ByteBuffer src, final long firingTime) {
        (this.buf = ByteBuffer.allocate(src.remaining())).put(src);
        this.buf.rewind();
        this.firingTime = firingTime;
    }
}
