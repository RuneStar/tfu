package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.event.EventHandler;

public class BroadcastStateAndEventsTypes$StateDefinition extends BroadcastStateAndEventsTypes$MessageDefinition implements Comparable {
   public int ordering;

   public boolean equals(Object var1) {
      return super.messageName.equals(((BroadcastStateAndEventsTypes$StateDefinition)var1).messageName) && this.ordering == ((BroadcastStateAndEventsTypes$StateDefinition)var1).ordering;
   }

   public BroadcastStateAndEventsTypes$StateDefinition(String var1, boolean var2, EventHandler var3, int var4) {
      super(var1, var2, var3);
      this.ordering = var4;
   }

   public int compareTo(BroadcastStateAndEventsTypes$StateDefinition var1) {
      int var2 = this.ordering - var1.ordering;
      if (var2 == 0) {
         var2 = super.messageName.compareTo(var1.messageName);
      }

      return var2;
   }

   public String toString() {
      return "(" + super.messageName + "/order=" + this.ordering + ")";
   }
}
