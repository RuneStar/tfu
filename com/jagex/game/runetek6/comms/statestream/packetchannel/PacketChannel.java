package com.jagex.game.runetek6.comms.statestream.packetchannel;

import java.io.IOException;
import java.nio.ByteBuffer;

public interface PacketChannel {
   int getReadByteCount();

   int read(ByteBuffer var1) throws IOException;

   boolean canWrite();

   void resetByteCounts();

   int getWrittenByteCount();

   void write(ByteBuffer var1) throws IOException;
}
