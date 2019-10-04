// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.io.RandomAccessFile;
import java.io.File;
import java.util.Hashtable;

public class Dh131
{
    public static boolean d;
    private static final boolean g = false;
    private static Hashtable j;
    private static File q;
    
    static {
        Dh131.d = false;
        Dh131.j = new Hashtable(16);
    }
    
    public static void g(final File q) {
        Dh131.q = q;
        if (!Dh131.q.exists()) {
            throw new RuntimeException("");
        }
        Dh131.d = true;
    }
    
    public static File d(final String key) {
        if (!Dh131.d) {
            throw new RuntimeException("");
        }
        final File file = Dh131.j.get(key);
        if (file != null) {
            return file;
        }
        final File file2 = new File(Dh131.q, key);
        RandomAccessFile randomAccessFile = null;
        try {
            if (!new File(file2.getParent()).exists()) {
                throw new RuntimeException("");
            }
            randomAccessFile = new RandomAccessFile(file2, "rw");
            final int read = randomAccessFile.read();
            randomAccessFile.seek(0L);
            randomAccessFile.write(read);
            randomAccessFile.seek(0L);
            randomAccessFile.close();
            Dh131.j.put(key, file2);
            return file2;
        }
        catch (Exception ex) {
            try {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            }
            catch (Exception ex2) {}
            throw new RuntimeException();
        }
    }
}
