package tfu;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.shared.movement.PhysicsComponent;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.Q40;

public class Ll42 {
   private static final Logger logger = LoggerFactory.getLogger(Ll42.class);
   public PhysicsWorldWrapper d;

   public static void g(Ll42 var0) {
      PhysicsWorldWrapper.b(var0.d);
      logger.debug("----------------Physics worlds on client have been reset------------------");
   }

   public void d(GameEntity var1, float var2, float var3, Q40 var4, Integer var5) {
      var1.x = true;
      RigidBody var6 = this.d.h(var1, var2, var3, var5);
      var1.ba = var6;
      PhysicsComponent var7 = (PhysicsComponent)GameEntity.eb(var1, PhysicsComponent.class);
      if (var7 != null) {
         logger.error("Error: Adding to a physical world a game entity which already has been added to some other physical world");
      } else {
         GameEntity.ep(var1, new PhysicsComponent(var4, var6, (RigidBody)null));
      }

   }

   public static void q(Ll42 var0, GameEntity var1) {
      if (GameEntity.ee(var1, PhysicsComponent.class)) {
         var1.x = false;
         var1.u = true;
         PhysicsComponent var2 = (PhysicsComponent)GameEntity.eb(var1, PhysicsComponent.class);
         if (var2 != null) {
            var2.removeCollisionGeometryFromWorld();
         }

         var1.ba = null;
         GameEntity.eo(var1, PhysicsComponent.class);
      }
   }
}
