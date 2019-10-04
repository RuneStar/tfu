// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import com.jagex.maths.Z165;
import org.slf4j.Logger;

public class Kx22 extends It12
{
    static final int[] h;
    private static final Logger logger;
    public final float d;
    public final String e;
    public final float j;
    public final float q;
    
    public static Kx22 e(final Gg3 gg3, final Z165 z165, final boolean b, final boolean b2) {
        Gg3.bm(gg3);
        final String bp = gg3.bp();
        z165.g.j = Gg3.bw(gg3);
        z165.g.e = Gg3.bw(gg3);
        z165.g.h = Gg3.bw(gg3);
        z165.g.s = Gg3.bw(gg3);
        z165.d.j = Gg3.bw(gg3) * (b2 ? Ai354.q : 1.0f);
        z165.d.e = Gg3.bw(gg3) * (b2 ? Ai354.q : 1.0f);
        z165.d.h = Gg3.bw(gg3) * (b2 ? Ai354.q : 1.0f);
        final float f = Gg3.bw(gg3) * (b2 ? Ai354.q : 1.0f);
        final float f2 = Gg3.bw(gg3) * (b2 ? Ai354.q : 1.0f);
        final float f3 = Gg3.bw(gg3) * (b2 ? Ai354.q : 1.0f);
        if (b) {
            Kx22.logger.info("    box sizes: {},{},{}, orientation: {} local position: {}", new Object[] { f, f2, f3, z165.g, z165.d });
        }
        return new Kx22(f, f2, f3, bp);
    }
    
    static {
        logger = LoggerFactory.getLogger(Kx22.class);
        h = new int[] { 0, 1, 1, 5, 5, 4, 4, 0, 2, 3, 3, 7, 7, 6, 6, 2, 0, 2, 1, 3, 5, 7, 4, 6 };
    }
    
    @Override
    public Ie21 g() {
        return Ie21.BOX;
    }
    
    public Kx22(final float d, final float q, final float j, final String e) {
        this.d = d;
        this.q = q;
        this.j = j;
        this.e = e;
    }
}
