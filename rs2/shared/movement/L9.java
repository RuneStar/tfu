// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.movement;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.maths.Vector3;
import java.util.Comparator;

class L9 implements Comparator
{
    final Vector3 g;
    final /* synthetic */ PhysicsWorldWrapper d;
    
    public L9(final PhysicsWorldWrapper d, final Vector3 g) {
        this.d = d;
        this.g = g;
    }
    
    public static int g(final L9 l9, final GameEntity gameEntity, final GameEntity gameEntity2) {
        return (Vector3.c(Vector3.k(gameEntity.getWorldTransform().trans, l9.g)) < Vector3.c(Vector3.k(gameEntity2.getWorldTransform().trans, l9.g))) ? -1 : 1;
    }
}
