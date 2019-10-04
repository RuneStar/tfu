/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import com.jagex.game.runetek6.comms.statestream.CircularIDWidth;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import com.jagex.game.runetek6.comms.statestream.SyncPacket$Section;
import com.jagex.game.runetek6.comms.statestream.SyncPacket$SectionType;
import java.nio.ByteBuffer;

class SyncPacket$DeltaSection
extends SyncPacket$Section {
    public final long addedTime;
    public final byte[] deltaPacket;
    public final byte filterGroup;
    public final int sourceStateID;
    public final Class stateType;
    public final int targetStateID;
    public final int timestamp;

    SyncPacket$DeltaSection(Class class_, int n, int n2, int n3, byte by, byte[] arrby, long l) {
        this.stateType = class_;
        this.sourceStateID = n;
        this.targetStateID = n2;
        this.timestamp = n3;
        this.deltaPacket = arrby;
        this.filterGroup = by;
        this.addedTime = l;
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
        } else {
            n += 4;
            n += LossyStateStream.TIMESTAMP_WIDTH.bytes;
        }
        return n;
    }

    public String toString() {
        return "DELTA: " + this.sourceStateID + " -> " + this.targetStateID + " @ " + this.timestamp;
    }

    SyncPacket$DeltaSection(ByteBuffer byteBuffer) {
        this.stateType = null;
        this.sourceStateID = LossyStateStream.STATE_ID_WIDTH.getID(byteBuffer);
        this.targetStateID = LossyStateStream.STATE_ID_WIDTH.getID(byteBuffer);
        this.filterGroup = byteBuffer.get();
        int n = byteBuffer.getInt();
        if (n < 0) {
            n = -n;
            this.timestamp = -1;
        } else {
            this.timestamp = LossyStateStream.TIMESTAMP_WIDTH.getID(byteBuffer);
        }
        this.deltaPacket = new byte[n];
        byteBuffer.get(this.deltaPacket);
        this.addedTime = byteBuffer.getLong();
    }

    public int compareTo(SyncPacket$DeltaSection syncPacket$DeltaSection) {
        return this.timestamp - syncPacket$DeltaSection.timestamp;
    }

    @Override
    public String toStringForDebug() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.stateType != null) {
            stringBuilder.append("State Type: " + this.stateType.getSimpleName() + "\n");
        }
        stringBuilder.append("SourceState ID: " + this.sourceStateID + "\n");
        stringBuilder.append("TargetState ID: " + this.targetStateID + "\n");
        stringBuilder.append("Timestamp: " + this.timestamp + "\n");
        stringBuilder.append("Delta Length: " + this.deltaPacket.length + "\n");
        return stringBuilder.toString();
    }

    @Override
    public void writeBody(ByteBuffer byteBuffer) {
        LossyStateStream.STATE_ID_WIDTH.putID(this.sourceStateID, byteBuffer);
        LossyStateStream.STATE_ID_WIDTH.putID(this.targetStateID, byteBuffer);
        byteBuffer.put(this.filterGroup);
        if (this.timestamp == -1) {
            byteBuffer.putInt(-this.deltaPacket.length);
        } else {
            byteBuffer.putInt(this.deltaPacket.length);
            LossyStateStream.TIMESTAMP_WIDTH.putID(this.timestamp, byteBuffer);
        }
        byteBuffer.put(this.deltaPacket);
        byteBuffer.putLong(this.addedTime);
    }
}

