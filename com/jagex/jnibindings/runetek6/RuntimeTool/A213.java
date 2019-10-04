// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.StateManager;

class A213
{
    public String d;
    public long g;
    final /* synthetic */ RuntimeTool q;
    
    public A213(final RuntimeTool q, final long g) {
        this.q = q;
        this.g = g;
        this.d = StateManager.getZoneId(this.g);
        RuntimeTool.logger.debug("constructed new zone object - " + this.d);
    }
    
    @Override
    public String toString() {
        return this.d;
    }
}
