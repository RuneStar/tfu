/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import com.jagex.game.runetek6.comms.statestream.SyncPacket$Section;
import com.jagex.game.runetek6.comms.statestream.SyncPacket$SectionType;
import java.nio.ByteBuffer;

class SyncPacket$ErrorSection
extends SyncPacket$Section {
    public String toString() {
        return "ErrorSection";
    }

    @Override
    public SyncPacket$SectionType getType() {
        return SyncPacket$SectionType.ERROR;
    }

    @Override
    public int getBodySize() {
        return 0;
    }

    @Override
    public void writeBody(ByteBuffer byteBuffer) {
    }

    @Override
    public String toStringForDebug() {
        return "ErrorSection";
    }

    public int compareTo(SyncPacket$ErrorSection syncPacket$ErrorSection) {
        return 0;
    }

    SyncPacket$ErrorSection() {
    }

    SyncPacket$ErrorSection(ByteBuffer byteBuffer) {
    }
}

