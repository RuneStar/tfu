// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.script;

import com.jagex.jnibindings.runetek6.Scripting;
import tfu.Aa129;

class ScriptManager$LuaStackTraceElementProvider implements Aa129
{
    final /* synthetic */ ScriptManager this$0;
    
    @Override
    public String getHeading() {
        return "....Lua Stacktrace....";
    }
    
    @Override
    public StackTraceElement[] getElements() {
        return Scripting.getLuaStackTrace(this.this$0.getScriptManagerNativeRef(), this.this$0.getLuaStateNativeRef());
    }
    
    public ScriptManager$LuaStackTraceElementProvider(final ScriptManager this$0) {
        this.this$0 = this$0;
    }
}
