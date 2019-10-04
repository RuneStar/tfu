package rs2.client.worldelement;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import com.jagex.game.runetek6.config.vartype.general.VarBasicType;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.xelement.XElement;
import com.jagex.jnibindings.runetek6.jagbullet.RigidBody;
import com.jagex.maths.E41;
import com.jagex.maths.I48;
import com.jagex.maths.Quaternion;
import com.jagex.maths.ScaleRotTrans;
import com.jagex.maths.Vector3;
import java.util.Iterator;
import rs2.client.client;
import rs2.client.lua.Q290;
import rs2.shared.movement.E181;
import rs2.shared.movement.PhysicsComponent;
import rs2.shared.movement.ScheduledMovementComponent;
import tfu.Bb4;
import tfu.Be2;
import tfu.Bs1;
import tfu.Jg365;
import tfu.Jt38;
import tfu.Lq191;

@ScriptEntryClass
public class Npc extends L51 implements Q290 {
   private static final float al = 0.25F;
   public static boolean m = false;
   private float a;
   private Jg365 af = new Jg365();
   private int ag;
   public String ai;
   Jt38 aq;
   private ScaleRotTrans av;
   private int c;
   private float f;
   public final ScheduledMovementComponent i;
   public XElement k;
   boolean n = false;
   private E181 o;

   public String toString() {
      String var1 = super.toString();
      int var2 = var1.lastIndexOf(64);
      if (var2 != -1) {
         var1 = var1.substring(var1.lastIndexOf(64));
      }

      String var3 = (String)ej(this, "NpcName");
      return (var3 == null ? "null-npc-name" : var3) + " " + var1;
   }

   public static void bn(Npc var0, float var1, float var2, int var3, int var4) {
      var0.a = var1;
      var0.f = var2;
      var0.c = var3;
      var0.ag = var4;
      if (var0.aq != null) {
         Jt38.f(var0.aq, var0.a, var0.f, var0.c, var0.ag);
      }

   }

   public void bt(Vector3 var1, Quaternion var2) {
      if (this.aq == null) {
         this.aq = new Jt38(this, client.gz.d, client.gn, client.gj, this.a, this.f, this.c, this.ag, var1, var2);
         if (this.o != null) {
            this.aq.e(this.o);
            this.o = null;
         }

         this.i.b();
      }
   }

   static Vector3 be(Npc var0) {
      I48 var1 = I48.d();
      float var2 = 0.0F;
      Iterator var3 = var0.af.iterator();

      while(var3.hasNext()) {
         H50 var4 = (H50)var3.next();
         I48.n(var1, var4.g);
         var2 += var4.q;
         if (var2 > 0.25F) {
            I48.f(var1, var4.g, (var2 - 0.25F) / var4.q);
            var2 = 0.25F;
            break;
         }
      }

      if (var2 > 0.0F) {
         I48.ai(var1, var2);
      }

      return var1.ao();
   }

   static Vector3 bs(Npc var0) {
      I48 var1 = I48.d();
      float var2 = 0.0F;
      Iterator var3 = var0.af.iterator();

      while(var3.hasNext()) {
         H50 var4 = (H50)var3.next();
         I48.n(var1, var4.d);
         var2 += var4.q;
         if (var2 > 0.25F) {
            I48.f(var1, var4.d, (var2 - 0.25F) / var4.q);
            var2 = 0.25F;
            break;
         }
      }

      if (var2 > 0.0F) {
         I48.ai(var1, var2);
      }

      return var1.ao();
   }

   void cq(float var1) {
      ScaleRotTrans var2 = this.getObjectTransform();
      if (this.av == null) {
         this.av = var2;
      }

      Vector3 var3 = Vector3.k(var2.trans, this.av.trans);
      Quaternion var4 = this.av.rot.s();
      var4 = var4.r(var2.rot);
      Vector3 var5 = var4.x();
      this.av = var2;
      this.af.addFirst(new H50(var3, var5, var1));
      float var6 = 0.0F;
      int var7 = 0;

      H50 var9;
      for(Iterator var8 = this.af.iterator(); var8.hasNext(); var6 += var9.q) {
         var9 = (H50)var8.next();
         if (var6 > 0.25F) {
            ++var7;
         }
      }

      for(int var11 = 0; var11 < var7; ++var11) {
         this.af.removeLast();
      }

      ScaleRotTrans var12 = v(this);
      I48 var13 = new I48(be(this));
      Vector3 var10 = bs(this);
      I48.al(var13, var12.rot);
      var13.j = -var13.j;
      var13.h = -var13.h;
      this.setProperty("LinearVelocity", var13.ao());
      this.setProperty("AngularVelocity", var10);
   }

   public static void cp(Npc var0) {
      if (var0.aq != null) {
         Jt38.i(var0.aq);
      }
   }

   public static void cd(Npc var0) {
      if (var0.aq != null) {
         Jt38.o(var0.aq, client.gn, client.gj);
         var0.i.b();
      }
   }

