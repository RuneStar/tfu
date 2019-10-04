package com.jagex.game.runetek6.script;

import com.jagex.jnibindings.runetek6.Scripting;
import tfu.Aa129;

class ScriptManager$LuaStackTraceElementProvider implements Aa129 {
   // $FF: synthetic field
   final ScriptManager this$0;

   public String getHeading() {
      return "....Lua Stacktrace....";
   }

   public StackTraceElement[] getElements() {
      return Scripting.getLuaStackTrace(this.this$0.getScriptManagerNativeRef(), this.this$0.getLuaStateNativeRef());
   }

   public ScriptManager$LuaStackTraceElementProvider(ScriptManager var1) {
      this.this$0 = var1;
   }
}
