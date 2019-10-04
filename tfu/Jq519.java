/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import tfu.Jg365;

class Jq519
implements Iterator {
    private int d;
    private int g;
    final /* synthetic */ Jg365 q;

    Jq519(Jg365 jg365) {
        this.q = jg365;
        this.g = this.q.j;
        this.d = this.q.q;
    }

    @Override
    public boolean hasNext() {
        if (this.q.j != this.g) {
            throw new ConcurrentModificationException();
        }
        return this.d != this.q.d;
    }

    public Object next() {
        if (this.q.j != this.g) {
            throw new ConcurrentModificationException();
        }
        if (this.d == this.q.d) {
            throw new NoSuchElementException();
        }
        this.d = this.d - 1 & this.q.g.length - 1;
        return this.q.g[this.d];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

