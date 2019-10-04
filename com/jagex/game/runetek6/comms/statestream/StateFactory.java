// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.statestream;

import java.nio.ByteBuffer;

public interface StateFactory
{
    void generateDeltaPacket(final State p0, final State p1, final ByteBuffer p2);
    
    State createBaseState();
    
    State applyDeltaPacket(final State p0, final ByteBuffer p1);
    
    State duplicateState(final State p0);
}
