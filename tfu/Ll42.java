/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.SceneGraphNode;
import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.shared.movement.PhysicsComponent;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.Q40;

public class Ll42 {
    private static final Logger logger = LoggerFactory.getLogger(Ll42.class);
    public PhysicsWorldWrapper d;

    public static void g(Ll42 ll42) {
        PhysicsWorldWrapper.b(ll42.d);
        logger.debug("----------------Physics worlds on client have been reset------------------");
    }

    public void d(GameEntity gameEntity, float f, float f2, Q40 q40, Integer n) {
        gameEntity.x = true;
        RigidBody rigidBody = this.d.h(gameEntity, f, f2, n);
        gameEntity.ba = rigidBody;
        PhysicsComponent physicsComponent = (PhysicsComponent)GameEntity.eb(gameEntity, PhysicsComponent.class);
        if (physicsComponent != null) {
            logger.error("Error: Adding to a physical world a game entity which already has been added to some other physical world");
        } else {
            GameEntity.ep(gameEntity, new PhysicsComponent(q40, rigidBody, null));
        }
    }

    public static void q(Ll42 ll42, GameEntity gameEntity) {
        if (!GameEntity.ee(gameEntity, PhysicsComponent.class)) {
            return;
        }
        gameEntity.x = false;
        gameEntity.u = true;
        PhysicsComponent physicsComponent = (PhysicsComponent)GameEntity.eb(gameEntity, PhysicsComponent.class);
        if (physicsComponent != null) {
            physicsComponent.removeCollisionGeometryFromWorld();
        }
        gameEntity.ba = null;
        GameEntity.eo(gameEntity, PhysicsComponent.class);
    }
}

