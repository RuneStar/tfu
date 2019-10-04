// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.jagbullet;

import com.jagex.maths.Vector3;

public class L8
{
    public final Vector3 d;
    public final long g;
    public final float j;
    public final Vector3 q;
    
    public L8(final long g, final Vector3 d, final Vector3 q) {
        this.g = g;
        this.d = d;
        this.q = q;
        this.j = 0.0f;
    }
    
    public L8(final long g, final Vector3 d, final Vector3 q, final float j) {
        this.g = g;
        this.d = d;
        this.q = q;
        this.j = j;
    }
}
