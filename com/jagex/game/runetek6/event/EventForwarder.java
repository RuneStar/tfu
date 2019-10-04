package com.jagex.game.runetek6.event;

import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import tfu.Be2;
import tfu.Bs1;

public interface EventForwarder {
   @Be2
   @Bs1
   void triggerEvent(@ScriptID Integer var1, Object var2);

   @Be2
   @Bs1
   void removeAllEventHandlers(@ScriptID Integer var1);

   @Be2
   @Bs1
   void removeEventHandler(String var1, EventHandler var2);

   @Be2
   @Bs1
   void addEventHandlerByID(@ScriptID Integer var1, EventHandler var2);

   @ScriptEntryPoint
   @Be2
   @Bs1
   void addEventHandler(String var1, EventHandler var2);
}
