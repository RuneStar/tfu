// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import tfu.Gg3;

final class E673 implements Z674
{
    @Override
    public void g(final String s, final Object o) {
    }
    
    @Override
    public void d(final byte[] array, final Object o) {
        K589.q.clear();
        K589.j.clear();
        final Gg3 gg3 = new Gg3(array);
        for (int au = Gg3.au(gg3), i = 0; i < au; ++i) {
            K589.j.add(Gg3.bk(gg3));
        }
        for (int au2 = Gg3.au(gg3), j = 0; j < au2; ++j) {
            final X675 e = new X675();
            e.p(gg3);
            K589.q.add(e);
        }
        K589.w = System.currentTimeMillis() + 33L;
        K589.d = true;
        if (K589.e != null) {
            K589.h(K589.e, K589.h);
            K589.e = (K589.h = null);
        }
        K589.l = System.currentTimeMillis();
    }
    
    @Override
    public void q() {
    }
}
