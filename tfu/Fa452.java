// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class Fa452 extends WeakReference
{
    final Fh453 g;
    
    Fa452(final Object referent, final ReferenceQueue q, final Fh453 g) {
        super(referent, q);
        this.g = g;
    }
}
