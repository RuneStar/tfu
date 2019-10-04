// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

class Da631 extends Dm448
{
    long d;
    int g;
    final /* synthetic */ Dg449 q;
    
    Da631(final Dg449 q, final int g, final long d) {
        this.q = q;
        this.g = g;
        this.d = d;
    }
    
    @Override
    void g(final Gg3 gg3) {
        this.g = Gg3.bd(gg3);
        this.d = Gg3.bq(gg3);
    }
    
    @Override
    void d(final Ef450 ef450) {
        ef450.y(this.g, this.d);
    }
    
    Da631(final Dg449 q) {
        this.q = q;
    }
}
