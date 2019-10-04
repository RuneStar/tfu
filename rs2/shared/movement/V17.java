// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import com.jagex.jnibindings.runetek6.jagbullet.HeightfieldTerrainCollisionShape;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;
import com.jagex.maths.Quaternion;
import com.jagex.game.runetek6.xelement.W14;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;

public class V17
{
    public static D18 g(final DiscreteDynamicsWorld discreteDynamicsWorld, final W14 w14, final float n, final float n2, final float n3, final float n4, final int n5, final int n6, final Object o) {
        final float[][] array = new float[W14.g(w14)][W14.d(w14)];
        float n7 = Float.MAX_VALUE;
        float n8 = -3.4028235E38f;
        for (int i = 0; i < W14.g(w14); ++i) {
            for (int j = 0; j < W14.d(w14); ++j) {
                final float n9 = (w14.s[j * W14.g(w14) + i] & 0xFFFF) * w14.e + w14.j;
                array[i][j] = n9;
                if (n9 < n7) {
                    n7 = n9;
                }
                if (n9 > n8) {
                    n8 = n9;
                }
            }
        }
        final float n10 = w14.h * (W14.g(w14) - 1);
        final float n11 = w14.h * (W14.d(w14) - 1);
        final HeightfieldTerrainCollisionShape w15 = discreteDynamicsWorld.w(array, n10, n11, 1.0f);
        final float[][] array2 = null;
        return new D18(discreteDynamicsWorld.v(w15, Q7.g(new RotTrans(Quaternion.g, Vector3.g(n + n10 / 2.0f, (n7 + n8) / 2.0f, n2 + n11 / 2.0f))), n3, n4, n5, n6, false, true, o), w15);
    }
}
