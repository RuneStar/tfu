/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.script.resource.script;

import com.jagex.js5.js5;
import tfu.Gg3;
import tfu.Hs30;
import tfu.Ib29;

public class JS5ScriptResourceDataProvider
implements Ib29 {
    final String extension;
    final js5 scriptJS5;

    public JS5ScriptResourceDataProvider(js5 js52, String string) {
        this.scriptJS5 = js52;
        this.extension = string;
    }

    public byte[] getData(String string) throws Hs30 {
        byte[] arrby = js5.a(this.scriptJS5, this.extension, string + this.extension);
        if (arrby == null) {
            throw new Hs30(String.format("File \"%s\" not found", string));
        }
        Gg3 gg3 = new Gg3(arrby);
        gg3.bh();
        byte[] arrby2 = new byte[arrby.length - gg3.v];
        System.arraycopy(arrby, gg3.v, arrby2, 0, arrby2.length);
        return arrby2;
    }

    @Override
    public String getResourceAddress(String string) {
        return null;
    }

    @Override
    public String getIdentifier() {
        return null;
    }
}

