// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

class Er571 extends Eg572
{
    private static final int s = 1;
    byte d;
    String e;
    int g;
    boolean h;
    long j;
    int q;
    final /* synthetic */ Ee573 b;
    
    Er571(final Ee573 b, final int g, final byte d, final int q, final long j, final String e, final boolean h) {
        this.b = b;
        this.g = -1;
        this.g = g;
        this.d = d;
        this.q = q;
        this.j = j;
        this.e = e;
        this.h = h;
    }
    
    @Override
    void d(final Dr574 dr574) {
        final Dt575 dt575 = dr574.z[this.g];
        dt575.d = this.d;
        dt575.q = this.q;
        dt575.e = this.j;
        dt575.j = this.e;
        dt575.h = this.h;
    }
    
    @Override
    void g(final Gg3 gg3) {
        Gg3.ar(gg3);
        this.g = Gg3.au(gg3);
        this.d = Gg3.ax(gg3);
        this.q = Gg3.au(gg3);
        this.j = Gg3.bq(gg3);
        this.e = Gg3.bk(gg3);
        this.h = (Gg3.ar(gg3) == 1);
    }
    
    Er571(final Ee573 b) {
        this.b = b;
        this.g = -1;
    }
}
