/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream.packetchannel;

import com.jagex.game.runetek6.comms.statestream.packetchannel.PacketChannel;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class NumberingPacketChannel
implements PacketChannel {
    private int maxIncomingNumber = -1;
    private int outgoingNumber = 0;
    private ByteBuffer tmpbuf = ByteBuffer.allocate(65536);
    private final PacketChannel underlyingChannel;
    private final List unreceivedNumbers = new LinkedList();

    @Override
    public boolean canWrite() {
        return this.underlyingChannel.canWrite();
    }

    @Override
    public int read(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() + 4 > this.tmpbuf.capacity()) {
            this.tmpbuf = ByteBuffer.allocate(byteBuffer.remaining() + 1024);
        }
        this.tmpbuf.clear();
        int n = this.underlyingChannel.read(this.tmpbuf);
        if (n == 0) {
            return 0;
        }
        this.tmpbuf.limit(n);
        this.tmpbuf.rewind();
        int n2 = this.tmpbuf.getInt();
        byteBuffer.put(this.tmpbuf);
        if (n2 > this.maxIncomingNumber) {
            for (int i = this.maxIncomingNumber + 1; i < n2; ++i) {
                this.unreceivedNumbers.add(i);
            }
            this.maxIncomingNumber = n2;
        } else {
            this.unreceivedNumbers.remove((Object)n2);
        }
        return n - 4;
    }

    @Override
    public void write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() + 4 > this.tmpbuf.capacity()) {
            this.tmpbuf = ByteBuffer.allocate(byteBuffer.remaining() + 1024);
        }
        this.tmpbuf.clear();
        this.tmpbuf.putInt(this.outgoingNumber++);
        this.tmpbuf.put(byteBuffer);
        this.tmpbuf.flip();
        this.underlyingChannel.write(this.tmpbuf);
    }

    public int getUnreceivedCount() {
        return this.unreceivedNumbers.size();
    }

    public NumberingPacketChannel(PacketChannel packetChannel) {
        this.underlyingChannel = packetChannel;
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

