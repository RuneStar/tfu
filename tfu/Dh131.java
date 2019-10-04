/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Hashtable;

public class Dh131 {
    public static boolean d = false;
    private static final boolean g = false;
    private static Hashtable j = new Hashtable(16);
    private static File q;

    public static void g(File file) {
        q = file;
        if (!q.exists()) {
            throw new RuntimeException("");
        }
        d = true;
    }

    public static File d(String string) {
        if (!d) {
            throw new RuntimeException("");
        }
        File file = (File)j.get(string);
        if (file != null) {
            return file;
        }
        File file2 = new File(q, string);
        RandomAccessFile randomAccessFile = null;
        try {
            File file3 = new File(file2.getParent());
            if (!file3.exists()) {
                throw new RuntimeException("");
            }
            randomAccessFile = new RandomAccessFile(file2, "rw");
            int n = randomAccessFile.read();
            randomAccessFile.seek(0L);
            randomAccessFile.write(n);
            randomAccessFile.seek(0L);
            randomAccessFile.close();
            j.put(string, file2);
            return file2;
        }
        catch (Exception exception) {
            try {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                    randomAccessFile = null;
                }
            }
            catch (Exception exception2) {
                // empty catch block
            }
            throw new RuntimeException();
        }
    }
}

