// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Ch643
{
    private int b;
    private int d;
    int e;
    boolean g;
    int h;
    private int[] j;
    private int l;
    private int[] q;
    private int r;
    int s;
    private int v;
    private int w;
    
    public static final void g(final Ch643 ch643, final Gg3 gg3) {
        ch643.s = Gg3.ar(gg3);
        ch643.e = Gg3.bd(gg3);
        ch643.h = Gg3.bd(gg3);
        d(ch643, gg3);
    }
    
    public Ch643() {
        this.g = true;
        this.d = 2;
        this.q = new int[2];
        this.j = new int[2];
        this.q[0] = 0;
        this.q[1] = 65535;
        this.j[0] = 0;
        this.j[1] = 65535;
    }
    
    static final int j(final Ch643 ch643, final int n) {
        if (ch643.v >= ch643.b) {
            ch643.r = ch643.j[ch643.l++] << 15;
            if (ch643.l >= ch643.d) {
                ch643.l = ch643.d - 1;
            }
            ch643.b = (int)(ch643.q[ch643.l] / 65536.0 * n);
            if (ch643.b > ch643.v) {
                ch643.w = ((ch643.j[ch643.l] << 15) - ch643.r) / (ch643.b - ch643.v);
            }
        }
        ch643.r += ch643.w;
        ++ch643.v;
        return ch643.r - ch643.w >> 15;
    }
    
    public static final void d(final Ch643 ch643, final Gg3 gg3) {
        ch643.d = Gg3.ar(gg3);
        ch643.q = new int[ch643.d];
        ch643.j = new int[ch643.d];
        for (int i = 0; i < ch643.d; ++i) {
            ch643.q[i] = Gg3.au(gg3);
            ch643.j[i] = Gg3.au(gg3);
        }
    }
    
    static final void q(final Ch643 ch643) {
        ch643.b = 0;
        ch643.l = 0;
        ch643.w = 0;
        ch643.r = 0;
        ch643.v = 0;
    }
}
