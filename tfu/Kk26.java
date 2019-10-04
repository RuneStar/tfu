// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.maths.O166;
import com.jagex.maths.Z165;

public class Kk26 extends It12
{
    public final String d;
    public final float g;
    
    public static Kk26 e(final Gg3 gg3, final Z165 z165, final boolean b, final boolean b2) {
        Gg3.bm(gg3);
        final String bp = gg3.bp();
        O166.v(z165.g);
        z165.d.j = Gg3.bw(gg3) * (b2 ? Ai354.q : 1.0f);
        z165.d.e = Gg3.bw(gg3) * (b2 ? Ai354.q : 1.0f);
        z165.d.h = Gg3.bw(gg3) * (b2 ? Ai354.q : 1.0f);
        return new Kk26(Gg3.bw(gg3) * (b2 ? Ai354.q : 1.0f), bp);
    }
    
    public Kk26(final float g, final String d) {
        this.g = g;
        this.d = d;
    }
    
    @Override
    public Ie21 g() {
        return Ie21.SPHERE;
    }
}
