/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream.packetchannel;

import com.jagex.game.runetek6.comms.statestream.packetchannel.DelayableUDPPacketChannel$1;
import com.jagex.game.runetek6.comms.statestream.packetchannel.DelayableUDPPacketChannel$Packet;
import com.jagex.game.runetek6.comms.statestream.packetchannel.PacketChannel;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DelayableUDPPacketChannel
implements PacketChannel {
    private static final Logger logger = LoggerFactory.getLogger(DelayableUDPPacketChannel.class);
    int bytesRead = 0;
    int bytesWritten = 0;
    final Runnable delayRunnable;
    Thread delayThread = null;
    final PacketChannel internalChannel;
    int msDelay;
    final Queue readPacketQueue;
    final ByteBuffer tmpBuffer;
    final Queue writtenPacketQueue = new LinkedList();

    static /* synthetic */ Logger access$000() {
        return logger;
    }

    public void process() throws IOException {
        Object object;
        if (!this.internalChannel.canWrite()) {
            return;
        }
        Queue queue = this.writtenPacketQueue;
        synchronized (queue) {
            while (!this.writtenPacketQueue.isEmpty()) {
                object = (DelayableUDPPacketChannel$Packet)this.writtenPacketQueue.element();
                if (this.msDelay > 0 && System.currentTimeMillis() < object.firingTime) break;
                this.internalChannel.write(object.buf);
                this.writtenPacketQueue.remove();
            }
        }
        queue = this.readPacketQueue;
        synchronized (queue) {
            do {
                this.tmpBuffer.clear();
                object = this.internalChannel.read(this.tmpBuffer);
                this.tmpBuffer.flip();
                if (object == false) break;
                DelayableUDPPacketChannel$Packet delayableUDPPacketChannel$Packet = new DelayableUDPPacketChannel$Packet(this.tmpBuffer, System.currentTimeMillis() + (long)this.msDelay);
                this.readPacketQueue.add(delayableUDPPacketChannel$Packet);
            } while (true);
        }
    }

    private synchronized void updateDelayThread() {
        if (this.msDelay > 0 && this.delayThread == null) {
            this.delayThread = new Thread(this.delayRunnable);
            this.delayThread.start();
        }
        if (this.msDelay <= 0 && this.delayThread != null) {
            this.delayThread = null;
        }
    }

    public DelayableUDPPacketChannel(PacketChannel packetChannel, int n) {
        this.readPacketQueue = new LinkedList();
        this.tmpBuffer = ByteBuffer.allocate(1048576);
        this.delayRunnable = new DelayableUDPPacketChannel$1(this);
        this.internalChannel = packetChannel;
        this.msDelay = n;
        this.updateDelayThread();
    }

    @Override
    public void write(ByteBuffer byteBuffer) throws IOException {
        this.bytesWritten += byteBuffer.remaining();
        Queue queue = this.writtenPacketQueue;
        synchronized (queue) {
            DelayableUDPPacketChannel$Packet delayableUDPPacketChannel$Packet = new DelayableUDPPacketChannel$Packet(byteBuffer, System.currentTimeMillis() + (long)this.msDelay);
            this.writtenPacketQueue.add(delayableUDPPacketChannel$Packet);
            if (this.msDelay > 0) {
                this.process();
            }
        }
    }

    @Override
    public int read(ByteBuffer byteBuffer) throws IOException {
        Queue queue = this.readPacketQueue;
        synchronized (queue) {
            if (this.msDelay <= 0) {
                this.process();
            }
            if (this.readPacketQueue.isEmpty()) {
                return 0;
            }
            DelayableUDPPacketChannel$Packet delayableUDPPacketChannel$Packet = (DelayableUDPPacketChannel$Packet)this.readPacketQueue.element();
            if (this.msDelay > 0 && System.currentTimeMillis() < delayableUDPPacketChannel$Packet.firingTime) {
                return 0;
            }
            byteBuffer.put(delayableUDPPacketChannel$Packet.buf);
            this.readPacketQueue.remove();
            int n = delayableUDPPacketChannel$Packet.buf.limit();
            this.bytesRead += n;
            return n;
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

    @Override
    public int getWrittenByteCount() {
        return this.bytesWritten;
    }

    @Override
    public boolean canWrite() {
        return this.internalChannel.canWrite();
    }
}

