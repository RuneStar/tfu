// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.Iterator;

public class Gr482 implements Iterator
{
    private Ln265 d;
    private Gx298 g;
    private Ln265 q;
    
    public static Ln265 g(final Gr482 gr482) {
        Ln265 d = gr482.d;
        if (d == gr482.g.g) {
            d = null;
            gr482.d = null;
        }
        else {
            gr482.d = d.bo;
        }
        return gr482.q = d;
    }
    
    @Override
    public boolean hasNext() {
        return this.d != this.g.g;
    }
    
    @Override
    public void remove() {
        if (this.q == null) {
            throw new IllegalStateException();
        }
        Ln265.ef(this.q);
        this.q = null;
    }
    
    public Gr482(final Gx298 g) {
        this.q = null;
        this.g = g;
        this.d = this.g.g.bo;
        this.q = null;
    }
}
