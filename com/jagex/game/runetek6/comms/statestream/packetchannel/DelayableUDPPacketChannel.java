// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream.packetchannel;

import org.slf4j.LoggerFactory;
import java.util.LinkedList;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Queue;
import org.slf4j.Logger;

public class DelayableUDPPacketChannel implements PacketChannel
{
    private static final Logger logger;
    int bytesRead;
    int bytesWritten;
    final Runnable delayRunnable;
    Thread delayThread;
    final PacketChannel internalChannel;
    int msDelay;
    final Queue readPacketQueue;
    final ByteBuffer tmpBuffer;
    final Queue writtenPacketQueue;
    
    public void process() throws IOException {
        if (!this.internalChannel.canWrite()) {
            return;
        }
        synchronized (this.writtenPacketQueue) {
            while (!this.writtenPacketQueue.isEmpty()) {
                final DelayableUDPPacketChannel$Packet delayableUDPPacketChannel$Packet = this.writtenPacketQueue.element();
                if (this.msDelay > 0 && System.currentTimeMillis() < delayableUDPPacketChannel$Packet.firingTime) {
                    break;
                }
                this.internalChannel.write(delayableUDPPacketChannel$Packet.buf);
                this.writtenPacketQueue.remove();
            }
        }
        synchronized (this.readPacketQueue) {
            while (true) {
                this.tmpBuffer.clear();
                final int read = this.internalChannel.read(this.tmpBuffer);
                this.tmpBuffer.flip();
                if (read == 0) {
                    break;
                }
                this.readPacketQueue.add(new DelayableUDPPacketChannel$Packet(this.tmpBuffer, System.currentTimeMillis() + this.msDelay));
            }
        }
    }
    
    private synchronized void updateDelayThread() {
        if (this.msDelay > 0 && this.delayThread == null) {
            (this.delayThread = new Thread(this.delayRunnable)).start();
        }
        if (this.msDelay <= 0 && this.delayThread != null) {
            this.delayThread = null;
        }
    }
    
    public DelayableUDPPacketChannel(final PacketChannel internalChannel, final int msDelay) {
        this.writtenPacketQueue = new LinkedList();
        this.readPacketQueue = new LinkedList();
        this.tmpBuffer = ByteBuffer.allocate(1048576);
        this.delayRunnable = new DelayableUDPPacketChannel$1(this);
        this.delayThread = null;
        this.bytesWritten = 0;
        this.bytesRead = 0;
        this.internalChannel = internalChannel;
        this.msDelay = msDelay;
        this.updateDelayThread();
    }
    
    @Override
    public void write(final ByteBuffer byteBuffer) throws IOException {
        this.bytesWritten += byteBuffer.remaining();
        synchronized (this.writtenPacketQueue) {
            this.writtenPacketQueue.add(new DelayableUDPPacketChannel$Packet(byteBuffer, System.currentTimeMillis() + this.msDelay));
            if (this.msDelay > 0) {
                this.process();
            }
        }
    }
    
    @Override
    public int read(final ByteBuffer byteBuffer) throws IOException {
        synchronized (this.readPacketQueue) {
            if (this.msDelay <= 0) {
                this.process();
            }
            if (this.readPacketQueue.isEmpty()) {
                return 0;
            }
            final DelayableUDPPacketChannel$Packet delayableUDPPacketChannel$Packet = this.readPacketQueue.element();
            if (this.msDelay > 0 && System.currentTimeMillis() < delayableUDPPacketChannel$Packet.firingTime) {
                return 0;
            }
            byteBuffer.put(delayableUDPPacketChannel$Packet.buf);
            this.readPacketQueue.remove();
            final int limit = delayableUDPPacketChannel$Packet.buf.limit();
            this.bytesRead += limit;
            return limit;
        }
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
    
    @Override
    public int getWrittenByteCount() {
        return this.bytesWritten;
    }
    
    static {
        logger = LoggerFactory.getLogger(DelayableUDPPacketChannel.class);
    }
    
    @Override
    public boolean canWrite() {
        return this.internalChannel.canWrite();
    }
}
