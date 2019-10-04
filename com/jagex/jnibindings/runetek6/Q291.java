// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.PhantomReference;

class Q291 extends PhantomReference
{
    private final int g;
    
    public Q291(final LuaRef referent, final int g) {
        super(referent, Scripting.j);
        this.g = g;
    }
    
    public static int g(final Q291 q291) {
        return q291.g;
    }
}
