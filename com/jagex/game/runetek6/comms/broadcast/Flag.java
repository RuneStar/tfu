/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.comms.broadcast;

import com.jagex.game.runetek6.script.ScriptEntryClass;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import tfu.Be2;
import tfu.Bs1;

@ScriptEntryClass(value="Flag")
public class Flag {
    private boolean flag;

    public Flag(boolean bl) {
        this.flag = bl;
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

