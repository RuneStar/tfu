/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import tfu.Jg365;

class Jf518
implements Iterator {
    private int d;
    private int g;
    final /* synthetic */ Jg365 q;

    Jf518(Jg365 jg365) {
        this.q = jg365;
        this.g = this.q.j;
        this.d = this.q.d;
    }

    @Override
    public boolean hasNext() {
        if (this.q.j != this.g) {
            throw new ConcurrentModificationException();
        }
        return this.d != this.q.q;
    }

    public Object next() {
        if (this.q.j != this.g) {
            throw new ConcurrentModificationException();
        }
        if (this.d == this.q.q) {
            throw new NoSuchElementException();
        }
        Object object = this.q.g[this.d];
        this.d = this.d + 1 & this.q.g.length - 1;
        return object;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

