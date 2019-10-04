// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

class Ep612 extends Dm448
{
    byte d;
    byte e;
    boolean g;
    byte j;
    byte q;
    final /* synthetic */ Dg449 h;
    
    Ep612(final Dg449 h, final Ef450 ef450) {
        this.h = h;
        this.g = ef450.r;
        this.d = ef450.v;
        this.q = ef450.y;
        this.j = ef450.p;
        this.e = ef450.x;
    }
    
    Ep612(final Dg449 h) {
        this.h = h;
    }
    
    @Override
    void d(final Ef450 ef450) {
        ef450.r = this.g;
        ef450.v = this.d;
        ef450.y = this.q;
        ef450.p = this.j;
        ef450.x = this.e;
    }
    
    @Override
    void g(final Gg3 gg3) {
        this.g = (Gg3.ar(gg3) == 1);
        this.d = Gg3.ax(gg3);
        this.q = Gg3.ax(gg3);
        this.j = Gg3.ax(gg3);
        this.e = Gg3.ax(gg3);
    }
}
