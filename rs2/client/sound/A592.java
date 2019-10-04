/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import java.io.File;
import java.io.FileFilter;

final class A592
implements FileFilter {
    A592() {
    }

    @Override
    public boolean accept(File file) {
        return file.getPath().toLowerCase().endsWith(".fsb");
    }
}

