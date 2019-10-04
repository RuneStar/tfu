package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.event.EventHandler;

public class CommonStateAndEventTypes {
   public static BroadcastStateAndEventsTypes$StateDefinition entityConfigDef = null;
   public static BroadcastStateAndEventsTypes$EventDefinition propertyEventDef = null;

   public static void Init(boolean var0) {
      entityConfigDef = BroadcastStateAndEventsTypes.DeclareStateDefinition("entityconfig", (EventHandler)null, 100);
      if (var0) {
         entityConfigDef.setAutoForwarding(true);
      }

      propertyEventDef = BroadcastStateAndEventsTypes.DeclareEventDefinition("property", (EventHandler)null);
      if (var0) {
         propertyEventDef.setAutoForwarding(true);
      }

   }
}
