package rs2.shared.movement;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.comms.statestream.LossyStateStream;
import com.jagex.game.runetek6.comms.statestream.LossyStateStreamSynchronizer;
import com.jagex.game.runetek6.comms.statestream.SourceLossyStateStream;
import com.jagex.game.runetek6.comms.statestream.StateFactory;
import com.jagex.game.runetek6.gameentity.Component;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.I48;
import com.jagex.maths.RotTrans;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import java.util.Iterator;
import tfu.Bb4;
import tfu.Be2;
import tfu.Bs1;
import tfu.Lq191;
import tfu.Me312;

@ScriptEntryClass
public final class ScheduledMovementComponent extends Component {
   private static StateFactory d = new Az206();
   static final A207 g = new A207(0.0F, 0.0F, 0.0F, 0.0F, Float.NaN, false, 0.0F, 0.0F, 0.0F);
   public static final int t = StringTools.l(ScheduledMovementComponent.class.getName());
   private Vector3 b;
   private float e;
   private boolean h;
   private float j;
   private Vector3 l;
   private Me312 m;
   private int p;
   private Vector3 q;
   private final LossyStateStream r;
   private I48 s;
   private final Z36 u;
   private final LossyStateStream v;
   private Vector3 w;
   private final Ai37 x;
   private int y;
   private final M188 z;

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getScheduledPositionEstimate() {
      if (!(this.r instanceof SourceLossyStateStream)) {
         throw new IllegalStateException("Movement can only be scheduled server-side.");
      } else {
         d(this);
         return this.b;
      }
   }

