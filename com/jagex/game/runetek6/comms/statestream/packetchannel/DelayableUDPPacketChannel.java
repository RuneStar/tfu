package com.jagex.game.runetek6.comms.statestream.packetchannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DelayableUDPPacketChannel implements PacketChannel {
   private static final Logger logger = LoggerFactory.getLogger(DelayableUDPPacketChannel.class);
   int bytesRead = 0;
   int bytesWritten = 0;
   final Runnable delayRunnable = new DelayableUDPPacketChannel$1(this);
   Thread delayThread = null;
   final PacketChannel internalChannel;
   int msDelay;
   final Queue readPacketQueue = new LinkedList();
   final ByteBuffer tmpBuffer = ByteBuffer.allocate(1048576);
   final Queue writtenPacketQueue = new LinkedList();

   // $FF: synthetic method
   static Logger access$000() {
      return logger;
   }

   public void process() throws IOException {
      if (this.internalChannel.canWrite()) {
         Queue var1 = this.writtenPacketQueue;
         synchronized(var1) {
            while(!this.writtenPacketQueue.isEmpty()) {
               DelayableUDPPacketChannel$Packet var2 = (DelayableUDPPacketChannel$Packet)this.writtenPacketQueue.element();
               if (this.msDelay > 0 && System.currentTimeMillis() < var2.firingTime) {
                  break;
               }

               this.internalChannel.write(var2.buf);
               this.writtenPacketQueue.remove();
            }
         }

         var1 = this.readPacketQueue;
         synchronized(var1) {
            while(true) {
               this.tmpBuffer.clear();
               int var7 = this.internalChannel.read(this.tmpBuffer);
               this.tmpBuffer.flip();
               if (var7 == 0) {
                  return;
               }

               DelayableUDPPacketChannel$Packet var3 = new DelayableUDPPacketChannel$Packet(this.tmpBuffer, System.currentTimeMillis() + (long)this.msDelay);
               this.readPacketQueue.add(var3);
            }
         }
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

   public DelayableUDPPacketChannel(PacketChannel var1, int var2) {
      this.internalChannel = var1;
      this.msDelay = var2;
      this.updateDelayThread();
   }

   public void write(ByteBuffer var1) throws IOException {
      this.bytesWritten += var1.remaining();
      Queue var2 = this.writtenPacketQueue;
      synchronized(var2) {
         DelayableUDPPacketChannel$Packet var3 = new DelayableUDPPacketChannel$Packet(var1, System.currentTimeMillis() + (long)this.msDelay);
         this.writtenPacketQueue.add(var3);
         if (this.msDelay > 0) {
            this.process();
         }

      }
   }

   public int read(ByteBuffer var1) throws IOException {
      Queue var2 = this.readPacketQueue;
      synchronized(var2) {
         if (this.msDelay <= 0) {
            this.process();
         }

         if (this.readPacketQueue.isEmpty()) {
            return 0;
         } else {
            DelayableUDPPacketChannel$Packet var3 = (DelayableUDPPacketChannel$Packet)this.readPacketQueue.element();
            if (this.msDelay > 0 && System.currentTimeMillis() < var3.firingTime) {
               return 0;
            } else {
               var1.put(var3.buf);
               this.readPacketQueue.remove();
               int var4 = var3.buf.limit();
               this.bytesRead += var4;
               return var4;
            }
         }
      }
   }

   public void resetByteCounts() {
      this.bytesWritten = this.bytesRead = 0;
   }

   public int getReadByteCount() {
      return this.bytesRead;
   }

   public int getWrittenByteCount() {
      return this.bytesWritten;
   }

   public boolean canWrite() {
      return this.internalChannel.canWrite();
   }
}
