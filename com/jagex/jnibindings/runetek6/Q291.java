/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

import com.jagex.jnibindings.runetek6.LuaRef;
import com.jagex.jnibindings.runetek6.Scripting;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

class Q291
extends PhantomReference {
    private final int g;

    public Q291(LuaRef luaRef, int n) {
        super(luaRef, Scripting.s());
        this.g = n;
    }

    public static int g(Q291 q291) {
        return q291.g;
    }
}

