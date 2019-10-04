// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.io.File;
import java.util.HashMap;

class Io438
{
    private static HashMap d;
    private static final int g = 60000;
    
    public static synchronized boolean g(File parentFile) {
        while (true) {
            final File file = parentFile;
            parentFile = parentFile.getParentFile();
            if (parentFile == null) {
                return false;
            }
            if (!parentFile.getName().equals("store")) {
                continue;
            }
            final Long n = Io438.d.get(file);
            final long currentTimeMillis = System.currentTimeMillis();
            if (n == null || n + 60000L < currentTimeMillis) {
                Io438.d.put(file, currentTimeMillis);
                return true;
            }
            return false;
        }
    }
    
    static {
        Io438.d = new HashMap();
    }
}
