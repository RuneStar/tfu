// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream.packetchannel;

import java.util.LinkedList;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.nio.channels.DatagramChannel;

public class UDPPacketChannelClient implements PacketChannel
{
    int bytesRead;
    int bytesWritten;
    final DatagramChannel channel;
    final List pushedBackPackets;
    
    @Override
    public int getWrittenByteCount() {
        return this.bytesWritten;
    }
    
    @Override
    public void write(final ByteBuffer byteBuffer) throws IOException {
        this.bytesWritten += byteBuffer.remaining();
        this.channel.write(byteBuffer);
    }
    
    public void close() {
        try {
            this.channel.close();
        }
        catch (IOException ex) {}
    }
    
    @Override
    public void resetByteCounts() {
        final int n = 0;
        this.bytesRead = n;
        this.bytesWritten = n;
    }
    
    @Override
    public int getReadByteCount() {
        return this.bytesRead;
    }
    
    public void pushBackPacket(final byte[] array) {
        this.pushedBackPackets.add(array);
    }
    
    @Override
    public boolean canWrite() {
        return this.channel.isConnected();
    }
    
    public UDPPacketChannelClient(final DatagramChannel channel) {
        this.bytesWritten = 0;
        this.bytesRead = 0;
        this.pushedBackPackets = new LinkedList();
        this.channel = channel;
    }
    
    @Override
    public int read(final ByteBuffer byteBuffer) throws IOException {
        if (this.pushedBackPackets.isEmpty()) {
            final int read = this.channel.read(byteBuffer);
            this.bytesRead += read;
            return read;
        }
        final byte[] src = this.pushedBackPackets.remove(0);
        byteBuffer.put(src);
        return src.length;
    }
}
