// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Dx616 extends Eg572
{
    public int d;
    public int g;
    public long q;
    final /* synthetic */ Ee573 j;
    
    Dx616(final Ee573 j, final int g, final int d, final long q) {
        this.j = j;
        this.g = -1;
        this.g = g;
        this.d = d;
        this.q = q;
    }
    
    Dx616(final Ee573 j) {
        this.j = j;
        this.g = -1;
    }
    
    @Override
    void g(final Gg3 gg3) {
        this.g = Gg3.au(gg3);
        this.d = Gg3.ar(gg3);
        if (Gg3.ar(gg3) != 255) {
            --gg3.v;
            this.q = Gg3.bq(gg3);
        }
    }
    
    @Override
    void d(final Dr574 dr574) {
        Dr574.q(dr574, this.g);
    }
}
