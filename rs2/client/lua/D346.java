/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.lua;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import java.util.Comparator;

class D346
implements Comparator {
    final Vector3 g;

    public static int g(D346 d346, GameEntity gameEntity, GameEntity gameEntity2) {
        float f;
        Vector3 vector3 = gameEntity.getWorldTransform().trans;
        Vector3 vector32 = gameEntity2.getWorldTransform().trans;
        Vector3 vector33 = Vector3.k(vector3, d346.g);
        Vector3 vector34 = Vector3.k(vector32, d346.g);
        float f2 = Vector3.c(vector33);
        return f2 < (f = Vector3.c(vector34)) ? -1 : 1;
    }

    public D346(Vector3 vector3) {
        this.g = vector3;
    }
}

