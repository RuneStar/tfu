// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.script.resource.proto;

import tfu.Gg3;
import tfu.Hs30;
import tfu.If31;
import java.io.File;
import tfu.Ib29;

public class FileProtoResourceDataProvider implements Ib29
{
    final File baseDir;
    
    public byte[] getData(final String str) throws Hs30 {
        final byte[] q = If31.q(new File(this.baseDir, str + ".proto"));
        if (q == null) {
            throw new Hs30(String.format("File \"%s\" not found", str));
        }
        final Gg3 gg3 = new Gg3(Gg3.av(str) + 2 + q.length);
        gg3.ap(str);
        Gg3.i(gg3, 0);
        Gg3.aa(gg3, q, 0, q.length);
        return gg3.r;
    }
    
    public FileProtoResourceDataProvider(final File baseDir) {
        this.baseDir = baseDir;
    }
    
    @Override
    public String getIdentifier() {
        return null;
    }
    
    @Override
    public String getResourceAddress(final String s) {
        return null;
    }
}
