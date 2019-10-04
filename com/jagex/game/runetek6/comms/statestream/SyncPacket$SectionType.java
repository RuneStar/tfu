// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

public enum SyncPacket$SectionType
{
    DELTA("DELTA", 0, (byte)1), 
    ERROR("ERROR", 2, (byte)3), 
    PACKET_ACKNOWLEDGE("PACKET_ACKNOWLEDGE", 1, (byte)2), 
    RESET("RESET", 3, (byte)4);
    
    public final byte id;
    
    private SyncPacket$SectionType(final String name, final int ordinal, final byte id) {
        this.id = id;
    }
    
    public static SyncPacket$SectionType getByID(final byte b) {
        for (final SyncPacket$SectionType syncPacket$SectionType : values()) {
            if (syncPacket$SectionType.id == b) {
                return syncPacket$SectionType;
            }
        }
        return null;
    }
}
