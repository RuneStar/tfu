package rs2.client.worldelement;

import com.jagex.game.runetek6.config.vartype.VarDomain;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import com.jagex.game.runetek6.gameentity.G55;
import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.variables.G53;
import com.jagex.maths.E41;
import com.jagex.maths.Vector3;
import rs2.client.client;
import tfu.An52;
import tfu.Bb4;
import tfu.Kh56;
import tfu.Ma57;
import tfu.Mn54;

public abstract class L51 extends GameEntity implements An52, G53, VarDomain {
   public int bh;
   public int bj;
   public int bk;
   public int bl = 1;
   public boolean bp = false;
   public int bw = -1000;
   public boolean bx = false;
   public final Mn54 by;

   public abstract E41 bc();

   public Vector3 e() {
      E41 var1 = this.bc();
      return Vector3.g(var1.j, var1.e, var1.h);
   }

   public int bz() {
      return this.bl;
   }

   public boolean canModifyVarValue(VarType var1) {
      return true;
   }

   public int getVarValueInt(VarType var1) {
      return this.by.d(var1.id);
   }

   public long getVarValueLong(VarType var1) {
      return this.by.j(var1.id);
   }

   public Object getVarValue(VarType var1) {
      return this.by.h(var1.id);
   }

   public int getVarBitValue(VarBitType var1) {
      return var1.getVarbitValue(this.getVarValueInt(var1.baseVar));
   }

   public void setVarValueInt(VarType var1, int var2) {
      int var3 = this.by.d(var1.id);
      if (var3 != var2) {
         this.by.q(var1.id, var2);
         Integer var4 = G55.s(super.ce, var1.debugNameHash32);
         if (var4 != null) {
            this.triggerEvent(var4, var2);
         }
      }

   }

   public void setVarValueLong(VarType var1, long var2) {
      long var4 = (long)this.by.d(var1.id);
      if (var4 != var2) {
         this.by.e(var1.id, var2);
         Integer var6 = G55.s(super.ce, var1.debugNameHash32);
         if (var6 != null) {
            this.triggerEvent(var6, var2);
         }
      }

   }

   public static void ez(L51 var0, int var1) {
      var0.bl = var1;
   }

   public Vector3 j() {
      E41 var1 = this.bc();
      return Vector3.g(var1.g, var1.d, var1.q);
   }

   public void setVarBitValue(VarBitType var1, int var2) throws VarBitOverflowException {
      this.setVarValueInt(var1.baseVar, var1.setVarbitValue(this.getVarValueInt(var1.baseVar), var2));
   }

   public void setVarValue(VarType var1, Object var2) {
      Integer var3 = this.by.d(var1.id);
      if (!Kh56.g(var3, var2)) {
         this.by.s(var1.id, var2);
         Integer var4 = G55.s(super.ce, var1.debugNameHash32);
         if (var4 != null) {
            this.triggerEvent(var4, var2);
         }
      }

   }

   public L51(Bb4 var1, VarTypeList var2) {
      super(var1, client.cj);
      ea(this, this);
      this.by = new Ma57(var2);
      this.setProperty("targetingVelocity", 1.0F);
      this.setProperty("targetingAcceleration", 0.2F);
      this.setProperty("DesiredVelocity", new Vector3(0.0F, 0.0F, 0.0F));
      this.setProperty("TargetCoord", (Object)null);
   }
}
