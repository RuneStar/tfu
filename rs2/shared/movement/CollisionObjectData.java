package rs2.shared.movement;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass("CollisionObject")
public class CollisionObjectData {
   public GameEntity d = null;
   public final S15 g;
   public PlayerPhysicsAvatar q = null;

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int getType() {
      return this.g.h;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public GameEntity getEntity() {
      return this.d;
   }

   public CollisionObjectData(S15 var1) {
      this.g = var1;
   }
}
