/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.RuntimeTool.RuntimeTool;
import com.jagex.jnibindings.runetek6.StateManager;

class A213 {
    public String d;
    public long g;
    final /* synthetic */ RuntimeTool q;

    public A213(RuntimeTool runtimeTool, long l) {
        this.q = runtimeTool;
        this.g = l;
        this.d = StateManager.getZoneId(this.g);
        RuntimeTool.o().debug("constructed new zone object - " + this.d);
    }

    public String toString() {
        return this.d;
    }
}

