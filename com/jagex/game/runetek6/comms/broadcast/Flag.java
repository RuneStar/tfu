// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.comms.broadcast;

import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptEntryClass;

@ScriptEntryClass("Flag")
public class Flag
{
    private boolean flag;
    
    public Flag(final boolean flag) {
        this.flag = flag;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void Set() {
        this.flag = true;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public void Clear() {
        this.flag = false;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public boolean Get() {
        return this.flag;
    }
}
