/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6;

public class Animation {
    private long g;

    public Animation() {
        this(Animation.Create());
    }

    Animation(long l) {
        this.g = l;
    }

    private static final native long Create();
}

