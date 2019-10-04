/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.movement;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import java.util.Comparator;
import rs2.shared.movement.PhysicsWorldWrapper;

class L9
implements Comparator {
    final Vector3 g;
    final /* synthetic */ PhysicsWorldWrapper d;

    public L9(PhysicsWorldWrapper physicsWorldWrapper, Vector3 vector3) {
        this.d = physicsWorldWrapper;
        this.g = vector3;
    }

    public static int g(L9 l9, GameEntity gameEntity, GameEntity gameEntity2) {
        float f;
        Vector3 vector3 = gameEntity.getWorldTransform().trans;
        Vector3 vector32 = gameEntity2.getWorldTransform().trans;
        Vector3 vector33 = Vector3.k(vector3, l9.g);
        Vector3 vector34 = Vector3.k(vector32, l9.g);
        float f2 = Vector3.c(vector33);
        return f2 < (f = Vector3.c(vector34)) ? -1 : 1;
    }
}

