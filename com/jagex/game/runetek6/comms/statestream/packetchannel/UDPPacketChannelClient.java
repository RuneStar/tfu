/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream.packetchannel;

import com.jagex.game.runetek6.comms.statestream.packetchannel.PacketChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.LinkedList;
import java.util.List;

public class UDPPacketChannelClient
implements PacketChannel {
    int bytesRead = 0;
    int bytesWritten = 0;
    final DatagramChannel channel;
    final List pushedBackPackets = new LinkedList();

    @Override
    public int getWrittenByteCount() {
        return this.bytesWritten;
    }

    @Override
    public void write(ByteBuffer byteBuffer) throws IOException {
        this.bytesWritten += byteBuffer.remaining();
        this.channel.write(byteBuffer);
    }

    public void close() {
        try {
            this.channel.close();
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    @Override
    public void resetByteCounts() {
        this.bytesRead = 0;
        this.bytesWritten = 0;
    }

    @Override
    public int getReadByteCount() {
        return this.bytesRead;
    }

    public void pushBackPacket(byte[] arrby) {
        this.pushedBackPackets.add(arrby);
    }

    @Override
    public boolean canWrite() {
        return this.channel.isConnected();
    }

    public UDPPacketChannelClient(DatagramChannel datagramChannel) {
        this.channel = datagramChannel;
    }

    @Override
    public int read(ByteBuffer byteBuffer) throws IOException {
        if (this.pushedBackPackets.isEmpty()) {
            int n = this.channel.read(byteBuffer);
            this.bytesRead += n;
            return n;
        }
        byte[] arrby = (byte[])this.pushedBackPackets.remove(0);
        byteBuffer.put(arrby);
        return arrby.length;
    }
}

