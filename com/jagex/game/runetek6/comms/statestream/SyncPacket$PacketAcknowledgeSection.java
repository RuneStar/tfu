/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import com.jagex.game.runetek6.comms.statestream.CircularIDWidth;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer;
import com.jagex.game.runetek6.comms.statestream.SyncPacket$Section;
import com.jagex.game.runetek6.comms.statestream.SyncPacket$SectionType;
import java.nio.ByteBuffer;

class SyncPacket$PacketAcknowledgeSection
extends SyncPacket$Section {
    public final int packetID;

    @Override
    public String toStringForDebug() {
        return this.toString();
    }

    @Override
    public void writeBody(ByteBuffer byteBuffer) {
        LossyStateStreamSynchronizer.PACKET_ID_WIDTH.putID(this.packetID, byteBuffer);
    }

    SyncPacket$PacketAcknowledgeSection(ByteBuffer byteBuffer) {
        this.packetID = LossyStateStreamSynchronizer.PACKET_ID_WIDTH.getID(byteBuffer);
    }

    @Override
    public int getBodySize() {
        return LossyStateStreamSynchronizer.PACKET_ID_WIDTH.bytes;
    }

    public String toString() {
        return "PACKET_ACKNOWLEDGE: " + this.packetID;
    }

    public int compareTo(SyncPacket$PacketAcknowledgeSection syncPacket$PacketAcknowledgeSection) {
        return 0;
    }

    @Override
    public SyncPacket$SectionType getType() {
        return SyncPacket$SectionType.PACKET_ACKNOWLEDGE;
    }

    SyncPacket$PacketAcknowledgeSection(int n) {
        this.packetID = n;
    }
}

