// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

class Dd615 extends Eg572
{
    boolean d;
    String g;
    byte j;
    byte q;
    final /* synthetic */ Ee573 e;
    
    @Override
    void g(final Gg3 gg3) {
        this.g = Gg3.bj(gg3);
        if (this.g != null) {
            this.d = (Gg3.ar(gg3) == 1);
            this.q = Gg3.ax(gg3);
            this.j = Gg3.ax(gg3);
        }
    }
    
    Dd615(final Ee573 e, final String g, final boolean d, final byte q, final byte j) {
        this.e = e;
        this.g = g;
        this.d = d;
        this.q = q;
        this.j = j;
    }
    
    @Override
    void d(final Dr574 dr574) {
        dr574.k = this.g;
        if (this.g != null) {
            dr574.i = this.d;
            dr574.o = this.q;
            dr574.a = this.j;
        }
    }
    
    Dd615(final Ee573 e) {
        this.e = e;
    }
}
