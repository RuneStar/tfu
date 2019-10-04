/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.Iterator;
import tfu.Jc528;

final class Jr529
implements Iterable {
    final /* synthetic */ Iterator d;
    final /* synthetic */ Iterator g;

    public Iterator iterator() {
        return new Jc528(this);
    }

    Jr529(Iterator iterator, Iterator iterator2) {
        this.d = iterator2;
        this.g = iterator;
    }
}

