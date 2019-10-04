// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

class Eh618 extends Dm448
{
    byte d;
    int g;
    final /* synthetic */ Dg449 q;
    
    Eh618(final Dg449 q, final int g, final byte d) {
        this.q = q;
        this.g = -1;
        this.g = g;
        this.d = d;
    }
    
    Eh618(final Dg449 q) {
        this.q = q;
        this.g = -1;
    }
    
    @Override
    void g(final Gg3 gg3) {
        this.g = Gg3.au(gg3);
        this.d = Gg3.ax(gg3);
    }
    
    @Override
    void d(final Ef450 ef450) {
        Ef450.b(ef450, this.g, this.d);
    }
}
