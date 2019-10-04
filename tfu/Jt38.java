package tfu;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.jnibindings.runetek6.jagbullet.CharacterController;
import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.E41;
import com.jagex.maths.Q10;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.shared.movement.Ai37;
import rs2.shared.movement.CollisionObjectData;
import rs2.shared.movement.E181;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.S15;

public class Jt38 implements Ai37 {
   private static final Logger logger = LoggerFactory.getLogger(Jt38.class);
   private static final boolean[] y = new boolean[Gn5.values().length];
   private int b;
   private final GameEntity d;
   private int e;
   private float h;
   private int j;
   private int l;
   private final PhysicsWorldWrapper q;
   private CharacterController r;
   private float s;
   private RotTrans v;
   private E6 w;

   private static Vector3 ai(Jt38 var0, Vector3 var1) {
      if (var0.s > 0.0F) {
         var1 = Vector3.i(var1, 0.0F, var0.s / 2.0F, 0.0F);
      } else {
         Q10 var2 = GameEntity.i(var0.d);
         if (var2 != null) {
            var1 = Vector3.i(var1, 0.0F, (Q10.q(var2) - Q10.j(var2)) / 2.0F, 0.0F);
         }
      }

      var1 = Vector3.i(var1, (float)var0.j, 0.0F, (float)var0.e);
      return var1;
   }

   private RotTrans c(RotTrans var1) {
      return new RotTrans(var1.rot.v(Gh19.g), ag(this, var1.trans));
   }

   private void n(RotTrans var1) {
      Q10 var2 = null;
      if (!t(this.h, this.s)) {
         var2 = GameEntity.k(this.d);
      }

      this.w = PhysicsWorldWrapper.s(this.q, var2, this.h, this.s);
      CollisionObjectData var3 = new CollisionObjectData(S15.NPC);
      var3.d = this.d;
      float var4 = 0.0F;
      this.r = this.q.d.u(this.w, Q7.g(var1), var4, true, this.b, this.l, var3);
      this.d.ba = this.r;
      this.r.s(1.553343F);
   }

   private static void k(Jt38 var0) {
      var0.q.d.n(var0.r);
      var0.q.d.t(var0.w);
   }

   public static void i(Jt38 var0) {
      var0.v = Q7.d(var0.r.ao());
      k(var0);
   }

   public static void o(Jt38 var0, int var1, int var2) {
      var0.n(var0.v);
      var0.j = var1;
      var0.e = var2;
   }

   public static int a(Jt38 var0) {
      return var0.l;
   }

   private RotTrans aq(RotTrans var1) {
      return new RotTrans(var1.rot.v(Gh19.g), ai(this, var1.trans));
   }

   public static void al(Jt38 var0) {
      k(var0);
   }

   public void d(Vector3 var1, float var2, boolean var3) {
      this.r.e(var1);
      if (!Float.isNaN(var2)) {
         this.r.ac(Lr302.d(var2).m());
      }

      this.r.w(!var3);
   }

   public RotTrans q() {
      RotTrans var1 = Q7.d(this.r.ao());
      var1 = this.aq(var1);
      return var1;
   }

   public E181 j() {
      E181 var1 = new E181();
      var1.g = this.r.ao();
      var1.d = this.r.h();
      return var1;
   }

   public void e(E181 var1) {
      this.r.aa(var1.g);
      this.r.e(var1.d);
   }

   public void h(Q7 var1) {
      this.r.aa(var1);
   }

   public static E41 af(Jt38 var0) {
      return var0.r.at();
   }

   static {
      y[Gn5.NPC_FULLCOLLIDE.ordinal()] = true;
      y[Gn5.NPC_NODRIVECOLLIDE.ordinal()] = true;
      y[Gn5.NPC_NOPLAYERCOLLIDE.ordinal()] = true;
      y[Gn5.NPC_NOCOLLIDE.ordinal()] = true;
   }

   public static boolean t(float var0, float var1) {
      return var0 > 0.0F && var1 > 0.0F;
   }

   private int m(int var1) {
      if (var1 < 0) {
         return Gn5.NPC_NODRIVECOLLIDE.ordinal();
      } else {
         Gn5 var2;
         if (var1 >= y.length) {
            var2 = Gn5.NPC_NODRIVECOLLIDE;
            logger.warn("Invalid collision group " + var1 + " for NPC - reverting to " + var2);
            return var2.ordinal();
         } else if (!y[var1]) {
            var2 = Gn5.NPC_NODRIVECOLLIDE;
            logger.warn("Invalid collision group " + Gn5.values()[var1] + " for NPC - reverting to " + var2);
            return var2.ordinal();
         } else {
            return var1;
         }
      }
   }

   private static Vector3 ag(Jt38 var0, Vector3 var1) {
      var1 = Vector3.m(var1, (float)var0.j, 0.0F, (float)var0.e);
      if (var0.s > 0.0F) {
         var1 = Vector3.m(var1, 0.0F, var0.s / 2.0F, 0.0F);
      } else {
         Q10 var2 = GameEntity.i(var0.d);
         if (var2 != null) {
            var1 = Vector3.m(var1, 0.0F, (Q10.q(var2) - Q10.j(var2)) / 2.0F, 0.0F);
         }
      }

      return var1;
   }

   public Jt38(GameEntity var1, PhysicsWorldWrapper var2, int var3, int var4, float var5, float var6, int var7, int var8, Vector3 var9, Quaternion var10) {
      this.d = var1;
      this.q = var2;
      this.j = var3;
      this.e = var4;
      this.h = var5;
      this.s = var6;
      this.b = this.m(var7);
      this.l = var8;
      RotTrans var11 = new RotTrans(var10, var9);
      var11 = this.c(var11);
      this.n(var11);
   }

   public Vector3 g() {
      return this.r.h();
   }

   public static void f(Jt38 var0, float var1, float var2, int var3, int var4) {
      i(var0);
      var0.h = var1;
      var0.s = var2;
      var0.b = var0.m(var3);
      var0.l = var4;
      o(var0, var0.j, var0.e);
   }
}