   public E41 bc() {
      E41 var1 = new E41(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      return var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Object GetVarByIndex(int var1) {
      VarBasicType var2 = client.fn.list(var1);
      if (var2 != null) {
         return this.ce(var1, var2);
      } else {
         throw new RuntimeException("NPC variable '" + var1 + "' not defined");
      }
   }

   public boolean br(String var1) {
      int var2 = StringTools.l(var1);
      VarType var3 = client.fn.hashLookup(var2);
      if (var3 == null) {
         VarBitType var4 = client.fl.hashLookup(var2);
         if (var4 == null) {
            return false;
         }

         var3 = var4.baseVar;
      }

      return var3.domain == VarDomainType.NPC;
   }

   private Object ce(Object var1, VarType var2) {
      // $FF: Couldn't be decompiled
   }

   private void ck(Object var1, VarType var2, Object var3) {
      // $FF: Couldn't be decompiled
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetVarBit(int var1, Object var2) throws VarBitOverflowException {
      VarBitType var3 = client.fl.list(var1);
      if (var3 != null) {
         if (var3.baseVar.domain != VarDomainType.NPC) {
            throw new RuntimeException("'" + var1 + "' is not an NPC varbit, it's a " + var3.baseVar.domain.name());
         } else if (!(var2 instanceof Double)) {
            throw new RuntimeException("Passed non-number type as value to SetVarBit when setting NPC client variable with index: '" + var1 + "'.");
         } else {
            this.setVarBitValue(var3, ((Number)var2).intValue());
         }
      } else {
         throw new RuntimeException("NPC varbit '" + var1 + "' not defined");
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Object GetVar(String var1) {
      int var2 = StringTools.l(var1);
      VarType var3 = client.fn.hashLookup(var2);
      if (var3 != null) {
         return this.ce(var1, var3);
      } else {
         VarBitType var4 = client.fl.hashLookup(var2);
         if (var4 != null) {
            if (var4.baseVar.domain != VarDomainType.NPC) {
               throw new RuntimeException("'" + var1 + "' is not an NPC varbit, it's a " + var4.baseVar.domain.name());
            } else {
               return this.getVarBitValue(var4);
            }
         } else {
            throw new RuntimeException("NPC variable '" + var1 + "' not defined");
         }
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String GetName() {
      return this.ai;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Object GetVarBit(int var1) {
      VarBitType var2 = client.fl.list(var1);
      if (var2 != null) {
         if (var2.baseVar.domain != VarDomainType.NPC) {
            throw new RuntimeException("'" + var1 + "' is not an NPC varbit, it's a " + var2.baseVar.domain.name());
         } else {
            return this.getVarBitValue(var2);
         }
      } else {
         throw new RuntimeException("NPC varbit '" + var1 + "' not defined");
      }
   }

   public static void ca(Npc var0) {
      var0.n = true;
      ScheduledMovementComponent.z(var0.i, client.dq);
      if (var0.aq != null) {
         Jt38.al(var0.aq);
         var0.aq = null;
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int getCollisionMask(@ScriptDefaults(defaultBoolean = false) boolean var1) {
      return Jt38.a(this.aq);
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetVar(String var1, Object var2) throws VarBitOverflowException {
      int var3 = StringTools.l(var1);
      VarType var4 = client.fn.hashLookup(var3);
      if (var4 != null) {
         this.ck(var1, var4, var2);
      } else {
         VarBitType var5 = client.fl.hashLookup(var3);
         if (var5 != null) {
            if (var5.baseVar.domain != VarDomainType.NPC) {
               throw new RuntimeException("'" + var1 + "' is not an NPC varbit, it's a " + var5.baseVar.domain.name());
            } else if (!(var2 instanceof Number)) {
               throw new RuntimeException("Passed non-number type as value to SetVar when setting NPC client varbit: '" + var1 + "'.");
            } else {
               this.setVarBitValue(var5, ((Number)var2).intValue());
            }
         } else {
            throw new RuntimeException("NPC variable '" + var1 + "' not defined");
         }
      }
   }

   void cw() {
      ScaleRotTrans var1 = this.getObjectTransform();
      this.av = var1;
      this.af.clear();
      Vector3 var2 = this.aq.g();
      var2 = Vector3.ai(var2, 0.25F / Lq191.d());
      this.af.addFirst(new H50(var2, Vector3.g, 0.25F));
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public void SetVarByIndex(int var1, Object var2) {
      VarBasicType var3 = client.fn.list(var1);
      if (var3 != null) {
         this.ck(var1, var3, var2);
      } else {
         throw new RuntimeException("NPC variable '" + var1 + "' not defined");
      }
   }

   public void bi(XElement var1, Vector3 var2, Quaternion var3) {
      this.k = var1;
      XElement.bq(this.k, this, new Q32(this, var2, var3));
   }

   public Npc(Bb4 var1) {
      super(var1, client.fn);
      ep(this, new NpcComponent(this));
      ep(this, new PhysicsComponent(new J44(this), (RigidBody)null, (RigidBody)null));
      this.i = ScheduledMovementComponent.g(super.bg, new B35(this));
      ep(this, this.i);
      this.ai = "#PLACEHOLDER#";
   }
}
