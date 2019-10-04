/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

public enum SyncPacket$SectionType {
    DELTA(1),
    PACKET_ACKNOWLEDGE(2),
    ERROR(3),
    RESET(4);
    
    public final byte id;

    private SyncPacket$SectionType(byte by) {
        this.id = by;
    }

    public static SyncPacket$SectionType getByID(byte by) {
        for (SyncPacket$SectionType syncPacket$SectionType : SyncPacket$SectionType.values()) {
            if (syncPacket$SectionType.id != by) continue;
            return syncPacket$SectionType;
        }
        return null;
    }
}

