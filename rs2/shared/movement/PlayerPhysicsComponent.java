package rs2.shared.movement;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import com.jagex.game.runetek6.comms.statestream.SourceLossyStateStream;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import com.jagex.game.runetek6.script.ScriptManager;
import com.jagex.jnibindings.runetek6.Scripting$ScriptIDMap;
import com.jagex.jnibindings.runetek6.StaticModel;
import com.jagex.jnibindings.runetek6.jagbullet.BulletVehicle;
import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import com.jagex.jnibindings.runetek6.jagbullet.D194;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.L8;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.maths.E41;
import com.jagex.maths.I48;
import com.jagex.maths.M47;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import com.jagex.maths.Z165;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ao128;
import tfu.Be2;
import tfu.Bs1;
import tfu.Gh19;
import tfu.Gj16;
import tfu.Gn5;
import tfu.Lb33;
import tfu.Lq191;

@ScriptEntryClass
public class PlayerPhysicsComponent extends Component {
   private static final int a = 10;
   static final Map ab = new HashMap();
   private static final int ag = 13;
   private static final int ai = 15;
   private static final String[] al = new String[]{"T_lFrontSuspensionJ", "T_rFrontSuspensionJ", "T_lFrontWheelJ", "T_rFrontWheelJ", "T_lRearSuspensionJ", "T_rRearSuspensionJ", "T_lRearWheelJ", "T_rRearWheelJ", "T_lMidSuspensionJ", "T_rMidSuspensionJ", "T_lMidWheelJ", "T_rMidWheelJ", "T_FrontSuspensionJ", "T_RearSuspensionJ", "T_FrontWheelJ", "T_RearWheelJ"};
   private static final int aq = 14;
   static float ar = 1.0F;
   public static boolean as = false;
   public static final int at = StringTools.l(PlayerPhysicsComponent.class.getName());
   static int aw = 0;
   private static final int c = 12;
   public static boolean d = true;
   private static final int f = 11;
   private static final int i = 8;
   private static final int k = 7;
   private static final Logger logger = LoggerFactory.getLogger(PlayerPhysicsComponent.class);
   private static final int m = 5;
   private static final int n = 6;
   private static final int o = 9;
   private static final int p = 0;
   private static final int t = 4;
   private static final int u = 2;
   private static final int x = 1;
   private static final int z = 3;
   private final Ag183 aa;
   private final ScriptManager ac;
   private final RotTrans[] af;
   private final PlayerPhysicsAvatar ah;
   public boolean am;
   public float an;
   private boolean ao;
   private C184 ap;
   private Map av;
   private Map az;
   U186 b;
   public Vector3 e;
   public Vector3 h;
   private RotTrans j;
   private I187 l;
   public final M188 q;
   private int r;
   final boolean s;
   private Vector3 v;
   private Integer w;
   private Vector3 y;

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float GetVehicleCurveReverseAccelerationMultiplier() {
      return this.ah.b != null && this.ah.w != null ? this.ah.w.v : 0.0F;
   }

