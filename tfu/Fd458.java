/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class Fd458
extends WeakReference {
    Object d;
    final int g;
    Fd458 q;

    Fd458(Object object, ReferenceQueue referenceQueue, int n, Object object2) {
        super(object, referenceQueue);
        this.g = n;
        this.d = object2;
    }
}

