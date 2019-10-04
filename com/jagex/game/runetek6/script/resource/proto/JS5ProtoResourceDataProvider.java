// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.script.resource.proto;

import tfu.Hs30;
import com.jagex.js5.js5;
import tfu.Ib29;

public class JS5ProtoResourceDataProvider implements Ib29
{
    public static final boolean keepLuaAround = true;
    final js5 protoJS5;
    
    public JS5ProtoResourceDataProvider(final js5 protoJS5) {
        this.protoJS5 = protoJS5;
    }
    
    @Override
    public String getIdentifier() {
        return null;
    }
    
    public byte[] getData(final String str) throws Hs30 {
        final byte[] a = js5.a(this.protoJS5, ".proto", str + ".proto");
        if (a == null) {
            throw new Hs30(String.format("File \"%s\" not found", str));
        }
        return a;
    }
    
    @Override
    public String getResourceAddress(final String s) {
        return null;
    }
}
