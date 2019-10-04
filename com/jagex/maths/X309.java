// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

public final class X309
{
    public final Vector3 d;
    public final float g;
    
    public static float d(final X309 x309, final float n, final float n2, final float n3) {
        return x309.d.x * n + x309.d.y * n2 + x309.d.z * n3 + x309.g;
    }
    
    public X309(final Vector3 d, final float g) {
        this.d = d;
        this.g = g;
    }
    
    public X309(final float n, final float n2, final float n3, final float g) {
        this.d = new Vector3(n, n2, n3);
        this.g = g;
    }
    
    public X309 g() {
        final float n = 1.0f / Vector3.f(this.d);
        return new X309(Vector3.ai(this.d, n), this.g * n);
    }
    
    public X309() {
        this.d = Vector3.g;
        this.g = 0.0f;
    }
}
