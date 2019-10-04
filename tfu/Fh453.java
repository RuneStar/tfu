/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import tfu.Fa452;

class Fh453
extends WeakReference {
    Fa452 d;
    final int g;
    Fh453 q;

    Fh453(Object object, ReferenceQueue referenceQueue, int n, Object object2, ReferenceQueue referenceQueue2) {
        super(object, referenceQueue);
        this.g = n;
        this.g(object2, referenceQueue2);
    }

    void g(Object object, ReferenceQueue referenceQueue) {
        this.d = new Fa452(object, referenceQueue, this);
    }
}

