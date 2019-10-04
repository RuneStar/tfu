/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.File;
import java.util.HashMap;

class Io438 {
    private static HashMap d = new HashMap();
    private static final int g = 60000;

    public static synchronized boolean g(File file) {
        File file2;
        do {
            file2 = file;
            if ((file = file.getParentFile()) != null) continue;
            return false;
        } while (!file.getName().equals("store"));
        Long l = (Long)d.get(file2);
        long l2 = System.currentTimeMillis();
        if (l == null || l + 60000L < l2) {
            d.put(file2, l2);
            return true;
        }
        return false;
    }

    Io438() {
    }
}

