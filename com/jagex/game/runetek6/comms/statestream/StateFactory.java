package com.jagex.game.runetek6.comms.statestream;

import java.nio.ByteBuffer;

public interface StateFactory {
   void generateDeltaPacket(State var1, State var2, ByteBuffer var3);

   State createBaseState();

   State applyDeltaPacket(State var1, ByteBuffer var2);

   State duplicateState(State var1);
}
