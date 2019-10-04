// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.event;

import tfu.Lv148;
import tfu.Lm295;

public enum ScriptEventHandler$Zones
{
    TriggerScriptEvent("TriggerScriptEvent", 0);
    
    private Lm295 zone;
    
    public void stop() {
        if (this.zone != null) {
            this.zone.d();
        }
    }
    
    public void start() {
        if (this.zone == null) {
            this.zone = Lv148.q(this.name());
        }
        if (this.zone != null) {
            this.zone.g();
        }
    }
    
    private ScriptEventHandler$Zones(final String name, final int ordinal) {
    }
}
