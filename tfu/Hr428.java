// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.Iterator;

public class Hr428 implements Iterator
{
    private Kp349 d;
    private Hn359 g;
    private Kp349 q;
    
    @Override
    public boolean hasNext() {
        return this.d != this.g.g;
    }
    
    public static Kp349 g(final Hr428 hr428) {
        Kp349 d = hr428.d;
        if (d == hr428.g.g) {
            d = null;
            hr428.d = null;
        }
        else {
            hr428.d = d.x;
        }
        return hr428.q = d;
    }
    
    @Override
    public void remove() {
        if (this.q == null) {
            throw new IllegalStateException();
        }
        Kp349.t(this.q);
        this.q = null;
    }
    
    public Hr428(final Hn359 g) {
        this.q = null;
        this.g = g;
        this.d = this.g.g.x;
        this.q = null;
    }
}
