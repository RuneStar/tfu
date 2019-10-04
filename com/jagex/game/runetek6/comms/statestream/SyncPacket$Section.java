/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import com.jagex.game.runetek6.comms.statestream.SyncPacket$SectionType;
import java.nio.ByteBuffer;

abstract class SyncPacket$Section
implements Comparable {
    public abstract int getBodySize();

    public abstract String toStringForDebug();

    public abstract void writeBody(ByteBuffer var1);

    public abstract SyncPacket$SectionType getType();

    SyncPacket$Section() {
    }
}

