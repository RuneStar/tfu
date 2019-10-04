// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

import java.nio.ByteBuffer;

class SyncPacket$ErrorSection extends SyncPacket$Section
{
    @Override
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
    public void writeBody(final ByteBuffer byteBuffer) {
    }
    
    @Override
    public String toStringForDebug() {
        return "ErrorSection";
    }
    
    public int compareTo(final SyncPacket$ErrorSection syncPacket$ErrorSection) {
        return 0;
    }
    
    SyncPacket$ErrorSection() {
    }
    
    SyncPacket$ErrorSection(final ByteBuffer byteBuffer) {
    }
}
