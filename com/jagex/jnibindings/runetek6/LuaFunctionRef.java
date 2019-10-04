/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

import com.jagex.jnibindings.runetek6.LuaRef;
import tfu.Be2;
import tfu.Bs1;

@Bs1
@Be2
public class LuaFunctionRef
extends LuaRef {
    private final String functionName;

    @Bs1
    @Be2
    public LuaFunctionRef(int n, String string) {
        super(n);
        this.functionName = string;
    }

    @Bs1
    @Be2
    public LuaFunctionRef(int n) {
        super(n);
        this.functionName = "";
    }

    public String toString() {
        return "{ LuaFunctionRef " + LuaFunctionRef.g(this) + " }";
    }

    public static String j(LuaFunctionRef luaFunctionRef) {
        if (luaFunctionRef.functionName == null) {
            return "";
        }
        return luaFunctionRef.functionName;
    }
}

