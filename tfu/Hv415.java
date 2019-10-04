// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.Iterator;

public class Hv415 implements Iterator
{
    private Ln265 d;
    private Ha262 g;
    private Ln265 j;
    private int q;
    
    public static Ln265 j(final Hv415 hv415) {
        if (hv415.d != hv415.g.d[hv415.q - 1]) {
            final Ln265 d = hv415.d;
            hv415.d = d.bo;
            return hv415.j = d;
        }
        while (hv415.q < hv415.g.g) {
            final Ln265 bo = hv415.g.d[hv415.q++].bo;
            if (bo != hv415.g.d[hv415.q - 1]) {
                hv415.d = bo.bo;
                return hv415.j = bo;
            }
        }
        return null;
    }
    
    @Override
    public boolean hasNext() {
        if (this.d != this.g.d[this.q - 1]) {
            return true;
        }
        while (this.q < this.g.g) {
            if (this.g.d[this.q++].bo != this.g.d[this.q - 1]) {
                this.d = this.g.d[this.q - 1].bo;
                return true;
            }
            this.d = this.g.d[this.q - 1];
        }
        return false;
    }
    
    public Hv415(final Ha262 g) {
        this.j = null;
        this.g = g;
        g(this);
    }
    
    public static void g(final Hv415 hv415) {
        hv415.d = hv415.g.d[0].bo;
        hv415.q = 1;
        hv415.j = null;
    }
    
    @Override
    public void remove() {
        if (this.j == null) {
            throw new IllegalStateException();
        }
        Ln265.ef(this.j);
        this.j = null;
    }
}
