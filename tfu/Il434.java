// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@Bs1
@Be2
class Il434 extends WeakReference
{
    final Hz419 d;
    ArrayList e;
    final Hm417 g;
    boolean j;
    int q;
    SoftReference softRef;
    
    Il434(final Hp62 referent, final ReferenceQueue q, final Hm417 g, final Hz419 d) {
        super(referent, q);
        this.g = g;
        this.d = d;
    }
}
