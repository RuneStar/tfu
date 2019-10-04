/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.Iterator;
import tfu.Je530;

final class Jw531
implements Iterable {
    final /* synthetic */ Iterator d;
    final /* synthetic */ Iterator g;

    Jw531(Iterator iterator, Iterator iterator2) {
        this.d = iterator2;
        this.g = iterator;
    }

    public Iterator iterator() {
        return new Je530(this);
    }
}

