/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.script;

import com.jagex.game.runetek6.script.ScriptManager;

class ScriptManager$NativeRef {
    private final long ref;
    final /* synthetic */ ScriptManager this$0;

    public long getRef() {
        if (this.ref == 0L) {
            throw new IllegalStateException("Native reference was invalid.");
        }
        return this.ref;
    }

    ScriptManager$NativeRef(ScriptManager scriptManager, long l) {
        this.this$0 = scriptManager;
        this.ref = l;
    }
}

