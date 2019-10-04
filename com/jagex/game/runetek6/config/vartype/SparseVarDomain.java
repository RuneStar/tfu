/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.config.vartype;

import com.jagex.game.runetek6.config.vartype.VarDomain;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.VarTypeList;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import tfu.Kf58;
import tfu.Ma57;
import tfu.Mn54;

public class SparseVarDomain
implements VarDomain {
    public final Mn54 varValues;

    @Override
    public Object getVarValue(VarType varType) {
        return this.varValues.h(varType.id);
    }

    @Override
    public int getVarValueInt(VarType varType) {
        return this.varValues.d(varType.id);
    }

    @Override
    public void setVarValueInt(VarType varType, int n) {
        this.varValues.q(varType.id, n);
    }

    @Override
    public long getVarValueLong(VarType varType) {
        return this.varValues.j(varType.id);
    }

    @Override
    public void setVarValueLong(VarType varType, long l) {
        this.varValues.e(varType.id, l);
    }

    @Override
    public void setVarValue(VarType varType, Object object) {
        this.varValues.s(varType.id, object);
    }

    @Override
    public int getVarBitValue(VarBitType varBitType) {
        return varBitType.getVarbitValue(this.getVarValueInt(varBitType.baseVar));
    }

    @Override
    public void setVarBitValue(VarBitType varBitType, int n) throws VarBitOverflowException {
        this.setVarValueInt(varBitType.baseVar, varBitType.setVarbitValue(this.getVarValueInt(varBitType.baseVar), n));
    }

    @Override
    public boolean canModifyVarValue(VarType varType) {
        return true;
    }

    public SparseVarDomain(VarTypeList varTypeList) {
        this.varValues = new Ma57(varTypeList);
    }
}

