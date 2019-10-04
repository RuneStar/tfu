// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.script.resource.script;

import tfu.Id102;
import tfu.Hp62;
import tfu.Mj383;
import tfu.Hi86;
import tfu.Ia63;

final class StringScriptChunk$1 implements Ia63
{
    @Override
    public boolean resourceNeedsRefCounting() {
        return false;
    }
    
    public ScriptChunk constructResource(final byte[] array, final String s, final Hi86 hi86) {
        return new StringScriptChunk(s, Mj383.q(array));
    }
}
