/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.Iterator;
import tfu.Js343;
import tfu.Jw531;

class Je530
implements Iterator {
    final /* synthetic */ Jw531 g;

    @Override
    public synchronized void remove() {
        this.g.g.remove();
        this.g.d.remove();
    }

    Je530(Jw531 jw531) {
        this.g = jw531;
    }

    public Js343 g() {
        return new Js343(this.g.g.next(), this.g.d.next());
    }

    @Override
    public boolean hasNext() {
        return this.g.g.hasNext() && this.g.d.hasNext();
    }
}

