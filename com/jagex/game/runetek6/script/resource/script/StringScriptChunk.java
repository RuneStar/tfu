// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.script.resource.script;

import tfu.Ia63;

public class StringScriptChunk extends ScriptChunk
{
    public static final Ia63 CHUNK_CONSTRUCTOR;
    public final String chunk;
    
    static {
        CHUNK_CONSTRUCTOR = new StringScriptChunk$1();
    }
    
    public StringScriptChunk(final String s, final String chunk) {
        super(s);
        this.chunk = chunk;
    }
    
    @Override
    public void onAllRefsReleased() {
    }
}
