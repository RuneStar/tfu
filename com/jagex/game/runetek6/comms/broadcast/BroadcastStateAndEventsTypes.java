package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import java.util.HashMap;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass("Broadcast")
public class BroadcastStateAndEventsTypes {
   static HashMap known_message_declarations = new HashMap();

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static BroadcastStateAndEventsTypes$StateDefinition DeclareStateDefinition(String var0, EventHandler var1, int var2) {
      Object var3 = (BroadcastStateAndEventsTypes$MessageDefinition)known_message_declarations.get(var0);
      if (var3 != null) {
         if (!(var3 instanceof BroadcastStateAndEventsTypes$StateDefinition)) {
            throw new RuntimeException("Message type '" + var0 + "' was previously declared, but not as a State definition (is " + var0.getClass() + ")");
         }

         if (((BroadcastStateAndEventsTypes$StateDefinition)var3).ordering != var2) {
            throw new RuntimeException("State '" + var0 + "' was previously declared with a different priority (" + ((BroadcastStateAndEventsTypes$StateDefinition)var3).ordering + ")");
         }

         if (((BroadcastStateAndEventsTypes$StateDefinition)var3).validator != var1) {
            throw new RuntimeException("State '" + var0 + "' was previously declared with a different validation callback");
         }
      } else {
         var3 = new BroadcastStateAndEventsTypes$StateDefinition(var0, false, var1, var2);
         known_message_declarations.put(var0, var3);
      }

      return (BroadcastStateAndEventsTypes$StateDefinition)var3;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetAutoForwarding(BroadcastStateAndEventsTypes$MessageDefinition var0, boolean var1) {
      var0.setAutoForwarding(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static BroadcastStateAndEventsTypes$EventDefinition DeclareEventDefinition(String var0, EventHandler var1) {
      Object var2 = (BroadcastStateAndEventsTypes$MessageDefinition)known_message_declarations.get(var0);
      if (var2 != null) {
         if (!(var2 instanceof BroadcastStateAndEventsTypes$EventDefinition)) {
            throw new RuntimeException("Message type '" + var0 + "' was previously declared, but not as an Event definition (is " + var0.getClass() + ")");
         }

         if (((BroadcastStateAndEventsTypes$EventDefinition)var2).validator != var1) {
            throw new RuntimeException("Event '" + var0 + "' was previously declared with a different validation callback");
         }
      } else {
         var2 = new BroadcastStateAndEventsTypes$EventDefinition(var0, false, var1);
         known_message_declarations.put(var0, var2);
      }

      return (BroadcastStateAndEventsTypes$EventDefinition)var2;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static BroadcastStateAndEventsTypes$StateDefinition GetStateDefinition(String var0) {
      BroadcastStateAndEventsTypes$MessageDefinition var1 = (BroadcastStateAndEventsTypes$MessageDefinition)known_message_declarations.get(var0);
      if (var1 instanceof BroadcastStateAndEventsTypes$StateDefinition) {
         return (BroadcastStateAndEventsTypes$StateDefinition)var1;
      } else if (var1 == null) {
         throw new RuntimeException("Message type '" + var0 + "' has not been declared.  It needs to be declared before use.");
      } else {
         throw new RuntimeException("Message type '" + var0 + "' has been declared, but not as a State definition (is " + var0.getClass() + ")");
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static BroadcastStateAndEventsTypes$EventDefinition GetEventDefinition(String var0) {
      BroadcastStateAndEventsTypes$MessageDefinition var1 = (BroadcastStateAndEventsTypes$MessageDefinition)known_message_declarations.get(var0);
      if (var1 instanceof BroadcastStateAndEventsTypes$EventDefinition) {
         return (BroadcastStateAndEventsTypes$EventDefinition)var1;
      } else if (var1 == null) {
         throw new RuntimeException("Message type '" + var0 + " has not been declared.  It needs to be declared before use.");
      } else {
         throw new RuntimeException("Message type '" + var0 + "' has been declared, but not as an Event definition (is " + var0.getClass() + ")");
      }
   }

   public static BroadcastStateAndEventsTypes$StateDefinition getStateDefinition(String var0) {
      BroadcastStateAndEventsTypes$MessageDefinition var1 = (BroadcastStateAndEventsTypes$MessageDefinition)known_message_declarations.get(var0);
      return var1 instanceof BroadcastStateAndEventsTypes$StateDefinition ? (BroadcastStateAndEventsTypes$StateDefinition)var1 : null;
   }

   public static BroadcastStateAndEventsTypes$EventDefinition getEventDefinition(String var0) {
      BroadcastStateAndEventsTypes$MessageDefinition var1 = (BroadcastStateAndEventsTypes$MessageDefinition)known_message_declarations.get(var0);
      return var1 instanceof BroadcastStateAndEventsTypes$EventDefinition ? (BroadcastStateAndEventsTypes$EventDefinition)var1 : null;
   }
}
