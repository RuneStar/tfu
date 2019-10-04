// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

class LossyStateStreamSynchronizer$SentPacket
{
    public final SyncPacket packet;
    public final long sentTime;
    
    public LossyStateStreamSynchronizer$SentPacket(final SyncPacket packet, final long sentTime) {
        this.packet = packet;
        this.sentTime = sentTime;
    }
}
