package com.jagex.game.runetek6.event;

import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.jnibindings.runetek6.LuaFunctionRef;
import com.jagex.jnibindings.runetek6.Scripting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ao128;
import tfu.Jy122;

public class ScriptEventHandler extends EventHandler {
   private static final Logger logger = LoggerFactory.getLogger(ScriptEventHandler.class);
   private final Object[] arguments;
   private final LuaFunctionRef function;
   private final ScriptManager scriptManager;

   public ScriptEventHandler(ScriptManager var1, LuaFunctionRef var2, Object[] var3) {
      if (var1 == null) {
         throw new IllegalArgumentException("Null ScriptManager instance.");
      } else if (var2 == null) {
         throw new IllegalArgumentException("Null Lua function reference.");
      } else {
         this.scriptManager = var1;
         this.function = var2;
         this.arguments = var3;
         ++ScriptManager.totalHandlersCreated;
      }
   }

   public void finalize() {
      ++ScriptManager.totalHandlersDestroyed;
   }

   public static ScriptEventHandler createScriptEventHandler(ScriptManager var0, LuaFunctionRef var1, Object[] var2) {
      if (var0 == null) {
         throw new IllegalArgumentException("Null ScriptManager instance.");
      } else if (var1 == null) {
         throw new IllegalArgumentException("Null Lua function reference.");
      } else if (!Scripting.checkLuaFunction(var0.getScriptManagerNativeRef(), var0.getLuaStateNativeRef(), LuaFunctionRef.g(var1))) {
         throw new RuntimeException(String.format("Lua function ref '%d' is undefined", LuaFunctionRef.g(var1)));
      } else {
         ScriptEventHandler var3 = new ScriptEventHandler(var0, var1, var2);
         return var3;
      }
   }

   public void trigger(Object var1, Object var2) {
      String var3;
      if (this.scriptManager.getThread() != Thread.currentThread()) {
         var3 = "ScriptEventHandler.trigger() called from " + Thread.currentThread() + " - main thread is " + this.scriptManager.getThread();
         logger.error(var3, new Ao128());
         throw new IllegalStateException(var3);
      } else if (this.function == null) {
         throw new RuntimeException("Cannot trigger event handler with no attached Lua function");
      } else {
         var3 = "";
         ScriptEventHandler$Zones.TriggerScriptEvent.start();

         try {
            try {
               if (Jy122.g(ScriptManager.calltrace)) {
                  Jy122.h(ScriptManager.calltrace, "J>L: calling handler " + this.function);
               }

               Object[] var4 = null;
               if (var2 != null) {
                  Class var5 = var2.getClass();
                  if (!var5.isArray()) {
                     var4 = new Object[]{var2};
                  } else {
                     if (var5.getComponentType().isPrimitive()) {
                        throw new RuntimeException("Cannot pass primitive arrays as payload.");
                     }

                     var4 = (Object[])((Object[])var2);
                  }
               }

               Scripting.callLuaFunction(this.scriptManager.getScriptManagerNativeRef(), this.scriptManager.getLuaStateNativeRef(), LuaFunctionRef.g(this.function), LuaFunctionRef.j(this.function), this.arguments, var1, var1 != null ? Scripting.getClassName(var1) : "", var4, 0);
               ++ScriptManager.totalHandlersTriggered;
            } catch (Throwable var16) {
               logger.error("", var16);
               var3 = ": **EXCEPTION:** " + var16;

               try {
                  if (Jy122.g(ScriptManager.calltrace)) {
                     Jy122.l(ScriptManager.calltrace, "END" + var3);
                  }
               } catch (Exception var14) {
                  logger.error("{}", var14);
               }

               ScriptEventHandler$Zones.TriggerScriptEvent.stop();
               return;
            }

            try {
               if (Jy122.g(ScriptManager.calltrace)) {
                  Jy122.l(ScriptManager.calltrace, "END" + var3);
               }
            } catch (Exception var15) {
               logger.error("{}", var15);
            }

            ScriptEventHandler$Zones.TriggerScriptEvent.stop();
         } finally {
            try {
               if (Jy122.g(ScriptManager.calltrace)) {
                  Jy122.l(ScriptManager.calltrace, "END" + var3);
               }
            } catch (Exception var13) {
               logger.error("{}", var13);
            }

            ScriptEventHandler$Zones.TriggerScriptEvent.stop();
         }
      }
   }
}
