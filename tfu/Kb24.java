/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.maths.C306;
import com.jagex.maths.Vector3;
import com.jagex.maths.Z165;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ai354;
import tfu.Gg3;
import tfu.Ie21;
import tfu.It12;

public class Kb24
extends It12 {
    private static final Logger logger = LoggerFactory.getLogger(Kb24.class);
    public final Vector3[] d;
    private C306[] j = null;
    public final String q;

    public static Kb24 e(Gg3 gg3, Z165 z165, boolean bl, boolean bl2) {
        Z165.q(z165);
        Gg3.bm(gg3);
        String string = gg3.bp();
        int n = Gg3.bm(gg3);
        Vector3[] arrvector3 = new Vector3[n];
        for (int i = 0; i < n; ++i) {
            float f = Gg3.bw(gg3) * (bl2 ? Ai354.q : 1.0f);
            float f2 = Gg3.bw(gg3) * (bl2 ? Ai354.q : 1.0f);
            float f3 = Gg3.bw(gg3) * (bl2 ? Ai354.q : 1.0f);
            arrvector3[i] = new Vector3(f, f2, f3);
        }
        if (bl) {
            logger.info("    convex hull: material = \"{}\" numVertices = {}", (Object)string, (Object)n);
        }
        return new Kb24(arrvector3, string);
    }

    @Override
    public Ie21 g() {
        return Ie21.CONVEX_HULL;
    }

    public Kb24(Vector3[] arrvector3, String string) {
        this.d = arrvector3;
        this.q = string;
    }
}

