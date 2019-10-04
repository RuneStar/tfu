// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.variables;

import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;

public interface IVarHolder
{
    @ScriptEntryPoint
    @Be2
    @Bs1
    Object GetVar(final String p0);
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    void SetVar(final String p0, final Object p1) throws VarBitOverflowException;
}
