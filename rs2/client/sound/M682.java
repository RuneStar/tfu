// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

class M682 implements Z674
{
    final /* synthetic */ X675 g;
    
    @Override
    public void g(final String s, final Object o) {
        final X675 b = (X675)o;
        b(b);
        if (K589.b != null) {
            X675.h(K589.b);
        }
        X675.h(this.g);
        final X675 s2 = K589.s;
        if (s2 == null) {
            X675.g(this.g);
        }
        else if (s2 != null && X675.w(s2)) {
            final long n2;
            long n = (n2 = ((K589.s == null) ? 0L : X675.x(K589.s))) + ((n2 / s2.r + 1L) * s2.r - n2);
            if (s2 != b) {
                if (K589.s != null && n > X675.u(K589.s)) {
                    n %= X675.u(K589.s);
                }
                X675.s(b, new N680(0, n));
                K589.b = b;
            }
        }
    }
    
    @Override
    public void d(final byte[] array, final Object o) {
    }
    
    @Override
    public void q() {
    }
    
    M682(final X675 g) {
        this.g = g;
    }
}
