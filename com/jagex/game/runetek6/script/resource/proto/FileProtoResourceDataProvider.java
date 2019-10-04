/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.script.resource.proto;

import java.io.File;
import tfu.Gg3;
import tfu.Hs30;
import tfu.Ib29;
import tfu.If31;

public class FileProtoResourceDataProvider
implements Ib29 {
    final File baseDir;

    public byte[] getData(String string) throws Hs30 {
        byte[] arrby = If31.q(new File(this.baseDir, string + ".proto"));
        if (arrby == null) {
            throw new Hs30(String.format("File \"%s\" not found", string));
        }
        Gg3 gg3 = new Gg3(Gg3.av(string) + 2 + arrby.length);
        gg3.ap(string);
        Gg3.i(gg3, 0);
        Gg3.aa(gg3, arrby, 0, arrby.length);
        return gg3.r;
    }

    public FileProtoResourceDataProvider(File file) {
        this.baseDir = file;
    }

    @Override
    public String getIdentifier() {
        return null;
    }

    @Override
    public String getResourceAddress(String string) {
        return null;
    }
}

