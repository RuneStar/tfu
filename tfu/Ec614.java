// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

class Ec614 extends Dm448
{
    String d;
    long g;
    final /* synthetic */ Dg449 q;
    
    @Override
    void d(final Ef450 ef450) {
        ef450.q(this.g, this.d, 0);
    }
    
    Ec614(final Dg449 q, final long g, final String d) {
        this.q = q;
        this.g = -1L;
        this.d = null;
        this.g = g;
        this.d = d;
    }
    
    @Override
    void g(final Gg3 gg3) {
        if (Gg3.ar(gg3) != 255) {
            --gg3.v;
            this.g = Gg3.bq(gg3);
        }
        this.d = Gg3.bj(gg3);
        if (Ef450.g) {
            System.out.println("memberhash:" + this.g + " membername:" + this.d);
        }
    }
    
    Ec614(final Dg449 q) {
        this.q = q;
        this.g = -1L;
        this.d = null;
    }
}
