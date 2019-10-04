// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

final class A307
{
    private float d;
    private final Vector3[] g;
    private P308 j;
    private float[] q;
    
    static void d(final A307 a307, final int n, final Vector3 vector3) {
        a307.g[n] = vector3;
        g(a307);
    }
    
    private static void g(final A307 a307) {
        a307.d = -1.0f;
        a307.q = null;
        a307.j = null;
    }
    
    A307() {
        this.g = new Vector3[4];
        g(this);
    }
    
    static Vector3 q(final A307 a307, final int n) {
        return a307.g[n];
    }
}
