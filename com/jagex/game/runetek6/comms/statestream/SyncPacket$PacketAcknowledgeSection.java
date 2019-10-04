// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

import java.nio.ByteBuffer;

class SyncPacket$PacketAcknowledgeSection extends SyncPacket$Section
{
    public final int packetID;
    
    @Override
    public String toStringForDebug() {
        return this.toString();
    }
    
    @Override
    public void writeBody(final ByteBuffer byteBuffer) {
        LossyStateStreamSynchronizer.PACKET_ID_WIDTH.putID(this.packetID, byteBuffer);
    }
    
    SyncPacket$PacketAcknowledgeSection(final ByteBuffer byteBuffer) {
        this.packetID = LossyStateStreamSynchronizer.PACKET_ID_WIDTH.getID(byteBuffer);
    }
    
    @Override
    public int getBodySize() {
        return LossyStateStreamSynchronizer.PACKET_ID_WIDTH.bytes;
    }
    
    @Override
    public String toString() {
        return "PACKET_ACKNOWLEDGE: " + this.packetID;
    }
    
    public int compareTo(final SyncPacket$PacketAcknowledgeSection syncPacket$PacketAcknowledgeSection) {
        return 0;
    }
    
    @Override
    public SyncPacket$SectionType getType() {
        return SyncPacket$SectionType.PACKET_ACKNOWLEDGE;
    }
    
    SyncPacket$PacketAcknowledgeSection(final int packetID) {
        this.packetID = packetID;
    }
}
