// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.vartype;

import tfu.Kf58;
import tfu.Ma57;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import tfu.Mn54;

public class SparseVarDomain implements VarDomain
{
    public final Mn54 varValues;
    
    @Override
    public Object getVarValue(final VarType varType) {
        return this.varValues.h(varType.id);
    }
    
    @Override
    public int getVarValueInt(final VarType varType) {
        return this.varValues.d(varType.id);
    }
    
    @Override
    public void setVarValueInt(final VarType varType, final int n) {
        this.varValues.q(varType.id, n);
    }
    
    @Override
    public long getVarValueLong(final VarType varType) {
        return this.varValues.j(varType.id);
    }
    
    @Override
    public void setVarValueLong(final VarType varType, final long n) {
        this.varValues.e(varType.id, n);
    }
    
    @Override
    public void setVarValue(final VarType varType, final Object o) {
        this.varValues.s(varType.id, o);
    }
    
    @Override
    public int getVarBitValue(final VarBitType varBitType) {
        return varBitType.getVarbitValue(this.getVarValueInt(varBitType.baseVar));
    }
    
    @Override
    public void setVarBitValue(final VarBitType varBitType, final int n) throws VarBitOverflowException {
        this.setVarValueInt(varBitType.baseVar, varBitType.setVarbitValue(this.getVarValueInt(varBitType.baseVar), n));
    }
    
    @Override
    public boolean canModifyVarValue(final VarType varType) {
        return true;
    }
    
    public SparseVarDomain(final VarTypeList list) {
        this.varValues = new Ma57(list);
    }
}
