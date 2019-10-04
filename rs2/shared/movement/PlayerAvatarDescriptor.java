package rs2.shared.movement;

import com.jagex.game.runetek6.event.EventHandler;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import com.jagex.jnibindings.runetek6.jagbullet.B45;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.I48;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass("PlayerPhysicsAvatarDescriptor")
public class PlayerAvatarDescriptor {
   public static final HashMap i = new HashMap();
   static Set k = new HashSet();
   private static final Logger logger = LoggerFactory.getLogger(PlayerAvatarDescriptor.class);
   public static final HashMap o = new HashMap();
   public float b = 0.0F;
   public J93 d = null;
   public float e;
   public float h;
   public B45 j = null;
   public float l;
   public EventHandler m = null;
   public EventHandler n = null;
   public Vector3 p = new Vector3(1.0F, 1.0F, 1.0F);
   public W94 q = null;
   public float r = 1.0F;
   public float s;
   public float t = (float)Math.toRadians(30.0D);
   public float u = (float)Math.toRadians(45.0D);
   public float v = 0.0F;
   public float w = -29.41995F;
   public float x = 0.0F;
   public float y = 0.3F;
   public float z = (float)Math.toRadians(45.0D);

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getMaxWalkSlope(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.u;
   }

   private PlayerAvatarDescriptor(J93 var1) {
      this.d = var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder(3000);
      var1.append("\n=============\n");
      var1.append("type: ");
      var1.append(this.d);
      var1.append("\nshapeType: ");
      var1.append(this.q);
      var1.append("\ndimension: ");
      var1.append(this.e);
      var1.append(" ");
      var1.append(this.h);
      var1.append(" ");
      var1.append(this.s);
      var1.append(" ");
      var1.append(this.b);
      var1.append("\nmass: ");
      var1.append(this.l);
      var1.append("\ninAirGravityY: ");
      var1.append(this.w);
      var1.append("\nonWallGravityMultiplier: ");
      var1.append(this.r);
      var1.append("\nfriction: ");
      var1.append(this.v);
      var1.append("\nrestitution: ");
      var1.append(this.y);
      var1.append("\ninertiaScaleRelativeToShape: ");
      var1.append(this.p);
      var1.append("\nstepHeight: ");
      var1.append(this.x);
      var1.append("\nmaxWalkSlopeRadians: ");
      var1.append(this.u);
      var1.append("\nmaxJumpSlopeRadians: ");
      var1.append(this.z);
      var1.append("\nminSlideSlopeRadians: ");
      var1.append(this.t);
      if (this.j != null) {
         var1.append("\n------------");
         var1.append(this.j.toString());
      }

      var1.append("\n=============");
      return var1.toString();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void createBodyDescriptor(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = new PlayerAvatarDescriptor(J93.BODY);
      i.put(var0, var1);
      o.put(var0, 1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleMaxLinearVelocity(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.br = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static boolean IsCharacterController(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.d == J93.CHARACTERCONTROLLER;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetVehicleVisualRollStrength(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.t = var1;
      q(var0);
   }

   public static int d(int var0) {
      Integer var1 = (Integer)o.get(var0);
      return var1 == null ? 0 : var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void CreateDuplicateDescriptor(@ScriptID Integer var0, @ScriptID Integer var1) {
      j(var0, var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setBoxShape(@ScriptID Integer var0, float var1, float var2, float var3, @ScriptDefaults(defaultNumber = 0.0D) float var4) {
      PlayerAvatarDescriptor var5 = (PlayerAvatarDescriptor)i.get(var0);
      var5.q = W94.BOX;
      var5.e = var1;
      var5.h = var2;
      var5.s = var3;
      var5.b = var4;
      q(var0);
   }

   public static float h(PlayerAvatarDescriptor var0) {
      // $FF: Couldn't be decompiled
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setSphereShape(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.q = W94.SPHERE;
      var2.b = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetDimension1(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.e;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetDimension2(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.h;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleVisualRollMaxAngle(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.n;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setLeftWheelPretransformZangle(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.bq = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetRadius(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.b;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setMass(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.l = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetLowEndSteeringFullLockAngle(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.ar;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setInAirGravity(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      if ((double)var1 >= 0.0D) {
         logger.warn("lua::SetInAirGravity(): gravity should be negative. Supplied value: {}", var1);
      }

      var2.w = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getInAirGravity(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.w;
   }

   public static RotTrans r(PlayerAvatarDescriptor var0, PlayerPhysicsAvatar var1) {
      return var0.d == J93.VEHICLE ? RotTrans.g : null;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getOnWallGravityMultiplier(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.r;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setFriction(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.v = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetFriction(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.v;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleVisualPitchSpeed(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.i;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetRestitution(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.y;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVerticalInertiaScale(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.p = var2.p.an(var1);
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setInertiaScalesRelativeToShape(@ScriptID Integer var0, float var1, float var2, float var3) {
      PlayerAvatarDescriptor var4 = (PlayerAvatarDescriptor)i.get(var0);
      var4.p = new Vector3(var1, var2, var3);
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetVehicleTopSpeedInReverse(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.ah = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setStepHeight(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.x = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetStepHeight(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.x;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void createCharacterControllerDescriptor(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = new PlayerAvatarDescriptor(J93.CHARACTERCONTROLLER);
      i.put(var0, var1);
      o.put(var0, 1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static Vector3 getVehicleOrientationCorrectionStrengths(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? Vector3.g : var1.j.bb;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setMaxJumpSlope(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.z = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleVisualRollStrength(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.t;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setMinSlideSlope(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.t = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getMinSlideSlope(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.t;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleSuspensionStiffness(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.d = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleSuspensionStiffness(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.d;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setCapsuleYShape(@ScriptID Integer var0, float var1, float var2) {
      PlayerAvatarDescriptor var3 = (PlayerAvatarDescriptor)i.get(var0);
      var3.q = W94.CAPSULE_Y;
      var3.e = var1;
      var3.b = var2;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleSuspensionCompression(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.q;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleSuspensionDamping(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.j = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleSuspensionDamping(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.j;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleMaxSuspensionForce(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.e = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleMaxSuspensionForce(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.e;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleMaximumBrakingForce(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.ak;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleSuspensionRestLength(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.h;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleWheelSpinRateOnSkid(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.s = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleWheelSpinRateOnSkid(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.s;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleMaxSuspensionTravel(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.b = var1 * 100.0F;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleMaxSuspensionTravel(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.b / 100.0F;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleWheelFrictions(@ScriptID Integer var0, float var1, float var2, float var3, float var4, @ScriptDefaults(defaultNumber = 1.0D) float var5, @ScriptDefaults(defaultNumber = 1.0D) float var6) {
      PlayerAvatarDescriptor var7 = (PlayerAvatarDescriptor)i.get(var0);
      var7.j.l = var1;
      var7.j.w = var2;
      var7.j.r = var5;
      var7.j.v = var3;
      var7.j.y = var4;
      var7.j.p = var6;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getFrontForwardToLateralFrictionRatio(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j.r;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getRearForwardToLateralFrictionRatio(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j.p;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleWheelFriction(@ScriptID Integer var0, boolean var1, boolean var2) {
      PlayerAvatarDescriptor var3 = (PlayerAvatarDescriptor)i.get(var0);
      if (var1) {
         if (var2) {
            return var3.j == null ? 0.0F : var3.j.w;
         } else {
            return var3.j == null ? 0.0F : var3.j.y;
         }
      } else if (var2) {
         return var3.j == null ? 0.0F : var3.j.l;
      } else {
         return var3.j == null ? 0.0F : var3.j.v;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setMaxTorqueAtLowSpeed(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.aq = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getMaxJumpSlope(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.z;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleWheelRadius(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.x = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleWheelRadius(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.x;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleWheelWidth(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.u = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleWheelWidth(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.u;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetVehicleRollInfluence(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.z = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setExtraAngularPitchVelocityOnTransformation(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.be = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetMaxTorqueAtLowSpeed(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.aq;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setActivationHandler(@ScriptID Integer var0, EventHandler var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.n = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleBlendSpeedToVertical(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.bz = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleVisualPitchStrength(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.k;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetVehicleVisualRollSpeed(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.m = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleVisualRollSpeed(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.m;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setRestitution(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.y = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static Vector3 GetInertiaScaleRelativeToShape(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.p;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleSuspensionRestLength(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.h = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getVehicleMaxAngularVelocity(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.bv;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleVisualPitchMaxAngle(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.o;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static Vector3 getVehicleOrientationCorrectionLimits_hard(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? Vector3.g : var1.j.bt;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleAxlePointX(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.a;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetVehicleReverseAccelerationAtSpeed(@ScriptID Integer var0, float var1, float var2) {
      PlayerAvatarDescriptor var3 = (PlayerAvatarDescriptor)i.get(var0);
      var3.j.af.add(new Float(var1));
      var3.j.av.add(new Float(var2));
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleAxlePointZ(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.c;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleEnginePower(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.ag = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleEnginePower(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.ag;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void VehicleAccelerationCurve_Clear(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      var1.j.al.clear();
      var1.j.ai.clear();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetVehicleAccelerationAtSpeed(@ScriptID Integer var0, float var1, float var2) {
      PlayerAvatarDescriptor var3 = (PlayerAvatarDescriptor)i.get(var0);
      var3.j.ai.add(new Float(var1));
      var3.j.al.add(new Float(var2));
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleGraphicsPivotOffset(@ScriptID Integer var0, float var1, float var2, float var3) {
      PlayerAvatarDescriptor var4 = (PlayerAvatarDescriptor)i.get(var0);
      var4.j.bm = Vector3.g(var1, var2, var3);
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleAccelerationCurve_Acceleration(@ScriptID Integer var0, int var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      return (Float)var2.j.ai.get(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleAccelerationCurve_Speed(@ScriptID Integer var0, int var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      return (Float)var2.j.al.get(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static Vector3 getVehicleOrientationCorrectionLimits(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? Vector3.g : var1.j.bi;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void VehicleReverseAccelerationCurve_Clear(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      var1.j.av.clear();
      var1.j.af.clear();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleTopSpeedInReverse(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.ah;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleReverseAccelerationCurve_Acceleration(@ScriptID Integer var0, int var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      return (Float)var2.j.af.get(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleReverseAccelerationCurve_Speed(@ScriptID Integer var0, int var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      return (Float)var2.j.av.get(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetVehicleVisualPitchStrength(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.k = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleRollingFriction(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.ac = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleDrivingAxles(@ScriptID Integer var0, boolean var1, boolean var2) {
      PlayerAvatarDescriptor var3 = (PlayerAvatarDescriptor)i.get(var0);
      var3.j.ap = var1;
      var3.j.ao = var2;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static boolean AxleIsDriving(@ScriptID Integer var0, boolean var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      return var2.j == null ? false : (var1 ? var2.j.ap : var2.j.ao);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleBrakingAxles(@ScriptID Integer var0, boolean var1, boolean var2) {
      PlayerAvatarDescriptor var3 = (PlayerAvatarDescriptor)i.get(var0);
      var3.j.aa = var1;
      var3.j.an = var2;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static boolean AxleIsBraking(@ScriptID Integer var0, boolean var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      return var2.j == null ? false : (var1 ? var2.j.aa : var2.j.an);
   }

   public PlayerAvatarDescriptor(PlayerAvatarDescriptor var1) {
      this.d = var1.d;
      this.q = var1.q;
      this.e = var1.e;
      this.h = var1.h;
      this.s = var1.s;
      this.b = var1.b;
      this.l = var1.l;
      this.w = var1.w;
      this.r = var1.r;
      this.y = var1.y;
      this.v = var1.v;
      this.p = var1.p;
      this.x = var1.x;
      this.u = var1.u;
      this.z = var1.z;
      this.t = var1.t;
      if (var1.j != null) {
         this.j = new B45(var1.j);
      }

      this.m = var1.m;
      this.n = var1.n;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static boolean AxleIsHandBraking(@ScriptID Integer var0, boolean var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      return var2.j == null ? false : (var1 ? var2.j.am : var2.j.as);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setupDumbDownSkiddingEffect(@ScriptID Integer var0, float var1, float var2) {
      PlayerAvatarDescriptor var3 = (PlayerAvatarDescriptor)i.get(var0);
      var3.j.at = var1;
      var3.j.ab = var2;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleRollInfluence(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.z;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static Vector3 getVehicleLocalAdditionalAngularDampingsOutsideLimits_hard(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? Vector3.g : var1.j.bu;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setWheelFrictionConstraintStabilityTweak(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.aw = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getRearAxlePretransformYangle(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.bk;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetVehicleTopSpeed(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.az = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleAxlePointY(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.f;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getVehicleInertiaContactResolutionScale(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.by;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleSuspensionCompression(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.q = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setOnWallGravityMultiplier(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      if (var1 < 1.0F) {
         logger.warn("lua::SetOnWallGravityMultiplier(): OnWallGravityMultiplier should be >= 1. Supplied value: {}", var1);
      }

      var2.r = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleCentreOfMassOffset(@ScriptID Integer var0, float var1, float var2, float var3) {
      PlayerAvatarDescriptor var4 = (PlayerAvatarDescriptor)i.get(var0);
      var4.j.ay = new Vector3(var1, var2, var3);
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static Vector3 getVehicleCentreOfMassOffset(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? Vector3.g : var1.j.ay;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleCentreOfWheelsOffset(@ScriptID Integer var0, float var1, float var2, float var3) {
      PlayerAvatarDescriptor var4 = (PlayerAvatarDescriptor)i.get(var0);
      var4.j.ae = new Vector3(var1, var2, var3);
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleCentreOfMassOffsetY(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.ay = var2.j.ay.an(var1);
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleCentreOfShapeOffset(@ScriptID Integer var0, float var1, float var2, float var3) {
      PlayerAvatarDescriptor var4 = (PlayerAvatarDescriptor)i.get(var0);
      var4.j.ad = new Vector3(var1, var2, var3);
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleMassContactResolutionScale(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.bx;
   }

   public static RotTrans s(PlayerAvatarDescriptor var0, RotTrans var1, boolean var2) {
      if (var0.d == J93.VEHICLE) {
         I48 var3 = I48.r(var0.j.ay);
         if (var2) {
            I48.o(var3, var0.j.ad);
         }

         I48.t(var3);
         I48.al(var3, var1.rot);
         var1 = var1.l(var3);
         I48.y(var3);
      }

      return var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static Vector3 GetVehicleLocalAngularDampings(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? Vector3.g : var1.j.bn;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetWheelFrictionConstraintStabilityTweak(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.aw;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getVehicleMaxLinearVelocity(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.br;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleMaxAngularVelocity(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.bv = var1;
      q(var0);
   }

   E6 e(DiscreteDynamicsWorld var1) {
      // $FF: Couldn't be decompiled
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setMaxWalkSlope(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.u = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleContactResolutionScales(@ScriptID Integer var0, float var1, float var2) {
      PlayerAvatarDescriptor var3 = (PlayerAvatarDescriptor)i.get(var0);
      var3.j.bx = var1;
      var3.j.by = var2;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleAxlePoint(@ScriptID Integer var0, float var1, float var2, float var3) {
      PlayerAvatarDescriptor var4 = (PlayerAvatarDescriptor)i.get(var0);
      var4.j.a = var1;
      var4.j.f = var2;
      var4.j.c = var3;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getLeftWheelPretransformZangle(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.bq;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setRightWheelPretransformZangle(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.bo = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getRightWheelPretransformZangle(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.bo;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setFrontAxlePretransformXangle(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.bl = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getFrontAxlePretransformXangle(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.bl;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setFrontAxlePretransformYangle(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.bw = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getFrontAxlePretransformYangle(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.bw;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setRearAxlePretransformXangle(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.bj = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getRearAxlePretransformXangle(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.bj;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setRearAxlePretransformYangle(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.bk = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static boolean IsBody(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.d == J93.BODY;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setSteeringScale(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.bh = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getSteeringScale(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.bh;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetVehicleVisualRollMaxAngle(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.n = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getForkLeanAngle(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.bp;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetDumbDownSkiddingEffectAngleRatio(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.ab;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getMiddleWhellOffsetFromRear(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.bd;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleSteeringCharacteristics(@ScriptID Integer var0, float var1, float var2, float var3, float var4) {
      PlayerAvatarDescriptor var5 = (PlayerAvatarDescriptor)i.get(var0);
      var5.j.ar = var1;
      var5.j.ax = var2;
      var5.j.au = var3;
      var5.j.aj = var4;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetHighEndSteeringSpeed(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.ax;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetHighEndSteeringFullLockAngle(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.au;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetSteeringChangeRate(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.aj;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleBrakingCharacteristics(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.ak = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static boolean IsVehicle(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.d == J93.VEHICLE;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleLeanAmount(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.bf = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleLeanAmount(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j != null && !Float.isNaN(var1.j.bf) ? var1.j.bf : 0.0F;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleLocalAngularDampings(@ScriptID Integer var0, float var1, float var2, float var3) {
      PlayerAvatarDescriptor var4 = (PlayerAvatarDescriptor)i.get(var0);
      var4.j.bn = new Vector3(var1, var2, var3);
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetDumbDownSkiddingEffectStrength(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.at;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getMass(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.l;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleOrientationCorrectionLimits_hard(@ScriptID Integer var0, float var1, float var2, float var3) {
      PlayerAvatarDescriptor var4 = (PlayerAvatarDescriptor)i.get(var0);
      var4.j.bt = new Vector3(var1, var2, var3);
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int GetVehicleReverseAccelerationCurve_NumPoints(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j.af.size();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getVehicleBlendSpeedToVertical(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.bz;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleBlendSpeedToSurface(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.bc = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getVehicleBlendSpeedToSurface(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.bc;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setMiddleWhellOffsetFromRear(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.bd = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleLocalAdditionalAngularDampingsOutsideLimits(@ScriptID Integer var0, float var1, float var2, float var3) {
      PlayerAvatarDescriptor var4 = (PlayerAvatarDescriptor)i.get(var0);
      var4.j.bg = new Vector3(var1, var2, var3);
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleLocalAdditionalAngularDampingsOutsideLimits_hard(@ScriptID Integer var0, float var1, float var2, float var3) {
      PlayerAvatarDescriptor var4 = (PlayerAvatarDescriptor)i.get(var0);
      var4.j.bu = new Vector3(var1, var2, var3);
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static Vector3 getVehicleLocalAdditionalAngularDampingsOutsideLimits(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? Vector3.g : var1.j.bg;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static Vector3 getVehicleCentreOfShapeOffset(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? Vector3.g : var1.j.ad;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setBikeVerticalDisplacementOnLean(@ScriptID Integer var0, float var1) {
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleOrientationCorrectionStrengths(@ScriptID Integer var0, float var1, float var2, float var3) {
      PlayerAvatarDescriptor var4 = (PlayerAvatarDescriptor)i.get(var0);
      var4.j.bb = new Vector3(var1, var2, var3);
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleOrientationCorrectionStrengths_hard(@ScriptID Integer var0, float var1, float var2, float var3) {
      PlayerAvatarDescriptor var4 = (PlayerAvatarDescriptor)i.get(var0);
      var4.j.ba = new Vector3(var1, var2, var3);
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetVehicleVisualPitchSpeed(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.i = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static Vector3 getVehicleOrientationCorrectionStrengths_hard(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? Vector3.g : var1.j.ba;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void createVehicleDescriptor(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = new PlayerAvatarDescriptor(J93.VEHICLE);
      var1.j = new B45();
      i.put(var0, var1);
      o.put(var0, 1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float getExtraAngularPitchVelocityOnTransformation(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.be;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setControlHandler(@ScriptID Integer var0, EventHandler var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      if (k.add(var0)) {
         logger.debug("NEW DESCRIPTOR HASH: " + var0);
      }

      var2.m = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleHandBrakingAxles(@ScriptID Integer var0, boolean var1, boolean var2) {
      PlayerAvatarDescriptor var3 = (PlayerAvatarDescriptor)i.get(var0);
      var3.j.am = var1;
      var3.j.as = var2;
      q(var0);
   }

   public static PlayerAvatarDescriptor g(int var0) {
      return (PlayerAvatarDescriptor)i.get(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void SetVehicleVisualPitchMaxAngle(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.o = var1;
      q(var0);
   }

   static void q(int var0) {
      Integer var1 = (Integer)o.get(var0);
      if (var1 == null) {
         var1 = 0;
      }

      o.put(var0, var1 + 1);
   }

   public static PlayerAvatarDescriptor j(int var0, int var1) {
      PlayerAvatarDescriptor var2 = new PlayerAvatarDescriptor((PlayerAvatarDescriptor)i.get(var0));
      i.put(var1, var2);
      o.put(var1, 1);
      return var2;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static Vector3 getVehicleCentreOfWheelsOffset(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? Vector3.g : var1.j.ae;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setVehicleOrientationCorrectionLimits(@ScriptID Integer var0, float var1, float var2, float var3) {
      PlayerAvatarDescriptor var4 = (PlayerAvatarDescriptor)i.get(var0);
      var4.j.bi = new Vector3(var1, var2, var3);
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetDimension3(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.s;
   }

   public static RotTrans b(PlayerAvatarDescriptor var0, RotTrans var1) {
      return s(var0, var1, false);
   }

   public static RotTrans l(PlayerAvatarDescriptor var0, RotTrans var1) {
      if (var0.d == J93.VEHICLE) {
         Vector3 var2 = Vector3.al(var0.j.ay, var1.rot);
         var1 = var1.b(var2);
      }

      return var1;
   }

   public static Q7 w(PlayerAvatarDescriptor var0, Q7 var1) {
      if (var0.d == J93.VEHICLE) {
         Vector3 var2 = Vector3.af(var0.j.ay, var1.d);
         var1 = var1.e(var2);
      }

      return var1;
   }

   public static float v(PlayerAvatarDescriptor var0, PlayerPhysicsAvatar var1) {
      if (var1 != null && var1.q != null && var1.d != null && var1.d.d != null) {
         Quaternion var2 = var1.q.as().q();
         Vector3 var3 = var1.q.l();
         Vector3 var4 = Vector3.al(Vector3.g(0.0F, 0.0F, 1.0F), var2);
         float var5 = Vector3.o(var3, var4);
         Vector3 var6 = var1.q.w();
         Vector3 var7 = Vector3.al(Vector3.g(0.0F, 1.0F, 0.0F), var2);
         float var8 = Vector3.o(var6, var7) * var0.j.bf;
         float var9 = Vector3.f(DiscreteDynamicsWorld.af(var1.d.d));
         float var10 = (float)Math.atan((double)(var5 * var8 / var9));
         return var10;
      } else {
         return 0.0F;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static void setForkLeanAngle(@ScriptID Integer var0, float var1) {
      PlayerAvatarDescriptor var2 = (PlayerAvatarDescriptor)i.get(var0);
      var2.j.bp = var1;
      q(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static Vector3 getAabbFullSize(@ScriptID Integer var0) {
      // $FF: Couldn't be decompiled
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int GetVehicleAccelerationCurve_NumPoints(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j.ai.size();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleRollingFriction(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.ac;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static Vector3 getVehicleGraphicsPivotOffset(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? Vector3.g : var1.j.bm;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static float GetVehicleTopSpeed(@ScriptID Integer var0) {
      PlayerAvatarDescriptor var1 = (PlayerAvatarDescriptor)i.get(var0);
      return var1.j == null ? 0.0F : var1.j.az;
   }
}
