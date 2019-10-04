/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

import com.jagex.jnibindings.runetek6.Scripting;
import tfu.Be2;
import tfu.Bs1;

@Bs1
@Be2
public class LuaRef {
    private final int ref;

    @Bs1
    @Be2
    public LuaRef(int n) {
        this.ref = n;
        Scripting.j(this, this.ref);
    }

    public static int g(LuaRef luaRef) {
        return luaRef.ref;
    }
}

