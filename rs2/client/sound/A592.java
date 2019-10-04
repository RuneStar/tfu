// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import java.io.File;
import java.io.FileFilter;

final class A592 implements FileFilter
{
    @Override
    public boolean accept(final File file) {
        return file.getPath().toLowerCase().endsWith(".fsb");
    }
}
