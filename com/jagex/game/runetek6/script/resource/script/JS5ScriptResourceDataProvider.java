// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.script.resource.script;

import tfu.Gg3;
import tfu.Hs30;
import com.jagex.js5.js5;
import tfu.Ib29;

public class JS5ScriptResourceDataProvider implements Ib29
{
    final String extension;
    final js5 scriptJS5;
    
    public JS5ScriptResourceDataProvider(final js5 scriptJS5, final String extension) {
        this.scriptJS5 = scriptJS5;
        this.extension = extension;
    }
    
    public byte[] getData(final String str) throws Hs30 {
        final byte[] a = js5.a(this.scriptJS5, this.extension, str + this.extension);
        if (a == null) {
            throw new Hs30(String.format("File \"%s\" not found", str));
        }
        final Gg3 gg3 = new Gg3(a);
        gg3.bh();
        final byte[] array = new byte[a.length - gg3.v];
        System.arraycopy(a, gg3.v, array, 0, array.length);
        return array;
    }
    
    @Override
    public String getResourceAddress(final String s) {
        return null;
    }
    
    @Override
    public String getIdentifier() {
        return null;
    }
}
