// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Jp534
{
    private byte[] d;
    public Jh522 g;
    
    public void g(final Gg3 gg3, final int n) {
        final int n2 = gg3.v + n;
        final int ar = Gg3.ar(gg3);
        final int ar2 = Gg3.ar(gg3);
        final int bd = Gg3.bd(gg3);
        final int bd2 = Gg3.bd(gg3);
        final int n3 = n2 - gg3.v;
        if (bd == 0) {
            this.d = new byte[bd2];
        }
        Gg3.bx(gg3, this.d, bd, n3);
        if (bd + n3 == bd2) {
            if (this.g == null) {
                this.g = new Jh522(ar);
            }
            Jh522.d(this.g, ar2, this.d);
            this.d = null;
        }
    }
}
