// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

class Ei604 extends Dm448
{
    String d;
    long g;
    int q;
    final /* synthetic */ Dg449 j;
    
    @Override
    void g(final Gg3 gg3) {
        if (Gg3.ar(gg3) != 255) {
            --gg3.v;
            this.g = Gg3.bq(gg3);
        }
        this.d = Gg3.bj(gg3);
        this.q = Gg3.au(gg3);
        if (Ef450.g) {
            System.out.println("memberhash:" + this.g + " membername:" + this.d);
        }
    }
    
    Ei604(final Dg449 j, final long g, final String d, final int q) {
        this.j = j;
        this.g = -1L;
        this.d = null;
        this.q = 0;
        this.g = g;
        this.d = d;
        this.q = q;
    }
    
    @Override
    void d(final Ef450 ef450) {
        ef450.q(this.g, this.d, this.q);
    }
    
    Ei604(final Dg449 j) {
        this.j = j;
        this.g = -1L;
        this.d = null;
        this.q = 0;
    }
}
