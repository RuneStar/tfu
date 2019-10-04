// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.maths;

import java.util.ArrayList;

public final class T313
{
    public final Vector3 d;
    public final Vector3 g;
    ArrayList j;
    public final Vector3 q;
    
    @Override
    public int hashCode() {
        return System.identityHashCode(this.g) + System.identityHashCode(this.d) + System.identityHashCode(this.q);
    }
    
    @Override
    public boolean equals(final Object o) {
        final T313 t313 = (T313)o;
        return (this.g == t313.g && this.d == t313.d && this.q == t313.q) || (this.g == t313.d && this.d == t313.q && this.q == t313.g) || (this.g == t313.q && this.d == t313.g && this.q == t313.d) || (this.g == t313.g && this.d == t313.q && this.q == t313.d) || (this.g == t313.d && this.d == t313.g && this.q == t313.q) || (this.g == t313.q && this.d == t313.d && this.q == t313.g);
    }
    
    T313(final Vector3 g, final Vector3 d, final Vector3 q) {
        this.g = g;
        this.d = d;
        this.q = q;
    }
}
