// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream.packetchannel;

import java.util.LinkedList;
import java.io.IOException;
import java.util.List;
import java.nio.ByteBuffer;

public class NumberingPacketChannel implements PacketChannel
{
    private int maxIncomingNumber;
    private int outgoingNumber;
    private ByteBuffer tmpbuf;
    private final PacketChannel underlyingChannel;
    private final List unreceivedNumbers;
    
    @Override
    public boolean canWrite() {
        return this.underlyingChannel.canWrite();
    }
    
    @Override
    public int read(final ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() + 4 > this.tmpbuf.capacity()) {
            this.tmpbuf = ByteBuffer.allocate(byteBuffer.remaining() + 1024);
        }
        this.tmpbuf.clear();
        final int read = this.underlyingChannel.read(this.tmpbuf);
        if (read == 0) {
            return 0;
        }
        this.tmpbuf.limit(read);
        this.tmpbuf.rewind();
        final int int1 = this.tmpbuf.getInt();
        byteBuffer.put(this.tmpbuf);
        if (int1 > this.maxIncomingNumber) {
            for (int i = this.maxIncomingNumber + 1; i < int1; ++i) {
                this.unreceivedNumbers.add(i);
            }
            this.maxIncomingNumber = int1;
        }
        else {
            this.unreceivedNumbers.remove((Object)int1);
        }
        return read - 4;
    }
    
    @Override
    public void write(final ByteBuffer src) throws IOException {
        if (src.remaining() + 4 > this.tmpbuf.capacity()) {
            this.tmpbuf = ByteBuffer.allocate(src.remaining() + 1024);
        }
        this.tmpbuf.clear();
        this.tmpbuf.putInt(this.outgoingNumber++);
        this.tmpbuf.put(src);
        this.tmpbuf.flip();
        this.underlyingChannel.write(this.tmpbuf);
    }
    
    public int getUnreceivedCount() {
        return this.unreceivedNumbers.size();
    }
    
    public NumberingPacketChannel(final PacketChannel underlyingChannel) {
        this.tmpbuf = ByteBuffer.allocate(65536);
        this.outgoingNumber = 0;
        this.maxIncomingNumber = -1;
        this.unreceivedNumbers = new LinkedList();
        this.underlyingChannel = underlyingChannel;
    }
    
    public int getReceivedCount() {
        return this.maxIncomingNumber + 1 - this.unreceivedNumbers.size();
    }
    
    @Override
    public void resetByteCounts() {
        this.underlyingChannel.resetByteCounts();
    }
    
    @Override
    public int getReadByteCount() {
        return this.underlyingChannel.getReadByteCount();
    }
    
    @Override
    public int getWrittenByteCount() {
        return this.underlyingChannel.getWrittenByteCount();
    }
}
