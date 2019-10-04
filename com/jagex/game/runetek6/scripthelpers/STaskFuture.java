// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.scripthelpers;

import tfu.Be2;
import tfu.Bs1;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import tfu.Bn279;

public class STaskFuture
{
    public final Bn279 inner;
    
    public STaskFuture(final Bn279 inner) {
        this.inner = inner;
    }
    
    @ScriptEntryPoint
    @Bs1
    @Be2
    public void CancelIfNotUsedYet() {
        Bn279.j(this.inner);
    }
}
