/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.game.runetek6.xelement.W14;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.HeightfieldTerrainCollisionShape;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;
import rs2.shared.movement.D18;

public class V17 {
    public static D18 g(DiscreteDynamicsWorld discreteDynamicsWorld, W14 w14, float f, float f2, float f3, float f4, int n, int n2, Object object) {
        float[][] arrf = new float[W14.g(w14)][W14.d(w14)];
        float f5 = Float.MAX_VALUE;
        float f6 = -3.4028235E38f;
        for (int i = 0; i < W14.g(w14); ++i) {
            for (int j = 0; j < W14.d(w14); ++j) {
                float f7;
                arrf[i][j] = f7 = (float)(w14.s[j * W14.g(w14) + i] & 0xFFFF) * w14.e + w14.j;
                if (f7 < f5) {
                    f5 = f7;
                }
                if (!(f7 > f6)) continue;
                f6 = f7;
            }
        }
        float f8 = w14.h * (float)(W14.g(w14) - 1);
        float f9 = w14.h * (float)(W14.d(w14) - 1);
        HeightfieldTerrainCollisionShape heightfieldTerrainCollisionShape = discreteDynamicsWorld.w(arrf, f8, f9, 1.0f);
        arrf = null;
        RotTrans rotTrans = new RotTrans(Quaternion.g, Vector3.g(f + f8 / 2.0f, (f5 + f6) / 2.0f, f2 + f9 / 2.0f));
        return new D18(discreteDynamicsWorld.v(heightfieldTerrainCollisionShape, Q7.g(rotTrans), f3, f4, n, n2, false, true, object), heightfieldTerrainCollisionShape);
    }
}

