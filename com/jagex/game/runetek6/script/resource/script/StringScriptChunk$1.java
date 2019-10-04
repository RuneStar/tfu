/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.script.resource.script;

import com.jagex.game.runetek6.script.resource.script.ScriptChunk;
import com.jagex.game.runetek6.script.resource.script.StringScriptChunk;
import tfu.Hi86;
import tfu.Hp62;
import tfu.Ia63;
import tfu.Id102;
import tfu.Mj383;

final class StringScriptChunk$1
implements Ia63 {
    @Override
    public boolean resourceNeedsRefCounting() {
        return false;
    }

    public ScriptChunk constructResource(byte[] arrby, String string, Hi86 hi86) {
        String string2 = Mj383.q(arrby);
        return new StringScriptChunk(string, string2);
    }

    StringScriptChunk$1() {
    }
}

