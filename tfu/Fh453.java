// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class Fh453 extends WeakReference
{
    Fa452 d;
    final int g;
    Fh453 q;
    
    Fh453(final Object referent, final ReferenceQueue q, final int g, final Object o, final ReferenceQueue referenceQueue) {
        super(referent, q);
        this.g = g;
        this.g(o, referenceQueue);
    }
    
    void g(final Object o, final ReferenceQueue referenceQueue) {
        this.d = new Fa452(o, referenceQueue, this);
    }
}
