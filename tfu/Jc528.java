/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.Iterator;
import tfu.Jk523;
import tfu.Jr529;

class Jc528
implements Iterator {
    final /* synthetic */ Jr529 g;

    @Override
    public boolean hasNext() {
        return this.g.g.hasNext() && this.g.d.hasNext();
    }

    public Jk523 g() {
        return new Jk523(this.g.g.next(), this.g.d.next());
    }

    @Override
    public synchronized void remove() {
        this.g.g.remove();
        this.g.d.remove();
    }

    Jc528(Jr529 jr529) {
        this.g = jr529;
    }
}