   public static ScheduledMovementComponent g(Bb4 var0, Z36 var1) {
      LossyStateStream var2 = new LossyStateStream(d, var0.h() | 50331648, "NPCScheduledMove_" + var0.h());
      LossyStateStream var3 = new LossyStateStream(new B348(), var0.h() | 83886080, "NPCDynamicState_" + var0.h());
      return new ScheduledMovementComponent(var2, var3, 0, (Ai37)null, var1, new M188(false));
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public static int getComponentTypeID() {
      return t;
   }

   public static void p(ScheduledMovementComponent var0, int var1) {
      var0.r.discardStates(var1);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getScheduledVelocityEstimate() {
      if (!(this.r instanceof SourceLossyStateStream)) {
         throw new IllegalStateException("Movement can only be scheduled server-side.");
      } else {
         d(this);
         return this.w;
      }
   }

   private static void d(ScheduledMovementComponent var0) {
      if (var0.b == null) {
         RotTrans var1 = var0.x.q();
         I48 var2 = I48.r(var1.trans);
         I48 var3 = I48.r(var0.x.g());

         for(int var4 = var0.y; var4 != var0.p; var4 = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(var4, 1)) {
            A207 var5 = (A207)var0.r.getState(var4);
            if (var5 != null) {
               e(var0, var5, var3);
               I48.k(var2, var3);
            }
         }

         var0.b = var2.ao();
         var0.l = var3.ao();
         float var6 = Lq191.d();
         var0.w = Vector3.ai(var0.l, var6);
      }

   }

   public static void v(ScheduledMovementComponent var0, Q7 var1) {
      Ai37 var2 = var0.u.g();
      if (var2 != null) {
         var2.h(var1);
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setScheduledTargetVelocity(Vector3 var1) {
      if (!(this.r instanceof SourceLossyStateStream)) {
         throw new IllegalStateException("Movement can only be scheduled server-side.");
      } else if (!Float.isNaN(var1.x) && !Float.isNaN(var1.y) && !Float.isNaN(var1.z)) {
         if (!Float.isInfinite(var1.x) && !Float.isInfinite(var1.y) && !Float.isInfinite(var1.z)) {
            this.q = var1;
         } else {
            throw new IllegalArgumentException("Invalid input: " + var1);
         }
      } else {
         throw new IllegalArgumentException("Invalid input: " + var1);
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public float getScheduledAcceleration() {
      if (!(this.r instanceof SourceLossyStateStream)) {
         throw new IllegalStateException("Movement can only be scheduled server-side.");
      } else {
         return this.j;
      }
   }

   public static void t(ScheduledMovementComponent var0) {
      Iterator var1 = var0.m.iterator();

      while(var1.hasNext()) {
         LossyStateStreamSynchronizer var2 = (LossyStateStreamSynchronizer)var1.next();
         var2.removeStream(var0.r);
         var2.removeStream(var0.v);
      }

      var0.m.clear();
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Vector3 getScheduledTargetVelocity() {
      if (!(this.r instanceof SourceLossyStateStream)) {
         throw new IllegalStateException("Movement can only be scheduled server-side.");
      } else {
         return this.q;
      }
   }

   public void q(float var1, float var2, float var3) {
      if (!(this.r instanceof SourceLossyStateStream)) {
         throw new IllegalStateException("Movement can only be scheduled server-side.");
      } else if (!Float.isNaN(var1) && !Float.isNaN(var2) && !Float.isNaN(var3)) {
         if (!Float.isInfinite(var1) && !Float.isInfinite(var2) && !Float.isInfinite(var3)) {
            I48.i(this.s, var1, var2, var3);
         } else {
            throw new IllegalArgumentException("Invalid input: " + var1 + ", " + var2 + ", " + var3);
         }
      } else {
         throw new IllegalArgumentException("Invalid input: " + var1 + ", " + var2 + ", " + var3);
      }
   }

   private static void j(I48 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      var0.j -= var1;
      var0.e -= var2;
      var0.h -= var3;
      if (var4 < 0.0F) {
         var4 = 0.0F;
      }

      float var8 = I48.c(var0);
      if (var8 > var4) {
         float var9 = var8 - var4;
         I48.aq(var0, var9 / var8);
      } else {
         I48.z(var0);
      }

      var0.j += var1;
      var0.e += var2;
      var0.h += var3;
      var0.j += var5;
      var0.e += var6;
      var0.h += var7;
   }

   public static void h(ScheduledMovementComponent var0, int var1, boolean var2, boolean var3) {
      Ai37 var4 = var0.u.g();
      if (var4 != null) {
         if (var3) {
            s(var0, var1, var4);
            var0.y = LossyStateStream.TIMESTAMP_WIDTH.sumIDs(var1, 1);
         }

      }
   }

   public void b() {
      Ai37 var1 = this.u.g();
      if (var1 != null) {
         RotTrans var2 = var1.q();
         GameEntity var3 = this.getEntity();
         var3.setObjectTransform(new ScaleRotTrans(var2, var3.getObjectScale()));
         M188.d(this.z, var2);
         this.u.d();
      }
   }

   public static void l(ScheduledMovementComponent var0) {
      Ai37 var1 = var0.u.g();
      if (var1 != null) {
         RotTrans var2 = var1.q();
         M188.d(var0.z, var2);
      }
   }

   private ScheduledMovementComponent(LossyStateStream var1, LossyStateStream var2, int var3, Ai37 var4, Z36 var5, M188 var6) {
      this.q = Vector3.g;
      this.j = Float.POSITIVE_INFINITY;
      this.e = Float.NaN;
      this.h = false;
      this.s = I48.d();
      this.b = null;
      this.l = null;
      this.w = null;
      this.m = new Me312();
      this.r = var1;
      this.v = var2;
      this.y = var3;
      this.p = var3;
      this.x = var4;
      this.u = var5;
      this.z = var6;
   }

   public static E181 r(ScheduledMovementComponent var0, int var1) {
      return var0.v.hasExplicitState(var1) ? (E181)var0.v.getState(var1) : null;
   }

   public static void z(ScheduledMovementComponent var0, LossyStateStreamSynchronizer var1) {
      var1.removeStream(var0.r);
      var1.removeStream(var0.v);
      var0.m.remove(var1);
   }

   public static void x(ScheduledMovementComponent var0, int var1) {
      var0.v.discardStates(var1);
   }

   public static void u(ScheduledMovementComponent var0, LossyStateStreamSynchronizer var1) {
      var0.m.add(var1);
      var1.addSlaveStream(var0.r);
      var1.addSlaveStream(var0.v);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void scheduleKick(Vector3 var1) {
      this.q(var1.x, var1.y, var1.z);
   }

   protected void detachFromEntity() {
      t(this);
   }

   public void bd() {
      t(this);
   }

   public void w(float var1) {
      RotTrans var2 = (RotTrans)M188.q(this.z);
      if (var2 != null) {
         RotTrans var3 = (RotTrans)M188.j(this.z);
         float var4 = M188.l(this.z);
         RotTrans var5 = var2;
         if (var3 != null) {
            var5 = var2.p(var3, var4);
         }

         GameEntity var6 = this.getEntity();
         var6.setObjectTransform(new ScaleRotTrans(var5, var6.getObjectScale()));
         this.u.q(var1);
      }
   }

   private static void s(ScheduledMovementComponent var0, int var1, Ai37 var2) {
      I48 var3 = I48.r(var2.g());
      float var4 = Float.NaN;
      boolean var5 = false;
      A207 var6 = (A207)var0.r.getState(var1);
      if (var6 != null) {
         e(var0, var6, var3);
         if (!Float.isNaN(var6.e)) {
            var4 = var6.e;
         }

         var5 = var6.h;
      }

      var2.d(var3.ao(), var4, var5);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void setScheduledAcceleration(float var1) {
      if (!(this.r instanceof SourceLossyStateStream)) {
         throw new IllegalStateException("Movement can only be scheduled server-side.");
      } else if (Float.isNaN(var1)) {
         throw new IllegalArgumentException("Invalid input: " + var1);
      } else {
         this.j = var1;
      }
   }

   private static void e(ScheduledMovementComponent var0, A207 var1, I48 var2) {
      j(var2, var1.g, var1.d, var1.q, var1.j, var1.s, var1.b, var1.l);
   }

   public static E181 y(ScheduledMovementComponent var0) {
      Ai37 var1 = var0.u.g();
      return var1 != null ? var1.j() : null;
   }
}
