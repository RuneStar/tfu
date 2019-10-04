// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

class Dy619 extends Dm448
{
    int d;
    int g;
    int j;
    int q;
    final /* synthetic */ Dg449 e;
    
    Dy619(final Dg449 e) {
        this.e = e;
        this.g = -1;
    }
    
    @Override
    void g(final Gg3 gg3) {
        this.g = Gg3.au(gg3);
        this.d = Gg3.bd(gg3);
        this.q = Gg3.ar(gg3);
        this.j = Gg3.ar(gg3);
    }
    
    @Override
    void d(final Ef450 ef450) {
        Ef450.w(ef450, this.g, this.d, this.q, this.j);
    }
    
    Dy619(final Dg449 e, final int g, final int d, final int q, final int j) {
        this.e = e;
        this.g = -1;
        this.g = g;
        this.d = d;
        this.q = q;
        this.j = j;
    }
}
