package com.jagex.game.runetek6.comms.statestream.packetchannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class NumberingPacketChannel implements PacketChannel {
   private int maxIncomingNumber = -1;
   private int outgoingNumber = 0;
   private ByteBuffer tmpbuf = ByteBuffer.allocate(65536);
   private final PacketChannel underlyingChannel;
   private final List unreceivedNumbers = new LinkedList();

   public boolean canWrite() {
      return this.underlyingChannel.canWrite();
   }

   public int read(ByteBuffer var1) throws IOException {
      if (var1.remaining() + 4 > this.tmpbuf.capacity()) {
         this.tmpbuf = ByteBuffer.allocate(var1.remaining() + 1024);
      }

      this.tmpbuf.clear();
      int var2 = this.underlyingChannel.read(this.tmpbuf);
      if (var2 == 0) {
         return 0;
      } else {
         this.tmpbuf.limit(var2);
         this.tmpbuf.rewind();
         int var3 = this.tmpbuf.getInt();
         var1.put(this.tmpbuf);
         if (var3 > this.maxIncomingNumber) {
            for(int var4 = this.maxIncomingNumber + 1; var4 < var3; ++var4) {
               this.unreceivedNumbers.add(var4);
            }

            this.maxIncomingNumber = var3;
         } else {
            this.unreceivedNumbers.remove(var3);
         }

         return var2 - 4;
      }
   }

   public void write(ByteBuffer var1) throws IOException {
      if (var1.remaining() + 4 > this.tmpbuf.capacity()) {
         this.tmpbuf = ByteBuffer.allocate(var1.remaining() + 1024);
      }

      this.tmpbuf.clear();
      this.tmpbuf.putInt(this.outgoingNumber++);
      this.tmpbuf.put(var1);
      this.tmpbuf.flip();
      this.underlyingChannel.write(this.tmpbuf);
   }

   public int getUnreceivedCount() {
      return this.unreceivedNumbers.size();
   }

   public NumberingPacketChannel(PacketChannel var1) {
      this.underlyingChannel = var1;
   }

   public int getReceivedCount() {
      return this.maxIncomingNumber + 1 - this.unreceivedNumbers.size();
   }

   public void resetByteCounts() {
      this.underlyingChannel.resetByteCounts();
   }

   public int getReadByteCount() {
      return this.underlyingChannel.getReadByteCount();
   }

   public int getWrittenByteCount() {
      return this.underlyingChannel.getWrittenByteCount();
   }
}
