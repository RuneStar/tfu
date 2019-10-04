package rs2.shared.movement;

import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.maths.I48;
import com.jagex.maths.M47;
import com.jagex.maths.Vector3;

class Ag183 {
   public float b;
   public float d;
   public boolean e;
   public boolean g;
   public boolean h;
   public float j;
   public float q;
   public Vector3 s;

   public static void g(Ag183 var0) {
      var0.g = false;
      var0.d = 0.0F;
      var0.q = 0.0F;
      var0.j = 0.0F;
      var0.e = false;
      var0.h = false;
      var0.s = Vector3.g;
      var0.b = 0.0F;
   }

   public Ag183() {
      g(this);
   }

   public void d(PlayerPhysicsAvatar var1, int var2, boolean var3, C184 var4) {
      if (var1.b != null) {
         var1.w.d(var1.b, Vector3.f(var1.q.l()), DiscreteDynamicsWorld.av(var1.d.d), this.g ? this.d : 0.0F, this.g ? this.q : 0.0F, this.g ? this.j : 0.0F, this.g ? this.e : false, var4);
         if (I48.c(var1.z) > 0.0F) {
            boolean var5 = false;
            Vector3 var6;
            if (var5) {
               var6 = var1.q.l();
               I48 var7 = I48.v(var1.z);
               I48 var8 = I48.v(var1.t);
               I48.aq(var8, 0.95F);
               I48.a(var7, var8);
               I48.u(var1.t, var1.z);
               PlayerPhysicsComponent.a().debug("shunt on car {}", var7);
               var6 = Vector3.t(var6, var7);
               RigidBody.s(var1.q, var6);
               I48.y(var7);
            } else {
               var6 = var1.q.an();
               Vector3 var11 = var1.z.ao();
               var6 = Vector3.n(var6, var11, DiscreteDynamicsWorld.av(var1.d.d));
               var1.q.am(var6);
            }
         }
      }

      if (var1.j != null && (this.h || I48.c(var1.z) > 0.0F || var1.m)) {
         var1.h = Vector3.af(this.s, var1.j.as());
         Vector3 var9 = var1.h;
         var1.m = false;
         var9 = Vector3.t(var9, var1.z);
         float var10 = DiscreteDynamicsWorld.av(var1.d.d);
         var9 = Vector3.ai(var9, var10);
         var1.j.e(var9);
         M47 var12 = var1.j.as();
         M47 var13 = M47.d(0.0F, 1.0F, 0.0F, this.b * var10);
         var12 = var12.e(var13);
         var1.j.ac(var12);
         var1.s = new Vector3(0.0F, this.b, 0.0F);
      }

   }
}
