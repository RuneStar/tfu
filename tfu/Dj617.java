// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

class Dj617 extends Eg572
{
    byte d;
    String e;
    int g;
    long j;
    int q;
    final /* synthetic */ Ee573 h;
    
    Dj617(final Ee573 h, final int g, final byte d, final int q, final long j, final String e) {
        this.h = h;
        this.g = -1;
        this.g = g;
        this.d = d;
        this.q = q;
        this.j = j;
        this.e = e;
    }
    
    @Override
    void g(final Gg3 gg3) {
        this.g = Gg3.au(gg3);
        this.d = Gg3.ax(gg3);
        this.q = Gg3.au(gg3);
        this.j = Gg3.bq(gg3);
        this.e = Gg3.bk(gg3);
    }
    
    @Override
    void d(final Dr574 dr574) {
        final Dt575 dt575 = dr574.z[this.g];
        dt575.d = this.d;
        dt575.q = this.q;
        dt575.e = this.j;
        dt575.j = this.e;
    }
    
    Dj617(final Ee573 h) {
        this.h = h;
        this.g = -1;
    }
}
