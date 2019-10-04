// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

class Db630 extends Dm448
{
    int g;
    final /* synthetic */ Dg449 d;
    
    Db630(final Dg449 d) {
        this.d = d;
        this.g = -1;
    }
    
    @Override
    void g(final Gg3 gg3) {
        this.g = Gg3.au(gg3);
    }
    
    @Override
    void d(final Ef450 ef450) {
        ef450.j(this.g);
    }
    
    Db630(final Dg449 d, final int g) {
        this.d = d;
        this.g = -1;
        this.g = g;
    }
}
