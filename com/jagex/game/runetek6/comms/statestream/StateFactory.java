/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.statestream;

import com.jagex.game.runetek6.comms.statestream.State;
import java.nio.ByteBuffer;

public interface StateFactory {
    public void generateDeltaPacket(State var1, State var2, ByteBuffer var3);

    public State createBaseState();

    public State applyDeltaPacket(State var1, ByteBuffer var2);

    public State duplicateState(State var1);
}

