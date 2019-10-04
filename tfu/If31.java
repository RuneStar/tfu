// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.io.EOFException;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

public final class If31
{
    public static byte[] d(final File file, final int n) {
        try {
            final byte[] array = new byte[n];
            g(file, array, n);
            return array;
        }
        catch (IOException ex) {
            return null;
        }
    }
    
    public static void g(final File file, final byte[] b, final int len) throws IOException {
        final DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        try {
            dataInputStream.readFully(b, 0, len);
        }
        catch (EOFException ex) {}
        dataInputStream.close();
    }
    
    public static byte[] q(final File file) {
        return d(file, (int)file.length());
    }
}
