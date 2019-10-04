/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.maths.Z165;
import tfu.Ai354;
import tfu.Gg3;
import tfu.Ie21;
import tfu.It12;

public class Kd441
extends It12 {
    public final float[] d;
    public final float[] g;

    private Kd441(float[] arrf, float[] arrf2) {
        this.g = arrf;
        this.d = arrf2;
    }

    public static Kd441 e(Gg3 gg3, Z165 z165, boolean bl, boolean bl2) {
        Z165.q(z165);
        Gg3.bm(gg3);
        int n = Gg3.bm(gg3);
        float[] arrf = new float[n];
        float[] arrf2 = new float[n];
        for (int i = 0; i < n; ++i) {
            arrf[i] = Gg3.bw(gg3) * (bl2 ? Ai354.q : 1.0f);
            arrf2[i] = Gg3.bw(gg3) * (bl2 ? Ai354.q : 1.0f);
        }
        return new Kd441(arrf, arrf2);
    }

    @Override
    public Ie21 g() {
        return Ie21.CONVEX_2D_POLYGON;
    }
}

