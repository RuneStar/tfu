// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

import tfu.Be2;
import tfu.Bs1;

@Bs1
@Be2
public class LuaFunctionRef extends LuaRef
{
    private final String functionName;
    
    @Bs1
    @Be2
    public LuaFunctionRef(final int n, final String functionName) {
        super(n);
        this.functionName = functionName;
    }
    
    @Bs1
    @Be2
    public LuaFunctionRef(final int n) {
        super(n);
        this.functionName = "";
    }
    
    @Override
    public String toString() {
        return "{ LuaFunctionRef " + LuaRef.g(this) + " }";
    }
    
    public static String j(final LuaFunctionRef luaFunctionRef) {
        if (luaFunctionRef.functionName == null) {
            return "";
        }
        return luaFunctionRef.functionName;
    }
}
