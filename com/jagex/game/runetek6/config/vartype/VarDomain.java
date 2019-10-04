/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.vartype;

import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;

public interface VarDomain {
    public void setVarValueInt(VarType var1, int var2);

    public int getVarValueInt(VarType var1);

    public Object getVarValue(VarType var1);

    public void setVarValue(VarType var1, Object var2);

    public int getVarBitValue(VarBitType var1);

    public void setVarBitValue(VarBitType var1, int var2) throws VarBitOverflowException;

    public long getVarValueLong(VarType var1);

    public void setVarValueLong(VarType var1, long var2);

    public boolean canModifyVarValue(VarType var1);
}

