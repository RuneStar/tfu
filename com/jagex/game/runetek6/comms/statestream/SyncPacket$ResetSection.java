// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

import java.nio.ByteBuffer;

class SyncPacket$ResetSection extends SyncPacket$Section
{
    SyncPacket$ResetSection(final ByteBuffer byteBuffer) {
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
    public void writeBody(final ByteBuffer byteBuffer) {
    }
    
    @Override
    public String toString() {
        return "ResetSection";
    }
    
    public int compareTo(final SyncPacket$ResetSection syncPacket$ResetSection) {
        return 0;
    }
    
    @Override
    public String toStringForDebug() {
        return "ResetSection";
    }
    
    SyncPacket$ResetSection() {
    }
}
