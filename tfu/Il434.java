/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import tfu.Be2;
import tfu.Bs1;
import tfu.Hm417;
import tfu.Hp62;
import tfu.Hz419;

@Bs1
@Be2
class Il434
extends WeakReference {
    final Hz419 d;
    ArrayList e;
    final Hm417 g;
    boolean j;
    int q;
    SoftReference softRef;

    Il434(Hp62 hp62, ReferenceQueue referenceQueue, Hm417 hm417, Hz419 hz419) {
        super(hp62, referenceQueue);
        this.g = hm417;
        this.d = hz419;
    }
}

