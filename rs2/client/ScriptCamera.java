package rs2.client;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.scenegraph.Scene;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.jnibindings.runetek6.jagbullet.CameraController;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.F304;
import com.jagex.maths.H303;
import com.jagex.maths.Matrix4;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;
import rs2.client.lua.ClientScriptAPI;
import rs2.client.worldelement.player;
import rs2.shared.movement.CollisionObjectData;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.PlayerPhysicsComponent;
import rs2.shared.movement.S15;
import tfu.Ba115;
import tfu.Be2;
import tfu.Bs1;
import tfu.Ej287;
import tfu.Gc330;
import tfu.Gj16;
import tfu.Gn5;

@ScriptEntryClass("Camera")
public class ScriptCamera extends GameEntity {
   private static ScriptCamera k;
   public static Ba115 m;
   float a;
   float ag;
   Matrix4 ai;
   Matrix4 al;
   Matrix4 aq;
   float c;
   float f;
   float i = 0.0F;
   CameraController n = null;
   float o = 0.0F;

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setPerspectiveProjection(float var1, float var2, float var3, float var4) {
      this.ai = Matrix4.l(var1, var2, var3, var4);
      this.a = (float)(Math.tan((double)(var3 / 2.0F)) * (double)var1);
      this.f = (float)(Math.tan((double)(var4 / 2.0F)) * (double)var1);
      this.c = -this.a;
      this.ag = -this.f;
      this.i = var1;
      this.o = var2;
   }

   ScriptCamera(ScriptManager var1) {
      super(m.h(), var1);
      this.aq = Matrix4.g;
      this.ai = Matrix4.g;
      this.al = Matrix4.g;
   }

   /** @deprecated */
   @Deprecated
   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 worldPosToScreenPos(float var1, float var2, float var3, float var4, float var5, @ScriptDefaults(defaultNumber = 2.0D) float var6) {
      F304 var7 = new F304(var1, var2, var3, 1.0F);
      Matrix4 var8 = this.getViewProjMatrix();
      F304.h(var7, var8);
      float var9 = Math.abs(var7.g / var6);
      float var10 = Math.abs(var7.d / var6);
      if (var7.j < var9) {
         var7.j = var9;
      }

      if (var7.j < var10) {
         var7.j = var10;
      }

      if (var7.j == 0.0F) {
         var7.j = 1.0F;
         var7.d = var6;
      }

      float var11 = 1.0F / var7.j;
      var7.g *= var11;
      var7.d *= var11;
      var7.q *= var11;
      var7.j *= var11;
      Vector3 var12 = new Vector3((var7.g + 1.0F) * 0.5F * var4, (-var7.d + 1.0F) * 0.5F * var5, var7.q);
      return var12;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean setDesiredTransform(RotTrans var1) {
      if (this.n == null) {
         this.bv(this.getWorldTransform().q());
      }

      this.setLocalOrientation(var1.rot);
      GameEntity var3 = ClientScriptAPI.GetSelfGameEntity();
      PlayerPhysicsComponent var4 = (PlayerPhysicsComponent)GameEntity.eb(var3, PlayerPhysicsComponent.class);
      RotTrans var5 = var4.entityRotTransToPhysicsSpace(var1);
      boolean var6 = this.n.e(var5.trans);
      RotTrans var7 = Q7.d(this.n.ao());
      RotTrans var8 = var4.physicsRotTransToEntitySpace(var7);
      w(this, var8.trans);
      return var6;
   }

   public static void br() {
      if (k != null) {
         k.n = null;
      }

   }

   /** @deprecated */
   @Deprecated
   @ScriptEntryPoint
   @Be2
   @Bs1
   public Matrix4 getViewMatrix() {
      RotTrans var1 = v(this).q();
      H303 var2 = new H303();
      H303.q(var2, var1);
      this.aq = new Matrix4(var2);
      return this.aq;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Matrix4 getProjMatrix() {
      return this.ai;
   }

   /** @deprecated */
   @Deprecated
   @ScriptEntryPoint
   @Be2
   @Bs1
   public Matrix4 getViewProjMatrix() {
      this.al = this.getViewMatrix().g(this.ai);
      return this.al;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setTransform(RotTrans var1) {
      this.setWorldTransform(var1);
      if (this.n != null) {
         this.n.aa(Q7.g(var1));
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setOrthographicProjection(float var1, float var2, float var3) {
      this.ai = Matrix4.w(var1, var2, var3);
      this.i = var1;
      this.o = var2;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static ScriptCamera create(ScriptManager var0, RotTrans var1, float var2, float var3, float var4, float var5) {
      if (var0 == null) {
         throw new IllegalArgumentException("Null ScriptManager instance.");
      } else {
         ScriptCamera var6 = new ScriptCamera(var0);
         var6.setTransform(var1);
         var6.setPerspectiveProjection(var2, var3, var4, var5);
         var6.bv(var1);
         return var6;
      }
   }

   private void bv(RotTrans var1) {
      PhysicsWorldWrapper var2 = client.gz.d;
      E6 var3 = var2.d.q(3.0F);
      CollisionObjectData var4 = new CollisionObjectData(S15.CAMERA);
      var4.d = this;
      this.n = var2.d.x(var3, Q7.g(var1), true, Gn5.CAMERA_SIGHT.ordinal(), Gj16.NONE.az, var4);
      super.ba = this.n;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setRadius(float var1) {
      if (this.n != null) {
         this.n.h(var1);
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public RotTrans getPhysicsTransform() {
      return this.n != null ? Q7.d(this.n.ao()) : RotTrans.g;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public RotTrans getTransform() {
      return Q7.d(this.n.ao());
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setLocalOrientation(Quaternion var1) {
      this.setObjectRotation(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static ScriptCamera getActiveCamera() {
      return k;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setActiveCamera(ScriptCamera var0) {
      player var1 = Gc330.j();
      if (var1 != null) {
         Scene var2 = var1.getScene();
         if (var2 != null) {
            var2.setActiveCamera(var0);
         }
      }

      k = var0;
   }

   static {
      m = Ba115.d(Ej287.CAMERA);
   }
}
