// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

import tfu.Lp301;

public final class E41 implements Lp301
{
    public final float d;
    public final float e;
    public final float g;
    public final float h;
    public final float j;
    public final float q;
    
    @Override
    public Vector3 j() {
        return Vector3.g(this.g, this.d, this.q);
    }
    
    @Override
    public Vector3 e() {
        return Vector3.g(this.j, this.e, this.h);
    }
    
    public E41(final float g, final float d, final float q, final float j, final float e, final float h) {
        this.g = g;
        this.d = d;
        this.q = q;
        this.j = j;
        this.e = e;
        this.h = h;
    }
    
    @Override
    public String toString() {
        return "[Aabb: (" + this.g + "," + this.d + "," + this.q + ")->(" + this.j + "," + this.e + "," + this.h + ")]";
    }
}
