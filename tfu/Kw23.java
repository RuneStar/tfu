// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.maths.Z165;

public class Kw23 extends It12
{
    public final float d;
    public final float g;
    public final String q;
    
    public static Kw23 e(final Gg3 gg3, final Z165 z165, final boolean b, final boolean b2) {
        Gg3.bm(gg3);
        final String bp = gg3.bp();
        z165.g.j = Gg3.bw(gg3);
        z165.g.e = Gg3.bw(gg3);
        z165.g.h = Gg3.bw(gg3);
        z165.g.s = Gg3.bw(gg3);
        z165.d.j = Gg3.bw(gg3) * (b2 ? Ai354.q : 1.0f);
        z165.d.e = Gg3.bw(gg3) * (b2 ? Ai354.q : 1.0f);
        z165.d.h = Gg3.bw(gg3) * (b2 ? Ai354.q : 1.0f);
        return new Kw23(Gg3.bw(gg3) * (b2 ? Ai354.q : 1.0f), Gg3.bw(gg3) * (b2 ? Ai354.q : 1.0f), bp);
    }
    
    @Override
    public Ie21 g() {
        return Ie21.CAPSULE;
    }
    
    public Kw23(final float g, final float d, final String q) {
        this.g = g;
        this.d = d;
        this.q = q;
    }
}
