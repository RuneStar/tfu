package com.jagex.game.runetek6.comms.statestream.packetchannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.LinkedList;
import java.util.List;

public class UDPPacketChannelClient implements PacketChannel {
   int bytesRead = 0;
   int bytesWritten = 0;
   final DatagramChannel channel;
   final List pushedBackPackets = new LinkedList();

   public int getWrittenByteCount() {
      return this.bytesWritten;
   }

   public void write(ByteBuffer var1) throws IOException {
      this.bytesWritten += var1.remaining();
      this.channel.write(var1);
   }

   public void close() {
      try {
         this.channel.close();
      } catch (IOException var2) {
      }

   }

   public void resetByteCounts() {
      this.bytesWritten = this.bytesRead = 0;
   }

   public int getReadByteCount() {
      return this.bytesRead;
   }

   public void pushBackPacket(byte[] var1) {
      this.pushedBackPackets.add(var1);
   }

   public boolean canWrite() {
      return this.channel.isConnected();
   }

   public UDPPacketChannelClient(DatagramChannel var1) {
      this.channel = var1;
   }

   public int read(ByteBuffer var1) throws IOException {
      if (this.pushedBackPackets.isEmpty()) {
         int var3 = this.channel.read(var1);
         this.bytesRead += var3;
         return var3;
      } else {
         byte[] var2 = (byte[])this.pushedBackPackets.remove(0);
         var1.put(var2);
         return var2.length;
      }
   }
}