   public static void g(PlayerPhysicsComponent var0, I187 var1) {
      var0.l = var1;
      PlayerPhysicsAvatar.g(var0.ah, var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float vehicleGetFrictionDissipationReductionEffect() {
      return this.ah.b != null ? this.ah.b.p : 0.0F;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public PlayerPhysicsAvatar getAvatar(boolean var1) {
      return this.ah;
   }

   public static void q(PlayerPhysicsComponent var0, M47 var1, boolean var2, boolean var3) {
      if (var2) {
         PlayerPhysicsAvatar.s(var0.ah, var1);
      }

   }

   public static void j(PlayerPhysicsComponent var0, Vector3 var1, boolean var2, boolean var3) {
      if (var2) {
         PlayerPhysicsAvatar.h(var0.ah, var1);
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getVehicleLeanAngles(boolean var1) {
      return PlayerPhysicsAvatar.r(this.ah);
   }

   private static void r(PlayerPhysicsComponent var0) {
      PlayerPhysicsAvatar.q(var0.ah);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setLinearVelocity(Vector3 var1, boolean var2, boolean var3) {
      if (this.ap != null) {
         this.ap.d("setLinearVelocity", var1);
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      h(this, var1, var2, var3);
   }

   public static void h(PlayerPhysicsComponent var0, Vector3 var1, boolean var2, boolean var3) {
      if (var2 && var0.ah != null) {
         if (var0.ah.q != null) {
            RigidBody.s(var0.ah.q, var1);
         } else if (var0.ah.j != null) {
            var0.ah.h = var1;
         }
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setAngularVelocity(Vector3 var1, boolean var2, boolean var3) {
      if (this.ap != null) {
         this.ap.d("setAngularVelocity", var1);
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      s(this, var1, var2, var3);
   }

   public static void s(PlayerPhysicsComponent var0, Vector3 var1, boolean var2, boolean var3) {
      if (var2 && var0.ah != null) {
         if (var0.ah.q != null) {
            RigidBody.b(var0.ah.q, var1);
         } else if (var0.ah.j != null) {
            var0.ah.s = var1;
         }
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float vehicleGetInducedDriftEffect() {
      return this.ah.b != null ? this.ah.b.v : 1.0F;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public RotTrans entityRotTransToPhysicsSpace(RotTrans var1) {
      return var1;
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public String getJointTransformTarget(int var1) {
      return al[var1];
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
   public Vector3 physicsVectorToEntitySpace(Vector3 var1) {
      return var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float getLinearSpeed(boolean var1) {
      if (this.ah == null) {
         return 0.0F;
      } else if (this.ah.q != null) {
         return Vector3.f(this.ah.q.l());
      } else {
         return this.ah.j != null ? Vector3.f(this.ah.h) : 0.0F;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float getInclination(boolean var1) {
      Quaternion var2 = this.getOrientation(var1);
      Vector3 var3 = Vector3.al(Vector3.g(0.0F, 0.0F, 1.0F), var2);
      return (float)Math.atan2((double)var3.y, (double)((float)Math.sqrt((double)(var3.x * var3.x + var3.z * var3.z))));
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float getAngularSpeed(boolean var1) {
      if (this.ah == null) {
         return 0.0F;
      } else if (this.ah.q != null) {
         return Vector3.f(this.ah.q.w());
      } else {
         return this.ah.j != null ? Vector3.f(this.ah.s) : 0.0F;
      }
   }

   public static void d(PlayerPhysicsComponent var0, Q7 var1, boolean var2, boolean var3) {
      if (var2) {
         PlayerPhysicsAvatar.e(var0.ah, var1);
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getAABBMinCorner() {
      if (this.ah.e != null) {
         E41 var1 = this.ah.e.at();
         return var1.j();
      } else {
         return null;
      }
   }

   public static void l(PlayerPhysicsComponent var0) {
      var0.am = false;
      r(var0);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public GameEntity[] getEntitiesInSwingArea(boolean var1, float var2, float var3, float var4, float var5, float var6, @ScriptDefaults(defaultInteger = 100) int var7) {
      if (this.ah != null && this.ah.e != null) {
         Q7 var8 = this.ah.getCurrentTransform();
         return this.ah.d.getEntitiesInSwingArea(Vector3.m(var8.g, 0.0F, var4, 0.0F), var2, var3, var5, var6, 0.0F, Gn5.PLAYER_VOLUME_QUERY.ordinal(), CollisionObject.ab(this.ah.e), var7);
      } else {
         return null;
      }
   }

   public PlayerPhysicsComponent(I187 var1, ScriptManager var2, boolean var3) {
      this.j = RotTrans.g;
      this.e = Vector3.g;
      this.h = Vector3.g;
      this.s = true;
      this.b = null;
      this.l = null;
      this.w = null;
      this.r = -1;
      this.v = Vector3.g;
      this.y = Vector3.g;
      this.af = new RotTrans[al.length];
      this.av = new Scripting$ScriptIDMap();
      this.az = new Scripting$ScriptIDMap();
      this.ah = new PlayerPhysicsAvatar();
      this.ap = null;
      this.ao = false;
      this.aa = new Ag183();
      this.an = Float.NaN;
      this.am = true;
      if (var2 == null) {
         throw new IllegalArgumentException("Null ScriptManager instance.");
      } else {
         g(this, var1);
         this.ac = var2;
         if (this.l.d()) {
            this.q = new M188(var3);
         } else {
            this.q = null;
         }

         for(int var4 = 0; var4 < this.af.length; ++var4) {
            this.af[var4] = RotTrans.g;
         }

      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean canJump() {
      return this.ah.j != null ? this.ah.j.x() : false;
   }

   private static RotTrans x(PlayerPhysicsComponent var0, RotTrans var1, boolean var2) {
      if (var1 == null) {
         return null;
      } else {
         if (var0.w != null) {
            PlayerAvatarDescriptor var3 = PlayerAvatarDescriptor.g(var0.w);
            if (var2) {
               var1 = PlayerAvatarDescriptor.b(var3, var1);
               Vector3 var4 = Vector3.al(Vector3.g(0.0F, -PlayerAvatarDescriptor.h(var3) / 2.0F, 0.0F), var1.rot);
               var1 = var1.b(var4);
            }

            RotTrans var5 = PlayerAvatarDescriptor.r(var3, var0.ah);
            if (var5 != null) {
               var5 = var0.j.p(var5, 0.1F);
               var0.j = var5;
               var1 = var5.e(var1);
            } else {
               var0.j = RotTrans.g;
            }
         }

         var1 = var1.s(Gh19.g);
         return var1;
      }
   }

   public void u() {
      if (this.ah.d != null && this.q != null) {
         Vector3 var1 = this.getLinearVelocity(false);
         Vector3 var2 = this.getAngularVelocity(false);
         float var3 = this.getVerticalVelocity();
         U186 var4 = (U186)M188.g(this.q);
         if (var4 == null) {
            var4 = new U186();
         }

         var4.p = var1;
         var4.x = var2;
         var4.u = var3;
         PlayerPhysicsAvatar var5 = this.ah;
         RotTrans var6 = Q7.d(var5.getCurrentTransform());
         var4.g = x(this, var6, true);
         if (this.w != null) {
            PlayerAvatarDescriptor var7 = PlayerAvatarDescriptor.g(this.w);
            if (var7 != null && var7.d == J93.VEHICLE) {
               Vector3 var8 = Vector3.al(var7.j.bm, var4.g.rot);
               var8 = Vector3.k(var8, Vector3.al(new Vector3(0.0F, PlayerAvatarDescriptor.h(var7) / 2.0F, 0.0F), var4.g.rot));
               RotTrans var9 = x(this, var6.b(var8), true);
               Vector3 var10 = Vector3.k(var5.b.e.l(), var5.b.s);
               Quaternion var11;
               Vector3 var12;
               float var13;
               float var14;
               float var15;
               Quaternion var16;
               RotTrans var17;
               if ((double)var7.j.t != 0.0D) {
                  var11 = var5.b.e.ao().d.q();
                  var12 = Vector3.al(Vector3.g(1.0F, 0.0F, 0.0F), var11);
                  var13 = Vector3.o(var10, var12);
                  var14 = var7.j.m;
                  var13 = var14 * var13 + (1.0F - var14) * var5.b.b;
                  var5.b.b = var13;
                  var15 = var7.j.t * var13;
                  if (Math.abs(var15) > var7.j.n) {
                     var15 *= var7.j.n / Math.abs(var15);
                  }

                  var16 = Quaternion.j(Vector3.j, -var15);
                  var17 = new RotTrans(var16, Vector3.g);
                  var9 = var9.h(var17);
               }

               if ((double)var7.j.k != 0.0D) {
                  var11 = var5.b.e.ao().d.q();
                  var12 = Vector3.al(Vector3.g(0.0F, 0.0F, 1.0F), var11);
                  var13 = Vector3.o(var10, var12);
                  var14 = var7.j.i;
                  var13 = var14 * var13 + (1.0F - var14) * var5.b.l;
                  var5.b.l = var13;
                  var15 = var7.j.k * var13;
                  if (Math.abs(var15) > var7.j.o) {
                     var15 *= var7.j.o / Math.abs(var15);
                  }

                  var16 = Quaternion.j(Vector3.d, var15);
                  var17 = new RotTrans(var16, Vector3.g);
                  var9 = var9.h(var17);
               }

               var4.g = var9;
               var4.e = x(this, Q7.d(PlayerPhysicsAvatar.l(var5, 0)), false);
               var4.q = x(this, Q7.d(PlayerPhysicsAvatar.b(var5, 0)), false);
               var4.l = x(this, Q7.d(PlayerPhysicsAvatar.l(var5, 1)), false);
               var4.s = x(this, Q7.d(PlayerPhysicsAvatar.b(var5, 1)), false);
               Vector3 var18;
               if (var7.j.bd != 0.0F) {
                  var18 = Vector3.g(0.0F, 0.0F, var7.j.bd);
                  var12 = Vector3.al(var18, var4.g.rot);
                  var4.y = x(this, Q7.d(PlayerPhysicsAvatar.l(var5, 1)), false).b(var12);
                  var4.r = x(this, Q7.d(PlayerPhysicsAvatar.b(var5, 1)), false).b(var12);
               }

               if (BulletVehicle.g(var5.b) > 2) {
                  var4.j = x(this, Q7.d(PlayerPhysicsAvatar.l(var5, 2)), false);
                  var4.d = x(this, Q7.d(PlayerPhysicsAvatar.b(var5, 2)), false);
                  var4.b = x(this, Q7.d(PlayerPhysicsAvatar.l(var5, 3)), false);
                  var4.h = x(this, Q7.d(PlayerPhysicsAvatar.b(var5, 3)), false);
                  if (var7.j.bd != 0.0F) {
                     var18 = Vector3.g(0.0F, 0.0F, var7.j.bd);
                     var12 = Vector3.al(var18, var4.g.rot);
                     var4.v = x(this, Q7.d(PlayerPhysicsAvatar.l(var5, 3)), false).b(var12);
                     var4.w = x(this, Q7.d(PlayerPhysicsAvatar.b(var5, 3)), false).b(var12);
                  }
               }
            }
         }

         M188.d(this.q, var4);
         var4.z = System.nanoTime();
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setOrientation(Quaternion var1, boolean var2, boolean var3) {
      if (this.ap != null) {
         this.ap.d("setOrientation", var1);
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      q(this, var1.m(), var2, var3);
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public int getJointTransformCount() {
      return this.af.length;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void controlOnWithParameters(@ScriptID Integer var1, int var2, float... var3) {
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public PhysicsWorldWrapper getDisplayWorld() {
      return this.ah.d;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float vehicleGetWheelSuspensionCompression(int var1) {
      return this.ah.b != null ? this.ah.b.h(var1) : 0.0F;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Integer GetCurrentDescriptor() {
      return m(this, false);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int getComponentTypeID() {
      return at;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetVehicleCurveReverseSpeedMultiplier(float var1) {
      if (this.ah.b != null && this.ah.w != null) {
         this.ah.w.y = var1;
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void clearControl(String var1, @ScriptDefaults(defaultInteger = 0) int var2) {
      if (var2 < 0) {
         throw new IllegalArgumentException("timestampOffset must be >=0!");
      } else {
         this.setControl(var1, (Object)null, var2);
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void clearAllControls(@ScriptDefaults(defaultInteger = 0) int var1) {
      if (var1 < 0) {
         throw new IllegalArgumentException("timestampOffset must be >=0!");
      } else if (this.l.q()) {
         GameEntity var2 = this.getEntity();
         if (var2 == null) {
            throw new RuntimeException("entity is null for PlayerPhysicsComponent");
         } else if (this.l.d() && GameEntity.ej(var2, "__clientControlStreamMaster") == Boolean.FALSE) {
            throw new IllegalStateException("Can't set client-side controls for other people!");
         } else {
            SourceLossyStateStream var3 = (SourceLossyStateStream)GameEntity.ej(var2, this.l.d() ? "__clientControlStream" : "__serverControlStream");
            if (var3 != null) {
               int var4 = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(this.l.j(), var1);
               K189 var5 = (K189)var3.getState(var4);
               K189 var6 = (K189)var3.factory.duplicateState(var5);
               var6.g.clear();
               var6.d.clear();
               var3.putState(var6, var4);
            }

         }
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void flushControls() {
      Lb33.g(Lb33.FlushControls);
      this.getEntity().eh("__PHYSICSFLUSH", (Object)null);
      Lb33.d(Lb33.FlushControls);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void characterJumpByHeight(float var1) {
      if (this.ap != null) {
         this.ap.d("characterJumpByHeight", var1);
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      PlayerAvatarDescriptor var3 = t(this, false);
      float var2;
      if (var3 == null) {
         var2 = (float)Math.sqrt((double)(2.0F * -DiscreteDynamicsWorld.af(this.ah.d.d).y * var1));
      } else {
         var2 = (float)Math.sqrt((double)(2.0F * var3.w * var1));
      }

      this.ah.j.r(var2);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getWheelEntitySpaceUp() {
      Quaternion var1 = this.getOrientation(false);
      Vector3 var2 = Vector3.g(0.0F, 1.0F, 0.0F);
      return Vector3.al(var2, var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void controlOff(@ScriptID Integer var1, @ScriptDefaults(defaultInteger = 0) int var2) {
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void controlNeutral(@ScriptID Integer var1, @ScriptDefaults(defaultInteger = 0) int var2) {
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void allControlsNeutral(@ScriptDefaults(defaultInteger = 0) int var1) {
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void ignoreControlRaw(@ScriptID Integer var1, float var2) {
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setDescriptor(String var1) {
      Integer var2 = null;
      if (var1 != null) {
         var2 = StringTools.l(var1);
      }

      if (var2 != null && PlayerAvatarDescriptor.g(var2) == null) {
         logger.error("Attempted to set non-existent player avatar descriptor " + var1 + " - ignoring", new Ao128());
      } else if (this.l.q()) {
         logger.debug("descriptor set to {}", var2);
         GameEntity var3 = this.getEntity();
         if (this.l.d() && GameEntity.ej(var3, "__clientControlStreamMaster") == Boolean.FALSE) {
            throw new IllegalStateException("Can't set client-side controls for other people!");
         } else {
            SourceLossyStateStream var4 = (SourceLossyStateStream)GameEntity.ej(var3, this.l.d() ? "__clientControlStream" : "__serverControlStream");
            if (var4 != null) {
               int var5 = this.l.j();
               K189 var6 = (K189)var4.factory.duplicateState(var4.getState(var5));
               var6.q = var2;
               var4.putState(var6, var5);
            }

         }
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void kick(Vector3 var1, float var2, @ScriptDefaults(defaultNumber = 1000.0D) float var3, @ScriptDefaults(defaultInteger = 0) int var4) {
      if (this.l.q()) {
         GameEntity var5 = this.getEntity();
         if (var2 < 0.0F) {
            logger.warn("Kick(): _decceleration must be >= 0.0f");
         }

         if (this.l.d() && GameEntity.ej(var5, "__clientControlStreamMaster") == Boolean.FALSE) {
            throw new IllegalStateException("Can't set client-side controls for other people!");
         } else {
            SourceLossyStateStream var6 = (SourceLossyStateStream)GameEntity.ej(var5, this.l.d() ? "__clientControlStream" : "__serverControlStream");
            if (var6 != null) {
               int var7 = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(this.l.j(), var4);
               K189 var8 = (K189)var6.factory.duplicateState(var6.getState(var7));
               var8.j = new Av190(var1, var2, var7, var3);
               var6.putState(var8, var7);
            }

         }
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean IsDescriptorActive(@ScriptID Integer var1) {
      boolean var2;
      if (var1 == null) {
         var2 = this.w == null;
      } else {
         var2 = var1.equals(this.w);
      }

      return var2;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getPosition(boolean var1) {
      if (this.ah == null) {
         if (++aw % (int)ar == 0) {
            ar = (float)((double)ar * 1.2D);
            logger.debug("GetPosition() returned zero position as there is no avatar. Or a lost lua reference used.");
         }

         return Vector3.g;
      } else {
         Vector3 var2 = null;
         if (this.ah.e != null) {
            var2 = this.ah.e.an();
         }

         if (var2 == null) {
            if (++aw % (int)ar == 0) {
               ar = (float)((double)ar * 1.2D);
               logger.debug("GetPosition() returned zero position as there is no physics for player. Or a lost lua reference used.");
            }

            return Vector3.g;
         } else {
            return var2;
         }
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void controlOn(@ScriptID Integer var1, @ScriptDefaults(defaultInteger = 0) int var2) {
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setPosition(Vector3 var1, boolean var2, boolean var3) {
      if (this.ap != null) {
         this.ap.d("setPosition", var1);
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      j(this, var1, var2, var3);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetVehicleCurveSpeedMultiplier(float var1) {
      if (this.ah.b != null && this.ah.w != null) {
         this.ah.w.r = var1;
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Quaternion getOrientation(boolean var1) {
      if (this.ah == null) {
         return Quaternion.g;
      } else {
         Quaternion var2 = null;
         if (this.ah.e != null) {
            var2 = this.ah.e.as().q();
         }

         return var2 == null ? Quaternion.g : var2;
      }
   }

   public static void n(PlayerPhysicsComponent var0, Integer var1, boolean var2, boolean var3, int var4) {
      if (var2) {
         if (var0.w == null) {
            if (var1 != null) {
               k(var0, var1, false, var4);
            }
         } else if (!var0.w.equals(var1) || var0.r != PlayerAvatarDescriptor.d(var1)) {
            k(var0, var1, false, var4);
         }
      }

   }

   private static void k(PlayerPhysicsComponent var0, Integer var1, boolean var2, int var3) {
      Q7 var4 = null;
      var4 = var0.ah.getCurrentTransform();
      if (var4 == null) {
         var4 = v(var0, var0.w);
      }

      Vector3 var5 = var0.getLinearVelocity(var2);
      Vector3 var6 = var0.getAngularVelocity(var2);
      int var7 = var0.ah.e != null ? CollisionObject.ab(var0.ah.e) : Gj16.PLAYER.az;
      PlayerAvatarDescriptor var8 = null;
      if (!var2 && var0.w != null) {
         var8 = PlayerAvatarDescriptor.g(var0.w);
      }

      PlayerAvatarDescriptor var9 = null;
      if (var1 != null) {
         var9 = PlayerAvatarDescriptor.g(var1);
      }

      if (var8 != null && var9 != null) {
         I48 var10 = I48.w(0.0F, (PlayerAvatarDescriptor.h(var9) - PlayerAvatarDescriptor.h(var8)) / 2.0F, 0.0F);
         if (var8.d == J93.VEHICLE) {
            float var11 = var8.j.x - var8.j.f - PlayerAvatarDescriptor.h(var8) / 2.0F;
            var11 -= Vector3.f(DiscreteDynamicsWorld.af(var0.ah.d.d)) / (4.0F * var8.j.d);
            var11 -= -var8.j.ay.y;
            var10.e -= var11;
            var10.j += -var8.j.ay.x;
            var10.h += -var8.j.ay.z;
         }

         if (var9.d == J93.VEHICLE) {
            Vector3 var13 = Vector3.g(var9.j.be, 0.0F, 0.0F);
            var13 = Vector3.af(var13, var4.d);
            var6 = Vector3.z(var6, var13);
            float var12 = var9.j.x - var9.j.f - PlayerAvatarDescriptor.h(var9) / 2.0F;
            var12 -= Vector3.f(DiscreteDynamicsWorld.af(var0.ah.d.d)) / (4.0F * var9.j.d);
            var12 -= -var9.j.ay.y;
            var10.e += var12;
            var10.j -= -var9.j.ay.x;
            var10.h -= -var9.j.ay.z;
         }

         M47.s(var4.d, var10);
         var4 = var4.h(var10);
         I48.y(var10);
      }

      PlayerPhysicsAvatar.q(var0.ah);
      var0.w = var1;
      if (var9 != null) {
         var0.ah.j(var0.getEntity(), var9, var4, var5, var6, var3, var7);
         var0.r = PlayerAvatarDescriptor.d(var1);
      } else {
         var0.r = -1;
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setInterpolation(float var1) {
      if (var1 > 1.0F) {
         var1 = 1.0F;
      }

      if (var1 <= 0.0F) {
         var1 = Float.NaN;
      }

      this.an = var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean isBike() {
      if (this.w != null) {
         PlayerAvatarDescriptor var1 = PlayerAvatarDescriptor.g(this.w);
         if (var1 != null && !Float.isNaN(var1.j.bf)) {
            return true;
         }
      }

      return false;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean isVehicle() {
      return this.ah.b != null;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetVehicleTopSpeed(float var1) {
      if (this.ap != null) {
         this.ap.d("SetVehicleTopSpeed", var1);
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      if (this.ah.b != null && this.ah.w != null) {
         this.ah.w.b = var1;
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float GetVehicleTopSpeed() {
      return this.ah.b != null && this.ah.w != null ? this.ah.w.b : 0.0F;
   }

   @ScriptEntryPoint
   @Bs1
   @Be2
   public RotTrans getJointTransform(int var1) {
      Z165 var2 = new Z165(this.af[var1]);
      if (this.getEntity().v != 0L) {
      }

      return var2.b();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float GetVehicleTopSpeedInReverse() {
      return this.ah.b != null && this.ah.w != null ? this.ah.w.l : 0.0F;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setVehicleAccelerator(float var1) {
      if (this.ap != null) {
         this.ap.d("setVehicleAccelerator", var1);
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      this.aa.g = true;
      this.aa.d = var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetVehicleCurveAccelerationMultiplier(float var1) {
      if (this.ah.b != null && this.ah.w != null) {
         this.ah.w.w = var1;
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float GetVehicleCurveAccelerationMultiplier() {
      return this.ah.b != null && this.ah.w != null ? this.ah.w.w : 0.0F;
   }

   public E181 e(E181 var1, boolean var2) {
      if (this.ah.e != null) {
         if (var1 == null) {
            var1 = new E181();
         }

         var1.g = this.ah.e.ao();
         if (this.ah.q != null) {
            var1.d = this.ah.q.l();
            var1.q = this.ah.q.w();
            return var1;
         } else if (this.ah.j != null) {
            var1.d = this.ah.h.an(this.ah.j.y());
            var1.q = this.ah.s;
            return var1;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void vehicleStopFrictionDissipationReduction() {
      if (this.ap != null) {
         this.ap.d("vehicleStopFrictionDissipationReduction");
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      if (this.ah.b != null) {
         this.ah.b.p = 0.0F;
         this.ah.b.x = 0.0F;
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float GetVehicleCurveSpeedMultiplier() {
      return this.ah.b != null && this.ah.w != null ? this.ah.w.r : 0.0F;
   }

   public static Integer m(PlayerPhysicsComponent var0, boolean var1) {
      return var0.w;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float GetVehicleCurveReverseSpeedMultiplier() {
      return this.ah.b != null && this.ah.w != null ? this.ah.w.y : 0.0F;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setVehicleSteering(float var1) {
      if (this.ap != null) {
         this.ap.d("setVehicleSteering", var1);
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      this.aa.g = true;
      this.aa.q = var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float getVehicleSteeringAngle() {
      return this.ah.w.j;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public RotTrans getCurrentTransform() {
      return Q7.d(this.ah.getCurrentTransform());
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void vehicleSteerRight() {
      if (this.ap != null) {
         this.ap.d("vehicleSteerRight");
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      this.aa.g = true;
      this.aa.q = 1.0F;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void vehicleBrake(@ScriptDefaults(defaultNumber = 1.0D) double var1) {
      if (this.ap != null) {
         this.ap.d("vehicleBrake", var1);
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      this.aa.g = true;
      this.aa.j = Math.abs((float)var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void vehicleHandBrake(@ScriptDefaults(defaultBoolean = true) boolean var1) {
      if (this.ap != null) {
         this.ap.d("vehicleHandBrake", var1);
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      this.aa.g = true;
      this.aa.e = var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean vehicleGetWheelIsTouchingGround(int var1) {
      return this.ah.b != null ? this.ah.b.e(var1 % BulletVehicle.g(this.ah.b)) : false;
   }

   public static void p(PlayerPhysicsComponent var0, int var1, boolean var2, boolean var3, String var4) {
      boolean var5 = var2 && !var3;
      GameEntity var6 = var0.getEntity();
      y(var0, var2, var3, var1);
      LossyStateStream var7 = (LossyStateStream)GameEntity.ej(var6, "__clientControlStream");
      LossyStateStream var8 = (LossyStateStream)GameEntity.ej(var6, "__serverControlStream");
      K189 var9 = null;
      K189 var10 = null;
      if (var7 != null) {
         var9 = (K189)var7.getState(var1);
      }

      if (var8 != null) {
         var10 = (K189)var8.getState(var1);
      }

      Av190 var11 = null;
      int var12 = 0;
      if (var0.l.d()) {
         if (var9 != null && var9.j != null) {
            var11 = var9.j;
            var12 = var1;
         } else if (var10 != null) {
            var11 = var10.j;
            var12 = var1;
         }
      } else if (var10 != null && var10.j != null) {
         var11 = var10.j;
         var12 = var1;
      } else if (var9 != null) {
         var11 = var9.j;
         var12 = var1;
      }

      if (var0.ah != null && var0.ah.d != null) {
         PlayerPhysicsAvatar.v(var0.ah, var11, var1, var12, var5);
      }

      float var14;
      PlayerAvatarDescriptor var15;
      if (var0.ah != null && var0.ah.d != null) {
         Q7 var13 = var0.ah.getCurrentTransform();
         if (var13 != null) {
            var14 = var0.ah.d.d.ao(var13.g.x, var13.g.z);
            var15 = null;
            if (var0.w != null) {
               var15 = PlayerAvatarDescriptor.g(var0.w);
            }

            float var16 = var13.g.y;
            if (var15 != null && var15.j != null) {
               var16 -= var15.j.ay.y;
            }

            if (var16 < var14) {
               if (var0.w != null) {
                  var14 += PlayerAvatarDescriptor.h(var15);
               }

               var13 = var13.j(var14 + 5.0F);
               PlayerPhysicsAvatar.e(var0.ah, var13);
            }
         }
      }

      if (var0.ah != null && var0.ah.d != null) {
         PlayerAvatarDescriptor var17 = null;
         if (var0.w != null) {
            var17 = PlayerAvatarDescriptor.g(var0.w);
         }

         if (var17 != null && var0.ah.b != null && var17.j != null) {
            if (!Float.isNaN(var17.j.bf)) {
               var14 = PlayerAvatarDescriptor.v(var17, var0.ah);
               var0.ah.w(0.0F, 0.0F, var14);
               I48.p(var0.ah.w.p, 0.0F, 0.0F, 0.0F);
               var0.ah.b.v(var0.ah.w.p);
            } else {
               var0.ah.w(0.0F, 0.0F, 0.0F);
            }
         }
      }

      if (var0.ah != null && var0.ah.d != null && var0.ah.q != null) {
         var0.ah.y = var0.ah.q.l();
         var0.ah.p = var0.ah.q.w();
      }

      if (var9 != null || var10 != null) {
         var0.av.clear();
         var0.az.clear();
         var0.av.putAll(var9.g);
         Iterator var18 = var9.d.entrySet().iterator();

         Entry var19;
         while(var18.hasNext()) {
            var19 = (Entry)var18.next();
            var0.az.put(var19.getKey(), (double)((float)LossyStateStream.TIMESTAMP_WIDTH.diffIDs(var1, (Integer)var19.getValue()) * Lq191.d()) * 1.0D);
         }

         var0.av.putAll(var10.g);
         var18 = var10.d.entrySet().iterator();

         while(var18.hasNext()) {
            var19 = (Entry)var18.next();
            var0.az.put(var19.getKey(), (double)((float)LossyStateStream.TIMESTAMP_WIDTH.diffIDs(var1, (Integer)var19.getValue()) * Lq191.d()) * 1.0D);
         }

         for(int var20 = 0; var20 < 2; ++var20) {
            boolean var22 = var20 == 0;
            if ((!var22 || var2) && (var22 || var3)) {
               var15 = null;
               if (!var22 && var0.w != null) {
                  var15 = PlayerAvatarDescriptor.g(var0.w);
               }

               if (var15 != null) {
                  Ag183.g(var0.aa);
                  var0.ap = Y192.d(var4, var1, var6.bb, var0.ah, var0.av, ab);
                  var0.ao = true;
                  if (var15.m != null) {
                     var15.m.trigger(var6, new Object[]{var1, var22, var0.av, var0.az});
                  }

                  var0.aa.d(var0.ah, var1, var5, var0.ap);
                  var0.ao = false;
                  var0.ap = null;
               }
            }
         }
      }

      if (var3 && var0.ah.d != null && var0.q == null) {
         RotTrans var21 = x(var0, var0.getCurrentTransform(), true);
         if (var21 != null) {
            var0.getEntity().setWorldTransform(var21);
         }
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void vehicleStartInducedDrift(float var1, float var2) {
      if (this.ap != null) {
         this.ap.d("vehicleStartInducedDrift", var1, var2);
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      if (this.ah.b != null) {
         this.ah.b.v = var1;
         this.ah.b.y = (1.0F - var1) * DiscreteDynamicsWorld.av(this.ah.b.e.b) / var2;
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void applyForceAtPoint(Vector3 var1, Vector3 var2, boolean var3, boolean var4) {
      if (this.ap != null) {
         this.ap.d("applyForceAtPoint", var1, var2);
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      if (var3 && this.ah.q != null) {
         Vector3 var5 = this.ah.q.an();
         Vector3 var6 = Vector3.k(var2, var5);
         Vector3 var7 = Vector3.a(var6, var1);
         this.ah.q.r(var1);
         this.ah.q.v(var7);
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean isControllable() {
      if (this.l.d()) {
         Boolean var1 = (Boolean)GameEntity.ej(this.getEntity(), "__clientControlStreamMaster");
         return var1;
      } else {
         return true;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void vehicleStopInducedDrift() {
      if (this.ap != null) {
         this.ap.d("vehicleStopInducedDrift");
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      if (this.ah.b != null) {
         this.ah.b.v = 1.0F;
         this.ah.b.y = 0.0F;
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void vehicleStartLateralFrictionMultiplier(float var1, float var2) {
      if (this.ap != null) {
         this.ap.d("vehicleStartLateralFrictionMultiplier", var1, var2);
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      if (this.ah.b != null) {
         this.ah.b.w = var1;
         this.ah.b.r = (1.0F - var1) * DiscreteDynamicsWorld.av(this.ah.b.e.b) / var2;
      }

   }

   private static Q7 v(PlayerPhysicsComponent var0, Integer var1) {
      ScaleRotTrans var2 = var0.getEntity().getWorldTransform();
      RotTrans var3 = var2.q();
      Q7 var4 = Q7.g(var3);
      var4 = var4.s(Gh19.g.m());
      if (var1 != null) {
         PlayerAvatarDescriptor var5 = PlayerAvatarDescriptor.g(var1);
         if (var5 != null) {
            Vector3 var6 = Vector3.g(0.0F, PlayerAvatarDescriptor.h(var5) / 2.0F, 0.0F);
            var6 = Vector3.af(var6, var4.d);
            var4 = var4.e(var6);
            var4 = PlayerAvatarDescriptor.w(var5, var4);
         }
      }

      return var4;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getLinearVelocity(boolean var1) {
      if (this.ah == null) {
         return Vector3.g;
      } else if (this.ah.q != null) {
         return this.ah.q.l();
      } else if (this.ah.j != null) {
         Vector3 var2 = this.ah.h;
         return var2.an(this.ah.j.y());
      } else {
         return Vector3.g;
      }
   }

   public void z() {
      U186 var1 = (U186)M188.q(this.q);
      if (var1 != null) {
         U186 var2 = (U186)M188.j(this.q);
         float var3 = M188.l(this.q);
         if (M188.s && var2 != null) {
            long var4 = var1.z;
            long var6 = var2.z;
            long var8 = System.nanoTime();
            long var10 = (long)((float)var4 * (1.0F - var3) + (float)var6 * var3);
            var4 /= 1000L;
            var6 /= 1000L;
            var8 /= 1000L;
            var10 /= 1000L;
            var4 %= 1000000L;
            var6 %= 1000000L;
            var8 %= 1000000L;
            var10 %= 1000000L;
            long var12 = var8 - var10;
            if (var12 < 0L) {
               var12 += 1000000L;
            }

            Object[] var14 = new Object[]{(float)var4 / 1000.0F, (float)var6 / 1000.0F, var3, (float)var10 / 1000.0F, (float)var8 / 1000.0F, (float)var12 / 1000.0F};
            logger.debug("Tweening frames: {} ms and {} ms. tweenPos = {} This is eqivalent to {} ms.  Current time = {} ms.  Lag due to tweener = {} ms.", var14);
         }

         RotTrans var25 = var1.g;
         if (var25 != null) {
            if (var2 != null) {
               if (var2.g == null) {
                  var2 = null;
               } else {
                  var25 = var25.p(var2.g, var3);
               }
            } else {
               logger.trace("Ran out of frames");
            }

            this.getEntity().setWorldTransform(var25);
            RotTrans var5 = null;
            var5 = var25.j();
            float var26 = this.getEntity().v != 0L ? 1.0F / StaticModel.getAnimatedSgnScale(this.getEntity().v) : 1.0F;
            if (this.w != null) {
               PlayerAvatarDescriptor var7 = PlayerAvatarDescriptor.g(this.w);
               if (var7 != null && var7.d == J93.VEHICLE && this.af != null) {
                  Quaternion var28 = Quaternion.e(0.0F, 0.0F, 1.0F, var7.j.bq);
                  Vector3 var9 = Vector3.g;
                  if (this.af[0] != null) {
                     var9 = var9.aa(var7.j.u / 2.0F);
                  }

                  RotTrans var31 = new RotTrans(var28, var9);
                  RotTrans var11 = new RotTrans(var28, Vector3.g);
                  Quaternion var33 = Quaternion.e(0.0F, 0.0F, 1.0F, var7.j.bo);
                  Vector3 var13 = Vector3.g;
                  if (this.af[1] != null) {
                     var13 = var13.aa(-var7.j.u / 2.0F);
                  }

                  RotTrans var34 = new RotTrans(var33, var13);
                  RotTrans var15 = new RotTrans(var33, Vector3.g);
                  Z165 var16 = new Z165();
                  RotTrans var17 = null;
                  I48 var10000;
                  Quaternion var19;
                  if (this.af[0] != null && var5 != null) {
                     Z165.g(var16, var1.j);
                     if (var2 != null) {
                        Z165.s(var16, var2.j, var3);
                     }

                     Z165.e(var16, var11);
                     Quaternion var18 = Quaternion.e(1.0F, 0.0F, 0.0F, var7.j.bl);
                     var19 = Quaternion.e(0.0F, 1.0F, 0.0F, -var7.j.bw);
                     Z165.h(var16, var18);
                     Z165.h(var16, var19);
                     var17 = var16.b().j();
                     Z165.j(var16, var5);
                     var10000 = var16.d;
                     var10000.j *= var26;
                     var10000 = var16.d;
                     var10000.e *= var26;
                     var10000 = var16.d;
                     var10000.h *= var26;
                     this.af[0] = var16.b();
                  }

                  RotTrans var35 = null;
                  Quaternion var20;
                  if (this.af[1] != null && var5 != null) {
                     Z165.g(var16, var1.e);
                     if (var2 != null) {
                        Z165.s(var16, var2.e, var3);
                     }

                     Z165.e(var16, var15);
                     var19 = Quaternion.e(1.0F, 0.0F, 0.0F, var7.j.bl);
                     var20 = Quaternion.e(0.0F, 1.0F, 0.0F, var7.j.bw);
                     Z165.h(var16, var19);
                     Z165.h(var16, var20);
                     var35 = var16.b().j();
                     Z165.j(var16, var5);
                     var10000 = var16.d;
                     var10000.j *= var26;
                     var10000 = var16.d;
                     var10000.e *= var26;
                     var10000 = var16.d;
                     var10000.h *= var26;
                     this.af[1] = var16.b();
                  }

                  RotTrans var36 = null;
                  Quaternion var21;
                  if (this.af[4] != null && var5 != null) {
                     Z165.g(var16, var1.b);
                     if (var2 != null) {
                        Z165.s(var16, var2.b, var3);
                     }

                     Z165.e(var16, var11);
                     var20 = Quaternion.e(1.0F, 0.0F, 0.0F, var7.j.bj);
                     var21 = Quaternion.e(0.0F, 1.0F, 0.0F, -var7.j.bk);
                     Z165.h(var16, var20);
                     Z165.h(var16, var21);
                     var36 = var16.b().j();
                     Z165.j(var16, var5);
                     var10000 = var16.d;
                     var10000.j *= var26;
                     var10000 = var16.d;
                     var10000.e *= var26;
                     var10000 = var16.d;
                     var10000.h *= var26;
                     this.af[4] = var16.b();
                  }

                  RotTrans var37 = null;
                  if (this.af[5] != null && var5 != null) {
                     Z165.g(var16, var1.l);
                     if (var2 != null) {
                        Z165.s(var16, var2.l, var3);
                     }

                     Z165.e(var16, var15);
                     var21 = Quaternion.e(1.0F, 0.0F, 0.0F, var7.j.bj);
                     Quaternion var22 = Quaternion.e(0.0F, 1.0F, 0.0F, var7.j.bk);
                     Z165.h(var16, var21);
                     Z165.h(var16, var22);
                     var37 = var16.b().j();
                     Z165.j(var16, var5);
                     var10000 = var16.d;
                     var10000.j *= var26;
                     var10000 = var16.d;
                     var10000.e *= var26;
                     var10000 = var16.d;
                     var10000.h *= var26;
                     this.af[5] = var16.b();
                  }

                  RotTrans var38 = null;
                  RotTrans var39 = null;
                  if (var7.j.bd != 0.0F) {
                     if (this.af[8] != null && var5 != null) {
                        Z165.g(var16, var1.v);
                        if (var2 != null) {
                           Z165.s(var16, var2.v, var3);
                        }

                        Z165.e(var16, var11);
                        var38 = var16.b().j();
                        Z165.j(var16, var5);
                        var10000 = var16.d;
                        var10000.j *= var26;
                        var10000 = var16.d;
                        var10000.e *= var26;
                        var10000 = var16.d;
                        var10000.h *= var26;
                        this.af[8] = var16.b();
                     }

                     if (this.af[9] != null && var5 != null) {
                        Z165.g(var16, var1.y);
                        if (var2 != null) {
                           Z165.s(var16, var2.y, var3);
                        }

                        Z165.e(var16, var15);
                        var39 = var16.b().j();
                        Z165.j(var16, var5);
                        var10000 = var16.d;
                        var10000.j *= var26;
                        var10000 = var16.d;
                        var10000.e *= var26;
                        var10000 = var16.d;
                        var10000.h *= var26;
                        this.af[9] = var16.b();
                     }
                  }

                  if (this.af[2] != null && var17 != null) {
                     Z165.g(var16, var1.d);
                     if (var2 != null) {
                        Z165.s(var16, var2.d, var3);
                     }

                     Z165.e(var16, var31);
                     Z165.j(var16, var17);
                     var10000 = var16.d;
                     var10000.j *= var26;
                     var10000 = var16.d;
                     var10000.e *= var26;
                     var10000 = var16.d;
                     var10000.h *= var26;
                     this.af[2] = var16.b();
                  }

                  if (this.af[3] != null && var35 != null) {
                     Z165.g(var16, var1.q);
                     if (var2 != null) {
                        Z165.s(var16, var2.q, var3);
                     }

                     Z165.e(var16, var34);
                     Z165.j(var16, var35);
                     var10000 = var16.d;
                     var10000.j *= var26;
                     var10000 = var16.d;
                     var10000.e *= var26;
                     var10000 = var16.d;
                     var10000.h *= var26;
                     this.af[3] = var16.b();
                  }

                  if (this.af[6] != null && var36 != null) {
                     Z165.g(var16, var1.h);
                     if (var2 != null) {
                        Z165.s(var16, var2.h, var3);
                     }

                     Z165.e(var16, var31);
                     Z165.j(var16, var36);
                     var10000 = var16.d;
                     var10000.j *= var26;
                     var10000 = var16.d;
                     var10000.e *= var26;
                     var10000 = var16.d;
                     var10000.h *= var26;
                     this.af[6] = var16.b();
                  }

                  if (this.af[7] != null && var37 != null) {
                     Z165.g(var16, var1.s);
                     if (var2 != null) {
                        Z165.s(var16, var2.s, var3);
                     }

                     Z165.e(var16, var34);
                     Z165.j(var16, var37);
                     var10000 = var16.d;
                     var10000.j *= var26;
                     var10000 = var16.d;
                     var10000.e *= var26;
                     var10000 = var16.d;
                     var10000.h *= var26;
                     this.af[7] = var16.b();
                  }

                  if (var7.j.bd != 0.0F) {
                     if (this.af[10] != null && var38 != null) {
                        Z165.g(var16, var1.w);
                        if (var2 != null) {
                           Z165.s(var16, var2.w, var3);
                        }

                        Z165.e(var16, var31);
                        Z165.j(var16, var38);
                        var10000 = var16.d;
                        var10000.j *= var26;
                        var10000 = var16.d;
                        var10000.e *= var26;
                        var10000 = var16.d;
                        var10000.h *= var26;
                        this.af[10] = var16.b();
                     }

                     if (this.af[11] != null && var39 != null) {
                        Z165.g(var16, var1.r);
                        if (var2 != null) {
                           Z165.s(var16, var2.r, var3);
                        }

                        Z165.e(var16, var34);
                        Z165.j(var16, var39);
                        var10000 = var16.d;
                        var10000.j *= var26;
                        var10000 = var16.d;
                        var10000.e *= var26;
                        var10000 = var16.d;
                        var10000.h *= var26;
                        this.af[11] = var16.b();
                     }
                  }

                  Quaternion var23;
                  Quaternion var24;
                  if (this.af[12] != null && var5 != null) {
                     Z165.g(var16, var1.e);
                     if (var2 != null) {
                        Z165.s(var16, var2.e, var3);
                     }

                     var23 = Quaternion.e(1.0F, 0.0F, 0.0F, var7.j.bl);
                     var24 = Quaternion.e(0.0F, 1.0F, 0.0F, var7.j.bw);
                     Z165.h(var16, var23);
                     Z165.h(var16, var24);
                     var35 = var16.b().j();
                     Z165.j(var16, var5);
                     var10000 = var16.d;
                     var10000.j *= var26;
                     var10000 = var16.d;
                     var10000.e *= var26;
                     var10000 = var16.d;
                     var10000.h *= var26;
                     this.af[12] = var16.b();
                  }

                  if (this.af[13] != null && var5 != null) {
                     Z165.g(var16, var1.l);
                     if (var2 != null) {
                        Z165.s(var16, var2.l, var3);
                     }

                     var23 = Quaternion.e(1.0F, 0.0F, 0.0F, var7.j.bj);
                     var24 = Quaternion.e(0.0F, 1.0F, 0.0F, var7.j.bk);
                     Z165.h(var16, var23);
                     Z165.h(var16, var24);
                     var37 = var16.b().j();
                     Z165.j(var16, var5);
                     var10000 = var16.d;
                     var10000.j *= var26;
                     var10000 = var16.d;
                     var10000.e *= var26;
                     var10000 = var16.d;
                     var10000.h *= var26;
                     this.af[13] = var16.b();
                  }

                  if (this.af[14] != null && var35 != null) {
                     Z165.g(var16, var1.q);
                     if (var2 != null) {
                        Z165.s(var16, var2.q, var3);
                     }

                     Z165.e(var16, var34);
                     Z165.j(var16, var35);
                     var10000 = var16.d;
                     var10000.j *= var26;
                     var10000 = var16.d;
                     var10000.e *= var26;
                     var10000 = var16.d;
                     var10000.h *= var26;
                     this.af[14] = var16.b();
                  }

                  if (this.af[15] != null && var37 != null) {
                     Z165.g(var16, var1.s);
                     if (var2 != null) {
                        Z165.s(var16, var2.s, var3);
                     }

                     Z165.e(var16, var34);
                     Z165.j(var16, var37);
                     var10000 = var16.d;
                     var10000.j *= var26;
                     var10000 = var16.d;
                     var10000.e *= var26;
                     var10000 = var16.d;
                     var10000.h *= var26;
                     this.af[15] = var16.b();
                  }
               }
            }

            Vector3 var27 = var1.p;
            if (var2 != null) {
               var27 = Vector3.av(var27, var2.p, var3);
            }

            this.e = var27;
            Vector3 var29 = var1.x;
            if (var2 != null) {
               var29 = Vector3.av(var29, var2.x, var3);
            }

            this.h = var29;
            ScaleRotTrans var30 = GameEntity.v(this.getEntity());
            var27 = Vector3.al(var27, var30.rot);
            var27 = var27.ao();
            float var32 = var1.u;
            if (var2 != null) {
               var32 += (var2.u - var32) * var3;
            }

            this.getEntity().setProperty("LinearVelocity", var27);
            this.getEntity().setProperty("AngularVelocity", var29);
            this.getEntity().setProperty("VerticalVelocity", var32);
         }
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float vehicleGetWheelSlipStatus(int var1) {
      return this.ah.b != null ? this.ah.b.s(var1) : 0.0F;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getAABBMaxCorner() {
      if (this.ah.e != null) {
         E41 var1 = this.ah.e.at();
         return var1.e();
      } else {
         return null;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 vehicleGetWheelContactPatchPosition(int var1) {
      if (this.ah.b != null) {
         Vector3 var2 = BulletVehicle.l(this.ah.b, var1);
         return var2;
      } else {
         return new Vector3(0.0F, 0.0F, 0.0F);
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void resetOrientation() {
      if (this.ap != null) {
         this.ap.d("resetOrientation");
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      if (this.ah.e != null) {
         this.ah.e.ac(M47.g);
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float characterGetContactPatchHeight() {
      float var1 = 0.0F;
      if (this.ah.j != null) {
         var1 = this.ah.j.at().j().y;
      }

      return var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setCharacterTurnSpeed(float var1) {
      if (this.ap != null) {
         this.ap.d("setCharacterTurnSpeed", var1);
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      this.aa.h = true;
      this.aa.b = var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setCharacterSpeed(float var1, float var2, float var3) {
      if (this.ap != null) {
         this.ap.d("setCharacterSpeed", var1, var2, var3);
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      this.aa.h = true;
      this.aa.s = new Vector3(var1, var2, var3);
      this.ah.h = Vector3.af(this.aa.s, this.ah.j.as());
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void characterJump(float var1) {
      if (this.ap != null) {
         this.ap.d("characterJump", var1);
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      this.ah.j.r(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 entityVectorToPhysicsSpace(Vector3 var1) {
      return var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Aq193 getLandingPrediction(float var1) {
      if (this.ah.j != null && this.ah.j.p()) {
         D194 var2 = new D194();
         if (this.ah.j.u(var2, var1)) {
            Aq193 var3 = new Aq193();
            var3.g = var2.g;
            var3.d = var2.d;
            var3.q = var2.q;
            var3.j = var2.j;
            var3.e = var2.e >= 0 ? ((CollisionObjectData)this.ah.j.b.ap((long)var2.e)).d : null;
            return var3;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float getHeading(boolean var1) {
      Quaternion var2 = this.getOrientation(var1);
      Vector3 var3 = Vector3.al(Vector3.g(0.0F, 0.0F, 1.0F), var2);
      return (float)Math.atan2((double)var3.x, (double)var3.z);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean canTransformTo(@ScriptID Integer var1, @ScriptDefaults(defaultNumber = -0.1D) float var2, @ScriptDefaults(defaultInteger = 0) int var3, @ScriptDefaults(defaultInteger = 0) int var4) {
      PlayerAvatarDescriptor var5 = PlayerAvatarDescriptor.g(var1);
      if (var5 == null) {
         logger.warn("canTransformTo(): could not find the descriptor in the library");
         return true;
      } else {
         PlayerPhysicsAvatar var6 = this.getAvatar(false);
         if (var6 == null) {
            logger.warn("canTransformTo(): could not find the avatar for the descriptor. The physics reperesentation hasn't been created yet.");
            return true;
         } else {
            if (var3 == 0) {
               if (PlayerAvatarDescriptor.IsCharacterController(var1)) {
                  var3 = Gn5.PLAYER_AS_ROBOT.ordinal();
               } else if (PlayerAvatarDescriptor.IsVehicle(var1)) {
                  var3 = Gn5.PLAYER_AS_CAR.ordinal();
               }
            }

            E6 var7 = var5.e(var6.d.d);
            Q7 var8 = v(this, var1);
            List var9 = var6.d.d.al(var7, var8, var3, var4, (List)null, 20);
            if (var9.size() == 20) {
               return false;
            } else {
               var6.d.d.t(var7);
               Iterator var10 = var9.iterator();

               while(var10.hasNext()) {
                  L8 var11 = (L8)var10.next();
                  Iterator var12 = var9.iterator();

                  while(var12.hasNext()) {
                     L8 var13 = (L8)var12.next();
                     if (Vector3.o(var11.q, var13.q) < var2) {
                        return false;
                     }
                  }
               }

               return true;
            }
         }
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public PhysicsWorldWrapper getPhysicsWorld(boolean var1) {
      return this.ah == null ? null : this.ah.d;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getAngularVelocity(boolean var1) {
      if (this.ah == null) {
         return Vector3.g;
      } else if (this.ah.q != null) {
         return this.ah.q.w();
      } else {
         return this.ah.j != null ? this.ah.s : Vector3.g;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float getVerticalVelocity() {
      return this.ah.j != null ? this.ah.j.y() : 0.0F;
   }

   // $FF: synthetic method
   static Logger a() {
      return logger;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean isCharacter() {
      return this.ah.j != null;
   }

   public void i(int var1, boolean var2) {
      if (!this.l.d()) {
         throw new IllegalArgumentException("Only on client");
      } else {
         o(this, var1, var2);
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getWheelEntitySpacePos(int var1) {
      Vector3 var2 = this.vehicleGetWheelContactPatchPosition(var1);
      return var2;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float vehicleGetLateralFrictionMultiplier() {
      return this.ah.b != null ? this.ah.b.w : 1.0F;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getWheelEntitySpaceFront() {
      Quaternion var1 = this.getOrientation(false);
      Vector3 var2 = Vector3.g(0.0F, 0.0F, 1.0F);
      return Vector3.al(var2, var1);
   }

   private static void o(PlayerPhysicsComponent var0, int var1, boolean var2) {
      if (var0.ah.x != -1) {
         var0.ac.runRaw("tyreTrackDecal", var0.getEntity(), var2, var0.ah.x);
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int getCollisionMask(@ScriptDefaults(defaultBoolean = false) boolean var1) {
      if (this.ah != null && this.ah.e != null) {
         return CollisionObject.ab(this.ah.e);
      } else {
         throw new RuntimeException(String.format("PlayerPhysicsComponent%s PlayerPhysicsAvatar%s was null.", var1 ? " master" : "", this.ah != null ? " CollisionObject" : ""));
      }
   }

   public static void w(PlayerPhysicsComponent var0) {
      var0.am = true;
      r(var0);
   }

   public static E41 b(PlayerPhysicsComponent var0) {
      return var0.ah.e != null ? var0.ah.e.at() : null;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void vehicleStartFrictionDissipationReduction(float var1, float var2) {
      if (this.ap != null) {
         this.ap.d("vehicleStartFrictionDissipationReduction", var1, var2);
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      if (this.ah.b != null) {
         this.ah.b.p = var1;
         this.ah.b.x = -var1 * DiscreteDynamicsWorld.av(this.ah.b.e.b) / var2;
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float vehicleGetWheelSlipSpeed(int var1) {
      return this.ah.b != null ? this.ah.b.b(var1) : 0.0F;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetVehicleTopSpeedInReverse(float var1) {
      if (this.ap != null) {
         this.ap.d("SetVehicleTopSpeedInReverse", var1);
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      if (this.ah.b != null && this.ah.w != null) {
         this.ah.w.l = var1;
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean isTouchingGround() {
      if (this.ah.j != null) {
         return this.ah.j.p();
      } else if (this.ah.b == null) {
         return false;
      } else if (BulletVehicle.g(this.ah.b) == 4) {
         return this.ah.b.e(0) || this.ah.b.e(1) || this.ah.b.e(2) || this.ah.b.e(3);
      } else if (BulletVehicle.g(this.ah.b) != 2) {
         return false;
      } else {
         return this.ah.b.e(0) || this.ah.b.e(1);
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void vehicleSteerLeft() {
      if (this.ap != null) {
         this.ap.d("vehicleSteerLeft");
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      this.aa.g = true;
      this.aa.q = -1.0F;
   }

   public static PlayerAvatarDescriptor t(PlayerPhysicsComponent var0, boolean var1) {
      Integer var2 = m(var0, var1);
      return var2 == null ? null : PlayerAvatarDescriptor.g(var2);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void vehicleStopLateralFrictionMultiplier() {
      if (this.ap != null) {
         this.ap.d("vehicleStopLateralFrictionMultiplier");
      }

      if (!this.ao) {
         logger.warn("Called physics function outside control handler", new Ao128());
      }

      if (this.ah.b != null) {
         this.ah.b.w = 1.0F;
         this.ah.b.r = 0.0F;
      }

   }

   public static void y(PlayerPhysicsComponent var0, boolean var1, boolean var2, int var3) {
      GameEntity var4 = var0.getEntity();
      if (!var0.am) {
         r(var0);
      } else {
         ScaleRotTrans var5 = var4.getWorldTransform();
         Q7 var6 = null;
         if (var2) {
            PhysicsWorldWrapper var7 = var0.l.g(var5.trans);
            if (var7 != var0.ah.d || !PlayerPhysicsAvatar.d(var0.ah)) {
               var6 = v(var0, var0.w);
               Vector3 var8 = var0.ah.y;
               Vector3 var9 = var0.ah.p;
               int var10 = Gj16.PLAYER.az;
               if (var0.ah.e != null) {
                  var10 = CollisionObject.ab(var0.ah.e);
               }

               PlayerPhysicsAvatar.q(var0.ah);
               var0.ah.d = var7;
               if (var0.w != null && var0.ah.d != null) {
                  var0.ah.j(var4, PlayerAvatarDescriptor.g(var0.w), var6, var8, var9, var3, var10);
               }
            }
         }

         LossyStateStream var13 = (LossyStateStream)GameEntity.ej(var4, "__clientControlStream");
         LossyStateStream var14 = (LossyStateStream)GameEntity.ej(var4, "__serverControlStream");
         K189 var15 = null;
         K189 var16 = null;
         if (var13 != null) {
            var15 = (K189)var13.getState(var3);
         }

         if (var14 != null) {
            var16 = (K189)var14.getState(var3);
         }

         Integer var11 = null;
         if (var0.l.d()) {
            if (var15 != null && var15.q != null) {
               var11 = var15.q;
            } else if (var16 != null) {
               var11 = var16.q;
            }
         } else if (var16 != null && var16.q != null) {
            var11 = var16.q;
         } else if (var15 != null) {
            var11 = var15.q;
         }

         if (var2 && var11 != null && (!var11.equals(var0.w) || var0.r != PlayerAvatarDescriptor.d(var0.w))) {
            PlayerAvatarDescriptor var12 = PlayerAvatarDescriptor.g(var11);
            if (var12 != null && var12.n != null) {
               var12.n.trigger(var4, (Object)null);
            }
         }

         n(var0, var11, var2, false, var3);
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setControl(String var1, Object var2, @ScriptDefaults(defaultInteger = 0) int var3) {
      if (var3 < 0) {
         throw new IllegalArgumentException("timestampOffset must be >=0!");
      } else {
         int var4 = StringTools.l(var1);
         ab.put(var4, var1);
         if (this.l.q()) {
            GameEntity var5 = this.getEntity();
            if (var5 == null) {
               throw new RuntimeException("entity is null for PlayerPhysicsComponent");
            } else if (this.l.d() && GameEntity.ej(var5, "__clientControlStreamMaster") == Boolean.FALSE) {
               throw new IllegalStateException("Can't set client-side controls for other people!");
            } else {
               SourceLossyStateStream var6 = (SourceLossyStateStream)GameEntity.ej(var5, this.l.d() ? "__clientControlStream" : "__serverControlStream");
               if (var6 != null) {
                  int var7 = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(this.l.j(), var3);
                  K189 var8 = (K189)var6.getState(var7);
                  Object var9 = var8.g.get(var4);
                  if (var9 == null) {
                     if (var2 == null) {
                        return;
                     }
                  } else if (var9.equals(var2)) {
                     return;
                  }

                  K189 var10 = (K189)var6.factory.duplicateState(var8);
                  if (var2 == null) {
                     var10.g.remove(var4);
                     var10.d.remove(var4);
                  } else {
                     var10.g.put(var4, var2);
                     var10.d.put(var4, var7);
                  }

                  var6.putState(var10, var7);
               }

            }
         }
      }
   }
}
