package com.jagex.game.runetek6.comms.statestream;

public class StateWrapper {
   public final byte filterGroup;
   public final State state;
   public final int timestamp;
   public final int uniqueID;

   public String toString() {
      return "StateWrapper(id=" + this.uniqueID + ";ts=" + this.timestamp + ";\"" + this.state.toString() + "\")";
   }

   public StateWrapper(State var1, int var2, int var3, byte var4) {
      this.state = var1;
      this.uniqueID = var2;
      this.timestamp = var3;
      this.filterGroup = var4;
   }
}
