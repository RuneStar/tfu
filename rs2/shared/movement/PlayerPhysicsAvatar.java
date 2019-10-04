package rs2.shared.movement;

import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.components.MappedEventComponent;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.Decals;
import com.jagex.jnibindings.runetek6.jagbullet.BulletVehicle;
import com.jagex.jnibindings.runetek6.jagbullet.CharacterController;
import com.jagex.jnibindings.runetek6.jagbullet.CollisionObject;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.maths.I48;
import com.jagex.maths.M47;
import com.jagex.maths.Vector3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Be2;
import tfu.Bs1;
import tfu.Lq191;

public class PlayerPhysicsAvatar {
   private static final Logger logger = LoggerFactory.getLogger(PlayerPhysicsAvatar.class);
   public BulletVehicle b;
   public PhysicsWorldWrapper d = null;
   public CollisionObject e = null;
   Vector3 h;
   public CharacterController j = null;
   private Vector3 l;
   boolean m;
   public Vector3 p;
   public RigidBody q = null;
   E6 r;
   Vector3 s;
   final I48 t;
   Av190 u;
   private I187 v;
   public final P185 w;
   public int x;
   public Vector3 y;
   final I48 z;

   public PlayerPhysicsAvatar() {
      this.h = Vector3.g;
      this.s = Vector3.g;
      this.b = null;
      this.l = Vector3.g;
      this.w = new P185();
      this.r = null;
      this.v = null;
      this.y = new Vector3(0.0F, 0.0F, 0.0F);
      this.p = new Vector3(0.0F, 0.0F, 0.0F);
      this.x = -1;
      this.u = null;
      this.z = new I48(0.0F, 0.0F, 0.0F);
      this.t = new I48(0.0F, 0.0F, 0.0F);
      this.m = false;
   }

   public static void v(PlayerPhysicsAvatar var0, Av190 var1, int var2, int var3, boolean var4) {
      if (var1 != null) {
         if (!Av190.g(var1, var0.u)) {
            var0.u = var1;
         }
      } else {
         var0.u = null;
         I48.z(var0.z);
         I48.z(var0.t);
         var0.m = true;
      }

      if (var0.u != null) {
         int var5 = LossyStateStream.TIMESTAMP_WIDTH.diffIDs(var2, var1.j);
         float var6 = Vector3.f(var0.u.g);
         if (var0.u.d >= 0.0F) {
            float var7 = Lq191.d();
            float var8 = var0.u.q / var7;
            if (var0.u.d > 0.0F) {
               float var9 = var6 / (var0.u.d * var7);
               if (var9 < var8) {
                  var8 = var9;
               }
            }

            if ((float)var5 <= var8 && var5 >= 0) {
               I48 var10 = I48.r(var0.u.g);
               I48.ai(var10, var6);
               I48.aq(var10, var0.u.d * var7 * (float)var5);
               I48.x(var0.z, var0.u.g);
               I48.a(var0.z, var10);
               I48.y(var10);
            } else {
               if ((float)var5 == var8 + 1.0F && var0.j != null && Vector3.f(var0.h) == 0.0F) {
                  var0.j.e(Vector3.g(0.0F, 0.0F, 0.0F));
               }

               I48.z(var0.z);
               I48.z(var0.t);
               var0.m = true;
            }
         } else {
            I48.z(var0.z);
            I48.z(var0.t);
            var0.m = true;
         }
      } else {
         I48.z(var0.z);
         I48.z(var0.t);
         var0.m = true;
      }

   }

   static boolean d(PlayerPhysicsAvatar var0) {
      return var0.e != null;
   }

   static void q(PlayerPhysicsAvatar var0) {
      if (var0.d != null) {
         if (var0.b != null) {
            var0.d.d.k(var0.b);
            var0.b = null;
            if (var0.v != null && var0.v.d()) {
               Decals.freeVehicleTyreTrackDecalSlot(var0.x);
            }
         }

         if (var0.q != null) {
            var0.d.d.m(var0.q);
            var0.q = null;
         }

         if (var0.j != null) {
            var0.d.d.n(var0.j);
            var0.j = null;
         }

         if (var0.r != null) {
            var0.d.d.t(var0.r);
            var0.r = null;
         }

         var0.e = null;
      }

   }

   public void j(GameEntity var1, PlayerAvatarDescriptor var2, Q7 var3, Vector3 var4, Vector3 var5, int var6, int var7) {
      // $FF: Couldn't be decompiled
   }

   public static void e(PlayerPhysicsAvatar var0, Q7 var1) {
      if (var0.e != null) {
         var0.e.aa(var1);
      }

   }

   public static void h(PlayerPhysicsAvatar var0, Vector3 var1) {
      if (var0.e != null) {
         var0.e.am(var1);
      }

   }

   public static void s(PlayerPhysicsAvatar var0, M47 var1) {
      if (var0.e != null) {
         var0.e.ac(var1);
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Q7 getCurrentTransform() {
      return this.e != null ? this.e.ao() : null;
   }

   public static Q7 b(PlayerPhysicsAvatar var0, int var1) {
      return var0.b == null ? null : var0.b.q(var1);
   }

   public static Vector3 r(PlayerPhysicsAvatar var0) {
      return var0.l;
   }

   public void w(float var1, float var2, float var3) {
      if (this.b != null) {
         this.l = new Vector3(var1, var2, var3);
         this.b.y(var1, var2, var3);
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public CollisionObject getPhysicsCollisionObject() {
      return this.e != null ? this.e : null;
   }

   static void g(PlayerPhysicsAvatar var0, I187 var1) {
      var0.v = var1;
   }

   public static Q7 l(PlayerPhysicsAvatar var0, int var1) {
      return var0.b == null ? null : var0.b.j(var1);
   }
}
