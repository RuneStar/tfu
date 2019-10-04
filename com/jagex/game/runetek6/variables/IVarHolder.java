/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.variables;

import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import tfu.Be2;
import tfu.Bs1;

public interface IVarHolder {
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object GetVar(String var1);

    @ScriptEntryPoint
    @Be2
    @Bs1
    public void SetVar(String var1, Object var2) throws VarBitOverflowException;
}

