package com.jagex.game.runetek6.config.vartype;

import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;

public interface VarDomain {
   void setVarValueInt(VarType var1, int var2);

   int getVarValueInt(VarType var1);

   Object getVarValue(VarType var1);

   void setVarValue(VarType var1, Object var2);

   int getVarBitValue(VarBitType var1);

   void setVarBitValue(VarBitType var1, int var2) throws VarBitOverflowException;

   long getVarValueLong(VarType var1);

   void setVarValueLong(VarType var1, long var2);

   boolean canModifyVarValue(VarType var1);
}
