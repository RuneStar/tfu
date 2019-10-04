// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import fmod.X243;

final class I684 implements Z674
{
    @Override
    public void d(final byte[] array, final Object o) {
    }
    
    @Override
    public void q() {
        Y603.d = null;
        Y603.j = null;
        if (Y603.q != null) {
            X243.f(Y603.q);
            Y603.q = null;
        }
    }
    
    @Override
    public void g(final String s, final Object o) {
        --Y603.h;
        if (Y603.h <= 0 && Y603.d != null) {
            final X243 r = SoundManager.c.r(Y603.d, 0);
            if (X243.h(r)) {
                X243.i(r, Y603.e);
                if (Y603.j != null) {
                    final C595[] f = SoundManager.f(Y603.j);
                    if (f != null) {
                        for (final C595 c595 : f) {
                            r.ag(c595.g, (float)c595.d);
                        }
                    }
                }
                r.a();
                if (Y603.q != null) {
                    X243.f(Y603.q);
                }
                Y603.j = null;
                Y603.q = r;
                Y603.g = Y603.d;
                Y603.d = null;
            }
        }
    }
}
