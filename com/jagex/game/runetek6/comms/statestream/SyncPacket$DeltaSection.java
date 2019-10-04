// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

import java.nio.ByteBuffer;

class SyncPacket$DeltaSection extends SyncPacket$Section
{
    public final long addedTime;
    public final byte[] deltaPacket;
    public final byte filterGroup;
    public final int sourceStateID;
    public final Class stateType;
    public final int targetStateID;
    public final int timestamp;
    
    SyncPacket$DeltaSection(final Class stateType, final int sourceStateID, final int targetStateID, final int timestamp, final byte filterGroup, final byte[] deltaPacket, final long addedTime) {
        this.stateType = stateType;
        this.sourceStateID = sourceStateID;
        this.targetStateID = targetStateID;
        this.timestamp = timestamp;
        this.deltaPacket = deltaPacket;
        this.filterGroup = filterGroup;
        this.addedTime = addedTime;
    }
    
    @Override
    public SyncPacket$SectionType getType() {
        return SyncPacket$SectionType.DELTA;
    }
    
    @Override
    public int getBodySize() {
        int n = 2 * LossyStateStream.STATE_ID_WIDTH.bytes + 1 + this.deltaPacket.length + 8;
        if (this.timestamp == -1) {
            n += 4;
        }
        else {
            n += 4;
            n += LossyStateStream.TIMESTAMP_WIDTH.bytes;
        }
        return n;
    }
    
    @Override
    public String toString() {
        return "DELTA: " + this.sourceStateID + " -> " + this.targetStateID + " @ " + this.timestamp;
    }
    
    SyncPacket$DeltaSection(final ByteBuffer byteBuffer) {
        this.stateType = null;
        this.sourceStateID = LossyStateStream.STATE_ID_WIDTH.getID(byteBuffer);
        this.targetStateID = LossyStateStream.STATE_ID_WIDTH.getID(byteBuffer);
        this.filterGroup = byteBuffer.get();
        int int1 = byteBuffer.getInt();
        if (int1 < 0) {
            int1 = -int1;
            this.timestamp = -1;
        }
        else {
            this.timestamp = LossyStateStream.TIMESTAMP_WIDTH.getID(byteBuffer);
        }
        byteBuffer.get(this.deltaPacket = new byte[int1]);
        this.addedTime = byteBuffer.getLong();
    }
    
    public int compareTo(final SyncPacket$DeltaSection syncPacket$DeltaSection) {
        return this.timestamp - syncPacket$DeltaSection.timestamp;
    }
    
    @Override
    public String toStringForDebug() {
        final StringBuilder sb = new StringBuilder();
        if (this.stateType != null) {
            sb.append("State Type: " + this.stateType.getSimpleName() + "\n");
        }
        sb.append("SourceState ID: " + this.sourceStateID + "\n");
        sb.append("TargetState ID: " + this.targetStateID + "\n");
        sb.append("Timestamp: " + this.timestamp + "\n");
        sb.append("Delta Length: " + this.deltaPacket.length + "\n");
        return sb.toString();
    }
    
    @Override
    public void writeBody(final ByteBuffer byteBuffer) {
        LossyStateStream.STATE_ID_WIDTH.putID(this.sourceStateID, byteBuffer);
        LossyStateStream.STATE_ID_WIDTH.putID(this.targetStateID, byteBuffer);
        byteBuffer.put(this.filterGroup);
        if (this.timestamp == -1) {
            byteBuffer.putInt(-this.deltaPacket.length);
        }
        else {
            byteBuffer.putInt(this.deltaPacket.length);
            LossyStateStream.TIMESTAMP_WIDTH.putID(this.timestamp, byteBuffer);
        }
        byteBuffer.put(this.deltaPacket);
        byteBuffer.putLong(this.addedTime);
    }
}
