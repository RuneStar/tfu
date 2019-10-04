/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class If31 {
    public static byte[] d(File file, int n) {
        try {
            byte[] arrby = new byte[n];
            If31.g(file, arrby, n);
            return arrby;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public static void g(File file, byte[] arrby, int n) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        try {
            dataInputStream.readFully(arrby, 0, n);
        }
        catch (EOFException eOFException) {
            // empty catch block
        }
        dataInputStream.close();
    }

    public static byte[] q(File file) {
        return If31.d(file, (int)file.length());
    }
}

