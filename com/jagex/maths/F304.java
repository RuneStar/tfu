// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

import tfu.Gg3;
import tfu.Kl267;

public final class F304 implements Kl267
{
    public float d;
    public float g;
    public float j;
    public float q;
    
    public F304(final V198 v198) {
        d(this, v198);
    }
    
    public static final F304 e(final F304 f304) {
        final float n = 0.0f;
        f304.j = n;
        f304.q = n;
        f304.d = n;
        f304.g = n;
        return f304;
    }
    
    public F304(final Gg3 gg3) {
        this.g = Gg3.bl(gg3);
        this.d = Gg3.bl(gg3);
        this.q = Gg3.bl(gg3);
        this.j = Gg3.bl(gg3);
    }
    
    public static F304 g(final F304 f304, final float g, final float d, final float q, final float j) {
        f304.g = g;
        f304.d = d;
        f304.q = q;
        f304.j = j;
        return f304;
    }
    
    public static F304 d(final F304 f304, final V198 v198) {
        g(f304, v198.d, v198.q, v198.j, v198.e);
        return f304;
    }
    
    public static F304 j(final F304 f304, final F304 f305) {
        g(f304, f305.g, f305.d, f305.q, f305.j);
        return f304;
    }
    
    public F304(final float n, final float n2, final float n3, final float n4) {
        g(this, n, n2, n3, n4);
    }
    
    public static final F304 h(final F304 f304, final Matrix4 matrix4) {
        final float g = f304.g;
        final float d = f304.d;
        final float q = f304.q;
        final float j = f304.j;
        f304.g = matrix4.f00 * g + matrix4.f10 * d + matrix4.f20 * q + matrix4.f30 * j;
        f304.d = matrix4.f01 * g + matrix4.f11 * d + matrix4.f21 * q + matrix4.f31 * j;
        f304.q = matrix4.f02 * g + matrix4.f12 * d + matrix4.f22 * q + matrix4.f32 * j;
        f304.j = matrix4.f03 * g + matrix4.f13 * d + matrix4.f23 * q + matrix4.f33 * j;
        return f304;
    }
    
    @Override
    public String toString() {
        return this.g + "," + this.d + "," + this.q + "," + this.j;
    }
    
    public F304 s() {
        return new F304(this);
    }
    
    public F304() {
        e(this);
    }
    
    public F304(final F304 f304) {
        j(this, f304);
    }
}
