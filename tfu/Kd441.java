// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import com.jagex.maths.Z165;

public class Kd441 extends It12
{
    public final float[] d;
    public final float[] g;
    
    private Kd441(final float[] g, final float[] d) {
        this.g = g;
        this.d = d;
    }
    
    public static Kd441 e(final Gg3 gg3, final Z165 z165, final boolean b, final boolean b2) {
        Z165.q(z165);
        Gg3.bm(gg3);
        final int bm = Gg3.bm(gg3);
        final float[] array = new float[bm];
        final float[] array2 = new float[bm];
        for (int i = 0; i < bm; ++i) {
            array[i] = Gg3.bw(gg3) * (b2 ? Ai354.q : 1.0f);
            array2[i] = Gg3.bw(gg3) * (b2 ? Ai354.q : 1.0f);
        }
        return new Kd441(array, array2);
    }
    
    @Override
    public Ie21 g() {
        return Ie21.CONVEX_2D_POLYGON;
    }
}
