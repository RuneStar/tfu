// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import rs2.shared.movement.PhysicsComponent;
import rs2.shared.movement.Q40;
import com.jagex.game.runetek6.gameentity.GameEntity;
import rs2.shared.movement.PhysicsWorldWrapper;
import org.slf4j.Logger;

public class Ll42
{
    private static final Logger logger;
    public PhysicsWorldWrapper d;
    
    public static void g(final Ll42 ll42) {
        PhysicsWorldWrapper.b(ll42.d);
        Ll42.logger.debug("----------------Physics worlds on client have been reset------------------");
    }
    
    public void d(final GameEntity gameEntity, final float n, final float n2, final Q40 q40, final Integer n3) {
        gameEntity.x = true;
        final RigidBody h = this.d.h(gameEntity, n, n2, n3);
        gameEntity.ba = h;
        if (GameEntity.eb(gameEntity, PhysicsComponent.class) != null) {
            Ll42.logger.error("Error: Adding to a physical world a game entity which already has been added to some other physical world");
        }
        else {
            GameEntity.ep(gameEntity, new PhysicsComponent(q40, h, null));
        }
    }
    
    static {
        logger = LoggerFactory.getLogger(Ll42.class);
    }
    
    public static void q(final Ll42 ll42, final GameEntity gameEntity) {
        if (!GameEntity.ee(gameEntity, PhysicsComponent.class)) {
            return;
        }
        gameEntity.x = false;
        gameEntity.u = true;
        final PhysicsComponent physicsComponent = (PhysicsComponent)GameEntity.eb(gameEntity, PhysicsComponent.class);
        if (physicsComponent != null) {
            physicsComponent.removeCollisionGeometryFromWorld();
        }
        gameEntity.ba = null;
        GameEntity.eo(gameEntity, PhysicsComponent.class);
    }
}
