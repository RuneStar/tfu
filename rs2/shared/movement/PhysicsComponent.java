package rs2.shared.movement;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.maths.E41;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import tfu.Be2;
import tfu.Bs1;
import tfu.Lr302;

@ScriptEntryClass
public class PhysicsComponent extends Component {
   public static final int j = StringTools.l(PhysicsComponent.class.getName());
   public RigidBody d;
   private final Q40 g;
   public RigidBody q;

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float getHeading() {
      Quaternion var1 = this.getEntity().getWorldTransform().rot;
      return (Lr302.g(var1) + 3.1415927F) % 6.2831855F;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int getComponentTypeID() {
      return j;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getAabbMaxCorner() {
      if (this.g == null) {
         return null;
      } else {
         E41 var1 = this.g.j();
         return var1 == null ? null : var1.e();
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public RotTrans entityRotTransToPhysicsSpace(RotTrans var1) {
      return var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void removeCollisionGeometryFromWorld() {
      if (this.q != null) {
         this.q.b.t(this.q.d);
         this.q.b.m(this.q);
         this.q = null;
      }

      if (this.d != null) {
         this.d.b.t(this.d.d);
         this.d.b.m(this.d);
         this.d = null;
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public PhysicsWorldWrapper getPhysicsWorld() {
      return this.g == null ? null : this.g.g();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 physicsVectorToEntitySpace(Vector3 var1) {
      return var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int getCurrentOrBestNavLayer() {
      return this.g == null ? 0 : this.g.d();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void kick(Vector3 var1) {
      if (this.g != null) {
         this.g.q(var1);
      }

   }

   public PhysicsComponent(Q40 var1, RigidBody var2, RigidBody var3) {
      this.g = var1;
      this.d = var2;
      this.q = var3;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getFacingLinearVelocity() {
      Vector3 var1 = this.g.e();
      ScaleRotTrans var2 = GameEntity.v(this.getEntity());
      var1 = Vector3.al(var1, var2.rot);
      var1 = var1.ao();
      return var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setCollisionGeometryEnabled(boolean var1) {
      if (this.q != null) {
         if (var1) {
            RigidBody.y(this.q);
         } else {
            RigidBody.p(this.q);
         }
      }

      if (this.d != null) {
         if (var1) {
            RigidBody.y(this.d);
         } else {
            RigidBody.p(this.d);
         }
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean isCollisionGeometryEnabled() {
      if (this.q != null && this.d != null && RigidBody.x(this.q) != RigidBody.x(this.d)) {
         throw new IllegalStateException("PhysicsComponent " + this + " has client master body and interpolated body with values for enabled that are not in sync");
      } else if (this.q != null) {
         return RigidBody.x(this.q);
      } else {
         return this.d != null ? RigidBody.x(this.d) : false;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public RotTrans physicsRotTransToEntitySpace(RotTrans var1) {
      return var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getAabbMinCorner() {
      if (this.g == null) {
         return null;
      } else {
         E41 var1 = this.g.j();
         return var1 == null ? null : var1.j();
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getWorldAngularVelocity() {
      return this.g.h();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getFacingAngularVelocity() {
      Vector3 var1 = this.g.h();
      ScaleRotTrans var2 = GameEntity.v(this.getEntity());
      var1 = Vector3.al(var1, var2.rot);
      var1 = var1.ao();
      return var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getWorldLinearVelocity() {
      return this.g.e();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 entityVectorToPhysicsSpace(Vector3 var1) {
      return var1;
   }
}
