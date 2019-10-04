// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import tfu.Gg3;

final class V696 implements Z674
{
    @Override
    public void d(final byte[] array, final Object o) {
        final Gg3 gg3 = new Gg3(array);
        final int au = Gg3.au(gg3);
        Ag588.e.clear();
        for (int i = 0; i < au; ++i) {
            final Ag588 value = new Ag588();
            final int au2 = Gg3.au(gg3);
            value.d = Gg3.bk(gg3);
            value.q = Gg3.bk(gg3);
            value.j = Gg3.bk(gg3);
            for (int au3 = Gg3.au(gg3), j = 0; j < au3; ++j) {
                value.g.put(Gg3.bk(gg3), Gg3.bk(gg3));
                if (j == 22) {
                    int n = 0;
                    ++n;
                }
            }
            Ag588.e.put(au2, value);
        }
    }
    
    @Override
    public void g(final String s, final Object o) {
    }
    
    @Override
    public void q() {
        Ag588.e.clear();
    }
}
