// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import fmod.E245;
import fmod.Q244;
import fmod.X243;

class L681
{
    public float d;
    public X243 g;
    private String j;
    public H591 q;
    final /* synthetic */ H591 e;
    
    public static void g(final L681 l681, final Q244 q244) {
        if (X243.y(l681.g)) {
            X243.c(l681.g);
            l681.e.f.remove(l681.g);
        }
        l681.g = E245.v(SoundManager.c, l681.j);
        if (X243.h(l681.g)) {
            X243.u(l681.g, q244);
            X243.i(l681.g, l681.d * l681.e.g);
            l681.g.a();
            l681.e.f.add(l681.g);
        }
    }
    
    public L681(final H591 e, final String j, final float d, final H591 q) {
        this.e = e;
        this.j = j;
        this.q = q;
        this.g = E245.v(SoundManager.c, j);
        this.d = d;
    }
}
