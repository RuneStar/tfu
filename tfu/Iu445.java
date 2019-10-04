// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.Collection;
import java.io.File;

public class Iu445
{
    public static String g(final File file) {
        if (!file.isDirectory()) {
            final String name = file.getName();
            final int lastIndex = name.lastIndexOf(46);
            return (lastIndex >= 0) ? name.substring(lastIndex + 1) : "";
        }
        return null;
    }
    
    public static void d(final File file, final Collection collection, final String... array) {
        if (file.isDirectory()) {
            final File[] listFiles = file.listFiles();
            for (int length = listFiles.length, i = 0; i < length; ++i) {
                d(listFiles[i], collection, array);
            }
        }
        else if (file.isFile()) {
            final String path = file.getPath();
            for (final String suffix : array) {
                if (path.length() > suffix.length() && path.charAt(path.length() - suffix.length() - 1) == '.' && path.endsWith(suffix)) {
                    collection.add(file);
                    break;
                }
            }
        }
    }
}
