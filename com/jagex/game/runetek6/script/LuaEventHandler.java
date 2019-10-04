package com.jagex.game.runetek6.script;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.event.Event;
import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.event.ScriptEventHandler;
import com.jagex.jnibindings.runetek6.LuaFunctionRef;
import com.jagex.jnibindings.runetek6.StateEventManager;
import java.util.HashMap;
import java.util.Map;
import tfu.Be2;
import tfu.Bs1;
import tfu.Jy122;

public class LuaEventHandler {
   private Map events = new HashMap();

   public EventHandler addEventHandler(String var1, EventHandler var2) {
      return this.addEventHandler(StringTools.l(var1), var2);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public EventHandler addEventHandler(ScriptManager var1, @ScriptID Integer var2, LuaFunctionRef var3) {
      if (var1 == null) {
         throw new IllegalArgumentException("Null ScriptManager instance.");
      } else {
         ScriptEventHandler var4 = new ScriptEventHandler(var1, var3, (Object[])null);
         this.addEventHandler((Integer)var2, var4);
         return var4;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public EventHandler addEventHandlerArgs(ScriptManager var1, @ScriptID Integer var2, LuaFunctionRef var3, Object... var4) {
      if (var1 == null) {
         throw new IllegalArgumentException("Null ScriptManager instance.");
      } else {
         ScriptEventHandler var5 = new ScriptEventHandler(var1, var3, var4);
         this.addEventHandler((Integer)var2, var5);
         return var5;
      }
   }

   public void triggerEvent(Object var1, String var2, Object var3) {
      Jy122.h(ScriptManager.calltrace, "SCRIPTING EVENT: " + var1 + "." + var2 + "(" + var3 + ")");
      this.triggerEvent(var1, StringTools.l(var2), var3);
      Jy122.h(ScriptManager.calltrace, "END");
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public EventHandler addEventHandler(@ScriptID Integer var1, EventHandler var2) {
      Event var3 = (Event)this.events.get(var1);
      if (var3 == null) {
         var3 = new Event();
         this.events.put(var1, var3);
      }

      var3.add(var2);
      ++ScriptManager.totalHandlersActive;
      return var2;
   }

   public boolean hasEvent(String var1) {
      return this.hasEvent(StringTools.l(var1));
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void removeEventHandler(@ScriptID Integer var1, EventHandler var2) {
      Event var3 = (Event)this.events.get(var1);
      if (var3 != null) {
         --ScriptManager.totalHandlersActive;
         var3.remove(var2);
      }

   }

   public void removeEventHandler(String var1, EventHandler var2) {
      this.removeEventHandler(StringTools.l(var1), var2);
   }

   public void triggerEvent(String var1, Object var2) {
      Jy122.h(ScriptManager.calltrace, "SCRIPTING EVENT: " + var1 + "(" + var2 + ")");
      this.triggerEvent(StringTools.l(var1), var2);
      StateEventManager.sendEvent(var1);
      Jy122.l(ScriptManager.calltrace, "END");
   }

   public boolean hasEvent(int var1) {
      return this.events.containsKey(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void triggerEvent(Object var1, @ScriptID Integer var2, Object var3) {
      Event var4 = (Event)this.events.get(var2);
      if (var4 != null) {
         var4.trigger(var1, var3);
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void triggerEvent(@ScriptID Integer var1, Object var2) {
      Event var3 = (Event)this.events.get(var1);
      if (var3 != null) {
         var3.trigger((Object)null, var2);
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void removeAllEventHandlers(@ScriptID Integer var1) {
      Event var2 = (Event)this.events.get(var1);
      if (var2 != null) {
         ScriptManager.totalHandlersActive -= var2.size();
      }

      this.events.remove(var1);
   }
}
