/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.maths.I48;
import com.jagex.maths.O166;
import com.jagex.maths.Z165;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ai354;
import tfu.Gg3;
import tfu.Ie21;
import tfu.It12;

public class Kx22
extends It12 {
    static final int[] h;
    private static final Logger logger;
    public final float d;
    public final String e;
    public final float j;
    public final float q;

    public static Kx22 e(Gg3 gg3, Z165 z165, boolean bl, boolean bl2) {
        Gg3.bm(gg3);
        String string = gg3.bp();
        z165.g.j = Gg3.bw(gg3);
        z165.g.e = Gg3.bw(gg3);
        z165.g.h = Gg3.bw(gg3);
        z165.g.s = Gg3.bw(gg3);
        z165.d.j = Gg3.bw(gg3) * (bl2 ? Ai354.q : 1.0f);
        z165.d.e = Gg3.bw(gg3) * (bl2 ? Ai354.q : 1.0f);
        z165.d.h = Gg3.bw(gg3) * (bl2 ? Ai354.q : 1.0f);
        float f = Gg3.bw(gg3) * (bl2 ? Ai354.q : 1.0f);
        float f2 = Gg3.bw(gg3) * (bl2 ? Ai354.q : 1.0f);
        float f3 = Gg3.bw(gg3) * (bl2 ? Ai354.q : 1.0f);
        if (bl) {
            Object[] arrobject = new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), z165.g, z165.d};
            logger.info("    box sizes: {},{},{}, orientation: {} local position: {}", arrobject);
        }
        return new Kx22(f, f2, f3, string);
    }

    static {
        logger = LoggerFactory.getLogger(Kx22.class);
        h = new int[]{0, 1, 1, 5, 5, 4, 4, 0, 2, 3, 3, 7, 7, 6, 6, 2, 0, 2, 1, 3, 5, 7, 4, 6};
    }

    @Override
    public Ie21 g() {
        return Ie21.BOX;
    }

    public Kx22(float f, float f2, float f3, String string) {
        this.d = f;
        this.q = f2;
        this.j = f3;
        this.e = string;
    }
}

