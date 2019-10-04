/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.File;
import java.util.Collection;

public class Iu445 {
    public static String g(File file) {
        if (!file.isDirectory()) {
            String string = file.getName();
            int n = string.lastIndexOf(46);
            return n >= 0 ? string.substring(n + 1) : "";
        }
        return null;
    }

    public static void d(File file, Collection collection, String ... arrstring) {
        block2 : {
            block3 : {
                File[] arrfile;
                if (!file.isDirectory()) break block3;
                for (File file2 : arrfile = file.listFiles()) {
                    Iu445.d(file2, collection, arrstring);
                }
                break block2;
            }
            if (!file.isFile()) break block2;
            String string = file.getPath();
            for (String string2 : arrstring) {
                if (string.length() <= string2.length() || string.charAt(string.length() - string2.length() - 1) != '.' || !string.endsWith(string2)) continue;
                collection.add(file);
                break;
            }
        }
    }
}

