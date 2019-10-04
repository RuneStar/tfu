// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class Fd458 extends WeakReference
{
    Object d;
    final int g;
    Fd458 q;
    
    Fd458(final Object referent, final ReferenceQueue q, final int g, final Object d) {
        super(referent, q);
        this.g = g;
        this.d = d;
    }
}
