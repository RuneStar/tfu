/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.script.resource.script;

import java.io.File;
import tfu.Hs30;
import tfu.Ib29;
import tfu.If31;

public class FileScriptResourceDataProvider
implements Ib29 {
    final File baseDir;
    final String extension;

    public byte[] getData(String string) throws Hs30 {
        byte[] arrby = If31.q(new File(this.baseDir, string + this.extension));
        if (arrby == null) {
            throw new Hs30(String.format("File \"%s\" not found", string));
        }
        return arrby;
    }

    @Override
    public String getResourceAddress(String string) {
        return null;
    }

    public FileScriptResourceDataProvider(File file, String string) {
        this.baseDir = file;
        this.extension = string;
    }

    @Override
    public String getIdentifier() {
        return null;
    }
}

