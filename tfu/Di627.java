// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

class Di627 extends Dm448
{
    boolean d;
    int g;
    final /* synthetic */ Dg449 q;
    
    Di627(final Dg449 q, final int g, final boolean d) {
        this.q = q;
        this.g = -1;
        this.g = g;
        this.d = d;
    }
    
    @Override
    void g(final Gg3 gg3) {
        this.g = Gg3.au(gg3);
        this.d = (Gg3.ar(gg3) == 1);
    }
    
    Di627(final Dg449 q) {
        this.q = q;
        this.g = -1;
    }
    
    @Override
    void d(final Ef450 ef450) {
        Ef450.l(ef450, this.g, this.d);
    }
}
