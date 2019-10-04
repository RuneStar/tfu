// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

import tfu.Be2;
import tfu.Bs1;

@Bs1
@Be2
public class LuaRef
{
    private final int ref;
    
    @Bs1
    @Be2
    public LuaRef(final int ref) {
        Scripting.j(this, this.ref = ref);
    }
    
    public static int g(final LuaRef luaRef) {
        return luaRef.ref;
    }
}
