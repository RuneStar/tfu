// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

public class Animation
{
    private long g;
    
    public Animation() {
        this(Create());
    }
    
    Animation(final long g) {
        this.g = g;
    }
    
    private static final native long Create();
}
