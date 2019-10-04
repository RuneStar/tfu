/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import com.jagex.game.runetek6.comms.statestream.SyncPacket$Section;
import com.jagex.game.runetek6.comms.statestream.SyncPacket$SectionType;
import java.nio.ByteBuffer;

class SyncPacket$ResetSection
extends SyncPacket$Section {
    SyncPacket$ResetSection(ByteBuffer byteBuffer) {
    }

    @Override
    public int getBodySize() {
        return 0;
    }

    @Override
    public SyncPacket$SectionType getType() {
        return SyncPacket$SectionType.RESET;
    }

    @Override
    public void writeBody(ByteBuffer byteBuffer) {
    }

    public String toString() {
        return "ResetSection";
    }

    public int compareTo(SyncPacket$ResetSection syncPacket$ResetSection) {
        return 0;
    }

    @Override
    public String toStringForDebug() {
        return "ResetSection";
    }

    SyncPacket$ResetSection() {
    }
}

