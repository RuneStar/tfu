package rs2.shared.movement;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.L8;
import com.jagex.maths.Vector3;
import java.util.ArrayList;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass
public class PhysicsQueryResultList {
   public final ArrayList d;
   public final DiscreteDynamicsWorld g;

   public PhysicsQueryResultList(DiscreteDynamicsWorld var1, ArrayList var2) {
      this.g = var1;
      this.d = var2;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int getResultCount() {
      return this.d.size();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public CollisionObjectData getCollisionObject(int var1) {
      return (CollisionObjectData)this.g.ap(((L8)this.d.get(var1)).g);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getContactNormal(int var1) {
      return ((L8)this.d.get(var1)).q;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getContactPoint(int var1) {
      return ((L8)this.d.get(var1)).d;
   }
}
