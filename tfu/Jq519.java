// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

class Jq519 implements Iterator
{
    private int d;
    private int g;
    final /* synthetic */ Jg365 q;
    
    Jq519(final Jg365 q) {
        this.q = q;
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
    
    @Override
    public Object next() {
        if (this.q.j != this.g) {
            throw new ConcurrentModificationException();
        }
        if (this.d == this.q.d) {
            throw new NoSuchElementException();
        }
        this.d = (this.d - 1 & this.q.g.length - 1);
        return this.q.g[this.d];
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
