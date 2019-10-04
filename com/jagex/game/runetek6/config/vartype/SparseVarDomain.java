package com.jagex.game.runetek6.config.vartype;

import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import tfu.Ma57;
import tfu.Mn54;

public class SparseVarDomain implements VarDomain {
   public final Mn54 varValues;

   public Object getVarValue(VarType var1) {
      return this.varValues.h(var1.id);
   }

   public int getVarValueInt(VarType var1) {
      return this.varValues.d(var1.id);
   }

   public void setVarValueInt(VarType var1, int var2) {
      this.varValues.q(var1.id, var2);
   }

   public long getVarValueLong(VarType var1) {
      return this.varValues.j(var1.id);
   }

   public void setVarValueLong(VarType var1, long var2) {
      this.varValues.e(var1.id, var2);
   }

   public void setVarValue(VarType var1, Object var2) {
      this.varValues.s(var1.id, var2);
   }

   public int getVarBitValue(VarBitType var1) {
      return var1.getVarbitValue(this.getVarValueInt(var1.baseVar));
   }

   public void setVarBitValue(VarBitType var1, int var2) throws VarBitOverflowException {
      this.setVarValueInt(var1.baseVar, var1.setVarbitValue(this.getVarValueInt(var1.baseVar), var2));
   }

   public boolean canModifyVarValue(VarType var1) {
      return true;
   }

   public SparseVarDomain(VarTypeList var1) {
      this.varValues = new Ma57(var1);
   }
}
