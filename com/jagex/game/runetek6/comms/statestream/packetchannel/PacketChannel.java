/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream.packetchannel;

import java.io.IOException;
import java.nio.ByteBuffer;

public interface PacketChannel {
    public int getReadByteCount();

    public int read(ByteBuffer var1) throws IOException;

    public boolean canWrite();

    public void resetByteCounts();

    public int getWrittenByteCount();

    public void write(ByteBuffer var1) throws IOException;
}

