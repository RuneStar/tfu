// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.config.vartype;

import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;

public interface VarDomain
{
    void setVarValueInt(final VarType p0, final int p1);
    
    int getVarValueInt(final VarType p0);
    
    Object getVarValue(final VarType p0);
    
    void setVarValue(final VarType p0, final Object p1);
    
    int getVarBitValue(final VarBitType p0);
    
    void setVarBitValue(final VarBitType p0, final int p1) throws VarBitOverflowException;
    
    long getVarValueLong(final VarType p0);
    
    void setVarValueLong(final VarType p0, final long p1);
    
    boolean canModifyVarValue(final VarType p0);
}
