// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream.packetchannel;

import java.io.IOException;
import java.nio.ByteBuffer;

public interface PacketChannel
{
    int getReadByteCount();
    
    int read(final ByteBuffer p0) throws IOException;
    
    boolean canWrite();
    
    void resetByteCounts();
    
    int getWrittenByteCount();
    
    void write(final ByteBuffer p0) throws IOException;
}
