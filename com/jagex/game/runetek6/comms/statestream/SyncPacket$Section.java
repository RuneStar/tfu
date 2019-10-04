// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

import java.nio.ByteBuffer;

abstract class SyncPacket$Section implements Comparable
{
    public abstract int getBodySize();
    
    public abstract String toStringForDebug();
    
    public abstract void writeBody(final ByteBuffer p0);
    
    public abstract SyncPacket$SectionType getType();
}
