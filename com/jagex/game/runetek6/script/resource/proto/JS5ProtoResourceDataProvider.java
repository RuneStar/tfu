/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.script.resource.proto;

import com.jagex.js5.js5;
import tfu.Hs30;
import tfu.Ib29;

public class JS5ProtoResourceDataProvider
implements Ib29 {
    public static final boolean keepLuaAround = true;
    final js5 protoJS5;

    public JS5ProtoResourceDataProvider(js5 js52) {
        this.protoJS5 = js52;
    }

    @Override
    public String getIdentifier() {
        return null;
    }

    public byte[] getData(String string) throws Hs30 {
        byte[] arrby = js5.a(this.protoJS5, ".proto", string + ".proto");
        if (arrby == null) {
            throw new Hs30(String.format("File \"%s\" not found", string));
        }
        return arrby;
    }

    @Override
    public String getResourceAddress(String string) {
        return null;
    }
}

