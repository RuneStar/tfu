// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.StateManager;

class R212
{
    public String d;
    public long g;
    final /* synthetic */ RuntimeTool q;
    
    @Override
    public String toString() {
        if (StateManager.isActive(this.g)) {
            return this.d;
        }
        return this.d;
    }
    
    public R212(final RuntimeTool q, final long g) {
        this.q = q;
        this.g = g;
        this.d = StateManager.getStateId(this.g);
    }
}
