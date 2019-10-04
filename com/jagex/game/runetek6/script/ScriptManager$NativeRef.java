// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.script;

class ScriptManager$NativeRef
{
    private final long ref;
    final /* synthetic */ ScriptManager this$0;
    
    public long getRef() {
        if (this.ref == 0L) {
            throw new IllegalStateException("Native reference was invalid.");
        }
        return this.ref;
    }
    
    ScriptManager$NativeRef(final ScriptManager this$0, final long ref) {
        this.this$0 = this$0;
        this.ref = ref;
    }
}
