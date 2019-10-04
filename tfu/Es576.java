// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

class Es576 extends Dm448
{
    int d;
    int g;
    int j;
    int q;
    final /* synthetic */ Dg449 e;
    
    Es576(final Dg449 e) {
        this.e = e;
    }
    
    Es576(final Dg449 e, final int g, final int j, final int d, final int q) {
        this.e = e;
        this.g = g;
        this.j = j;
        this.d = d;
        this.q = q;
    }
    
    @Override
    void g(final Gg3 gg3) {
        this.g = Gg3.bd(gg3);
        this.j = Gg3.bd(gg3);
        this.d = Gg3.ar(gg3);
        this.q = Gg3.ar(gg3);
    }
    
    @Override
    void d(final Ef450 ef450) {
        ef450.v(this.g, this.j, this.d, this.q);
    }
}
