// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.Iterator;

class Je530 implements Iterator
{
    final /* synthetic */ Jw531 g;
    
    @Override
    public synchronized void remove() {
        this.g.g.remove();
        this.g.d.remove();
    }
    
    Je530(final Jw531 g) {
        this.g = g;
    }
    
    public Js343 g() {
        return new Js343(this.g.g.next(), this.g.d.next());
    }
    
    @Override
    public boolean hasNext() {
        return this.g.g.hasNext() && this.g.d.hasNext();
    }
}
