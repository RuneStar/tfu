// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Ek609 extends Eg572
{
    String d;
    long e;
    long g;
    byte j;
    int q;
    final /* synthetic */ Ee573 h;
    
    Ek609(final Ee573 h, final long g, final String d, final int q, final byte j, final long e) {
        this.h = h;
        this.g = -1L;
        this.d = null;
        this.g = g;
        this.d = d;
        this.q = q;
        this.j = j;
        this.e = e;
    }
    
    @Override
    void g(final Gg3 gg3) {
        if (Gg3.ar(gg3) != 255) {
            --gg3.v;
            this.g = Gg3.bq(gg3);
        }
        this.d = Gg3.bj(gg3);
        this.q = Gg3.au(gg3);
        this.j = Gg3.ax(gg3);
        this.e = Gg3.bq(gg3);
        if (Dr574.g) {
            System.out.println("memberhash:" + this.g + " membername:" + this.d);
        }
    }
    
    Ek609(final Ee573 h) {
        this.h = h;
        this.g = -1L;
        this.d = null;
    }
    
    @Override
    void d(final Dr574 dr574) {
        final Dt575 dt575 = new Dt575();
        dt575.g = this.g;
        dt575.j = this.d;
        dt575.q = this.q;
        dt575.d = this.j;
        dt575.e = this.e;
        Dr574.d(dr574, dt575);
    }
}
