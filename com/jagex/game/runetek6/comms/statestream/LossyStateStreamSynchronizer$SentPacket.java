/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import com.jagex.game.runetek6.comms.statestream.SyncPacket;

class LossyStateStreamSynchronizer$SentPacket {
    public final SyncPacket packet;
    public final long sentTime;

    public LossyStateStreamSynchronizer$SentPacket(SyncPacket syncPacket, long l) {
        this.packet = syncPacket;
        this.sentTime = l;
    }
}

