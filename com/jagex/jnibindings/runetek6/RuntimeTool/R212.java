/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.RuntimeTool.RuntimeTool;
import com.jagex.jnibindings.runetek6.StateManager;

class R212 {
    public String d;
    public long g;
    final /* synthetic */ RuntimeTool q;

    public String toString() {
        if (StateManager.isActive(this.g)) {
            return this.d;
        }
        return this.d;
    }

    public R212(RuntimeTool runtimeTool, long l) {
        this.q = runtimeTool;
        this.g = l;
        this.d = StateManager.getStateId(this.g);
    }
}

