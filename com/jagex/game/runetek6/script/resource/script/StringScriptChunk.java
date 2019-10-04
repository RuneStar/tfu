/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.script.resource.script;

import com.jagex.game.runetek6.script.resource.script.ScriptChunk;
import com.jagex.game.runetek6.script.resource.script.StringScriptChunk$1;
import tfu.Ia63;

public class StringScriptChunk
extends ScriptChunk {
    public static final Ia63 CHUNK_CONSTRUCTOR = new StringScriptChunk$1();
    public final String chunk;

    public StringScriptChunk(String string, String string2) {
        super(string);
        this.chunk = string2;
    }

    @Override
    public void onAllRefsReleased() {
    }
}

