// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.gameentity;

import com.jagex.maths.Vector3;
import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptEntryClass;
import tfu.Fn87;

@ScriptEntryClass("PickResult")
public class ScriptablePickResult extends Fn87
{
    @ScriptEntryPoint
    @Be2
    @Bs1
    public float getDistance() {
        return super.q;
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Vector3 getPickPoint() {
        return super.d;
    }
    
    public ScriptablePickResult(final Fn87 fn87) {
        super(fn87);
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public Object getPicked() {
        return super.g;
    }
}
