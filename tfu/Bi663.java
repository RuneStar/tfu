// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class Bi663 extends WeakReference
{
    Ao128 d;
    final int g;
    
    Bi663(final Bb4 referent, final ReferenceQueue q) {
        super(referent, q);
        this.g = referent.d;
    }
}
