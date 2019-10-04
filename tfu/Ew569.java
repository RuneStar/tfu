// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.lang.ref.SoftReference;

class Ew569 extends Fv466
{
    private SoftReference g;
    
    Ew569(final Object referent, final int n) {
        super(n);
        this.g = new SoftReference((T)referent);
    }
    
    @Override
    boolean d() {
        return true;
    }
    
    @Override
    Object g() {
        return this.g.get();
    }
}
