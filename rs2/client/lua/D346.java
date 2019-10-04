// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.lua;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.maths.Vector3;
import java.util.Comparator;

class D346 implements Comparator
{
    final Vector3 g;
    
    public static int g(final D346 d346, final GameEntity gameEntity, final GameEntity gameEntity2) {
        return (Vector3.c(Vector3.k(gameEntity.getWorldTransform().trans, d346.g)) < Vector3.c(Vector3.k(gameEntity2.getWorldTransform().trans, d346.g))) ? -1 : 1;
    }
    
    public D346(final Vector3 g) {
        this.g = g;
    }
}
