// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.script.resource.script;

import tfu.Hs30;
import tfu.If31;
import java.io.File;
import tfu.Ib29;

public class FileScriptResourceDataProvider implements Ib29
{
    final File baseDir;
    final String extension;
    
    public byte[] getData(final String str) throws Hs30 {
        final byte[] q = If31.q(new File(this.baseDir, str + this.extension));
        if (q == null) {
            throw new Hs30(String.format("File \"%s\" not found", str));
        }
        return q;
    }
    
    @Override
    public String getResourceAddress(final String s) {
        return null;
    }
    
    public FileScriptResourceDataProvider(final File baseDir, final String extension) {
        this.baseDir = baseDir;
        this.extension = extension;
    }
    
    @Override
    public String getIdentifier() {
        return null;
    }
}
