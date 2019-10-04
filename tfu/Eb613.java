// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

class Eb613 extends Dm448
{
    String d;
    int g;
    final /* synthetic */ Dg449 q;
    
    Eb613(final Dg449 q, final int g, final String d) {
        this.q = q;
        this.g = g;
        this.d = d;
    }
    
    @Override
    void g(final Gg3 gg3) {
        this.g = Gg3.bd(gg3);
        this.d = Gg3.bk(gg3);
    }
    
    @Override
    void d(final Ef450 ef450) {
        ef450.p(this.g, this.d);
    }
    
    Eb613(final Dg449 q) {
        this.q = q;
    }
}
