// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.js5;

public abstract class S136
{
    protected abstract H362 d();
    
    protected abstract byte[] q(final int p0);
    
    protected abstract int w(final int p0);
    
    public int g() {
        return 100;
    }
    
    public static int i(final S136 s136) {
        if (s136.d() == null) {
            return 0;
        }
        return s136.d().e;
    }
    
    public abstract int b();
    
    public abstract int s();
}
