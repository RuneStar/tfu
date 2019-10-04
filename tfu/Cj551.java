// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Cj551 extends Cw634
{
    public byte[] e;
    
    public Cj551(final int g, final byte[] e, final int d, final int q) {
        super.g = g;
        this.e = e;
        super.d = d;
        super.q = q;
    }
    
    @Override
    public int g() {
        return this.e.length;
    }
    
    public Cv549 b(final int n, final int n2, final int n3) {
        if (this.e == null || this.e.length == 0) {
            return null;
        }
        return new Cv549(this, n, n2, n3);
    }
    
    public Cj551(final int g, final int q) {
        super.g = g;
        this.e = new byte[q];
        super.d = 0;
        super.q = q;
    }
    
    public Cj551(final int g, final byte[] e, final int d, final int q, final boolean j) {
        super.g = g;
        this.e = e;
        super.d = d;
        super.q = q;
        super.j = j;
    }
}
