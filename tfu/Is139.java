// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.File;

public final class Is139
{
    private static final boolean g = true;
    private final File d;
    private long e;
    private final long j;
    private RandomAccessFile q;
    
    public static final int h(final Is139 is139, final byte[] b, final int off, final int len) throws IOException {
        final int read = is139.q.read(b, off, len);
        if (read > 0) {
            is139.e += read;
        }
        return read;
    }
    
    public static final File g(final Is139 is139) {
        return is139.d;
    }
    
    public static final void d(final Is139 is139, final long n) throws IOException {
        is139.q.seek(n);
        is139.e = n;
    }
    
    public static final long e(final Is139 is139) throws IOException {
        return is139.q.length();
    }
    
    public static final void s(final Is139 is139, long length) throws IOException {
        if (length > is139.j - is139.e) {
            length = is139.j - is139.e;
        }
        is139.q.setLength(length);
    }
    
    public Is139(final File d, final String mode, long n) throws IOException {
        if (n == -1L) {
            n = Long.MAX_VALUE;
        }
        if (d.length() > n) {
            System.out.println("Deleting: " + d + " as length exceeds maxlen - filelen:" + d.length() + " maxlen:" + n);
            d.delete();
        }
        this.q = new RandomAccessFile(d, mode);
        this.d = d;
        this.j = n;
        this.e = 0L;
        final int read = this.q.read();
        if (read != -1 && !mode.equals("r")) {
            this.q.seek(0L);
            this.q.write(read);
        }
        this.q.seek(0L);
    }
    
    @Override
    protected void finalize() throws Throwable {
        if (this.q != null) {
            System.out.println("Warning! fileondisk " + this.d + " not closed correctly using close(). Auto-closing instead. ");
            j(this);
        }
    }
    
    public static void b(final Is139 is139) throws IOException {
        is139.q.getFD().sync();
    }
    
    public static final void j(final Is139 is139) throws IOException {
        if (is139.q != null) {
            is139.q.close();
            is139.q = null;
        }
    }
    
    public final void q(final byte[] b, final int off, final int len) throws IOException {
        if (len + this.e > this.j) {
            this.q.seek(this.j);
            this.q.write(1);
            throw new EOFException();
        }
        this.q.write(b, off, len);
        this.e += len;
    }
}
