/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import tfu.Ao128;
import tfu.Bb4;

class Bi663
extends WeakReference {
    Ao128 d;
    final int g;

    Bi663(Bb4 bb4, ReferenceQueue referenceQueue) {
        super(bb4, referenceQueue);
        this.g = bb4.d;
    }
}

