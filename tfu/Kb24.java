// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import com.jagex.maths.Z165;
import com.jagex.maths.C306;
import com.jagex.maths.Vector3;
import org.slf4j.Logger;

public class Kb24 extends It12
{
    private static final Logger logger;
    public final Vector3[] d;
    private C306[] j;
    public final String q;
    
    public static Kb24 e(final Gg3 gg3, final Z165 z165, final boolean b, final boolean b2) {
        Z165.q(z165);
        Gg3.bm(gg3);
        final String bp = gg3.bp();
        final int bm = Gg3.bm(gg3);
        final Vector3[] array = new Vector3[bm];
        for (int i = 0; i < bm; ++i) {
            array[i] = new Vector3(Gg3.bw(gg3) * (b2 ? Ai354.q : 1.0f), Gg3.bw(gg3) * (b2 ? Ai354.q : 1.0f), Gg3.bw(gg3) * (b2 ? Ai354.q : 1.0f));
        }
        if (b) {
            Kb24.logger.info("    convex hull: material = \"{}\" numVertices = {}", bp, bm);
        }
        return new Kb24(array, bp);
    }
    
    @Override
    public Ie21 g() {
        return Ie21.CONVEX_HULL;
    }
    
    public Kb24(final Vector3[] d, final String q) {
        this.j = null;
        this.d = d;
        this.q = q;
    }
    
    static {
        logger = LoggerFactory.getLogger(Kb24.class);
    }
}
