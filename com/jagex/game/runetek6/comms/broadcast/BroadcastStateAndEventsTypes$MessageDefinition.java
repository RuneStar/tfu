package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.event.EventHandler;

public class BroadcastStateAndEventsTypes$MessageDefinition {
   protected boolean autoForward;
   public final String messageName;
   protected final EventHandler validator;

   public boolean getAutoForwarding() {
      return this.autoForward;
   }

   public int hashCode() {
      return this.messageName.hashCode();
   }

   public boolean equals(Object var1) {
      return this.messageName.equals(((BroadcastStateAndEventsTypes$MessageDefinition)var1).messageName);
   }

   public void setAutoForwarding(boolean var1) {
      this.autoForward = var1;
   }

   public String toString() {
      return "(" + this.messageName + ")";
   }

   public BroadcastStateAndEventsTypes$MessageDefinition(String var1, boolean var2, EventHandler var3) {
      this.messageName = var1;
      this.validator = var3;
      this.autoForward = var2;
   }
}
