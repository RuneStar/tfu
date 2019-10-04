/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;

public final class Is139 {
    private static final boolean g = true;
    private final File d;
    private long e;
    private final long j;
    private RandomAccessFile q;

    public static final int h(Is139 is139, byte[] arrby, int n, int n2) throws IOException {
        int n3 = is139.q.read(arrby, n, n2);
        if (n3 > 0) {
            is139.e += (long)n3;
        }
        return n3;
    }

    public static final File g(Is139 is139) {
        return is139.d;
    }

    public static final void d(Is139 is139, long l) throws IOException {
        is139.q.seek(l);
        is139.e = l;
    }

    public static final long e(Is139 is139) throws IOException {
        return is139.q.length();
    }

    public static final void s(Is139 is139, long l) throws IOException {
        if (l > is139.j - is139.e) {
            l = is139.j - is139.e;
        }
        is139.q.setLength(l);
    }

    public Is139(File file, String string, long l) throws IOException {
        if (l == -1L) {
            l = Long.MAX_VALUE;
        }
        if (file.length() > l) {
            System.out.println("Deleting: " + file + " as length exceeds maxlen - filelen:" + file.length() + " maxlen:" + l);
            file.delete();
        }
        this.q = new RandomAccessFile(file, string);
        this.d = file;
        this.j = l;
        this.e = 0L;
        int n = this.q.read();
        if (n != -1 && !string.equals("r")) {
            this.q.seek(0L);
            this.q.write(n);
        }
        this.q.seek(0L);
    }

    protected void finalize() throws Throwable {
        if (this.q != null) {
            System.out.println("Warning! fileondisk " + this.d + " not closed correctly using close(). Auto-closing instead. ");
            Is139.j(this);
        }
    }

    public static void b(Is139 is139) throws IOException {
        is139.q.getFD().sync();
    }

    public static final void j(Is139 is139) throws IOException {
        if (is139.q != null) {
            is139.q.close();
            is139.q = null;
        }
    }

    public final void q(byte[] arrby, int n, int n2) throws IOException {
        if ((long)n2 + this.e > this.j) {
            this.q.seek(this.j);
            this.q.write(1);
            throw new EOFException();
        }
        this.q.write(arrby, n, n2);
        this.e += (long)n2;
    }
}

